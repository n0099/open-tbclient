package com.baidu.ar.imu;
/* loaded from: classes.dex */
public class f {
    public float[] ik;
    public int sc;
    public float sd;
    public float[] se;

    public void M(int i) {
        this.sc = i;
    }

    public void e(float f) {
        this.sd = f;
    }

    public int eU() {
        return this.sc;
    }

    public void g(float[] fArr) {
        this.se = fArr;
    }

    public float getAngle() {
        return this.sd;
    }

    public float[] getMatrix() {
        return this.ik;
    }

    public void setMatrix(float[] fArr) {
        this.ik = fArr;
    }
}
