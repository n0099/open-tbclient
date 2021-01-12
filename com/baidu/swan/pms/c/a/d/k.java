package com.baidu.swan.pms.c.a.d;
/* loaded from: classes6.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f esH;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.esH = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void iz(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.esH.esw.esv.currentSize = 0L;
                this.esH.lS(0);
            }
            d.bcJ().j(this.esH);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f bcD() {
        return this.esH;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.esH == fVar) {
            return true;
        }
        return this.esH.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + " " + super.toString();
    }
}
