package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    protected static final Set<String> dlW = new HashSet();
    public boolean WI;
    public String dlS;
    public String dlT;
    public String dlU;
    public String dlV;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.WI && !tH(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ab = com.baidu.tieba.recapp.report.g.ab(z ? 13 : 3, i, cVar.pn);
            ab.JN(cVar.page);
            ab.eE("isCache", String.valueOf(cVar.dlS));
            ab.JK(cVar.dlT);
            ab.JL(cVar.dlU);
            ab.JM(cVar.fid);
            ab.eE("vc", cVar.dlV);
            ab.JF(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cOl().a(ab);
            cVar.WI = true;
            dlW.add(cVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.WI && !tH(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 3, cVar.pn);
            c.JN(cVar.page);
            c.eE("isCache", cVar.dlS);
            c.JK(cVar.dlT);
            c.JL(cVar.dlU);
            c.JM(cVar.fid);
            c.eE("vc", cVar.dlV);
            c.JF(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cOl().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.WI = true;
            dlW.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pp() != null && !dVar.WI && !TextUtils.isEmpty(dVar.pp().ext) && !tH(dVar.pp().ext)) {
            com.baidu.tieba.recapp.report.d.cOl().a(com.baidu.tieba.recapp.report.g.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.WI = true;
            dlW.add(dVar.pp().ext);
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.WI && !tH(cVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.c cVar2 = new com.baidu.tieba.recapp.report.c();
            cVar2.BG(i2);
            if ("PB_BANNER".equals(cVar.page)) {
                cVar2.BH(-1);
                cVar2.setPageNumber(-1);
            } else {
                cVar2.BH(i2);
                cVar2.setPageNumber(cVar.pn);
            }
            cVar2.JN(cVar.page);
            cVar2.JK(cVar.dlT);
            cVar2.JL(cVar.dlU);
            cVar2.JM(cVar.fid);
            cVar2.eE("vc", cVar.dlV);
            cVar2.JF(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cOl().a(cVar2);
            cVar.WI = true;
            dlW.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.cWf() != null && (cVar = mVar.cWf().advertAppContext) != null && !cVar.WI && !tH(cVar.extensionInfo)) {
            mVar.dmA = cVar.dlT;
            mVar.dmB = cVar.dlU;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.cWg() != null && mVar.cWg().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(mVar, i);
            c.JF(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cOl().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.po()));
            cVar.WI = true;
            dlW.add(cVar.extensionInfo);
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.WI && !tH(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ab = com.baidu.tieba.recapp.report.g.ab(z ? 13 : 3, i, cVar.pn);
            ab.JN(cVar.page);
            ab.JF(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cOl().a(ab);
            cVar.WI = true;
            dlW.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.bFo() != null && dVar.bFo().advertAppContext != null && !dVar.bFo().advertAppContext.WI && !tH(dVar.bFo().advertAppContext.extensionInfo)) {
            dVar.bFo().page = dVar.bFo().advertAppContext.page;
            com.baidu.tbadk.distribute.a.aWD().a(dVar.bFo(), "", 0L, dVar.bFo().page, "show", dVar.bFo().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c d = com.baidu.tieba.recapp.report.g.d(dVar.bFo(), 3, dVar.bFo().advertAppContext.pn);
            d.JF(dVar.bFo().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.d.cOl().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.bFo()));
            dVar.bFo().advertAppContext.WI = true;
            dlW.add(dVar.bFo().advertAppContext.extensionInfo);
        }
    }

    private static boolean tH(String str) {
        return dlW.contains(str);
    }
}
