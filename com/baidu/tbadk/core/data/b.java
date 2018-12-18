package com.baidu.tbadk.core.data;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class b {
    public boolean RT;
    public String aoU;
    public String aoV;
    public String aoW;
    public String aoX;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.RT) {
            com.baidu.tieba.recapp.report.b aa = com.baidu.tieba.recapp.report.f.aa(z ? 13 : 3, i, bVar.pn);
            aa.uT(bVar.page);
            aa.cA("isCache", String.valueOf(bVar.aoU));
            aa.uQ(bVar.aoV);
            aa.uR(bVar.aoW);
            aa.uS(bVar.fid);
            aa.cA("vc", bVar.aoX);
            aa.uM(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bvt().a(aa);
            bVar.RT = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.RT) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, bVar.pn);
            c.uT(bVar.page);
            c.cA("isCache", bVar.aoU);
            c.uQ(bVar.aoV);
            c.uR(bVar.aoW);
            c.uS(bVar.fid);
            c.cA("vc", bVar.aoX);
            c.uM(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bvt().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            bVar.RT = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pv() != null && !dVar.RT && !TextUtils.isEmpty(dVar.pv().ext)) {
            com.baidu.tieba.recapp.report.c.bvt().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.RT = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.RT) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar2 = new com.baidu.tieba.recapp.report.b();
            bVar2.tT(i2);
            if ("PB_BANNER".equals(bVar.page)) {
                bVar2.tU(-1);
                bVar2.setPageNumber(-1);
            } else {
                bVar2.tU(i2);
                bVar2.setPageNumber(bVar.pn);
            }
            bVar2.uT(bVar.page);
            bVar2.uQ(bVar.aoV);
            bVar2.uR(bVar.aoW);
            bVar2.uS(bVar.fid);
            bVar2.cA("vc", bVar.aoX);
            bVar2.uM(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bvt().a(bVar2);
            bVar.RT = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bDf() != null && (bVar = lVar.bDf().advertAppContext) != null && !bVar.RT) {
            lVar.apE = bVar.aoV;
            lVar.apF = bVar.aoW;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.bDg() != null && lVar.bDg().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(lVar, i);
            c.uM(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bvt().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(lVar.pu()));
            bVar.RT = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.RT) {
            com.baidu.tieba.recapp.report.b aa = com.baidu.tieba.recapp.report.f.aa(z ? 13 : 3, i, bVar.pn);
            aa.uT(bVar.page);
            aa.uM(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bvt().a(aa);
            bVar.RT = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.apV() != null && dVar.apV().advertAppContext != null && !dVar.apV().advertAppContext.RT) {
            dVar.apV().page = dVar.apV().advertAppContext.page;
            com.baidu.tbadk.distribute.a.LK().a(dVar.apV(), "", 0L, dVar.apV().page, "show", dVar.apV().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.apV(), 3, dVar.apV().advertAppContext.pn);
            d.uM(dVar.apV().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.bvt().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.apV()));
            dVar.apV().advertAppContext.RT = true;
        }
    }
}
