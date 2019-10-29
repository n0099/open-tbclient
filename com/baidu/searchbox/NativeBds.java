package com.baidu.searchbox;
/* loaded from: classes6.dex */
public final class NativeBds {
    private static native byte[] ae0(String str, String str2);

    private static native byte[] ae1(String str, byte[] bArr);

    private static native byte[] dae1(String str, byte[] bArr);

    private NativeBds() {
    }

    public static byte[] ae(String str, String str2) {
        return ae0(str, str2);
    }

    public static byte[] ae(String str, byte[] bArr) {
        return ae1(str, bArr);
    }

    public static byte[] dae(String str, byte[] bArr) {
        return dae1(str, bArr);
    }

    static {
        System.loadLibrary("AesArithmetic_V1_1");
    }
}
