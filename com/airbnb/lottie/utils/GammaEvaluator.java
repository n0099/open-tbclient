package com.airbnb.lottie.utils;
/* loaded from: classes.dex */
public class GammaEvaluator {
    public static float EOCF_sRGB(float f2) {
        return f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((f2 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float OECF_sRGB(float f2) {
        return f2 <= 0.0031308f ? f2 * 12.92f : (float) ((Math.pow(f2, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int evaluate(float f2, int i2, int i3) {
        if (i2 == i3) {
            return i2;
        }
        float f3 = ((i2 >> 24) & 255) / 255.0f;
        float EOCF_sRGB = EOCF_sRGB(((i2 >> 16) & 255) / 255.0f);
        float EOCF_sRGB2 = EOCF_sRGB(((i2 >> 8) & 255) / 255.0f);
        float EOCF_sRGB3 = EOCF_sRGB((i2 & 255) / 255.0f);
        float EOCF_sRGB4 = EOCF_sRGB(((i3 >> 16) & 255) / 255.0f);
        float EOCF_sRGB5 = EOCF_sRGB(((i3 >> 8) & 255) / 255.0f);
        float EOCF_sRGB6 = EOCF_sRGB3 + (f2 * (EOCF_sRGB((i3 & 255) / 255.0f) - EOCF_sRGB3));
        return (Math.round(OECF_sRGB(EOCF_sRGB + ((EOCF_sRGB4 - EOCF_sRGB) * f2)) * 255.0f) << 16) | (Math.round((f3 + (((((i3 >> 24) & 255) / 255.0f) - f3) * f2)) * 255.0f) << 24) | (Math.round(OECF_sRGB(EOCF_sRGB2 + ((EOCF_sRGB5 - EOCF_sRGB2) * f2)) * 255.0f) << 8) | Math.round(OECF_sRGB(EOCF_sRGB6) * 255.0f);
    }
}
