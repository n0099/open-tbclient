package com.baidu.adp.widget.ListView;

import android.view.animation.OvershootInterpolator;
/* loaded from: classes.dex */
public class m extends OvershootInterpolator {
    private final float VJ;

    public m() {
        this.VJ = 2.0f;
    }

    public m(float f) {
        super(f);
        this.VJ = f;
    }

    @Override // android.view.animation.OvershootInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (((f2 * (this.VJ + 1.0f)) + this.VJ) * (-0.5f) * f2) + 1.0f;
    }
}
