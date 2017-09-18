package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String Tr;
    public String Ts;
    public String Tt;
    public String Tu;
    public String Tv;
    public boolean Tw;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Tw) {
            com.baidu.tieba.recapp.report.a Q = com.baidu.tieba.recapp.report.e.Q(z ? 13 : 3, i, bVar.pn);
            Q.rm(bVar.Tr);
            Q.bZ("isCache", String.valueOf(bVar.Ts));
            Q.rj(bVar.Tt);
            Q.rk(bVar.Tu);
            Q.rl(bVar.fid);
            Q.bZ("vc", bVar.Tv);
            Q.rf(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bhY().a(Q);
            bVar.Tw = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.Tw) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.rm(bVar.Tr);
            c.bZ("isCache", bVar.Ts);
            c.rj(bVar.Tt);
            c.rk(bVar.Tu);
            c.rl(bVar.fid);
            c.bZ("vc", bVar.Tv);
            c.rf(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bhY().a(c);
            bVar.Tw = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Tw) {
            com.baidu.tieba.recapp.report.a Q = com.baidu.tieba.recapp.report.e.Q(z ? 13 : 3, i, bVar.pn);
            Q.rm(bVar.Tr);
            Q.rj(bVar.Tt);
            Q.rk(bVar.Tu);
            Q.rl(bVar.fid);
            Q.bZ("vc", bVar.Tv);
            Q.rf(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bhY().a(Q);
            bVar.Tw = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bso() != null && (bVar = lVar.bso().advertAppContext) != null && !bVar.Tw) {
            lVar.Ua = bVar.Tt;
            lVar.Ub = bVar.Tu;
            lVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 3);
            c.rf(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bhY().a(c);
            bVar.Tw = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Tw) {
            com.baidu.tieba.recapp.report.a Q = com.baidu.tieba.recapp.report.e.Q(z ? 13 : 3, i, bVar.pn);
            Q.rm(bVar.Tr);
            Q.rf(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bhY().a(Q);
            bVar.Tw = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.Ys() != null && dVar.Ys().advertAppContext != null && !dVar.Ys().advertAppContext.Tw) {
            dVar.Ys().Tr = dVar.Ys().advertAppContext.Tr;
            com.baidu.tbadk.distribute.a.CF().a(dVar.Ys(), "", 0L, dVar.Ys().Tr, "show", dVar.Ys().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.Ys(), 3, dVar.Ys().advertAppContext.pn);
            d.rf(dVar.Ys().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bhY().a(d);
            dVar.Ys().advertAppContext.Tw = true;
        }
    }
}
