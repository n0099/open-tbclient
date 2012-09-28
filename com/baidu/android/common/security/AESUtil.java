package com.baidu.android.common.security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public final class AESUtil {
    private static final String ALGORITHM_NAME = "AES";
    private static final String CBC_IV = "2011121211143000";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    private AESUtil() {
    }

    public static byte[] decrypt(String str, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), ALGORITHM_NAME);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(2, secretKeySpec, new IvParameterSpec(CBC_IV.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] encrypt(String str, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), ALGORITHM_NAME);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(1, secretKeySpec, new IvParameterSpec(CBC_IV.getBytes()));
        return cipher.doFinal(bArr);
    }
}
