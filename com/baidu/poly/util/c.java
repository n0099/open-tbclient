package com.baidu.poly.util;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes6.dex */
public class c {
    public static String a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                return sb.toString();
            }
        }
    }

    public static String n(File file) {
        FileInputStream fileInputStream;
        String str = null;
        if (file != null) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    str = a(fileInputStream);
                    a(fileInputStream);
                } catch (Exception e) {
                    a(fileInputStream);
                    return str;
                } catch (Throwable th) {
                    th = th;
                    a(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        }
        return str;
    }

    public static void a(String str, File file) {
        FileOutputStream fileOutputStream;
        if (!TextUtils.isEmpty(str) && file != null) {
            try {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e) {
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                a(fileOutputStream);
            } catch (Exception e2) {
                a(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                a(fileOutputStream);
                throw th;
            }
        }
    }

    public static void a(Closeable... closeableArr) {
        if (closeableArr != null) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }
}
