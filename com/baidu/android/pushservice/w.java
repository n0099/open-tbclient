package com.baidu.android.pushservice;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static final String f749a;
    public static final String b;
    public static final int c;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final String g;
    private static String h = "http://channel.api.duapp.com";
    private static String i = "agentchannel.api.duapp.com";
    private static int j = 5287;
    private static String k = "http://m.baidu.com";

    static {
        a();
        f749a = h;
        b = i;
        c = j;
        d = k;
        e = f749a + "/rest/2.0/channel/channel";
        f = f749a + "/rest/2.0/channel/";
        g = d + "/searchbox?action=publicsrv&type=issuedcode";
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a() {
        FileInputStream fileInputStream;
        File file = new File(Environment.getExternalStorageDirectory(), "pushservice.cfg");
        if (!file.exists()) {
            return;
        }
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    properties.load(fileInputStream);
                    String property = properties.getProperty("http_server");
                    if (property != null && property.length() > 0) {
                        h = property;
                    }
                    String property2 = properties.getProperty("socket_server");
                    if (property2 != null && property2.length() > 0) {
                        i = property2;
                    }
                    String property3 = properties.getProperty("socket_server_port");
                    if (property3 != null && property3.length() > 0) {
                        j = Integer.parseInt(property3);
                    }
                    String property4 = properties.getProperty("config_server");
                    if (property4 != null && property4.length() > 0) {
                        k = property4;
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    if (b.a()) {
                        System.out.println(e.getMessage());
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th;
        }
    }
}
