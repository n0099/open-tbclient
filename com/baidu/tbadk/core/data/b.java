package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    protected static final Set<String> dME = new HashSet();
    public boolean Xw;
    public String dMA;
    public String dMB;
    public String dMC;
    public String dMD;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Xw && !wJ(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c Y = com.baidu.tieba.recapp.report.g.Y(z ? 13 : 3, i, bVar.pn);
            Y.MM(bVar.page);
            Y.fo("isCache", String.valueOf(bVar.dMA));
            Y.MJ(bVar.dMB);
            Y.MK(bVar.dMC);
            Y.ML(bVar.fid);
            Y.fo("vc", bVar.dMD);
            Y.ME(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dcY().a(Y);
            bVar.Xw = true;
            dME.add(bVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.Xw && !wJ(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 3, bVar.pn);
            c.MM(bVar.page);
            c.fo("isCache", bVar.dMA);
            c.MJ(bVar.dMB);
            c.MK(bVar.dMC);
            c.ML(bVar.fid);
            c.fo("vc", bVar.dMD);
            c.ME(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dcY().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            bVar.Xw = true;
            dME.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pN() != null && !dVar.Xw && !TextUtils.isEmpty(dVar.pN().ext) && !wJ(dVar.pN().ext)) {
            com.baidu.tieba.recapp.report.d.dcY().a(com.baidu.tieba.recapp.report.g.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Xw = true;
            dME.add(dVar.pN().ext);
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Xw && !wJ(bVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.c cVar = new com.baidu.tieba.recapp.report.c();
            cVar.DQ(i2);
            if ("PB_BANNER".equals(bVar.page)) {
                cVar.DR(-1);
                cVar.setPageNumber(-1);
            } else {
                cVar.DR(i2);
                cVar.setPageNumber(bVar.pn);
            }
            cVar.MM(bVar.page);
            cVar.MJ(bVar.dMB);
            cVar.MK(bVar.dMC);
            cVar.ML(bVar.fid);
            cVar.fo("vc", bVar.dMD);
            cVar.ME(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dcY().a(cVar);
            bVar.Xw = true;
            dME.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.n nVar) {
        b bVar;
        if (nVar != null && nVar.dkV() != null && (bVar = nVar.dkV().advertAppContext) != null && !bVar.Xw && !wJ(bVar.extensionInfo)) {
            nVar.dNi = bVar.dMB;
            nVar.dNj = bVar.dMC;
            nVar.forumId = bVar.fid;
            int i = 3;
            if (nVar != null && nVar.dkW() != null && nVar.dkW().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, i);
            c.ME(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dcY().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(nVar.pM()));
            bVar.Xw = true;
            dME.add(bVar.extensionInfo);
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Xw && !wJ(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c Y = com.baidu.tieba.recapp.report.g.Y(z ? 13 : 3, i, bVar.pn);
            Y.MM(bVar.page);
            Y.ME(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dcY().a(Y);
            bVar.Xw = true;
            dME.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.bSf() != null && dVar.bSf().advertAppContext != null && !dVar.bSf().advertAppContext.Xw && !wJ(dVar.bSf().advertAppContext.extensionInfo)) {
            dVar.bSf().page = dVar.bSf().advertAppContext.page;
            com.baidu.tbadk.distribute.a.biw().a(dVar.bSf(), "", 0L, dVar.bSf().page, "show", dVar.bSf().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c d = com.baidu.tieba.recapp.report.g.d(dVar.bSf(), 3, dVar.bSf().advertAppContext.pn);
            d.ME(dVar.bSf().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.d.dcY().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.bSf()));
            dVar.bSf().advertAppContext.Xw = true;
            dME.add(dVar.bSf().advertAppContext.extensionInfo);
        }
    }

    private static boolean wJ(String str) {
        return dME.contains(str);
    }
}
