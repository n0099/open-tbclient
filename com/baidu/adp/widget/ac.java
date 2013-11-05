package com.baidu.adp.widget;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
abstract class ac {

    /* renamed from: a  reason: collision with root package name */
    public static final Interpolator f595a = new ad();
    public static final Interpolator b = new ae();

    public static int a(float f, float f2, boolean z) {
        if (z) {
            return (int) (f - (f595a.getInterpolation(f2 / (f2 - f)) * f));
        }
        return (int) (f595a.getInterpolation(f2 / f) * f);
    }
}
