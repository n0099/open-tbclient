package com.baidu.android.pushservice.jni;

import android.content.Context;
import android.util.Base64;
/* loaded from: classes.dex */
public class BaiduAppSSOJni {
    static {
        try {
            System.loadLibrary("bdpush_V3_6");
        } catch (Throwable unused) {
        }
    }

    public static String a(Context context, String str, String str2) {
        try {
            byte[] a = a(context, str, Base64.decode(str2.getBytes(), 2));
            if (a == null || a.length <= 0) {
                return null;
            }
            return new String(a, "utf-8");
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] a(Context context, String str, byte[] bArr) {
        if (str == null) {
            str = "";
        }
        try {
            byte[] key = getKey(str);
            if (key == null) {
                return null;
            }
            String str2 = new String(key, "utf-8");
            if (str2.length() > 0) {
                return decryptAESwithKey(str2.substring(16), str2.substring(0, 16), bArr, bArr.length);
            }
            return null;
        } catch (Exception | UnsatisfiedLinkError unused) {
            return null;
        }
    }

    public static String b(Context context, String str, String str2) {
        try {
            return Base64.encodeToString(b(context, str, str2.getBytes()), 2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(Context context, String str, byte[] bArr) {
        byte[] key;
        if (str == null) {
            str = "";
        }
        try {
            key = getKey(str);
        } catch (Exception | UnsatisfiedLinkError unused) {
        }
        if (key == null) {
            return null;
        }
        String str2 = new String(key, "utf-8");
        if (str2.length() > 0) {
            return encryptAESwithKey(str2.substring(16), str2.substring(0, 16), new String(bArr, "utf-8"));
        }
        return null;
    }

    public static native byte[] decryptAES(byte[] bArr, int i, int i2);

    public static native byte[] decryptAESwithKey(String str, String str2, byte[] bArr, int i);

    public static native String encodeBySha1(byte[] bArr);

    public static native byte[] encryptAES(String str, int i);

    public static native byte[] encryptAESwithKey(String str, String str2, String str3);

    public static native byte[] getKey(String str);

    public static native String getPublicKey(int i);
}
