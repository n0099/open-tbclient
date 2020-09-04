package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    protected static final Set<String> dVR = new HashSet();
    public boolean Ye;
    public String dVN;
    public String dVO;
    public String dVP;
    public String dVQ;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Ye && !yY(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c X = com.baidu.tieba.recapp.report.g.X(z ? 13 : 3, i, bVar.pn);
            X.PJ(bVar.page);
            X.fG("isCache", String.valueOf(bVar.dVN));
            X.PG(bVar.dVO);
            X.PH(bVar.dVP);
            X.PI(bVar.fid);
            X.fG("vc", bVar.dVQ);
            X.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dol().a(X);
            bVar.Ye = true;
            dVR.add(bVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.Ye && !yY(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 3, bVar.pn);
            c.PJ(bVar.page);
            c.fG("isCache", bVar.dVN);
            c.PG(bVar.dVO);
            c.PH(bVar.dVP);
            c.PI(bVar.fid);
            c.fG("vc", bVar.dVQ);
            c.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dol().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(advertAppInfo));
            bVar.Ye = true;
            dVR.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.rm() != null && !dVar.Ye && !TextUtils.isEmpty(dVar.rm().ext) && !yY(dVar.rm().ext)) {
            com.baidu.tieba.recapp.report.d.dol().a(com.baidu.tieba.recapp.report.g.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Ye = true;
            dVR.add(dVar.rm().ext);
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Ye && !yY(bVar.extensionInfo)) {
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
            cVar.PG(bVar.dVO);
            cVar.PH(bVar.dVP);
            cVar.PI(bVar.fid);
            cVar.fG("vc", bVar.dVQ);
            cVar.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dol().a(cVar);
            bVar.Ye = true;
            dVR.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.n nVar) {
        b bVar;
        if (nVar != null && nVar.dwy() != null && (bVar = nVar.dwy().advertAppContext) != null && !bVar.Ye && !yY(bVar.extensionInfo)) {
            nVar.dWv = bVar.dVO;
            nVar.dWw = bVar.dVP;
            nVar.forumId = bVar.fid;
            int i = 3;
            if (nVar != null && nVar.dwz() != null && nVar.dwz().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, i);
            c.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dol().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(nVar.rl()));
            bVar.Ye = true;
            dVR.add(bVar.extensionInfo);
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Ye && !yY(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c X = com.baidu.tieba.recapp.report.g.X(z ? 13 : 3, i, bVar.pn);
            X.PJ(bVar.page);
            X.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dol().a(X);
            bVar.Ye = true;
            dVR.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.e eVar) {
        if (eVar != null && eVar.ccs() != null && eVar.ccs().advertAppContext != null && !eVar.ccs().advertAppContext.Ye && !yY(eVar.ccs().advertAppContext.extensionInfo)) {
            eVar.ccs().page = eVar.ccs().advertAppContext.page;
            com.baidu.tbadk.distribute.a.brj().a(eVar.ccs(), "", 0L, eVar.ccs().page, "show", eVar.ccs().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c d = com.baidu.tieba.recapp.report.g.d(eVar.ccs(), 3, eVar.ccs().advertAppContext.pn);
            d.setExtInfo(eVar.ccs().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.d.dol().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(eVar.ccs()));
            eVar.ccs().advertAppContext.Ye = true;
            dVR.add(eVar.ccs().advertAppContext.extensionInfo);
        }
    }

    private static boolean yY(String str) {
        return dVR.contains(str);
    }
}
