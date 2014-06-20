package com.baidu.android.nebula.a;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public final class l {
    private l() {
    }

    public static byte[] a(String str, String str2, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), com.baidu.sapi2.utils.f.q);
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.f.p);
        cipher.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] b(String str, String str2, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), com.baidu.sapi2.utils.f.q);
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.f.p);
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }
}
