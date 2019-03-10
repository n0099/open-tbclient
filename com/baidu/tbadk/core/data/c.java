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
            ad.BT(cVar.page);
            ad.dL("isCache", String.valueOf(cVar.bwg));
            ad.BQ(cVar.bwh);
            ad.BR(cVar.bwi);
            ad.BS(cVar.fid);
            ad.dL("vc", cVar.bwj);
            ad.BL(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXC().a(ad);
            cVar.Tj = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.Tj) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, cVar.pn);
            c.BT(cVar.page);
            c.dL("isCache", cVar.bwg);
            c.BQ(cVar.bwh);
            c.BR(cVar.bwi);
            c.BS(cVar.fid);
            c.dL("vc", cVar.bwj);
            c.BL(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXC().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.Tj = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pS() != null && !dVar.Tj && !TextUtils.isEmpty(dVar.pS().ext)) {
            com.baidu.tieba.recapp.report.c.bXC().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
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
            bVar.BT(cVar.page);
            bVar.BQ(cVar.bwh);
            bVar.BR(cVar.bwi);
            bVar.BS(cVar.fid);
            bVar.dL("vc", cVar.bwj);
            bVar.BL(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXC().a(bVar);
            cVar.Tj = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.cef() != null && (cVar = mVar.cef().advertAppContext) != null && !cVar.Tj) {
            mVar.bwO = cVar.bwh;
            mVar.bwP = cVar.bwi;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.ceg() != null && mVar.ceg().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, i);
            c.BL(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXC().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.pR()));
            cVar.Tj = true;
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Tj) {
            com.baidu.tieba.recapp.report.b ad = com.baidu.tieba.recapp.report.f.ad(z ? 13 : 3, i, cVar.pn);
            ad.BT(cVar.page);
            ad.BL(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXC().a(ad);
            cVar.Tj = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.aQX() != null && dVar.aQX().advertAppContext != null && !dVar.aQX().advertAppContext.Tj) {
            dVar.aQX().page = dVar.aQX().advertAppContext.page;
            com.baidu.tbadk.distribute.a.alG().a(dVar.aQX(), "", 0L, dVar.aQX().page, SmsLoginView.StatEvent.LOGIN_SHOW, dVar.aQX().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.aQX(), 3, dVar.aQX().advertAppContext.pn);
            d.BL(dVar.aQX().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXC().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.aQX()));
            dVar.aQX().advertAppContext.Tj = true;
        }
    }
}
