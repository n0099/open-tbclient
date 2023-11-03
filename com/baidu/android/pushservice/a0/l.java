package com.baidu.android.pushservice.a0;

import android.util.Base64;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    public static JSONArray a(String str, int i, int i2) {
        JSONArray jSONArray = new JSONArray();
        int length = str.length() / 100;
        int length2 = str.length() % 100;
        if (length2 != 0) {
            length++;
        }
        int i3 = 0;
        while (i3 < length) {
            JSONObject jSONObject = new JSONObject();
            try {
                String encodeToString = Base64.encodeToString(a(str.substring(i3 * 100, (i3 != length + (-1) || length2 == 0) ? (i3 + 1) * 100 : str.length()).getBytes(), BaiduAppSSOJni.getPublicKey(i)), i2);
                jSONObject.put("data", encodeToString);
                jSONObject.put("data_len", encodeToString.length());
                jSONArray.put(jSONObject);
            } catch (Exception unused) {
            }
            i3++;
        }
        return jSONArray;
    }

    public static JSONArray a(byte[] bArr, int i, int i2) {
        JSONArray jSONArray = new JSONArray();
        int length = bArr.length / 100;
        int length2 = bArr.length % 100;
        if (length2 != 0) {
            length++;
        }
        int i3 = 0;
        while (i3 < length) {
            JSONObject jSONObject = new JSONObject();
            try {
                String encodeToString = Base64.encodeToString(a(Arrays.copyOfRange(bArr, i3 * 100, (i3 != length + (-1) || length2 == 0) ? (i3 + 1) * 100 : bArr.length), BaiduAppSSOJni.getPublicKey(i)), i2);
                jSONObject.put("data", encodeToString);
                jSONObject.put("data_len", encodeToString.length());
                jSONArray.put(jSONObject);
            } catch (Exception unused) {
            }
            i3++;
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
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }
}
