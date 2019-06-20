package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.views.SmsLoginView;
/* loaded from: classes.dex */
public class c {
    public boolean QV;
    public String bDA;
    public String bDB;
    public String bDy;
    public String bDz;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.QV) {
            com.baidu.tieba.recapp.report.b ae = com.baidu.tieba.recapp.report.f.ae(z ? 13 : 3, i, cVar.pn);
            ae.Do(cVar.page);
            ae.dZ("isCache", String.valueOf(cVar.bDy));
            ae.Dl(cVar.bDz);
            ae.Dm(cVar.bDA);
            ae.Dn(cVar.fid);
            ae.dZ("vc", cVar.bDB);
            ae.Dg(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cfH().a(ae);
            cVar.QV = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.QV) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, cVar.pn);
            c.Do(cVar.page);
            c.dZ("isCache", cVar.bDy);
            c.Dl(cVar.bDz);
            c.Dm(cVar.bDA);
            c.Dn(cVar.fid);
            c.dZ("vc", cVar.bDB);
            c.Dg(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cfH().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.QV = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.oN() != null && !dVar.QV && !TextUtils.isEmpty(dVar.oN().ext)) {
            com.baidu.tieba.recapp.report.c.cfH().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.QV = true;
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.QV) {
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
            bVar.Do(cVar.page);
            bVar.Dl(cVar.bDz);
            bVar.Dm(cVar.bDA);
            bVar.Dn(cVar.fid);
            bVar.dZ("vc", cVar.bDB);
            bVar.Dg(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cfH().a(bVar);
            cVar.QV = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.cml() != null && (cVar = mVar.cml().advertAppContext) != null && !cVar.QV) {
            mVar.bEg = cVar.bDz;
            mVar.bEh = cVar.bDA;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.cmm() != null && mVar.cmm().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, i);
            c.Dg(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cfH().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.oM()));
            cVar.QV = true;
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.QV) {
            com.baidu.tieba.recapp.report.b ae = com.baidu.tieba.recapp.report.f.ae(z ? 13 : 3, i, cVar.pn);
            ae.Do(cVar.page);
            ae.Dg(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cfH().a(ae);
            cVar.QV = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.aYg() != null && dVar.aYg().advertAppContext != null && !dVar.aYg().advertAppContext.QV) {
            dVar.aYg().page = dVar.aYg().advertAppContext.page;
            com.baidu.tbadk.distribute.a.aqF().a(dVar.aYg(), "", 0L, dVar.aYg().page, SmsLoginView.StatEvent.LOGIN_SHOW, dVar.aYg().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.aYg(), 3, dVar.aYg().advertAppContext.pn);
            d.Dg(dVar.aYg().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.cfH().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.aYg()));
            dVar.aYg().advertAppContext.QV = true;
        }
    }
}
