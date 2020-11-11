package com.baidu.swan.pms.c.a.d;
/* loaded from: classes15.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f eit;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.eit = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void hR(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.eit.eih.eig.currentSize = 0L;
                this.eit.mV(0);
            }
            d.bbI().j(this.eit);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f bbC() {
        return this.eit;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.eit == fVar) {
            return true;
        }
        return this.eit.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + " " + super.toString();
    }
}
