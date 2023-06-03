package com.baidu.searchbox.download.util;

import android.text.TextUtils;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public final class AesUtil {
    public static final String IV = "2011121211143000";

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            return new String(Base64.encode(encrypt(str, IV, str2), 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] encrypt(String str, String str2, String str3) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
        return cipher.doFinal(str3.getBytes("UTF-8"));
    }
}
