package com.baidu.adp.widget.ListView;

import android.view.animation.OvershootInterpolator;
/* loaded from: classes.dex */
public class m extends OvershootInterpolator {
    private final float WV;

    public m() {
        this.WV = 2.0f;
    }

    public m(float f) {
        super(f);
        this.WV = f;
    }

    @Override // android.view.animation.OvershootInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (((f2 * (this.WV + 1.0f)) + this.WV) * (-0.5f) * f2) + 1.0f;
    }
}
