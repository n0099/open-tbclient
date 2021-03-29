package com.badlogic.gdx.math;

import java.util.Random;
/* loaded from: classes.dex */
public final class a {
    static {
        new Random();
    }

    public static float a(float f2, float f3) {
        if (f3 == 0.0f) {
            int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i > 0) {
                return 1.5707964f;
            }
            return i == 0 ? 0.0f : -1.5707964f;
        }
        float f4 = f2 / f3;
        if (Math.abs(f4) >= 1.0f) {
            float f5 = 1.5707964f - (f4 / ((f4 * f4) + 0.28f));
            return f2 < 0.0f ? f5 - 3.1415927f : f5;
        }
        float f6 = f4 / (((0.28f * f4) * f4) + 1.0f);
        if (f3 < 0.0f) {
            return f6 + (f2 < 0.0f ? -3.1415927f : 3.1415927f);
        }
        return f6;
    }

    public static float b(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    public static boolean c(float f2, float f3) {
        return Math.abs(f2 - f3) <= 1.0E-6f;
    }
}
