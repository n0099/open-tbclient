package com.baidu.adp.widget.ListView;

import android.view.animation.OvershootInterpolator;
/* loaded from: classes.dex */
public class m extends OvershootInterpolator {
    private final float VR;

    public m() {
        this.VR = 2.0f;
    }

    public m(float f) {
        super(f);
        this.VR = f;
    }

    @Override // android.view.animation.OvershootInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (((f2 * (this.VR + 1.0f)) + this.VR) * (-0.5f) * f2) + 1.0f;
    }
}
