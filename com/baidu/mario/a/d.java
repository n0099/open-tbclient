package com.baidu.mario.a;

import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes2.dex */
class d {
    private static final String TAG = d.class.getSimpleName();

    d() {
    }

    public static double v(byte[] bArr) {
        double d = 0.0d;
        for (int i = 0; i < bArr.length; i += 2) {
            int i2 = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
            if (i2 >= 32768) {
                i2 = SupportMenu.USER_MASK - i2;
            }
            d += Math.abs(i2);
        }
        return Math.log10(((d / bArr.length) / 2.0d) + 1.0d) * 10.0d;
    }

    public static double w(byte[] bArr) {
        double d = 0.0d;
        for (int i = 0; i < bArr.length; i += 2) {
            int i2 = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
            if (i2 >= 32768) {
                i2 = SupportMenu.USER_MASK - i2;
            }
            d += i2 * i2;
        }
        return Math.min(5000.0d, Math.sqrt((d / bArr.length) / 2.0d)) / 50.0d;
    }
}
