package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class k extends com.baidu.swan.pms.b.a.b {
    private f bmM;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.bmM = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public void cP(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.bmM.bmB.bmA.currentSize = 0L;
                this.bmM.fg(0);
            }
            d.RR().g(this.bmM);
        }
    }

    @Override // com.baidu.swan.pms.b.a.b
    public f RP() {
        return this.bmM;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public boolean a(f fVar) {
        if (this.bmM == fVar) {
            return true;
        }
        return this.bmM.h(fVar);
    }
}
