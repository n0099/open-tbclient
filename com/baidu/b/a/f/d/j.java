package com.baidu.b.a.f.d;

import com.baidu.b.a.a;
/* loaded from: classes2.dex */
public class j {
    private f aap;
    private boolean aaq;
    private String mPackageName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar) {
        this.aap = fVar;
        this.mPackageName = this.aap.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar, boolean z) {
        this.aap = fVar;
        this.mPackageName = this.aap.getPackageName();
        this.aaq = z;
    }

    public boolean aI(boolean z) {
        if (this.aap.rS() || this.aaq) {
            return false;
        }
        if (z) {
            this.aap.rP().ZG = 0L;
            this.aap.rP().ZF = -1L;
            this.aap.bH(0);
        }
        if (d.a(this.aap.rQ(), this.aap.rP()) && !c.rO().c(this.aap)) {
            com.baidu.b.a.c.a.a rP = this.aap.rP();
            rP.KI = 2212;
            rP.errMsg = "duplicated download task";
            rP.Zv = a.C0056a.C0057a.Zl;
            this.aap.rQ().onFileDownloaded(new com.baidu.b.a.b.b.a(this.aap.getPackageName(), rP.KI, rP.errMsg, rP.Zv), rP);
            return false;
        }
        g.rV().e(this.aap);
        return true;
    }

    public boolean g(f fVar) {
        if (this.aap == fVar) {
            return true;
        }
        return this.aap.d(fVar);
    }

    public f rX() {
        return this.aap;
    }
}
