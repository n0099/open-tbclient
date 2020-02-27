package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes11.dex */
public class b implements Cloneable {
    private float[] aJq;
    private boolean aJr;
    private boolean aJs;
    private float[] mMVPMatrix = new float[16];
    private long mTimestamp;

    public b() {
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        this.aJq = new float[16];
        Matrix.setIdentityM(this.aJq, 0);
        this.aJr = false;
        this.aJs = false;
    }

    public float[] Cn() {
        return this.mMVPMatrix;
    }

    public void e(float[] fArr) {
        this.mMVPMatrix = fArr;
    }

    public float[] Co() {
        return this.aJq;
    }

    public void f(float[] fArr) {
        this.aJq = fArr;
    }

    public boolean Cp() {
        return this.aJr;
    }

    public boolean Cq() {
        return this.aJs;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Cr */
    public b clone() {
        b bVar = null;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (bVar != null) {
            bVar.e((float[]) this.mMVPMatrix.clone());
            bVar.f((float[]) this.aJq.clone());
        }
        return bVar;
    }
}
