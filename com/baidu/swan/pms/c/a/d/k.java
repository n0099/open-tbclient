package com.baidu.swan.pms.c.a.d;
/* loaded from: classes11.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f dbe;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.dbe = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void fV(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.dbe.daT.daS.currentSize = 0L;
                this.dbe.iO(0);
            }
            d.aCi().j(this.dbe);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f aCd() {
        return this.dbe;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.dbe == fVar) {
            return true;
        }
        return this.dbe.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + " " + super.toString();
    }
}
