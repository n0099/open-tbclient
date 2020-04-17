package com.baidu.adp.widget.ListView;

import android.view.animation.OvershootInterpolator;
/* loaded from: classes.dex */
public class j extends OvershootInterpolator {
    private final float UV;

    public j() {
        this.UV = 2.0f;
    }

    public j(float f) {
        super(f);
        this.UV = f;
    }

    @Override // android.view.animation.OvershootInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (((f2 * (this.UV + 1.0f)) + this.UV) * (-0.5f) * f2) + 1.0f;
    }
}
