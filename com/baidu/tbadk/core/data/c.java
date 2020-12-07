package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    protected static final Set<String> eDL = new HashSet();
    public boolean ZP;
    public String eDH;
    public String eDI;
    public String eDJ;
    public String eDK;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.ZP && !AO(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ab = com.baidu.tieba.recapp.report.g.ab(z ? 13 : 3, i, cVar.pn);
            ab.Sw(cVar.page);
            ab.gj("isCache", String.valueOf(cVar.eDH));
            ab.St(cVar.eDI);
            ab.Su(cVar.eDJ);
            ab.Sv(cVar.fid);
            ab.gj("vc", cVar.eDK);
            ab.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dGf().a(ab);
            cVar.ZP = true;
            eDL.add(cVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.ZP && !AO(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 3, cVar.pn);
            c.Sw(cVar.page);
            c.gj("isCache", cVar.eDH);
            c.St(cVar.eDI);
            c.Su(cVar.eDJ);
            c.Sv(cVar.fid);
            c.gj("vc", cVar.eDK);
            c.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dGf().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.c(advertAppInfo));
            cVar.ZP = true;
            eDL.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.rt() != null && !dVar.ZP && !TextUtils.isEmpty(dVar.rt().ext) && !AO(dVar.rt().ext)) {
            com.baidu.tieba.recapp.report.d.dGf().a(com.baidu.tieba.recapp.report.g.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.ZP = true;
            eDL.add(dVar.rt().ext);
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.ZP && !AO(cVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.c cVar2 = new com.baidu.tieba.recapp.report.c();
            cVar2.Jq(i2);
            if ("PB_BANNER".equals(cVar.page)) {
                cVar2.Jr(-1);
                cVar2.setPageNumber(-1);
            } else {
                cVar2.Jr(i2);
                cVar2.setPageNumber(cVar.pn);
            }
            cVar2.Sw(cVar.page);
            cVar2.St(cVar.eDI);
            cVar2.Su(cVar.eDJ);
            cVar2.Sv(cVar.fid);
            cVar2.gj("vc", cVar.eDK);
            cVar2.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dGf().a(cVar2);
            cVar.ZP = true;
            eDL.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.n nVar) {
        c cVar;
        if (nVar != null && nVar.dOU() != null && (cVar = nVar.dOU().advertAppContext) != null && !cVar.ZP && !AO(cVar.extensionInfo)) {
            nVar.eEp = cVar.eDI;
            nVar.eEq = cVar.eDJ;
            nVar.forumId = cVar.fid;
            int i = 3;
            if (nVar != null && nVar.dOV() != null && nVar.dOV().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, i);
            c.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dGf().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.c(nVar.rs()));
            cVar.ZP = true;
            eDL.add(cVar.extensionInfo);
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.ZP && !AO(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ab = com.baidu.tieba.recapp.report.g.ab(z ? 13 : 3, i, cVar.pn);
            ab.Sw(cVar.page);
            ab.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dGf().a(ab);
            cVar.ZP = true;
            eDL.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.csD() != null && dVar.csD().advertAppContext != null && !dVar.csD().advertAppContext.ZP && !AO(dVar.csD().advertAppContext.extensionInfo)) {
            dVar.csD().page = dVar.csD().advertAppContext.page;
            com.baidu.tbadk.distribute.a.bCa().a(dVar.csD(), "", 0L, dVar.csD().page, "show", dVar.csD().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c d = com.baidu.tieba.recapp.report.g.d(dVar.csD(), 3, dVar.csD().advertAppContext.pn);
            d.setExtInfo(dVar.csD().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.d.dGf().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.c(dVar.csD()));
            dVar.csD().advertAppContext.ZP = true;
            eDL.add(dVar.csD().advertAppContext.extensionInfo);
        }
    }

    private static boolean AO(String str) {
        return eDL.contains(str);
    }
}
