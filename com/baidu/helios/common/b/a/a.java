package com.baidu.helios.common.b.a;
/* loaded from: classes4.dex */
public class a {
    private static final char[] awN = "0123456789ABCDEF".toCharArray();
    private static final char[] awO = "0123456789abcdef".toCharArray();
    private static final byte[] awP = new byte[128];

    static {
        for (int i = 0; i < 10; i++) {
            awP[i + 48] = (byte) i;
            awP[i + 65] = (byte) (i + 10);
            awP[i + 97] = (byte) (i + 10);
        }
    }

    public static char[] b(byte[] bArr, boolean z) {
        int i = 0;
        char[] cArr = z ? awN : awO;
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
