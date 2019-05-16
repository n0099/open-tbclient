package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.i.l;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PushSettings {
    public static int a = -1;
    public static int b = -1;
    public static int c = -1;
    public static int d = -1;
    public static int e = -1;
    public static int f = -1;

    public static String a(Context context) {
        String a2 = com.baidu.android.pushservice.i.a.a(context, "com.baidu.pushservice.channel_id");
        if (TextUtils.isEmpty(a2)) {
            a2 = com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.channel_id");
            if (TextUtils.isEmpty(a2)) {
                a2 = com.baidu.android.pushservice.c.c.a(context, false);
                if (TextUtils.isEmpty(a2)) {
                    Iterator<String> it = l.n(context).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a2 = com.baidu.android.pushservice.c.d.a(context, it.next());
                        if (!TextUtils.isEmpty(a2)) {
                            a(context, a2, null);
                            break;
                        }
                    }
                }
            }
        }
        return a2;
    }

    public static void a(Context context, int i) {
        if (context == null) {
            return;
        }
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.sd", i);
    }

    public static void a(Context context, long j) {
        if (context == null) {
            return;
        }
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.cst", j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.android.pushservice.i.i.b(context, "com.baidu.pushservice.app_id", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, String str, String str2) {
        com.baidu.android.pushservice.i.a.a(context, "com.baidu.pushservice.channel_id", str);
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.channel_id", str);
        com.baidu.android.pushservice.i.a.a(context, "com.baidu.pushservice.channel_id_new", str2);
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.channel_id_new", str2);
        com.baidu.android.pushservice.c.c.a(context, str, str2);
    }

    public static String b(Context context) {
        String a2 = com.baidu.android.pushservice.i.a.a(context, "com.baidu.pushservice.channel_id_new");
        if (TextUtils.isEmpty(a2)) {
            String a3 = com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.channel_id_new");
            return TextUtils.isEmpty(a3) ? com.baidu.android.pushservice.c.c.a(context, true) : a3;
        }
        return a2;
    }

    public static void b(Context context, long j) {
        if (context == null) {
            return;
        }
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.st", j);
    }

    public static String c(Context context) {
        return com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.app_id");
    }

    public static boolean d(Context context) {
        return context != null && a == 1;
    }

    public static long e(Context context) {
        if (context == null) {
            return 0L;
        }
        return com.baidu.android.pushservice.i.i.b(context, "com.baidu.pushservice.cst");
    }

    public static long f(Context context) {
        long b2 = com.baidu.android.pushservice.i.i.b(context, "com.baidu.pushservice.st");
        if (b2 <= 0) {
            return 86400000L;
        }
        return b2;
    }

    public static boolean g(Context context) {
        return com.baidu.android.pushservice.i.i.b(context, "com.baidu.pushservice.sd", 0) == 1;
    }

    public static boolean h(Context context) {
        if (context == null) {
            return false;
        }
        if (b == -1) {
            b = com.baidu.android.pushservice.i.i.b(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", -1);
        }
        return b == 1;
    }

    public static boolean i(Context context) {
        if (context == null) {
            return false;
        }
        if (d == -1) {
            d = com.baidu.android.pushservice.i.i.b(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", -1);
        }
        return d == 1;
    }

    public static boolean j(Context context) {
        if (context == null) {
            return false;
        }
        if (e == -1) {
            e = com.baidu.android.pushservice.i.i.b(context, "com.baidu.android.pushservice.PushSettings.op_proxy_mode", -1);
        }
        return e == 1;
    }

    public static boolean k(Context context) {
        if (context == null) {
            return false;
        }
        if (f == -1) {
            f = com.baidu.android.pushservice.i.i.b(context, "com.baidu.android.pushservice.PushSettings.vi_proxy_mode", -1);
        }
        return f == 1;
    }

    public static boolean l(Context context) {
        if (context == null) {
            return false;
        }
        if (c == -1) {
            c = com.baidu.android.pushservice.i.i.b(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", -1);
        }
        return c == 1;
    }
}
