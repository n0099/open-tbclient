package com.baidu.sapi2.shell;

import android.text.TextUtils;
import com.baidu.android.common.security.Base64;
import com.baidu.sapi2.utils.g;
import java.io.ByteArrayInputStream;
import java.security.Key;
import java.security.PublicKey;
import java.util.Random;
import javax.crypto.Cipher;
import javax.security.cert.X509Certificate;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    public static final String a = "RSA/ECB/PKCS1Padding";
    private String b;
    private g c = new g();

    public b() {
        this.b = "kf1t9tsczk16vc8z";
        this.b = b();
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String a(String str, String str2) {
        int length;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        PublicKey publicKey = X509Certificate.getInstance(new ByteArrayInputStream(str.getBytes())).getPublicKey();
        JSONArray jSONArray = new JSONArray();
        byte[] bytes = str2.getBytes("UTF-8");
        if (bytes.length % 116 == 0) {
            length = bytes.length / 116;
        } else {
            length = (bytes.length / 116) + 1;
        }
        for (int i = 0; i < length; i++) {
            if (1 == length) {
                jSONArray.put(Base64.encode(a(publicKey, bytes), "UTF-8"));
            } else if (i != length - 1) {
                byte[] bArr = new byte[116];
                System.arraycopy(bytes, i * 116, bArr, 0, 116);
                jSONArray.put(Base64.encode(a(publicKey, bArr), "UTF-8"));
            } else {
                int length2 = bytes.length - (i * 116);
                byte[] bArr2 = new byte[length2];
                System.arraycopy(bytes, i * 116, bArr2, 0, length2);
                jSONArray.put(Base64.encode(a(publicKey, bArr2), "UTF-8"));
            }
        }
        return Base64.encode(jSONArray.toString().getBytes("UTF-8"), "UTF-8");
    }

    public String b(String str) {
        return new String(this.c.a(Base64.decode(str.getBytes()), new StringBuffer(this.b).reverse().toString(), this.b), "UTF-8");
    }

    private String b() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt("abcdefghijklmnopqrstuvwxyz0123456789".length())));
        }
        return sb.toString();
    }

    private byte[] a(Key key, byte[] bArr) {
        Cipher cipher = Cipher.getInstance(a);
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }
}
