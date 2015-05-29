package com.baidu.adp.widget;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
class s implements Interpolator {
    private final float Jm;

    public s(float f) {
        this.Jm = f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = this.Jm * f;
        if (f2 > 0.9d) {
            return 1.0f;
        }
        return f2;
    }
}
