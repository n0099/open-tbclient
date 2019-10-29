package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class k extends com.baidu.swan.pms.b.a.b {
    private f bML;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.bML = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public void dC(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.bML.bMC.bMB.currentSize = 0L;
                this.bML.gG(0);
            }
            d.abr().g(this.bML);
        }
    }

    @Override // com.baidu.swan.pms.b.a.b
    public f abp() {
        return this.bML;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public boolean a(f fVar) {
        if (this.bML == fVar) {
            return true;
        }
        return this.bML.h(fVar);
    }
}
