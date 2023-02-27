package com.baidu.swan.bdtls;

import android.text.TextUtils;
import androidx.annotation.Keep;
import java.nio.charset.StandardCharsets;
@Keep
/* loaded from: classes3.dex */
public class RSA {
    @Keep
    public static native byte[] decrypt(byte[] bArr);

    @Keep
    public static native byte[] encrypt(byte[] bArr);

    @Keep
    public static native byte[] privateDecrypt(byte[] bArr);

    @Keep
    public static native byte[] privateEncrypt(byte[] bArr);

    public static String privateKeyDecrypt(byte[] bArr) {
        if (bArr != null && bArr.length >= 1) {
            byte[] privateDecrypt = privateDecrypt(bArr);
            if (privateDecrypt != null && privateDecrypt.length >= 1) {
                return new String(privateDecrypt, StandardCharsets.UTF_8);
            }
            return "result is null";
        }
        return "null content";
    }

    public static byte[] privateKeyEncrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] privateEncrypt = privateEncrypt(str.getBytes(StandardCharsets.UTF_8));
        return (privateEncrypt == null || privateEncrypt.length < 1) ? new byte[]{-1} : privateEncrypt;
    }

    public static String rsaDecrypt(byte[] bArr) {
        if (bArr != null && bArr.length >= 1) {
            byte[] decrypt = decrypt(bArr);
            if (decrypt != null && decrypt.length >= 1) {
                return new String(decrypt, StandardCharsets.UTF_8);
            }
            return "result is null";
        }
        return "null content";
    }

    public static byte[] rsaEncrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return encrypt(str.getBytes(StandardCharsets.UTF_8));
    }
}
