package com.baidu.ar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public final class DeviceSupportAbility {
    private DeviceSupportAbility() {
    }

    public static String getBlacklistParams(Context context, String str) {
        return com.baidu.ar.i.e.a(context, str);
    }

    public static boolean hasNougat() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static int isSupportSensor(Context context) {
        int i = ((SensorManager) context.getSystemService("sensor")).getSensorList(4).size() > 0 ? 1 : 0;
        return ((SensorManager) context.getSystemService("sensor")).getSensorList(11).size() > 0 ? i | 2 : i;
    }

    public static boolean isSupportTrackAr(Context context) {
        return true;
    }
}
