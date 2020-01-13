package com.baidu.android.pushservice.j;

import android.annotation.SuppressLint;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes6.dex */
public final class e {
    public static boolean a(byte[] bArr, String str, String str2) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(b.a(str2.getBytes())));
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initVerify(generatePublic);
            signature.update(bArr);
            return signature.verify(b.a(str.getBytes()));
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressLint({"InlinedApi", "OldTargetApi"})
    public static byte[] a(byte[] bArr, String str) throws Exception {
        PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(b.a(str.getBytes())));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, generatePrivate);
        return cipher.doFinal(bArr);
    }

    @SuppressLint({"InlinedApi", "OldTargetApi"})
    public static byte[] b(byte[] bArr, String str) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(b.a(str.getBytes())));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }

    @SuppressLint({"InlinedApi", "OldTargetApi"})
    public static byte[] c(byte[] bArr, String str) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(b.a(str.getBytes())));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        int length = bArr.length;
        byte[] bArr2 = new byte[(((length + 117) - 1) / 117) * 128];
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            int i3 = length - i2;
            if (117 < i3) {
                i3 = 117;
            }
            byte[] bArr3 = new byte[i3];
            System.arraycopy(bArr, i2, bArr3, 0, i3);
            i2 += i3;
            System.arraycopy(cipher.doFinal(bArr3), 0, bArr2, i, 128);
            i += 128;
        }
        return bArr2;
    }
}
