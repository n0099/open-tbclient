package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    protected static final Set<String> cIA = new HashSet();
    public boolean CU;
    public String cIw;
    public String cIx;
    public String cIy;
    public String cIz;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.CU && !sd(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b X = com.baidu.tieba.recapp.report.f.X(z ? 13 : 3, i, cVar.pn);
            X.HU(cVar.page);
            X.ei("isCache", String.valueOf(cVar.cIw));
            X.HR(cVar.cIx);
            X.HS(cVar.cIy);
            X.HT(cVar.fid);
            X.ei("vc", cVar.cIz);
            X.HM(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cBP().a(X);
            cVar.CU = true;
            cIA.add(cVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.CU && !sd(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, cVar.pn);
            c.HU(cVar.page);
            c.ei("isCache", cVar.cIw);
            c.HR(cVar.cIx);
            c.HS(cVar.cIy);
            c.HT(cVar.fid);
            c.ei("vc", cVar.cIz);
            c.HM(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cBP().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.CU = true;
            cIA.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.kw() != null && !dVar.CU && !TextUtils.isEmpty(dVar.kw().ext) && !sd(dVar.kw().ext)) {
            com.baidu.tieba.recapp.report.c.cBP().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.CU = true;
            cIA.add(dVar.kw().ext);
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.CU && !sd(cVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar = new com.baidu.tieba.recapp.report.b();
            bVar.AP(i2);
            if ("PB_BANNER".equals(cVar.page)) {
                bVar.AQ(-1);
                bVar.setPageNumber(-1);
            } else {
                bVar.AQ(i2);
                bVar.setPageNumber(cVar.pn);
            }
            bVar.HU(cVar.page);
            bVar.HR(cVar.cIx);
            bVar.HS(cVar.cIy);
            bVar.HT(cVar.fid);
            bVar.ei("vc", cVar.cIz);
            bVar.HM(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cBP().a(bVar);
            cVar.CU = true;
            cIA.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.cJl() != null && (cVar = mVar.cJl().advertAppContext) != null && !cVar.CU && !sd(cVar.extensionInfo)) {
            mVar.cJe = cVar.cIx;
            mVar.cJf = cVar.cIy;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.cJm() != null && mVar.cJm().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, i);
            c.HM(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cBP().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.kv()));
            cVar.CU = true;
            cIA.add(cVar.extensionInfo);
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.CU && !sd(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b X = com.baidu.tieba.recapp.report.f.X(z ? 13 : 3, i, cVar.pn);
            X.HU(cVar.page);
            X.HM(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cBP().a(X);
            cVar.CU = true;
            cIA.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.btR() != null && dVar.btR().advertAppContext != null && !dVar.btR().advertAppContext.CU && !sd(dVar.btR().advertAppContext.extensionInfo)) {
            dVar.btR().page = dVar.btR().advertAppContext.page;
            com.baidu.tbadk.distribute.a.aLJ().a(dVar.btR(), "", 0L, dVar.btR().page, "show", dVar.btR().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.btR(), 3, dVar.btR().advertAppContext.pn);
            d.HM(dVar.btR().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.cBP().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.btR()));
            dVar.btR().advertAppContext.CU = true;
            cIA.add(dVar.btR().advertAppContext.extensionInfo);
        }
    }

    private static boolean sd(String str) {
        return cIA.contains(str);
    }
}
