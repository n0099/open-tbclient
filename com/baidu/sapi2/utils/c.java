package com.baidu.sapi2.utils;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import javax.crypto.Cipher;
import javax.security.cert.X509Certificate;
/* loaded from: classes.dex */
public class c {
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
}
