package com.baidu.adp.widget.ListView;

import android.view.animation.OvershootInterpolator;
/* loaded from: classes.dex */
public class l extends OvershootInterpolator {
    private final float Vn;

    public l() {
        this.Vn = 2.0f;
    }

    public l(float f) {
        super(f);
        this.Vn = f;
    }

    @Override // android.view.animation.OvershootInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (((f2 * (this.Vn + 1.0f)) + this.Vn) * (-0.5f) * f2) + 1.0f;
    }
}
