package com.baidu.crabsdk.lite.b;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f4784a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcNo7OFl4AMWXHXHQ/Uyr5Qwmi1EJXbxtkWHQPiT3tBxAgCApZyZXI8Sc0L+g2e3csrK+Mi/uD0W7AFmxdqSunmbiCEP4N8o5+X8NyREPRofM8cfFtIY/kHemCWR65V69FLv++/tPp5DlJQaHERWIvWL5aJXNGhUNzqUQMjRzEPwIDAQAB";

    public static String a(String str) {
        byte[] bytes = str.getBytes();
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(f4784a, 0)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i;
            if (i3 <= 0) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
            byte[] doFinal = i3 > 117 ? cipher.doFinal(bytes, i, 117) : cipher.doFinal(bytes, i, i3);
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i2++;
            i = i2 * 117;
        }
    }
}
