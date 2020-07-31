package com.baidu.browser.core.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;
/* loaded from: classes10.dex */
public final class c {
    private static String sProcessName = null;

    public static String N(Context context) {
        ActivityManager.RunningAppProcessInfo P;
        if (TextUtils.isEmpty(sProcessName) && (P = P(context)) != null) {
            sProcessName = P.processName;
        }
        return sProcessName;
    }

    public static boolean O(Context context) {
        String N = N(context);
        return N != null && N.equals("com.baidu.browser.apps");
    }

    public static ActivityManager.RunningAppProcessInfo P(Context context) {
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
