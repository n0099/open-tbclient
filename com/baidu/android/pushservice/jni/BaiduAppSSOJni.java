package com.baidu.android.pushservice.jni;

import android.content.Context;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.j.a;
import com.baidu.android.pushservice.j.b;
/* loaded from: classes3.dex */
public class BaiduAppSSOJni {
    private static final String TAG = "BaiduAppSSOJni";

    static {
        try {
            System.loadLibrary("bdpush_V2_9");
        } catch (UnsatisfiedLinkError e) {
        }
    }

    public static native byte[] decryptAES(byte[] bArr, int i, int i2);

    public static native byte[] decryptR(byte[] bArr, int i);

    public static native byte[] encryptAES(String str, int i);

    public static native byte[] encryptR(byte[] bArr, int i);

    public static String getDecrypted(Context context, String str, String str2) {
        try {
            byte[] decrypted = getDecrypted(context, str, b.a(str2.getBytes()));
            if (decrypted != null && decrypted.length > 0) {
                return new String(decrypted, "utf-8");
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static byte[] getDecrypted(Context context, String str, byte[] bArr) {
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
                return a.b(str2.substring(16), str2.substring(0, 16), bArr);
            }
            return null;
        } catch (Exception e) {
            return null;
        } catch (UnsatisfiedLinkError e2) {
            l.b("UnsatisfiedLinkError getDecrypted ", context);
            return null;
        }
    }

    public static String getEncrypted(Context context, String str, String str2) {
        try {
            return b.a(getEncrypted(context, str, str2.getBytes()), "utf-8");
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] getEncrypted(Context context, String str, byte[] bArr) {
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
                return a.a(str2.substring(16), str2.substring(0, 16), bArr);
            }
            return null;
        } catch (Exception e) {
            return null;
        } catch (UnsatisfiedLinkError e2) {
            l.b("UnsatisfiedLinkError getEncrypted " + bArr, context);
            return null;
        }
    }

    private static native byte[] getKey(String str);

    public static native boolean verify(byte[] bArr, String str, int i);
}
