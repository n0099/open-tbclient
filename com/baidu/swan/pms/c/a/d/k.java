package com.baidu.swan.pms.c.a.d;
/* loaded from: classes3.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f euO;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.euO = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void iB(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.euO.euD.euC.currentSize = 0L;
                this.euO.lV(0);
            }
            d.bcW().j(this.euO);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f bcQ() {
        return this.euO;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.euO == fVar) {
            return true;
        }
        return this.euO.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + " " + super.toString();
    }
}
