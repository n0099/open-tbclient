package com.baidu.share;

import android.content.Context;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class Crypto {
    private static boolean a = false;
    private static final String b = e();
    private static final String c = d();
    private static final String d = c();
    private static SecretKeySpec e = null;
    private static Cipher f = null;
    private static IvParameterSpec g = null;
    private static volatile boolean h = false;

    public static String a(Context context, String str) {
        if (f.a(str) && context != null) {
            if (!h) {
                a(context);
            }
            try {
                if (f == null) {
                    f = Cipher.getInstance(d);
                }
                b();
                f.init(1, e, g);
                return a(f.doFinal(str.getBytes()));
            } catch (Exception e2) {
                return null;
            }
        }
        return null;
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b2 : bArr) {
            a(stringBuffer, b2);
        }
        return stringBuffer.toString();
    }

    private static void a() {
        if (a) {
            return;
        }
        try {
            System.loadLibrary("share");
            a = true;
        } catch (Throwable th) {
            a = false;
        }
    }

    private static void a(Context context) {
        a();
        nativeInit(context);
        e = new SecretKeySpec(b(context).getBytes(), c);
        h = true;
    }

    private static void a(StringBuffer stringBuffer, byte b2) {
        stringBuffer.append("0123456789ABCDEF".charAt((b2 >> 4) & 15)).append("0123456789ABCDEF".charAt(b2 & 15));
    }

    private static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = Integer.valueOf(str.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return bArr;
    }

    private static String b(Context context) {
        a();
        return nativeGetKey(context);
    }

    public static String b(Context context, String str) {
        if (f.a(str) && context != null) {
            if (!h) {
                a(context);
            }
            try {
                if (f == null) {
                    f = Cipher.getInstance(d);
                }
                b();
                f.init(2, e, g);
                return new String(f.doFinal(a(str)));
            } catch (Exception e2) {
                return null;
            }
        }
        return null;
    }

    private static void b() {
        if (g == null) {
            g = new IvParameterSpec(b.getBytes());
        }
    }

    private static String c() {
        a();
        return nativeGetCipher();
    }

    private static String d() {
        a();
        return nativeGetAlgorithm();
    }

    private static String e() {
        a();
        return nativeGetIV();
    }

    private static native String nativeGetAlgorithm();

    private static native String nativeGetCipher();

    private static native String nativeGetIV();

    private static native String nativeGetKey(Context context);

    private static native void nativeInit(Context context);
}
