package com.baidu.swan.pms.c.a.d;
/* loaded from: classes11.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f dmp;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.dmp = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void gg(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.dmp.dme.dmd.currentSize = 0L;
                this.dmp.je(0);
            }
            d.aGy().j(this.dmp);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f aGs() {
        return this.dmp;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.dmp == fVar) {
            return true;
        }
        return this.dmp.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + " " + super.toString();
    }
}
