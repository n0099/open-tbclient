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

    public static String getCurProcessName(Context context) {
        ActivityManager.RunningAppProcessInfo S;
        if (TextUtils.isEmpty(sProcessName) && (S = S(context)) != null) {
            sProcessName = S.processName;
        }
        return sProcessName;
    }

    public static boolean R(Context context) {
        String curProcessName = getCurProcessName(context);
        return curProcessName != null && curProcessName.equals("com.baidu.browser.apps");
    }

    public static ActivityManager.RunningAppProcessInfo S(Context context) {
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
