package com.baidu.android.pushservice.i;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.webkit.internal.GlobalConstants;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class k {
    private static String a = null;

    public static void a(Context context) {
        com.baidu.android.pushservice.f.a.a("ServiceUtils", "--- Start Service from " + context.getPackageName(), context.getApplicationContext());
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
        if (com.baidu.android.pushservice.b.d.k(context) && !com.baidu.android.pushservice.b.d.c(context)) {
            com.baidu.android.pushservice.h.a(context).a(intent);
            return;
        }
        if (TextUtils.isEmpty(a) || context.getPackageName().equals(a)) {
            a = l.v(context);
        }
        a(context, intent, a);
    }

    private static void a(Context context, Intent intent, String str) {
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        com.baidu.android.pushservice.f.a.a("ServiceUtils", "startPushService go on pkgName = " + str, context.getApplicationContext());
        try {
            if (!TextUtils.isEmpty(str)) {
                intent.setClassName(str, "com.baidu.android.pushservice.PushService");
                context.startService(intent);
                com.baidu.android.pushservice.f.a.a("ServiceUtils", "startPushService by startService", context.getApplicationContext());
                return;
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.f.a.b("ServiceUtils", "START SERVICE E: " + e, context.getApplicationContext());
        }
        if (com.baidu.android.pushservice.a.a(context.getPackageName()) || l.E(context) || !l.i(context, str)) {
            return;
        }
        try {
            String c = l.c(context, str, intent.getAction());
            if (!TextUtils.isEmpty(c)) {
                intent.setClassName(str, c);
                context.sendBroadcast(intent);
                com.baidu.android.pushservice.f.a.a("ServiceUtils", "startPushService by sendBroadcast", context.getApplicationContext());
                return;
            }
        } catch (Exception e2) {
            com.baidu.android.pushservice.f.a.b("ServiceUtils", "START SERVICE E-2: " + e2, context.getApplicationContext());
        }
        context.sendBroadcast(intent);
        com.baidu.android.pushservice.f.a.a("ServiceUtils", "startPushService by sendBroadcast all", context.getApplicationContext());
    }

    public static void a(Context context, String str) {
        Intent c = c(context);
        if (l.D(context)) {
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
        String u = l.u(context);
        long g = l.g(context, u);
        if (!TextUtils.isEmpty(u) && !u.equals(context.getPackageName()) && ((com.baidu.android.pushservice.b.d.a(context).b() != 4 && g < l.h(context)) || com.baidu.android.pushservice.b.d.a(context).b() == 3)) {
            a(context, u);
        } else if (TextUtils.isEmpty(u) || u.equals(context.getPackageName())) {
            List<String> s = l.s(context);
            if (s.isEmpty()) {
                return;
            }
            for (String str : s) {
                if (!context.getPackageName().equals(str) && ((l.D(context) && l.z(context, str)) || (!l.D(context) && !l.z(context, str)))) {
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
            if (l.D(context)) {
                intent.putExtra("priority3", l.h(context));
            } else {
                intent.putExtra("priority2", l.h(context));
            }
        } catch (Exception e) {
        }
        return intent;
    }

    public static void d(Context context) {
        com.baidu.android.pushservice.b.d.a(context).e();
        if (!com.baidu.android.pushservice.b.d.k(context) || com.baidu.android.pushservice.b.d.c(context)) {
            String u = l.u(context);
            String packageName = context.getPackageName();
            a = l.v(context);
            boolean z = false;
            if (!com.baidu.android.pushservice.a.a(packageName) || packageName.equals(a)) {
                packageName = u;
            } else {
                z = true;
            }
            com.baidu.android.pushservice.a.c(context, z);
            if (TextUtils.isEmpty(packageName) || !packageName.equals(a) || z) {
                a(context, packageName);
            }
            if (context.getPackageName().startsWith(GlobalConstants.SEARCHBOX_PACKAGE_NAME) && !com.baidu.android.pushservice.job.a.b() && !l.l(context) && !com.baidu.android.pushservice.b.d.c(context) && (Build.VERSION.SDK_INT > 22 || (!l.d() && !l.e()))) {
                com.baidu.android.pushservice.job.a.a(context);
                com.baidu.android.pushservice.job.a.a(true);
            }
            if (z && context.getPackageName().startsWith(GlobalConstants.SEARCHBOX_PACKAGE_NAME)) {
                return;
            }
            final Context applicationContext = context.getApplicationContext();
            com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("checkAndStartPushService", (short) 98) { // from class: com.baidu.android.pushservice.i.k.1
                /* JADX WARN: Code restructure failed: missing block: B:35:0x00d9, code lost:
                    r5 = com.baidu.android.pushservice.j.c.a("netstat -ant", null).iterator();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:36:0x00e5, code lost:
                    r3 = false;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:38:0x00ea, code lost:
                    if (r5.hasNext() == false) goto L73;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:39:0x00ec, code lost:
                    r0 = r5.next();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:40:0x00f2, code lost:
                    if (r3 == false) goto L53;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:41:0x00f4, code lost:
                    r2 = r3;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:43:0x0102, code lost:
                    if (r0.toUpperCase().contains("ESTABLISHED") == false) goto L70;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:45:0x010e, code lost:
                    if (r0.contains(java.lang.String.valueOf(com.baidu.android.pushservice.g.a)) == false) goto L57;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:46:0x0110, code lost:
                    r3 = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:47:0x0112, code lost:
                    r6 = com.baidu.android.pushservice.g.c;
                    r7 = r6.length;
                    r4 = 0;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:48:0x0116, code lost:
                    if (r4 >= r7) goto L66;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:50:0x011e, code lost:
                    if (r0.contains(r6[r4]) == false) goto L61;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:51:0x0120, code lost:
                    r0 = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:52:0x0121, code lost:
                    r3 = r0;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:53:0x0123, code lost:
                    r4 = r4 + 1;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:55:0x0127, code lost:
                    com.baidu.android.pushservice.f.a.b("ServiceUtils", r0.getMessage(), r3);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:56:0x0135, code lost:
                    r0 = e;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:57:0x0136, code lost:
                    r2 = r3;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:58:0x0138, code lost:
                    r0 = r3;
                 */
                /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
                /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
                @Override // com.baidu.android.pushservice.h.c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void a() {
                    boolean z2;
                    boolean z3 = false;
                    try {
                        if (l.D(applicationContext)) {
                            if (l.s(applicationContext).contains(k.a)) {
                                for (String str : com.baidu.android.pushservice.j.c.a("netstat -ant", null)) {
                                    if (str.toUpperCase().contains("ESTABLISHED") && str.contains(String.valueOf(com.baidu.android.pushservice.g.b))) {
                                        z2 = true;
                                        break;
                                    }
                                }
                            }
                            z2 = false;
                            z3 = z2;
                        } else {
                            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) applicationContext.getSystemService(com.meizu.cloud.pushsdk.constants.PushConstants.INTENT_ACTIVITY_NAME)).getRunningServices(500);
                            if (!TextUtils.isEmpty(k.a) && runningServices != null && !runningServices.isEmpty()) {
                                Iterator<ActivityManager.RunningServiceInfo> it = runningServices.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    ActivityManager.RunningServiceInfo next = it.next();
                                    String packageName2 = next.service.getPackageName();
                                    if (next.service.getClassName().equals("com.baidu.android.pushservice.PushService") && k.a.equals(packageName2)) {
                                        break;
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                    }
                    com.baidu.android.pushservice.f.a.a("ServiceUtils", "checkAndStartPushService, running is " + z3, applicationContext);
                    if (!z3) {
                        k.a(applicationContext, new Intent());
                    }
                    if (com.baidu.android.pushservice.a.a(applicationContext.getPackageName())) {
                        k.e(applicationContext);
                    }
                }
            });
        }
    }

    public static void e(Context context) {
        boolean z;
        try {
            if (l.D(context)) {
                List<String> s = l.s(context);
                List<ResolveInfo> o = l.o(context.getApplicationContext());
                Iterator<ResolveInfo> it = o.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (s.contains(it.next().activityInfo.packageName)) {
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
                for (ResolveInfo resolveInfo : o) {
                    a(context, new Intent(), resolveInfo.activityInfo.packageName);
                }
            }
        } catch (Exception e) {
        }
    }
}
