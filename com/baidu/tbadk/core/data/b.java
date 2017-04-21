package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String TA;
    public String TB;
    public String TC;
    public boolean TD;
    public String Ty;
    public String Tz;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i) {
        if (bVar != null && !bVar.TD) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pB(bVar.Ty);
            O.bT("isCache", String.valueOf(bVar.Tz));
            O.py(bVar.TA);
            O.pz(bVar.TB);
            O.pA(bVar.fid);
            O.bT("vc", bVar.TC);
            O.pu(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bbA().a(O);
            bVar.TD = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.TD) {
            com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(advertAppInfo, 3, bVar.pn);
            b.pB(bVar.Ty);
            b.bT("isCache", bVar.Tz);
            b.py(bVar.TA);
            b.pz(bVar.TB);
            b.pA(bVar.fid);
            b.bT("vc", bVar.TC);
            b.pu(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bbA().a(b);
            bVar.TD = true;
        }
    }

    public static void b(b bVar, int i) {
        if (bVar != null && !bVar.TD) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pB(bVar.Ty);
            O.py(bVar.TA);
            O.pz(bVar.TB);
            O.pA(bVar.fid);
            O.bT("vc", bVar.TC);
            O.pu(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bbA().a(O);
            bVar.TD = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.o oVar) {
        b bVar;
        if (oVar != null && oVar.bjd() != null && (bVar = oVar.bjd().advertAppContext) != null && !bVar.TD) {
            oVar.Ug = bVar.TA;
            oVar.Uh = bVar.TB;
            oVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(oVar, 3);
            b.pu(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bbA().a(b);
            bVar.TD = true;
        }
    }

    public static void c(b bVar, int i) {
        if (bVar != null && !bVar.TD) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pB(bVar.Ty);
            O.pu(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bbA().a(O);
            bVar.TD = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.Uk() != null && dVar.Uk().advertAppContext != null && !dVar.Uk().advertAppContext.TD) {
            dVar.Uk().Ty = dVar.Uk().advertAppContext.Ty;
            com.baidu.tbadk.distribute.a.CX().a(dVar.Uk(), "", 0L, dVar.Uk().Ty, "show", dVar.Uk().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(dVar.Uk(), 3, dVar.Uk().advertAppContext.pn);
            b.pu(dVar.Uk().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bbA().a(b);
            dVar.Uk().advertAppContext.TD = true;
        }
    }
}
