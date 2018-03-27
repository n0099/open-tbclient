package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String aJY;
    public String aJZ;
    public String aKa;
    public String aKb;
    public String aKc;
    public boolean aKd;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aKd) {
            com.baidu.tieba.recapp.report.a ai = com.baidu.tieba.recapp.report.e.ai(z ? 13 : 3, i, bVar.pn);
            ai.sd(bVar.aJY);
            ai.bS("isCache", String.valueOf(bVar.aJZ));
            ai.sa(bVar.aKa);
            ai.sb(bVar.aKb);
            ai.sc(bVar.fid);
            ai.bS("vc", bVar.aKc);
            ai.rW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.boX().a(ai);
            bVar.aKd = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.aKd) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.sd(bVar.aJY);
            c.bS("isCache", bVar.aJZ);
            c.sa(bVar.aKa);
            c.sb(bVar.aKb);
            c.sc(bVar.fid);
            c.bS("vc", bVar.aKc);
            c.rW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.boX().a(c);
            bVar.aKd = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aKd) {
            com.baidu.tieba.recapp.report.a ai = com.baidu.tieba.recapp.report.e.ai(z ? 13 : 3, i, bVar.pn);
            ai.sd(bVar.aJY);
            ai.sa(bVar.aKa);
            ai.sb(bVar.aKb);
            ai.sc(bVar.fid);
            ai.bS("vc", bVar.aKc);
            ai.rW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.boX().a(ai);
            bVar.aKd = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        b bVar;
        if (mVar != null && mVar.bwN() != null && (bVar = mVar.bwN().advertAppContext) != null && !bVar.aKd) {
            mVar.aKJ = bVar.aKa;
            mVar.aKK = bVar.aKb;
            mVar.forumId = bVar.fid;
            int i = 3;
            if (mVar != null && mVar.bwO() != null && mVar.bwO().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(mVar, i);
            c.rW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.boX().a(c);
            bVar.aKd = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aKd) {
            com.baidu.tieba.recapp.report.a ai = com.baidu.tieba.recapp.report.e.ai(z ? 13 : 3, i, bVar.pn);
            ai.sd(bVar.aJY);
            ai.rW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.boX().a(ai);
            bVar.aKd = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.alH() != null && dVar.alH().advertAppContext != null && !dVar.alH().advertAppContext.aKd) {
            dVar.alH().aJY = dVar.alH().advertAppContext.aJY;
            com.baidu.tbadk.distribute.a.KM().a(dVar.alH(), "", 0L, dVar.alH().aJY, "show", dVar.alH().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.alH(), 3, dVar.alH().advertAppContext.pn);
            d.rW(dVar.alH().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.boX().a(d);
            dVar.alH().advertAppContext.aKd = true;
        }
    }
}
