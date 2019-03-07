package com.baidu.adp.widget.ListView;

import android.view.animation.OvershootInterpolator;
/* loaded from: classes.dex */
public class j extends OvershootInterpolator {
    private final float Qh;

    public j() {
        this.Qh = 2.0f;
    }

    public j(float f) {
        super(f);
        this.Qh = f;
    }

    @Override // android.view.animation.OvershootInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (((f2 * (this.Qh + 1.0f)) + this.Qh) * (-0.5f) * f2) + 1.0f;
    }
}
