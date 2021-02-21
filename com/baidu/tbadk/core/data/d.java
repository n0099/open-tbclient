package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class d {
    protected static final Set<String> eKZ = new HashSet();
    public boolean aas;
    public String eKV;
    public String eKW;
    public String eKX;
    public String eKY;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(d dVar, int i, boolean z) {
        if (dVar != null && !dVar.aas && !zR(dVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ab = com.baidu.tieba.recapp.report.h.ab(z ? 13 : 3, i, dVar.pn);
            ab.Sc(dVar.page);
            ab.gm("isCache", String.valueOf(dVar.eKV));
            ab.RZ(dVar.eKW);
            ab.Sa(dVar.eKX);
            ab.Sb(dVar.fid);
            ab.gm("vc", dVar.eKY);
            ab.setExtInfo(dVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dEu().a(ab);
            dVar.aas = true;
            eKZ.add(dVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        d dVar;
        if (advertAppInfo != null && (dVar = advertAppInfo.advertAppContext) != null && !dVar.aas && !zR(dVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(advertAppInfo, 3, dVar.pn);
            b2.Sc(dVar.page);
            b2.gm("isCache", dVar.eKV);
            b2.RZ(dVar.eKW);
            b2.Sa(dVar.eKX);
            b2.Sb(dVar.fid);
            b2.gm("vc", dVar.eKY);
            b2.setExtInfo(dVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dEu().a(b2);
            com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(advertAppInfo));
            dVar.aas = true;
            eKZ.add(dVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.qT() != null && !dVar.aas && !TextUtils.isEmpty(dVar.qT().ext) && !zR(dVar.qT().ext)) {
            com.baidu.tieba.recapp.report.e.dEu().a(com.baidu.tieba.recapp.report.h.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.a.c.b(dVar);
            dVar.aas = true;
            eKZ.add(dVar.qT().ext);
        }
    }

    public static void b(d dVar, int i, boolean z) {
        if (dVar != null && !dVar.aas && !zR(dVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.c cVar = new com.baidu.tieba.recapp.report.c();
            cVar.HW(i2);
            if ("PB_BANNER".equals(dVar.page)) {
                cVar.HX(-1);
                cVar.setPageNumber(-1);
            } else {
                cVar.HX(i);
                cVar.setPageNumber(dVar.pn);
            }
            cVar.Sc(dVar.page);
            cVar.RZ(dVar.eKW);
            cVar.Sa(dVar.eKX);
            cVar.Sb(dVar.fid);
            cVar.gm("vc", dVar.eKY);
            cVar.setExtInfo(dVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dEu().a(cVar);
            dVar.aas = true;
            eKZ.add(dVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (oVar != null && oVar.dNt() != null) {
            d dVar = oVar.dNt().advertAppContext;
            if (oVar.eLL || (dVar != null && !dVar.aas && !zR(dVar.extensionInfo))) {
                oVar.eLF = dVar.eKW;
                oVar.eLG = dVar.eKX;
                oVar.forumId = dVar.fid;
                int i = 3;
                if (oVar != null && oVar.dNu() != null && oVar.dNu().forFree()) {
                    i = 103;
                }
                com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(oVar, i);
                b2.setExtInfo(dVar.extensionInfo);
                com.baidu.tieba.recapp.report.e.dEu().a(b2);
                if (!oVar.eLL) {
                    com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(oVar.qS()));
                }
                dVar.aas = true;
                eKZ.add(dVar.extensionInfo);
            }
        }
    }

    public static void c(d dVar, int i, boolean z) {
        if (dVar != null && !dVar.aas && !zR(dVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ab = com.baidu.tieba.recapp.report.h.ab(z ? 13 : 3, i, dVar.pn);
            ab.Sc(dVar.page);
            ab.setExtInfo(dVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dEu().a(ab);
            dVar.aas = true;
            eKZ.add(dVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.csZ() != null && dVar.csZ().advertAppContext != null && !dVar.csZ().advertAppContext.aas && !zR(dVar.csZ().advertAppContext.extensionInfo)) {
            dVar.csZ().page = dVar.csZ().advertAppContext.page;
            com.baidu.tbadk.distribute.a.bAU().a(dVar.csZ(), "", 0L, dVar.csZ().page, "show", dVar.csZ().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.h.c(dVar.csZ(), 3, dVar.csZ().advertAppContext.pn);
            c.setExtInfo(dVar.csZ().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.e.dEu().a(c);
            com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(dVar.csZ()));
            dVar.csZ().advertAppContext.aas = true;
            eKZ.add(dVar.csZ().advertAppContext.extensionInfo);
        }
    }

    private static boolean zR(String str) {
        return eKZ.contains(str);
    }
}
