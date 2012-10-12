package com.baidu.android.pushservice;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class w {
    public static final String a;
    public static final String b;
    public static final int c;
    public static final long d;
    public static final String e;
    public static final String f;
    private static String g = "http://channel.api.duapp.com";
    private static String h = "agentchannel.api.duapp.com";
    private static int i = 5287;
    private static long j = 86400000;

    static {
        a();
        a = g;
        b = h;
        c = i;
        d = j;
        e = a + "/rest/2.0/channel/channel";
        f = a + "/rest/2.0/channel/";
    }

    private static void a() {
        FileInputStream fileInputStream;
        File file = new File(Environment.getExternalStorageDirectory(), "pushservice.cfg");
        if (!file.exists()) {
            return;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                properties.load(fileInputStream);
                String property = properties.getProperty("http_server");
                if (property != null && property.length() > 0) {
                    g = property;
                }
                String property2 = properties.getProperty("socket_server");
                if (property2 != null && property2.length() > 0) {
                    h = property2;
                }
                String property3 = properties.getProperty("socket_server_port");
                if (property3 != null && property3.length() > 0) {
                    i = Integer.parseInt(property3);
                }
                String property4 = properties.getProperty("socket_interval");
                if (property4 != null && property4.length() > 0) {
                    j = Integer.parseInt(property4) * 60000;
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                fileInputStream2 = fileInputStream;
                th = th;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
