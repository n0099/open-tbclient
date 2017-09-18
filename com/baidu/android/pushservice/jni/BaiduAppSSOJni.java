package com.baidu.android.pushservice.jni;

import android.content.Context;
import com.baidu.android.pushservice.g.a;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.k.b;
import com.baidu.android.pushservice.k.e;
/* loaded from: classes2.dex */
public class BaiduAppSSOJni {
    private static final String TAG = "BaiduAppSSOJni";

    static {
        try {
            System.loadLibrary("bdpush_V2_7");
        } catch (UnsatisfiedLinkError e) {
            a.e(TAG, "Native library not found! Please copy libbdpush_V2_7.so into your project!");
        }
    }

    public static native byte[] decryptAES(byte[] bArr, int i, int i2);

    private static native byte[] encrypt(String str, String str2);

    public static native byte[] encryptAES(String str, int i);

    public static String getDecrypted(Context context, String str, String str2) {
        try {
            byte[] decrypted = getDecrypted(context, str, b.a(str2.getBytes()));
            if (decrypted != null && decrypted.length > 0) {
                return new String(decrypted, "utf-8");
            }
        } catch (Exception e) {
            a.a(TAG, "getDecrypted: " + e);
        }
        return null;
    }

    public static byte[] getDecrypted(Context context, String str, byte[] bArr) {
        byte[] bArr2 = null;
        if (str == null) {
            str = "";
        }
        try {
            byte[] key = getKey(str);
            if (key == null) {
                a.a(TAG, "keyInfo null");
            } else {
                String str2 = new String(key, "utf-8");
                if (str2.length() > 0) {
                    bArr2 = com.baidu.android.pushservice.k.a.b(str2.substring(16), str2.substring(0, 16), bArr);
                }
            }
        } catch (Exception e) {
            a.a(TAG, "getDecrypted: " + e);
        } catch (UnsatisfiedLinkError e2) {
            a.e(TAG, "UnsatisfiedLinkError getDecrypted ");
            p.b("UnsatisfiedLinkError getDecrypted ", context);
        }
        return bArr2;
    }

    public static String getEncrypted(Context context, String str, String str2) {
        try {
            return b.a(getEncrypted(context, str, str2.getBytes()), "utf-8");
        } catch (Exception e) {
            a.a(TAG, "getEncrypted: " + e);
            return null;
        }
    }

    public static byte[] getEncrypted(Context context, String str, byte[] bArr) {
        byte[] bArr2 = null;
        if (str == null) {
            str = "";
        }
        try {
            byte[] key = getKey(str);
            if (key == null) {
                a.a(TAG, "keyInfo null");
            } else {
                String str2 = new String(key, "utf-8");
                if (str2.length() > 0) {
                    bArr2 = com.baidu.android.pushservice.k.a.a(str2.substring(16), str2.substring(0, 16), bArr);
                }
            }
        } catch (Exception e) {
            a.a(TAG, "getEncrypted: " + e);
        } catch (UnsatisfiedLinkError e2) {
            a.e(TAG, "UnsatisfiedLinkError getEncrypted " + bArr);
            p.b("UnsatisfiedLinkError getEncrypted " + bArr, context);
        }
        return bArr2;
    }

    private static native byte[] getKey(String str);

    public static String getPushHash(Context context, String str, String str2, String str3) {
        if (context == null || str == null || str2 == null) {
            return null;
        }
        String str4 = str3 == null ? "other" : str3;
        String q = p.q(context.getApplicationContext(), str);
        if (q == null) {
            a.c(TAG, "can not get singInfo for: " + str);
            return null;
        }
        try {
            return b.a(getSsoHashNative(context, str, str2, q, e.a(context), str4, System.currentTimeMillis()), "utf-8");
        } catch (Exception e) {
            a.c(TAG, "getPushHashException: " + e);
            return "";
        }
    }

    private static native byte[] getSsoHashNative(Context context, String str, String str2, String str3, String str4, String str5, long j);
}
