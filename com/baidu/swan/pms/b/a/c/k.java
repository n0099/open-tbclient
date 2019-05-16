package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class k extends com.baidu.swan.pms.b.a.b {
    private f bsM;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.bsM = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public void dg(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.bsM.bsD.bsC.currentSize = 0L;
                this.bsM.fG(0);
            }
            d.VF().g(this.bsM);
        }
    }

    @Override // com.baidu.swan.pms.b.a.b
    public f VD() {
        return this.bsM;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public boolean a(f fVar) {
        if (this.bsM == fVar) {
            return true;
        }
        return this.bsM.h(fVar);
    }
}
