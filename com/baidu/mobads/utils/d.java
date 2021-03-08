package com.baidu.mobads.utils;

import android.util.Base64;
import com.baidu.live.adp.lib.util.SecureHelper;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes4.dex */
public class d {
    public static SecretKey a() {
        return new SecretKeySpec("aaskdffdaaskdffd".getBytes(), com.baidu.sapi2.utils.e.q);
    }

    public static String a(String str) {
        try {
            return a(Base64.decode(str, 0), a());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(byte[] bArr, SecretKey secretKey) {
        Cipher cipher = Cipher.getInstance(SecureHelper.CIPHER_TRIPLE_AES);
        cipher.init(2, secretKey);
        return new String(cipher.doFinal(bArr), "UTF-8");
    }
}
