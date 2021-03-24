package com.baidu.mobads.utils;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public class d {
    public static SecretKey a() {
        return new SecretKeySpec("aaskdffdaaskdffd".getBytes(), "AES");
    }

    public static String a(String str) {
        try {
            return a(Base64.decode(str, 0), a());
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String a(byte[] bArr, SecretKey secretKey) {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, secretKey);
        return new String(cipher.doFinal(bArr), "UTF-8");
    }
}
