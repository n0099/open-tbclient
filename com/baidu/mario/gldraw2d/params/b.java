package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes4.dex */
public class b implements Cloneable {
    private boolean bBL;
    private boolean bBM;
    private float[] mMVPMatrix = new float[16];
    private float[] mTexMatrix;
    private long mTimestamp;

    public b() {
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        this.mTexMatrix = new float[16];
        Matrix.setIdentityM(this.mTexMatrix, 0);
        this.bBL = false;
        this.bBM = false;
    }

    public float[] Sz() {
        return this.mMVPMatrix;
    }

    public void setMVPMatrix(float[] fArr) {
        this.mMVPMatrix = fArr;
    }

    public float[] SA() {
        return this.mTexMatrix;
    }

    public void u(float[] fArr) {
        this.mTexMatrix = fArr;
    }

    public boolean SB() {
        return this.bBL;
    }

    public boolean SC() {
        return this.bBM;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: SD */
    public b clone() {
        b bVar = null;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (bVar != null) {
            bVar.setMVPMatrix((float[]) this.mMVPMatrix.clone());
            bVar.u((float[]) this.mTexMatrix.clone());
        }
        return bVar;
    }
}
