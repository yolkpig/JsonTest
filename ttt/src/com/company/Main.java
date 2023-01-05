package com.company;

import java.io.*;

public class Main {
    /**
     * 读取文件的内容
     * 读取指定文件的内容
     * @param path 为要读取文件的绝对路径
     * @return 以行读取文件后的内容。
     * @since  1.0
     */
    public static final String getFileContent(String path)
    {
        String filecontent = "";
        try {


            File file = new File(path);
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis,"utf-8"),5*1024*1024);// 用5M的缓冲读取文本文件

            String line = "";
            while((line = reader.readLine()) != null){
                filecontent += line;
            }

            reader.close(); //关闭BufferedReader对象
            fis.close(); //关闭文件

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return filecontent;
    }

    private void parseJSONWithJSONObject(String JsonData) {
        try
        {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i=0; i < jsonArray.length(); i++)    {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObect.getString("version");

                System.out.println("id" + id + ";name" + name + ";version" + version);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    public static void main(String[] args) throws Exception{
        String path = "D:/study/idea_projects/test1/获取单个设备的信息.txt";
        String jsonData = Main.getFileContent(path);
        System.out.println(jsonData);
    }
}
