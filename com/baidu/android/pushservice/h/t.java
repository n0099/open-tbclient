package com.baidu.android.pushservice.h;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.config.ModeConfig;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class t {
    public static void a(Context context) {
        com.baidu.android.pushservice.e.b.a("ServiceUtils", "--- Start Service from " + context.getPackageName(), context.getApplicationContext());
        if (!com.baidu.android.pushservice.a.b(context)) {
            d(context);
            return;
        }
        b(context);
        com.baidu.android.pushservice.a.a(context, false);
    }

    public static void a(Context context, Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            intent = c(context);
        }
        if (ModeConfig.isProxyMode(context)) {
            com.baidu.android.pushservice.i.a(context).a(intent);
            return;
        }
        String u = u.u(context);
        com.baidu.android.pushservice.e.a.c("ServiceUtils", "package: " + u);
        a(context, intent, u);
    }

    private static void a(Context context, Intent intent, String str) {
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        com.baidu.android.pushservice.e.b.a("ServiceUtils", "startPushService go on pkgName = " + str, context.getApplicationContext());
        try {
            if (!TextUtils.isEmpty(str)) {
                intent.setClassName(str, "com.baidu.android.pushservice.PushService");
                context.startService(intent);
                com.baidu.android.pushservice.e.b.a("ServiceUtils", "startPushService by startService", context.getApplicationContext());
                return;
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.e.b.b("ServiceUtils", "START SERVICE E: " + e, context.getApplicationContext());
        }
        try {
            String c = u.c(context, str, intent.getAction());
            if (!TextUtils.isEmpty(c)) {
                intent.setClassName(str, c);
                context.sendBroadcast(intent);
                com.baidu.android.pushservice.e.b.a("ServiceUtils", "startPushService by sendBroadcast", context.getApplicationContext());
                return;
            }
        } catch (Exception e2) {
            com.baidu.android.pushservice.e.b.b("ServiceUtils", "START SERVICE E-2: " + e2, context.getApplicationContext());
        }
        context.sendBroadcast(intent);
        com.baidu.android.pushservice.e.b.a("ServiceUtils", "startPushService by sendBroadcast all", context.getApplicationContext());
    }

    public static void a(Context context, String str) {
        Intent c = c(context);
        if (u.E(context)) {
            c.putExtra(PushConstants.EXTRA_METHOD, "pushservice_restart_v3");
            if (!TextUtils.isEmpty(str) && str.equals(context.getPackageName())) {
                c.putExtra("priority3", Long.MAX_VALUE);
            }
        } else {
            c.putExtra(PushConstants.EXTRA_METHOD, "pushservice_restart_v2");
            if (!TextUtils.isEmpty(str) && str.equals(context.getPackageName())) {
                c.putExtra("priority2", Long.MAX_VALUE);
            }
        }
        a(context, c, str);
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        String t = u.t(context);
        long g = u.g(context, t);
        if (!TextUtils.isEmpty(t) && !t.equals(context.getPackageName()) && ((ModeConfig.getInstance(context).getCurrentMode() != ModeConfig.MODE_C_C && g < u.h(context)) || ModeConfig.getInstance(context).getCurrentMode() == ModeConfig.MODE_C_H)) {
            a(context, t);
        } else if (TextUtils.isEmpty(t) || t.equals(context.getPackageName())) {
            List<String> q = u.q(context);
            if (q.isEmpty()) {
                return;
            }
            for (String str : q) {
                if (!context.getPackageName().equals(str) && ((u.E(context) && u.y(context, str)) || (!u.E(context) && !u.y(context, str)))) {
                    a(context, str);
                }
            }
        }
    }

    public static void b(Context context, Intent intent) {
        a(context, intent, context.getPackageName());
    }

    public static Intent c(Context context) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.addFlags(32);
        try {
            intent.putExtra(PushConstants.PACKAGE_NAME, context.getPackageName());
            intent.putExtra("method_version", "V2");
            if (u.E(context)) {
                intent.putExtra("priority3", u.h(context));
            } else {
                intent.putExtra("priority2", u.h(context));
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.a("ServiceUtils", e);
        }
        return intent;
    }

    public static void d(Context context) {
        ModeConfig.getInstance(context).refreshMode();
        if (ModeConfig.isProxyMode(context)) {
            com.baidu.android.pushservice.e.a.c("ServiceUtils", "proxy mode, quit checkAndStartPushService");
            return;
        }
        String t = u.t(context);
        final String u = u.u(context);
        com.baidu.android.pushservice.e.a.c("ServiceUtils", "curPkg in checkAndStartPushService: " + t + " highest: " + u);
        if (TextUtils.isEmpty(t) || !t.equals(u)) {
            com.baidu.android.pushservice.e.a.c("ServiceUtils", "curPkg in checkAndStartPushService: " + t);
            a(context, t);
        }
        final Context applicationContext = context.getApplicationContext();
        com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("checkAndStartPushService", (short) 98) { // from class: com.baidu.android.pushservice.h.t.1
            /* JADX WARN: Code restructure failed: missing block: B:33:0x00c5, code lost:
                r5 = com.baidu.android.pushservice.i.c.a("netstat -ant", null).iterator();
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x00d0, code lost:
                r3 = false;
             */
            /* JADX WARN: Code restructure failed: missing block: B:36:0x00d5, code lost:
                if (r5.hasNext() == false) goto L70;
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:0x00d7, code lost:
                r0 = r5.next();
             */
            /* JADX WARN: Code restructure failed: missing block: B:38:0x00dd, code lost:
                if (r3 == false) goto L50;
             */
            /* JADX WARN: Code restructure failed: missing block: B:39:0x00df, code lost:
                r1 = r3;
             */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x00ec, code lost:
                if (r0.toUpperCase().contains("ESTABLISHED") == false) goto L67;
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x00f8, code lost:
                if (r0.contains(java.lang.String.valueOf(com.baidu.android.pushservice.h.a)) == false) goto L54;
             */
            /* JADX WARN: Code restructure failed: missing block: B:44:0x00fa, code lost:
                r3 = true;
             */
            /* JADX WARN: Code restructure failed: missing block: B:45:0x00fc, code lost:
                r6 = com.baidu.android.pushservice.h.c;
                r7 = r6.length;
                r4 = 0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x0100, code lost:
                if (r4 >= r7) goto L63;
             */
            /* JADX WARN: Code restructure failed: missing block: B:48:0x0108, code lost:
                if (r0.contains(r6[r4]) == false) goto L58;
             */
            /* JADX WARN: Code restructure failed: missing block: B:49:0x010a, code lost:
                r0 = true;
             */
            /* JADX WARN: Code restructure failed: missing block: B:50:0x010b, code lost:
                r3 = r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:51:0x010d, code lost:
                r4 = r4 + 1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:53:0x0111, code lost:
                com.baidu.android.pushservice.e.b.b("ServiceUtils", r0.getMessage(), r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x011e, code lost:
                r0 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:55:0x011f, code lost:
                r1 = r3;
             */
            /* JADX WARN: Code restructure failed: missing block: B:56:0x0121, code lost:
                r0 = r3;
             */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
            @Override // com.baidu.android.pushservice.g.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void a() {
                boolean z;
                boolean z2 = false;
                try {
                    List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) applicationContext.getSystemService("activity")).getRunningServices(1000);
                    if (u.E(applicationContext)) {
                        if (u.q(applicationContext).contains(u)) {
                            for (String str : com.baidu.android.pushservice.i.c.a("netstat -ant", null)) {
                                if (str.toUpperCase().contains("ESTABLISHED") && str.contains(String.valueOf(com.baidu.android.pushservice.h.b))) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        z = false;
                        z2 = z;
                    } else if (!TextUtils.isEmpty(u) && runningServices != null && !runningServices.isEmpty()) {
                        Iterator<ActivityManager.RunningServiceInfo> it = runningServices.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ActivityManager.RunningServiceInfo next = it.next();
                            String packageName = next.service.getPackageName();
                            if (next.service.getClassName().equals("com.baidu.android.pushservice.PushService") && u.equals(packageName)) {
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    e = e;
                }
                com.baidu.android.pushservice.e.b.a("ServiceUtils", "checkAndStartPushService, running is " + z2, applicationContext.getApplicationContext());
                if (!z2) {
                    t.a(applicationContext, new Intent());
                }
                t.e(applicationContext);
            }
        });
    }

    public static void e(Context context) {
        boolean z;
        try {
            if (u.E(context)) {
                List<String> q = u.q(context);
                List<ResolveInfo> m = u.m(context.getApplicationContext());
                Iterator<ResolveInfo> it = m.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (q.contains(it.next().activityInfo.packageName)) {
                            z = true;
                            com.baidu.android.pushservice.e.a.c("ServiceUtils", "V2 version SDK is running!");
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    return;
                }
                com.baidu.android.pushservice.e.a.c("ServiceUtils", "V2 version SDK is not  running!  start V2 VERSION  SDK !");
                for (ResolveInfo resolveInfo : m) {
                    a(context, new Intent(), resolveInfo.activityInfo.packageName);
                }
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.a("ServiceUtils", e);
        }
    }
}
