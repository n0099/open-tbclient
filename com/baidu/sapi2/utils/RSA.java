package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.sapi2.base.debug.Log;
import java.io.ByteArrayInputStream;
import javax.crypto.Cipher;
import javax.security.cert.X509Certificate;
/* loaded from: classes.dex */
public class RSA {
    public static byte[] encrypt(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
            cipher.init(1, X509Certificate.getInstance(new ByteArrayInputStream(str2.getBytes())).getPublicKey());
            return cipher.doFinal(str.getBytes("UTF-8"));
        } catch (Throwable th) {
            Log.e(Log.TAG, th.toString());
            return null;
        }
    }
}
