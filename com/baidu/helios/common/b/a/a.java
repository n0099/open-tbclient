package com.baidu.helios.common.b.a;
/* loaded from: classes12.dex */
public class a {
    private static final char[] arQ = "0123456789ABCDEF".toCharArray();
    private static final char[] arR = "0123456789abcdef".toCharArray();
    private static final byte[] arS = new byte[128];

    static {
        for (int i = 0; i < 10; i++) {
            arS[i + 48] = (byte) i;
            arS[i + 65] = (byte) (i + 10);
            arS[i + 97] = (byte) (i + 10);
        }
    }

    public static char[] b(byte[] bArr, boolean z) {
        int i = 0;
        char[] cArr = z ? arQ : arR;
        char[] cArr2 = new char[bArr.length * 2];
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b & 240) >>> 4];
            i = i2 + 1;
            cArr2[i2] = cArr[b & 15];
        }
        return cArr2;
    }

    public static String c(byte[] bArr, boolean z) {
        return new String(b(bArr, z));
    }
}
