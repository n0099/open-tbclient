package com.baidu.tbadk.core.a;

import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import java.io.ByteArrayInputStream;
import java.security.Key;
import java.security.PublicKey;
import java.util.Random;
import javax.crypto.Cipher;
import javax.security.cert.X509Certificate;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class c {
    private String mKey;

    public c() {
        this.mKey = "kf1t9tsczk16vc8z";
        this.mKey = rh();
    }

    private byte[] b(Key key, byte[] bArr) {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }

    public String encrypt(String str, String str2) {
        int length;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        PublicKey publicKey = X509Certificate.getInstance(new ByteArrayInputStream(str.getBytes())).getPublicKey();
        JSONArray jSONArray = new JSONArray();
        byte[] bytes = str2.getBytes("UTF-8");
        if (bytes.length % SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE == 0) {
            length = bytes.length / SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE;
        } else {
            length = (bytes.length / SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE) + 1;
        }
        for (int i = 0; i < length; i++) {
            if (1 == length) {
                jSONArray.put(com.baidu.adp.lib.util.c.encodeBytes(b(publicKey, bytes)));
            } else if (i != length - 1) {
                byte[] bArr = new byte[SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE];
                System.arraycopy(bytes, i * SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE, bArr, 0, SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE);
                jSONArray.put(com.baidu.adp.lib.util.c.encodeBytes(b(publicKey, bArr)));
            } else {
                int length2 = bytes.length - (i * SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE);
                byte[] bArr2 = new byte[length2];
                System.arraycopy(bytes, i * SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE, bArr2, 0, length2);
                jSONArray.put(com.baidu.adp.lib.util.c.encodeBytes(b(publicKey, bArr2)));
            }
        }
        return com.baidu.adp.lib.util.c.encodeBytes(jSONArray.toString().getBytes("UTF-8"));
    }

    private String rh() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            stringBuffer.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt("abcdefghijklmnopqrstuvwxyz0123456789".length())));
        }
        return stringBuffer.toString();
    }
}
