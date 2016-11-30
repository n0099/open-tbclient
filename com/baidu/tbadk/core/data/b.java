package com.baidu.tbadk.core.data;

import com.baidu.tieba.tbadkCore.data.p;
/* loaded from: classes.dex */
public class b {
    public String OS;
    public String OT;
    public String OU;
    public String OV;
    public String OW;
    public boolean OX;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i) {
        if (bVar != null && !bVar.OX) {
            com.baidu.tieba.recapp.report.a P = com.baidu.tieba.recapp.report.e.P(3, i, bVar.pn);
            P.rd(bVar.OS);
            P.bP("isCache", String.valueOf(bVar.OT));
            P.ra(bVar.OU);
            P.rb(bVar.OV);
            P.rc(bVar.fid);
            P.bP("vc", bVar.OW);
            P.qX(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.beF().a(P);
            bVar.OX = true;
        }
    }

    public static void a(c cVar) {
        b bVar;
        if (cVar != null && (bVar = cVar.PD) != null && !bVar.OX) {
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(cVar, 3, bVar.pn);
            a.rd(bVar.OS);
            a.bP("isCache", bVar.OT);
            a.ra(bVar.OU);
            a.rb(bVar.OV);
            a.rc(bVar.fid);
            a.bP("vc", bVar.OW);
            a.qX(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.beF().a(a);
            bVar.OX = true;
        }
    }

    public static void b(b bVar, int i) {
        if (bVar != null && !bVar.OX) {
            com.baidu.tieba.recapp.report.a P = com.baidu.tieba.recapp.report.e.P(3, i, bVar.pn);
            P.rd(bVar.OS);
            P.ra(bVar.OU);
            P.rb(bVar.OV);
            P.rc(bVar.fid);
            P.bP("vc", bVar.OW);
            P.qX(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.beF().a(P);
            bVar.OX = true;
        }
    }

    public static void a(p pVar) {
        b bVar;
        if (pVar != null && pVar.blZ() != null && (bVar = pVar.blZ().PD) != null && !bVar.OX) {
            pVar.PE = bVar.OU;
            pVar.PF = bVar.OV;
            pVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(pVar, 3);
            a.qX(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.beF().a(a);
            bVar.OX = true;
        }
    }

    public static void c(b bVar, int i) {
        if (bVar != null && !bVar.OX) {
            com.baidu.tieba.recapp.report.a P = com.baidu.tieba.recapp.report.e.P(3, i, bVar.pn);
            P.rd(bVar.OS);
            P.qX(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.beF().a(P);
            bVar.OX = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.PA() != null && dVar.PA().PD != null && !dVar.PA().PD.OX) {
            dVar.PA().OS = dVar.PA().PD.OS;
            com.baidu.tbadk.distribute.a.Cx().a(dVar.PA(), "", 0L, dVar.PA().OS, "show", dVar.PA().PD.pn);
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(dVar.PA(), 3, dVar.PA().PD.pn);
            a.qX(dVar.PA().PD.extensionInfo);
            com.baidu.tieba.recapp.report.b.beF().a(a);
            dVar.PA().PD.OX = true;
        }
    }
}
