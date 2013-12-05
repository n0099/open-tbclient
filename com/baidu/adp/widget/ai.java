package com.baidu.adp.widget;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
abstract class ai {

    /* renamed from: a  reason: collision with root package name */
    public static final Interpolator f606a = new aj();
    public static final Interpolator b = new ak();

    public static int a(float f, float f2, boolean z) {
        if (z) {
            return (int) (f - (f606a.getInterpolation(f2 / (f2 - f)) * f));
        }
        return (int) (f606a.getInterpolation(f2 / f) * f);
    }
}
