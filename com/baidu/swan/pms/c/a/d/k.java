package com.baidu.swan.pms.c.a.d;

import com.baidu.android.imsdk.utils.HanziToPinyin;
/* loaded from: classes11.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f cBM;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.cBM = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void eX(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.cBM.cBB.cBA.currentSize = 0L;
                this.cBM.iH(0);
            }
            d.atT().j(this.cBM);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f atO() {
        return this.cBM;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.cBM == fVar) {
            return true;
        }
        return this.cBM.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + HanziToPinyin.Token.SEPARATOR + super.toString();
    }
}
