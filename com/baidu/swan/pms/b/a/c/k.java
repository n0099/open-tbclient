package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class k extends com.baidu.swan.pms.b.a.b {
    private f btC;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.btC = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public void dl(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.btC.btt.bts.currentSize = 0L;
                this.btC.fK(0);
            }
            d.Wy().g(this.btC);
        }
    }

    @Override // com.baidu.swan.pms.b.a.b
    public f Ww() {
        return this.btC;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public boolean a(f fVar) {
        if (this.btC == fVar) {
            return true;
        }
        return this.btC.h(fVar);
    }
}
