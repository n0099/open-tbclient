package com.baidu.adp.widget.ListView;

import android.view.animation.OvershootInterpolator;
/* loaded from: classes.dex */
public class j extends OvershootInterpolator {
    private final float Qi;

    public j() {
        this.Qi = 2.0f;
    }

    public j(float f) {
        super(f);
        this.Qi = f;
    }

    @Override // android.view.animation.OvershootInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (((f2 * (this.Qi + 1.0f)) + this.Qi) * (-0.5f) * f2) + 1.0f;
    }
}
