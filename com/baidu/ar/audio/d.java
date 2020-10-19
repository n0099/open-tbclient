package com.baidu.ar.audio;
/* loaded from: classes14.dex */
class d {
    private static final String TAG = d.class.getSimpleName();

    d() {
    }

    private static int a(byte b, byte b2) {
        int i = (b & 255) + ((b2 & 255) << 8);
        return i >= 32768 ? i - 65535 : i;
    }

    public static void a(byte[] bArr, double d) {
        for (int i = 0; i < bArr.length; i += 2) {
            int a2 = a(bArr[i], bArr[i + 1]);
            int i2 = (int) (a2 * d);
            if (i2 < 32767 && i2 > -32768) {
                a2 = (short) i2;
            } else if (i2 > 32767) {
                a2 = 32767;
            } else if (i2 < -32768) {
                a2 = -32768;
            }
            bArr[i] = (byte) (a2 & 255);
            bArr[i + 1] = (byte) ((a2 >> 8) & 255);
        }
    }

    public static double b(byte[] bArr) {
        double d = 0.0d;
        for (int i = 0; i < bArr.length; i += 2) {
            d += Math.abs(a(bArr[i], bArr[i + 1]));
        }
        return Math.log10(((d / bArr.length) / 2.0d) + 1.0d) * 10.0d;
    }

    public static double c(byte[] bArr) {
        double d = 0.0d;
        for (int i = 0; i < bArr.length; i += 2) {
            int a2 = a(bArr[i], bArr[i + 1]);
            d += a2 * a2;
        }
        return Math.min(5000.0d, Math.sqrt((d / bArr.length) / 2.0d)) / 50.0d;
    }
}
