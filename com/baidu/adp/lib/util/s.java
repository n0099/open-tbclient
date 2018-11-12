package com.baidu.adp.lib.util;

import com.baidu.searchbox.ng.ai.apps.util.AiAppEncryptUtils;
import java.io.InputStream;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public class s {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String toMd5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_MD5);
            messageDigest.update(bArr);
            return t(messageDigest.digest());
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public static String t(byte[] bArr) {
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

    public static String i(InputStream inputStream) {
        String str = null;
        if (inputStream != null) {
            try {
                byte[] bArr = new byte[1024];
                MessageDigest messageDigest = MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_MD5);
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                str = t(messageDigest.digest());
            } catch (Exception e) {
                BdLog.e(e.toString());
            } finally {
                n.h(inputStream);
            }
        }
        return str;
    }

    public static String bC(String str) {
        if (str == null) {
            return null;
        }
        try {
            return toMd5(str.getBytes("UTF-8"));
        } catch (Exception e) {
            return null;
        }
    }
}
