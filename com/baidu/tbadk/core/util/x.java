package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x {
    int HT;
    boolean HU;
    y HV;
    y HW;
    y HX;
    y HY;
    y HZ;
    y Ia;
    y Ib;
    y Ic;
    y Id;
    y Ie;
    y If;
    y Ig;
    y Ih;
    y Ii;
    y Ij;

    private x() {
        this.HT = 0;
        this.HV = new y(null);
        this.HW = new y(null);
        this.HX = new y(null);
        this.HY = new y(null);
        this.HZ = new y(null);
        this.Ia = new y(null);
        this.Ib = new y(null);
        this.Ic = new y(null);
        this.Id = new y(null);
        this.Ie = new y(null);
        this.If = new y(null);
        this.Ig = new y(null);
        this.Ih = new y(null);
        this.Ii = new y(null);
        this.Ij = new y(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x(x xVar) {
        this();
    }

    public int oK() {
        return this.HV.num + this.HW.num + this.HX.num + this.HY.num + this.HZ.num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [93=12, 94=5, 95=5] */
    public int oL() {
        return this.HV.num + this.HW.num + this.HX.num + this.HY.num + this.HZ.num + this.Ia.num + this.Ib.num + this.Ic.num + this.Id.num + this.Ie.num + this.If.num + this.Ig.num + this.Ih.num + this.Ii.num + this.Ij.num;
    }

    public int oM() {
        return this.Ia.num + this.Ib.num + this.Ic.num + this.Id.num + this.Ie.num;
    }

    public int oN() {
        return this.If.num + this.Ig.num + this.Ih.num + this.Ii.num + this.Ij.num;
    }

    public void reset() {
        this.HT = 0;
        this.HV.reset();
        this.HW.reset();
        this.HX.reset();
        this.HY.reset();
        this.HZ.reset();
        this.Ia.reset();
        this.Ib.reset();
        this.Ic.reset();
        this.Id.reset();
        this.Ie.reset();
        this.If.reset();
        this.Ig.reset();
        this.Ih.reset();
        this.Ii.reset();
        this.Ij.reset();
    }

    public void oO() {
        if (w.oJ().oK() > 0) {
            com.baidu.tbadk.performanceLog.aa.a(w.oJ().HV.num, w.oJ().HV.Ik, w.oJ().HV.Im, w.oJ().HV.Il, w.oJ().HV.time, w.oJ().HW.num, w.oJ().HW.Ik, w.oJ().HW.Im, w.oJ().HW.time, w.oJ().HW.Il, w.oJ().HX.num, w.oJ().HX.Ik, w.oJ().HX.Im, w.oJ().HX.time, w.oJ().HX.Il, w.oJ().HZ.num, w.oJ().HZ.Ik, w.oJ().HZ.Im, w.oJ().HZ.time, w.oJ().HZ.Il, w.oJ().HY.num, w.oJ().HY.Ik, w.oJ().HY.Im, w.oJ().HY.time, w.oJ().HY.Il, 3);
        }
    }

    public void oP() {
        if (w.oJ().oM() > 0) {
            com.baidu.tbadk.performanceLog.aa.a(w.oJ().Ia.num, w.oJ().Ia.Ik, w.oJ().Ia.Im, w.oJ().Ia.time, w.oJ().Ia.Il, w.oJ().Ib.num, w.oJ().Ib.Ik, w.oJ().Ib.Im, w.oJ().Ib.time, w.oJ().Ib.Il, w.oJ().Ic.num, w.oJ().Ic.Ik, w.oJ().Ic.Im, w.oJ().Ic.time, w.oJ().Ic.Il, w.oJ().Ie.num, w.oJ().Ie.Ik, w.oJ().Ie.Im, w.oJ().Ie.time, w.oJ().Ie.Il, w.oJ().Id.num, w.oJ().Id.Ik, w.oJ().Id.Im, w.oJ().Id.time, w.oJ().Id.Il, 1);
        }
    }

    public void oQ() {
        if (w.oJ().oN() > 0) {
            com.baidu.tbadk.performanceLog.aa.a(w.oJ().If.num, w.oJ().If.Ik, w.oJ().If.Im, w.oJ().If.time, w.oJ().If.Il, w.oJ().Ig.num, w.oJ().Ig.Ik, w.oJ().Ig.Im, w.oJ().Ig.time, w.oJ().Ig.Il, w.oJ().Ih.num, w.oJ().Ih.Ik, w.oJ().Ih.Im, w.oJ().Ih.time, w.oJ().Ih.Il, w.oJ().Ij.num, w.oJ().Ij.Ik, w.oJ().Ij.Im, w.oJ().Ij.time, w.oJ().Ij.Il, w.oJ().Ii.num, w.oJ().Ii.Ik, w.oJ().Ii.Im, w.oJ().Ii.time, w.oJ().Ii.Il, 2);
        }
    }
}
