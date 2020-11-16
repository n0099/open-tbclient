package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes6.dex */
public class b implements Cloneable {
    private boolean bUI;
    private boolean bUJ;
    private float[] mMVPMatrix = new float[16];
    private float[] mTexMatrix;
    private long mTimestamp;

    public b() {
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        this.mTexMatrix = new float[16];
        Matrix.setIdentityM(this.mTexMatrix, 0);
        this.bUI = false;
        this.bUJ = false;
    }

    public float[] Yc() {
        return this.mMVPMatrix;
    }

    public void setMVPMatrix(float[] fArr) {
        this.mMVPMatrix = fArr;
    }

    public float[] Yd() {
        return this.mTexMatrix;
    }

    public void u(float[] fArr) {
        this.mTexMatrix = fArr;
    }

    public boolean Ye() {
        return this.bUI;
    }

    public boolean Yf() {
        return this.bUJ;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Yg */
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
