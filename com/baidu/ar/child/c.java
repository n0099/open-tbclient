package com.baidu.ar.child;
/* loaded from: classes11.dex */
public class c {
    private int angle;
    private int height;
    private float kZ;
    private float[] la;
    private float[] lb;
    private boolean lc;
    private long ld;
    private byte[] le;
    private int width;

    public float[] cv() {
        return this.la;
    }

    public float[] cw() {
        return this.lb;
    }

    public void d(float f) {
        this.kZ = f;
    }

    public void d(float[] fArr) {
        this.la = fArr;
    }

    public void e(float[] fArr) {
        this.lb = fArr;
    }

    public void f(byte[] bArr) {
        this.le = bArr;
    }

    public long getHandle() {
        return this.ld;
    }

    public void setHandle(long j) {
        this.ld = j;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public void v(boolean z) {
        this.lc = z;
    }

    public void x(int i) {
        this.angle = i;
    }
}
