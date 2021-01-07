package com.baidu.swan.pms.c.a.d;
/* loaded from: classes6.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f exv;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.exv = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void iD(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.exv.exj.exi.currentSize = 0L;
                this.exv.ny(0);
            }
            d.bgD().j(this.exv);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f bgx() {
        return this.exv;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.exv == fVar) {
            return true;
        }
        return this.exv.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + " " + super.toString();
    }
}
