package com.baidu.adp.widget;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
class ab implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
