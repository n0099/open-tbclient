package com.baidu.ar.child;
/* loaded from: classes6.dex */
public class c {
    private int angle;
    private int height;
    private float lX;
    private float[] lY;
    private float[] lZ;
    private boolean ma;
    private long mb;
    private byte[] mc;
    private int width;

    public void c(float f) {
        this.lX = f;
    }

    public void c(float[] fArr) {
        this.lY = fArr;
    }

    public float[] cU() {
        return this.lY;
    }

    public float[] cV() {
        return this.lZ;
    }

    public void d(float[] fArr) {
        this.lZ = fArr;
    }

    public void f(byte[] bArr) {
        this.mc = bArr;
    }

    public long getHandle() {
        return this.mb;
    }

    public void setHandle(long j) {
        this.mb = j;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public void u(boolean z) {
        this.ma = z;
    }

    public void w(int i) {
        this.angle = i;
    }
}
