package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class PushSettings {

    /* renamed from: a  reason: collision with root package name */
    public static int f2707a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static int f2708b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static int f2709c = -1;

    /* renamed from: d  reason: collision with root package name */
    public static int f2710d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static int f2711e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static int f2712f = -1;

    public static String a(Context context) {
        String a2 = com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_id");
        return TextUtils.isEmpty(a2) ? com.baidu.android.pushservice.c.c.a(context, false) : a2;
    }

    public static void a(Context context, int i) {
        if (context == null) {
            return;
        }
        com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.sd", i);
    }

    public static void a(Context context, String str) {
        com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_token", str);
        com.baidu.android.pushservice.c.c.a(context, str);
    }

    public static void a(Context context, String str, String str2) {
        com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_id", str);
        com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_id_new", str2);
        com.baidu.android.pushservice.c.c.a(context, str, str2);
    }

    public static String b(Context context) {
        String a2 = com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_id_new");
        return TextUtils.isEmpty(a2) ? com.baidu.android.pushservice.c.c.a(context, true) : a2;
    }

    public static void b(Context context, int i) {
        com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.track.failcount", i);
    }

    public static void b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.android.pushservice.j.i.b(context, "com.baidu.pushservice.app_id", str);
    }

    public static String c(Context context) {
        String a2 = com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_token");
        return TextUtils.isEmpty(a2) ? com.baidu.android.pushservice.c.c.c(context) : a2;
    }

    public static String d(Context context) {
        return com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.app_id");
    }

    public static boolean e(Context context) {
        return context != null && f2707a == 1;
    }

    public static void enableDebugMode(boolean z) {
        f2707a = z ? 1 : 0;
    }

    public static boolean f(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean g(Context context) {
        if (context == null) {
            return false;
        }
        if (f2708b == -1) {
            f2708b = com.baidu.android.pushservice.j.i.b(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", -1);
        }
        return f2708b == 1;
    }

    public static boolean h(Context context) {
        if (context == null) {
            return false;
        }
        if (f2710d == -1) {
            f2710d = com.baidu.android.pushservice.j.i.b(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", -1);
        }
        return f2710d == 1;
    }

    public static boolean i(Context context) {
        if (context == null) {
            return false;
        }
        if (f2711e == -1) {
            f2711e = com.baidu.android.pushservice.j.i.b(context, "com.baidu.android.pushservice.PushSettings.op_proxy_mode", -1);
        }
        return f2711e == 1;
    }

    public static boolean j(Context context) {
        if (context == null) {
            return false;
        }
        if (f2712f == -1) {
            f2712f = com.baidu.android.pushservice.j.i.b(context, "com.baidu.android.pushservice.PushSettings.vi_proxy_mode", -1);
        }
        return f2712f == 1;
    }

    public static boolean k(Context context) {
        if (context == null) {
            return false;
        }
        if (f2709c == -1) {
            f2709c = com.baidu.android.pushservice.j.i.b(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", -1);
        }
        return f2709c == 1;
    }

    public static void l(Context context) {
        com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.track", System.currentTimeMillis());
    }

    public static boolean m(Context context) {
        long b2 = com.baidu.android.pushservice.j.i.b(context, "com.baidu.pushservice.track");
        if (b2 > 0) {
            return System.currentTimeMillis() - b2 >= ((long) ((com.baidu.android.pushservice.b.d.h(context) * 3600) * 1000));
        }
        l(context);
        return false;
    }

    public static int n(Context context) {
        return com.baidu.android.pushservice.j.i.b(context, "com.baidu.pushservice.track.failcount", 1);
    }

    public static boolean o(Context context) {
        return com.baidu.android.pushservice.j.i.b(context, "com.baidu.pushservice.need.logtofile", -1) == 1;
    }
}
