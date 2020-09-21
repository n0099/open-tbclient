package com.baidu.appsearchlib;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
/* loaded from: classes14.dex */
public class Util {
    public static String openudid = null;
    public static PackageInfo packageInfo = null;

    public static long getTime() {
        return System.currentTimeMillis() / 1000;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0005: INVOKE  (r2v0 long A[REMOVE]) =  type: STATIC call: com.baidu.appsearchlib.Util.getTime():long)] */
    public static String getTimeStr() {
        return new StringBuilder().append(getTime()).toString();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0005: SGET  (r1v0 int A[REMOVE]) =  android.os.Build.VERSION.SDK_INT int)] */
    public static String getOSVersion() {
        return new StringBuilder().append(Build.VERSION.SDK_INT).toString();
    }

    public static String getPlatformCode() {
        return Build.MODEL != null ? Build.MODEL : "unknown";
    }

    public static String getCurrentVersion(Context context) {
        PackageInfo packageInfo2 = getPackageInfo(context);
        return packageInfo2 == null ? "0" : packageInfo2.versionName;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004e -> B:17:0x000a). Please submit an issue!!! */
    public static String getDeviceId(Context context) {
        String str;
        String deviceId;
        if (!isEmpty(openudid)) {
            return openudid;
        }
        StringBuilder sb = new StringBuilder();
        try {
            deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!isEmpty(deviceId)) {
            sb.append(deviceId);
            str = sb.toString();
        } else {
            String macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if (!isEmpty(macAddress)) {
                sb.append(macAddress);
                str = sb.toString();
            }
            openudid = sb.toString();
            str = openudid;
        }
        return str;
    }

    public static PackageInfo getPackageInfo(Context context) {
        if (packageInfo != null) {
            return packageInfo;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return packageInfo;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.equals("");
    }
}
