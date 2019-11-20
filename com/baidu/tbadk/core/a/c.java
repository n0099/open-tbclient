package com.baidu.tbadk.core.a;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class c {
    private String mKey;

    public c() {
        this.mKey = "kf1t9tsczk16vc8z";
        this.mKey = agu();
    }

    private byte[] b(Key key, byte[] bArr) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }

    public String encrypt(String str, String str2) throws CertificateException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        int length;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        PublicKey publicKey = X509Certificate.getInstance(new ByteArrayInputStream(str.getBytes())).getPublicKey();
        JSONArray jSONArray = new JSONArray();
        byte[] bytes = str2.getBytes(HTTP.UTF_8);
        if (bytes.length % 116 == 0) {
            length = bytes.length / 116;
        } else {
            length = (bytes.length / 116) + 1;
        }
        for (int i = 0; i < length; i++) {
            if (1 == length) {
                jSONArray.put(com.baidu.adp.lib.util.c.encodeBytes(b(publicKey, bytes)));
            } else if (i != length - 1) {
                byte[] bArr = new byte[116];
                System.arraycopy(bytes, i * 116, bArr, 0, 116);
                jSONArray.put(com.baidu.adp.lib.util.c.encodeBytes(b(publicKey, bArr)));
            } else {
                int length2 = bytes.length - (i * 116);
                byte[] bArr2 = new byte[length2];
                System.arraycopy(bytes, i * 116, bArr2, 0, length2);
                jSONArray.put(com.baidu.adp.lib.util.c.encodeBytes(b(publicKey, bArr2)));
            }
        }
        return com.baidu.adp.lib.util.c.encodeBytes(jSONArray.toString().getBytes(HTTP.UTF_8));
    }

    private String agu() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            stringBuffer.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt("abcdefghijklmnopqrstuvwxyz0123456789".length())));
        }
        return stringBuffer.toString();
    }
}
