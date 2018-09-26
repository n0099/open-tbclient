package cn.jiguang.d.b;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import cn.jpush.android.service.AlarmReceiver;
import cn.jpush.android.service.PushReceiver;
import cn.jpush.android.service.PushService;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class a {
    public static int a = -1;
    private static String b;

    public static void a(Context context) {
        try {
            cn.jiguang.api.e.a(new c(context), new int[0]);
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, boolean z) {
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context.getApplicationContext(), PushReceiver.class);
            ComponentName componentName2 = new ComponentName(context.getApplicationContext(), AlarmReceiver.class);
            if (z) {
                cn.jiguang.e.c.a("JCoreServiceUtils", "set Push/Alarm Receiver enabled");
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
                packageManager.setComponentEnabledSetting(componentName2, 1, 1);
                cn.jiguang.g.a.k(context.getApplicationContext());
            } else {
                cn.jiguang.e.c.a("JCoreServiceUtils", "set Push/Alarm Receiver disabled");
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
                packageManager.setComponentEnabledSetting(componentName2, 2, 1);
                cn.jiguang.g.a.l(context.getApplicationContext());
                cn.jiguang.g.a.s(context);
            }
        } catch (Throwable th) {
        }
    }

    public static boolean a() {
        return a == 0;
    }

    public static void b() {
        if (!cn.jiguang.g.a.q(cn.jiguang.d.a.d)) {
            a = 0;
        } else if (b(cn.jiguang.d.a.d)) {
            try {
                cn.jiguang.api.e.a(new b(), new int[0]);
            } catch (Throwable th) {
                cn.jiguang.e.c.c("JCoreServiceUtils", "create checkCommonService thread error:" + th);
                a = 1;
            }
        } else {
            try {
                String c = c(cn.jiguang.d.a.d);
                String N = cn.jiguang.g.a.N(cn.jiguang.d.a.d, PushService.class.getCanonicalName());
                if (TextUtils.isEmpty(c) || TextUtils.isEmpty(N) || !c.equals(N)) {
                    return;
                }
                a(cn.jiguang.d.a.d);
            } catch (Throwable th2) {
            }
        }
    }

    public static boolean b(Context context) {
        String c = c(context);
        String packageName = context.getPackageName();
        return (c == null || packageName == null || !packageName.equals(c)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
        cn.jiguang.d.b.a.b = r0.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context) {
        if (TextUtils.isEmpty(b)) {
            try {
                Context X = cn.jiguang.d.a.X(context);
                ActivityManager activityManager = X != null ? (ActivityManager) X.getSystemService(PushConstants.INTENT_ACTIVITY_NAME) : null;
                if (activityManager != null) {
                    int myPid = Process.myPid();
                    Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == myPid) {
                            break;
                        }
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.e.c.c("JCoreServiceUtils", "#unexcepted - getCurProcessName failed:" + th.getMessage());
            }
            return b;
        }
        return b;
    }

    public static boolean c() {
        return a == 1 || a == -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(Context context) {
        int i = 20;
        while (i > 0) {
            try {
            } catch (InterruptedException e) {
                a = 1;
            } catch (Throwable th) {
                a = 1;
            }
            if (new File(context.getFilesDir(), ".servicesaveFile").exists()) {
                a = 1;
                break;
            } else {
                i--;
                Thread.sleep(1000L);
            }
        }
        if (a == -1) {
            a = 0;
            cn.jiguang.api.e.register(cn.jiguang.d.a.d);
        }
    }
}
