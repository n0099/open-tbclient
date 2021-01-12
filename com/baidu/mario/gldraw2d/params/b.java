package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes14.dex */
public class b implements Cloneable {
    private boolean cbS;
    private boolean cbT;
    private float[] mMVPMatrix = new float[16];
    private float[] mTexMatrix;
    private long mTimestamp;

    public b() {
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        this.mTexMatrix = new float[16];
        Matrix.setIdentityM(this.mTexMatrix, 0);
        this.cbS = false;
        this.cbT = false;
    }

    public float[] getMVPMatrix() {
        return this.mMVPMatrix;
    }

    public void setMVPMatrix(float[] fArr) {
        this.mMVPMatrix = fArr;
    }

    public float[] Yz() {
        return this.mTexMatrix;
    }

    public void t(float[] fArr) {
        this.mTexMatrix = fArr;
    }

    public boolean YA() {
        return this.cbS;
    }

    public boolean YB() {
        return this.cbT;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: YC */
    public b clone() {
        b bVar = null;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (bVar != null) {
            bVar.setMVPMatrix((float[]) this.mMVPMatrix.clone());
            bVar.t((float[]) this.mTexMatrix.clone());
        }
        return bVar;
    }
}
