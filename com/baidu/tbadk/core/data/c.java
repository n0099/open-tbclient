package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    protected static final Set<String> eIN = new HashSet();
    public boolean aaw;
    public String eIJ;
    public String eIK;
    public String eIL;
    public String eIM;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.aaw && !zA(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ad = com.baidu.tieba.recapp.report.h.ad(z ? 13 : 3, i, cVar.pn);
            ad.QV(cVar.page);
            ad.gf("isCache", String.valueOf(cVar.eIJ));
            ad.QS(cVar.eIK);
            ad.QT(cVar.eIL);
            ad.QU(cVar.fid);
            ad.gf("vc", cVar.eIM);
            ad.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dCe().a(ad);
            cVar.aaw = true;
            eIN.add(cVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.aaw && !zA(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(advertAppInfo, 3, cVar.pn);
            b2.QV(cVar.page);
            b2.gf("isCache", cVar.eIJ);
            b2.QS(cVar.eIK);
            b2.QT(cVar.eIL);
            b2.QU(cVar.fid);
            b2.gf("vc", cVar.eIM);
            b2.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dCe().a(b2);
            com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(advertAppInfo));
            cVar.aaw = true;
            eIN.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.qV() != null && !dVar.aaw && !TextUtils.isEmpty(dVar.qV().ext) && !zA(dVar.qV().ext)) {
            com.baidu.tieba.recapp.report.e.dCe().a(com.baidu.tieba.recapp.report.h.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.a.c.b(dVar);
            dVar.aaw = true;
            eIN.add(dVar.qV().ext);
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.aaw && !zA(cVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.c cVar2 = new com.baidu.tieba.recapp.report.c();
            cVar2.HD(i2);
            if ("PB_BANNER".equals(cVar.page)) {
                cVar2.HE(-1);
                cVar2.setPageNumber(-1);
            } else {
                cVar2.HE(i2);
                cVar2.setPageNumber(cVar.pn);
            }
            cVar2.QV(cVar.page);
            cVar2.QS(cVar.eIK);
            cVar2.QT(cVar.eIL);
            cVar2.QU(cVar.fid);
            cVar2.gf("vc", cVar.eIM);
            cVar2.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dCe().a(cVar2);
            cVar.aaw = true;
            eIN.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.o oVar) {
        c cVar;
        if (oVar != null && oVar.dLa() != null && (cVar = oVar.dLa().advertAppContext) != null && !cVar.aaw && !zA(cVar.extensionInfo)) {
            oVar.eJu = cVar.eIK;
            oVar.eJv = cVar.eIL;
            oVar.forumId = cVar.fid;
            int i = 3;
            if (oVar != null && oVar.dLb() != null && oVar.dLb().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(oVar, i);
            b2.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dCe().a(b2);
            com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(oVar.qU()));
            cVar.aaw = true;
            eIN.add(cVar.extensionInfo);
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.aaw && !zA(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ad = com.baidu.tieba.recapp.report.h.ad(z ? 13 : 3, i, cVar.pn);
            ad.QV(cVar.page);
            ad.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dCe().a(ad);
            cVar.aaw = true;
            eIN.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.crG() != null && dVar.crG().advertAppContext != null && !dVar.crG().advertAppContext.aaw && !zA(dVar.crG().advertAppContext.extensionInfo)) {
            dVar.crG().page = dVar.crG().advertAppContext.page;
            com.baidu.tbadk.distribute.a.bAC().a(dVar.crG(), "", 0L, dVar.crG().page, "show", dVar.crG().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.h.c(dVar.crG(), 3, dVar.crG().advertAppContext.pn);
            c.setExtInfo(dVar.crG().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.e.dCe().a(c);
            com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(dVar.crG()));
            dVar.crG().advertAppContext.aaw = true;
            eIN.add(dVar.crG().advertAppContext.extensionInfo);
        }
    }

    private static boolean zA(String str) {
        return eIN.contains(str);
    }
}
