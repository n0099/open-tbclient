package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String TL;
    public String TM;
    public String TO;
    public String TP;
    public String TQ;
    public boolean TR;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.TR) {
            com.baidu.tieba.recapp.report.a aa = com.baidu.tieba.recapp.report.e.aa(z ? 13 : 3, i, bVar.pn);
            aa.rC(bVar.TL);
            aa.bQ("isCache", String.valueOf(bVar.TM));
            aa.rz(bVar.TO);
            aa.rA(bVar.TP);
            aa.rB(bVar.fid);
            aa.bQ("vc", bVar.TQ);
            aa.rv(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bjK().a(aa);
            bVar.TR = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.TR) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.rC(bVar.TL);
            c.bQ("isCache", bVar.TM);
            c.rz(bVar.TO);
            c.rA(bVar.TP);
            c.rB(bVar.fid);
            c.bQ("vc", bVar.TQ);
            c.rv(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bjK().a(c);
            bVar.TR = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.TR) {
            com.baidu.tieba.recapp.report.a aa = com.baidu.tieba.recapp.report.e.aa(z ? 13 : 3, i, bVar.pn);
            aa.rC(bVar.TL);
            aa.rz(bVar.TO);
            aa.rA(bVar.TP);
            aa.rB(bVar.fid);
            aa.bQ("vc", bVar.TQ);
            aa.rv(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bjK().a(aa);
            bVar.TR = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.buj() != null && (bVar = lVar.buj().advertAppContext) != null && !bVar.TR) {
            lVar.Uu = bVar.TO;
            lVar.Uv = bVar.TP;
            lVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 3);
            c.rv(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bjK().a(c);
            bVar.TR = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.TR) {
            com.baidu.tieba.recapp.report.a aa = com.baidu.tieba.recapp.report.e.aa(z ? 13 : 3, i, bVar.pn);
            aa.rC(bVar.TL);
            aa.rv(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bjK().a(aa);
            bVar.TR = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.aag() != null && dVar.aag().advertAppContext != null && !dVar.aag().advertAppContext.TR) {
            dVar.aag().TL = dVar.aag().advertAppContext.TL;
            com.baidu.tbadk.distribute.a.Cs().a(dVar.aag(), "", 0L, dVar.aag().TL, "show", dVar.aag().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.aag(), 3, dVar.aag().advertAppContext.pn);
            d.rv(dVar.aag().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bjK().a(d);
            dVar.aag().advertAppContext.TR = true;
        }
    }
}
