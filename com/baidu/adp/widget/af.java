package com.baidu.adp.widget;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
final class af implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
