package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes2.dex */
public class b implements Cloneable {
    private float[] awO;
    private boolean awP;
    private boolean awQ;
    private float[] im = new float[16];
    private long mTimestamp;

    public b() {
        Matrix.setIdentityM(this.im, 0);
        this.awO = new float[16];
        Matrix.setIdentityM(this.awO, 0);
        this.awP = false;
        this.awQ = false;
    }

    public float[] xM() {
        return this.im;
    }

    public void e(float[] fArr) {
        this.im = fArr;
    }

    public float[] xN() {
        return this.awO;
    }

    public void f(float[] fArr) {
        this.awO = fArr;
    }

    public boolean xO() {
        return this.awP;
    }

    public boolean xP() {
        return this.awQ;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: xQ */
    public b clone() {
        b bVar = null;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (bVar != null) {
            bVar.e((float[]) this.im.clone());
            bVar.f((float[]) this.awO.clone());
        }
        return bVar;
    }
}
