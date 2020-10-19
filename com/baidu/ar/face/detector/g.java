package com.baidu.ar.face.detector;
/* loaded from: classes14.dex */
public class g {
    private int og;
    private int[] od = {3, 10, 10, 10, 10};
    private int oe = 4;
    private int of = 0;
    private boolean oh = false;

    public void C(int i) {
        this.of = i;
    }

    public void D(int i) {
        this.oe = i;
    }

    public boolean a(f fVar) {
        if (fVar.nL == null || fVar.nL.getFaceFrame() == null || fVar.nL.getFaceFrame().getProcessResult() == 200 || dT() > 0) {
            return false;
        }
        C(0);
        return true;
    }

    public void b(int[] iArr) {
        this.od = iArr;
    }

    public boolean dP() {
        if (this.og == 0) {
            this.og++;
            return true;
        } else if (this.oh) {
            return false;
        } else {
            this.og++;
            if (this.og - 1 > this.od[this.of > this.oe ? this.oe : this.of]) {
                this.og = 0;
                return true;
            }
            return false;
        }
    }

    public void dQ() {
        this.oh = true;
    }

    public void dR() {
        this.oh = false;
    }

    public int dS() {
        return this.oe;
    }

    public int dT() {
        return this.of;
    }
}
