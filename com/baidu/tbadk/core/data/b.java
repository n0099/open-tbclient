package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    protected static final Set<String> dGt = new HashSet();
    public boolean XE;
    public String dGp;
    public String dGq;
    public String dGr;
    public String dGs;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.XE && !vC(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ab = com.baidu.tieba.recapp.report.g.ab(z ? 13 : 3, i, bVar.pn);
            ab.Me(bVar.page);
            ab.fm("isCache", String.valueOf(bVar.dGp));
            ab.Mb(bVar.dGq);
            ab.Mc(bVar.dGr);
            ab.Md(bVar.fid);
            ab.fm("vc", bVar.dGs);
            ab.LW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cZQ().a(ab);
            bVar.XE = true;
            dGt.add(bVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.XE && !vC(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 3, bVar.pn);
            c.Me(bVar.page);
            c.fm("isCache", bVar.dGp);
            c.Mb(bVar.dGq);
            c.Mc(bVar.dGr);
            c.Md(bVar.fid);
            c.fm("vc", bVar.dGs);
            c.LW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cZQ().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            bVar.XE = true;
            dGt.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pM() != null && !dVar.XE && !TextUtils.isEmpty(dVar.pM().ext) && !vC(dVar.pM().ext)) {
            com.baidu.tieba.recapp.report.d.cZQ().a(com.baidu.tieba.recapp.report.g.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.XE = true;
            dGt.add(dVar.pM().ext);
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.XE && !vC(bVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.c cVar = new com.baidu.tieba.recapp.report.c();
            cVar.Du(i2);
            if ("PB_BANNER".equals(bVar.page)) {
                cVar.Dv(-1);
                cVar.setPageNumber(-1);
            } else {
                cVar.Dv(i2);
                cVar.setPageNumber(bVar.pn);
            }
            cVar.Me(bVar.page);
            cVar.Mb(bVar.dGq);
            cVar.Mc(bVar.dGr);
            cVar.Md(bVar.fid);
            cVar.fm("vc", bVar.dGs);
            cVar.LW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cZQ().a(cVar);
            bVar.XE = true;
            dGt.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.n nVar) {
        b bVar;
        if (nVar != null && nVar.dhM() != null && (bVar = nVar.dhM().advertAppContext) != null && !bVar.XE && !vC(bVar.extensionInfo)) {
            nVar.dGX = bVar.dGq;
            nVar.dGY = bVar.dGr;
            nVar.forumId = bVar.fid;
            int i = 3;
            if (nVar != null && nVar.dhN() != null && nVar.dhN().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, i);
            c.LW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cZQ().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(nVar.pL()));
            bVar.XE = true;
            dGt.add(bVar.extensionInfo);
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.XE && !vC(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ab = com.baidu.tieba.recapp.report.g.ab(z ? 13 : 3, i, bVar.pn);
            ab.Me(bVar.page);
            ab.LW(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cZQ().a(ab);
            bVar.XE = true;
            dGt.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.bOT() != null && dVar.bOT().advertAppContext != null && !dVar.bOT().advertAppContext.XE && !vC(dVar.bOT().advertAppContext.extensionInfo)) {
            dVar.bOT().page = dVar.bOT().advertAppContext.page;
            com.baidu.tbadk.distribute.a.beN().a(dVar.bOT(), "", 0L, dVar.bOT().page, "show", dVar.bOT().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c d = com.baidu.tieba.recapp.report.g.d(dVar.bOT(), 3, dVar.bOT().advertAppContext.pn);
            d.LW(dVar.bOT().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.d.cZQ().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.bOT()));
            dVar.bOT().advertAppContext.XE = true;
            dGt.add(dVar.bOT().advertAppContext.extensionInfo);
        }
    }

    private static boolean vC(String str) {
        return dGt.contains(str);
    }
}
