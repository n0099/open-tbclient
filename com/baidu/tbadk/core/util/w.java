package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w {
    x DA;
    x DB;
    x DC;
    x DD;
    x DE;
    x DF;
    x DG;
    x DH;
    x DI;
    x DJ;
    x DK;
    x DL;
    x DM;
    x DN;
    int Dx;
    boolean Dy;
    x Dz;

    private w() {
        this.Dx = 0;
        this.Dz = new x(null);
        this.DA = new x(null);
        this.DB = new x(null);
        this.DC = new x(null);
        this.DD = new x(null);
        this.DE = new x(null);
        this.DF = new x(null);
        this.DG = new x(null);
        this.DH = new x(null);
        this.DI = new x(null);
        this.DJ = new x(null);
        this.DK = new x(null);
        this.DL = new x(null);
        this.DM = new x(null);
        this.DN = new x(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(w wVar) {
        this();
    }

    public int lM() {
        return this.Dz.num + this.DA.num + this.DB.num + this.DC.num + this.DD.num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [89=12, 90=5, 91=5] */
    public int lN() {
        return this.Dz.num + this.DA.num + this.DB.num + this.DC.num + this.DD.num + this.DE.num + this.DF.num + this.DG.num + this.DH.num + this.DI.num + this.DJ.num + this.DK.num + this.DL.num + this.DM.num + this.DN.num;
    }

    public int lO() {
        return this.DE.num + this.DF.num + this.DG.num + this.DH.num + this.DI.num;
    }

    public int lP() {
        return this.DJ.num + this.DK.num + this.DL.num + this.DM.num + this.DN.num;
    }

    public void reset() {
        this.Dx = 0;
        this.Dz.reset();
        this.DA.reset();
        this.DB.reset();
        this.DC.reset();
        this.DD.reset();
        this.DE.reset();
        this.DF.reset();
        this.DG.reset();
        this.DH.reset();
        this.DI.reset();
        this.DJ.reset();
        this.DK.reset();
        this.DL.reset();
        this.DM.reset();
        this.DN.reset();
    }

    public void lQ() {
        if (v.lL().lM() > 0) {
            com.baidu.tbadk.performanceLog.t.a(v.lL().Dz.num, v.lL().Dz.DO, v.lL().Dz.DP, v.lL().Dz.time, v.lL().DA.num, v.lL().DA.DO, v.lL().DA.DP, v.lL().DA.time, v.lL().DB.num, v.lL().DB.DO, v.lL().DB.DP, v.lL().DB.time, v.lL().DD.num, v.lL().DD.DO, v.lL().DD.DP, v.lL().DD.time, v.lL().DC.num, v.lL().DC.DO, v.lL().DC.DP, v.lL().DC.time, 3);
        }
    }

    public void lR() {
        if (v.lL().lO() > 0) {
            com.baidu.tbadk.performanceLog.t.a(v.lL().DE.num, v.lL().DE.DO, v.lL().DE.DP, v.lL().DE.time, v.lL().DF.num, v.lL().DF.DO, v.lL().DF.DP, v.lL().DF.time, v.lL().DG.num, v.lL().DG.DO, v.lL().DG.DP, v.lL().DG.time, v.lL().DI.num, v.lL().DI.DO, v.lL().DI.DP, v.lL().DI.time, v.lL().DH.num, v.lL().DH.DO, v.lL().DH.DP, v.lL().DH.time, 1);
        }
    }

    public void lS() {
        if (v.lL().lP() > 0) {
            com.baidu.tbadk.performanceLog.t.a(v.lL().DJ.num, v.lL().DJ.DO, v.lL().DJ.DP, v.lL().DJ.time, v.lL().DK.num, v.lL().DK.DO, v.lL().DK.DP, v.lL().DK.time, v.lL().DL.num, v.lL().DL.DO, v.lL().DL.DP, v.lL().DL.time, v.lL().DN.num, v.lL().DN.DO, v.lL().DN.DP, v.lL().DN.time, v.lL().DM.num, v.lL().DM.DO, v.lL().DM.DP, v.lL().DM.time, 2);
        }
    }
}
