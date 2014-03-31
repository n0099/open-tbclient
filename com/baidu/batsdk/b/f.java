package com.baidu.batsdk.b;

import android.app.ActivityManager;
import android.content.Context;
/* loaded from: classes.dex */
public final class f {
    private static Context a;
    private static ActivityManager b;

    public static void a(Context context) {
        a = context;
        b = (ActivityManager) context.getSystemService("activity");
    }

    public static String a() {
        StringBuilder sb = new StringBuilder();
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : b.getRunningAppProcesses()) {
                sb.append(runningAppProcessInfo.processName).append("(").append(runningAppProcessInfo.pid).append(") uid(").append(runningAppProcessInfo.uid).append(")\n");
            }
        } catch (RuntimeException e) {
            com.baidu.batsdk.f.a.b("getAllProcessInfo fail.", e);
        }
        return sb.toString();
    }
}
