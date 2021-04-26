package com.baidu.mobstat;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes2.dex */
public class bv {
    public static String a(byte[] bArr) throws Exception {
        try {
            return bp.b(a(false, br.a(), bArr));
        } catch (Exception unused) {
            return "";
        }
    }

    public static byte[] b(boolean z, byte[] bArr, byte[] bArr2) throws Exception {
        RSAKey a2 = a(z, bArr);
        return a(2, (Key) a2, (a2.getModulus().bitLength() + 1) / 8, bArr2);
    }

    public static byte[] a(boolean z, byte[] bArr, byte[] bArr2) throws Exception {
        RSAKey a2 = a(z, bArr);
        return a(1, (Key) a2, ((a2.getModulus().bitLength() + 1) / 8) - 11, bArr2);
    }

    public static RSAKey a(boolean z, byte[] bArr) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        if (z) {
            return (RSAPrivateKey) keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArr));
        }
        return (RSAPublicKey) keyFactory.generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static byte[] a(int i2, Key key, int i3, byte[] bArr) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(i2, key);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i4 = 0;
        while (i4 < bArr.length) {
            int length = bArr.length - i4;
            if (length > i3) {
                length = i3;
            }
            byteArrayOutputStream.write(cipher.doFinal(bArr, i4, length));
            i4 += i3;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
