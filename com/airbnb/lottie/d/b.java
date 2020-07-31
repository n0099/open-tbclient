package com.airbnb.lottie.d;
/* loaded from: classes20.dex */
public class b {
    private static float k(float f) {
        return f <= 0.0031308f ? 12.92f * f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float l(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((0.055f + f) / 1.055f, 2.4000000953674316d);
    }

    public static int b(float f, int i, int i2) {
        float f2 = ((i >> 24) & 255) / 255.0f;
        float l = l(((i >> 16) & 255) / 255.0f);
        float l2 = l(((i >> 8) & 255) / 255.0f);
        float l3 = l((i & 255) / 255.0f);
        float l4 = l(((i2 >> 16) & 255) / 255.0f);
        return (Math.round((f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f)) * 255.0f) << 24) | (Math.round(k(l + ((l4 - l) * f)) * 255.0f) << 16) | (Math.round(k(l2 + ((l(((i2 >> 8) & 255) / 255.0f) - l2) * f)) * 255.0f) << 8) | Math.round(k(l3 + ((l((i2 & 255) / 255.0f) - l3) * f)) * 255.0f);
    }
}
