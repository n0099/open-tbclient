package com.baidu.pass.face.platform.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import java.util.UUID;
/* loaded from: classes2.dex */
public class DeviceUtils {
    public static final String TAG = "DeviceUtils";

    public static String getAndroidID(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
        try {
            return MD5Utils.encryption(string.getBytes());
        } catch (Exception e2) {
            e2.printStackTrace();
            return string;
        }
    }

    public static String getDeviceCode(Context context) {
        String str = "";
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            return MD5Utils.encryption(str.getBytes());
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String getSerialNumber(Context context) {
        return Build.SERIAL;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
