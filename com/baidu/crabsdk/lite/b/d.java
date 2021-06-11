package com.baidu.crabsdk.lite.b;

import android.util.Base64;
import com.baidu.crabsdk.lite.a.g;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public final class d {
    public static Key a(String str) {
        try {
            return new SecretKeySpec(str.getBytes(), "AES");
        } catch (Exception e2) {
            e2.printStackTrace();
            throw e2;
        }
    }

    public static String b(String str, String str2) {
        return g.b(str + str2);
    }

    public static byte[] c(String str, String str2) {
        try {
            String substring = str2.substring(0, 16);
            String substring2 = str2.substring(str2.length() - 16, str2.length());
            Key a2 = a(substring);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr = new byte[length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            cipher.init(1, a2, new IvParameterSpec(substring2.getBytes()));
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String d(String str, String str2) {
        return Base64.encodeToString(c(str, str2), 0);
    }
}
