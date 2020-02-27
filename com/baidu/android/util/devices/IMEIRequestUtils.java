package com.baidu.android.util.devices;

import android.annotation.SuppressLint;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes12.dex */
public class IMEIRequestUtils {
    private IMEIRequestUtils() {
    }

    @SuppressLint({"MissingPermission"})
    public static String getIMEI(String str) {
        String str2;
        if (AppRuntime.getAppContext() != null) {
            if (!DeviceUtil.OSInfo.hasMarshMallow() || AppRuntime.getAppContext().checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
                    if (telephonyManager == null) {
                        str2 = null;
                    } else {
                        str2 = telephonyManager.getDeviceId();
                    }
                    return !TextUtils.isEmpty(str2) ? str2 : str;
                } catch (Exception e) {
                    return str;
                }
            }
            return str;
        }
        return str;
    }
}
