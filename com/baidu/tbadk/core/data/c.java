package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    protected static final Set<String> bWS = new HashSet();
    public boolean AJ;
    public String bWO;
    public String bWP;
    public String bWQ;
    public String bWR;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.AJ && !mM(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b X = com.baidu.tieba.recapp.report.f.X(z ? 13 : 3, i, cVar.pn);
            X.CX(cVar.page);
            X.dN("isCache", String.valueOf(cVar.bWO));
            X.CU(cVar.bWP);
            X.CV(cVar.bWQ);
            X.CW(cVar.fid);
            X.dN("vc", cVar.bWR);
            X.CP(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cgI().a(X);
            cVar.AJ = true;
            bWS.add(cVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.AJ && !mM(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, cVar.pn);
            c.CX(cVar.page);
            c.dN("isCache", cVar.bWO);
            c.CU(cVar.bWP);
            c.CV(cVar.bWQ);
            c.CW(cVar.fid);
            c.dN("vc", cVar.bWR);
            c.CP(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cgI().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.AJ = true;
            bWS.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.ke() != null && !dVar.AJ && !TextUtils.isEmpty(dVar.ke().ext) && !mM(dVar.ke().ext)) {
            com.baidu.tieba.recapp.report.c.cgI().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.AJ = true;
            bWS.add(dVar.ke().ext);
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.AJ && !mM(cVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar = new com.baidu.tieba.recapp.report.b();
            bVar.yp(i2);
            if ("PB_BANNER".equals(cVar.page)) {
                bVar.yq(-1);
                bVar.setPageNumber(-1);
            } else {
                bVar.yq(i2);
                bVar.setPageNumber(cVar.pn);
            }
            bVar.CX(cVar.page);
            bVar.CU(cVar.bWP);
            bVar.CV(cVar.bWQ);
            bVar.CW(cVar.fid);
            bVar.dN("vc", cVar.bWR);
            bVar.CP(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cgI().a(bVar);
            cVar.AJ = true;
            bWS.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.cod() != null && (cVar = mVar.cod().advertAppContext) != null && !cVar.AJ && !mM(cVar.extensionInfo)) {
            mVar.bXx = cVar.bWP;
            mVar.bXy = cVar.bWQ;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.coe() != null && mVar.coe().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, i);
            c.CP(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cgI().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.kd()));
            cVar.AJ = true;
            bWS.add(cVar.extensionInfo);
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.AJ && !mM(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b X = com.baidu.tieba.recapp.report.f.X(z ? 13 : 3, i, cVar.pn);
            X.CX(cVar.page);
            X.CP(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cgI().a(X);
            cVar.AJ = true;
            bWS.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.baN() != null && dVar.baN().advertAppContext != null && !dVar.baN().advertAppContext.AJ && !mM(dVar.baN().advertAppContext.extensionInfo)) {
            dVar.baN().page = dVar.baN().advertAppContext.page;
            com.baidu.tbadk.distribute.a.atN().a(dVar.baN(), "", 0L, dVar.baN().page, "show", dVar.baN().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.baN(), 3, dVar.baN().advertAppContext.pn);
            d.CP(dVar.baN().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.cgI().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.baN()));
            dVar.baN().advertAppContext.AJ = true;
            bWS.add(dVar.baN().advertAppContext.extensionInfo);
        }
    }

    private static boolean mM(String str) {
        return bWS.contains(str);
    }
}
