package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class k extends com.baidu.swan.pms.b.a.b {
    private f bmN;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.bmN = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public void cP(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.bmN.bmC.bmB.currentSize = 0L;
                this.bmN.fg(0);
            }
            d.RR().g(this.bmN);
        }
    }

    @Override // com.baidu.swan.pms.b.a.b
    public f RP() {
        return this.bmN;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public boolean a(f fVar) {
        if (this.bmN == fVar) {
            return true;
        }
        return this.bmN.h(fVar);
    }
}
