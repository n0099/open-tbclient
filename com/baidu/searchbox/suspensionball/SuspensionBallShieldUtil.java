package com.baidu.searchbox.suspensionball;

import android.app.Activity;
/* loaded from: classes18.dex */
public class SuspensionBallShieldUtil {
    public static void hideSuspensionBall(Activity activity) {
        setActivityHideAllMark(activity);
    }

    public static void resetSuspensionBall(Activity activity) {
        removeActivityHideAllMark(activity);
    }

    private static void setActivityHideAllMark(Activity activity) {
        if (SuspensionBallManager.getInstance().isInit()) {
            SuspensionBallShowHelper.getInstance().setActivityHideAllMark(activity);
            SuspensionBallManager.getInstance().hideAllSuspensionBall();
        }
    }

    private static void removeActivityHideAllMark(Activity activity) {
        if (SuspensionBallManager.getInstance().isInit()) {
            SuspensionBallShowHelper.getInstance().removeActivityHideAllMark(activity);
            SuspensionBallShowHelper.getInstance().onResume(activity);
        }
    }
}
