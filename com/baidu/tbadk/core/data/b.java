package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String Tt;
    public String Tu;
    public String Tv;
    public String Tw;
    public String Tx;
    public boolean Ty;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Ty) {
            com.baidu.tieba.recapp.report.a X = com.baidu.tieba.recapp.report.e.X(z ? 13 : 3, i, bVar.pn);
            X.qV(bVar.Tt);
            X.bT("isCache", String.valueOf(bVar.Tu));
            X.qS(bVar.Tv);
            X.qT(bVar.Tw);
            X.qU(bVar.fid);
            X.bT("vc", bVar.Tx);
            X.qO(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bgy().a(X);
            bVar.Ty = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.Ty) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.qV(bVar.Tt);
            c.bT("isCache", bVar.Tu);
            c.qS(bVar.Tv);
            c.qT(bVar.Tw);
            c.qU(bVar.fid);
            c.bT("vc", bVar.Tx);
            c.qO(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bgy().a(c);
            bVar.Ty = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Ty) {
            com.baidu.tieba.recapp.report.a X = com.baidu.tieba.recapp.report.e.X(z ? 13 : 3, i, bVar.pn);
            X.qV(bVar.Tt);
            X.qS(bVar.Tv);
            X.qT(bVar.Tw);
            X.qU(bVar.fid);
            X.bT("vc", bVar.Tx);
            X.qO(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bgy().a(X);
            bVar.Ty = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bre() != null && (bVar = lVar.bre().advertAppContext) != null && !bVar.Ty) {
            lVar.Uc = bVar.Tv;
            lVar.Ud = bVar.Tw;
            lVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 3);
            c.qO(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bgy().a(c);
            bVar.Ty = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Ty) {
            com.baidu.tieba.recapp.report.a X = com.baidu.tieba.recapp.report.e.X(z ? 13 : 3, i, bVar.pn);
            X.qV(bVar.Tt);
            X.qO(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bgy().a(X);
            bVar.Ty = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.XW() != null && dVar.XW().advertAppContext != null && !dVar.XW().advertAppContext.Ty) {
            dVar.XW().Tt = dVar.XW().advertAppContext.Tt;
            com.baidu.tbadk.distribute.a.Cd().a(dVar.XW(), "", 0L, dVar.XW().Tt, "show", dVar.XW().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.XW(), 3, dVar.XW().advertAppContext.pn);
            d.qO(dVar.XW().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bgy().a(d);
            dVar.XW().advertAppContext.Ty = true;
        }
    }
}
