package com.baidu.ar.imu;
/* loaded from: classes11.dex */
public class f {
    private float[] iw;
    private int rg;
    private float rh;
    private float[] ri;

    public void I(int i) {
        this.rg = i;
    }

    public int dL() {
        return this.rg;
    }

    public void f(float f) {
        this.rh = f;
    }

    public float getAngle() {
        return this.rh;
    }

    public float[] getMatrix() {
        return this.iw;
    }

    public void h(float[] fArr) {
        this.ri = fArr;
    }

    public void setMatrix(float[] fArr) {
        this.iw = fArr;
    }
}
