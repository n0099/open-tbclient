package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.views.SmsLoginView;
/* loaded from: classes.dex */
public class b {
    public boolean Pb;
    public String adE;
    public String adF;
    public String adG;
    public String adH;
    public String adI;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Pb) {
            com.baidu.tieba.recapp.report.a W = com.baidu.tieba.recapp.report.e.W(z ? 13 : 3, i, bVar.pn);
            W.te(bVar.adE);
            W.cd("isCache", String.valueOf(bVar.adF));
            W.tb(bVar.adG);
            W.tc(bVar.adH);
            W.td(bVar.fid);
            W.cd("vc", bVar.adI);
            W.sX(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bpD().a(W);
            bVar.Pb = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.Pb) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.te(bVar.adE);
            c.cd("isCache", bVar.adF);
            c.tb(bVar.adG);
            c.tc(bVar.adH);
            c.td(bVar.fid);
            c.cd("vc", bVar.adI);
            c.sX(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bpD().a(c);
            bVar.Pb = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.ol() != null && !dVar.Pb && !TextUtils.isEmpty(dVar.ol().ext)) {
            com.baidu.tieba.recapp.report.b.bpD().a(com.baidu.tieba.recapp.report.e.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Pb = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Pb) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.a aVar = new com.baidu.tieba.recapp.report.a();
            aVar.sn(i2);
            if ("PB_BANNER".equals(bVar.adE)) {
                aVar.so(-1);
                aVar.setPageNumber(-1);
            } else {
                aVar.so(i2);
                aVar.setPageNumber(bVar.pn);
            }
            aVar.te(bVar.adE);
            aVar.tb(bVar.adG);
            aVar.tc(bVar.adH);
            aVar.td(bVar.fid);
            aVar.cd("vc", bVar.adI);
            aVar.sX(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bpD().a(aVar);
            bVar.Pb = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bxq() != null && (bVar = lVar.bxq().advertAppContext) != null && !bVar.Pb) {
            lVar.aep = bVar.adG;
            lVar.aeq = bVar.adH;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.bxr() != null && lVar.bxr().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, i);
            c.sX(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bpD().a(c);
            bVar.Pb = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Pb) {
            com.baidu.tieba.recapp.report.a W = com.baidu.tieba.recapp.report.e.W(z ? 13 : 3, i, bVar.pn);
            W.te(bVar.adE);
            W.sX(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bpD().a(W);
            bVar.Pb = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.aiR() != null && dVar.aiR().advertAppContext != null && !dVar.aiR().advertAppContext.Pb) {
            dVar.aiR().adE = dVar.aiR().advertAppContext.adE;
            com.baidu.tbadk.distribute.a.Hj().a(dVar.aiR(), "", 0L, dVar.aiR().adE, SmsLoginView.StatEvent.LOGIN_SHOW, dVar.aiR().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.aiR(), 3, dVar.aiR().advertAppContext.pn);
            d.sX(dVar.aiR().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bpD().a(d);
            dVar.aiR().advertAppContext.Pb = true;
        }
    }
}
