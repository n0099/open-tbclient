package com.baidu.searchbox.support.v4.app;

import android.app.ActivityManager;
/* loaded from: classes2.dex */
class ActivityManagerCompatKitKat {
    ActivityManagerCompatKitKat() {
    }

    public static boolean isLowRamDevice(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
