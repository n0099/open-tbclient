package com.baidu.helios.common.b.a;
/* loaded from: classes6.dex */
public class a {
    private static final char[] aqC = "0123456789ABCDEF".toCharArray();
    private static final char[] aqD = "0123456789abcdef".toCharArray();
    private static final byte[] aqE = new byte[128];

    static {
        for (int i = 0; i < 10; i++) {
            aqE[i + 48] = (byte) i;
            aqE[i + 65] = (byte) (i + 10);
            aqE[i + 97] = (byte) (i + 10);
        }
    }

    public static char[] b(byte[] bArr, boolean z) {
        int i = 0;
        char[] cArr = z ? aqC : aqD;
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
