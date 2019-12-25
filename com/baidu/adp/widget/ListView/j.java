package com.baidu.adp.widget.ListView;

import android.view.animation.OvershootInterpolator;
/* loaded from: classes.dex */
public class j extends OvershootInterpolator {
    private final float Bf;

    public j() {
        this.Bf = 2.0f;
    }

    public j(float f) {
        super(f);
        this.Bf = f;
    }

    @Override // android.view.animation.OvershootInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (((f2 * (this.Bf + 1.0f)) + this.Bf) * (-0.5f) * f2) + 1.0f;
    }
}
