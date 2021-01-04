package com.baidu.pano.platform.a;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes15.dex */
class h {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f3914a = "0123456789ABCDEF".toCharArray();

    private static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = f3914a[i2 >>> 4];
            cArr[(i * 2) + 1] = f3914a[i2 & 15];
        }
        return new String(cArr);
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = str.getBytes("UTF-8");
            messageDigest.update(bytes, 0, bytes.length);
            return a(messageDigest.digest());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
