package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String SR;
    public String SS;
    public String ST;
    public String SU;
    public String SV;
    public boolean SW;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i) {
        if (bVar != null && !bVar.SW) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pz(bVar.SR);
            O.bT("isCache", String.valueOf(bVar.SS));
            O.pw(bVar.ST);
            O.px(bVar.SU);
            O.py(bVar.fid);
            O.bT("vc", bVar.SV);
            O.ps(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.aYZ().a(O);
            bVar.SW = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.SW) {
            com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(advertAppInfo, 3, bVar.pn);
            b.pz(bVar.SR);
            b.bT("isCache", bVar.SS);
            b.pw(bVar.ST);
            b.px(bVar.SU);
            b.py(bVar.fid);
            b.bT("vc", bVar.SV);
            b.ps(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.aYZ().a(b);
            bVar.SW = true;
        }
    }

    public static void b(b bVar, int i) {
        if (bVar != null && !bVar.SW) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pz(bVar.SR);
            O.pw(bVar.ST);
            O.px(bVar.SU);
            O.py(bVar.fid);
            O.bT("vc", bVar.SV);
            O.ps(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.aYZ().a(O);
            bVar.SW = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.o oVar) {
        b bVar;
        if (oVar != null && oVar.bgA() != null && (bVar = oVar.bgA().advertAppContext) != null && !bVar.SW) {
            oVar.Ty = bVar.ST;
            oVar.Tz = bVar.SU;
            oVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(oVar, 3);
            b.ps(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.aYZ().a(b);
            bVar.SW = true;
        }
    }

    public static void c(b bVar, int i) {
        if (bVar != null && !bVar.SW) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pz(bVar.SR);
            O.ps(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.aYZ().a(O);
            bVar.SW = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.TD() != null && dVar.TD().advertAppContext != null && !dVar.TD().advertAppContext.SW) {
            dVar.TD().SR = dVar.TD().advertAppContext.SR;
            com.baidu.tbadk.distribute.a.Cc().a(dVar.TD(), "", 0L, dVar.TD().SR, "show", dVar.TD().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(dVar.TD(), 3, dVar.TD().advertAppContext.pn);
            b.ps(dVar.TD().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.aYZ().a(b);
            dVar.TD().advertAppContext.SW = true;
        }
    }
}
