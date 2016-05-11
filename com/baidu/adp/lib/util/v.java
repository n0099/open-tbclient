package com.baidu.adp.lib.util;

import com.baidu.android.common.security.RSAUtil;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
/* loaded from: classes.dex */
public class v {
    public static final Charset pN = Charset.forName("UTF-8");
    private static final byte[] pO = {-92, 11, -56, 52, -42, -107, -13, 19};

    public static PublicKey m(byte[] bArr) {
        return KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static byte[] a(PublicKey publicKey, byte[] bArr) {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKey);
        return cipher.doFinal(bArr);
    }

    public static byte[] b(Key key, byte[] bArr) {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, key);
        return cipher.doFinal(bArr);
    }

    public static SecretKey aT(String str) {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        char[] cArr = new char[str.length()];
        for (int i = 0; i < cArr.length; i++) {
            cArr[i] = (char) (((byte) str.charAt(i)) & 255);
        }
        return secretKeyFactory.generateSecret(new PBEKeySpec(cArr, pO, 5, 256));
    }

    public static byte[] a(SecretKey secretKey, byte[] bArr) {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, secretKey);
        return cipher.doFinal(bArr);
    }

    public static byte[] a(SecretKey secretKey, byte[] bArr, int i, int i2) {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, secretKey);
        return cipher.doFinal(bArr, i, i2);
    }

    public static String ae(int i) {
        String bigInteger = new BigInteger(i * 5, new SecureRandom()).toString(36);
        if (bigInteger.length() > i) {
            return bigInteger.substring(0, bigInteger.length());
        }
        return bigInteger;
    }
}
