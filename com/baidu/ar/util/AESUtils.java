package com.baidu.ar.util;

import com.baidu.sapi2.utils.SapiEnv;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public class AESUtils {
    private static byte[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private static byte[] b = {10, 1, 11, 5, 4, 15, 7, 9, 23, 3, 1, 6, 8, 12, 13, 91};

    private static SecretKeySpec a(String str) {
        return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), a, 10000, 256)).getEncoded(), SapiEnv.SHARE_ALGORITHM);
    }

    private static byte[] a(SecretKey secretKey, IvParameterSpec ivParameterSpec, byte[] bArr) {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(1, secretKey, ivParameterSpec);
        return cipher.doFinal(bArr);
    }

    private static byte[] b(SecretKey secretKey, IvParameterSpec ivParameterSpec, byte[] bArr) {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(2, secretKey, ivParameterSpec);
        return cipher.doFinal(bArr);
    }

    public static String decrypt(String str, String str2) {
        try {
            return new String(b(a(str), new IvParameterSpec(b), e.a(str2)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String str, String str2) {
        try {
            return e.a(a(a(str), new IvParameterSpec(b), str2.getBytes("UTF8")));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
