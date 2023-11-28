package com.baidu.searchbox.common.security;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.security.ioc.HostAbilityRuntime;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.kuaishou.weapon.p0.g;
/* loaded from: classes3.dex */
public class DeviceInfoProxy {
    public static final int DEFAULT_PHONE_TYPE = 0;
    public static volatile boolean hasInvokedImei;
    public static volatile boolean hasInvokedImsi;
    public static String lastImei;
    public static String lastImsi;
    public static int lastPhoneType;
    public static volatile boolean[] hasInvokedImeiArray = new boolean[2];
    public static String[] imeiArray = new String[2];

    public static boolean checkPermisson(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23 && i < 29) {
            if (context.checkSelfPermission(g.c) != 0) {
                return false;
            }
            return true;
        } else if (Build.VERSION.SDK_INT >= 29) {
            return false;
        } else {
            return true;
        }
    }

    public static DeviceIdBag getImei(Context context) {
        return getImei(context, false);
    }

    public static DeviceIdBag getImsi(Context context) {
        return getImsi(context, false);
    }

    public static int getPhoneType(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getPhoneType();
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String realImei(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT >= 26) {
                return ApiReplaceUtil.getImei(telephonyManager);
            }
            return ApiReplaceUtil.getDeviceId(telephonyManager);
        } catch (Exception unused) {
            return null;
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String realImsi(Context context) {
        try {
            return ApiReplaceUtil.getSubscriberId((TelephonyManager) context.getSystemService("phone"));
        } catch (Exception unused) {
            return null;
        }
    }

    public static DeviceIdBag getImei(Context context, boolean z) {
        return getImei(context, z, false);
    }

    public static DeviceIdBag getImei(Context context, boolean z, boolean z2) {
        DeviceIdBag deviceIdBag = new DeviceIdBag();
        if (!HostAbilityRuntime.getHostAbility().hasAgreedPrivacyPolicy()) {
            deviceIdBag.errorCode = -3;
            return deviceIdBag;
        }
        int phoneType = getPhoneType(context);
        int i = 1;
        if (!z2 && ((lastImei != null || hasInvokedImei) && lastPhoneType == phoneType)) {
            if (lastImei == null && hasInvokedImei) {
                i = 2;
            }
        } else if (!z && !HostAbilityRuntime.getHostAbility().isForeground()) {
            i = -1;
        } else if (checkPermisson(context)) {
            lastImei = realImei(context);
            hasInvokedImei = true;
            lastPhoneType = phoneType;
            i = 0;
        } else {
            i = -2;
        }
        deviceIdBag.deviceId = lastImei;
        deviceIdBag.errorCode = i;
        return deviceIdBag;
    }

    public static DeviceIdBag getImsi(Context context, boolean z) {
        int i;
        DeviceIdBag deviceIdBag = new DeviceIdBag();
        if (!HostAbilityRuntime.getHostAbility().hasAgreedPrivacyPolicy()) {
            deviceIdBag.errorCode = -3;
            return deviceIdBag;
        }
        String str = null;
        if (!z && !HostAbilityRuntime.getHostAbility().isForeground()) {
            i = -1;
        } else if (checkPermisson(context)) {
            str = realImsi(context);
            i = 0;
        } else {
            i = -2;
        }
        if (TextUtils.isEmpty(str)) {
            str = lastImsi;
            if (!TextUtils.isEmpty(str)) {
                i = 1;
            }
        } else {
            lastImsi = str;
        }
        deviceIdBag.deviceId = str;
        deviceIdBag.errorCode = i;
        return deviceIdBag;
    }

    public static String realImei(Context context, int i) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return telephonyManager.getImei(i);
        }
        if (i2 >= 21) {
            try {
                return (String) TelephonyManager.class.getMethod("getImei", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i));
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
