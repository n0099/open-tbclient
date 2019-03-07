package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.views.SmsLoginView;
/* loaded from: classes.dex */
public class c {
    public boolean Tj;
    public String bwg;
    public String bwh;
    public String bwi;
    public String bwj;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Tj) {
            com.baidu.tieba.recapp.report.b ad = com.baidu.tieba.recapp.report.f.ad(z ? 13 : 3, i, cVar.pn);
            ad.BS(cVar.page);
            ad.dL("isCache", String.valueOf(cVar.bwg));
            ad.BP(cVar.bwh);
            ad.BQ(cVar.bwi);
            ad.BR(cVar.fid);
            ad.dL("vc", cVar.bwj);
            ad.BK(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXB().a(ad);
            cVar.Tj = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.Tj) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, cVar.pn);
            c.BS(cVar.page);
            c.dL("isCache", cVar.bwg);
            c.BP(cVar.bwh);
            c.BQ(cVar.bwi);
            c.BR(cVar.fid);
            c.dL("vc", cVar.bwj);
            c.BK(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXB().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.Tj = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pS() != null && !dVar.Tj && !TextUtils.isEmpty(dVar.pS().ext)) {
            com.baidu.tieba.recapp.report.c.bXB().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Tj = true;
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Tj) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar = new com.baidu.tieba.recapp.report.b();
            bVar.xW(i2);
            if ("PB_BANNER".equals(cVar.page)) {
                bVar.xX(-1);
                bVar.setPageNumber(-1);
            } else {
                bVar.xX(i2);
                bVar.setPageNumber(cVar.pn);
            }
            bVar.BS(cVar.page);
            bVar.BP(cVar.bwh);
            bVar.BQ(cVar.bwi);
            bVar.BR(cVar.fid);
            bVar.dL("vc", cVar.bwj);
            bVar.BK(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXB().a(bVar);
            cVar.Tj = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.cee() != null && (cVar = mVar.cee().advertAppContext) != null && !cVar.Tj) {
            mVar.bwO = cVar.bwh;
            mVar.bwP = cVar.bwi;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.cef() != null && mVar.cef().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, i);
            c.BK(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXB().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.pR()));
            cVar.Tj = true;
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Tj) {
            com.baidu.tieba.recapp.report.b ad = com.baidu.tieba.recapp.report.f.ad(z ? 13 : 3, i, cVar.pn);
            ad.BS(cVar.page);
            ad.BK(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXB().a(ad);
            cVar.Tj = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.aQW() != null && dVar.aQW().advertAppContext != null && !dVar.aQW().advertAppContext.Tj) {
            dVar.aQW().page = dVar.aQW().advertAppContext.page;
            com.baidu.tbadk.distribute.a.alG().a(dVar.aQW(), "", 0L, dVar.aQW().page, SmsLoginView.StatEvent.LOGIN_SHOW, dVar.aQW().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.aQW(), 3, dVar.aQW().advertAppContext.pn);
            d.BK(dVar.aQW().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXB().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.aQW()));
            dVar.aQW().advertAppContext.Tj = true;
        }
    }
}
