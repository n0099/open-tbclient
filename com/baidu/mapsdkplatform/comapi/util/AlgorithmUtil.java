package com.baidu.mapsdkplatform.comapi.util;

import android.text.TextUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public final class AlgorithmUtil {
    public static byte[] a(String str, String str2, byte[] bArr) throws Exception {
        if (str2 == null) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
        int length = bArr.length;
        while (length % 16 != 0) {
            length++;
        }
        byte[] bArr2 = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 < bArr.length) {
                bArr2[i2] = bArr[i2];
            } else {
                bArr2[i2] = 0;
            }
        }
        return cipher.doFinal(bArr2);
    }

    public static byte[] b(String str, String str2, byte[] bArr) throws Exception {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(HTTP.ASCII), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] getUrlNeedInfo(String str, String str2, byte[] bArr) throws Exception {
        return b(str, str2, bArr);
    }

    public static byte[] setUrlNeedInfo(String str, String str2, byte[] bArr) throws Exception {
        return a(str, str2, bArr);
    }
}
