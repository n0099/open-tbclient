package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes11.dex */
public class b implements Cloneable {
    private float[] bnc;
    private boolean bnd;
    private boolean bne;
    private float[] mMVPMatrix = new float[16];
    private long mTimestamp;

    public b() {
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        this.bnc = new float[16];
        Matrix.setIdentityM(this.bnc, 0);
        this.bnd = false;
        this.bne = false;
    }

    public float[] Kt() {
        return this.mMVPMatrix;
    }

    public void s(float[] fArr) {
        this.mMVPMatrix = fArr;
    }

    public float[] Ku() {
        return this.bnc;
    }

    public void t(float[] fArr) {
        this.bnc = fArr;
    }

    public boolean Kv() {
        return this.bnd;
    }

    public boolean Kw() {
        return this.bne;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Kx */
    public b clone() {
        b bVar = null;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (bVar != null) {
            bVar.s((float[]) this.mMVPMatrix.clone());
            bVar.t((float[]) this.bnc.clone());
        }
        return bVar;
    }
}
