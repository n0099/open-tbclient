package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String Uq;
    public String Ur;
    public String Us;
    public String Ut;
    public String Uu;
    public boolean Uv;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Uv) {
            com.baidu.tieba.recapp.report.a Z = com.baidu.tieba.recapp.report.e.Z(z ? 13 : 3, i, bVar.pn);
            Z.si(bVar.Uq);
            Z.bW("isCache", String.valueOf(bVar.Ur));
            Z.sf(bVar.Us);
            Z.sg(bVar.Ut);
            Z.sh(bVar.fid);
            Z.bW("vc", bVar.Uu);
            Z.sb(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bmB().a(Z);
            bVar.Uv = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.Uv) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.si(bVar.Uq);
            c.bW("isCache", bVar.Ur);
            c.sf(bVar.Us);
            c.sg(bVar.Ut);
            c.sh(bVar.fid);
            c.bW("vc", bVar.Uu);
            c.sb(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bmB().a(c);
            bVar.Uv = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Uv) {
            com.baidu.tieba.recapp.report.a Z = com.baidu.tieba.recapp.report.e.Z(z ? 13 : 3, i, bVar.pn);
            Z.si(bVar.Uq);
            Z.sf(bVar.Us);
            Z.sg(bVar.Ut);
            Z.sh(bVar.fid);
            Z.bW("vc", bVar.Uu);
            Z.sb(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bmB().a(Z);
            bVar.Uv = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bwK() != null && (bVar = lVar.bwK().advertAppContext) != null && !bVar.Uv) {
            lVar.Vc = bVar.Us;
            lVar.Vd = bVar.Ut;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.bwL() != null && lVar.bwL().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, i);
            c.sb(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bmB().a(c);
            bVar.Uv = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Uv) {
            com.baidu.tieba.recapp.report.a Z = com.baidu.tieba.recapp.report.e.Z(z ? 13 : 3, i, bVar.pn);
            Z.si(bVar.Uq);
            Z.sb(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bmB().a(Z);
            bVar.Uv = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.ack() != null && dVar.ack().advertAppContext != null && !dVar.ack().advertAppContext.Uv) {
            dVar.ack().Uq = dVar.ack().advertAppContext.Uq;
            com.baidu.tbadk.distribute.a.CO().a(dVar.ack(), "", 0L, dVar.ack().Uq, "show", dVar.ack().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.ack(), 3, dVar.ack().advertAppContext.pn);
            d.sb(dVar.ack().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bmB().a(d);
            dVar.ack().advertAppContext.Uv = true;
        }
    }
}
