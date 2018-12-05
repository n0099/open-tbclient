package com.baidu.b.a.f.d;

import com.baidu.b.a.a;
/* loaded from: classes2.dex */
public class j {
    private f aag;
    private boolean aah;
    private String mPackageName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar) {
        this.aag = fVar;
        this.mPackageName = this.aag.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar, boolean z) {
        this.aag = fVar;
        this.mPackageName = this.aag.getPackageName();
        this.aah = z;
    }

    public boolean aI(boolean z) {
        if (this.aag.rO() || this.aah) {
            return false;
        }
        if (z) {
            this.aag.rL().Zx = 0L;
            this.aag.rL().Zw = -1L;
            this.aag.bH(0);
        }
        if (d.a(this.aag.rM(), this.aag.rL()) && !c.rK().c(this.aag)) {
            com.baidu.b.a.c.a.a rL = this.aag.rL();
            rL.KC = 2212;
            rL.errMsg = "duplicated download task";
            rL.Zm = a.C0056a.C0057a.Zc;
            this.aag.rM().onFileDownloaded(new com.baidu.b.a.b.b.a(this.aag.getPackageName(), rL.KC, rL.errMsg, rL.Zm), rL);
            return false;
        }
        g.rR().e(this.aag);
        return true;
    }

    public boolean g(f fVar) {
        if (this.aag == fVar) {
            return true;
        }
        return this.aag.d(fVar);
    }

    public f rT() {
        return this.aag;
    }
}
