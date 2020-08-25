package com.baidu.adp.widget.ListView;

import android.view.animation.OvershootInterpolator;
/* loaded from: classes2.dex */
public class m extends OvershootInterpolator {
    private final float Wn;

    public m() {
        this.Wn = 2.0f;
    }

    public m(float f) {
        super(f);
        this.Wn = f;
    }

    @Override // android.view.animation.OvershootInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (((f2 * (this.Wn + 1.0f)) + this.Wn) * (-0.5f) * f2) + 1.0f;
    }
}
