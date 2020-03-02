package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes11.dex */
public class b implements Cloneable {
    private float[] aJr;
    private boolean aJs;
    private boolean aJt;
    private float[] mMVPMatrix = new float[16];
    private long mTimestamp;

    public b() {
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        this.aJr = new float[16];
        Matrix.setIdentityM(this.aJr, 0);
        this.aJs = false;
        this.aJt = false;
    }

    public float[] Cp() {
        return this.mMVPMatrix;
    }

    public void e(float[] fArr) {
        this.mMVPMatrix = fArr;
    }

    public float[] Cq() {
        return this.aJr;
    }

    public void f(float[] fArr) {
        this.aJr = fArr;
    }

    public boolean Cr() {
        return this.aJs;
    }

    public boolean Cs() {
        return this.aJt;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Ct */
    public b clone() {
        b bVar = null;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (bVar != null) {
            bVar.e((float[]) this.mMVPMatrix.clone());
            bVar.f((float[]) this.aJr.clone());
        }
        return bVar;
    }
}
