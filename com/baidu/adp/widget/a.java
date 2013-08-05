package com.baidu.adp.widget;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Interpolator f483a = new b();
    public static final Interpolator b = new c();

    public static int a(float f, float f2, boolean z) {
        if (z) {
            return (int) (f - (f483a.getInterpolation(f2 / (f2 - f)) * f));
        }
        return (int) (f483a.getInterpolation(f2 / f) * f);
    }
}
