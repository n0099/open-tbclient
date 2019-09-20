package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class k extends com.baidu.swan.pms.b.a.b {
    private f bua;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.bua = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public void dl(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.bua.btR.btQ.currentSize = 0L;
                this.bua.fL(0);
            }
            d.WC().g(this.bua);
        }
    }

    @Override // com.baidu.swan.pms.b.a.b
    public f WA() {
        return this.bua;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public boolean a(f fVar) {
        if (this.bua == fVar) {
            return true;
        }
        return this.bua.h(fVar);
    }
}
