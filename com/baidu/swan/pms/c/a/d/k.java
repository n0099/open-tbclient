package com.baidu.swan.pms.c.a.d;
/* loaded from: classes14.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f dFW;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.dFW = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void ha(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.dFW.dFK.dFJ.currentSize = 0L;
                this.dFW.lS(0);
            }
            d.aTU().j(this.dFW);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f aTO() {
        return this.dFW;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.dFW == fVar) {
            return true;
        }
        return this.dFW.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + " " + super.toString();
    }
}
