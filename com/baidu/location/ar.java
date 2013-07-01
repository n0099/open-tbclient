package com.baidu.location;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.account.AccountProxy;
import java.util.UUID;
/* loaded from: classes.dex */
public class ar {
    public static String a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("bids", 0);
        String string = sharedPreferences.getString("i", null);
        if (string == null) {
            string = b(context);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("i", string);
            edit.commit();
        }
        String string2 = sharedPreferences.getString("a", null);
        if (string2 == null) {
            string2 = c(context);
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            edit2.putString("a", string2);
            edit2.commit();
        }
        String a2 = ap.a((AccountProxy.BAIDUACCOUNT_TYPE + string + string2).getBytes(), true);
        String string3 = Settings.System.getString(context.getContentResolver(), a2);
        if (TextUtils.isEmpty(string3)) {
            String a3 = ap.a((string + string2 + UUID.randomUUID().toString()).getBytes(), true);
            Settings.System.putString(context.getContentResolver(), a2, a3);
            return !a3.equals(Settings.System.getString(context.getContentResolver(), a2)) ? a2 : a3;
        }
        return string3;
    }

    public static String b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            String deviceId = telephonyManager.getDeviceId();
            return TextUtils.isEmpty(deviceId) ? "" : deviceId;
        }
        return "";
    }

    public static String c(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }
}
