package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes5.dex */
public class PushSettings {

    /* renamed from: a  reason: collision with root package name */
    public static int f1077a = -1;
    public static int b = -1;
    public static int c = -1;
    public static int d = -1;
    public static int e = -1;
    public static int f = -1;

    public static String a(Context context) {
        String a2 = com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.channel_id");
        return TextUtils.isEmpty(a2) ? com.baidu.android.pushservice.c.c.a(context, false) : a2;
    }

    public static void a(Context context, int i) {
        if (context == null) {
            return;
        }
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.sd", i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, String str) {
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.channel_token", str);
        com.baidu.android.pushservice.c.c.a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, String str, String str2) {
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.channel_id", str);
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.channel_id_new", str2);
        com.baidu.android.pushservice.c.c.a(context, str, str2);
    }

    public static String b(Context context) {
        String a2 = com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.channel_id_new");
        return TextUtils.isEmpty(a2) ? com.baidu.android.pushservice.c.c.a(context, true) : a2;
    }

    public static void b(Context context, int i) {
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.track.failcount", i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.android.pushservice.i.i.b(context, "com.baidu.pushservice.app_id", str);
    }

    public static String c(Context context) {
        String a2 = com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.channel_token");
        return TextUtils.isEmpty(a2) ? com.baidu.android.pushservice.c.c.c(context) : a2;
    }

    public static String d(Context context) {
        return com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.app_id");
    }

    public static boolean e(Context context) {
        return context != null && f1077a == 1;
    }

    public static void enableDebugMode(boolean z) {
        f1077a = z ? 1 : 0;
    }

    public static boolean f(Context context) {
        if (context == null) {
            return false;
        }
        if (b == -1) {
            b = com.baidu.android.pushservice.i.i.b(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", -1);
        }
        return b == 1;
    }

    public static boolean g(Context context) {
        if (context == null) {
            return false;
        }
        if (d == -1) {
            d = com.baidu.android.pushservice.i.i.b(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", -1);
        }
        return d == 1;
    }

    public static boolean h(Context context) {
        if (context == null) {
            return false;
        }
        if (e == -1) {
            e = com.baidu.android.pushservice.i.i.b(context, "com.baidu.android.pushservice.PushSettings.op_proxy_mode", -1);
        }
        return e == 1;
    }

    public static boolean i(Context context) {
        if (context == null) {
            return false;
        }
        if (f == -1) {
            f = com.baidu.android.pushservice.i.i.b(context, "com.baidu.android.pushservice.PushSettings.vi_proxy_mode", -1);
        }
        return f == 1;
    }

    public static boolean j(Context context) {
        if (context == null) {
            return false;
        }
        if (c == -1) {
            c = com.baidu.android.pushservice.i.i.b(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", -1);
        }
        return c == 1;
    }

    public static void k(Context context) {
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.track", System.currentTimeMillis());
    }

    public static boolean l(Context context) {
        long b2 = com.baidu.android.pushservice.i.i.b(context, "com.baidu.pushservice.track");
        if (b2 > 0) {
            return System.currentTimeMillis() - b2 >= ((long) ((com.baidu.android.pushservice.b.d.h(context) * SdkConfigData.DEFAULT_REQUEST_INTERVAL) * 1000));
        }
        k(context);
        return false;
    }

    public static int m(Context context) {
        return com.baidu.android.pushservice.i.i.b(context, "com.baidu.pushservice.track.failcount", 1);
    }

    public static boolean n(Context context) {
        return com.baidu.android.pushservice.i.i.b(context, "com.baidu.pushservice.need.logtofile", -1) == 1;
    }
}
