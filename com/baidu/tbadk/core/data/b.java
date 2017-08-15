package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String Uo;
    public String Up;
    public String Uq;
    public String Ur;
    public String Us;
    public boolean Ut;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Ut) {
            com.baidu.tieba.recapp.report.a Q = com.baidu.tieba.recapp.report.d.Q(z ? 13 : 3, i, bVar.pn);
            Q.rr(bVar.Uo);
            Q.bZ("isCache", String.valueOf(bVar.Up));
            Q.ro(bVar.Uq);
            Q.rp(bVar.Ur);
            Q.rq(bVar.fid);
            Q.bZ("vc", bVar.Us);
            Q.rk(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.biT().a(Q);
            bVar.Ut = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.Ut) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(advertAppInfo, 3, bVar.pn);
            c.rr(bVar.Uo);
            c.bZ("isCache", bVar.Up);
            c.ro(bVar.Uq);
            c.rp(bVar.Ur);
            c.rq(bVar.fid);
            c.bZ("vc", bVar.Us);
            c.rk(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.biT().a(c);
            bVar.Ut = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Ut) {
            com.baidu.tieba.recapp.report.a Q = com.baidu.tieba.recapp.report.d.Q(z ? 13 : 3, i, bVar.pn);
            Q.rr(bVar.Uo);
            Q.ro(bVar.Uq);
            Q.rp(bVar.Ur);
            Q.rq(bVar.fid);
            Q.bZ("vc", bVar.Us);
            Q.rk(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.biT().a(Q);
            bVar.Ut = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bsV() != null && (bVar = lVar.bsV().advertAppContext) != null && !bVar.Ut) {
            lVar.UX = bVar.Uq;
            lVar.UY = bVar.Ur;
            lVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(lVar, 3);
            c.rk(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.biT().a(c);
            bVar.Ut = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Ut) {
            com.baidu.tieba.recapp.report.a Q = com.baidu.tieba.recapp.report.d.Q(z ? 13 : 3, i, bVar.pn);
            Q.rr(bVar.Uo);
            Q.rk(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.biT().a(Q);
            bVar.Ut = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.Xh() != null && dVar.Xh().advertAppContext != null && !dVar.Xh().advertAppContext.Ut) {
            dVar.Xh().Uo = dVar.Xh().advertAppContext.Uo;
            com.baidu.tbadk.distribute.a.CK().a(dVar.Xh(), "", 0L, dVar.Xh().Uo, "show", dVar.Xh().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(dVar.Xh(), 3, dVar.Xh().advertAppContext.pn);
            c.rk(dVar.Xh().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.biT().a(c);
            dVar.Xh().advertAppContext.Ut = true;
        }
    }
}
