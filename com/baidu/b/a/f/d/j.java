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

    public boolean au(boolean z) {
        if (this.aag.rS() || this.aah) {
            return false;
        }
        if (z) {
            this.aag.rP().Zx = 0L;
            this.aag.rP().Zw = -1L;
            this.aag.bs(0);
        }
        if (d.a(this.aag.rQ(), this.aag.rP()) && !c.rO().c(this.aag)) {
            com.baidu.b.a.c.a.a rP = this.aag.rP();
            rP.Ky = 2212;
            rP.errMsg = "duplicated download task";
            rP.Zm = a.C0056a.C0057a.Zc;
            this.aag.rQ().onFileDownloaded(new com.baidu.b.a.b.b.a(this.aag.getPackageName(), rP.Ky, rP.errMsg, rP.Zm), rP);
            return false;
        }
        g.rV().e(this.aag);
        return true;
    }

    public boolean g(f fVar) {
        if (this.aag == fVar) {
            return true;
        }
        return this.aag.d(fVar);
    }

    public f rX() {
        return this.aag;
    }
}
