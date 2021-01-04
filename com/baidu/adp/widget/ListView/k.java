package com.baidu.adp.widget.ListView;

import android.view.animation.OvershootInterpolator;
/* loaded from: classes.dex */
public class k extends OvershootInterpolator {
    private final float XV;

    public k() {
        this.XV = 2.0f;
    }

    public k(float f) {
        super(f);
        this.XV = f;
    }

    @Override // android.view.animation.OvershootInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (((f2 * (this.XV + 1.0f)) + this.XV) * (-0.5f) * f2) + 1.0f;
    }
}
