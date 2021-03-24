package com.baidu.swan.bdtls;

import java.io.UnsupportedEncodingException;
/* loaded from: classes3.dex */
public class AES {
    static {
        System.loadLibrary("bdtls");
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return (bArr == null || bArr.length <= 0) ? new byte[]{-1} : decrypt(bArr, bArr2);
    }

    public static byte[] b(String str, byte[] bArr) {
        if (str == null || str.length() <= 0) {
            return new byte[]{-1};
        }
        byte[] bArr2 = new byte[0];
        try {
            bArr2 = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return encrypt(bArr2, bArr);
    }

    public static native byte[] decrypt(byte[] bArr, byte[] bArr2);

    public static native byte[] encrypt(byte[] bArr, byte[] bArr2);
}
