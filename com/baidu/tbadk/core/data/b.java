package com.baidu.tbadk.core.data;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class b {
    public boolean OZ;
    public String adp;
    public String adq;
    public String adr;
    public String ads;
    public String adt;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.OZ) {
            com.baidu.tieba.recapp.report.a W = com.baidu.tieba.recapp.report.e.W(z ? 13 : 3, i, bVar.pn);
            W.tf(bVar.adp);
            W.bZ("isCache", String.valueOf(bVar.adq));
            W.tc(bVar.adr);
            W.td(bVar.ads);
            W.te(bVar.fid);
            W.bZ("vc", bVar.adt);
            W.sY(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bpc().a(W);
            bVar.OZ = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.OZ) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.tf(bVar.adp);
            c.bZ("isCache", bVar.adq);
            c.tc(bVar.adr);
            c.td(bVar.ads);
            c.te(bVar.fid);
            c.bZ("vc", bVar.adt);
            c.sY(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bpc().a(c);
            bVar.OZ = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.ol() != null && !dVar.OZ && !TextUtils.isEmpty(dVar.ol().ext)) {
            com.baidu.tieba.recapp.report.b.bpc().a(com.baidu.tieba.recapp.report.e.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.OZ = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.OZ) {
            com.baidu.tieba.recapp.report.a W = com.baidu.tieba.recapp.report.e.W(z ? 13 : 3, i, bVar.pn);
            W.tf(bVar.adp);
            W.tc(bVar.adr);
            W.td(bVar.ads);
            W.te(bVar.fid);
            W.bZ("vc", bVar.adt);
            W.sY(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bpc().a(W);
            bVar.OZ = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bwP() != null && (bVar = lVar.bwP().advertAppContext) != null && !bVar.OZ) {
            lVar.aea = bVar.adr;
            lVar.aeb = bVar.ads;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.bwQ() != null && lVar.bwQ().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, i);
            c.sY(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bpc().a(c);
            bVar.OZ = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.OZ) {
            com.baidu.tieba.recapp.report.a W = com.baidu.tieba.recapp.report.e.W(z ? 13 : 3, i, bVar.pn);
            W.tf(bVar.adp);
            W.sY(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bpc().a(W);
            bVar.OZ = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.ajx() != null && dVar.ajx().advertAppContext != null && !dVar.ajx().advertAppContext.OZ) {
            dVar.ajx().adp = dVar.ajx().advertAppContext.adp;
            com.baidu.tbadk.distribute.a.GR().a(dVar.ajx(), "", 0L, dVar.ajx().adp, "show", dVar.ajx().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.ajx(), 3, dVar.ajx().advertAppContext.pn);
            d.sY(dVar.ajx().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bpc().a(d);
            dVar.ajx().advertAppContext.OZ = true;
        }
    }
}
