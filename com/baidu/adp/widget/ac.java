package com.baidu.adp.widget;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
final class ac implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        return f * f * f * f * f;
    }
}
