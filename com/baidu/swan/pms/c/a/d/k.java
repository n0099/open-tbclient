package com.baidu.swan.pms.c.a.d;

import com.baidu.android.imsdk.utils.HanziToPinyin;
/* loaded from: classes10.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f cxO;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.cxO = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void eQ(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.cxO.cxD.cxC.currentSize = 0L;
                this.cxO.iq(0);
            }
            d.arF().j(this.cxO);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f arA() {
        return this.cxO;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.cxO == fVar) {
            return true;
        }
        return this.cxO.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + HanziToPinyin.Token.SEPARATOR + super.toString();
    }
}
