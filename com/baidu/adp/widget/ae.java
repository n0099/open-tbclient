package com.baidu.adp.widget;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
abstract class ae {
    public static final Interpolator a = new af();
    public static final Interpolator b = new ag();

    public static int a(float f, float f2, boolean z) {
        return (int) (a.getInterpolation(f2 / f) * f);
    }
}
