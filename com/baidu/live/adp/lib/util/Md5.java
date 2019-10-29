package com.baidu.live.adp.lib.util;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class Md5 {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public String str;

    public static String toMd5(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return toHexString(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toHexString(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }

    public static String toMd5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return toHexString(messageDigest.digest());
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(HEX_DIGITS[(bArr[i] & 240) >>> 4]);
            sb.append(HEX_DIGITS[bArr[i] & 15]);
        }
        return sb.toString();
    }

    public static String toMd5(InputStream inputStream) {
        String str = null;
        if (inputStream != null) {
            try {
                byte[] bArr = new byte[1024];
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                str = toHexString(messageDigest.digest());
            } catch (Exception e) {
                BdLog.e(e.toString());
            } finally {
                CloseUtil.close(inputStream);
            }
        }
        return str;
    }

    public static String toMd5(String str) {
        if (str == null) {
            return null;
        }
        try {
            return toMd5(str.getBytes(HTTP.UTF_8));
        } catch (Exception e) {
            return null;
        }
    }
}
