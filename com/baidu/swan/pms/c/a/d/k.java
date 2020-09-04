package com.baidu.swan.pms.c.a.d;
/* loaded from: classes14.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f dGa;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.dGa = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void hb(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.dGa.dFO.dFN.currentSize = 0L;
                this.dGa.lS(0);
            }
            d.aTU().j(this.dGa);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f aTO() {
        return this.dGa;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.dGa == fVar) {
            return true;
        }
        return this.dGa.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + " " + super.toString();
    }
}
