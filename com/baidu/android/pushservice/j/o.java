package com.baidu.android.pushservice.j;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class o {
    public static void a(Context context) {
        com.baidu.android.pushservice.g.a.a("ServiceUtils", "--- Start Service from " + context.getPackageName(), context.getApplicationContext());
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
        if (com.baidu.android.pushservice.c.d.g(context)) {
            com.baidu.android.pushservice.i.a(context).a(intent);
        } else {
            a(context, intent, p.v(context));
        }
    }

    private static void a(Context context, Intent intent, String str) {
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        com.baidu.android.pushservice.g.a.a("ServiceUtils", "startPushService go on pkgName = " + str, context.getApplicationContext());
        try {
            if (!TextUtils.isEmpty(str)) {
                intent.setClassName(str, "com.baidu.android.pushservice.PushService");
                context.startService(intent);
                com.baidu.android.pushservice.g.a.a("ServiceUtils", "startPushService by startService", context.getApplicationContext());
                return;
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.b("ServiceUtils", "START SERVICE E: " + e, context.getApplicationContext());
        }
        if (p.G(context) || !p.i(context, str)) {
            return;
        }
        try {
            String c = p.c(context, str, intent.getAction());
            if (!TextUtils.isEmpty(c)) {
                intent.setClassName(str, c);
                context.sendBroadcast(intent);
                com.baidu.android.pushservice.g.a.a("ServiceUtils", "startPushService by sendBroadcast", context.getApplicationContext());
                return;
            }
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.b("ServiceUtils", "START SERVICE E-2: " + e2, context.getApplicationContext());
        }
        context.sendBroadcast(intent);
        com.baidu.android.pushservice.g.a.a("ServiceUtils", "startPushService by sendBroadcast all", context.getApplicationContext());
    }

    public static void a(Context context, String str) {
        Intent c = c(context);
        if (p.F(context)) {
            c.putExtra("method", "pushservice_restart_v3");
            if (!TextUtils.isEmpty(str) && str.equals(context.getPackageName())) {
                c.putExtra("priority3", Long.MAX_VALUE);
            }
        } else {
            c.putExtra("method", "pushservice_restart_v2");
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
        String u = p.u(context);
        long g = p.g(context, u);
        if (!TextUtils.isEmpty(u) && !u.equals(context.getPackageName()) && ((com.baidu.android.pushservice.c.d.a(context).b() != 4 && g < p.h(context)) || com.baidu.android.pushservice.c.d.a(context).b() == 3)) {
            a(context, u);
        } else if (TextUtils.isEmpty(u) || u.equals(context.getPackageName())) {
            List<String> r = p.r(context);
            if (r.isEmpty()) {
                return;
            }
            for (String str : r) {
                if (!context.getPackageName().equals(str) && ((p.F(context) && p.z(context, str)) || (!p.F(context) && !p.z(context, str)))) {
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
            if (p.F(context)) {
                intent.putExtra("priority3", p.h(context));
            } else {
                intent.putExtra("priority2", p.h(context));
            }
        } catch (Exception e) {
        }
        return intent;
    }

    public static void d(Context context) {
        com.baidu.android.pushservice.c.d.a(context).e();
        if (com.baidu.android.pushservice.c.d.g(context)) {
            return;
        }
        String u = p.u(context);
        final String v = p.v(context);
        if (TextUtils.isEmpty(u) || !u.equals(v)) {
            a(context, u);
        }
        final Context applicationContext = context.getApplicationContext();
        com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("checkAndStartPushService", (short) 98) { // from class: com.baidu.android.pushservice.j.o.1
            /* JADX WARN: Code restructure failed: missing block: B:33:0x00cb, code lost:
                r5 = com.baidu.android.pushservice.k.c.a("netstat -ant", null).iterator();
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x00d7, code lost:
                r3 = false;
             */
            /* JADX WARN: Code restructure failed: missing block: B:36:0x00dc, code lost:
                if (r5.hasNext() == false) goto L70;
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:0x00de, code lost:
                r0 = r5.next();
             */
            /* JADX WARN: Code restructure failed: missing block: B:38:0x00e4, code lost:
                if (r3 == false) goto L50;
             */
            /* JADX WARN: Code restructure failed: missing block: B:39:0x00e6, code lost:
                r1 = r3;
             */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x00f4, code lost:
                if (r0.toUpperCase().contains("ESTABLISHED") == false) goto L67;
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x0100, code lost:
                if (r0.contains(java.lang.String.valueOf(com.baidu.android.pushservice.h.a)) == false) goto L54;
             */
            /* JADX WARN: Code restructure failed: missing block: B:44:0x0102, code lost:
                r3 = true;
             */
            /* JADX WARN: Code restructure failed: missing block: B:45:0x0104, code lost:
                r6 = com.baidu.android.pushservice.h.c;
                r7 = r6.length;
                r4 = 0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x0108, code lost:
                if (r4 >= r7) goto L63;
             */
            /* JADX WARN: Code restructure failed: missing block: B:48:0x0110, code lost:
                if (r0.contains(r6[r4]) == false) goto L58;
             */
            /* JADX WARN: Code restructure failed: missing block: B:49:0x0112, code lost:
                r0 = true;
             */
            /* JADX WARN: Code restructure failed: missing block: B:50:0x0113, code lost:
                r3 = r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:51:0x0115, code lost:
                r4 = r4 + 1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:53:0x0119, code lost:
                com.baidu.android.pushservice.g.a.b("ServiceUtils", r0.getMessage(), r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x0127, code lost:
                r0 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:55:0x0128, code lost:
                r1 = r3;
             */
            /* JADX WARN: Code restructure failed: missing block: B:56:0x012a, code lost:
                r0 = r3;
             */
            /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
            @Override // com.baidu.android.pushservice.i.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void a() {
                boolean z;
                boolean z2 = false;
                try {
                    List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) applicationContext.getSystemService(com.meizu.cloud.pushsdk.constants.PushConstants.INTENT_ACTIVITY_NAME)).getRunningServices(1000);
                    if (p.F(applicationContext)) {
                        if (p.r(applicationContext).contains(v)) {
                            for (String str : com.baidu.android.pushservice.k.c.a("netstat -ant", null)) {
                                if (str.toUpperCase().contains("ESTABLISHED") && str.contains(String.valueOf(com.baidu.android.pushservice.h.b))) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        z = false;
                        z2 = z;
                    } else if (!TextUtils.isEmpty(v) && runningServices != null && !runningServices.isEmpty()) {
                        Iterator<ActivityManager.RunningServiceInfo> it = runningServices.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ActivityManager.RunningServiceInfo next = it.next();
                            String packageName = next.service.getPackageName();
                            if (next.service.getClassName().equals("com.baidu.android.pushservice.PushService") && v.equals(packageName)) {
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    e = e;
                }
                com.baidu.android.pushservice.g.a.a("ServiceUtils", "checkAndStartPushService, running is " + z2, applicationContext.getApplicationContext());
                if (!z2) {
                    o.a(applicationContext, new Intent());
                }
                o.e(applicationContext);
            }
        });
    }

    public static void e(Context context) {
        boolean z;
        try {
            if (p.F(context)) {
                List<String> r = p.r(context);
                List<ResolveInfo> n = p.n(context.getApplicationContext());
                Iterator<ResolveInfo> it = n.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (r.contains(it.next().activityInfo.packageName)) {
                            z = true;
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
                for (ResolveInfo resolveInfo : n) {
                    a(context, new Intent(), resolveInfo.activityInfo.packageName);
                }
            }
        } catch (Exception e) {
        }
    }
}
