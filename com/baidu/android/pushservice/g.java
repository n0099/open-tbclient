package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.util.Utility;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class g {
    public static String a = "api.tuisong.baidu.com";
    public static String c = "sa.tuisong.baidu.com";
    public static int e = 5287;
    public static int f = 5288;
    public static String g = "https://info.tuisong.baidu.com";
    public static String h = "/v2/setter";
    public static String i = "/v2/getter";
    public static String j = "/bccs/upload";
    public static String k = "https://ack.tuisong.baidu.com";
    public static String l = "/click";
    public static boolean m;
    public static String[] b = {"api0.tuisong.baidu.com", "api1.tuisong.baidu.com", "api2.tuisong.baidu.com", "api3.tuisong.baidu.com", "api4.tuisong.baidu.com", "api5.tuisong.baidu.com", "api6.tuisong.baidu.com", "api7.tuisong.baidu.com", "api8.tuisong.baidu.com", "api9.tuisong.baidu.com"};
    public static String[] d = {"sa0.tuisong.baidu.com", "sa1.tuisong.baidu.com", "sa2.tuisong.baidu.com", "sa3.tuisong.baidu.com", "sa4.tuisong.baidu.com", "sa5.tuisong.baidu.com", "sa6.tuisong.baidu.com", "sa7.tuisong.baidu.com", "sa8.tuisong.baidu.com", "sa9.tuisong.baidu.com"};

    public static String a() {
        StringBuilder sb;
        String d2;
        if (m) {
            sb = new StringBuilder();
            d2 = c();
        } else {
            sb = new StringBuilder();
            d2 = d();
        }
        sb.append(d2);
        sb.append("/rest/2.0/channel/");
        return sb.toString();
    }

    public static String a(Context context) {
        String b2 = PushSettings.b(context);
        if (!TextUtils.isEmpty(b2) && b2.length() > 0) {
            try {
                return b[Integer.parseInt(b2.substring(b2.length() - 1)) % 10];
            } catch (Exception unused) {
            }
        }
        return "api.tuisong.baidu.com";
    }

    public static String b() {
        return a;
    }

    public static String b(Context context) {
        String b2 = PushSettings.b(context);
        if (!TextUtils.isEmpty(b2) && b2.length() > 0) {
            try {
                return d[Integer.parseInt(b2.substring(b2.length() - 1)) % 10];
            } catch (Exception unused) {
            }
        }
        return "sa.tuisong.baidu.com";
    }

    public static int c(Context context) {
        return Utility.D(context) ? f : e;
    }

    public static String c() {
        return "http://" + a;
    }

    public static String d() {
        return "https://" + a;
    }

    public static void d(Context context) {
        try {
            if (!PushSettings.e(context)) {
                String b2 = PushSettings.b(context);
                if (TextUtils.isEmpty(b2) || b2.length() <= 0) {
                    return;
                }
                int parseInt = Integer.parseInt(b2.substring(b2.length() - 1));
                a = b[parseInt % 10];
                c = d[parseInt % 10];
                return;
            }
            String c2 = com.baidu.android.pushservice.a0.i.c(context, "com.baidu.android.pushservice.offline_environment_conf");
            if (TextUtils.isEmpty(c2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(c2);
            String optString = jSONObject.optString("http_server");
            if (!TextUtils.isEmpty(optString)) {
                if (optString.startsWith("http://")) {
                    optString = optString.replace("http://", "");
                }
                a = optString;
            }
            String optString2 = jSONObject.optString("socket_server");
            if (!TextUtils.isEmpty(optString2)) {
                c = optString2;
            }
            String optString3 = jSONObject.optString("data_update_server");
            if (!TextUtils.isEmpty(optString3)) {
                g = optString3;
            }
            String optString4 = jSONObject.optString("push_ack_server");
            if (!TextUtils.isEmpty(optString4)) {
                k = optString4;
            }
            if (Utility.D(context)) {
                String optString5 = jSONObject.optString("socket_server_port_v3");
                if (!TextUtils.isEmpty(optString5)) {
                    f = Integer.parseInt(optString5);
                }
            } else {
                String optString6 = jSONObject.optString("socket_server_port");
                if (!TextUtils.isEmpty(optString6)) {
                    e = Integer.parseInt(optString6);
                }
            }
            if (e.a == 0) {
                String optString7 = jSONObject.optString("api_key");
                if (TextUtils.equals(jSONObject.optString("pkg_name"), context.getPackageName()) && !TextUtils.isEmpty(optString7)) {
                    e.b = optString7;
                }
            }
            m = true;
        } catch (Exception unused) {
        }
    }

    public static String e() {
        return c;
    }

    public static boolean f() {
        return m;
    }
}
