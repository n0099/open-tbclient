package com.baidu.swan.pms.c.a.d;
/* loaded from: classes6.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f enN;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.enN = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void ij(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.enN.enC.enB.currentSize = 0L;
                this.enN.np(0);
            }
            d.beg().j(this.enN);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f bea() {
        return this.enN;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.enN == fVar) {
            return true;
        }
        return this.enN.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + " " + super.toString();
    }
}
