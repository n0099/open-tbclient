package com.baidu.ar.child;
/* loaded from: classes.dex */
public class c {
    public int angle;
    public int height;
    public float lX;
    public float[] lY;
    public float[] lZ;
    public boolean ma;
    public long mb;
    public byte[] mc;
    public int width;

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
