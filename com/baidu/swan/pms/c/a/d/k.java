package com.baidu.swan.pms.c.a.d;

import com.baidu.android.imsdk.utils.HanziToPinyin;
/* loaded from: classes9.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f cxD;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.cxD = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void eL(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.cxD.cxs.cxr.currentSize = 0L;
                this.cxD.iq(0);
            }
            d.arm().j(this.cxD);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f arh() {
        return this.cxD;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.cxD == fVar) {
            return true;
        }
        return this.cxD.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + HanziToPinyin.Token.SEPARATOR + super.toString();
    }
}
