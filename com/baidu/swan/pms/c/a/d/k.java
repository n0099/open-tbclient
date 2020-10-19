package com.baidu.swan.pms.c.a.d;
/* loaded from: classes15.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f dUf;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.dUf = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void hv(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.dUf.dTT.dTS.currentSize = 0L;
                this.dUf.mA(0);
            }
            d.aXp().j(this.dUf);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f aXj() {
        return this.dUf;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.dUf == fVar) {
            return true;
        }
        return this.dUf.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + " " + super.toString();
    }
}
