package com.baidu.fsg.base.utils;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes2.dex */
public class RSA {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5425a = "RSA";

    public static PublicKey a(byte[] bArr) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static PrivateKey b(byte[] bArr) {
        try {
            return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] a(PublicKey publicKey, byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] a(PrivateKey privateKey, byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(2, privateKey);
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
