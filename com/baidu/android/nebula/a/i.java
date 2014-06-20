package com.baidu.android.nebula.a;

import com.baidu.android.common.security.RSAUtil;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes.dex */
public final class i {
    private i() {
    }

    public static byte[] a(byte[] bArr, String str, int i) {
        PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(k.a(str.getBytes())));
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.shell.b.a);
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
}
