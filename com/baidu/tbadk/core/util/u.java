package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u {
    v TA;
    v TB;
    v TC;
    v TD;
    v TE;
    v TF;
    v TG;
    v TH;
    v TI;
    v TJ;
    v TK;
    int Tu;
    boolean Tv;
    v Tw;
    v Tx;
    v Ty;
    v Tz;

    private u() {
        this.Tu = 0;
        this.Tw = new v(null);
        this.Tx = new v(null);
        this.Ty = new v(null);
        this.Tz = new v(null);
        this.TA = new v(null);
        this.TB = new v(null);
        this.TC = new v(null);
        this.TD = new v(null);
        this.TE = new v(null);
        this.TF = new v(null);
        this.TG = new v(null);
        this.TH = new v(null);
        this.TI = new v(null);
        this.TJ = new v(null);
        this.TK = new v(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(u uVar) {
        this();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [89=4] */
    public int sa() {
        return this.Tw.num + this.Tx.num + this.Ty.num + this.Tz.num + this.TA.num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [95=14] */
    public int sb() {
        return this.Tw.num + this.Tx.num + this.Ty.num + this.Tz.num + this.TA.num + this.TB.num + this.TC.num + this.TD.num + this.TE.num + this.TF.num + this.TG.num + this.TH.num + this.TI.num + this.TJ.num + this.TK.num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [106=4] */
    public int sc() {
        return this.TB.num + this.TC.num + this.TD.num + this.TE.num + this.TF.num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [112=4] */
    public int sd() {
        return this.TG.num + this.TH.num + this.TI.num + this.TJ.num + this.TK.num;
    }

    public void reset() {
        this.Tu = 0;
        this.Tw.reset();
        this.Tx.reset();
        this.Ty.reset();
        this.Tz.reset();
        this.TA.reset();
        this.TB.reset();
        this.TC.reset();
        this.TD.reset();
        this.TE.reset();
        this.TF.reset();
        this.TG.reset();
        this.TH.reset();
        this.TI.reset();
        this.TJ.reset();
        this.TK.reset();
    }

    public void se() {
        if (t.rZ().sa() > 0) {
            com.baidu.tbadk.performanceLog.ae.a(t.rZ().Tw.num, t.rZ().Tw.TL, t.rZ().Tw.TN, t.rZ().Tw.TM, t.rZ().Tw.time, t.rZ().Tx.num, t.rZ().Tx.TL, t.rZ().Tx.TN, t.rZ().Tx.time, t.rZ().Tx.TM, t.rZ().Ty.num, t.rZ().Ty.TL, t.rZ().Ty.TN, t.rZ().Ty.time, t.rZ().Ty.TM, t.rZ().TA.num, t.rZ().TA.TL, t.rZ().TA.TN, t.rZ().TA.time, t.rZ().TA.TM, t.rZ().Tz.num, t.rZ().Tz.TL, t.rZ().Tz.TN, t.rZ().Tz.time, t.rZ().Tz.TM, 3);
        }
    }

    public void sf() {
        if (t.rZ().sc() > 0) {
            com.baidu.tbadk.performanceLog.ae.a(t.rZ().TB.num, t.rZ().TB.TL, t.rZ().TB.TN, t.rZ().TB.time, t.rZ().TB.TM, t.rZ().TC.num, t.rZ().TC.TL, t.rZ().TC.TN, t.rZ().TC.time, t.rZ().TC.TM, t.rZ().TD.num, t.rZ().TD.TL, t.rZ().TD.TN, t.rZ().TD.time, t.rZ().TD.TM, t.rZ().TF.num, t.rZ().TF.TL, t.rZ().TF.TN, t.rZ().TF.time, t.rZ().TF.TM, t.rZ().TE.num, t.rZ().TE.TL, t.rZ().TE.TN, t.rZ().TE.time, t.rZ().TE.TM, 1);
        }
    }

    public void sg() {
        if (t.rZ().sd() > 0) {
            com.baidu.tbadk.performanceLog.ae.a(t.rZ().TG.num, t.rZ().TG.TL, t.rZ().TG.TN, t.rZ().TG.time, t.rZ().TG.TM, t.rZ().TH.num, t.rZ().TH.TL, t.rZ().TH.TN, t.rZ().TH.time, t.rZ().TH.TM, t.rZ().TI.num, t.rZ().TI.TL, t.rZ().TI.TN, t.rZ().TI.time, t.rZ().TI.TM, t.rZ().TK.num, t.rZ().TK.TL, t.rZ().TK.TN, t.rZ().TK.time, t.rZ().TK.TM, t.rZ().TJ.num, t.rZ().TJ.TL, t.rZ().TJ.TN, t.rZ().TJ.time, t.rZ().TJ.TM, 2);
        }
    }
}
