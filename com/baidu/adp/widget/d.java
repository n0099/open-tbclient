package com.baidu.adp.widget;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
abstract class d {
    public static final Interpolator sInterpolator = new Interpolator() { // from class: com.baidu.adp.widget.d.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    public static final Interpolator Mm = new Interpolator() { // from class: com.baidu.adp.widget.d.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f * f * f * f * f;
        }
    };

    public static int a(float f, float f2, boolean z) {
        if (z) {
            return (int) (f - (sInterpolator.getInterpolation(f2 / (f2 - f)) * f));
        }
        return (int) (sInterpolator.getInterpolation(f2 / f) * f);
    }
}
