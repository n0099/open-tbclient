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
    x DO;
    int Dy;
    boolean Dz;

    private w() {
        this.Dy = 0;
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
        this.DO = new x(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(w wVar) {
        this();
    }

    public int lM() {
        return this.DA.num + this.DB.num + this.DC.num + this.DD.num + this.DE.num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [89=12, 90=5, 91=5] */
    public int lN() {
        return this.DA.num + this.DB.num + this.DC.num + this.DD.num + this.DE.num + this.DF.num + this.DG.num + this.DH.num + this.DI.num + this.DJ.num + this.DK.num + this.DL.num + this.DM.num + this.DN.num + this.DO.num;
    }

    public int lO() {
        return this.DF.num + this.DG.num + this.DH.num + this.DI.num + this.DJ.num;
    }

    public int lP() {
        return this.DK.num + this.DL.num + this.DM.num + this.DN.num + this.DO.num;
    }

    public void reset() {
        this.Dy = 0;
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
        this.DO.reset();
    }

    public void lQ() {
        if (v.lL().lM() > 0) {
            com.baidu.tbadk.performanceLog.t.a(v.lL().DA.num, v.lL().DA.DP, v.lL().DA.DQ, v.lL().DA.time, v.lL().DB.num, v.lL().DB.DP, v.lL().DB.DQ, v.lL().DB.time, v.lL().DC.num, v.lL().DC.DP, v.lL().DC.DQ, v.lL().DC.time, v.lL().DE.num, v.lL().DE.DP, v.lL().DE.DQ, v.lL().DE.time, v.lL().DD.num, v.lL().DD.DP, v.lL().DD.DQ, v.lL().DD.time, 3);
        }
    }

    public void lR() {
        if (v.lL().lO() > 0) {
            com.baidu.tbadk.performanceLog.t.a(v.lL().DF.num, v.lL().DF.DP, v.lL().DF.DQ, v.lL().DF.time, v.lL().DG.num, v.lL().DG.DP, v.lL().DG.DQ, v.lL().DG.time, v.lL().DH.num, v.lL().DH.DP, v.lL().DH.DQ, v.lL().DH.time, v.lL().DJ.num, v.lL().DJ.DP, v.lL().DJ.DQ, v.lL().DJ.time, v.lL().DI.num, v.lL().DI.DP, v.lL().DI.DQ, v.lL().DI.time, 1);
        }
    }

    public void lS() {
        if (v.lL().lP() > 0) {
            com.baidu.tbadk.performanceLog.t.a(v.lL().DK.num, v.lL().DK.DP, v.lL().DK.DQ, v.lL().DK.time, v.lL().DL.num, v.lL().DL.DP, v.lL().DL.DQ, v.lL().DL.time, v.lL().DM.num, v.lL().DM.DP, v.lL().DM.DQ, v.lL().DM.time, v.lL().DO.num, v.lL().DO.DP, v.lL().DO.DQ, v.lL().DO.time, v.lL().DN.num, v.lL().DN.DP, v.lL().DN.DQ, v.lL().DN.time, 2);
        }
    }
}
