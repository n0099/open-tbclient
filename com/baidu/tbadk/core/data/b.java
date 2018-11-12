package com.baidu.tbadk.core.data;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class b {
    public boolean RT;
    public String alu;
    public String alv;
    public String alw;
    public String alx;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.RT) {
            com.baidu.tieba.recapp.report.b aa = com.baidu.tieba.recapp.report.f.aa(z ? 13 : 3, i, bVar.pn);
            aa.us(bVar.page);
            aa.cv("isCache", String.valueOf(bVar.alu));
            aa.up(bVar.alv);
            aa.uq(bVar.alw);
            aa.ur(bVar.fid);
            aa.cv("vc", bVar.alx);
            aa.ul(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.btB().a(aa);
            bVar.RT = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.RT) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, bVar.pn);
            c.us(bVar.page);
            c.cv("isCache", bVar.alu);
            c.up(bVar.alv);
            c.uq(bVar.alw);
            c.ur(bVar.fid);
            c.cv("vc", bVar.alx);
            c.ul(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.btB().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            bVar.RT = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pw() != null && !dVar.RT && !TextUtils.isEmpty(dVar.pw().ext)) {
            com.baidu.tieba.recapp.report.c.btB().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.RT = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.RT) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar2 = new com.baidu.tieba.recapp.report.b();
            bVar2.tz(i2);
            if ("PB_BANNER".equals(bVar.page)) {
                bVar2.tA(-1);
                bVar2.setPageNumber(-1);
            } else {
                bVar2.tA(i2);
                bVar2.setPageNumber(bVar.pn);
            }
            bVar2.us(bVar.page);
            bVar2.up(bVar.alv);
            bVar2.uq(bVar.alw);
            bVar2.ur(bVar.fid);
            bVar2.cv("vc", bVar.alx);
            bVar2.ul(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.btB().a(bVar2);
            bVar.RT = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bBl() != null && (bVar = lVar.bBl().advertAppContext) != null && !bVar.RT) {
            lVar.amd = bVar.alv;
            lVar.ame = bVar.alw;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.bBm() != null && lVar.bBm().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(lVar, i);
            c.ul(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.btB().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(lVar.pv()));
            bVar.RT = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.RT) {
            com.baidu.tieba.recapp.report.b aa = com.baidu.tieba.recapp.report.f.aa(z ? 13 : 3, i, bVar.pn);
            aa.us(bVar.page);
            aa.ul(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.btB().a(aa);
            bVar.RT = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.aoi() != null && dVar.aoi().advertAppContext != null && !dVar.aoi().advertAppContext.RT) {
            dVar.aoi().page = dVar.aoi().advertAppContext.page;
            com.baidu.tbadk.distribute.a.KG().a(dVar.aoi(), "", 0L, dVar.aoi().page, "show", dVar.aoi().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.aoi(), 3, dVar.aoi().advertAppContext.pn);
            d.ul(dVar.aoi().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.btB().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.aoi()));
            dVar.aoi().advertAppContext.RT = true;
        }
    }
}
