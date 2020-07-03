package com.baidu.swan.pms.c.a.d;
/* loaded from: classes11.dex */
public class k extends com.baidu.swan.pms.c.a.b {
    private f dra;
    private boolean mIsAttached;

    public k(f fVar, boolean z) {
        this.dra = fVar;
        this.mIsAttached = z;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public void gl(boolean z) {
        if (!this.mIsAttached) {
            if (z) {
                this.dra.dqP.dqO.currentSize = 0L;
                this.dra.jr(0);
            }
            d.aHE().j(this.dra);
        }
    }

    @Override // com.baidu.swan.pms.c.a.b
    public f aHy() {
        return this.dra;
    }

    @Override // com.baidu.swan.pms.c.a.b
    public boolean a(f fVar) {
        if (this.dra == fVar) {
            return true;
        }
        return this.dra.k(fVar);
    }

    @Override // com.baidu.swan.pms.c.a.b
    public String toString() {
        return "isAttached=" + this.mIsAttached + " " + super.toString();
    }
}
