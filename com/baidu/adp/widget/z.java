package com.baidu.adp.widget;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
abstract class z {

    /* renamed from: a  reason: collision with root package name */
    public static final Interpolator f528a = new aa();
    public static final Interpolator b = new ab();

    public static int a(float f, float f2, boolean z) {
        if (z) {
            return (int) (f - (f528a.getInterpolation(f2 / (f2 - f)) * f));
        }
        return (int) (f528a.getInterpolation(f2 / f) * f);
    }
}
