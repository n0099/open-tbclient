package com.baidu.browser.core.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;
/* loaded from: classes9.dex */
public final class c {
    private static String sProcessName = null;

    public static String ah(Context context) {
        ActivityManager.RunningAppProcessInfo aj;
        if (TextUtils.isEmpty(sProcessName) && (aj = aj(context)) != null) {
            sProcessName = aj.processName;
        }
        return sProcessName;
    }

    public static boolean ai(Context context) {
        String ah = ah(context);
        return ah != null && ah.equals("com.baidu.browser.apps");
    }

    public static ActivityManager.RunningAppProcessInfo aj(Context context) {
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
