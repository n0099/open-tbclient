package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    protected static final Set<String> cME = new HashSet();
    public boolean Dn;
    public String cMA;
    public String cMB;
    public String cMC;
    public String cMD;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b Y = com.baidu.tieba.recapp.report.f.Y(z ? 13 : 3, i, cVar.pn);
            Y.Ii(cVar.page);
            Y.er("isCache", String.valueOf(cVar.cMA));
            Y.If(cVar.cMB);
            Y.Ig(cVar.cMC);
            Y.Ih(cVar.fid);
            Y.er("vc", cVar.cMD);
            Y.Ia(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDp().a(Y);
            cVar.Dn = true;
            cME.add(cVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, cVar.pn);
            c.Ii(cVar.page);
            c.er("isCache", cVar.cMA);
            c.If(cVar.cMB);
            c.Ig(cVar.cMC);
            c.Ih(cVar.fid);
            c.er("vc", cVar.cMD);
            c.Ia(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDp().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.Dn = true;
            cME.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.kL() != null && !dVar.Dn && !TextUtils.isEmpty(dVar.kL().ext) && !su(dVar.kL().ext)) {
            com.baidu.tieba.recapp.report.c.cDp().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Dn = true;
            cME.add(dVar.kL().ext);
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar = new com.baidu.tieba.recapp.report.b();
            bVar.AY(i2);
            if ("PB_BANNER".equals(cVar.page)) {
                bVar.AZ(-1);
                bVar.setPageNumber(-1);
            } else {
                bVar.AZ(i2);
                bVar.setPageNumber(cVar.pn);
            }
            bVar.Ii(cVar.page);
            bVar.If(cVar.cMB);
            bVar.Ig(cVar.cMC);
            bVar.Ih(cVar.fid);
            bVar.er("vc", cVar.cMD);
            bVar.Ia(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDp().a(bVar);
            cVar.Dn = true;
            cME.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.cKO() != null && (cVar = mVar.cKO().advertAppContext) != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            mVar.cNi = cVar.cMB;
            mVar.cNj = cVar.cMC;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.cKP() != null && mVar.cKP().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, i);
            c.Ia(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDp().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.kK()));
            cVar.Dn = true;
            cME.add(cVar.extensionInfo);
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b Y = com.baidu.tieba.recapp.report.f.Y(z ? 13 : 3, i, cVar.pn);
            Y.Ii(cVar.page);
            Y.Ia(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDp().a(Y);
            cVar.Dn = true;
            cME.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.bvx() != null && dVar.bvx().advertAppContext != null && !dVar.bvx().advertAppContext.Dn && !su(dVar.bvx().advertAppContext.extensionInfo)) {
            dVar.bvx().page = dVar.bvx().advertAppContext.page;
            com.baidu.tbadk.distribute.a.aOh().a(dVar.bvx(), "", 0L, dVar.bvx().page, "show", dVar.bvx().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.bvx(), 3, dVar.bvx().advertAppContext.pn);
            d.Ia(dVar.bvx().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDp().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.bvx()));
            dVar.bvx().advertAppContext.Dn = true;
            cME.add(dVar.bvx().advertAppContext.extensionInfo);
        }
    }

    private static boolean su(String str) {
        return cME.contains(str);
    }
}
