package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.pushservice.config.ModeConfig;
import com.baidu.android.pushservice.h.m;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.h.r;
import com.baidu.android.pushservice.h.t;
import com.baidu.android.pushservice.h.u;
/* loaded from: classes2.dex */
public class PushSettings {
    private static int a = -1;
    private static int b = -1;
    private static int c = -1;

    public static String a(Context context) {
        String a2 = com.baidu.android.pushservice.h.b.a(context, "com.baidu.pushservice.channel_id");
        if (TextUtils.isEmpty(a2)) {
            String a3 = m.a(context, "com.baidu.pushservice.channel_id");
            if (TextUtils.isEmpty(a3)) {
                String d = q.d(context);
                if (TextUtils.isEmpty(d)) {
                    String str = d;
                    for (ResolveInfo resolveInfo : u.E(context) ? u.n(context.getApplicationContext()) : u.m(context.getApplicationContext())) {
                        str = r.a(context, resolveInfo.activityInfo.packageName);
                        if (!TextUtils.isEmpty(str)) {
                            a(context, str);
                            return str;
                        }
                    }
                    return str;
                }
                return d;
            }
            return a3;
        }
        return a2;
    }

    public static void a(Context context, int i) {
        if (context == null) {
            com.baidu.android.pushservice.e.a.d("PushSettings", "setStatisticSendDisabled mContext == null");
        } else {
            m.a(context, "com.baidu.pushservice.sd", i);
        }
    }

