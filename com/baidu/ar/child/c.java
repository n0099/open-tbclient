package com.baidu.ar.child;
/* loaded from: classes11.dex */
public class c {
    private int angle;
    private int height;
    private float lI;
    private float[] lJ;
    private float[] lK;
    private boolean lL;
    private long lM;
    private byte[] lN;
    private int width;

    public float[] cV() {
        return this.lJ;
    }

    public float[] cW() {
        return this.lK;
    }

    public void d(float f) {
        this.lI = f;
    }

    public void d(float[] fArr) {
        this.lJ = fArr;
    }

    public void e(float[] fArr) {
        this.lK = fArr;
    }

    public void f(byte[] bArr) {
        this.lN = bArr;
    }

    public long getHandle() {
        return this.lM;
    }

    public void setHandle(long j) {
        this.lM = j;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public void u(int i) {
        this.angle = i;
    }

    public void w(boolean z) {
        this.lL = z;
    }
}
