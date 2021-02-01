package com.baidu.adp.widget.ListView;

import android.view.animation.OvershootInterpolator;
/* loaded from: classes.dex */
public class k extends OvershootInterpolator {
    private final float XP;

    public k() {
        this.XP = 2.0f;
    }

    public k(float f) {
        super(f);
        this.XP = f;
    }

    @Override // android.view.animation.OvershootInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (((f2 * (this.XP + 1.0f)) + this.XP) * (-0.5f) * f2) + 1.0f;
    }
}
