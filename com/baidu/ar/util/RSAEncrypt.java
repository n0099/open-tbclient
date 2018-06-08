package com.baidu.ar.util;

import com.baidu.android.common.security.RSAUtil;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes3.dex */
public class RSAEncrypt {
    public static String encrypt(String str, String str2) {
        if (str == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str2))));
        return new String(Base64.encode(cipher.doFinal(str.getBytes(Charset.forName(IoUtils.UTF_8)))));
    }
}
