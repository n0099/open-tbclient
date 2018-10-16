package com.baidu.searchbox.ng.ai.apps.launch.model;

import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class AiAppsLaunchType {
    public static final String EXTRA_AIAPPS_LAUNCH_FROM = "aiapps_launch_from";
    public static final String EXTRA_AIAPPS_NOT_IN_HISTORY = "aiapps_not_in_history";
    public static final String LAUNCH_FROM_BAIDU_AIAPP_HISTORY = "3101";
    public static final String LAUNCH_FROM_HISTORY = "3001";
    public static final String LAUNCH_FROM_PERSONAL_BANNER_HISTORY = "3005";
    public static final String LAUNCH_FROM_SECOND_FLOOR_HISTORY = "3106";
    public static final String LAUNCH_FROM_SECOND_FLOOR_HISTORY_LIST = "3107";
    public static final String LAUNCH_FROM_SHORTCUT = "3004";
    public static final String LAUNCH_FROM_UNKNOWN = "unknown";
    public static final String LAUNCH_NOT_IN_HISTORY = "1";
    public static final String LUANCH_FROM_RECENT = "8003";

    public static boolean isSpecificLaunchType(AiAppsLaunchInfo aiAppsLaunchInfo, String str) {
        if (aiAppsLaunchInfo == null) {
            return false;
        }
        return TextUtils.equals(aiAppsLaunchInfo.mLaunchFrom, str);
    }

    public static boolean isLaunchFromRecent(Intent intent) {
        return (intent.getFlags() & 1048576) == 1048576;
    }
}
