package com.baidu.adp.lib.util;

import java.io.InputStream;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public class ab {
    private static final char[] ze = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String p(byte[] bArr) {
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
            sb.append(ze[(bArr[i] & 240) >>> 4]);
            sb.append(ze[bArr[i] & 15]);
        }
        return sb.toString();
    }

    public static String e(InputStream inputStream) {
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
                v.d(inputStream);
            }
        }
        return str;
    }

    public static String toMd5(String str) {
        if (str == null) {
            return null;
        }
        try {
            return p(str.getBytes("UTF-8"));
        } catch (Exception e) {
            return null;
        }
    }
}
