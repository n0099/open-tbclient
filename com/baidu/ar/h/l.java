package com.baidu.ar.h;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes10.dex */
public class l {
    private static char[] ye = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static MessageDigest yf;

    static {
        try {
            yf = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(l.class.getName() + "初始化失败，MessageDigest不支持MD5Util。");
            e.printStackTrace();
        }
    }

    private static void a(byte b, StringBuffer stringBuffer) {
        char c = ye[(b & 240) >> 4];
        char c2 = ye[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }

    public static synchronized String aT(String str) {
        String h;
        synchronized (l.class) {
            h = h(str.getBytes(Charset.forName("utf-8")));
        }
        return h;
    }

    public static String aU(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] digest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i2 = b & 255;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String e(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i + i2;
        while (i < i3) {
            a(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    public static String h(byte[] bArr) {
        yf.update(bArr);
        return i(yf.digest());
    }

    private static String i(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }
}
