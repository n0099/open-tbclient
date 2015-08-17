package com.baidu.adp.widget;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
class i implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return f * f * f * f * f;
    }
}
