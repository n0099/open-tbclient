package com.baidu.mobads.container.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
/* loaded from: classes2.dex */
public class SystemUtils {
    public static String getProcessName(Context context) {
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        for (ActivityManager.RunningServiceInfo runningServiceInfo : activityManager.getRunningServices(10)) {
            if (runningServiceInfo.pid == myPid) {
                return runningServiceInfo.process;
            }
        }
        return "";
    }

    public static boolean isAdbEnable(Context context) {
        return 17 <= Build.VERSION.SDK_INT ? 1 == Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) : 1 == Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0);
    }

    public static String getProcessName() {
        try {
            return (String) Class.forName("android.app.ActivityThread").getDeclaredMethod(Build.VERSION.SDK_INT >= 18 ? "currentProcessName" : "currentPackageName", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }
}
