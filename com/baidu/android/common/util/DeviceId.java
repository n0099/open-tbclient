package com.baidu.android.common.util;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
/* loaded from: classes.dex */
public final class DeviceId {
    private DeviceId() {
    }

    public static String getDeviceID(Context context) {
        TelephonyManager telephonyManager;
        String str;
        String str2;
        String str3 = "";
        if (((TelephonyManager) context.getSystemService("phone")) != null) {
            str3 = "" + telephonyManager.getDeviceId();
            if ("000000000000000".equals(str3)) {
                str = "" + telephonyManager.getLine1Number();
                str2 = str3;
                return Util.toMd5((str2 + ("" + Settings.Secure.getString(context.getContentResolver(), "android_id")) + str).getBytes(), false);
            }
        }
        str = "";
        str2 = str3;
        return Util.toMd5((str2 + ("" + Settings.Secure.getString(context.getContentResolver(), "android_id")) + str).getBytes(), false);
    }
}
