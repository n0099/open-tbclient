package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.views.SmsLoginView;
/* loaded from: classes.dex */
public class c {
    public boolean Tk;
    public String bwi;
    public String bwj;
    public String bwk;
    public String bwl;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Tk) {
            com.baidu.tieba.recapp.report.b ad = com.baidu.tieba.recapp.report.f.ad(z ? 13 : 3, i, cVar.pn);
            ad.BR(cVar.page);
            ad.dK("isCache", String.valueOf(cVar.bwi));
            ad.BO(cVar.bwj);
            ad.BP(cVar.bwk);
            ad.BQ(cVar.fid);
            ad.dK("vc", cVar.bwl);
            ad.BJ(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXE().a(ad);
            cVar.Tk = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.Tk) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, cVar.pn);
            c.BR(cVar.page);
            c.dK("isCache", cVar.bwi);
            c.BO(cVar.bwj);
            c.BP(cVar.bwk);
            c.BQ(cVar.fid);
            c.dK("vc", cVar.bwl);
            c.BJ(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXE().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.Tk = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pS() != null && !dVar.Tk && !TextUtils.isEmpty(dVar.pS().ext)) {
            com.baidu.tieba.recapp.report.c.bXE().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Tk = true;
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Tk) {
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
            bVar.BR(cVar.page);
            bVar.BO(cVar.bwj);
            bVar.BP(cVar.bwk);
            bVar.BQ(cVar.fid);
            bVar.dK("vc", cVar.bwl);
            bVar.BJ(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXE().a(bVar);
            cVar.Tk = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.ceh() != null && (cVar = mVar.ceh().advertAppContext) != null && !cVar.Tk) {
            mVar.bwQ = cVar.bwj;
            mVar.bwR = cVar.bwk;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.cei() != null && mVar.cei().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, i);
            c.BJ(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXE().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.pR()));
            cVar.Tk = true;
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Tk) {
            com.baidu.tieba.recapp.report.b ad = com.baidu.tieba.recapp.report.f.ad(z ? 13 : 3, i, cVar.pn);
            ad.BR(cVar.page);
            ad.BJ(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXE().a(ad);
            cVar.Tk = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.aQW() != null && dVar.aQW().advertAppContext != null && !dVar.aQW().advertAppContext.Tk) {
            dVar.aQW().page = dVar.aQW().advertAppContext.page;
            com.baidu.tbadk.distribute.a.alF().a(dVar.aQW(), "", 0L, dVar.aQW().page, SmsLoginView.StatEvent.LOGIN_SHOW, dVar.aQW().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.aQW(), 3, dVar.aQW().advertAppContext.pn);
            d.BJ(dVar.aQW().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.bXE().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.aQW()));
            dVar.aQW().advertAppContext.Tk = true;
        }
    }
}
