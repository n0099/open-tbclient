package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.views.SmsLoginView;
/* loaded from: classes.dex */
public class b {
    public boolean Rz;
    public String afJ;
    public String afK;
    public String afL;
    public String afM;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Rz) {
            com.baidu.tieba.recapp.report.b aa = com.baidu.tieba.recapp.report.f.aa(z ? 13 : 3, i, bVar.pn);
            aa.tM(bVar.page);
            aa.ck("isCache", String.valueOf(bVar.afJ));
            aa.tJ(bVar.afK);
            aa.tK(bVar.afL);
            aa.tL(bVar.fid);
            aa.ck("vc", bVar.afM);
            aa.tF(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bqQ().a(aa);
            bVar.Rz = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.Rz) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, bVar.pn);
            c.tM(bVar.page);
            c.ck("isCache", bVar.afJ);
            c.tJ(bVar.afK);
            c.tK(bVar.afL);
            c.tL(bVar.fid);
            c.ck("vc", bVar.afM);
            c.tF(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bqQ().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            bVar.Rz = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pq() != null && !dVar.Rz && !TextUtils.isEmpty(dVar.pq().ext)) {
            com.baidu.tieba.recapp.report.c.bqQ().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Rz = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Rz) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar2 = new com.baidu.tieba.recapp.report.b();
            bVar2.sJ(i2);
            if ("PB_BANNER".equals(bVar.page)) {
                bVar2.sK(-1);
                bVar2.setPageNumber(-1);
            } else {
                bVar2.sK(i2);
                bVar2.setPageNumber(bVar.pn);
            }
            bVar2.tM(bVar.page);
            bVar2.tJ(bVar.afK);
            bVar2.tK(bVar.afL);
            bVar2.tL(bVar.fid);
            bVar2.ck("vc", bVar.afM);
            bVar2.tF(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bqQ().a(bVar2);
            bVar.Rz = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.byA() != null && (bVar = lVar.byA().advertAppContext) != null && !bVar.Rz) {
            lVar.agu = bVar.afK;
            lVar.agv = bVar.afL;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.byB() != null && lVar.byB().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(lVar, i);
            c.tF(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bqQ().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(lVar.pp()));
            bVar.Rz = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Rz) {
            com.baidu.tieba.recapp.report.b aa = com.baidu.tieba.recapp.report.f.aa(z ? 13 : 3, i, bVar.pn);
            aa.tM(bVar.page);
            aa.tF(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bqQ().a(aa);
            bVar.Rz = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.ale() != null && dVar.ale().advertAppContext != null && !dVar.ale().advertAppContext.Rz) {
            dVar.ale().page = dVar.ale().advertAppContext.page;
            com.baidu.tbadk.distribute.a.Iv().a(dVar.ale(), "", 0L, dVar.ale().page, SmsLoginView.StatEvent.LOGIN_SHOW, dVar.ale().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.ale(), 3, dVar.ale().advertAppContext.pn);
            d.tF(dVar.ale().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.bqQ().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.ale()));
            dVar.ale().advertAppContext.Rz = true;
        }
    }
}
