package com.baidu.searchbox.datacollector.growth.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tieba.e30;
import com.baidu.tieba.g30;
import com.kuaishou.weapon.p0.h;
/* loaded from: classes2.dex */
public class DeviceUtil {
    public static final boolean DEBUG = AppConfig.isDebug();

    public static void generateOaid(Context context, final IDeviceCallback iDeviceCallback) {
        e30 f = e30.f(context);
        if (f != null) {
            f.o(new g30<String>() { // from class: com.baidu.searchbox.datacollector.growth.utils.DeviceUtil.1
                @Override // com.baidu.tieba.g30
                public void onError(int i, Throwable th, Bundle bundle) {
                    IDeviceCallback iDeviceCallback2 = IDeviceCallback.this;
                    if (iDeviceCallback2 != null) {
                        iDeviceCallback2.onFail();
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.g30
                public void onResult(String str, Bundle bundle) {
                    IDeviceCallback iDeviceCallback2 = IDeviceCallback.this;
                    if (iDeviceCallback2 != null) {
                        iDeviceCallback2.onSuccess(str);
                    }
                }
            });
        } else if (iDeviceCallback != null) {
            iDeviceCallback.onFail();
        }
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getIMei(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            return "";
        }
        if (i >= 23 && context.checkSelfPermission(h.c) != 0) {
            return "";
        }
        String str = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = ApiReplaceUtil.getDeviceId(telephonyManager);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }
}
