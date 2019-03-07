package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.l;
import com.baidu.android.pushservice.j.m;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class PushSettings {
    private static int a = -1;
    private static int b = -1;
    private static int c = -1;
    private static int d = -1;
    private static int e = -1;

    public static String a(Context context) {
        String a2 = com.baidu.android.pushservice.j.a.a(context, "com.baidu.pushservice.channel_id");
        if (TextUtils.isEmpty(a2)) {
            String a3 = com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.channel_id");
            if (TextUtils.isEmpty(a3)) {
                String a4 = com.baidu.android.pushservice.d.c.a(context, false);
                if (TextUtils.isEmpty(a4)) {
                    String str = a4;
                    for (ResolveInfo resolveInfo : m.F(context) ? m.o(context.getApplicationContext()) : m.n(context.getApplicationContext())) {
                        str = com.baidu.android.pushservice.d.d.a(context, resolveInfo.activityInfo.packageName);
                        if (!TextUtils.isEmpty(str)) {
                            a(context, str, null);
                            return str;
                        }
                    }
                    return str;
                }
                return a4;
            }
            return a3;
        }
        return a2;
    }

    public static void a(Context context, int i) {
        if (context == null) {
            return;
        }
        com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.sd", i);
    }

    public static void a(Context context, long j) {
        if (context == null) {
            return;
        }
        com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.cst", j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.app_id", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, String str, String str2) {
        com.baidu.android.pushservice.j.a.a(context, "com.baidu.pushservice.channel_id", str);
        com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.channel_id", str);
        com.baidu.android.pushservice.j.a.a(context, "com.baidu.pushservice.channel_id_new", str2);
        com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.channel_id_new", str2);
        com.baidu.android.pushservice.d.c.a(context, str, str2);
    }

    public static void a(Context context, boolean z) {
        String[] split;
        int i;
        boolean z2 = false;
        if (context == null || TextUtils.isEmpty(context.getPackageName())) {
            return;
        }
        String a2 = com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.le");
        if (TextUtils.isEmpty(a2)) {
            if (z) {
                com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.le", context.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : a2.trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (str.equals(context.getPackageName())) {
                z2 = true;
                i = z ? 0 : i + 1;
            }
            sb.append(str + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (!z2) {
            sb.append(context.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.le", sb.toString());
    }

    public static String b(Context context) {
        String a2 = com.baidu.android.pushservice.j.a.a(context, "com.baidu.pushservice.channel_id_new");
        if (TextUtils.isEmpty(a2)) {
            String a3 = com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.channel_id_new");
            return TextUtils.isEmpty(a3) ? com.baidu.android.pushservice.d.c.a(context, true) : a3;
        }
        return a2;
    }

    public static void b(Context context, long j) {
        if (context == null) {
            return;
        }
        com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.st", j);
    }

    public static void b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.le");
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String[] split = a2.trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        for (String str2 : split) {
            if (!str2.equals(str)) {
                sb.append(str2 + Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.le", sb.toString());
    }

    private static void b(Context context, boolean z) {
        try {
            String packageName = context.getPackageName();
            String v = m.v(context);
            if (TextUtils.isEmpty(v) || packageName.equals(v)) {
                return;
            }
            l.a(context, new Intent(z ? "com.baidu.android.pushservice.action.OPENDEBUGMODE" : "com.baidu.android.pushservice.action.CLOSEDEBUGMODE"));
        } catch (Exception e2) {
        }
    }

    public static String c(Context context) {
        return com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.app_id");
    }

    public static boolean d(Context context) {
        return context != null && a == 1;
    }

    public static long e(Context context) {
        if (context == null) {
            return 0L;
        }
        return com.baidu.android.pushservice.j.j.b(context, "com.baidu.pushservice.cst");
    }

    public static void enableDebugMode(Context context, boolean z) {
        a = z ? 1 : 0;
        if (com.baidu.android.pushservice.c.e.h(context)) {
            return;
        }
        b(context, z);
    }

    public static long f(Context context) {
        long b2 = com.baidu.android.pushservice.j.j.b(context, "com.baidu.pushservice.st");
        if (b2 <= 0) {
            return 86400000L;
        }
        return b2;
    }

    public static boolean g(Context context) {
        return com.baidu.android.pushservice.j.j.b(context, "com.baidu.pushservice.sd", 0) == 1;
    }

    public static void h(Context context) {
        if (context == null) {
        }
        com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.lms", "off");
    }

    public static void i(Context context) {
        if (context == null) {
        }
        com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.lms", "");
    }

    public static void j(Context context) {
        if (context == null) {
            return;
        }
        String a2 = com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.le");
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String[] split = a2.trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        PackageManager packageManager = context.getPackageManager();
        for (String str : split) {
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo(str, 0);
            } catch (Exception e2) {
            }
            if (packageInfo != null) {
                sb.append(str + Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.le", sb.toString());
    }

    public static boolean k(Context context) {
        if (context == null) {
            return false;
        }
        if (b == -1) {
            b = com.baidu.android.pushservice.j.j.b(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", -1);
        }
        return b == 1;
    }

    public static boolean l(Context context) {
        if (context == null) {
            return false;
        }
        if (d == -1) {
            d = com.baidu.android.pushservice.j.j.b(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", -1);
        }
        return d == 1;
    }

    public static boolean m(Context context) {
        if (context == null) {
            return false;
        }
        if (e == -1) {
            e = com.baidu.android.pushservice.j.j.b(context, "com.baidu.android.pushservice.PushSettings.op_proxy_mode", -1);
        }
        return e == 1;
    }

    public static boolean n(Context context) {
        if (context == null) {
            return false;
        }
        if (c == -1) {
            c = com.baidu.android.pushservice.j.j.b(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", -1);
        }
        return c == 1;
    }
}
