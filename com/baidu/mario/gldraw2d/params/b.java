package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes9.dex */
public class b implements Cloneable {
    private float[] aEs;
    private boolean aEt;
    private boolean aEu;
    private float[] kH = new float[16];
    private long mTimestamp;

    public b() {
        Matrix.setIdentityM(this.kH, 0);
        this.aEs = new float[16];
        Matrix.setIdentityM(this.aEs, 0);
        this.aEt = false;
        this.aEu = false;
    }

    public float[] zB() {
        return this.kH;
    }

    public void e(float[] fArr) {
        this.kH = fArr;
    }

    public float[] zC() {
        return this.aEs;
    }

    public void f(float[] fArr) {
        this.aEs = fArr;
    }

    public boolean zD() {
        return this.aEt;
    }

    public boolean zE() {
        return this.aEu;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: zF */
    public b clone() {
        b bVar = null;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (bVar != null) {
            bVar.e((float[]) this.kH.clone());
            bVar.f((float[]) this.aEs.clone());
        }
        return bVar;
    }
}
