package com.baidu.sapi2.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class SapiDeviceUtils {
    public static void checkHosts(Context context) {
        if (context != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream("/system/etc/hosts");
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str = new String(bArr);
                if (!TextUtils.isEmpty(str) && str.contains("passport.baidu.com")) {
                    com.baidu.sapi2.c.a(context).b(true);
                } else {
                    com.baidu.sapi2.c.a(context).b(false);
                }
                fileInputStream.close();
            } catch (Throwable th) {
                com.baidu.sapi2.c.a(context).b(false);
                L.e(th);
            }
        }
    }

    public static String getIMEI(Context context) {
        String str;
        if (context == null) {
            return null;
        }
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            L.e(e);
            str = null;
        }
        return str;
    }

    public static String getMac(Context context) {
        if (context == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            return TextUtils.isEmpty(connectionInfo.getMacAddress()) ? "" : connectionInfo.getMacAddress();
        } catch (Exception e) {
            return "";
        }
    }

    public static String getOSVersion() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.VERSION.RELEASE) ? "" : Build.VERSION.RELEASE, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    public static String getBrandName() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.BRAND) ? "" : Build.BRAND, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    public static String getBrandMode() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.MODEL) ? "" : Build.MODEL, "UTF-8");
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

        private static byte[] a(String str) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(a);
                messageDigest.update(str.getBytes());
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e2) {
                L.e(e2);
                return null;
            }
        }

        public static String getHexString(byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
            }
            return sb.toString();
        }

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
            try {
                String base64Encode = base64Encode(str.getBytes(c));
                return AES128Encrypt(base64Encode + "." + getHexString(a(base64Encode + f.z)), f.z);
            } catch (Exception e2) {
                L.e(e2);
                return null;
            }
        }

        public static String AES128Encrypt(String str, String str2) {
            try {
                String hexString = getHexString(a(str2.trim()));
                String substring = hexString.substring(0, 16);
                String stringBuffer = new StringBuffer(hexString.substring(0, 16)).reverse().toString();
                Cipher cipher = Cipher.getInstance(f.A);
                cipher.init(1, new SecretKeySpec(substring.getBytes(c), "AES"), new IvParameterSpec(stringBuffer.getBytes(c)));
                return base64Encode(cipher.doFinal(a(str.getBytes(c))));
            } catch (Exception e2) {
                L.e(e2);
                return null;
            }
        }

        public static String AES128Decrypt(String str, String str2) {
            try {
                String hexString = getHexString(a(str2.trim()));
                String substring = hexString.substring(0, 16);
                String stringBuffer = new StringBuffer(hexString.substring(0, 16)).reverse().toString();
                Cipher cipher = Cipher.getInstance(f.A);
                cipher.init(2, new SecretKeySpec(substring.getBytes(c), "AES"), new IvParameterSpec(stringBuffer.getBytes(c)));
                return base64Encode(cipher.doFinal(a(str.getBytes(c))));
            } catch (Exception e2) {
                L.e(e2);
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
