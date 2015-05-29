package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u {
    int Uf;
    boolean Ug;
    v Uh;
    v Ui;
    v Uj;
    v Uk;
    v Ul;
    v Um;
    v Un;
    v Uo;
    v Up;
    v Uq;
    v Ur;
    v Us;
    v Ut;
    v Uu;
    v Uv;

    private u() {
        this.Uf = 0;
        this.Uh = new v(null);
        this.Ui = new v(null);
        this.Uj = new v(null);
        this.Uk = new v(null);
        this.Ul = new v(null);
        this.Um = new v(null);
        this.Un = new v(null);
        this.Uo = new v(null);
        this.Up = new v(null);
        this.Uq = new v(null);
        this.Ur = new v(null);
        this.Us = new v(null);
        this.Ut = new v(null);
        this.Uu = new v(null);
        this.Uv = new v(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(u uVar) {
        this();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [89=4] */
    public int sI() {
        return this.Uh.num + this.Ui.num + this.Uj.num + this.Uk.num + this.Ul.num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [95=14] */
    public int sJ() {
        return this.Uh.num + this.Ui.num + this.Uj.num + this.Uk.num + this.Ul.num + this.Um.num + this.Un.num + this.Uo.num + this.Up.num + this.Uq.num + this.Ur.num + this.Us.num + this.Ut.num + this.Uu.num + this.Uv.num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [106=4] */
    public int sK() {
        return this.Um.num + this.Un.num + this.Uo.num + this.Up.num + this.Uq.num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [112=4] */
    public int sL() {
        return this.Ur.num + this.Us.num + this.Ut.num + this.Uu.num + this.Uv.num;
    }

    public void reset() {
        this.Uf = 0;
        this.Uh.reset();
        this.Ui.reset();
        this.Uj.reset();
        this.Uk.reset();
        this.Ul.reset();
        this.Um.reset();
        this.Un.reset();
        this.Uo.reset();
        this.Up.reset();
        this.Uq.reset();
        this.Ur.reset();
        this.Us.reset();
        this.Ut.reset();
        this.Uu.reset();
        this.Uv.reset();
    }

    public void sM() {
        if (t.sH().sI() > 0) {
            com.baidu.tbadk.performanceLog.ae.a(t.sH().Uh.num, t.sH().Uh.Uw, t.sH().Uh.Uy, t.sH().Uh.Ux, t.sH().Uh.time, t.sH().Ui.num, t.sH().Ui.Uw, t.sH().Ui.Uy, t.sH().Ui.time, t.sH().Ui.Ux, t.sH().Uj.num, t.sH().Uj.Uw, t.sH().Uj.Uy, t.sH().Uj.time, t.sH().Uj.Ux, t.sH().Ul.num, t.sH().Ul.Uw, t.sH().Ul.Uy, t.sH().Ul.time, t.sH().Ul.Ux, t.sH().Uk.num, t.sH().Uk.Uw, t.sH().Uk.Uy, t.sH().Uk.time, t.sH().Uk.Ux, 3);
        }
    }

    public void sN() {
        if (t.sH().sK() > 0) {
            com.baidu.tbadk.performanceLog.ae.a(t.sH().Um.num, t.sH().Um.Uw, t.sH().Um.Uy, t.sH().Um.time, t.sH().Um.Ux, t.sH().Un.num, t.sH().Un.Uw, t.sH().Un.Uy, t.sH().Un.time, t.sH().Un.Ux, t.sH().Uo.num, t.sH().Uo.Uw, t.sH().Uo.Uy, t.sH().Uo.time, t.sH().Uo.Ux, t.sH().Uq.num, t.sH().Uq.Uw, t.sH().Uq.Uy, t.sH().Uq.time, t.sH().Uq.Ux, t.sH().Up.num, t.sH().Up.Uw, t.sH().Up.Uy, t.sH().Up.time, t.sH().Up.Ux, 1);
        }
    }

    public void sO() {
        if (t.sH().sL() > 0) {
            com.baidu.tbadk.performanceLog.ae.a(t.sH().Ur.num, t.sH().Ur.Uw, t.sH().Ur.Uy, t.sH().Ur.time, t.sH().Ur.Ux, t.sH().Us.num, t.sH().Us.Uw, t.sH().Us.Uy, t.sH().Us.time, t.sH().Us.Ux, t.sH().Ut.num, t.sH().Ut.Uw, t.sH().Ut.Uy, t.sH().Ut.time, t.sH().Ut.Ux, t.sH().Uv.num, t.sH().Uv.Uw, t.sH().Uv.Uy, t.sH().Uv.time, t.sH().Uv.Ux, t.sH().Uu.num, t.sH().Uu.Uw, t.sH().Uu.Uy, t.sH().Uu.time, t.sH().Uu.Ux, 2);
        }
    }
}
