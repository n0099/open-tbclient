package com.baidu.android.pushservice.jni;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
/* loaded from: classes.dex */
public class BaiduAppSSOJni {
    static {
        try {
            System.loadLibrary("bdpush_V3_4");
        } catch (Throwable unused) {
        }
    }

    public static byte[] a(Context context, String str, byte[] bArr) {
        b.c cVar;
        byte[] key;
        if (str == null) {
            str = "";
        }
        try {
            key = getKey(str);
        } catch (Exception e2) {
            e = e2;
            cVar = new b.c(context);
            cVar.a(Log.getStackTraceString(e)).a();
            return null;
        } catch (UnsatisfiedLinkError e3) {
            e = e3;
            m.a("UnsatisfiedLinkError getEncrypted " + bArr, context);
            cVar = new b.c(context);
            cVar.a(Log.getStackTraceString(e)).a();
            return null;
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

    public static native byte[] decryptAES(byte[] bArr, int i2, int i3);

    public static native String encodeBySha1(byte[] bArr);

    public static native byte[] encryptAES(String str, int i2);

    public static native byte[] encryptAESwithKey(String str, String str2, String str3);

    public static native byte[] getKey(String str);

    public static native String getPrivateKey(int i2);

    public static native String getPublicKey(int i2);
}
