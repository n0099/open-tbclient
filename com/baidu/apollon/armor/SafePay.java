package com.baidu.apollon.armor;

import android.util.Log;
/* loaded from: classes.dex */
public final class SafePay {
    public static final int INPUT_ID_CVV = 2;
    public static final int INPUT_ID_CVV_MAX_LEN = 3;
    public static final int INPUT_ID_PW = 1;
    public static final String KEY = "key";
    public static final int SIG_RSA_MD2 = 2;
    public static final int SIG_RSA_MD4 = 3;
    public static final int SIG_RSA_MD5 = 4;
    public static final int SIG_RSA_RAW = 0;
    public static final int SIG_RSA_SHA1 = 5;
    public static final int SIG_RSA_SHA224 = 14;
    public static final int SIG_RSA_SHA256 = 11;
    public static final int SIG_RSA_SHA384 = 12;
    public static final int SIG_RSA_SHA512 = 13;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3579a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f3580b = "SafePay";

    /* renamed from: c  reason: collision with root package name */
    public static SafePay f3581c = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f3582d = true;

    static {
        try {
            System.loadLibrary("bd_wsp_v1_1");
        } catch (UnsatisfiedLinkError e2) {
            f3582d = false;
            Log.e(f3580b, "load library failed, " + e2.getMessage());
        }
    }

    public static synchronized SafePay getInstance() {
        SafePay safePay;
        synchronized (SafePay.class) {
            if (f3581c == null) {
                SafePay safePay2 = new SafePay();
                f3581c = safePay2;
                try {
                    safePay2.init();
                } catch (Throwable unused) {
                }
            }
            safePay = f3581c;
        }
        return safePay;
    }

    public static String unicodeDecode(String str) {
        int i2;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            char charAt = str.charAt(i3);
            if (charAt == '\\' && (i2 = i3 + 1) != length && str.charAt(i2) == 'u') {
                int i4 = i3 + 2;
                i3 += 6;
                sb.append((char) Integer.parseInt(str.substring(i4, i3), 16));
            } else {
                sb.append(charAt);
                i3++;
            }
        }
        return sb.toString();
    }

    public native void clearKeyboard(int i2);

    public native String decrypt(String str);

    public String decryptProxy(String str) {
        try {
            return decrypt(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public native String encrypt(String str);

    public String encryptProxy(String str) {
        try {
            return encrypt(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public native String getA(long j);

    public native String getB(int i2);

    public native String getC(int i2);

    public native String getDyKey(byte[] bArr, byte[] bArr2, int i2, int i3);

    public native String getSafeStr(int i2);

    public native String getToken();

    public native String getak();

    public native String getpw();

    public String getpwProxy() {
        try {
            return getpw();
        } catch (Throwable unused) {
            return "";
        }
    }

    public native void init();

    public native int inputKeyboardChar(int i2, char c2, int i3);

    public native String localDecrypt(String str);

    public native String localDecrypt1(String str);

    public String localDecryptProxy(String str) {
        try {
            return localDecrypt(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public native String localEncrypt(String str);

    public native String localEncrypt1(String str);

    public String localEncryptProxy(String str) {
        try {
            return localEncrypt(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public native String mapScancode(String str);

    public boolean prepareCompleted() {
        return f3582d;
    }

    public native String rsaDecrypt(String str);

    public native int rsaVerify(int i2, int i3, int i4, byte[] bArr, byte[] bArr2);

    public native String tokenDecrypt(String str);

    public native String tokenEncrypt(String str);
}
