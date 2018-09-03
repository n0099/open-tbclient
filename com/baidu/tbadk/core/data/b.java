package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.views.SmsLoginView;
/* loaded from: classes.dex */
public class b {
    public boolean OY;
    public String adj;
    public String adk;
    public String adl;
    public String adm;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.OY) {
            com.baidu.tieba.recapp.report.b V = com.baidu.tieba.recapp.report.f.V(z ? 13 : 3, i, bVar.pn);
            V.tf(bVar.page);
            V.ca("isCache", String.valueOf(bVar.adj));
            V.tc(bVar.adk);
            V.td(bVar.adl);
            V.te(bVar.fid);
            V.ca("vc", bVar.adm);
            V.sY(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.boj().a(V);
            bVar.OY = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.OY) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, bVar.pn);
            c.tf(bVar.page);
            c.ca("isCache", bVar.adj);
            c.tc(bVar.adk);
            c.td(bVar.adl);
            c.te(bVar.fid);
            c.ca("vc", bVar.adm);
            c.sY(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.boj().a(c);
            bVar.OY = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.ok() != null && !dVar.OY && !TextUtils.isEmpty(dVar.ok().ext)) {
            com.baidu.tieba.recapp.report.c.boj().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.OY = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.OY) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar2 = new com.baidu.tieba.recapp.report.b();
            bVar2.sl(i2);
            if ("PB_BANNER".equals(bVar.page)) {
                bVar2.sm(-1);
                bVar2.setPageNumber(-1);
            } else {
                bVar2.sm(i2);
                bVar2.setPageNumber(bVar.pn);
            }
            bVar2.tf(bVar.page);
            bVar2.tc(bVar.adk);
            bVar2.td(bVar.adl);
            bVar2.te(bVar.fid);
            bVar2.ca("vc", bVar.adm);
            bVar2.sY(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.boj().a(bVar2);
            bVar.OY = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bvU() != null && (bVar = lVar.bvU().advertAppContext) != null && !bVar.OY) {
            lVar.adT = bVar.adk;
            lVar.adU = bVar.adl;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.bvV() != null && lVar.bvV().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(lVar, i);
            c.sY(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.boj().a(c);
            bVar.OY = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.OY) {
            com.baidu.tieba.recapp.report.b V = com.baidu.tieba.recapp.report.f.V(z ? 13 : 3, i, bVar.pn);
            V.tf(bVar.page);
            V.sY(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.boj().a(V);
            bVar.OY = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.ajt() != null && dVar.ajt().advertAppContext != null && !dVar.ajt().advertAppContext.OY) {
            dVar.ajt().page = dVar.ajt().advertAppContext.page;
            com.baidu.tbadk.distribute.a.Hf().a(dVar.ajt(), "", 0L, dVar.ajt().page, SmsLoginView.StatEvent.LOGIN_SHOW, dVar.ajt().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.ajt(), 3, dVar.ajt().advertAppContext.pn);
            d.sY(dVar.ajt().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.boj().a(d);
            dVar.ajt().advertAppContext.OY = true;
        }
    }
}
