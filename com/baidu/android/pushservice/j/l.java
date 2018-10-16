package com.baidu.android.pushservice.j;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.webkit.internal.GlobalConstants;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class l {
    private static String a = null;

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
        if (com.baidu.android.pushservice.c.e.h(context)) {
            com.baidu.android.pushservice.i.a(context).a(intent);
            return;
        }
        if (TextUtils.isEmpty(a) || context.getPackageName().equals(a)) {
            a = m.v(context);
        }
        a(context, intent, a);
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
        if (m.G(context) || !m.i(context, str)) {
            return;
        }
        try {
            String c = m.c(context, str, intent.getAction());
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
        if (m.F(context)) {
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
        String u = m.u(context);
        long g = m.g(context, u);
        if (!TextUtils.isEmpty(u) && !u.equals(context.getPackageName()) && ((com.baidu.android.pushservice.c.e.a(context).b() != 4 && g < m.h(context)) || com.baidu.android.pushservice.c.e.a(context).b() == 3)) {
            a(context, u);
        } else if (TextUtils.isEmpty(u) || u.equals(context.getPackageName())) {
            List<String> r = m.r(context);
            if (r.isEmpty()) {
                return;
            }
            for (String str : r) {
                if (!context.getPackageName().equals(str) && ((m.F(context) && m.z(context, str)) || (!m.F(context) && !m.z(context, str)))) {
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
            if (m.F(context)) {
                intent.putExtra("priority3", m.h(context));
            } else {
                intent.putExtra("priority2", m.h(context));
            }
        } catch (Exception e) {
        }
        return intent;
    }

    public static void d(Context context) {
        com.baidu.android.pushservice.c.e.a(context).e();
        if (com.baidu.android.pushservice.c.e.h(context)) {
            return;
        }
        String u = m.u(context);
        String packageName = context.getPackageName();
        a = m.v(context);
        boolean z = false;
        if (!GlobalConstants.SEARCHBOX_PACKAGE_NAME.equals(packageName) || packageName.equals(a)) {
            packageName = u;
        } else {
            z = true;
        }
        com.baidu.android.pushservice.a.c(context, z);
        if (TextUtils.isEmpty(packageName) || !packageName.equals(a) || z) {
            a(context, packageName);
        }
        final Context applicationContext = context.getApplicationContext();
        com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("checkAndStartPushService", (short) 98) { // from class: com.baidu.android.pushservice.j.l.1
            /* JADX WARN: Code restructure failed: missing block: B:33:0x00cd, code lost:
                r5 = com.baidu.android.pushservice.k.c.a("netstat -ant", null).iterator();
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x00d9, code lost:
                r3 = false;
             */
            /* JADX WARN: Code restructure failed: missing block: B:36:0x00de, code lost:
                if (r5.hasNext() == false) goto L70;
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:0x00e0, code lost:
                r0 = r5.next();
             */
            /* JADX WARN: Code restructure failed: missing block: B:38:0x00e6, code lost:
                if (r3 == false) goto L50;
             */
            /* JADX WARN: Code restructure failed: missing block: B:39:0x00e8, code lost:
                r2 = r3;
             */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x00f6, code lost:
                if (r0.toUpperCase().contains("ESTABLISHED") == false) goto L67;
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x0102, code lost:
                if (r0.contains(java.lang.String.valueOf(com.baidu.android.pushservice.h.a)) == false) goto L54;
             */
            /* JADX WARN: Code restructure failed: missing block: B:44:0x0104, code lost:
                r3 = true;
             */
            /* JADX WARN: Code restructure failed: missing block: B:45:0x0106, code lost:
                r6 = com.baidu.android.pushservice.h.c;
                r7 = r6.length;
                r4 = 0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x010a, code lost:
                if (r4 >= r7) goto L63;
             */
            /* JADX WARN: Code restructure failed: missing block: B:48:0x0112, code lost:
                if (r0.contains(r6[r4]) == false) goto L58;
             */
            /* JADX WARN: Code restructure failed: missing block: B:49:0x0114, code lost:
                r0 = true;
             */
            /* JADX WARN: Code restructure failed: missing block: B:50:0x0115, code lost:
                r3 = r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:51:0x0117, code lost:
                r4 = r4 + 1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:53:0x011b, code lost:
                com.baidu.android.pushservice.g.a.b("ServiceUtils", r0.getMessage(), r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x0129, code lost:
                r0 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:55:0x012a, code lost:
                r2 = r3;
             */
            /* JADX WARN: Code restructure failed: missing block: B:56:0x012c, code lost:
                r0 = r3;
             */
            /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
            @Override // com.baidu.android.pushservice.i.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void a() {
                boolean z2;
                boolean z3 = false;
                try {
                    if (m.F(applicationContext)) {
                        if (m.r(applicationContext).contains(l.a)) {
                            for (String str : com.baidu.android.pushservice.k.c.a("netstat -ant", null)) {
                                if (str.toUpperCase().contains("ESTABLISHED") && str.contains(String.valueOf(com.baidu.android.pushservice.h.b))) {
                                    z2 = true;
                                    break;
                                }
                            }
                        }
                        z2 = false;
                        z3 = z2;
                    } else {
                        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) applicationContext.getSystemService(com.meizu.cloud.pushsdk.constants.PushConstants.INTENT_ACTIVITY_NAME)).getRunningServices(500);
                        if (!TextUtils.isEmpty(l.a) && runningServices != null && !runningServices.isEmpty()) {
                            Iterator<ActivityManager.RunningServiceInfo> it = runningServices.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ActivityManager.RunningServiceInfo next = it.next();
                                String packageName2 = next.service.getPackageName();
                                if (next.service.getClassName().equals("com.baidu.android.pushservice.PushService") && l.a.equals(packageName2)) {
                                    break;
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e = e;
                }
                com.baidu.android.pushservice.g.a.a("ServiceUtils", "checkAndStartPushService, running is " + z3, applicationContext);
                if (!z3) {
                    l.a(applicationContext, new Intent());
                }
                l.e(applicationContext);
            }
        });
    }

    public static void e(Context context) {
        boolean z;
        try {
            if (m.F(context)) {
                List<String> r = m.r(context);
                List<ResolveInfo> n = m.n(context.getApplicationContext());
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
