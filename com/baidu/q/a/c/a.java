package com.baidu.q.a.c;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes10.dex */
public final class a {
    public static byte[] encrypt(String str, String str2, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), com.baidu.sapi2.utils.e.q);
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.e.p);
        cipher.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] decrypt(String str, String str2, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), com.baidu.sapi2.utils.e.q);
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.e.p);
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }
}
