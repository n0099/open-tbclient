package com.baidu.swan.pms.c.a.d;
/* loaded from: classes15.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f ecB;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.ecB = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void hI(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.ecB.ecp.eco.currentSize = 0L;
                this.ecB.mL(0);
            }
            d.aZi().j(this.ecB);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f aZc() {
        return this.ecB;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.ecB == fVar) {
            return true;
        }
        return this.ecB.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + " " + super.toString();
    }
}
