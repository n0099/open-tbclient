package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.message.LocalPushMsg;
/* loaded from: classes.dex */
public class PushSettings {
    public static int a = -1;
    public static int b = -1;
    public static int c = -1;
    public static int d = -1;
    public static int e = -1;
    public static int f = -1;
    public static int g = -1;
    public static int h = -1;

    public static String a(Context context) {
        return com.baidu.android.pushservice.a0.i.c(context, "com.baidu.pushservice.app_id");
    }

    public static void a(Context context, int i) {
        if (context == null) {
            return;
        }
        com.baidu.android.pushservice.a0.i.b(context, "com.baidu.pushservice.sd", i);
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.android.pushservice.a0.i.c(context, "com.baidu.pushservice.app_id", str);
    }

    public static void a(Context context, String str, String str2) {
        com.baidu.android.pushservice.a0.i.b(context, "com.baidu.pushservice.channel_id", str);
        com.baidu.android.pushservice.a0.i.b(context, "com.baidu.pushservice.channel_id_new", str2);
        com.baidu.android.pushservice.m.d.d(context, str, str2);
    }

    public static String b(Context context) {
        String c2 = com.baidu.android.pushservice.a0.i.c(context, "com.baidu.pushservice.channel_id");
        return TextUtils.isEmpty(c2) ? com.baidu.android.pushservice.m.d.a(context, false) : c2;
    }

    public static void b(Context context, String str) {
        com.baidu.android.pushservice.a0.i.b(context, "com.baidu.pushservice.channel_token", str);
        com.baidu.android.pushservice.m.d.f(context, str);
    }

    public static String c(Context context) {
        String c2 = com.baidu.android.pushservice.a0.i.c(context, "com.baidu.pushservice.channel_token");
        return TextUtils.isEmpty(c2) ? com.baidu.android.pushservice.m.d.g(context) : c2;
    }

    public static String d(Context context) {
        String c2 = com.baidu.android.pushservice.a0.i.c(context, "com.baidu.pushservice.channel_id_new");
        return TextUtils.isEmpty(c2) ? com.baidu.android.pushservice.m.d.a(context, true) : c2;
    }

    public static boolean e(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void enableDebugMode(boolean z) {
        a = z ? 1 : 0;
    }

    public static boolean f(Context context) {
        return context != null && a == 1;
    }

    public static boolean g(Context context) {
        if (context == null) {
            return false;
        }
        if (d == -1) {
            d = com.baidu.android.pushservice.a0.i.a(context, "com.baidu.android.pushservice.PushSettings.hn_proxy_mode", -1);
        }
        return d == 1;
    }

    public static boolean h(Context context) {
        if (context == null) {
            return false;
        }
        if (c == -1) {
            c = com.baidu.android.pushservice.a0.i.a(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", -1);
        }
        return c == 1;
    }

    public static boolean i(Context context) {
        if (context == null) {
            return false;
        }
        if (h == -1) {
            h = com.baidu.android.pushservice.a0.i.a(context, "com.baidu.android.pushservice.PushSettings.hw_hms_down_mode", -1);
        }
        return h == 1;
    }

    public static void insertLocalNotifyMsg(Context context, LocalPushMsg localPushMsg) {
        com.baidu.android.pushservice.n.c.a().a(context, localPushMsg);
    }

    public static boolean j(Context context) {
        if (context == null) {
            return false;
        }
        if (e == -1) {
            e = com.baidu.android.pushservice.a0.i.a(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", -1);
        }
        return e == 1;
    }

    public static boolean k(Context context) {
        if (context == null) {
            return false;
        }
        if (f == -1) {
            f = com.baidu.android.pushservice.a0.i.a(context, "com.baidu.android.pushservice.PushSettings.op_proxy_mode", -1);
        }
        return f == 1;
    }

    public static boolean l(Context context) {
        if (context == null) {
            return false;
        }
        if (g == -1) {
            g = com.baidu.android.pushservice.a0.i.a(context, "com.baidu.android.pushservice.PushSettings.vi_proxy_mode", -1);
        }
        return g == 1;
    }

    public static boolean m(Context context) {
        if (context == null) {
            return false;
        }
        if (b == -1) {
            b = com.baidu.android.pushservice.a0.i.a(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", -1);
        }
        return b == 1;
    }
}
