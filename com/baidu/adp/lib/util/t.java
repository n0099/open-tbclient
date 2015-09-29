package com.baidu.adp.lib.util;

import java.io.InputStream;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public class t {
    private static final char[] yS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String B(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return C(messageDigest.digest());
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public static String C(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(yS[(bArr[i] & 240) >>> 4]);
            sb.append(yS[bArr[i] & 15]);
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
                str = C(messageDigest.digest());
            } catch (Exception e) {
                BdLog.e(e.toString());
            } finally {
                o.d(inputStream);
            }
        }
        return str;
    }

    public static String toMd5(String str) {
        if (str == null) {
            return null;
        }
        try {
            return B(str.getBytes("UTF-8"));
        } catch (Exception e) {
            return null;
        }
    }
}
