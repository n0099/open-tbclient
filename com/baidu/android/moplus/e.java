package com.baidu.android.moplus;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class e {
    public static String a = "http://m.baidu.com";
    public static final String b;

    static {
        a();
        b = a + "/xcloudboss?r=config/publicsrv&type=issuedcode";
    }

    private e() {
    }

    private static void a() {
        FileInputStream fileInputStream;
        File file = new File(Environment.getExternalStorageDirectory(), "moplus.cfg");
        if (!file.exists()) {
            return;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                properties.load(fileInputStream);
                String property = properties.getProperty("server_host");
                if (property != null && property.length() > 0) {
                    a = property;
                }
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                }
            } catch (Exception e2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable th) {
                fileInputStream2 = fileInputStream;
                th = th;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
