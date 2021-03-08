package com.baidu.swan.pms.c.a.d;
/* loaded from: classes3.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f ewp;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.ewp = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void iB(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.ewp.ewe.ewd.currentSize = 0L;
                this.ewp.lW(0);
            }
            d.bcY().j(this.ewp);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f bcS() {
        return this.ewp;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.ewp == fVar) {
            return true;
        }
        return this.ewp.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + " " + super.toString();
    }
}
