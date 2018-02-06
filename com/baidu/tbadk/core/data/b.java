package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String aKi;
    public String aKj;
    public String aKk;
    public String aKl;
    public String aKm;
    public boolean aKn;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aKn) {
            com.baidu.tieba.recapp.report.a ai = com.baidu.tieba.recapp.report.e.ai(z ? 13 : 3, i, bVar.pn);
            ai.sd(bVar.aKi);
            ai.bS("isCache", String.valueOf(bVar.aKj));
            ai.sa(bVar.aKk);
            ai.sb(bVar.aKl);
            ai.sc(bVar.fid);
            ai.bS("vc", bVar.aKm);
            ai.rW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.boX().a(ai);
            bVar.aKn = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.aKn) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.sd(bVar.aKi);
            c.bS("isCache", bVar.aKj);
            c.sa(bVar.aKk);
            c.sb(bVar.aKl);
            c.sc(bVar.fid);
            c.bS("vc", bVar.aKm);
            c.rW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.boX().a(c);
            bVar.aKn = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aKn) {
            com.baidu.tieba.recapp.report.a ai = com.baidu.tieba.recapp.report.e.ai(z ? 13 : 3, i, bVar.pn);
            ai.sd(bVar.aKi);
            ai.sa(bVar.aKk);
            ai.sb(bVar.aKl);
            ai.sc(bVar.fid);
            ai.bS("vc", bVar.aKm);
            ai.rW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.boX().a(ai);
            bVar.aKn = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bwJ() != null && (bVar = lVar.bwJ().advertAppContext) != null && !bVar.aKn) {
            lVar.aKT = bVar.aKk;
            lVar.aKU = bVar.aKl;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.bwK() != null && lVar.bwK().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, i);
            c.rW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.boX().a(c);
            bVar.aKn = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aKn) {
            com.baidu.tieba.recapp.report.a ai = com.baidu.tieba.recapp.report.e.ai(z ? 13 : 3, i, bVar.pn);
            ai.sd(bVar.aKi);
            ai.rW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.boX().a(ai);
            bVar.aKn = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.alH() != null && dVar.alH().advertAppContext != null && !dVar.alH().advertAppContext.aKn) {
            dVar.alH().aKi = dVar.alH().advertAppContext.aKi;
            com.baidu.tbadk.distribute.a.KM().a(dVar.alH(), "", 0L, dVar.alH().aKi, "show", dVar.alH().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.alH(), 3, dVar.alH().advertAppContext.pn);
            d.rW(dVar.alH().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.boX().a(d);
            dVar.alH().advertAppContext.aKn = true;
        }
    }
}
