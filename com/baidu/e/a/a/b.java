package com.baidu.e.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
/* loaded from: classes13.dex */
public class b {
    private static int UK = 0;
    private static boolean UL = false;
    private static boolean UM = false;

    public static int pg() {
        try {
            return Integer.valueOf(Build.VERSION.SDK).intValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String getIMEI(Context context) {
        try {
            if (context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId == null) {
                    return "";
                }
                return deviceId;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
