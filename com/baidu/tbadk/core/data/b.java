package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String SO;
    public String SP;
    public String SQ;
    public String SR;
    public String SS;
    public boolean ST;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.ST) {
            com.baidu.tieba.recapp.report.a Q = com.baidu.tieba.recapp.report.d.Q(z ? 13 : 3, i, bVar.pn);
            Q.rk(bVar.SO);
            Q.bY("isCache", String.valueOf(bVar.SP));
            Q.rh(bVar.SQ);
            Q.ri(bVar.SR);
            Q.rj(bVar.fid);
            Q.bY("vc", bVar.SS);
            Q.rd(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bid().a(Q);
            bVar.ST = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.ST) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(advertAppInfo, 3, bVar.pn);
            c.rk(bVar.SO);
            c.bY("isCache", bVar.SP);
            c.rh(bVar.SQ);
            c.ri(bVar.SR);
            c.rj(bVar.fid);
            c.bY("vc", bVar.SS);
            c.rd(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bid().a(c);
            bVar.ST = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.ST) {
            com.baidu.tieba.recapp.report.a Q = com.baidu.tieba.recapp.report.d.Q(z ? 13 : 3, i, bVar.pn);
            Q.rk(bVar.SO);
            Q.rh(bVar.SQ);
            Q.ri(bVar.SR);
            Q.rj(bVar.fid);
            Q.bY("vc", bVar.SS);
            Q.rd(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bid().a(Q);
            bVar.ST = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bsg() != null && (bVar = lVar.bsg().advertAppContext) != null && !bVar.ST) {
            lVar.Tv = bVar.SQ;
            lVar.Tw = bVar.SR;
            lVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(lVar, 3);
            c.rd(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bid().a(c);
            bVar.ST = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.ST) {
            com.baidu.tieba.recapp.report.a Q = com.baidu.tieba.recapp.report.d.Q(z ? 13 : 3, i, bVar.pn);
            Q.rk(bVar.SO);
            Q.rd(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bid().a(Q);
            bVar.ST = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.WG() != null && dVar.WG().advertAppContext != null && !dVar.WG().advertAppContext.ST) {
            dVar.WG().SO = dVar.WG().advertAppContext.SO;
            com.baidu.tbadk.distribute.a.CC().a(dVar.WG(), "", 0L, dVar.WG().SO, "show", dVar.WG().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(dVar.WG(), 3, dVar.WG().advertAppContext.pn);
            c.rd(dVar.WG().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bid().a(c);
            dVar.WG().advertAppContext.ST = true;
        }
    }
}
