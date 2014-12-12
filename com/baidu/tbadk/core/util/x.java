package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x {
    int HK;
    boolean HL;
    y HM;
    y HN;
    y HO;
    y HP;
    y HQ;
    y HR;
    y HS;
    y HT;
    y HU;
    y HV;
    y HW;
    y HX;
    y HY;
    y HZ;
    y Ia;

    private x() {
        this.HK = 0;
        this.HM = new y(null);
        this.HN = new y(null);
        this.HO = new y(null);
        this.HP = new y(null);
        this.HQ = new y(null);
        this.HR = new y(null);
        this.HS = new y(null);
        this.HT = new y(null);
        this.HU = new y(null);
        this.HV = new y(null);
        this.HW = new y(null);
        this.HX = new y(null);
        this.HY = new y(null);
        this.HZ = new y(null);
        this.Ia = new y(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x(x xVar) {
        this();
    }

    public int oH() {
        return this.HM.num + this.HN.num + this.HO.num + this.HP.num + this.HQ.num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [93=12, 94=5, 95=5] */
    public int oI() {
        return this.HM.num + this.HN.num + this.HO.num + this.HP.num + this.HQ.num + this.HR.num + this.HS.num + this.HT.num + this.HU.num + this.HV.num + this.HW.num + this.HX.num + this.HY.num + this.HZ.num + this.Ia.num;
    }

    public int oJ() {
        return this.HR.num + this.HS.num + this.HT.num + this.HU.num + this.HV.num;
    }

    public int oK() {
        return this.HW.num + this.HX.num + this.HY.num + this.HZ.num + this.Ia.num;
    }

    public void reset() {
        this.HK = 0;
        this.HM.reset();
        this.HN.reset();
        this.HO.reset();
        this.HP.reset();
        this.HQ.reset();
        this.HR.reset();
        this.HS.reset();
        this.HT.reset();
        this.HU.reset();
        this.HV.reset();
        this.HW.reset();
        this.HX.reset();
        this.HY.reset();
        this.HZ.reset();
        this.Ia.reset();
    }

    public void oL() {
        if (w.oG().oH() > 0) {
            com.baidu.tbadk.performanceLog.aa.a(w.oG().HM.num, w.oG().HM.Ib, w.oG().HM.Id, w.oG().HM.Ic, w.oG().HM.time, w.oG().HN.num, w.oG().HN.Ib, w.oG().HN.Id, w.oG().HN.time, w.oG().HN.Ic, w.oG().HO.num, w.oG().HO.Ib, w.oG().HO.Id, w.oG().HO.time, w.oG().HO.Ic, w.oG().HQ.num, w.oG().HQ.Ib, w.oG().HQ.Id, w.oG().HQ.time, w.oG().HQ.Ic, w.oG().HP.num, w.oG().HP.Ib, w.oG().HP.Id, w.oG().HP.time, w.oG().HP.Ic, 3);
        }
    }

    public void oM() {
        if (w.oG().oJ() > 0) {
            com.baidu.tbadk.performanceLog.aa.a(w.oG().HR.num, w.oG().HR.Ib, w.oG().HR.Id, w.oG().HR.time, w.oG().HR.Ic, w.oG().HS.num, w.oG().HS.Ib, w.oG().HS.Id, w.oG().HS.time, w.oG().HS.Ic, w.oG().HT.num, w.oG().HT.Ib, w.oG().HT.Id, w.oG().HT.time, w.oG().HT.Ic, w.oG().HV.num, w.oG().HV.Ib, w.oG().HV.Id, w.oG().HV.time, w.oG().HV.Ic, w.oG().HU.num, w.oG().HU.Ib, w.oG().HU.Id, w.oG().HU.time, w.oG().HU.Ic, 1);
        }
    }

    public void oN() {
        if (w.oG().oK() > 0) {
            com.baidu.tbadk.performanceLog.aa.a(w.oG().HW.num, w.oG().HW.Ib, w.oG().HW.Id, w.oG().HW.time, w.oG().HW.Ic, w.oG().HX.num, w.oG().HX.Ib, w.oG().HX.Id, w.oG().HX.time, w.oG().HX.Ic, w.oG().HY.num, w.oG().HY.Ib, w.oG().HY.Id, w.oG().HY.time, w.oG().HY.Ic, w.oG().Ia.num, w.oG().Ia.Ib, w.oG().Ia.Id, w.oG().Ia.time, w.oG().Ia.Ic, w.oG().HZ.num, w.oG().HZ.Ib, w.oG().HZ.Id, w.oG().HZ.time, w.oG().HZ.Ic, 2);
        }
    }
}
