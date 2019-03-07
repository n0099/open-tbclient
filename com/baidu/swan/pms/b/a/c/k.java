package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class k extends com.baidu.swan.pms.b.a.b {
    private f bmI;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.bmI = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public void cP(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.bmI.bmx.bmw.currentSize = 0L;
                this.bmI.fh(0);
            }
            d.RT().g(this.bmI);
        }
    }

    @Override // com.baidu.swan.pms.b.a.b
    public f RR() {
        return this.bmI;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public boolean a(f fVar) {
        if (this.bmI == fVar) {
            return true;
        }
        return this.bmI.h(fVar);
    }
}
