package com.baidu.cyberplayer.sdk.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class CommonUtils {
    public static int read2BytesNum(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            i3 += 256;
        }
        int i4 = i2 + 1;
        int i5 = bArr[i2];
        if (i5 < 0) {
            i5 += 256;
        }
        return i3 | (i5 << 8);
    }

    public static long versionStrToNum(String str) {
        String[] split = str.split("\\.", 2);
        long[] jArr = {Long.parseLong(split[0]), Long.parseLong(split[1])};
        return (jArr[0] << 24) | (jArr[1] << 16);
    }

    public static String versionNumToStr(long j) {
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append(String.valueOf(j >>> 24));
        stringBuffer.append(".");
        stringBuffer.append(String.valueOf((16777215 & j) >>> 16));
        stringBuffer.append(".");
        stringBuffer.append(String.valueOf((65535 & j) >>> 8));
        stringBuffer.append(".");
        stringBuffer.append(String.valueOf(255 & j));
        return stringBuffer.toString();
    }

    public static boolean isSdkMatchKernel(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        String[] split = str.split("\\.", 4);
        String[] split2 = str2.split("\\.", 4);
        long[] jArr = {Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split2[0]), Long.parseLong(split2[1])};
        return jArr[0] == jArr[2] && jArr[1] == jArr[3];
    }

    public static String toMd5(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest(), "");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append((b & 240) > 0 ? Integer.toHexString(b & 255) : "0" + Integer.toHexString(b & 255)).append(str);
        }
        return sb.toString();
    }
}
