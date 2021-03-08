package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes14.dex */
public class b implements Cloneable {
    private boolean chD;
    private boolean chE;
    private float[] mMVPMatrix = new float[16];
    private float[] mTexMatrix;
    private long mTimestamp;

    public b() {
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        this.mTexMatrix = new float[16];
        Matrix.setIdentityM(this.mTexMatrix, 0);
        this.chD = false;
        this.chE = false;
    }

    public float[] getMVPMatrix() {
        return this.mMVPMatrix;
    }

    public void setMVPMatrix(float[] fArr) {
        this.mMVPMatrix = fArr;
    }

    public float[] aav() {
        return this.mTexMatrix;
    }

    public void t(float[] fArr) {
        this.mTexMatrix = fArr;
    }

    public boolean aaw() {
        return this.chD;
    }

    public boolean aax() {
        return this.chE;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: aay */
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
