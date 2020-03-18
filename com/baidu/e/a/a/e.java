package com.baidu.e.a.a;

import android.text.TextUtils;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes13.dex */
public class e {
    private static final char[] UY = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] UZ = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String cK(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("UTF-8"));
            return r(messageDigest.digest());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    private static String r(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(UZ[(b & 240) >> 4]);
            sb.append(UZ[b & 15]);
        }
        return sb.toString();
    }

    private static String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(HEX_DIGITS[(bArr[i] & 240) >>> 4]);
            sb.append(HEX_DIGITS[bArr[i] & 15]);
        }
        return sb.toString();
    }

    public static String getFileMD5(String str) {
        byte[] bArr = new byte[1024];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return toHexString(messageDigest.digest());
                }
            }
        } catch (Exception e) {
            return "";
        }
    }
}
