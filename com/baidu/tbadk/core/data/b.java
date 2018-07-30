package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.views.SmsLoginView;
/* loaded from: classes.dex */
public class b {
    public boolean OY;
    public String adi;
    public String adj;
    public String adk;
    public String adl;
    public String adm;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.OY) {
            com.baidu.tieba.recapp.report.b V = com.baidu.tieba.recapp.report.f.V(z ? 13 : 3, i, bVar.pn);
            V.tb(bVar.adi);
            V.ca("isCache", String.valueOf(bVar.adj));
            V.sY(bVar.adk);
            V.sZ(bVar.adl);
            V.ta(bVar.fid);
            V.ca("vc", bVar.adm);
            V.sU(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.boi().a(V);
            bVar.OY = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.OY) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, bVar.pn);
            c.tb(bVar.adi);
            c.ca("isCache", bVar.adj);
            c.sY(bVar.adk);
            c.sZ(bVar.adl);
            c.ta(bVar.fid);
            c.ca("vc", bVar.adm);
            c.sU(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.boi().a(c);
            bVar.OY = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.on() != null && !dVar.OY && !TextUtils.isEmpty(dVar.on().ext)) {
            com.baidu.tieba.recapp.report.c.boi().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.OY = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.OY) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar2 = new com.baidu.tieba.recapp.report.b();
            bVar2.sl(i2);
            if ("PB_BANNER".equals(bVar.adi)) {
                bVar2.sm(-1);
                bVar2.setPageNumber(-1);
            } else {
                bVar2.sm(i2);
                bVar2.setPageNumber(bVar.pn);
            }
            bVar2.tb(bVar.adi);
            bVar2.sY(bVar.adk);
            bVar2.sZ(bVar.adl);
            bVar2.ta(bVar.fid);
            bVar2.ca("vc", bVar.adm);
            bVar2.sU(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.boi().a(bVar2);
            bVar.OY = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bvT() != null && (bVar = lVar.bvT().advertAppContext) != null && !bVar.OY) {
            lVar.adT = bVar.adk;
            lVar.adU = bVar.adl;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.bvU() != null && lVar.bvU().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(lVar, i);
            c.sU(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.boi().a(c);
            bVar.OY = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.OY) {
            com.baidu.tieba.recapp.report.b V = com.baidu.tieba.recapp.report.f.V(z ? 13 : 3, i, bVar.pn);
            V.tb(bVar.adi);
            V.sU(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.boi().a(V);
            bVar.OY = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.ajq() != null && dVar.ajq().advertAppContext != null && !dVar.ajq().advertAppContext.OY) {
            dVar.ajq().adi = dVar.ajq().advertAppContext.adi;
            com.baidu.tbadk.distribute.a.Hf().a(dVar.ajq(), "", 0L, dVar.ajq().adi, SmsLoginView.StatEvent.LOGIN_SHOW, dVar.ajq().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.ajq(), 3, dVar.ajq().advertAppContext.pn);
            d.sU(dVar.ajq().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.boi().a(d);
            dVar.ajq().advertAppContext.OY = true;
        }
    }
}
