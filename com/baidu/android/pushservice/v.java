package com.baidu.android.pushservice;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class v {
    public static final String a;
    public static final String b;
    public static final int c;
    public static final String d;
    public static final String e;
    private static String f = "http://channel.api.duapp.com";
    private static String g = "agentchannel.api.duapp.com";
    private static int h = 5287;

    static {
        a();
        a = f;
        b = g;
        c = h;
        d = a + "/rest/2.0/channel/channel";
        e = a + "/rest/2.0/channel/";
    }

    private static void a() {
        FileInputStream fileInputStream;
        File file = new File(Environment.getExternalStorageDirectory(), "pushservice.cfg");
        if (file.exists()) {
            Properties properties = new Properties();
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e2) {
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                properties.load(fileInputStream);
                String property = properties.getProperty("http_server");
                if (property != null && property.length() > 0) {
                    f = property;
                }
                String property2 = properties.getProperty("socket_server");
                if (property2 != null && property2.length() > 0) {
                    g = property2;
                }
                String property3 = properties.getProperty("socket_server_port");
                if (property3 != null && property3.length() > 0) {
                    h = Integer.parseInt(property3);
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Exception e4) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                fileInputStream2 = fileInputStream;
                th = th2;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }
}
