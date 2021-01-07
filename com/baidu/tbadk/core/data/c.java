package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    protected static final Set<String> eNy = new HashSet();
    public boolean aay;
    public String eNu;
    public String eNv;
    public String eNw;
    public String eNx;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.aay && !AL(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ad = com.baidu.tieba.recapp.report.h.ad(z ? 13 : 3, i, cVar.pn);
            ad.Sd(cVar.page);
            ad.gg("isCache", String.valueOf(cVar.eNu));
            ad.Sa(cVar.eNv);
            ad.Sb(cVar.eNw);
            ad.Sc(cVar.fid);
            ad.gg("vc", cVar.eNx);
            ad.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dFW().a(ad);
            cVar.aay = true;
            eNy.add(cVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.aay && !AL(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(advertAppInfo, 3, cVar.pn);
            b2.Sd(cVar.page);
            b2.gg("isCache", cVar.eNu);
            b2.Sa(cVar.eNv);
            b2.Sb(cVar.eNw);
            b2.Sc(cVar.fid);
            b2.gg("vc", cVar.eNx);
            b2.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dFW().a(b2);
            com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(advertAppInfo));
            cVar.aay = true;
            eNy.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.qV() != null && !dVar.aay && !TextUtils.isEmpty(dVar.qV().ext) && !AL(dVar.qV().ext)) {
            com.baidu.tieba.recapp.report.e.dFW().a(com.baidu.tieba.recapp.report.h.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.a.c.b(dVar);
            dVar.aay = true;
            eNy.add(dVar.qV().ext);
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.aay && !AL(cVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.c cVar2 = new com.baidu.tieba.recapp.report.c();
            cVar2.Jk(i2);
            if ("PB_BANNER".equals(cVar.page)) {
                cVar2.Jl(-1);
                cVar2.setPageNumber(-1);
            } else {
                cVar2.Jl(i2);
                cVar2.setPageNumber(cVar.pn);
            }
            cVar2.Sd(cVar.page);
            cVar2.Sa(cVar.eNv);
            cVar2.Sb(cVar.eNw);
            cVar2.Sc(cVar.fid);
            cVar2.gg("vc", cVar.eNx);
            cVar2.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dFW().a(cVar2);
            cVar.aay = true;
            eNy.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.o oVar) {
        c cVar;
        if (oVar != null && oVar.dOS() != null && (cVar = oVar.dOS().advertAppContext) != null && !cVar.aay && !AL(cVar.extensionInfo)) {
            oVar.eOf = cVar.eNv;
            oVar.eOg = cVar.eNw;
            oVar.forumId = cVar.fid;
            int i = 3;
            if (oVar != null && oVar.dOT() != null && oVar.dOT().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(oVar, i);
            b2.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dFW().a(b2);
            com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(oVar.qU()));
            cVar.aay = true;
            eNy.add(cVar.extensionInfo);
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.aay && !AL(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ad = com.baidu.tieba.recapp.report.h.ad(z ? 13 : 3, i, cVar.pn);
            ad.Sd(cVar.page);
            ad.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dFW().a(ad);
            cVar.aay = true;
            eNy.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.cvy() != null && dVar.cvy().advertAppContext != null && !dVar.cvy().advertAppContext.aay && !AL(dVar.cvy().advertAppContext.extensionInfo)) {
            dVar.cvy().page = dVar.cvy().advertAppContext.page;
            com.baidu.tbadk.distribute.a.bEw().a(dVar.cvy(), "", 0L, dVar.cvy().page, "show", dVar.cvy().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.h.c(dVar.cvy(), 3, dVar.cvy().advertAppContext.pn);
            c.setExtInfo(dVar.cvy().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.e.dFW().a(c);
            com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(dVar.cvy()));
            dVar.cvy().advertAppContext.aay = true;
            eNy.add(dVar.cvy().advertAppContext.extensionInfo);
        }
    }

    private static boolean AL(String str) {
        return eNy.contains(str);
    }
}
