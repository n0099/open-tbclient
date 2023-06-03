package com.baidu.searchbox.common.util.crypto.rsa;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
/* loaded from: classes3.dex */
public final class RSAUtil {
    public static final String ALGORITHM_RSA = "RSA";
    public static final int BYTE_IN_BITS = 8;
    public static final String PRIVATE_KEY = "PrivateKey";
    public static final int PT_MAXLEN_OFFSET = 11;
    public static final String PUBLIC_KEY = "PublicKey";

    public static byte[] decryptByPrivateKey(byte[] bArr, String str) throws Exception {
        PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str.getBytes())));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, generatePrivate);
        return cipher.doFinal(bArr);
    }

    public static byte[] decryptByPublicKey(byte[] bArr, String str) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, generatePublic);
        return cipher.doFinal(bArr);
    }

    public static byte[] encryptByPublicKey(byte[] bArr, String str) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }

    public static Map<String, Object> generateKey(int i) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(i);
        KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        HashMap hashMap = new HashMap(2);
        hashMap.put("PublicKey", (RSAPublicKey) generateKeyPair.getPublic());
        hashMap.put("PrivateKey", (RSAPrivateKey) generateKeyPair.getPrivate());
        return hashMap;
    }

    public static String getPrivateKey(Map<String, Object> map) throws Exception {
        return Base64.encode(((Key) map.get("PrivateKey")).getEncoded(), "utf-8");
    }

    public static String getPublicKey(Map<String, Object> map) throws UnsupportedEncodingException {
        return Base64.encode(((Key) map.get("PublicKey")).getEncoded(), "utf-8");
    }
}
