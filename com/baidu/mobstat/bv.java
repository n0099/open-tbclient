package com.baidu.mobstat;

import com.baidu.android.common.security.RSAUtil;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes3.dex */
public class bv {
    public static String a(byte[] bArr) throws Exception {
        try {
            return bp.b(a(false, br.a(), bArr));
        } catch (Exception e) {
            return "";
        }
    }

    public static byte[] a(boolean z, byte[] bArr, byte[] bArr2) throws Exception {
        RSAKey a2 = a(z, bArr);
        return a(1, (Key) a2, ((a2.getModulus().bitLength() + 1) / 8) - 11, bArr2);
    }

    public static byte[] b(boolean z, byte[] bArr, byte[] bArr2) throws Exception {
        RSAKey a2 = a(z, bArr);
        return a(2, (Key) a2, (a2.getModulus().bitLength() + 1) / 8, bArr2);
    }

    private static RSAKey a(boolean z, byte[] bArr) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA);
        return z ? (RSAPrivateKey) keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArr)) : (RSAPublicKey) keyFactory.generatePublic(new X509EncodedKeySpec(bArr));
    }

    private static byte[] a(int i, Key key, int i2, byte[] bArr) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(i, key);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 0;
        while (i3 < bArr.length) {
            int length = bArr.length - i3;
            if (length > i2) {
                length = i2;
            }
            byteArrayOutputStream.write(cipher.doFinal(bArr, i3, length));
            i3 += i2;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
