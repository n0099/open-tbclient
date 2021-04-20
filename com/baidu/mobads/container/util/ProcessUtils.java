package com.baidu.mobads.container.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.List;
/* loaded from: classes2.dex */
public class ProcessUtils {
    public static final ProcessUtils sProcessUtils = new ProcessUtils();
    public String mCurProcessName;

    public static ProcessUtils getInstance() {
        return sProcessUtils;
    }

    public int getCurrentProcessId() {
        try {
            return Process.myPid();
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getCurrentProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (this.mCurProcessName == null) {
                int myPid = Process.myPid();
                if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == myPid) {
                            this.mCurProcessName = runningAppProcessInfo.processName;
                        }
                    }
                }
            }
            return this.mCurProcessName;
        } catch (Exception unused) {
            return this.mCurProcessName;
        }
    }
}
