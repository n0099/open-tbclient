package com.baidu.swan.pms.b.a.c;
/* loaded from: classes2.dex */
public class k extends com.baidu.swan.pms.b.a.b {
    private f bmJ;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.bmJ = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public void cP(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.bmJ.bmy.bmx.currentSize = 0L;
                this.bmJ.fh(0);
            }
            d.RT().g(this.bmJ);
        }
    }

    @Override // com.baidu.swan.pms.b.a.b
    public f RR() {
        return this.bmJ;
    }

    @Override // com.baidu.swan.pms.b.a.b
    public boolean a(f fVar) {
        if (this.bmJ == fVar) {
            return true;
        }
        return this.bmJ.h(fVar);
    }
}
