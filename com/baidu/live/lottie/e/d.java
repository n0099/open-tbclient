package com.baidu.live.lottie.e;

import com.baidu.mobstat.Config;
/* loaded from: classes9.dex */
public class d {
    private final float HY;
    private final float HZ;

    public d(float f, float f2) {
        this.HY = f;
        this.HZ = f2;
    }

    public d() {
        this(1.0f, 1.0f);
    }

    public float getScaleX() {
        return this.HY;
    }

    public float getScaleY() {
        return this.HZ;
    }

    public String toString() {
        return getScaleX() + Config.EVENT_HEAT_X + getScaleY();
    }
}
