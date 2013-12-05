package com.baidu.adp.widget;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Interpolator f603a = new b();
    public static final Interpolator b = new c();

    public static int a(float f, float f2, boolean z) {
        if (z) {
            return (int) (f - (f603a.getInterpolation(f2 / (f2 - f)) * f));
        }
        return (int) (f603a.getInterpolation(f2 / f) * f);
    }
}
