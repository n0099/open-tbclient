package com.baidu.share;

import android.content.Context;
import com.baidu.loginshare.j;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class Crypto {
    private static final String a = nativeGetIV();
    private static final String b = nativeGetAlgorithm();
    private static final String c = nativeGetCipher();
    private static SecretKeySpec d = null;
    private static Cipher e = null;
    private static IvParameterSpec f = new IvParameterSpec(a.getBytes());
    private static volatile boolean g = false;
    private static final String h = "0123456789ABCDEF";

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b2 : bArr) {
            stringBuffer.append(h.charAt((b2 >> 4) & 15)).append(h.charAt(b2 & 15));
        }
        return stringBuffer.toString();
    }

    public static void a() {
        nativeDestroy();
        g = false;
    }

    private static void a(Context context) {
        nativeInit(context);
        d = new SecretKeySpec(nativeGetKey(context).getBytes(), b);
        g = true;
    }

    private static void a(StringBuffer stringBuffer, byte b2) {
        stringBuffer.append(h.charAt((b2 >> 4) & 15)).append(h.charAt(b2 & 15));
    }

    private static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = Integer.valueOf(str.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return bArr;
    }

    public static String decrypt(Context context, String str) {
        String str2 = null;
        if (j.a(str) && context != null) {
            if (!g) {
                a(context);
            }
            try {
                if (e == null) {
                    e = Cipher.getInstance(c);
                }
                e.init(2, d, f);
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    bArr[i] = Integer.valueOf(str.substring(i * 2, (i * 2) + 2), 16).byteValue();
                }
                str2 = new String(e.doFinal(bArr));
                return str2;
            } catch (Exception e2) {
                return str2;
            }
        }
        return null;
    }

    public static String encrypt(Context context, String str) {
        String str2 = null;
        if (j.a(str) && context != null) {
            if (!g) {
                a(context);
            }
            try {
                if (e == null) {
                    e = Cipher.getInstance(c);
                }
                e.init(1, d, f);
                byte[] doFinal = e.doFinal(str.getBytes());
                if (doFinal != null) {
                    StringBuffer stringBuffer = new StringBuffer(doFinal.length * 2);
                    for (byte b2 : doFinal) {
                        stringBuffer.append(h.charAt((b2 >> 4) & 15)).append(h.charAt(b2 & 15));
                    }
                    str2 = stringBuffer.toString();
                    return str2;
                }
                return null;
            } catch (Exception e2) {
                return str2;
            }
        }
        return null;
    }

    private static native void nativeDestroy();

    private static native String nativeGetAlgorithm();

    private static native String nativeGetCipher();

    private static native String nativeGetIV();

    private static native String nativeGetKey(Context context);

    private static native void nativeInit(Context context);
}
