package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.pushservice.f.p;
import com.baidu.android.pushservice.h.u;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;
/* loaded from: classes2.dex */
public final class h {
    private static String g = "api.tuisong.baidu.com";
    private static String[] h = {"api0.tuisong.baidu.com", "api1.tuisong.baidu.com", "api2.tuisong.baidu.com", "api3.tuisong.baidu.com", "api4.tuisong.baidu.com", "api5.tuisong.baidu.com", "api6.tuisong.baidu.com", "api7.tuisong.baidu.com", "api8.tuisong.baidu.com", "api9.tuisong.baidu.com"};
    private static String i = "sa.tuisong.baidu.com";
    private static String[] j = {"sa0.tuisong.baidu.com", "sa1.tuisong.baidu.com", "sa2.tuisong.baidu.com", "sa3.tuisong.baidu.com", "sa4.tuisong.baidu.com", "sa5.tuisong.baidu.com", "sa6.tuisong.baidu.com", "sa7.tuisong.baidu.com", "sa8.tuisong.baidu.com", "sa9.tuisong.baidu.com"};
    public static int a = 5287;
    public static int b = 5288;
    private static final String[] k = {"202.108.23.109", "180.149.132.103", "111.13.12.174", "111.13.12.61"};
    public static String[] c = {"202.108.23.105", "180.149.132.107", "111.13.12.162", "180.149.131.209", "111.13.12.110", "111.13.100.86", " 111.13.100.85", " 61.135.185.18", "220.181.163.183", "220.181.163.182", " 115.239.210.219", "115.239.210.246"};
    private static boolean l = true;
    private static String m = "http://m.baidu.com";
    public static String d = "http://m.baidu.com";
    private static ArrayList<String> n = null;
    private static ArrayList<String> o = null;
    public static final String e = m;
    public static final String f = e + "/searchbox?action=publicsrv&type=issuedcode";
    private static boolean p = false;

    public static int a(Context context) {
        return u.E(context) ? b : a;
    }

    public static String a() {
        return "http://" + g;
    }

    public static String a(Context context, boolean z) {
        if (o == null || o.isEmpty() || l) {
            o = a(context, ".baidu.push.sa");
        }
        if (o != null && o.size() > 0) {
            if (!z) {
                o.remove(0);
            }
            if (o.size() > 0) {
                return o.get(0);
            }
        }
        return null;
    }

    private static ArrayList<String> a(Context context, String str) {
        int i2 = 0;
        ArrayList<String> b2 = b(context, str);
        if (b2.size() <= 0) {
            if (str.equals(".baidu.push.http")) {
                String[] strArr = k;
                int length = strArr.length;
                while (i2 < length) {
                    b2.add(strArr[i2]);
                    i2++;
                }
            } else {
                String[] strArr2 = c;
                int length2 = strArr2.length;
                while (i2 < length2) {
                    b2.add(strArr2[i2]);
                    i2++;
                }
            }
            l = true;
            c(context);
        } else {
            l = false;
        }
        return b2;
    }

    public static String b() {
        return "https://" + g;
    }

    public static String b(Context context, boolean z) {
        if (n == null || n.isEmpty()) {
            n = a(context, ".baidu.push.http");
        }
        if (n != null && n.size() > 0) {
            if (!z) {
                n.remove(0);
            }
            if (n.size() > 0) {
                return n.get(0);
            }
        }
        return null;
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
        if (!file.exists()) {
            String a2 = PushSettings.a(context);
            if (TextUtils.isEmpty(a2) || a2.length() <= 0) {
                return;
            }
            try {
                int parseInt = Integer.parseInt(a2.substring(a2.length() - 1));
                g = h[parseInt % 10];
                i = j[parseInt % 10];
                return;
            } catch (Exception e2) {
                com.baidu.android.pushservice.e.a.a("PushUrl", "parseInt err: " + a2, e2);
                return;
            }
        }
        Properties properties = new Properties();
        try {
            if (u.s(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        properties.load(fileInputStream);
                    } catch (Exception e3) {
                        e = e3;
                        com.baidu.android.pushservice.e.a.a("PushUrl", e);
                        com.baidu.android.pushservice.d.b.a(fileInputStream);
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.android.pushservice.d.b.a(fileInputStream);
                    throw th;
                }
            } else {
                properties.put("http_server", "http://10.95.41.15:8080");
                if (u.E(context)) {
                    properties.put("socket_server_port_v3", "8006");
                } else {
                    properties.put("socket_server_port", "8005");
                }
                properties.put("socket_server", "10.95.41.15");
                fileInputStream = null;
            }
            String property = properties.getProperty("http_server");
            if (!TextUtils.isEmpty(property)) {
                if (property.startsWith("http://")) {
                    property = property.replace("http://", "");
                }
                g = property;
            }
            String property2 = properties.getProperty("socket_server");
            if (!TextUtils.isEmpty(property2)) {
                i = property2;
            }
            if (u.E(context)) {
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
                m = property5;
            }
            if (!TextUtils.isEmpty(properties.getProperty("lightapp_server"))) {
                d = property5;
            }
            if (f.a == 0) {
                String property6 = properties.getProperty("api_key");
                if (TextUtils.equals(properties.getProperty(PushConstants.PACKAGE_NAME), context.getPackageName()) && !TextUtils.isEmpty(property6)) {
                    f.b = property6;
                }
            }
            p = true;
            com.baidu.android.pushservice.d.b.a(fileInputStream);
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            com.baidu.android.pushservice.d.b.a(fileInputStream);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, String str, String str2) {
        boolean z = false;
        try {
            if (str.startsWith("http://")) {
                str = str.replace("http://", "");
            }
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (context != null && allByName != null && allByName.length > 0) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
                String str3 = "";
                int i2 = 0;
                while (i2 < allByName.length) {
                    i2++;
                    str3 = str3 + ":" + allByName[i2].getHostAddress();
                }
                if (str3.length() > 1) {
                    str3 = str3.substring(1);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(str2, str3);
                    edit.commit();
                    z = true;
                }
                com.baidu.android.pushservice.e.a.c("PushUrl", "  --- write bck " + str2 + " : " + str3);
            }
        } catch (Exception e2) {
            com.baidu.android.pushservice.e.a.e("PushUrl", "  --- write bck Exception " + e2);
            p.a(context, e2);
        }
        return z;
    }

    public static String c() {
        return i;
    }

    public static void c(final Context context) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
        long j2 = sharedPreferences.getLong(".baidu.push.dns.refresh", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.android.pushservice.e.a.c("PushUrl", " update last: " + j2 + " current: " + currentTimeMillis);
        if (currentTimeMillis - j2 > 86400000) {
            com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("updateBackupIp", (short) 95) { // from class: com.baidu.android.pushservice.h.1
                @Override // com.baidu.android.pushservice.g.c
                public void a() {
                    boolean b2 = h.b(context.getApplicationContext(), h.i, ".baidu.push.sa");
                    boolean b3 = h.b(context.getApplicationContext(), h.g, ".baidu.push.http");
                    if (b2 && b3) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putLong(".baidu.push.dns.refresh", System.currentTimeMillis());
                        edit.commit();
                    }
                }
            });
        }
    }

    public static String d() {
        return p ? a() + "/rest/2.0/channel/channel" : b() + "/rest/2.0/channel/channel";
    }

    public static String e() {
        return p ? a() + "/rest/2.0/channel/" : b() + "/rest/2.0/channel/";
    }

    public static boolean f() {
        return p;
    }
}
