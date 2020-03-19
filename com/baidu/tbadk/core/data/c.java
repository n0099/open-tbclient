package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    protected static final Set<String> cMQ = new HashSet();
    public boolean Dn;
    public String cMM;
    public String cMN;
    public String cMO;
    public String cMP;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b Y = com.baidu.tieba.recapp.report.f.Y(z ? 13 : 3, i, cVar.pn);
            Y.Ij(cVar.page);
            Y.ep("isCache", String.valueOf(cVar.cMM));
            Y.Ig(cVar.cMN);
            Y.Ih(cVar.cMO);
            Y.Ii(cVar.fid);
            Y.ep("vc", cVar.cMP);
            Y.Ib(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDK().a(Y);
            cVar.Dn = true;
            cMQ.add(cVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, cVar.pn);
            c.Ij(cVar.page);
            c.ep("isCache", cVar.cMM);
            c.Ig(cVar.cMN);
            c.Ih(cVar.cMO);
            c.Ii(cVar.fid);
            c.ep("vc", cVar.cMP);
            c.Ib(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDK().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.Dn = true;
            cMQ.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.kL() != null && !dVar.Dn && !TextUtils.isEmpty(dVar.kL().ext) && !su(dVar.kL().ext)) {
            com.baidu.tieba.recapp.report.c.cDK().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Dn = true;
            cMQ.add(dVar.kL().ext);
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar = new com.baidu.tieba.recapp.report.b();
            bVar.Bg(i2);
            if ("PB_BANNER".equals(cVar.page)) {
                bVar.Bh(-1);
                bVar.setPageNumber(-1);
            } else {
                bVar.Bh(i2);
                bVar.setPageNumber(cVar.pn);
            }
            bVar.Ij(cVar.page);
            bVar.Ig(cVar.cMN);
            bVar.Ih(cVar.cMO);
            bVar.Ii(cVar.fid);
            bVar.ep("vc", cVar.cMP);
            bVar.Ib(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDK().a(bVar);
            cVar.Dn = true;
            cMQ.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.cLj() != null && (cVar = mVar.cLj().advertAppContext) != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            mVar.cNw = cVar.cMN;
            mVar.cNx = cVar.cMO;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.cLk() != null && mVar.cLk().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, i);
            c.Ib(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDK().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.kK()));
            cVar.Dn = true;
            cMQ.add(cVar.extensionInfo);
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Dn && !su(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b Y = com.baidu.tieba.recapp.report.f.Y(z ? 13 : 3, i, cVar.pn);
            Y.Ij(cVar.page);
            Y.Ib(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDK().a(Y);
            cVar.Dn = true;
            cMQ.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.bvD() != null && dVar.bvD().advertAppContext != null && !dVar.bvD().advertAppContext.Dn && !su(dVar.bvD().advertAppContext.extensionInfo)) {
            dVar.bvD().page = dVar.bvD().advertAppContext.page;
            com.baidu.tbadk.distribute.a.aOm().a(dVar.bvD(), "", 0L, dVar.bvD().page, "show", dVar.bvD().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.bvD(), 3, dVar.bvD().advertAppContext.pn);
            d.Ib(dVar.bvD().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.cDK().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.bvD()));
            dVar.bvD().advertAppContext.Dn = true;
            cMQ.add(dVar.bvD().advertAppContext.extensionInfo);
        }
    }

    private static boolean su(String str) {
        return cMQ.contains(str);
    }
}
