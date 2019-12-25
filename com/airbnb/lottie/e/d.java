package com.airbnb.lottie.e;

import com.baidu.mobstat.Config;
/* loaded from: classes4.dex */
public class d {
    private final float kB;
    private final float kC;

    public d(float f, float f2) {
        this.kB = f;
        this.kC = f2;
    }

    public d() {
        this(1.0f, 1.0f);
    }

    public float getScaleX() {
        return this.kB;
    }

    public float getScaleY() {
        return this.kC;
    }

    public String toString() {
        return getScaleX() + Config.EVENT_HEAT_X + getScaleY();
    }
}
