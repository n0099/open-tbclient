package com.baidu.helios.common.b.a;
/* loaded from: classes3.dex */
public class a {
    private static final char[] asV = "0123456789ABCDEF".toCharArray();
    private static final char[] asW = "0123456789abcdef".toCharArray();
    private static final byte[] asX = new byte[128];

    static {
        for (int i = 0; i < 10; i++) {
            asX[i + 48] = (byte) i;
            asX[i + 65] = (byte) (i + 10);
            asX[i + 97] = (byte) (i + 10);
        }
    }

    public static char[] b(byte[] bArr, boolean z) {
        int i = 0;
        char[] cArr = z ? asV : asW;
        char[] cArr2 = new char[bArr.length * 2];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 < bArr.length) {
                byte b2 = bArr[i3];
                int i4 = i2 + 1;
                cArr2[i2] = cArr[(b2 & 240) >>> 4];
                i2 = i4 + 1;
                cArr2[i4] = cArr[b2 & 15];
                i = i3 + 1;
            } else {
                return cArr2;
            }
        }
    }

    public static String c(byte[] bArr, boolean z) {
        return new String(b(bArr, z));
    }
}
