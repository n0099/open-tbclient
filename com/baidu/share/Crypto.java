package com.baidu.share;

import android.content.Context;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class Crypto {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f970a = false;
    private static final String b = f();
    private static final String c = e();
    private static final String d = d();
    private static SecretKeySpec e = null;
    private static Cipher f = null;
    private static IvParameterSpec g = null;
    private static volatile boolean h = false;
    private static final String i = "0123456789ABCDEF";

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

    public static void a() {
        b();
        nativeDestroy();
        h = false;
    }

    private static void a(Context context) {
        b();
        nativeInit(context);
        e = new SecretKeySpec(b(context).getBytes(), c);
        h = true;
    }

    private static void a(StringBuffer stringBuffer, byte b2) {
        stringBuffer.append(i.charAt((b2 >> 4) & 15)).append(i.charAt(b2 & 15));
    }

    private static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = Integer.valueOf(str.substring(i2 * 2, (i2 * 2) + 2), 16).byteValue();
        }
        return bArr;
    }

    private static String b(Context context) {
        b();
        return nativeGetKey(context);
    }

    private static void b() {
        if (f970a) {
            return;
        }
        try {
            System.loadLibrary("share_v2");
            f970a = true;
        } catch (Throwable th) {
            f970a = false;
        }
    }

    private static void c() {
        if (g == null) {
            g = new IvParameterSpec(b.getBytes());
        }
    }

    private static String d() {
        b();
        return nativeGetCipher();
    }

    public static String decrypt(Context context, String str) {
        if (c.a(str) && context != null) {
            if (!h) {
                a(context);
            }
            try {
                if (f == null) {
                    f = Cipher.getInstance(d);
                }
                c();
                f.init(2, e, g);
                return new String(f.doFinal(a(str)));
            } catch (Exception e2) {
                return null;
            }
        }
        return null;
    }

    private static String e() {
        b();
        return nativeGetAlgorithm();
    }

    public static String encrypt(Context context, String str) {
        if (c.a(str) && context != null) {
            if (!h) {
                a(context);
            }
            try {
                if (f == null) {
                    f = Cipher.getInstance(d);
                }
                c();
                f.init(1, e, g);
                return a(f.doFinal(str.getBytes()));
            } catch (Exception e2) {
                return null;
            }
        }
        return null;
    }

    private static String f() {
        b();
        return nativeGetIV();
    }

    private static native void nativeDestroy();

    private static native String nativeGetAlgorithm();

    private static native String nativeGetCipher();

    private static native String nativeGetIV();

    private static native String nativeGetKey(Context context);

    private static native void nativeInit(Context context);
}
