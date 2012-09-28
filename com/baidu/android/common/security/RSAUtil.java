package com.baidu.android.common.security;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
/* loaded from: classes.dex */
public final class RSAUtil {
    public static final String ALGORITHM_RSA = "RSA";
    public static final String PRIVATE_KEY = "PrivateKey";
    public static final String PUBLIC_KEY = "PublicKey";

    private RSAUtil() {
    }

    public static byte[] decryptByPrivateKey(byte[] bArr, String str) throws Exception {
        PrivateKey generatePrivate = KeyFactory.getInstance(ALGORITHM_RSA).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str.getBytes())));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, generatePrivate);
        return cipher.doFinal(bArr);
    }

    public static byte[] decryptByPublicKey(byte[] bArr, String str) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance(ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, generatePublic);
        return cipher.doFinal(bArr);
    }

    public static byte[] encryptByPrivateKey(byte[] bArr, String str) throws Exception {
        PrivateKey generatePrivate = KeyFactory.getInstance(ALGORITHM_RSA).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str.getBytes())));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePrivate);
        return cipher.doFinal(bArr);
    }

    public static byte[] encryptByPublicKey(byte[] bArr, String str) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance(ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }

    public static Map<String, Object> generateKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM_RSA);
        keyPairGenerator.initialize(1024);
        KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        HashMap hashMap = new HashMap(2);
        hashMap.put(PUBLIC_KEY, (RSAPublicKey) generateKeyPair.getPublic());
        hashMap.put(PRIVATE_KEY, (RSAPrivateKey) generateKeyPair.getPrivate());
        return hashMap;
    }

    public static RSAPrivateKey generateRSAPrivateKey(BigInteger bigInteger, BigInteger bigInteger2) throws Exception {
        try {
            try {
                return (RSAPrivateKey) KeyFactory.getInstance(ALGORITHM_RSA).generatePrivate(new RSAPrivateKeySpec(bigInteger, bigInteger2));
            } catch (InvalidKeySpecException e) {
                throw new Exception(e.getMessage());
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new Exception(e2.getMessage());
        }
    }

    public static RSAPublicKey generateRSAPublicKey(BigInteger bigInteger, BigInteger bigInteger2) throws Exception {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(ALGORITHM_RSA).generatePublic(new RSAPublicKeySpec(bigInteger, bigInteger2));
            } catch (InvalidKeySpecException e) {
                throw new Exception(e.getMessage());
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new Exception(e2.getMessage());
        }
    }

    public static String getPrivateKey(Map<String, Object> map) throws Exception {
        return Base64.encode(((Key) map.get(PRIVATE_KEY)).getEncoded(), "utf-8");
    }

    public static String getPublicKey(Map<String, Object> map) throws UnsupportedEncodingException {
        return Base64.encode(((Key) map.get(PUBLIC_KEY)).getEncoded(), "utf-8");
    }
}
