package com.baidu.ar.imu;
/* loaded from: classes12.dex */
public class f {
    private float[] hU;
    private int rL;
    private float rM;
    private float[] rN;

    public void K(int i) {
        this.rL = i;
    }

    public int eV() {
        return this.rL;
    }

    public void f(float f) {
        this.rM = f;
    }

    public float getAngle() {
        return this.rM;
    }

    public float[] getMatrix() {
        return this.hU;
    }

    public void h(float[] fArr) {
        this.rN = fArr;
    }

    public void setMatrix(float[] fArr) {
        this.hU = fArr;
    }
}
