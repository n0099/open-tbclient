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
    public static final String d;
    public static final long e;
    public static final String f;
    public static final String g;
    public static final String h;
    private static String i = "http://channel.api.duapp.com";
    private static String j = "agentchannel.api.duapp.com";
    private static int k = 5287;
    private static String l = "http://m.baidu.com";
    private static long m = 86400000;

    static {
        a();
        a = i;
        b = j;
        c = k;
        d = l;
        e = m;
        f = a + "/rest/2.0/channel/channel";
        g = a + "/rest/2.0/channel/";
        h = d + "/searchbox?action=publicsrv&type=issuedcode";
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
                    i = property;
                }
                String property2 = properties.getProperty("socket_server");
                if (property2 != null && property2.length() > 0) {
                    j = property2;
                }
                String property3 = properties.getProperty("socket_server_port");
                if (property3 != null && property3.length() > 0) {
                    k = Integer.parseInt(property3);
                }
                String property4 = properties.getProperty("config_server");
                if (property4 != null && property4.length() > 0) {
                    l = property4;
                }
                String property5 = properties.getProperty("socket_interval");
                if (property5 != null && property5.length() > 0) {
                    m = Integer.parseInt(property5) * 60000;
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (Exception e3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                fileInputStream2 = fileInputStream;
                th = th;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
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
