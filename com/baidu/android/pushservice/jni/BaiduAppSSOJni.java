package com.baidu.android.pushservice.jni;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
/* loaded from: classes9.dex */
public class BaiduAppSSOJni {
    static {
        try {
            System.loadLibrary("bdpush_V3_3");
        } catch (Throwable th) {
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
                return encryptAESwithKey(str2.substring(16), str2.substring(0, 16), new String(bArr, "utf-8"));
            }
            return null;
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
            return null;
        } catch (UnsatisfiedLinkError e2) {
            m.a("UnsatisfiedLinkError getEncrypted " + bArr, context);
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return null;
        }
    }

    public static native byte[] decryptAES(byte[] bArr, int i, int i2);

    public static native String encodeBySha1(byte[] bArr);

    public static native byte[] encryptAES(String str, int i);

    public static native byte[] encryptAESwithKey(String str, String str2, String str3);

    private static native byte[] getKey(String str);

    public static native String getPrivateKey(int i);

    public static native String getPublicKey(int i);
}
