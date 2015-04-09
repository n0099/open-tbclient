package com.baidu.adp.widget;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
class s implements Interpolator {
    private final float Jv;

    public s(float f) {
        this.Jv = f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = this.Jv * f;
        if (f2 > 0.9d) {
            return 1.0f;
        }
        return f2;
    }
}
