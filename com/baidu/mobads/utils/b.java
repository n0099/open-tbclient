package com.baidu.mobads.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes2.dex */
public class b {
    public static String a(String str, String str2) {
        byte[] doFinal;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
                RSAPublicKey rSAPublicKey = (RSAPublicKey) a(str);
                cipher.init(1, rSAPublicKey);
                byte[] bytes = str2.getBytes("UTF-8");
                int bitLength = rSAPublicKey.getModulus().bitLength() / 8;
                int length = bytes.length;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i = 0;
                int i2 = 0;
                while (true) {
                    int i3 = length - i;
                    if (i3 > 0) {
                        if (i3 > bitLength) {
                            doFinal = cipher.doFinal(bytes, i, bitLength);
                        } else {
                            doFinal = cipher.doFinal(bytes, i, i3);
                        }
                        byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                        i2++;
                        i = i2 * bitLength;
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        return Base64.encodeToString(byteArray, 8);
                    }
                }
            } catch (Throwable th) {
                q.a().d(th);
            }
        }
        return "";
    }

    public static PublicKey a(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (Throwable th) {
            q.a().d(th);
            return null;
        }
    }
}
