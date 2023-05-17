package com.baidu.live.arch.utils;

import android.os.Build;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class RomUtils {
    public static boolean isMIUIRom() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(com.baidu.android.util.devices.RomUtils.MANUFACTURER_XIAOMI);
    }
}
