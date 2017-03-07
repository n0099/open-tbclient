package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String Te;
    public String Tf;
    public String Tg;
    public String Th;
    public String Ti;
    public boolean Tj;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i) {
        if (bVar != null && !bVar.Tj) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pk(bVar.Te);
            O.bU("isCache", String.valueOf(bVar.Tf));
            O.ph(bVar.Tg);
            O.pi(bVar.Th);
            O.pj(bVar.fid);
            O.bU("vc", bVar.Ti);
            O.pe(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.aZQ().a(O);
            bVar.Tj = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.Tj) {
            com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(advertAppInfo, 3, bVar.pn);
            b.pk(bVar.Te);
            b.bU("isCache", bVar.Tf);
            b.ph(bVar.Tg);
            b.pi(bVar.Th);
            b.pj(bVar.fid);
            b.bU("vc", bVar.Ti);
            b.pe(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.aZQ().a(b);
            bVar.Tj = true;
        }
    }

    public static void b(b bVar, int i) {
        if (bVar != null && !bVar.Tj) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pk(bVar.Te);
            O.ph(bVar.Tg);
            O.pi(bVar.Th);
            O.pj(bVar.fid);
            O.bU("vc", bVar.Ti);
            O.pe(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.aZQ().a(O);
            bVar.Tj = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.o oVar) {
        b bVar;
        if (oVar != null && oVar.bhr() != null && (bVar = oVar.bhr().advertAppContext) != null && !bVar.Tj) {
            oVar.TL = bVar.Tg;
            oVar.TM = bVar.Th;
            oVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(oVar, 3);
            b.pe(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.aZQ().a(b);
            bVar.Tj = true;
        }
    }

    public static void c(b bVar, int i) {
        if (bVar != null && !bVar.Tj) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pk(bVar.Te);
            O.pe(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.aZQ().a(O);
            bVar.Tj = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.SK() != null && dVar.SK().advertAppContext != null && !dVar.SK().advertAppContext.Tj) {
            dVar.SK().Te = dVar.SK().advertAppContext.Te;
            com.baidu.tbadk.distribute.a.Cz().a(dVar.SK(), "", 0L, dVar.SK().Te, "show", dVar.SK().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(dVar.SK(), 3, dVar.SK().advertAppContext.pn);
            b.pe(dVar.SK().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.aZQ().a(b);
            dVar.SK().advertAppContext.Tj = true;
        }
    }
}
