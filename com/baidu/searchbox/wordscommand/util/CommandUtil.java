package com.baidu.searchbox.wordscommand.util;

import android.app.Activity;
/* loaded from: classes4.dex */
public class CommandUtil {
    public static final String LOCKSCREEN_ACTIVITY_CLASS = "LockScreenActivity";
    public static final String LOCKSCREEN_DISMISS_ACTIVITY_CLASS = "LockScreenDismissActivity";
    public static final String LOCKSCREEN_SETTING_ACTIVITY_CLASS = "LockScreenSettingActivity";

    public static boolean isLockScreenSettingsActivity(Activity activity) {
        return activity.getClass().getSimpleName().equals(LOCKSCREEN_SETTING_ACTIVITY_CLASS);
    }
}
