package com.airbnb.lottie.d;
/* loaded from: classes7.dex */
public class b {
    private static float j(float f) {
        return f <= 0.0031308f ? 12.92f * f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float k(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((0.055f + f) / 1.055f, 2.4000000953674316d);
    }

    public static int b(float f, int i, int i2) {
        float f2 = ((i >> 24) & 255) / 255.0f;
        float k = k(((i >> 16) & 255) / 255.0f);
        float k2 = k(((i >> 8) & 255) / 255.0f);
        float k3 = k((i & 255) / 255.0f);
        float k4 = k(((i2 >> 16) & 255) / 255.0f);
        return (Math.round((f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f)) * 255.0f) << 24) | (Math.round(j(k + ((k4 - k) * f)) * 255.0f) << 16) | (Math.round(j(k2 + ((k(((i2 >> 8) & 255) / 255.0f) - k2) * f)) * 255.0f) << 8) | Math.round(j(k3 + ((k((i2 & 255) / 255.0f) - k3) * f)) * 255.0f);
    }
}
