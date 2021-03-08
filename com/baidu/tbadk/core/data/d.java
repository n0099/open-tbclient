package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class d {
    protected static final Set<String> eMA = new HashSet();
    public boolean abM;
    public String eMw;
    public String eMx;
    public String eMy;
    public String eMz;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(d dVar, int i, boolean z) {
        if (dVar != null && !dVar.abM && !zY(dVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ab = com.baidu.tieba.recapp.report.h.ab(z ? 13 : 3, i, dVar.pn);
            ab.Si(dVar.page);
            ab.gm("isCache", String.valueOf(dVar.eMw));
            ab.Sf(dVar.eMx);
            ab.Sg(dVar.eMy);
            ab.Sh(dVar.fid);
            ab.gm("vc", dVar.eMz);
            ab.setExtInfo(dVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dEC().a(ab);
            dVar.abM = true;
            eMA.add(dVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        d dVar;
        if (advertAppInfo != null && (dVar = advertAppInfo.advertAppContext) != null && !dVar.abM && !zY(dVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c b = com.baidu.tieba.recapp.report.h.b(advertAppInfo, 3, dVar.pn);
            b.Si(dVar.page);
            b.gm("isCache", dVar.eMw);
            b.Sf(dVar.eMx);
            b.Sg(dVar.eMy);
            b.Sh(dVar.fid);
            b.gm("vc", dVar.eMz);
            b.setExtInfo(dVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dEC().a(b);
            com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(advertAppInfo));
            dVar.abM = true;
            eMA.add(dVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.qT() != null && !dVar.abM && !TextUtils.isEmpty(dVar.qT().ext) && !zY(dVar.qT().ext)) {
            com.baidu.tieba.recapp.report.e.dEC().a(com.baidu.tieba.recapp.report.h.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.a.c.b(dVar);
            dVar.abM = true;
            eMA.add(dVar.qT().ext);
        }
    }

    public static void b(d dVar, int i, boolean z) {
        if (dVar != null && !dVar.abM && !zY(dVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.c cVar = new com.baidu.tieba.recapp.report.c();
            cVar.Ia(i2);
            if ("PB_BANNER".equals(dVar.page)) {
                cVar.Ib(-1);
                cVar.setPageNumber(-1);
            } else {
                cVar.Ib(i);
                cVar.setPageNumber(dVar.pn);
            }
            cVar.Si(dVar.page);
            cVar.Sf(dVar.eMx);
            cVar.Sg(dVar.eMy);
            cVar.Sh(dVar.fid);
            cVar.gm("vc", dVar.eMz);
            cVar.setExtInfo(dVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dEC().a(cVar);
            dVar.abM = true;
            eMA.add(dVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (oVar != null && oVar.dNC() != null) {
            d dVar = oVar.dNC().advertAppContext;
            if (oVar.eNm || (dVar != null && !dVar.abM && !zY(dVar.extensionInfo))) {
                oVar.eNg = dVar.eMx;
                oVar.eNh = dVar.eMy;
                oVar.forumId = dVar.fid;
                int i = 3;
                if (oVar != null && oVar.dND() != null && oVar.dND().forFree()) {
                    i = 103;
                }
                com.baidu.tieba.recapp.report.c b = com.baidu.tieba.recapp.report.h.b(oVar, i);
                b.setExtInfo(dVar.extensionInfo);
                com.baidu.tieba.recapp.report.e.dEC().a(b);
                if (!oVar.eNm) {
                    com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(oVar.qS()));
                }
                dVar.abM = true;
                eMA.add(dVar.extensionInfo);
            }
        }
    }

    public static void c(d dVar, int i, boolean z) {
        if (dVar != null && !dVar.abM && !zY(dVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ab = com.baidu.tieba.recapp.report.h.ab(z ? 13 : 3, i, dVar.pn);
            ab.Si(dVar.page);
            ab.setExtInfo(dVar.extensionInfo);
            com.baidu.tieba.recapp.report.e.dEC().a(ab);
            dVar.abM = true;
            eMA.add(dVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.ctf() != null && dVar.ctf().advertAppContext != null && !dVar.ctf().advertAppContext.abM && !zY(dVar.ctf().advertAppContext.extensionInfo)) {
            dVar.ctf().page = dVar.ctf().advertAppContext.page;
            com.baidu.tbadk.distribute.a.bAX().a(dVar.ctf(), "", 0L, dVar.ctf().page, "show", dVar.ctf().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.h.c(dVar.ctf(), 3, dVar.ctf().advertAppContext.pn);
            c.setExtInfo(dVar.ctf().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.e.dEC().a(c);
            com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(dVar.ctf()));
            dVar.ctf().advertAppContext.abM = true;
            eMA.add(dVar.ctf().advertAppContext.extensionInfo);
        }
    }

    private static boolean zY(String str) {
        return eMA.contains(str);
    }
}
