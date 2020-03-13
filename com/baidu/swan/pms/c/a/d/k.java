package com.baidu.swan.pms.c.a.d;

import com.baidu.android.imsdk.utils.HanziToPinyin;
/* loaded from: classes11.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f cBO;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.cBO = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void eX(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.cBO.cBD.cBC.currentSize = 0L;
                this.cBO.iH(0);
            }
            d.atV().j(this.cBO);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f atQ() {
        return this.cBO;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.cBO == fVar) {
            return true;
        }
        return this.cBO.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + HanziToPinyin.Token.SEPARATOR + super.toString();
    }
}
