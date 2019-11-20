package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    protected static final Set<String> bWb = new HashSet();
    public boolean Aj;
    public String bVX;
    public String bVY;
    public String bVZ;
    public String bWa;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Aj && !mM(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b X = com.baidu.tieba.recapp.report.f.X(z ? 13 : 3, i, cVar.pn);
            X.CX(cVar.page);
            X.dN("isCache", String.valueOf(cVar.bVX));
            X.CU(cVar.bVY);
            X.CV(cVar.bVZ);
            X.CW(cVar.fid);
            X.dN("vc", cVar.bWa);
            X.CP(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cgG().a(X);
            cVar.Aj = true;
            bWb.add(cVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.Aj && !mM(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, cVar.pn);
            c.CX(cVar.page);
            c.dN("isCache", cVar.bVX);
            c.CU(cVar.bVY);
            c.CV(cVar.bVZ);
            c.CW(cVar.fid);
            c.dN("vc", cVar.bWa);
            c.CP(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cgG().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.Aj = true;
            bWb.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.ke() != null && !dVar.Aj && !TextUtils.isEmpty(dVar.ke().ext) && !mM(dVar.ke().ext)) {
            com.baidu.tieba.recapp.report.c.cgG().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Aj = true;
            bWb.add(dVar.ke().ext);
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Aj && !mM(cVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar = new com.baidu.tieba.recapp.report.b();
            bVar.yo(i2);
            if ("PB_BANNER".equals(cVar.page)) {
                bVar.yp(-1);
                bVar.setPageNumber(-1);
            } else {
                bVar.yp(i2);
                bVar.setPageNumber(cVar.pn);
            }
            bVar.CX(cVar.page);
            bVar.CU(cVar.bVY);
            bVar.CV(cVar.bVZ);
            bVar.CW(cVar.fid);
            bVar.dN("vc", cVar.bWa);
            bVar.CP(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cgG().a(bVar);
            cVar.Aj = true;
            bWb.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.cob() != null && (cVar = mVar.cob().advertAppContext) != null && !cVar.Aj && !mM(cVar.extensionInfo)) {
            mVar.bWG = cVar.bVY;
            mVar.bWH = cVar.bVZ;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.coc() != null && mVar.coc().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, i);
            c.CP(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cgG().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.kd()));
            cVar.Aj = true;
            bWb.add(cVar.extensionInfo);
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Aj && !mM(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b X = com.baidu.tieba.recapp.report.f.X(z ? 13 : 3, i, cVar.pn);
            X.CX(cVar.page);
            X.CP(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cgG().a(X);
            cVar.Aj = true;
            bWb.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.baL() != null && dVar.baL().advertAppContext != null && !dVar.baL().advertAppContext.Aj && !mM(dVar.baL().advertAppContext.extensionInfo)) {
            dVar.baL().page = dVar.baL().advertAppContext.page;
            com.baidu.tbadk.distribute.a.atL().a(dVar.baL(), "", 0L, dVar.baL().page, "show", dVar.baL().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.baL(), 3, dVar.baL().advertAppContext.pn);
            d.CP(dVar.baL().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.cgG().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.baL()));
            dVar.baL().advertAppContext.Aj = true;
            bWb.add(dVar.baL().advertAppContext.extensionInfo);
        }
    }

    private static boolean mM(String str) {
        return bWb.contains(str);
    }
}
