package com.baidu.adp.widget;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
abstract class e {
    public static final Interpolator sInterpolator = new Interpolator() { // from class: com.baidu.adp.widget.e.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    public static final Interpolator asU = new Interpolator() { // from class: com.baidu.adp.widget.e.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f * f * f * f * f;
        }
    };

    public static int c(float f, float f2, boolean z) {
        if (z) {
            return (int) (f - (sInterpolator.getInterpolation(f2 / (f2 - f)) * f));
        }
        return (int) (sInterpolator.getInterpolation(f2 / f) * f);
    }
}
