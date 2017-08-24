package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String Up;
    public String Uq;
    public String Ur;
    public String Us;
    public String Ut;
    public boolean Uu;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Uu) {
            com.baidu.tieba.recapp.report.a Q = com.baidu.tieba.recapp.report.d.Q(z ? 13 : 3, i, bVar.pn);
            Q.rw(bVar.Up);
            Q.ca("isCache", String.valueOf(bVar.Uq));
            Q.rt(bVar.Ur);
            Q.ru(bVar.Us);
            Q.rv(bVar.fid);
            Q.ca("vc", bVar.Ut);
            Q.rp(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.biO().a(Q);
            bVar.Uu = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.Uu) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(advertAppInfo, 3, bVar.pn);
            c.rw(bVar.Up);
            c.ca("isCache", bVar.Uq);
            c.rt(bVar.Ur);
            c.ru(bVar.Us);
            c.rv(bVar.fid);
            c.ca("vc", bVar.Ut);
            c.rp(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.biO().a(c);
            bVar.Uu = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Uu) {
            com.baidu.tieba.recapp.report.a Q = com.baidu.tieba.recapp.report.d.Q(z ? 13 : 3, i, bVar.pn);
            Q.rw(bVar.Up);
            Q.rt(bVar.Ur);
            Q.ru(bVar.Us);
            Q.rv(bVar.fid);
            Q.ca("vc", bVar.Ut);
            Q.rp(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.biO().a(Q);
            bVar.Uu = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bsO() != null && (bVar = lVar.bsO().advertAppContext) != null && !bVar.Uu) {
            lVar.UY = bVar.Ur;
            lVar.UZ = bVar.Us;
            lVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(lVar, 3);
            c.rp(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.biO().a(c);
            bVar.Uu = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Uu) {
            com.baidu.tieba.recapp.report.a Q = com.baidu.tieba.recapp.report.d.Q(z ? 13 : 3, i, bVar.pn);
            Q.rw(bVar.Up);
            Q.rp(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.biO().a(Q);
            bVar.Uu = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.Xe() != null && dVar.Xe().advertAppContext != null && !dVar.Xe().advertAppContext.Uu) {
            dVar.Xe().Up = dVar.Xe().advertAppContext.Up;
            com.baidu.tbadk.distribute.a.CK().a(dVar.Xe(), "", 0L, dVar.Xe().Up, "show", dVar.Xe().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(dVar.Xe(), 3, dVar.Xe().advertAppContext.pn);
            c.rp(dVar.Xe().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.biO().a(c);
            dVar.Xe().advertAppContext.Uu = true;
        }
    }
}
