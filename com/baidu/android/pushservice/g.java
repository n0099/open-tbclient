package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.g.m;
import com.baidu.android.pushservice.i.l;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.sapi2.utils.SapiUtils;
import com.sina.weibo.sdk.utils.WbAuthConstants;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;
/* loaded from: classes8.dex */
public final class g {
    private static String f = "api.tuisong.baidu.com";
    private static String[] g = {"api0.tuisong.baidu.com", "api1.tuisong.baidu.com", "api2.tuisong.baidu.com", "api3.tuisong.baidu.com", "api4.tuisong.baidu.com", "api5.tuisong.baidu.com", "api6.tuisong.baidu.com", "api7.tuisong.baidu.com", "api8.tuisong.baidu.com", "api9.tuisong.baidu.com"};
    private static String h = "sa.tuisong.baidu.com";
    private static String[] i = {"sa0.tuisong.baidu.com", "sa1.tuisong.baidu.com", "sa2.tuisong.baidu.com", "sa3.tuisong.baidu.com", "sa4.tuisong.baidu.com", "sa5.tuisong.baidu.com", "sa6.tuisong.baidu.com", "sa7.tuisong.baidu.com", "sa8.tuisong.baidu.com", "sa9.tuisong.baidu.com"};
    public static int a = 5287;
    public static int b = 5288;
    public static String[] c = {"202.108.23.105", "180.149.132.107", "180.149.131.209", "111.13.100.86", "111.13.100.85", " 61.135.185.18", "220.181.163.183", "220.181.163.182"};
    private static boolean j = true;
    private static String k = DownloadConstants.REFER;
    private static ArrayList<String> l = null;
    private static ArrayList<String> m = null;
    public static final String d = k;
    public static final String e = d + "/searchbox?action=publicsrv&type=issuedcode";
    private static boolean n = false;

    public static int a(Context context) {
        return l.D(context) ? b : a;
    }

    public static String a() {
        return "http://" + f;
    }

    public static String a(Context context, boolean z) {
        if (m == null || m.isEmpty() || j) {
            m = a(context, ".baidu.push.sa");
        }
        if (m != null && m.size() > 0) {
            if (!z) {
                m.remove(0);
            }
            if (m.size() > 0) {
                return m.get(0);
            }
        }
        return null;
    }

    private static ArrayList<String> a(Context context, String str) {
        ArrayList<String> b2 = b(context, str);
        if (b2.size() <= 0) {
            if (str.equals(".baidu.push.sa")) {
                for (String str2 : c) {
                    b2.add(str2);
                }
            }
            j = true;
            c(context);
        } else {
            j = false;
        }
        return b2;
    }

    public static String b() {
        return SapiUtils.COOKIE_HTTPS_URL_PREFIX + f;
    }

    private static ArrayList<String> b(Context context, String str) {
        String[] split;
        ArrayList<String> arrayList = new ArrayList<>();
        String string = context.getSharedPreferences("pst", 0).getString(str, null);
        if (!TextUtils.isEmpty(string) && (split = string.split(":")) != null && split.length > 0) {
            for (String str2 : split) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static void b(Context context) {
        FileInputStream fileInputStream;
        File file = new File(Environment.getExternalStorageDirectory(), "pushservice.cfg");
        if (!context.getPackageName().startsWith("com.baidu.push") || !file.exists()) {
            String a2 = PushSettings.a(context);
            if (TextUtils.isEmpty(a2) || a2.length() <= 0) {
                return;
            }
            try {
                int parseInt = Integer.parseInt(a2.substring(a2.length() - 1));
                f = g[parseInt % 10];
                h = i[parseInt % 10];
                return;
            } catch (Exception e2) {
                return;
            }
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream2 = null;
        try {
            if (l.u(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.e.b.a(fileInputStream);
                    return;
                } catch (Throwable th) {
                    fileInputStream2 = fileInputStream;
                    th = th;
                    com.baidu.android.pushservice.e.b.a(fileInputStream2);
                    throw th;
                }
            } else {
                properties.put("http_server", "http://10.95.41.15:8080");
                if (l.D(context)) {
                    properties.put("socket_server_port_v3", "8006");
                } else {
                    properties.put("socket_server_port", WbAuthConstants.AUTH_FAILED_QUICK_NULL_TOKEN_ERROR_CODE);
                }
                properties.put("socket_server", "10.95.41.15");
                fileInputStream = null;
            }
            String property = properties.getProperty("http_server");
            if (!TextUtils.isEmpty(property)) {
                if (property.startsWith("http://")) {
                    property = property.replace("http://", "");
                }
                f = property;
            }
            String property2 = properties.getProperty("socket_server");
            if (!TextUtils.isEmpty(property2)) {
                h = property2;
            }
            if (l.D(context)) {
                String property3 = properties.getProperty("socket_server_port_v3");
                if (!TextUtils.isEmpty(property3)) {
                    b = Integer.parseInt(property3);
                }
            } else {
                String property4 = properties.getProperty("socket_server_port");
                if (!TextUtils.isEmpty(property4)) {
                    a = Integer.parseInt(property4);
                }
            }
            String property5 = properties.getProperty("config_server");
            if (!TextUtils.isEmpty(property5)) {
                k = property5;
            }
            if (e.a == 0) {
                String property6 = properties.getProperty(Constants.API_KEY);
                if (TextUtils.equals(properties.getProperty(PushConstants.PACKAGE_NAME), context.getPackageName()) && !TextUtils.isEmpty(property6)) {
                    e.b = property6;
                }
            }
            n = true;
            com.baidu.android.pushservice.e.b.a(fileInputStream);
        } catch (Exception e4) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, String str, String str2) {
        try {
            if (str.startsWith("http://")) {
                str = str.replace("http://", "");
            }
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (context != null && allByName != null && allByName.length > 0) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
                String str3 = "";
                for (int i2 = 0; i2 < allByName.length; i2++) {
                    str3 = str3 + ":" + allByName[i2].getHostAddress();
                }
                if (str3.length() > 1) {
                    String substring = str3.substring(1);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(str2, substring);
                    edit.commit();
                    return true;
                }
            }
        } catch (Exception e2) {
            m.a(context, e2);
        }
        return false;
    }

    public static String c() {
        return h;
    }

    public static void c(final Context context) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
        if (System.currentTimeMillis() - sharedPreferences.getLong(".baidu.push.dns.refresh", 0L) > 86400000) {
            com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("updateBackupIp", (short) 95) { // from class: com.baidu.android.pushservice.g.1
                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    if (g.b(context.getApplicationContext(), g.h, ".baidu.push.sa")) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putLong(".baidu.push.dns.refresh", System.currentTimeMillis());
                        edit.commit();
                    }
                }
            });
        }
    }

    public static String d() {
        return n ? a() + "/rest/2.0/channel/channel" : b() + "/rest/2.0/channel/channel";
    }

    public static String e() {
        return n ? a() + "/rest/2.0/channel/" : b() + "/rest/2.0/channel/";
    }

    public static boolean f() {
        return n;
    }
}
