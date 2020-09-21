package com.baidu.adp.widget.ListView;

import android.view.animation.OvershootInterpolator;
/* loaded from: classes.dex */
public class m extends OvershootInterpolator {
    private final float WF;

    public m() {
        this.WF = 2.0f;
    }

    public m(float f) {
        super(f);
        this.WF = f;
    }

    @Override // android.view.animation.OvershootInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (((f2 * (this.WF + 1.0f)) + this.WF) * (-0.5f) * f2) + 1.0f;
    }
}
