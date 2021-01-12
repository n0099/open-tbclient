package com.baidu.crabsdk.c;

import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes14.dex */
public final class e {
    private static String apD = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcNo7OFl4AMWXHXHQ/Uyr5Qwmi1EJXbxtkWHQPiT3tBxAgCApZyZXI8Sc0L+g2e3csrK+Mi/uD0W7AFmxdqSunmbiCEP4N8o5+X8NyREPRofM8cfFtIY/kHemCWR65V69FLv++/tPp5DlJQaHERWIvWL5aJXNGhUNzqUQMjRzEPwIDAQAB";

    public static String dz(String str) {
        byte[] bytes = str.getBytes();
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(apD, 0));
        KeyFactory keyFactory = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA);
        a.w(keyFactory.getProvider().toString());
        PublicKey generatePublic = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (length - i2 > 0) {
            byte[] doFinal = length - i2 > 117 ? cipher.doFinal(bytes, i2, 117) : cipher.doFinal(bytes, i2, length - i2);
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            int i3 = i + 1;
            i2 = i3 * 117;
            i = i3;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return Base64.encodeToString(byteArray, 2);
    }
}
