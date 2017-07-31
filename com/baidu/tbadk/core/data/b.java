package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String Um;
    public String Un;
    public String Uo;
    public String Up;
    public String Uq;
    public boolean Ur;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Ur) {
            com.baidu.tieba.recapp.report.a Q = com.baidu.tieba.recapp.report.d.Q(z ? 13 : 3, i, bVar.pn);
            Q.rp(bVar.Um);
            Q.bY("isCache", String.valueOf(bVar.Un));
            Q.rm(bVar.Uo);
            Q.rn(bVar.Up);
            Q.ro(bVar.fid);
            Q.bY("vc", bVar.Uq);
            Q.ri(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bin().a(Q);
            bVar.Ur = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.Ur) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(advertAppInfo, 3, bVar.pn);
            c.rp(bVar.Um);
            c.bY("isCache", bVar.Un);
            c.rm(bVar.Uo);
            c.rn(bVar.Up);
            c.ro(bVar.fid);
            c.bY("vc", bVar.Uq);
            c.ri(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bin().a(c);
            bVar.Ur = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Ur) {
            com.baidu.tieba.recapp.report.a Q = com.baidu.tieba.recapp.report.d.Q(z ? 13 : 3, i, bVar.pn);
            Q.rp(bVar.Um);
            Q.rm(bVar.Uo);
            Q.rn(bVar.Up);
            Q.ro(bVar.fid);
            Q.bY("vc", bVar.Uq);
            Q.ri(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bin().a(Q);
            bVar.Ur = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bsn() != null && (bVar = lVar.bsn().advertAppContext) != null && !bVar.Ur) {
            lVar.UV = bVar.Uo;
            lVar.UW = bVar.Up;
            lVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(lVar, 3);
            c.ri(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bin().a(c);
            bVar.Ur = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Ur) {
            com.baidu.tieba.recapp.report.a Q = com.baidu.tieba.recapp.report.d.Q(z ? 13 : 3, i, bVar.pn);
            Q.rp(bVar.Um);
            Q.ri(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bin().a(Q);
            bVar.Ur = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.WL() != null && dVar.WL().advertAppContext != null && !dVar.WL().advertAppContext.Ur) {
            dVar.WL().Um = dVar.WL().advertAppContext.Um;
            com.baidu.tbadk.distribute.a.CK().a(dVar.WL(), "", 0L, dVar.WL().Um, "show", dVar.WL().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(dVar.WL(), 3, dVar.WL().advertAppContext.pn);
            c.ri(dVar.WL().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bin().a(c);
            dVar.WL().advertAppContext.Ur = true;
        }
    }
}
