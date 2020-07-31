package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes10.dex */
public class b implements Cloneable {
    private float[] bsx;
    private boolean bsy;
    private boolean bsz;
    private float[] mMVPMatrix = new float[16];
    private long mTimestamp;

    public b() {
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        this.bsx = new float[16];
        Matrix.setIdentityM(this.bsx, 0);
        this.bsy = false;
        this.bsz = false;
    }

    public float[] LJ() {
        return this.mMVPMatrix;
    }

    public void t(float[] fArr) {
        this.mMVPMatrix = fArr;
    }

    public float[] LK() {
        return this.bsx;
    }

    public void u(float[] fArr) {
        this.bsx = fArr;
    }

    public boolean LL() {
        return this.bsy;
    }

    public boolean LM() {
        return this.bsz;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: LN */
    public b clone() {
        b bVar = null;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (bVar != null) {
            bVar.t((float[]) this.mMVPMatrix.clone());
            bVar.u((float[]) this.bsx.clone());
        }
        return bVar;
    }
}
