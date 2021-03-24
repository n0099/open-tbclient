package com.baidu.android.util.devices;

import android.app.Activity;
import com.baidu.android.util.devices.DeviceUtil;
@Deprecated
/* loaded from: classes2.dex */
public final class SamsungSpecialHandler {
    public static final boolean DEBUG = false;
    public static final String TAG = "SamsungSpecialHandler";

    public static boolean beforeCheck() {
        return DeviceUtil.OSInfo.hasLollipop();
    }

    public static void removeSumsungRList(Activity activity) {
        if (beforeCheck()) {
            try {
                System.currentTimeMillis();
                activity.deleteFile("rList-" + activity.getClass().getName());
            } catch (Exception unused) {
            }
        }
    }
}
