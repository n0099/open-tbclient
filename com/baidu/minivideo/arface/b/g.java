package com.baidu.minivideo.arface.b;

import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.security.MessageDigest;
/* loaded from: classes5.dex */
public class g {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String toMd5(String str) {
        if (str == null) {
            return null;
        }
        try {
            return toMd5(str.getBytes("UTF-8"));
        } catch (Exception e) {
            return null;
        }
    }

    public static String toMd5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.update(bArr);
            return toHexString(messageDigest.digest());
        } catch (Exception e) {
            e.printStackTrace();
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
}
