package com.baidu.adp.lib.util;

import java.io.InputStream;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public class t {
    private static final char[] zz = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String l(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return m(messageDigest.digest());
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public static String m(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(zz[(bArr[i] & 240) >>> 4]);
            sb.append(zz[bArr[i] & 15]);
        }
        return sb.toString();
    }

    public static String d(InputStream inputStream) {
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
                str = m(messageDigest.digest());
            } catch (Exception e) {
                BdLog.e(e.toString());
            } finally {
                o.c(inputStream);
            }
        }
        return str;
    }

    public static String aZ(String str) {
        if (str == null) {
            return null;
        }
        try {
            return l(str.getBytes("UTF-8"));
        } catch (Exception e) {
            return null;
        }
    }
}
