package com.baidu.crabsdk.c;

import android.support.media.ExifInterface;
import android.util.Base64;
import com.baidu.crabsdk.b.h;
import com.baidu.searchbox.ugc.model.PublishType;
import java.security.Key;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes8.dex */
public final class d {
    private static byte[] V(String str, String str2) {
        try {
            String substring = str2.substring(0, 16);
            String substring2 = str2.substring(str2.length() - 16, str2.length());
            Key dI = dI(substring);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr = new byte[length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            cipher.init(1, dI, new IvParameterSpec(substring2.getBytes()));
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String W(String str, String str2) {
        return Base64.encodeToString(V(str, str2), 0);
    }

    private static String a(String str, boolean z) {
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : charArray) {
            stringBuffer.append(Integer.toHexString(c));
        }
        return z ? stringBuffer.reverse().toString() : stringBuffer.toString();
    }

    private static String am() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 9; i++) {
            sb.append(String.valueOf(i));
        }
        sb.append((CharSequence) sb);
        return sb.toString();
    }

    public static byte[] b(byte[] bArr, String str) {
        try {
            String substring = str.substring(0, 16);
            String substring2 = str.substring(str.length() - 16, str.length());
            Key dI = dI(substring);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            int length = bArr.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            cipher.init(1, dI, new IvParameterSpec(substring2.getBytes()));
            return cipher.doFinal(bArr2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(String str, String str2) {
        return h.a(str + str2);
    }

    private static Key dI(String str) {
        try {
            return new SecretKeySpec(str.getBytes(), com.baidu.sapi2.utils.e.q);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static String dJ(String str) {
        try {
            Key dI = dI(vh());
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr = new byte[length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            cipher.init(1, dI, new IvParameterSpec(am().getBytes()));
            return new String(Base64.encodeToString(cipher.doFinal(bArr), 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dK(String str) {
        try {
            Key dI = dI(vh());
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, dI, new IvParameterSpec(am().getBytes()));
            return new String(cipher.doFinal(Base64.decode(str, 0))).trim();
        } catch (Exception e) {
            return null;
        }
    }

    private static String vh() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a(ExifInterface.LONGITUDE_WEST, false));
        stringBuffer.append(a(PublishType.TYPE_VIDEO_SHARE, true));
        stringBuffer.append(random.nextInt(1) + 1);
        stringBuffer.append(a("Y", true));
        stringBuffer.append("abe");
        stringBuffer.append(a("y", true));
        stringBuffer.append("1a88");
        return stringBuffer.toString();
    }
}
