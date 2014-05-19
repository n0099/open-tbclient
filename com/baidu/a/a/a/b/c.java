package com.baidu.a.a.a.b;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes.dex */
final class c {
    public final String a;
    public final boolean b;

    private c(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(Context context) {
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

    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a A[ORIG_RETURN, RETURN] */
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
            String a = a(str2);
            return !TextUtils.isEmpty(a) ? str : a;
        }
        str2 = null;
        String a2 = a(str2);
        if (!TextUtils.isEmpty(a2)) {
        }
    }

    private static String a(String str) {
        return (str == null || !str.contains(":")) ? str : "";
    }
}
