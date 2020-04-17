package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes11.dex */
public class b implements Cloneable {
    private boolean bfA;
    private float[] bfy;
    private boolean bfz;
    private float[] mMVPMatrix = new float[16];
    private long mTimestamp;

    public b() {
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        this.bfy = new float[16];
        Matrix.setIdentityM(this.bfy, 0);
        this.bfz = false;
        this.bfA = false;
    }

    public float[] IB() {
        return this.mMVPMatrix;
    }

    public void s(float[] fArr) {
        this.mMVPMatrix = fArr;
    }

    public float[] IC() {
        return this.bfy;
    }

    public void t(float[] fArr) {
        this.bfy = fArr;
    }

    public boolean ID() {
        return this.bfz;
    }

    public boolean IE() {
        return this.bfA;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: IF */
    public b clone() {
        b bVar = null;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (bVar != null) {
            bVar.s((float[]) this.mMVPMatrix.clone());
            bVar.t((float[]) this.bfy.clone());
        }
        return bVar;
    }
}
