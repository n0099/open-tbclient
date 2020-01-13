package com.airbnb.lottie.d;
/* loaded from: classes5.dex */
public class b {
    private static float l(float f) {
        return f <= 0.0031308f ? 12.92f * f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float m(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((0.055f + f) / 1.055f, 2.4000000953674316d);
    }

    public static int b(float f, int i, int i2) {
        float f2 = ((i >> 24) & 255) / 255.0f;
        float m = m(((i >> 16) & 255) / 255.0f);
        float m2 = m(((i >> 8) & 255) / 255.0f);
        float m3 = m((i & 255) / 255.0f);
        float m4 = m(((i2 >> 16) & 255) / 255.0f);
        return (Math.round((f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f)) * 255.0f) << 24) | (Math.round(l(m + ((m4 - m) * f)) * 255.0f) << 16) | (Math.round(l(m2 + ((m(((i2 >> 8) & 255) / 255.0f) - m2) * f)) * 255.0f) << 8) | Math.round(l(m3 + ((m((i2 & 255) / 255.0f) - m3) * f)) * 255.0f);
    }
}
