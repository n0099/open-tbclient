package com.baidu.android.pushservice.c;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
/* loaded from: classes2.dex */
public class a {
    public static String a() {
        return "QM/LurxEwvmX7RXA7cj5A6YOE9UNth30QE0T/8ZIdzn+9n7bHEY83yXrh+PjawH+NvooDz6aiM/AHshDo/AvNNyF5eOIihFbRNb4SSf56B6CFneI7NUf9VlyZVKcyfwfJbxO8YS4KG8y891gB5xNw+La7Ib4auEcw5yQdePhK1lvCJdWCbMJUUelU9uEihUy5Pjdt5apgOkU0+TrgJtJ3pr4JJdzrbEJGfruCK1tcACGqKK5KnPI50uXEGc3F0cXPMed6Y3x+9cj9p9/G8nMMkklQUJHTYlLd2Kt470Ipf68c7hlVZ6nESJznJcAjM6DreiD+c/MMXV3mMAEqM9EBh0EPk8ymMj1Ej+1+HfHLgHEz0mIP1y/GGooVglxvrbfLFuHAmKXcSThHYhjv+kVmMZQ71Iyj6Pkdq6LFDuSEFU57tCkBBBRcn5Lol62xz3y15o9/xoSp8vvfyi92YvXRHSdrAC7lTUhUqe9dXSUMO7HiO+gdBwYf9EDiTPom2lcwuEfjyThWKDTEPTF2cishBSYgtRQuXRHkc4wsrhGMPhUZOKZNFHLlMzGQMVoRhU5gs7PB+B/9r5LfFh9+YTrNuLt50orgsGM+/zVgexNgBP73fPLuyfNqJv8zNWc/ZiUPA+0h5KPK+7rYH9xqn1ywA==";
    }

    public static String a(String str) {
        BufferedReader bufferedReader;
        InputStream b = b(str);
        if (b == null) {
            return a();
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(b, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                com.baidu.android.pushservice.g.a.a("AssetFileUtils", e);
                com.baidu.android.pushservice.f.b.a(b);
            }
            try {
                try {
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        sb.append(readLine);
                    }
                    com.baidu.android.pushservice.f.b.a(bufferedReader);
                } catch (IOException e2) {
                    com.baidu.android.pushservice.g.a.a("AssetFileUtils", e2);
                    com.baidu.android.pushservice.f.b.a(bufferedReader);
                }
                com.baidu.android.pushservice.f.b.a(b);
                return sb.toString();
            } catch (Throwable th) {
                com.baidu.android.pushservice.f.b.a(bufferedReader);
                throw th;
            }
        } catch (Throwable th2) {
            com.baidu.android.pushservice.f.b.a(b);
            throw th2;
        }
    }

    public static boolean a(String str, String str2) {
        FileWriter fileWriter;
        FileWriter fileWriter2;
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            fileWriter = new FileWriter(str, false);
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
                try {
                    bufferedWriter2.write(str2);
                    com.baidu.android.pushservice.f.b.a(bufferedWriter2, fileWriter);
                    return true;
                } catch (Exception e) {
                    e = e;
                    bufferedWriter = bufferedWriter2;
                    fileWriter2 = fileWriter;
                    try {
                        com.baidu.android.pushservice.g.a.a("AssetFileUtils", e);
                        com.baidu.android.pushservice.f.b.a(bufferedWriter, fileWriter2);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileWriter = fileWriter2;
                        com.baidu.android.pushservice.f.b.a(bufferedWriter, fileWriter);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    com.baidu.android.pushservice.f.b.a(bufferedWriter, fileWriter);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileWriter2 = fileWriter;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e3) {
            e = e3;
            fileWriter2 = null;
        } catch (Throwable th4) {
            th = th4;
            fileWriter = null;
        }
    }

    private static InputStream b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return new FileInputStream(file);
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("AssetFileUtils", e);
        }
        return null;
    }
}
