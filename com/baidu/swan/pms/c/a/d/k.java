package com.baidu.swan.pms.c.a.d;
/* loaded from: classes24.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f dIe;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.dIe = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void gZ(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.dIe.dHS.dHR.currentSize = 0L;
                this.dIe.md(0);
            }
            d.aUG().j(this.dIe);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f aUA() {
        return this.dIe;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.dIe == fVar) {
            return true;
        }
        return this.dIe.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + " " + super.toString();
    }
}
