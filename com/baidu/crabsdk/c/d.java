package com.baidu.crabsdk.c;

import android.util.Base64;
import com.baidu.crabsdk.b.h;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import java.security.Key;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public final class d {
    public static Key a(String str) {
        try {
            return new SecretKeySpec(str.getBytes(), "AES");
        } catch (Exception e2) {
            e2.printStackTrace();
            throw e2;
        }
    }

    public static String b(String str) {
        try {
            Key a2 = a(e());
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr = new byte[length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            cipher.init(1, a2, new IvParameterSpec(f().getBytes()));
            return new String(Base64.encodeToString(cipher.doFinal(bArr), 0));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String c(String str) {
        try {
            Key a2 = a(e());
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, a2, new IvParameterSpec(f().getBytes()));
            return new String(cipher.doFinal(Base64.decode(str, 0))).trim();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String d(String str, boolean z) {
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char c2 : charArray) {
            stringBuffer.append(Integer.toHexString(c2));
        }
        return z ? stringBuffer.reverse().toString() : stringBuffer.toString();
    }

    public static String e() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(d("W", false));
        stringBuffer.append(d(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, true));
        stringBuffer.append(random.nextInt(1) + 1);
        stringBuffer.append(d("Y", true));
        stringBuffer.append("abe");
        stringBuffer.append(d("y", true));
        stringBuffer.append("1a88");
        return stringBuffer.toString();
    }

    public static String f() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 1; i2 < 9; i2++) {
            sb.append(String.valueOf(i2));
        }
        sb.append((CharSequence) sb);
        return sb.toString();
    }

    public static byte[] g(byte[] bArr, String str) {
        try {
            String substring = str.substring(0, 16);
            String substring2 = str.substring(str.length() - 16, str.length());
            Key a2 = a(substring);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            int length = bArr.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            cipher.init(1, a2, new IvParameterSpec(substring2.getBytes()));
            return cipher.doFinal(bArr2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String h(String str, String str2) {
        return h.a(str + str2);
    }

    public static byte[] i(String str, String str2) {
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

    public static String j(String str, String str2) {
        return Base64.encodeToString(i(str, str2), 0);
    }
}
