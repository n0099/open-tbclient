package com.baidu.mobstat.a;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public final class a {
    public static byte[] a(String str, String str2, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), com.baidu.sapi2.utils.e.q);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(bArr);
    }

    public static byte[] b(String str, String str2, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), com.baidu.sapi2.utils.e.q);
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.e.q);
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(bArr);
    }
}
