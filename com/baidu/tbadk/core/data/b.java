package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    protected static final Set<String> dVN = new HashSet();
    public boolean Yb;
    public String dVJ;
    public String dVK;
    public String dVL;
    public String dVM;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Yb && !yX(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c X = com.baidu.tieba.recapp.report.g.X(z ? 13 : 3, i, bVar.pn);
            X.PJ(bVar.page);
            X.fF("isCache", String.valueOf(bVar.dVJ));
            X.PG(bVar.dVK);
            X.PH(bVar.dVL);
            X.PI(bVar.fid);
            X.fF("vc", bVar.dVM);
            X.PB(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.doi().a(X);
            bVar.Yb = true;
            dVN.add(bVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.Yb && !yX(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 3, bVar.pn);
            c.PJ(bVar.page);
            c.fF("isCache", bVar.dVJ);
            c.PG(bVar.dVK);
            c.PH(bVar.dVL);
            c.PI(bVar.fid);
            c.fF("vc", bVar.dVM);
            c.PB(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.doi().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(advertAppInfo));
            bVar.Yb = true;
            dVN.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.rm() != null && !dVar.Yb && !TextUtils.isEmpty(dVar.rm().ext) && !yX(dVar.rm().ext)) {
            com.baidu.tieba.recapp.report.d.doi().a(com.baidu.tieba.recapp.report.g.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Yb = true;
            dVN.add(dVar.rm().ext);
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Yb && !yX(bVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.c cVar = new com.baidu.tieba.recapp.report.c();
            cVar.Gl(i2);
            if ("PB_BANNER".equals(bVar.page)) {
                cVar.Gm(-1);
                cVar.setPageNumber(-1);
            } else {
                cVar.Gm(i2);
                cVar.setPageNumber(bVar.pn);
            }
            cVar.PJ(bVar.page);
            cVar.PG(bVar.dVK);
            cVar.PH(bVar.dVL);
            cVar.PI(bVar.fid);
            cVar.fF("vc", bVar.dVM);
            cVar.PB(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.doi().a(cVar);
            bVar.Yb = true;
            dVN.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.n nVar) {
        b bVar;
        if (nVar != null && nVar.dwt() != null && (bVar = nVar.dwt().advertAppContext) != null && !bVar.Yb && !yX(bVar.extensionInfo)) {
            nVar.dWr = bVar.dVK;
            nVar.dWs = bVar.dVL;
            nVar.forumId = bVar.fid;
            int i = 3;
            if (nVar != null && nVar.dwu() != null && nVar.dwu().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, i);
            c.PB(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.doi().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(nVar.rl()));
            bVar.Yb = true;
            dVN.add(bVar.extensionInfo);
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Yb && !yX(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c X = com.baidu.tieba.recapp.report.g.X(z ? 13 : 3, i, bVar.pn);
            X.PJ(bVar.page);
            X.PB(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.doi().a(X);
            bVar.Yb = true;
            dVN.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.e eVar) {
        if (eVar != null && eVar.ccr() != null && eVar.ccr().advertAppContext != null && !eVar.ccr().advertAppContext.Yb && !yX(eVar.ccr().advertAppContext.extensionInfo)) {
            eVar.ccr().page = eVar.ccr().advertAppContext.page;
            com.baidu.tbadk.distribute.a.bri().a(eVar.ccr(), "", 0L, eVar.ccr().page, "show", eVar.ccr().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c d = com.baidu.tieba.recapp.report.g.d(eVar.ccr(), 3, eVar.ccr().advertAppContext.pn);
            d.PB(eVar.ccr().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.d.doi().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(eVar.ccr()));
            eVar.ccr().advertAppContext.Yb = true;
            dVN.add(eVar.ccr().advertAppContext.extensionInfo);
        }
    }

    private static boolean yX(String str) {
        return dVN.contains(str);
    }
}
