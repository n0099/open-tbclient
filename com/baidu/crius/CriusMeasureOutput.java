package com.baidu.crius;
/* loaded from: classes11.dex */
public class CriusMeasureOutput {
    public static long make(float f, float f2) {
        int floatToRawIntBits = Float.floatToRawIntBits(f);
        return Float.floatToRawIntBits(f2) | (floatToRawIntBits << 32);
    }

    public static long make(int i, int i2) {
        return make(i, i2);
    }

    public static float getWidth(long j) {
        return Float.intBitsToFloat((int) ((-1) & (j >> 32)));
    }

    public static float getHeight(long j) {
        return Float.intBitsToFloat((int) ((-1) & j));
    }
}
