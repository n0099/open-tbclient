package com.baidu.ar.face.detector;
/* loaded from: classes10.dex */
public class g {
    private int ow;
    private int[] ot = {3, 10, 10, 10, 10};
    private int ou = 4;
    private int ov = 0;
    private boolean ox = false;

    public void E(int i) {
        this.ov = i;
    }

    public void F(int i) {
        this.ou = i;
    }

    public boolean a(f fVar) {
        if (fVar.ob == null || fVar.ob.getFaceFrame() == null || fVar.ob.getFaceFrame().getProcessResult() == 200 || dS() > 0) {
            return false;
        }
        E(0);
        return true;
    }

    public void b(int[] iArr) {
        this.ot = iArr;
    }

    public boolean dO() {
        if (this.ow == 0) {
            this.ow++;
            return true;
        } else if (this.ox) {
            return false;
        } else {
            this.ow++;
            if (this.ow - 1 > this.ot[this.ov > this.ou ? this.ou : this.ov]) {
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
