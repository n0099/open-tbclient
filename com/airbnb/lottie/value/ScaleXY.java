package com.airbnb.lottie.value;
/* loaded from: classes.dex */
public class ScaleXY {
    public float scaleX;
    public float scaleY;

    public ScaleXY() {
        this(1.0f, 1.0f);
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public String toString() {
        return getScaleX() + "x" + getScaleY();
    }

    public ScaleXY(float f, float f2) {
        this.scaleX = f;
        this.scaleY = f2;
    }

    public boolean equals(float f, float f2) {
        if (this.scaleX == f && this.scaleY == f2) {
            return true;
        }
        return false;
    }

    public void set(float f, float f2) {
        this.scaleX = f;
        this.scaleY = f2;
    }
}
