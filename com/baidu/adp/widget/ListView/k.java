package com.baidu.adp.widget.ListView;

import android.view.animation.OvershootInterpolator;
/* loaded from: classes.dex */
public class k extends OvershootInterpolator {
    private final float Zj;

    public k() {
        this.Zj = 2.0f;
    }

    public k(float f) {
        super(f);
        this.Zj = f;
    }

    @Override // android.view.animation.OvershootInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (((f2 * (this.Zj + 1.0f)) + this.Zj) * (-0.5f) * f2) + 1.0f;
    }
}
