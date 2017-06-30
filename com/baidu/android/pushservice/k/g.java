package com.baidu.android.pushservice.k;

import com.baidu.android.common.security.RSAUtil;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes2.dex */
public final class g {
    public static byte[] a(byte[] bArr, String str) throws Exception {
        PrivateKey generatePrivate = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePrivate(new PKCS8EncodedKeySpec(b.a(str.getBytes())));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, generatePrivate);
        return cipher.doFinal(bArr);
    }

    public static byte[] a(byte[] bArr, String str, int i) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(b.a(str.getBytes())));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        int i2 = i / 8;
        int i3 = i2 - 11;
        int length = bArr.length;
        byte[] bArr2 = new byte[(((length + i3) - 1) / i3) * i2];
        int i4 = 0;
        int i5 = 0;
        while (i5 < length) {
            int i6 = length - i5;
            if (i3 < i6) {
                i6 = i3;
            }
            byte[] bArr3 = new byte[i6];
            System.arraycopy(bArr, i5, bArr3, 0, i6);
            i5 += i6;
            System.arraycopy(cipher.doFinal(bArr3), 0, bArr2, i4, i2);
            i4 += i2;
        }
        return bArr2;
    }

    public static byte[] b(byte[] bArr, String str) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(b.a(str.getBytes())));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }
}
