package com.baidu.adp.widget;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
abstract class af {

    /* renamed from: a  reason: collision with root package name */
    public static final Interpolator f601a = new ag();
    public static final Interpolator b = new ah();

    public static int a(float f, float f2, boolean z) {
        if (z) {
            return (int) (f - (f601a.getInterpolation(f2 / (f2 - f)) * f));
        }
        return (int) (f601a.getInterpolation(f2 / f) * f);
    }
}
