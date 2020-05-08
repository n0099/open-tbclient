package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes11.dex */
public class b implements Cloneable {
    private float[] bfD;
    private boolean bfE;
    private boolean bfF;
    private float[] mMVPMatrix = new float[16];
    private long mTimestamp;

    public b() {
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        this.bfD = new float[16];
        Matrix.setIdentityM(this.bfD, 0);
        this.bfE = false;
        this.bfF = false;
    }

    public float[] IA() {
        return this.mMVPMatrix;
    }

    public void s(float[] fArr) {
        this.mMVPMatrix = fArr;
    }

    public float[] IB() {
        return this.bfD;
    }

    public void t(float[] fArr) {
        this.bfD = fArr;
    }

    public boolean IC() {
        return this.bfE;
    }

    public boolean ID() {
        return this.bfF;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: IE */
    public b clone() {
        b bVar = null;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (bVar != null) {
            bVar.s((float[]) this.mMVPMatrix.clone());
            bVar.t((float[]) this.bfD.clone());
        }
        return bVar;
    }
}
