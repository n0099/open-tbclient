package com.baidu.location.b.a;

import com.baidu.sapi2.utils.SapiEnv;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public final class a {
    public static byte[] a(String str, String str2, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), SapiEnv.SHARE_ALGORITHM);
        Cipher cipher = Cipher.getInstance(SapiEnv.SHARE_AES_MODE);
        cipher.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] b(String str, String str2, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), SapiEnv.SHARE_ALGORITHM);
        Cipher cipher = Cipher.getInstance(SapiEnv.SHARE_AES_MODE);
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }
}
