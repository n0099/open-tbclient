package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.views.SmsLoginView;
/* loaded from: classes.dex */
public class c {
    public boolean Tk;
    public String bwl;
    public String bwm;
    public String bwn;
    public String bwo;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Tk) {
            com.baidu.tieba.recapp.report.b ad = com.baidu.tieba.recapp.report.f.ad(z ? 13 : 3, i, cVar.pn);
            ad.BQ(cVar.page);
            ad.dL("isCache", String.valueOf(cVar.bwl));
            ad.BN(cVar.bwm);
            ad.BO(cVar.bwn);
            ad.BP(cVar.fid);
            ad.dL("vc", cVar.bwo);
            ad.BI(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXA().a(ad);
            cVar.Tk = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.Tk) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, cVar.pn);
            c.BQ(cVar.page);
            c.dL("isCache", cVar.bwl);
            c.BN(cVar.bwm);
            c.BO(cVar.bwn);
            c.BP(cVar.fid);
            c.dL("vc", cVar.bwo);
            c.BI(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXA().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.Tk = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pS() != null && !dVar.Tk && !TextUtils.isEmpty(dVar.pS().ext)) {
            com.baidu.tieba.recapp.report.c.bXA().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Tk = true;
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Tk) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar = new com.baidu.tieba.recapp.report.b();
            bVar.xS(i2);
            if ("PB_BANNER".equals(cVar.page)) {
                bVar.xT(-1);
                bVar.setPageNumber(-1);
            } else {
                bVar.xT(i2);
                bVar.setPageNumber(cVar.pn);
            }
            bVar.BQ(cVar.page);
            bVar.BN(cVar.bwm);
            bVar.BO(cVar.bwn);
            bVar.BP(cVar.fid);
            bVar.dL("vc", cVar.bwo);
            bVar.BI(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXA().a(bVar);
            cVar.Tk = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.ced() != null && (cVar = mVar.ced().advertAppContext) != null && !cVar.Tk) {
            mVar.bwT = cVar.bwm;
            mVar.bwU = cVar.bwn;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.cee() != null && mVar.cee().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, i);
            c.BI(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXA().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.pR()));
            cVar.Tk = true;
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Tk) {
            com.baidu.tieba.recapp.report.b ad = com.baidu.tieba.recapp.report.f.ad(z ? 13 : 3, i, cVar.pn);
            ad.BQ(cVar.page);
            ad.BI(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXA().a(ad);
            cVar.Tk = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.aQU() != null && dVar.aQU().advertAppContext != null && !dVar.aQU().advertAppContext.Tk) {
            dVar.aQU().page = dVar.aQU().advertAppContext.page;
            com.baidu.tbadk.distribute.a.alC().a(dVar.aQU(), "", 0L, dVar.aQU().page, SmsLoginView.StatEvent.LOGIN_SHOW, dVar.aQU().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.aQU(), 3, dVar.aQU().advertAppContext.pn);
            d.BI(dVar.aQU().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXA().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.aQU()));
            dVar.aQU().advertAppContext.Tk = true;
        }
    }
}