    public static void a(Context context, long j) {
        if (context == null) {
            com.baidu.android.pushservice.e.a.d("PushSettings", "setLastSendStatisticTime mContext == null");
        } else {
            m.a(context, "com.baidu.pushservice.cst", j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, String str) {
        com.baidu.android.pushservice.h.b.a(context, "com.baidu.pushservice.channel_id", str);
        m.a(context, "com.baidu.pushservice.channel_id", str);
        q.a(context, str);
    }

    public static void a(Context context, boolean z) {
        String[] split;
        int i;
        boolean z2 = false;
        if (context == null) {
            com.baidu.android.pushservice.e.a.d("PushSettings", "setLbsEnabled mContext == null");
        } else if (TextUtils.isEmpty(context.getPackageName())) {
            com.baidu.android.pushservice.e.a.d("PushSettings", "mContext.getPackageName() == null");
        } else {
            String a2 = m.a(context, "com.baidu.pushservice.le");
            if (TextUtils.isEmpty(a2)) {
                if (z) {
                    m.a(context, "com.baidu.pushservice.le", context.getPackageName() + ",");
                    return;
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str : a2.trim().split(",")) {
                if (str.equals(context.getPackageName())) {
                    z2 = true;
                    i = z ? 0 : i + 1;
                }
                sb.append(str + ",");
            }
            if (!z2) {
                sb.append(context.getPackageName() + ",");
            }
            m.a(context, "com.baidu.pushservice.le", sb.toString());
        }
    }

    public static String b(Context context) {
        return m.a(context, "com.baidu.pushservice.app_id");
    }

    public static void b(Context context, int i) {
        if (context == null) {
            com.baidu.android.pushservice.e.a.d("PushSettings", "setCurPeriod mContext == null");
        } else {
            m.a(context, "com.baidu.pushservice.lsi", i * 1000);
        }
    }

    public static void b(Context context, long j) {
        if (context == null) {
            com.baidu.android.pushservice.e.a.d("PushSettings", "setLastSendStatisticTime mContext == null");
        } else {
            m.a(context, "com.baidu.pushservice.st", j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m.a(context, "com.baidu.pushservice.app_id", str);
    }

    private static void b(Context context, boolean z) {
        try {
            String packageName = context.getPackageName();
            String u = u.u(context);
            if (TextUtils.isEmpty(u) || packageName.equals(u)) {
                return;
            }
            t.a(context, new Intent(z ? "com.baidu.android.pushservice.action.OPENDEBUGMODE" : "com.baidu.android.pushservice.action.CLOSEDEBUGMODE"));
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.a("PushSettings", e);
        }
    }

    public static void c(Context context, String str) {
        if (context == null) {
            com.baidu.android.pushservice.e.a.d("PushSettings", "removeUninstalledAppLbsSwitch mContext == null");
        } else if (!TextUtils.isEmpty(str)) {
            String a2 = m.a(context, "com.baidu.pushservice.le");
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            String[] split = a2.trim().split(",");
            for (String str2 : split) {
                if (!str2.equals(str)) {
                    sb.append(str2 + ",");
                }
            }
            m.a(context, "com.baidu.pushservice.le", sb.toString());
        }
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        if (a == -1) {
            a = m.d(context, "com.baidu.android.pushservice.PushSettings.debug_mode", -1);
        }
        return a == 1;
    }

    public static long d(Context context) {
        if (context == null) {
            com.baidu.android.pushservice.e.a.e("PushSettings", "getLastSendStatisticTime mContext == null");
            return 0L;
        }
        return m.c(context, "com.baidu.pushservice.cst");
    }

    public static long e(Context context) {
        long c2 = m.c(context, "com.baidu.pushservice.st");
        if (c2 <= 0) {
            return 43200000L;
        }
        return c2;
    }

    public static void enableDebugMode(Context context, boolean z) {
        if (z) {
            m.c(context, "com.baidu.android.pushservice.PushSettings.debug_mode", 1);
        } else {
            m.c(context, "com.baidu.android.pushservice.PushSettings.debug_mode", 0);
        }
        if (ModeConfig.isProxyMode(context)) {
            return;
        }
        b(context, z);
    }

    public static boolean f(Context context) {
        return m.b(context, "com.baidu.pushservice.sd", 0) == 1;
    }

    public static int g(Context context) {
        if (context == null) {
            com.baidu.android.pushservice.e.a.e("PushSettings", "getLbsSendInterval mContext == null");
            return 0;
        }
        int b2 = m.b(context, "com.baidu.pushservice.lsi", -1);
        if (b2 < 0) {
            return 1800000;
        }
        return b2;
    }

    public static boolean h(Context context) {
        return !TextUtils.isEmpty(m.a(context, "com.baidu.pushservice.le"));
    }

    public static boolean i(Context context) {
        return TextUtils.equals(m.a(context, "com.baidu.pushservice.lms"), "off");
    }

    public static void j(Context context) {
        if (context == null) {
            com.baidu.android.pushservice.e.a.d("PushSettings", "tofms mContext == null");
        }
        m.a(context, "com.baidu.pushservice.lms", "off");
    }

    public static void k(Context context) {
        if (context == null) {
            com.baidu.android.pushservice.e.a.d("PushSettings", "toms mContext == null");
        }
        m.a(context, "com.baidu.pushservice.lms", "");
    }

    public static void l(Context context) {
        if (context == null) {
            com.baidu.android.pushservice.e.a.d("PushSettings", "refreshLbsSwitchInfo mContext == null");
            return;
        }
        String a2 = m.a(context, "com.baidu.pushservice.le");
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String[] split = a2.trim().split(",");
        PackageManager packageManager = context.getPackageManager();
        for (String str : split) {
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.android.pushservice.e.a.d("PushSettings", com.baidu.android.pushservice.e.a.a(e));
            }
            if (packageInfo != null) {
                sb.append(str + ",");
            }
        }
        m.a(context, "com.baidu.pushservice.le", sb.toString());
    }

    public static boolean m(Context context) {
        if (context == null) {
            return false;
        }
        if (b == -1) {
            b = m.b(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", -1);
        }
        return b == 1;
    }

    public static boolean n(Context context) {
        if (context == null) {
            return false;
        }
        if (c == -1) {
            c = m.b(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", -1);
        }
        return c == 1;
    }
}
