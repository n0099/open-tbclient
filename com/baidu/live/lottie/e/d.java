package com.baidu.live.lottie.e;
/* loaded from: classes10.dex */
public class d {
    private final float Ia;
    private final float Ib;

    public d(float f, float f2) {
        this.Ia = f;
        this.Ib = f2;
    }

    public d() {
        this(1.0f, 1.0f);
    }

    public float getScaleX() {
        return this.Ia;
    }

    public float getScaleY() {
        return this.Ib;
    }

    public String toString() {
        return getScaleX() + "x" + getScaleY();
    }
}
