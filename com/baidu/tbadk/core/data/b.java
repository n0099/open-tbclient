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
            aa.uW(bVar.page);
            aa.cA("isCache", String.valueOf(bVar.aoU));
            aa.uT(bVar.aoV);
            aa.uU(bVar.aoW);
            aa.uV(bVar.fid);
            aa.cA("vc", bVar.aoX);
            aa.uP(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bwf().a(aa);
            bVar.RT = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.RT) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, bVar.pn);
            c.uW(bVar.page);
            c.cA("isCache", bVar.aoU);
            c.uT(bVar.aoV);
            c.uU(bVar.aoW);
            c.uV(bVar.fid);
            c.cA("vc", bVar.aoX);
            c.uP(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bwf().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            bVar.RT = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pv() != null && !dVar.RT && !TextUtils.isEmpty(dVar.pv().ext)) {
            com.baidu.tieba.recapp.report.c.bwf().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.RT = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.RT) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar2 = new com.baidu.tieba.recapp.report.b();
            bVar2.ug(i2);
            if ("PB_BANNER".equals(bVar.page)) {
                bVar2.uh(-1);
                bVar2.setPageNumber(-1);
            } else {
                bVar2.uh(i2);
                bVar2.setPageNumber(bVar.pn);
            }
            bVar2.uW(bVar.page);
            bVar2.uT(bVar.aoV);
            bVar2.uU(bVar.aoW);
            bVar2.uV(bVar.fid);
            bVar2.cA("vc", bVar.aoX);
            bVar2.uP(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bwf().a(bVar2);
            bVar.RT = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bDX() != null && (bVar = lVar.bDX().advertAppContext) != null && !bVar.RT) {
            lVar.apE = bVar.aoV;
            lVar.apF = bVar.aoW;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.bDY() != null && lVar.bDY().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(lVar, i);
            c.uP(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bwf().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(lVar.pu()));
            bVar.RT = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.RT) {
            com.baidu.tieba.recapp.report.b aa = com.baidu.tieba.recapp.report.f.aa(z ? 13 : 3, i, bVar.pn);
            aa.uW(bVar.page);
            aa.uP(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bwf().a(aa);
            bVar.RT = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.aqK() != null && dVar.aqK().advertAppContext != null && !dVar.aqK().advertAppContext.RT) {
            dVar.aqK().page = dVar.aqK().advertAppContext.page;
            com.baidu.tbadk.distribute.a.LL().a(dVar.aqK(), "", 0L, dVar.aqK().page, "show", dVar.aqK().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.aqK(), 3, dVar.aqK().advertAppContext.pn);
            d.uP(dVar.aqK().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.bwf().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.aqK()));
            dVar.aqK().advertAppContext.RT = true;
        }
    }
}
