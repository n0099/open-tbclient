package com.baidu.android.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.account.AccountProxy;
import java.util.UUID;
/* loaded from: classes.dex */
public final class DeviceId {
    private static final String KEY_ANDROID_ID = "a";
    private static final String KEY_IMEI = "i";
    private static final String SHARED_NAME = "bids";
    private static final String TAG = "DeviceId";

    private DeviceId() {
    }

    public static String getAndroidId(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    public static String getDeviceID(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_NAME, 0);
        String string = sharedPreferences.getString(KEY_IMEI, null);
        if (string == null) {
            string = getIMEI(context);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(KEY_IMEI, string);
            edit.commit();
        }
        String string2 = sharedPreferences.getString(KEY_ANDROID_ID, null);
        if (string2 == null) {
            string2 = getAndroidId(context);
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            edit2.putString(KEY_ANDROID_ID, string2);
            edit2.commit();
        }
        String md5 = Util.toMd5((AccountProxy.BAIDUACCOUNT_TYPE + string + string2).getBytes(), true);
        String string3 = Settings.System.getString(context.getContentResolver(), md5);
        if (TextUtils.isEmpty(string3)) {
            String md52 = Util.toMd5((string + string2 + UUID.randomUUID().toString()).getBytes(), true);
            Settings.System.putString(context.getContentResolver(), md5, md52);
            return !md52.equals(Settings.System.getString(context.getContentResolver(), md5)) ? md5 : md52;
        }
        return string3;
    }

    public static String getIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            String deviceId = telephonyManager.getDeviceId();
            return TextUtils.isEmpty(deviceId) ? "" : deviceId;
        }
        return "";
    }
}
