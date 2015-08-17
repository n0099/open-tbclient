package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.android.common.security.Base64;
import com.baidu.android.common.security.RSAUtil;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.security.cert.X509Certificate;
/* loaded from: classes.dex */
public class b {
    public static byte[] a(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/NONE/NoPadding");
            cipher.init(1, X509Certificate.getInstance(new ByteArrayInputStream(str2.getBytes())).getPublicKey());
            return cipher.doFinal(str.getBytes("UTF-8"));
        } catch (Throwable th) {
            L.e(th);
            return null;
        }
    }

    public static String b(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
            PublicKey a = a(str2);
            if (a != null) {
                cipher.init(2, a);
                return new String(cipher.doFinal(Base64.decode(str.getBytes())), "UTF8");
            }
        } catch (Throwable th) {
            L.e(th);
        }
        return null;
    }

    private static PublicKey a(String str) {
        String readLine;
        PublicKey publicKey = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str.getBytes("UTF-8"))));
            StringBuilder sb = new StringBuilder();
            while (true) {
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (readLine.contains("-----BEGIN PUBLIC KEY-----")) {
                        while (true) {
                            readLine = bufferedReader.readLine();
                            if (readLine == null || readLine.contains("-----END PUBLIC KEY-----")) {
                                break;
                            }
                            sb.append(readLine.trim());
                        }
                    }
                } else {
                    break;
                }
            }
            bufferedReader.close();
            if (TextUtils.isEmpty(readLine)) {
                return null;
            }
            publicKey = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(sb.toString().getBytes())));
            return publicKey;
        } catch (Throwable th) {
            L.e(th);
            return publicKey;
        }
    }
}
