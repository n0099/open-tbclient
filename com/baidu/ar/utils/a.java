package com.baidu.ar.utils;

import android.graphics.Bitmap;
/* loaded from: classes3.dex */
public class a {
    public static Bitmap a(int i, int i2, byte[] bArr) {
        int i3 = i * i2;
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = bArr[(i4 * i) + i5] & 255;
                int i7 = bArr[((i4 >> 1) * i) + i3 + (i5 & (-2)) + 0] & 255;
                int i8 = bArr[((i4 >> 1) * i) + i3 + (i5 & (-2)) + 1] & 255;
                if (i6 < 16) {
                    i6 = 16;
                }
                int round = Math.round((1.164f * (i6 - 16)) + (1.596f * (i8 - 128)));
                int round2 = Math.round(((1.164f * (i6 - 16)) - ((i8 - 128) * 0.813f)) - (0.391f * (i7 - 128)));
                int round3 = Math.round(((i6 - 16) * 1.164f) + ((i7 - 128) * 2.018f));
                if (round < 0) {
                    round = 0;
                } else if (round > 255) {
                    round = 255;
                }
                if (round2 < 0) {
                    round2 = 0;
                } else if (round2 > 255) {
                    round2 = 255;
                }
                if (round3 < 0) {
                    round3 = 0;
                } else if (round3 > 255) {
                    round3 = 255;
                }
                iArr[(i4 * i) + i5] = ((round3 << 16) - 16777216) + (round2 << 8) + round;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return createBitmap;
    }
}
