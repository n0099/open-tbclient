package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String SA;
    public String SB;
    public String SC;
    public String SD;
    public boolean SE;
    public String Sz;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i) {
        if (bVar != null && !bVar.SE) {
            com.baidu.tieba.recapp.report.a P = com.baidu.tieba.recapp.report.e.P(3, i, bVar.pn);
            P.qL(bVar.Sz);
            P.bX("isCache", String.valueOf(bVar.SA));
            P.qI(bVar.SB);
            P.qJ(bVar.SC);
            P.qK(bVar.fid);
            P.bX("vc", bVar.SD);
            P.qE(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.beC().a(P);
            bVar.SE = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.SE) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.qL(bVar.Sz);
            c.bX("isCache", bVar.SA);
            c.qI(bVar.SB);
            c.qJ(bVar.SC);
            c.qK(bVar.fid);
            c.bX("vc", bVar.SD);
            c.qE(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.beC().a(c);
            bVar.SE = true;
        }
    }

    public static void b(b bVar, int i) {
        if (bVar != null && !bVar.SE) {
            com.baidu.tieba.recapp.report.a P = com.baidu.tieba.recapp.report.e.P(3, i, bVar.pn);
            P.qL(bVar.Sz);
            P.qI(bVar.SB);
            P.qJ(bVar.SC);
            P.qK(bVar.fid);
            P.bX("vc", bVar.SD);
            P.qE(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.beC().a(P);
            bVar.SE = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.o oVar) {
        b bVar;
        if (oVar != null && oVar.bmj() != null && (bVar = oVar.bmj().advertAppContext) != null && !bVar.SE) {
            oVar.Tg = bVar.SB;
            oVar.Th = bVar.SC;
            oVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(oVar, 3);
            c.qE(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.beC().a(c);
            bVar.SE = true;
        }
    }

    public static void c(b bVar, int i) {
        if (bVar != null && !bVar.SE) {
            com.baidu.tieba.recapp.report.a P = com.baidu.tieba.recapp.report.e.P(3, i, bVar.pn);
            P.qL(bVar.Sz);
            P.qE(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.beC().a(P);
            bVar.SE = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.VY() != null && dVar.VY().advertAppContext != null && !dVar.VY().advertAppContext.SE) {
            dVar.VY().Sz = dVar.VY().advertAppContext.Sz;
            com.baidu.tbadk.distribute.a.Cq().a(dVar.VY(), "", 0L, dVar.VY().Sz, "show", dVar.VY().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(dVar.VY(), 3, dVar.VY().advertAppContext.pn);
            c.qE(dVar.VY().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.beC().a(c);
            dVar.VY().advertAppContext.SE = true;
        }
    }
}
