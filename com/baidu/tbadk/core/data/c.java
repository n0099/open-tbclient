package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    protected static final Set<String> cMD = new HashSet();
    public boolean Dn;
    public String cMA;
    public String cMB;
    public String cMC;
    public String cMz;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b Y = com.baidu.tieba.recapp.report.f.Y(z ? 13 : 3, i, cVar.pn);
            Y.Ii(cVar.page);
            Y.er("isCache", String.valueOf(cVar.cMz));
            Y.If(cVar.cMA);
            Y.Ig(cVar.cMB);
            Y.Ih(cVar.fid);
            Y.er("vc", cVar.cMC);
            Y.Ia(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDn().a(Y);
            cVar.Dn = true;
            cMD.add(cVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, cVar.pn);
            c.Ii(cVar.page);
            c.er("isCache", cVar.cMz);
            c.If(cVar.cMA);
            c.Ig(cVar.cMB);
            c.Ih(cVar.fid);
            c.er("vc", cVar.cMC);
            c.Ia(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDn().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.Dn = true;
            cMD.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.kL() != null && !dVar.Dn && !TextUtils.isEmpty(dVar.kL().ext) && !su(dVar.kL().ext)) {
            com.baidu.tieba.recapp.report.c.cDn().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Dn = true;
            cMD.add(dVar.kL().ext);
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
            bVar.If(cVar.cMA);
            bVar.Ig(cVar.cMB);
            bVar.Ih(cVar.fid);
            bVar.er("vc", cVar.cMC);
            bVar.Ia(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDn().a(bVar);
            cVar.Dn = true;
            cMD.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.cKM() != null && (cVar = mVar.cKM().advertAppContext) != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            mVar.cNh = cVar.cMA;
            mVar.cNi = cVar.cMB;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.cKN() != null && mVar.cKN().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, i);
            c.Ia(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDn().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.kK()));
            cVar.Dn = true;
            cMD.add(cVar.extensionInfo);
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b Y = com.baidu.tieba.recapp.report.f.Y(z ? 13 : 3, i, cVar.pn);
            Y.Ii(cVar.page);
            Y.Ia(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDn().a(Y);
            cVar.Dn = true;
            cMD.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.bvv() != null && dVar.bvv().advertAppContext != null && !dVar.bvv().advertAppContext.Dn && !su(dVar.bvv().advertAppContext.extensionInfo)) {
            dVar.bvv().page = dVar.bvv().advertAppContext.page;
            com.baidu.tbadk.distribute.a.aOf().a(dVar.bvv(), "", 0L, dVar.bvv().page, "show", dVar.bvv().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.bvv(), 3, dVar.bvv().advertAppContext.pn);
            d.Ia(dVar.bvv().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDn().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.bvv()));
            dVar.bvv().advertAppContext.Dn = true;
            cMD.add(dVar.bvv().advertAppContext.extensionInfo);
        }
    }

    private static boolean su(String str) {
        return cMD.contains(str);
    }
}
