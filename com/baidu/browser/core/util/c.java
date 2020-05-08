package com.baidu.browser.core.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;
/* loaded from: classes11.dex */
public final class c {
    private static String sProcessName = null;

    public static String L(Context context) {
        ActivityManager.RunningAppProcessInfo N;
        if (TextUtils.isEmpty(sProcessName) && (N = N(context)) != null) {
            sProcessName = N.processName;
        }
        return sProcessName;
    }

    public static boolean M(Context context) {
        String L = L(context);
        return L != null && L.equals("com.baidu.browser.apps");
    }

    public static ActivityManager.RunningAppProcessInfo N(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }
}
