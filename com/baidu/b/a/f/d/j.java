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
        if (this.aag.rP() || this.aah) {
            return false;
        }
        if (z) {
            this.aag.rM().Zx = 0L;
            this.aag.rM().Zw = -1L;
            this.aag.bH(0);
        }
        if (d.a(this.aag.rN(), this.aag.rM()) && !c.rL().c(this.aag)) {
            com.baidu.b.a.c.a.a rM = this.aag.rM();
            rM.KC = 2212;
            rM.errMsg = "duplicated download task";
            rM.Zm = a.C0056a.C0057a.Zc;
            this.aag.rN().onFileDownloaded(new com.baidu.b.a.b.b.a(this.aag.getPackageName(), rM.KC, rM.errMsg, rM.Zm), rM);
            return false;
        }
        g.rS().e(this.aag);
        return true;
    }

    public boolean g(f fVar) {
        if (this.aag == fVar) {
            return true;
        }
        return this.aag.d(fVar);
    }

    public f rU() {
        return this.aag;
    }
}
