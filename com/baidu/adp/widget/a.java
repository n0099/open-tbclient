package com.baidu.adp.widget;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public final class a {
    public static final Interpolator a = new b();
    public static final Interpolator b = new c();

    public static int a(float f, float f2, boolean z) {
        if (z) {
            return (int) (f - (a.getInterpolation(f2 / (f2 - f)) * f));
        }
        return (int) (a.getInterpolation(f2 / f) * f);
    }
}
