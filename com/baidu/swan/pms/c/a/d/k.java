package com.baidu.swan.pms.c.a.d;
/* loaded from: classes6.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f egM;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.egM = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void hU(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.egM.egA.egz.currentSize = 0L;
                this.egM.mR(0);
            }
            d.bbb().j(this.egM);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f baV() {
        return this.egM;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.egM == fVar) {
            return true;
        }
        return this.egM.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + " " + super.toString();
    }
}
