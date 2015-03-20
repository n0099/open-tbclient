package com.baidu.adp.widget;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
class s implements Interpolator {
    private final float Jt;

    public s(float f) {
        this.Jt = f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = this.Jt * f;
        if (f2 > 0.9d) {
            return 1.0f;
        }
        return f2;
    }
}
