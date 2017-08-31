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
            Q.rk(bVar.Tr);
            Q.bZ("isCache", String.valueOf(bVar.Ts));
            Q.rh(bVar.Tt);
            Q.ri(bVar.Tu);
            Q.rj(bVar.fid);
            Q.bZ("vc", bVar.Tv);
            Q.rd(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bhN().a(Q);
            bVar.Tw = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.Tw) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.rk(bVar.Tr);
            c.bZ("isCache", bVar.Ts);
            c.rh(bVar.Tt);
            c.ri(bVar.Tu);
            c.rj(bVar.fid);
            c.bZ("vc", bVar.Tv);
            c.rd(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bhN().a(c);
            bVar.Tw = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Tw) {
            com.baidu.tieba.recapp.report.a Q = com.baidu.tieba.recapp.report.e.Q(z ? 13 : 3, i, bVar.pn);
            Q.rk(bVar.Tr);
            Q.rh(bVar.Tt);
            Q.ri(bVar.Tu);
            Q.rj(bVar.fid);
            Q.bZ("vc", bVar.Tv);
            Q.rd(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bhN().a(Q);
            bVar.Tw = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bsd() != null && (bVar = lVar.bsd().advertAppContext) != null && !bVar.Tw) {
            lVar.Ua = bVar.Tt;
            lVar.Ub = bVar.Tu;
            lVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 3);
            c.rd(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bhN().a(c);
            bVar.Tw = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Tw) {
            com.baidu.tieba.recapp.report.a Q = com.baidu.tieba.recapp.report.e.Q(z ? 13 : 3, i, bVar.pn);
            Q.rk(bVar.Tr);
            Q.rd(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bhN().a(Q);
            bVar.Tw = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.Yh() != null && dVar.Yh().advertAppContext != null && !dVar.Yh().advertAppContext.Tw) {
            dVar.Yh().Tr = dVar.Yh().advertAppContext.Tr;
            com.baidu.tbadk.distribute.a.CF().a(dVar.Yh(), "", 0L, dVar.Yh().Tr, "show", dVar.Yh().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.Yh(), 3, dVar.Yh().advertAppContext.pn);
            d.rd(dVar.Yh().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bhN().a(d);
            dVar.Yh().advertAppContext.Tw = true;
        }
    }
}
