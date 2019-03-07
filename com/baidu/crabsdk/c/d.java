package com.baidu.crabsdk.c;

import android.annotation.SuppressLint;
import android.util.Base64;
import com.baidu.crabsdk.b.h;
import com.baidu.sapi2.utils.SapiEnv;
import java.security.Key;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public final class d {
    private static byte[] R(String str, String str2) {
        try {
            String substring = str2.substring(0, 16);
            String substring2 = str2.substring(str2.length() - 16, str2.length());
            Key cA = cA(substring);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr = new byte[length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            cipher.init(1, cA, new IvParameterSpec(substring2.getBytes()));
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String S(String str, String str2) {
        return Base64.encodeToString(R(str, str2), 0);
    }

    private static String a(String str, boolean z) {
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : charArray) {
            stringBuffer.append(Integer.toHexString(c));
        }
        return z ? stringBuffer.reverse().toString() : stringBuffer.toString();
    }

    public static byte[] b(byte[] bArr, String str) {
        try {
            String substring = str.substring(0, 16);
            String substring2 = str.substring(str.length() - 16, str.length());
            Key cA = cA(substring);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            int length = bArr.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            cipher.init(1, cA, new IvParameterSpec(substring2.getBytes()));
            return cipher.doFinal(bArr2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(String str, String str2) {
        return h.b(str + str2);
    }

    private static Key cA(String str) {
        try {
            return new SecretKeySpec(str.getBytes(), SapiEnv.SHARE_ALGORITHM);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static String cB(String str) {
        byte[] bArr = null;
        try {
            Key cA = cA(rY());
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            cipher.init(1, cA, new IvParameterSpec(rZ().getBytes()));
            bArr = cipher.doFinal(bArr2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(Base64.encodeToString(bArr, 0));
    }

    public static String cC(String str) {
        try {
            Key cA = cA(rY());
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, cA, new IvParameterSpec(rZ().getBytes()));
            return new String(cipher.doFinal(Base64.decode(str, 0))).trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String rY() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a("W", false));
        stringBuffer.append(a("9", true));
        stringBuffer.append(random.nextInt(1) + 1);
        stringBuffer.append(a("Y", true));
        stringBuffer.append("abe");
        stringBuffer.append(a("y", true));
        stringBuffer.append("1a88");
        return stringBuffer.toString();
    }

    private static String rZ() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 9; i++) {
            sb.append(String.valueOf(i));
        }
        sb.append((CharSequence) sb);
        return sb.toString();
    }
}
