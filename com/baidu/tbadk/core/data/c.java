package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.views.SmsLoginView;
/* loaded from: classes.dex */
public class c {
    public boolean QW;
    public String bDA;
    public String bDx;
    public String bDy;
    public String bDz;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.QW) {
            com.baidu.tieba.recapp.report.b ae = com.baidu.tieba.recapp.report.f.ae(z ? 13 : 3, i, cVar.pn);
            ae.Dm(cVar.page);
            ae.dZ("isCache", String.valueOf(cVar.bDx));
            ae.Dj(cVar.bDy);
            ae.Dk(cVar.bDz);
            ae.Dl(cVar.fid);
            ae.dZ("vc", cVar.bDA);
            ae.De(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cfG().a(ae);
            cVar.QW = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.QW) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, cVar.pn);
            c.Dm(cVar.page);
            c.dZ("isCache", cVar.bDx);
            c.Dj(cVar.bDy);
            c.Dk(cVar.bDz);
            c.Dl(cVar.fid);
            c.dZ("vc", cVar.bDA);
            c.De(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cfG().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.QW = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.oN() != null && !dVar.QW && !TextUtils.isEmpty(dVar.oN().ext)) {
            com.baidu.tieba.recapp.report.c.cfG().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.QW = true;
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.QW) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar = new com.baidu.tieba.recapp.report.b();
            bVar.yZ(i2);
            if ("PB_BANNER".equals(cVar.page)) {
                bVar.za(-1);
                bVar.setPageNumber(-1);
            } else {
                bVar.za(i2);
                bVar.setPageNumber(cVar.pn);
            }
            bVar.Dm(cVar.page);
            bVar.Dj(cVar.bDy);
            bVar.Dk(cVar.bDz);
            bVar.Dl(cVar.fid);
            bVar.dZ("vc", cVar.bDA);
            bVar.De(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cfG().a(bVar);
            cVar.QW = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.cmk() != null && (cVar = mVar.cmk().advertAppContext) != null && !cVar.QW) {
            mVar.bEf = cVar.bDy;
            mVar.bEg = cVar.bDz;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.cml() != null && mVar.cml().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, i);
            c.De(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cfG().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.oM()));
            cVar.QW = true;
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.QW) {
            com.baidu.tieba.recapp.report.b ae = com.baidu.tieba.recapp.report.f.ae(z ? 13 : 3, i, cVar.pn);
            ae.Dm(cVar.page);
            ae.De(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cfG().a(ae);
            cVar.QW = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.aYg() != null && dVar.aYg().advertAppContext != null && !dVar.aYg().advertAppContext.QW) {
            dVar.aYg().page = dVar.aYg().advertAppContext.page;
            com.baidu.tbadk.distribute.a.aqF().a(dVar.aYg(), "", 0L, dVar.aYg().page, SmsLoginView.StatEvent.LOGIN_SHOW, dVar.aYg().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.aYg(), 3, dVar.aYg().advertAppContext.pn);
            d.De(dVar.aYg().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.cfG().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.aYg()));
            dVar.aYg().advertAppContext.QW = true;
        }
    }
}
