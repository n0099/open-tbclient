package com.baidu.ar.face.detector;

import com.baidu.ar.face.algo.FaceAlgoData;
/* loaded from: classes.dex */
public class g {
    public int ow;
    public int[] ot = {3, 10, 10, 10, 10};
    public int ou = 4;
    public int ov = 0;
    public boolean ox = false;

    public void E(int i) {
        this.ov = i;
    }

    public void F(int i) {
        this.ou = i;
    }

    public boolean a(f fVar) {
        FaceAlgoData faceAlgoData = fVar.ob;
        if (faceAlgoData == null || faceAlgoData.getFaceFrame() == null || fVar.ob.getFaceFrame().getProcessResult() == 200 || dS() > 0) {
            return false;
        }
        E(0);
        return true;
    }

    public void b(int[] iArr) {
        this.ot = iArr;
    }

    public boolean dO() {
        int i = this.ow;
        if (i == 0) {
            this.ow = i + 1;
            return true;
        } else if (this.ox) {
            return false;
        } else {
            int i2 = i + 1;
            this.ow = i2;
            int i3 = i2 - 1;
            int[] iArr = this.ot;
            int i4 = this.ov;
            int i5 = this.ou;
            if (i4 > i5) {
                i4 = i5;
            }
            if (i3 > iArr[i4]) {
                this.ow = 0;
                return true;
            }
            return false;
        }
    }

    public void dP() {
        this.ox = true;
    }

    public void dQ() {
        this.ox = false;
    }

    public int dR() {
        return this.ou;
    }

    public int dS() {
        return this.ov;
    }
}
