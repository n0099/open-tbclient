package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes11.dex */
public class b implements Cloneable {
    private float[] bsc;
    private boolean bsd;
    private boolean bse;
    private float[] mMVPMatrix = new float[16];
    private long mTimestamp;

    public b() {
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        this.bsc = new float[16];
        Matrix.setIdentityM(this.bsc, 0);
        this.bsd = false;
        this.bse = false;
    }

    public float[] LC() {
        return this.mMVPMatrix;
    }

    public void t(float[] fArr) {
        this.mMVPMatrix = fArr;
    }

    public float[] LD() {
        return this.bsc;
    }

    public void u(float[] fArr) {
        this.bsc = fArr;
    }

    public boolean LE() {
        return this.bsd;
    }

    public boolean LF() {
        return this.bse;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: LG */
    public b clone() {
        b bVar = null;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (bVar != null) {
            bVar.t((float[]) this.mMVPMatrix.clone());
            bVar.u((float[]) this.bsc.clone());
        }
        return bVar;
    }
}
