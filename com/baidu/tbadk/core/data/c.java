package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    protected static final Set<String> cMF = new HashSet();
    public boolean Dn;
    public String cMB;
    public String cMC;
    public String cMD;
    public String cME;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b Y = com.baidu.tieba.recapp.report.f.Y(z ? 13 : 3, i, cVar.pn);
            Y.Ij(cVar.page);
            Y.er("isCache", String.valueOf(cVar.cMB));
            Y.Ig(cVar.cMC);
            Y.Ih(cVar.cMD);
            Y.Ii(cVar.fid);
            Y.er("vc", cVar.cME);
            Y.Ib(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDq().a(Y);
            cVar.Dn = true;
            cMF.add(cVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, cVar.pn);
            c.Ij(cVar.page);
            c.er("isCache", cVar.cMB);
            c.Ig(cVar.cMC);
            c.Ih(cVar.cMD);
            c.Ii(cVar.fid);
            c.er("vc", cVar.cME);
            c.Ib(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDq().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.Dn = true;
            cMF.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.kL() != null && !dVar.Dn && !TextUtils.isEmpty(dVar.kL().ext) && !su(dVar.kL().ext)) {
            com.baidu.tieba.recapp.report.c.cDq().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Dn = true;
            cMF.add(dVar.kL().ext);
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
            bVar.Ij(cVar.page);
            bVar.Ig(cVar.cMC);
            bVar.Ih(cVar.cMD);
            bVar.Ii(cVar.fid);
            bVar.er("vc", cVar.cME);
            bVar.Ib(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDq().a(bVar);
            cVar.Dn = true;
            cMF.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.cKP() != null && (cVar = mVar.cKP().advertAppContext) != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            mVar.cNj = cVar.cMC;
            mVar.cNk = cVar.cMD;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.cKQ() != null && mVar.cKQ().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, i);
            c.Ib(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDq().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.kK()));
            cVar.Dn = true;
            cMF.add(cVar.extensionInfo);
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b Y = com.baidu.tieba.recapp.report.f.Y(z ? 13 : 3, i, cVar.pn);
            Y.Ij(cVar.page);
            Y.Ib(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDq().a(Y);
            cVar.Dn = true;
            cMF.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.bvy() != null && dVar.bvy().advertAppContext != null && !dVar.bvy().advertAppContext.Dn && !su(dVar.bvy().advertAppContext.extensionInfo)) {
            dVar.bvy().page = dVar.bvy().advertAppContext.page;
            com.baidu.tbadk.distribute.a.aOi().a(dVar.bvy(), "", 0L, dVar.bvy().page, "show", dVar.bvy().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.bvy(), 3, dVar.bvy().advertAppContext.pn);
            d.Ib(dVar.bvy().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDq().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.bvy()));
            dVar.bvy().advertAppContext.Dn = true;
            cMF.add(dVar.bvy().advertAppContext.extensionInfo);
        }
    }

    private static boolean su(String str) {
        return cMF.contains(str);
    }
}
