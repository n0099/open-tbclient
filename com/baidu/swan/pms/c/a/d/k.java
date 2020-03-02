package com.baidu.swan.pms.c.a.d;

import com.baidu.android.imsdk.utils.HanziToPinyin;
/* loaded from: classes11.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f cBN;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.cBN = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void eX(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.cBN.cBC.cBB.currentSize = 0L;
                this.cBN.iH(0);
            }
            d.atV().j(this.cBN);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f atQ() {
        return this.cBN;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.cBN == fVar) {
            return true;
        }
        return this.cBN.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + HanziToPinyin.Token.SEPARATOR + super.toString();
    }
}
