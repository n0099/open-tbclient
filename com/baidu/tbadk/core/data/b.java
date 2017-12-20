package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String Un;
    public String Uo;
    public String Up;
    public String Uq;
    public String Ur;
    public boolean Us;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Us) {
            com.baidu.tieba.recapp.report.a Z = com.baidu.tieba.recapp.report.e.Z(z ? 13 : 3, i, bVar.pn);
            Z.si(bVar.Un);
            Z.bW("isCache", String.valueOf(bVar.Uo));
            Z.sf(bVar.Up);
            Z.sg(bVar.Uq);
            Z.sh(bVar.fid);
            Z.bW("vc", bVar.Ur);
            Z.sb(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bmA().a(Z);
            bVar.Us = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.Us) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.si(bVar.Un);
            c.bW("isCache", bVar.Uo);
            c.sf(bVar.Up);
            c.sg(bVar.Uq);
            c.sh(bVar.fid);
            c.bW("vc", bVar.Ur);
            c.sb(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bmA().a(c);
            bVar.Us = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Us) {
            com.baidu.tieba.recapp.report.a Z = com.baidu.tieba.recapp.report.e.Z(z ? 13 : 3, i, bVar.pn);
            Z.si(bVar.Un);
            Z.sf(bVar.Up);
            Z.sg(bVar.Uq);
            Z.sh(bVar.fid);
            Z.bW("vc", bVar.Ur);
            Z.sb(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bmA().a(Z);
            bVar.Us = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bwJ() != null && (bVar = lVar.bwJ().advertAppContext) != null && !bVar.Us) {
            lVar.UZ = bVar.Up;
            lVar.Va = bVar.Uq;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.bwK() != null && lVar.bwK().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, i);
            c.sb(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bmA().a(c);
            bVar.Us = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Us) {
            com.baidu.tieba.recapp.report.a Z = com.baidu.tieba.recapp.report.e.Z(z ? 13 : 3, i, bVar.pn);
            Z.si(bVar.Un);
            Z.sb(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bmA().a(Z);
            bVar.Us = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.ack() != null && dVar.ack().advertAppContext != null && !dVar.ack().advertAppContext.Us) {
            dVar.ack().Un = dVar.ack().advertAppContext.Un;
            com.baidu.tbadk.distribute.a.CO().a(dVar.ack(), "", 0L, dVar.ack().Un, "show", dVar.ack().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.ack(), 3, dVar.ack().advertAppContext.pn);
            d.sb(dVar.ack().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bmA().a(d);
            dVar.ack().advertAppContext.Us = true;
        }
    }
}
