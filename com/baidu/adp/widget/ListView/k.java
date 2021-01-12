package com.baidu.adp.widget.ListView;

import android.view.animation.OvershootInterpolator;
/* loaded from: classes.dex */
public class k extends OvershootInterpolator {
    private final float XT;

    public k() {
        this.XT = 2.0f;
    }

    public k(float f) {
        super(f);
        this.XT = f;
    }

    @Override // android.view.animation.OvershootInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (((f2 * (this.XT + 1.0f)) + this.XT) * (-0.5f) * f2) + 1.0f;
    }
}
