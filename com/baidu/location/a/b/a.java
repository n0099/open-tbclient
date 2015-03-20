package com.baidu.location.a.b;

import com.baidu.sapi2.utils.e;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public final class a {
    public static byte[] a(String str, String str2, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), e.q);
        Cipher cipher = Cipher.getInstance(e.p);
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] e(String str, String str2, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), e.q);
        Cipher cipher = Cipher.getInstance(e.p);
        cipher.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }
}
