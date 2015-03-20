package com.baidu.location.a.a;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes.dex */
final class c {
    public final boolean a;

    /* renamed from: if  reason: not valid java name */
    public final String f27if;

    private c(String str, boolean z) {
        this.f27if = str;
        this.a = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c T(Context context) {
        String str;
        Exception e;
        boolean z;
        String str2 = "";
        try {
            str2 = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
            str = TextUtils.isEmpty(str2) ? a(context, "") : str2;
        } catch (Exception e2) {
            str = str2;
            e = e2;
        }
        try {
            Settings.System.putString(context.getContentResolver(), "bd_setting_i", str);
            z = false;
        } catch (Exception e3) {
            e = e3;
            Log.e("DeviceId", "Settings.System.getString or putString failed", e);
            if (TextUtils.isEmpty(str)) {
                str = a(context, "");
                z = true;
            } else {
                z = true;
            }
            return new c(str, z ? false : true);
        }
        return new c(str, z ? false : true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0015 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(Context context, String str) {
        String str2;
        TelephonyManager telephonyManager;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception e) {
            Log.e("DeviceId", "Read IMEI failed", e);
        }
        if (telephonyManager != null) {
            str2 = telephonyManager.getDeviceId();
            return !TextUtils.isEmpty(str2) ? str : str2;
        }
        str2 = null;
        if (!TextUtils.isEmpty(str2)) {
        }
    }
}
