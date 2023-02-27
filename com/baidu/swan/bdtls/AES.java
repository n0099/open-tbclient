package com.baidu.swan.bdtls;

import androidx.annotation.Keep;
import java.nio.charset.StandardCharsets;
@Keep
/* loaded from: classes3.dex */
public class AES {
    @Keep
    public static native byte[] decrypt(byte[] bArr, byte[] bArr2);

    @Keep
    public static native byte[] encrypt(byte[] bArr, byte[] bArr2);

    static {
        System.loadLibrary("bdtls");
    }

    public static byte[] aesDecrypt(byte[] bArr, byte[] bArr2) {
        return (bArr == null || bArr.length <= 0) ? new byte[]{-1} : decrypt(bArr, bArr2);
    }

    public static byte[] aesEncrypt(String str, byte[] bArr) {
        return (str == null || str.length() <= 0) ? new byte[]{-1} : encrypt(str.getBytes(StandardCharsets.UTF_8), bArr);
    }
}
