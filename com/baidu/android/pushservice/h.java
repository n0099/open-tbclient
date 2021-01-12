package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.sapi2.utils.SapiUtils;
import com.sina.weibo.sdk.utils.WbAuthConstants;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
/* loaded from: classes14.dex */
public final class h {
    private static String c = "api.tuisong.baidu.com";
    private static String[] d = {"api0.tuisong.baidu.com", "api1.tuisong.baidu.com", "api2.tuisong.baidu.com", "api3.tuisong.baidu.com", "api4.tuisong.baidu.com", "api5.tuisong.baidu.com", "api6.tuisong.baidu.com", "api7.tuisong.baidu.com", "api8.tuisong.baidu.com", "api9.tuisong.baidu.com"};
    private static String e = "sa.tuisong.baidu.com";
    private static String[] f = {"sa0.tuisong.baidu.com", "sa1.tuisong.baidu.com", "sa2.tuisong.baidu.com", "sa3.tuisong.baidu.com", "sa4.tuisong.baidu.com", "sa5.tuisong.baidu.com", "sa6.tuisong.baidu.com", "sa7.tuisong.baidu.com", "sa8.tuisong.baidu.com", "sa9.tuisong.baidu.com"};

    /* renamed from: a  reason: collision with root package name */
    public static int f1318a = 5287;

    /* renamed from: b  reason: collision with root package name */
    public static int f1319b = 5288;
    private static boolean g = false;

    public static int a(Context context) {
        return m.o(context) ? f1319b : f1318a;
    }

    public static String a() {
        return "http://" + c;
    }

    public static String b() {
        return SapiUtils.COOKIE_HTTPS_URL_PREFIX + c;
    }

    public static void b(Context context) {
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        if (!context.getPackageName().startsWith("com.baidu.push")) {
            String a2 = PushSettings.a(context);
            if (TextUtils.isEmpty(a2) || a2.length() <= 0) {
                return;
            }
            try {
                int parseInt = Integer.parseInt(a2.substring(a2.length() - 1));
                c = d[parseInt % 10];
                e = f[parseInt % 10];
                return;
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return;
            }
        }
        File file = new File(Environment.getExternalStorageDirectory(), "pushservice.cfg");
        if (!file.exists()) {
            return;
        }
        Properties properties = new Properties();
        try {
            if (m.k(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                fileInputStream2 = new FileInputStream(file);
                try {
                    properties.load(fileInputStream2);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.e.b.a(context, fileInputStream2);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    com.baidu.android.pushservice.e.b.a(context, fileInputStream);
                    throw th;
                }
            } else {
                properties.put("http_server", "http://10.95.41.15:8080");
                if (m.o(context)) {
                    properties.put("socket_server_port_v3", "8006");
                } else {
                    properties.put("socket_server_port", WbAuthConstants.AUTH_FAILED_QUICK_NULL_TOKEN_ERROR_CODE);
                }
                properties.put("socket_server", "10.95.41.15");
                fileInputStream2 = null;
            }
            String property = properties.getProperty("http_server");
            if (!TextUtils.isEmpty(property)) {
                if (property.startsWith("http://")) {
                    property = property.replace("http://", "");
                }
                c = property;
            }
            String property2 = properties.getProperty("socket_server");
            if (!TextUtils.isEmpty(property2)) {
                e = property2;
            }
            if (m.o(context)) {
                String property3 = properties.getProperty("socket_server_port_v3");
                if (!TextUtils.isEmpty(property3)) {
                    f1319b = Integer.parseInt(property3);
                }
            } else {
                String property4 = properties.getProperty("socket_server_port");
                if (!TextUtils.isEmpty(property4)) {
                    f1318a = Integer.parseInt(property4);
                }
            }
            if (f.f1295a == 0) {
                String property5 = properties.getProperty(Constants.API_KEY);
                if (TextUtils.equals(properties.getProperty("pkg_name"), context.getPackageName()) && !TextUtils.isEmpty(property5)) {
                    f.f1296b = property5;
                }
            }
            g = true;
            com.baidu.android.pushservice.e.b.a(context, fileInputStream2);
        } catch (Exception e4) {
            fileInputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static String c() {
        return c;
    }

    public static String c(Context context) {
        String a2 = PushSettings.a(context);
        if (TextUtils.isEmpty(a2) || a2.length() <= 0) {
            return "sa.tuisong.baidu.com";
        }
        try {
            return f[Integer.parseInt(a2.substring(a2.length() - 1)) % 10];
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return "sa.tuisong.baidu.com";
        }
    }

    public static String d() {
        return e;
    }

    public static String d(Context context) {
        String a2 = PushSettings.a(context);
        if (TextUtils.isEmpty(a2) || a2.length() <= 0) {
            return "api.tuisong.baidu.com";
        }
        try {
            return d[Integer.parseInt(a2.substring(a2.length() - 1)) % 10];
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return "api.tuisong.baidu.com";
        }
    }

    public static String e() {
        return g ? a() + "/rest/2.0/channel/" : b() + "/rest/2.0/channel/";
    }

    public static boolean f() {
        return g;
    }
}
