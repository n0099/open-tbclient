package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class k extends com.baidu.swan.pms.b.a.b {
    private f bLU;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.bLU = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public void dC(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.bLU.bLL.bLK.currentSize = 0L;
                this.bLU.gF(0);
            }
            d.abp().g(this.bLU);
        }
    }

    @Override // com.baidu.swan.pms.b.a.b
    public f abn() {
        return this.bLU;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public boolean a(f fVar) {
        if (this.bLU == fVar) {
            return true;
        }
        return this.bLU.h(fVar);
    }
}
