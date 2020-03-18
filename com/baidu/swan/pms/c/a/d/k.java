package com.baidu.swan.pms.c.a.d;

import com.baidu.android.imsdk.utils.HanziToPinyin;
/* loaded from: classes11.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f cBZ;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.cBZ = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void eY(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.cBZ.cBO.cBN.currentSize = 0L;
                this.cBZ.iH(0);
            }
            d.atY().j(this.cBZ);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f atT() {
        return this.cBZ;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.cBZ == fVar) {
            return true;
        }
        return this.cBZ.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + HanziToPinyin.Token.SEPARATOR + super.toString();
    }
}
