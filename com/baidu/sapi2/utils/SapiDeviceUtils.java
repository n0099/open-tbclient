package com.baidu.sapi2.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.common.util.DeviceId;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.base.debug.Log;
import java.io.FileInputStream;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.util.Collections;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class SapiDeviceUtils {
    static String a = "js52je)927!hsm^%3m";
    static String b = "AES/CBC/NoPadding";

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [57=4, 58=4, 60=4, 61=4] */
    public static boolean checkHosts(Context context) {
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
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e) {
                                Log.e(Log.TAG, e.toString());
                            }
                        }
                        return true;
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (Exception e2) {
                        Log.e(Log.TAG, e2.toString());
                        return false;
                    }
                }
                return false;
            } catch (Throwable th) {
                th = th;
                try {
                    Log.e(Log.TAG, th.toString());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return false;
                        } catch (Exception e3) {
                            Log.e(Log.TAG, e3.toString());
                            return false;
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

    public static String getIMEI(Context context) {
        String str = "";
        try {
            str = DeviceId.getIMEI(context);
        } catch (Throwable th) {
            Log.e(th);
        }
        return str != null ? str : "";
    }

    public static String getMac(Context context) {
        try {
        } catch (Exception e) {
            Log.e(e);
        }
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

    public static String getOSVersion() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.VERSION.RELEASE) ? "" : Build.VERSION.RELEASE, HTTP.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }

    public static String getBrandName() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.BRAND) ? "" : Build.BRAND, HTTP.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }

    public static String getBrandMode() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.MODEL) ? "" : Build.MODEL, HTTP.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }

    public static String createDeviceID(Context context) {
        return MD5Util.toMd5((getIMEI(context) + getMac(context)).getBytes(), false).replace("\n", "");
    }

    public static String createDeviceInfo() {
        return "os_version=" + getOSVersion() + "&brand_name=" + getBrandName() + "&brand_model=" + getBrandMode() + "&os_type=Android";
    }

    /* loaded from: classes.dex */
    public static class DeviceCrypto {
        private static final String a = "MD5";
        private static final String b = "AES";
        private static final String c = "UTF-8";
        private static final int d = 16;
        private static final int e = 16;

        public static String base64Encode(byte[] bArr) {
            int i;
            StringBuilder sb = new StringBuilder();
            int length = bArr.length * 8;
            byte b2 = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 6;
            int i5 = 0;
            do {
                if (i5 > 0 && i4 > 0) {
                    b2 = (byte) (((byte) (((bArr[i3] & 255) << i4) | ((bArr[i3 + 1] & 255) >> (8 - i4)))) & 63);
                    i5 = 8 - i4;
                    i4 = 6 - i5;
                } else if (i5 == 0) {
                    b2 = (byte) ((bArr[i3] & 255) >> (8 - i4));
                    i5 = 2;
                    i4 = 4;
                } else if (i4 == 0) {
                    b2 = (byte) (bArr[i3] & 63);
                    i4 = 6;
                    i5 = 0;
                }
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(b2));
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

        public static String encryptDeviceId(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str2 = SapiDeviceUtils.a;
            try {
                String base64Encode = base64Encode(str.getBytes("UTF-8"));
                return encryptAes128(base64Encode + "." + MD5Util.toMd5((base64Encode + str2).getBytes(), false), str2);
            } catch (Exception e2) {
                Log.e(Log.TAG, e2.toString());
                return null;
            }
        }

        public static String encryptAes128(String str, String str2) {
            try {
                String md5 = MD5Util.toMd5(str2.trim().getBytes(), false);
                String substring = md5.substring(0, 16);
                String stringBuffer = new StringBuffer(md5.substring(0, 16)).reverse().toString();
                Cipher cipher = Cipher.getInstance(SapiDeviceUtils.b);
                cipher.init(1, new SecretKeySpec(substring.getBytes("UTF-8"), "AES"), new IvParameterSpec(stringBuffer.getBytes("UTF-8")));
                return base64Encode(cipher.doFinal(a(str.getBytes("UTF-8"))));
            } catch (Exception e2) {
                Log.e(Log.TAG, e2.toString());
                return null;
            }
        }

        private static byte[] a(byte[] bArr) {
            if (bArr.length % 16 != 0) {
                byte[] bArr2 = new byte[((bArr.length / 16) + 1) * 16];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                for (int length = bArr.length; length < bArr2.length; length++) {
                    bArr2[length] = 0;
                }
                return bArr2;
            }
            return bArr;
        }
    }
}
