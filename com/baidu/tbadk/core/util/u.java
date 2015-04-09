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
    v TL;
    v TM;
    int Tw;
    boolean Tx;
    v Ty;
    v Tz;

    private u() {
        this.Tw = 0;
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
        this.TL = new v(null);
        this.TM = new v(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(u uVar) {
        this();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [89=4] */
    public int sa() {
        return this.Ty.num + this.Tz.num + this.TA.num + this.TB.num + this.TC.num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [95=14] */
    public int sb() {
        return this.Ty.num + this.Tz.num + this.TA.num + this.TB.num + this.TC.num + this.TD.num + this.TE.num + this.TF.num + this.TG.num + this.TH.num + this.TI.num + this.TJ.num + this.TK.num + this.TL.num + this.TM.num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [106=4] */
    public int sc() {
        return this.TD.num + this.TE.num + this.TF.num + this.TG.num + this.TH.num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [112=4] */
    public int sd() {
        return this.TI.num + this.TJ.num + this.TK.num + this.TL.num + this.TM.num;
    }

    public void reset() {
        this.Tw = 0;
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
        this.TL.reset();
        this.TM.reset();
    }

    public void se() {
        if (t.rZ().sa() > 0) {
            com.baidu.tbadk.performanceLog.ae.a(t.rZ().Ty.num, t.rZ().Ty.TN, t.rZ().Ty.TP, t.rZ().Ty.TO, t.rZ().Ty.time, t.rZ().Tz.num, t.rZ().Tz.TN, t.rZ().Tz.TP, t.rZ().Tz.time, t.rZ().Tz.TO, t.rZ().TA.num, t.rZ().TA.TN, t.rZ().TA.TP, t.rZ().TA.time, t.rZ().TA.TO, t.rZ().TC.num, t.rZ().TC.TN, t.rZ().TC.TP, t.rZ().TC.time, t.rZ().TC.TO, t.rZ().TB.num, t.rZ().TB.TN, t.rZ().TB.TP, t.rZ().TB.time, t.rZ().TB.TO, 3);
        }
    }

    public void sf() {
        if (t.rZ().sc() > 0) {
            com.baidu.tbadk.performanceLog.ae.a(t.rZ().TD.num, t.rZ().TD.TN, t.rZ().TD.TP, t.rZ().TD.time, t.rZ().TD.TO, t.rZ().TE.num, t.rZ().TE.TN, t.rZ().TE.TP, t.rZ().TE.time, t.rZ().TE.TO, t.rZ().TF.num, t.rZ().TF.TN, t.rZ().TF.TP, t.rZ().TF.time, t.rZ().TF.TO, t.rZ().TH.num, t.rZ().TH.TN, t.rZ().TH.TP, t.rZ().TH.time, t.rZ().TH.TO, t.rZ().TG.num, t.rZ().TG.TN, t.rZ().TG.TP, t.rZ().TG.time, t.rZ().TG.TO, 1);
        }
    }

    public void sg() {
        if (t.rZ().sd() > 0) {
            com.baidu.tbadk.performanceLog.ae.a(t.rZ().TI.num, t.rZ().TI.TN, t.rZ().TI.TP, t.rZ().TI.time, t.rZ().TI.TO, t.rZ().TJ.num, t.rZ().TJ.TN, t.rZ().TJ.TP, t.rZ().TJ.time, t.rZ().TJ.TO, t.rZ().TK.num, t.rZ().TK.TN, t.rZ().TK.TP, t.rZ().TK.time, t.rZ().TK.TO, t.rZ().TM.num, t.rZ().TM.TN, t.rZ().TM.TP, t.rZ().TM.time, t.rZ().TM.TO, t.rZ().TL.num, t.rZ().TL.TN, t.rZ().TL.TP, t.rZ().TL.time, t.rZ().TL.TO, 2);
        }
    }
}
