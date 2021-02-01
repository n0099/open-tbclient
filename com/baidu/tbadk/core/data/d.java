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
            ab.RQ(dVar.page);
            ab.gk("isCache", String.valueOf(dVar.eKV));
            ab.RN(dVar.eKW);
            ab.RO(dVar.eKX);
            ab.RP(dVar.fid);
            ab.gk("vc", dVar.eKY);
            ab.setExtInfo(dVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dEm().a(ab);
            dVar.aas = true;
            eKZ.add(dVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        d dVar;
        if (advertAppInfo != null && (dVar = advertAppInfo.advertAppContext) != null && !dVar.aas && !zR(dVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(advertAppInfo, 3, dVar.pn);
            b2.RQ(dVar.page);
            b2.gk("isCache", dVar.eKV);
            b2.RN(dVar.eKW);
            b2.RO(dVar.eKX);
            b2.RP(dVar.fid);
            b2.gk("vc", dVar.eKY);
            b2.setExtInfo(dVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dEm().a(b2);
            com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(advertAppInfo));
            dVar.aas = true;
            eKZ.add(dVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.qT() != null && !dVar.aas && !TextUtils.isEmpty(dVar.qT().ext) && !zR(dVar.qT().ext)) {
            com.baidu.tieba.recapp.report.e.dEm().a(com.baidu.tieba.recapp.report.h.a(dVar, 3, dVar.getPageNum()));
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
            cVar.RQ(dVar.page);
            cVar.RN(dVar.eKW);
            cVar.RO(dVar.eKX);
            cVar.RP(dVar.fid);
            cVar.gk("vc", dVar.eKY);
            cVar.setExtInfo(dVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dEm().a(cVar);
            dVar.aas = true;
            eKZ.add(dVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.o oVar) {
        d dVar;
        if (oVar != null && oVar.dNl() != null && (dVar = oVar.dNl().advertAppContext) != null && !dVar.aas && !zR(dVar.extensionInfo)) {
            oVar.eLG = dVar.eKW;
            oVar.eLH = dVar.eKX;
            oVar.forumId = dVar.fid;
            int i = 3;
            if (oVar != null && oVar.dNm() != null && oVar.dNm().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(oVar, i);
            b2.setExtInfo(dVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dEm().a(b2);
            com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(oVar.qS()));
            dVar.aas = true;
            eKZ.add(dVar.extensionInfo);
        }
    }

    public static void c(d dVar, int i, boolean z) {
        if (dVar != null && !dVar.aas && !zR(dVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ab = com.baidu.tieba.recapp.report.h.ab(z ? 13 : 3, i, dVar.pn);
            ab.RQ(dVar.page);
            ab.setExtInfo(dVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dEm().a(ab);
            dVar.aas = true;
            eKZ.add(dVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.csS() != null && dVar.csS().advertAppContext != null && !dVar.csS().advertAppContext.aas && !zR(dVar.csS().advertAppContext.extensionInfo)) {
            dVar.csS().page = dVar.csS().advertAppContext.page;
            com.baidu.tbadk.distribute.a.bAU().a(dVar.csS(), "", 0L, dVar.csS().page, "show", dVar.csS().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.h.c(dVar.csS(), 3, dVar.csS().advertAppContext.pn);
            c.setExtInfo(dVar.csS().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.e.dEm().a(c);
            com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(dVar.csS()));
            dVar.csS().advertAppContext.aas = true;
            eKZ.add(dVar.csS().advertAppContext.extensionInfo);
        }
    }

    private static boolean zR(String str) {
        return eKZ.contains(str);
    }
}
