package com.baidu.searchbox.common.security;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.searchbox.common.security.ioc.HostAbilityRuntime;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
/* loaded from: classes2.dex */
public class AndroidIDProxy {
    public static String androidId;
    public static volatile boolean hasInvoked;

    @SuppressLint({"HardwareIds"})
    public static DeviceIdBag getAndroidId(Context context) {
        return getAndroidId(context, false);
    }

    public static String realAndroidId(Context context) {
        try {
            return ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
        } catch (Exception unused) {
            return null;
        }
    }

    @SuppressLint({"HardwareIds"})
    public static DeviceIdBag getAndroidId(Context context, boolean z) {
        DeviceIdBag deviceIdBag = new DeviceIdBag();
        if (!HostAbilityRuntime.getHostAbility().hasAgreedPrivacyPolicy()) {
            deviceIdBag.errorCode = -3;
            return deviceIdBag;
        }
        int i = 1;
        if (androidId == null && !hasInvoked) {
            if (!z && !HostAbilityRuntime.getHostAbility().isForeground()) {
                i = -1;
            } else {
                androidId = realAndroidId(context);
                hasInvoked = true;
                i = 0;
            }
        } else if (hasInvoked && androidId == null) {
            i = 2;
        }
        deviceIdBag.deviceId = androidId;
        deviceIdBag.errorCode = i;
        return deviceIdBag;
    }
}
