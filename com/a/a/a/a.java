package com.a.a.a;

import java.util.Random;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Random f1127a = new Random();

    public static float a(float f, float f2) {
        if (f2 == 0.0f) {
            if (f > 0.0f) {
                return 1.5707964f;
            }
            return f == 0.0f ? 0.0f : -1.5707964f;
        }
        float f3 = f / f2;
        if (Math.abs(f3) >= 1.0f) {
            float f4 = 1.5707964f - (f3 / ((f3 * f3) + 0.28f));
            return f < 0.0f ? f4 - 3.1415927f : f4;
        }
        float f5 = f3 / (((0.28f * f3) * f3) + 1.0f);
        if (f2 < 0.0f) {
            return (f < 0.0f ? -3.1415927f : 3.1415927f) + f5;
        }
        return f5;
    }

    public static float a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public static boolean b(float f, float f2) {
        return Math.abs(f - f2) <= 1.0E-6f;
    }
}
