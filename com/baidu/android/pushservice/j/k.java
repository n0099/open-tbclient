package com.baidu.android.pushservice.j;

import android.util.Base64;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.yy.hiidostatis.inner.util.cipher.RsaCipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    public static JSONArray a(String str, int i2, int i3) {
        JSONArray jSONArray = new JSONArray();
        int length = str.length() / 100;
        int length2 = str.length() % 100;
        if (length2 != 0) {
            length++;
        }
        int i4 = 0;
        while (i4 < length) {
            JSONObject jSONObject = new JSONObject();
            try {
                String encodeToString = Base64.encodeToString(a(str.substring(i4 * 100, (i4 != length + (-1) || length2 == 0) ? (i4 + 1) * 100 : str.length()).getBytes(), BaiduAppSSOJni.getPublicKey(i2)), i3);
                jSONObject.put("data", encodeToString);
                jSONObject.put("data_len", encodeToString.length());
                jSONArray.put(jSONObject);
            } catch (Exception unused) {
            }
            i4++;
        }
        return jSONArray;
    }

    public static boolean a(byte[] bArr, String str, String str2) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 2)));
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initVerify(generatePublic);
            signature.update(bArr);
            return signature.verify(Base64.decode(str, 2));
        } catch (Exception unused) {
            return false;
        }
    }

    public static byte[] a(byte[] bArr, String str) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        Cipher cipher = Cipher.getInstance(RsaCipher.RSA_PADDING);
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }

    public static byte[] b(byte[] bArr, String str) throws Exception {
        PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 2)));
        Cipher cipher = Cipher.getInstance(RsaCipher.RSA_PADDING);
        cipher.init(2, generatePrivate);
        return cipher.doFinal(bArr);
    }
}
