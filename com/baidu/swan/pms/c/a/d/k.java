package com.baidu.swan.pms.c.a.d;
/* loaded from: classes19.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f dwS;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.dwS = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void gG(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.dwS.dwH.dwG.currentSize = 0L;
                this.dwS.jK(0);
            }
            d.aLv().j(this.dwS);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f aLp() {
        return this.dwS;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.dwS == fVar) {
            return true;
        }
        return this.dwS.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + " " + super.toString();
    }
}
