package com.baidu.swan.pms.c.a.d;
/* loaded from: classes11.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f daZ;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.daZ = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void fV(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.daZ.daO.daN.currentSize = 0L;
                this.daZ.iO(0);
            }
            d.aCi().j(this.daZ);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f aCd() {
        return this.daZ;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.daZ == fVar) {
            return true;
        }
        return this.daZ.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + " " + super.toString();
    }
}
