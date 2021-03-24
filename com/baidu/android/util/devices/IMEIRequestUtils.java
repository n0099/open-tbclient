package com.baidu.android.util.devices;

import android.annotation.SuppressLint;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
@Deprecated
/* loaded from: classes2.dex */
public class IMEIRequestUtils {
    @SuppressLint({"MissingPermission"})
    public static String getIMEI(String str) {
        if (AppRuntime.getAppContext() == null) {
            return str;
        }
        if (!DeviceUtil.OSInfo.hasMarshMallow() || AppRuntime.getAppContext().checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
                String deviceId = telephonyManager != null ? telephonyManager.getDeviceId() : null;
                return TextUtils.isEmpty(deviceId) ? str : deviceId;
            } catch (Exception unused) {
                return str;
            }
        }
        return str;
    }
}
