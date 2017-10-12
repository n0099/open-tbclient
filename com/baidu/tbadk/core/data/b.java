package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String TF;
    public String TG;
    public String TH;
    public String TI;
    public String TJ;
    public boolean TK;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.TK) {
            com.baidu.tieba.recapp.report.a X = com.baidu.tieba.recapp.report.e.X(z ? 13 : 3, i, bVar.pn);
            X.qW(bVar.TF);
            X.bU("isCache", String.valueOf(bVar.TG));
            X.qT(bVar.TH);
            X.qU(bVar.TI);
            X.qV(bVar.fid);
            X.bU("vc", bVar.TJ);
            X.qP(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bgD().a(X);
            bVar.TK = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.TK) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.qW(bVar.TF);
            c.bU("isCache", bVar.TG);
            c.qT(bVar.TH);
            c.qU(bVar.TI);
            c.qV(bVar.fid);
            c.bU("vc", bVar.TJ);
            c.qP(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bgD().a(c);
            bVar.TK = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.TK) {
            com.baidu.tieba.recapp.report.a X = com.baidu.tieba.recapp.report.e.X(z ? 13 : 3, i, bVar.pn);
            X.qW(bVar.TF);
            X.qT(bVar.TH);
            X.qU(bVar.TI);
            X.qV(bVar.fid);
            X.bU("vc", bVar.TJ);
            X.qP(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bgD().a(X);
            bVar.TK = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.brl() != null && (bVar = lVar.brl().advertAppContext) != null && !bVar.TK) {
            lVar.Uo = bVar.TH;
            lVar.Up = bVar.TI;
            lVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 3);
            c.qP(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bgD().a(c);
            bVar.TK = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.TK) {
            com.baidu.tieba.recapp.report.a X = com.baidu.tieba.recapp.report.e.X(z ? 13 : 3, i, bVar.pn);
            X.qW(bVar.TF);
            X.qP(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bgD().a(X);
            bVar.TK = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.Ya() != null && dVar.Ya().advertAppContext != null && !dVar.Ya().advertAppContext.TK) {
            dVar.Ya().TF = dVar.Ya().advertAppContext.TF;
            com.baidu.tbadk.distribute.a.Cj().a(dVar.Ya(), "", 0L, dVar.Ya().TF, "show", dVar.Ya().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.Ya(), 3, dVar.Ya().advertAppContext.pn);
            d.qP(dVar.Ya().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bgD().a(d);
            dVar.Ya().advertAppContext.TK = true;
        }
    }
}
