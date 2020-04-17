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

    public static String Y(Context context) {
        ActivityManager.RunningAppProcessInfo aa;
        if (TextUtils.isEmpty(sProcessName) && (aa = aa(context)) != null) {
            sProcessName = aa.processName;
        }
        return sProcessName;
    }

    public static boolean Z(Context context) {
        String Y = Y(context);
        return Y != null && Y.equals("com.baidu.browser.apps");
    }

    public static ActivityManager.RunningAppProcessInfo aa(Context context) {
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
