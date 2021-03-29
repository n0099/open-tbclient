package com.baidu.appsearchlib;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
/* loaded from: classes.dex */
public class Util {
    public static String openudid;
    public static PackageInfo packageInfo;

    public static String getCurrentVersion(Context context) {
        PackageInfo packageInfo2 = getPackageInfo(context);
        return packageInfo2 == null ? "0" : packageInfo2.versionName;
    }

    public static String getDeviceId(Context context) {
        String deviceId;
        if (!isEmpty(openudid)) {
            return openudid;
        }
        StringBuilder sb = new StringBuilder();
        try {
            deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!isEmpty(deviceId)) {
            sb.append(deviceId);
            return sb.toString();
        }
        String macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        if (!isEmpty(macAddress)) {
            sb.append(macAddress);
            return sb.toString();
        }
        String sb2 = sb.toString();
        openudid = sb2;
        return sb2;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0005: SGET  (r1v0 int A[REMOVE]) =  android.os.Build.VERSION.SDK_INT int)] */
    public static String getOSVersion() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.VERSION.SDK_INT);
        return sb.toString();
    }

    public static PackageInfo getPackageInfo(Context context) {
        PackageInfo packageInfo2 = packageInfo;
        if (packageInfo2 != null) {
            return packageInfo2;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return packageInfo;
    }

    public static String getPlatformCode() {
        String str = Build.MODEL;
        return str != null ? str : "unknown";
    }

    public static long getTime() {
        return System.currentTimeMillis() / 1000;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0005: INVOKE  (r1v0 long A[REMOVE]) =  type: STATIC call: com.baidu.appsearchlib.Util.getTime():long)] */
    public static String getTimeStr() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTime());
        return sb.toString();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.equals("");
    }
}
