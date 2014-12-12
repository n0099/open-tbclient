package com.baidu.tbadk.core.account;

import android.text.TextUtils;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import java.io.ByteArrayInputStream;
import java.security.Key;
import java.security.PublicKey;
import java.util.Random;
import javax.crypto.Cipher;
import javax.security.cert.X509Certificate;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class b {
    private String mKey;

    public b() {
        this.mKey = "kf1t9tsczk16vc8z";
        this.mKey = mm();
    }

    private byte[] b(Key key, byte[] bArr) {
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.shell.b.a);
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }

    public String K(String str, String str2) {
        int length;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        PublicKey publicKey = X509Certificate.getInstance(new ByteArrayInputStream(str.getBytes())).getPublicKey();
        JSONArray jSONArray = new JSONArray();
        byte[] bytes = str2.getBytes("UTF-8");
        if (bytes.length % Constants.MEDIA_HARD_DECODE_FAILED == 0) {
            length = bytes.length / Constants.MEDIA_HARD_DECODE_FAILED;
        } else {
            length = (bytes.length / Constants.MEDIA_HARD_DECODE_FAILED) + 1;
        }
        for (int i = 0; i < length; i++) {
            if (1 == length) {
                jSONArray.put(com.baidu.tbadk.core.util.b.encode(b(publicKey, bytes)));
            } else if (i != length - 1) {
                byte[] bArr = new byte[Constants.MEDIA_HARD_DECODE_FAILED];
                System.arraycopy(bytes, i * Constants.MEDIA_HARD_DECODE_FAILED, bArr, 0, Constants.MEDIA_HARD_DECODE_FAILED);
                jSONArray.put(com.baidu.tbadk.core.util.b.encode(b(publicKey, bArr)));
            } else {
                int length2 = bytes.length - (i * Constants.MEDIA_HARD_DECODE_FAILED);
                byte[] bArr2 = new byte[length2];
                System.arraycopy(bytes, i * Constants.MEDIA_HARD_DECODE_FAILED, bArr2, 0, length2);
                jSONArray.put(com.baidu.tbadk.core.util.b.encode(b(publicKey, bArr2)));
            }
        }
        return com.baidu.tbadk.core.util.b.encode(jSONArray.toString().getBytes("UTF-8"));
    }

    private String mm() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            stringBuffer.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt("abcdefghijklmnopqrstuvwxyz0123456789".length())));
        }
        return stringBuffer.toString();
    }
}
