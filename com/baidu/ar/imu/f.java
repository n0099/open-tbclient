package com.baidu.ar.imu;
/* loaded from: classes3.dex */
public class f {
    private float[] ih;
    private int qH;
    private float qI;
    private float[] qJ;

    public void C(int i) {
        this.qH = i;
    }

    public void d(float f) {
        this.qI = f;
    }

    public int dv() {
        return this.qH;
    }

    public void g(float[] fArr) {
        this.qJ = fArr;
    }

    public float getAngle() {
        return this.qI;
    }

    public float[] getMatrix() {
        return this.ih;
    }

    public void setMatrix(float[] fArr) {
        this.ih = fArr;
    }
}
