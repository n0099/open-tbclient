package com.baidu.sapi2.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.ServiceManager;
import java.io.FileInputStream;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.util.Collections;
/* loaded from: classes6.dex */
public class SapiDeviceUtils {

    /* loaded from: classes6.dex */
    public static class DeviceCrypto implements NoProguard {
        public static String base64Encode(byte[] bArr) {
            int i;
            if (bArr != null && bArr.length != 0) {
                StringBuilder sb = new StringBuilder();
                int length = bArr.length * 8;
                byte b = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 6;
                int i5 = 0;
                do {
                    if (i5 <= 0 || i4 <= 0) {
                        if (i5 == 0) {
                            b = (byte) ((bArr[i3] & 255) >> (8 - i4));
                            i5 = 2;
                            i4 = 4;
                        } else if (i4 == 0) {
                            b = (byte) (bArr[i3] & 63);
                            i4 = 6;
                            i5 = 0;
                        }
                    } else {
                        i5 = 8 - i4;
                        b = (byte) (((byte) (((bArr[i3] & 255) << i4) | ((bArr[i3 + 1] & 255) >> i5))) & 63);
                        i4 = 6 - i5;
                    }
                    sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(b));
                    i2 += 6;
                    i3 = i2 / 8;
                    i = length - i2;
                } while (i >= 6);
                if (i > 0) {
                    sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte) ((bArr[bArr.length - 1] << (6 - i)) & 63)));
                }
                int i6 = length % 3;
                for (int i7 = 0; i7 < i6; i7++) {
                    sb.append("=");
                }
                return sb.toString();
            }
            return "";
        }
    }

    public static String b(Context context) {
        try {
            if (ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol()) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                return deviceId == null ? "" : deviceId;
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    public static String c(Context context) {
        try {
        } catch (Exception e) {
            Log.e(e);
        }
        if (ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol()) {
            if (Build.VERSION.SDK_INT >= 23) {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
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

    public static String b() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.BRAND) ? "" : Build.BRAND, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean a(Context context) {
        FileInputStream fileInputStream;
        if (context == null) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream("/system/etc/hosts");
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str = new String(bArr);
                if (!TextUtils.isEmpty(str)) {
                    if (str.contains("passport.baidu.com")) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                            Log.e(Log.TAG, e.toString());
                        }
                        return true;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Exception e2) {
                    Log.e(Log.TAG, e2.toString());
                }
                return false;
            } catch (Throwable th) {
                th = th;
                try {
                    Log.e(Log.TAG, th.toString());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                            Log.e(Log.TAG, e3.toString());
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e4) {
                            Log.e(Log.TAG, e4.toString());
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static String a() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.MODEL) ? "" : Build.MODEL, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }
}
