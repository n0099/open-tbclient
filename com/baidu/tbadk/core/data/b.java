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
            aa.rJ(bVar.TL);
            aa.bU("isCache", String.valueOf(bVar.TM));
            aa.rG(bVar.TO);
            aa.rH(bVar.TP);
            aa.rI(bVar.fid);
            aa.bU("vc", bVar.TQ);
            aa.rC(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bjV().a(aa);
            bVar.TR = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.TR) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.rJ(bVar.TL);
            c.bU("isCache", bVar.TM);
            c.rG(bVar.TO);
            c.rH(bVar.TP);
            c.rI(bVar.fid);
            c.bU("vc", bVar.TQ);
            c.rC(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bjV().a(c);
            bVar.TR = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.TR) {
            com.baidu.tieba.recapp.report.a aa = com.baidu.tieba.recapp.report.e.aa(z ? 13 : 3, i, bVar.pn);
            aa.rJ(bVar.TL);
            aa.rG(bVar.TO);
            aa.rH(bVar.TP);
            aa.rI(bVar.fid);
            aa.bU("vc", bVar.TQ);
            aa.rC(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bjV().a(aa);
            bVar.TR = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.buv() != null && (bVar = lVar.buv().advertAppContext) != null && !bVar.TR) {
            lVar.Uu = bVar.TO;
            lVar.Uv = bVar.TP;
            lVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 3);
            c.rC(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bjV().a(c);
            bVar.TR = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.TR) {
            com.baidu.tieba.recapp.report.a aa = com.baidu.tieba.recapp.report.e.aa(z ? 13 : 3, i, bVar.pn);
            aa.rJ(bVar.TL);
            aa.rC(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bjV().a(aa);
            bVar.TR = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.aas() != null && dVar.aas().advertAppContext != null && !dVar.aas().advertAppContext.TR) {
            dVar.aas().TL = dVar.aas().advertAppContext.TL;
            com.baidu.tbadk.distribute.a.CE().a(dVar.aas(), "", 0L, dVar.aas().TL, "show", dVar.aas().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.aas(), 3, dVar.aas().advertAppContext.pn);
            d.rC(dVar.aas().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bjV().a(d);
            dVar.aas().advertAppContext.TR = true;
        }
    }
}
