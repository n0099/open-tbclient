package com.baidu.android.util.devices;

import android.app.Activity;
import com.baidu.android.util.devices.DeviceUtil;
@Deprecated
/* loaded from: classes6.dex */
public final class SamsungSpecialHandler {
    private static final boolean DEBUG = false;
    private static final String TAG = "SamsungSpecialHandler";

    private SamsungSpecialHandler() {
    }

    private static boolean beforeCheck() {
        if (DeviceUtil.OSInfo.hasLollipop()) {
            return true;
        }
        return false;
    }

    public static void removeSumsungRList(Activity activity) {
        if (beforeCheck()) {
            try {
                System.currentTimeMillis();
                if (activity.deleteFile("rList-" + activity.getClass().getName())) {
                }
            } catch (Exception e) {
            }
        }
    }
}
