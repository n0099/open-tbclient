package com.baidu.sapi2.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import com.baidu.mobstat.Config;
import com.baidu.pass.permissions.PassPermissions;
import com.baidu.sapi2.ServiceManager;
import java.io.FileInputStream;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes2.dex */
public class f {
    public static boolean a(Context context) {
        FileInputStream fileInputStream;
        if (context == null) {
            return false;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream("/system/etc/hosts");
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str = new String(bArr);
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("passport.baidu.com")) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                        Log.e(Log.TAG, e2.toString());
                    }
                    return true;
                }
            }
            try {
                fileInputStream.close();
            } catch (Exception e3) {
                Log.e(Log.TAG, e3.toString());
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            try {
                Log.e(Log.TAG, th.toString());
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                        Log.e(Log.TAG, e4.toString());
                    }
                }
                return false;
            } catch (Throwable th3) {
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e5) {
                        Log.e(Log.TAG, e5.toString());
                    }
                }
                throw th3;
            }
        }
    }

    public static String b(Context context) {
        try {
            if (!d(context) && Build.VERSION.SDK_INT < 29 && ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol() && PassPermissions.checkRequestPermission("android.permission.READ_PHONE_STATE", context)) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                return deviceId == null ? "" : deviceId;
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(Context context) {
        try {
        } catch (Exception e2) {
            Log.e(e2);
        }
        if (ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol()) {
            if (Build.VERSION.SDK_INT >= 23) {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (networkInterface.getName().equalsIgnoreCase(NetworkInfoUtils.NETWORK_NAME)) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress == null) {
                            return "";
                        }
                        StringBuilder sb = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString().toLowerCase();
                    }
                }
                return Config.DEF_MAC_ID;
            }
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        }
        return Config.DEF_MAC_ID;
    }

    public static boolean d(Context context) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("com.baidu.(.*)input(.*)");
        String packageName = context.getPackageName();
        for (String str : arrayList) {
            if (packageName.matches(str)) {
                return true;
            }
        }
        return false;
    }

    public static String a() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.BRAND) ? "" : Build.BRAND, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }
}
