package com.baidu.android.pushservice.k;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public class f {
    private static int a(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static String a(byte[] bArr, String str, boolean z) {
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

    public static String a(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static byte[] a(String str) {
        byte[] bArr = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                String upperCase = str.toUpperCase();
                int length = upperCase.length() / 2;
                bArr = new byte[length];
                char[] charArray = upperCase.toCharArray();
                if (charArray != null) {
                    for (int i = 0; i < length; i++) {
                        int i2 = i * 2;
                        if (i2 >= 0 && i2 + 1 < charArray.length && i >= 0 && i < length) {
                            bArr[i] = (byte) (a(charArray[i2 + 1]) | (a(charArray[i2]) << 4));
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return bArr;
    }
}
