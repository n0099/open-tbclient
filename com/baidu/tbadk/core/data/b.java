package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String SE;
    public String SF;
    public String SG;
    public String SH;
    public String SI;
    public boolean SJ;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i) {
        if (bVar != null && !bVar.SJ) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pO(bVar.SE);
            O.bT("isCache", String.valueOf(bVar.SF));
            O.pL(bVar.SG);
            O.pM(bVar.SH);
            O.pN(bVar.fid);
            O.bT("vc", bVar.SI);
            O.pH(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bas().a(O);
            bVar.SJ = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.SJ) {
            com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(advertAppInfo, 3, bVar.pn);
            b.pO(bVar.SE);
            b.bT("isCache", bVar.SF);
            b.pL(bVar.SG);
            b.pM(bVar.SH);
            b.pN(bVar.fid);
            b.bT("vc", bVar.SI);
            b.pH(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bas().a(b);
            bVar.SJ = true;
        }
    }

    public static void b(b bVar, int i) {
        if (bVar != null && !bVar.SJ) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pO(bVar.SE);
            O.pL(bVar.SG);
            O.pM(bVar.SH);
            O.pN(bVar.fid);
            O.bT("vc", bVar.SI);
            O.pH(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bas().a(O);
            bVar.SJ = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.o oVar) {
        b bVar;
        if (oVar != null && oVar.bhV() != null && (bVar = oVar.bhV().advertAppContext) != null && !bVar.SJ) {
            oVar.Tl = bVar.SG;
            oVar.Tm = bVar.SH;
            oVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(oVar, 3);
            b.pH(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bas().a(b);
            bVar.SJ = true;
        }
    }

    public static void c(b bVar, int i) {
        if (bVar != null && !bVar.SJ) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pO(bVar.SE);
            O.pH(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bas().a(O);
            bVar.SJ = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.UH() != null && dVar.UH().advertAppContext != null && !dVar.UH().advertAppContext.SJ) {
            dVar.UH().SE = dVar.UH().advertAppContext.SE;
            com.baidu.tbadk.distribute.a.BW().a(dVar.UH(), "", 0L, dVar.UH().SE, "show", dVar.UH().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(dVar.UH(), 3, dVar.UH().advertAppContext.pn);
            b.pH(dVar.UH().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bas().a(b);
            dVar.UH().advertAppContext.SJ = true;
        }
    }
}
