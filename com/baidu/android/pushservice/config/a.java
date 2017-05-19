package com.baidu.android.pushservice.config;

import android.content.Context;
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
    public static String a(Context context, String str) {
        InputStream b = b(context, str);
        if (b == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(b, "utf-8"));
                try {
                    try {
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            sb.append(readLine);
                        }
                        com.baidu.android.pushservice.d.b.a(bufferedReader);
                    } catch (IOException e) {
                        com.baidu.android.pushservice.e.a.a("AssetFileUtils", e);
                        com.baidu.android.pushservice.d.b.a(bufferedReader);
                    }
                    com.baidu.android.pushservice.d.b.a(b);
                } catch (Throwable th) {
                    com.baidu.android.pushservice.d.b.a(bufferedReader);
                    throw th;
                }
            } catch (Throwable th2) {
                com.baidu.android.pushservice.d.b.a(b);
                throw th2;
            }
        } catch (UnsupportedEncodingException e2) {
            com.baidu.android.pushservice.e.a.a("AssetFileUtils", e2);
            com.baidu.android.pushservice.d.b.a(b);
        }
        return sb.toString();
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
                    com.baidu.android.pushservice.d.b.a(bufferedWriter2, fileWriter);
                    return true;
                } catch (Exception e) {
                    e = e;
                    bufferedWriter = bufferedWriter2;
                    fileWriter2 = fileWriter;
                    try {
                        com.baidu.android.pushservice.e.a.a("AssetFileUtils", e);
                        com.baidu.android.pushservice.d.b.a(bufferedWriter, fileWriter2);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileWriter = fileWriter2;
                        com.baidu.android.pushservice.d.b.a(bufferedWriter, fileWriter);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    com.baidu.android.pushservice.d.b.a(bufferedWriter, fileWriter);
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

    private static InputStream b(Context context, String str) {
        try {
            File file = new File(str);
            return !file.exists() ? a.class.getResourceAsStream(str) : new FileInputStream(file);
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.a("AssetFileUtils", e);
            return null;
        }
    }
}
