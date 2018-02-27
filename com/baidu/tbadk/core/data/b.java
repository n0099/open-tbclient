package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String aJX;
    public String aJY;
    public String aJZ;
    public String aKa;
    public String aKb;
    public boolean aKc;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aKc) {
            com.baidu.tieba.recapp.report.a ai = com.baidu.tieba.recapp.report.e.ai(z ? 13 : 3, i, bVar.pn);
            ai.sd(bVar.aJX);
            ai.bS("isCache", String.valueOf(bVar.aJY));
            ai.sa(bVar.aJZ);
            ai.sb(bVar.aKa);
            ai.sc(bVar.fid);
            ai.bS("vc", bVar.aKb);
            ai.rW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.boW().a(ai);
            bVar.aKc = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.aKc) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.sd(bVar.aJX);
            c.bS("isCache", bVar.aJY);
            c.sa(bVar.aJZ);
            c.sb(bVar.aKa);
            c.sc(bVar.fid);
            c.bS("vc", bVar.aKb);
            c.rW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.boW().a(c);
            bVar.aKc = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aKc) {
            com.baidu.tieba.recapp.report.a ai = com.baidu.tieba.recapp.report.e.ai(z ? 13 : 3, i, bVar.pn);
            ai.sd(bVar.aJX);
            ai.sa(bVar.aJZ);
            ai.sb(bVar.aKa);
            ai.sc(bVar.fid);
            ai.bS("vc", bVar.aKb);
            ai.rW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.boW().a(ai);
            bVar.aKc = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bwI() != null && (bVar = lVar.bwI().advertAppContext) != null && !bVar.aKc) {
            lVar.aKI = bVar.aJZ;
            lVar.aKJ = bVar.aKa;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.bwJ() != null && lVar.bwJ().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, i);
            c.rW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.boW().a(c);
            bVar.aKc = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aKc) {
            com.baidu.tieba.recapp.report.a ai = com.baidu.tieba.recapp.report.e.ai(z ? 13 : 3, i, bVar.pn);
            ai.sd(bVar.aJX);
            ai.rW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.boW().a(ai);
            bVar.aKc = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.alG() != null && dVar.alG().advertAppContext != null && !dVar.alG().advertAppContext.aKc) {
            dVar.alG().aJX = dVar.alG().advertAppContext.aJX;
            com.baidu.tbadk.distribute.a.KL().a(dVar.alG(), "", 0L, dVar.alG().aJX, "show", dVar.alG().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.alG(), 3, dVar.alG().advertAppContext.pn);
            d.rW(dVar.alG().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.boW().a(d);
            dVar.alG().advertAppContext.aKc = true;
        }
    }
}
