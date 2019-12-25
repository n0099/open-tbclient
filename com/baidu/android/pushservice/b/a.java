package com.baidu.android.pushservice.b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
/* loaded from: classes5.dex */
public class a {
    public static String a() {
        return "QM/LurxEwvmX7RXA7cj5A6YOE9UNth30QE0T/8ZIdzn+9n7bHEY83yXrh+PjawH+NvooDz6aiM/AHshDo/AvNNyF5eOIihFbRNb4SSf56B6CFneI7NUf9VlyZVKcyfwfJbxO8YS4KG8y891gB5xNw+La7Ib4auEcw5yQdePhK1lvCJdWCbMJUUelU9uEihUy5Pjdt5apgOkU0+TrgJtJ3pr4JJdzrbEJGfruCK1tcACGqKK5KnPI50uXEGc3F0cXPMed6Y3x+9cj9p9/G8nMMkklQUJHTYlLd2Kt470Ipf68c7hlVZ6nESJznJcAjM6DreiD+c/MMXV3mMAEqM9EBh0EPk8ymMj1Ej+1+HfHLgHEz0mIP1y/GGooVglxvrbfLFuHAmKXcSThHYhjv+kVmMZQ71Iyj6Pkdq6LFDuSEFU57tCkBBBRcn5Lol62xz3y15o9/xoSp8vvfyi92YvXRHSdrAC7lTUhUqe9dXSUMO7HiO+gdBwYf9EDiTPom2lcwuEfjyThWKDTEPTF2cishBSYgtRQuXRHkc4wsrhGMPhUZOKZNFHLlMzGQMVoRhU5gs7PB+B/9r5LfFh9+YTrNuLt50orgsGM+/zVgexNgBP73fPLuyfNqJv8zNWc/ZiUPA+0h5KPK+7rYH9xqn1ywA==";
    }

    public static String a(String str) {
        InputStream b = b(str);
        if (b == null) {
            return a();
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(b, "utf-8"));
            try {
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    sb.append(readLine);
                }
                com.baidu.android.pushservice.e.b.a(bufferedReader);
            } catch (IOException e) {
                com.baidu.android.pushservice.e.b.a(bufferedReader);
            } catch (Throwable th) {
                com.baidu.android.pushservice.e.b.a(bufferedReader);
                throw th;
            }
            com.baidu.android.pushservice.e.b.a(b);
        } catch (UnsupportedEncodingException e2) {
            com.baidu.android.pushservice.e.b.a(b);
        } catch (Throwable th2) {
            com.baidu.android.pushservice.e.b.a(b);
            throw th2;
        }
        return sb.toString();
    }

    public static boolean a(String str, String str2) {
        FileWriter fileWriter;
        Throwable th;
        BufferedWriter bufferedWriter;
        FileWriter fileWriter2;
        BufferedWriter bufferedWriter2 = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            fileWriter = new FileWriter(str, false);
            try {
                bufferedWriter = new BufferedWriter(fileWriter);
                try {
                    bufferedWriter.write(str2);
                    com.baidu.android.pushservice.e.b.a(bufferedWriter, fileWriter);
                    return true;
                } catch (Exception e) {
                    bufferedWriter2 = bufferedWriter;
                    fileWriter2 = fileWriter;
                    com.baidu.android.pushservice.e.b.a(bufferedWriter2, fileWriter2);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.android.pushservice.e.b.a(bufferedWriter, fileWriter);
                    throw th;
                }
            } catch (Exception e2) {
                fileWriter2 = fileWriter;
            } catch (Throwable th3) {
                bufferedWriter = null;
                th = th3;
            }
        } catch (Exception e3) {
            fileWriter2 = null;
        } catch (Throwable th4) {
            fileWriter = null;
            th = th4;
            bufferedWriter = null;
        }
    }

    private static InputStream b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return new FileInputStream(file);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
