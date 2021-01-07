package com.baidu.helios.common.b.a;
/* loaded from: classes4.dex */
public class a {
    private static final char[] axH = "0123456789ABCDEF".toCharArray();
    private static final char[] axI = "0123456789abcdef".toCharArray();
    private static final byte[] axJ = new byte[128];

    static {
        for (int i = 0; i < 10; i++) {
            axJ[i + 48] = (byte) i;
            axJ[i + 65] = (byte) (i + 10);
            axJ[i + 97] = (byte) (i + 10);
        }
    }

    public static char[] b(byte[] bArr, boolean z) {
        int i = 0;
        char[] cArr = z ? axH : axI;
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
