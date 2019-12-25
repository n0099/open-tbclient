package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    protected static final Set<String> cIo = new HashSet();
    public boolean CN;
    public String cIk;
    public String cIl;
    public String cIm;
    public String cIn;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.CN && !sa(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b X = com.baidu.tieba.recapp.report.f.X(z ? 13 : 3, i, cVar.pn);
            X.HK(cVar.page);
            X.eg("isCache", String.valueOf(cVar.cIk));
            X.HH(cVar.cIl);
            X.HI(cVar.cIm);
            X.HJ(cVar.fid);
            X.eg("vc", cVar.cIn);
            X.HC(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cAJ().a(X);
            cVar.CN = true;
            cIo.add(cVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.CN && !sa(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, cVar.pn);
            c.HK(cVar.page);
            c.eg("isCache", cVar.cIk);
            c.HH(cVar.cIl);
            c.HI(cVar.cIm);
            c.HJ(cVar.fid);
            c.eg("vc", cVar.cIn);
            c.HC(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cAJ().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.CN = true;
            cIo.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.kv() != null && !dVar.CN && !TextUtils.isEmpty(dVar.kv().ext) && !sa(dVar.kv().ext)) {
            com.baidu.tieba.recapp.report.c.cAJ().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.CN = true;
            cIo.add(dVar.kv().ext);
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.CN && !sa(cVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar = new com.baidu.tieba.recapp.report.b();
            bVar.AK(i2);
            if ("PB_BANNER".equals(cVar.page)) {
                bVar.AL(-1);
                bVar.setPageNumber(-1);
            } else {
                bVar.AL(i2);
                bVar.setPageNumber(cVar.pn);
            }
            bVar.HK(cVar.page);
            bVar.HH(cVar.cIl);
            bVar.HI(cVar.cIm);
            bVar.HJ(cVar.fid);
            bVar.eg("vc", cVar.cIn);
            bVar.HC(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cAJ().a(bVar);
            cVar.CN = true;
            cIo.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.cIh() != null && (cVar = mVar.cIh().advertAppContext) != null && !cVar.CN && !sa(cVar.extensionInfo)) {
            mVar.cIT = cVar.cIl;
            mVar.cIU = cVar.cIm;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.cIi() != null && mVar.cIi().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, i);
            c.HC(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cAJ().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.ku()));
            cVar.CN = true;
            cIo.add(cVar.extensionInfo);
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.CN && !sa(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b X = com.baidu.tieba.recapp.report.f.X(z ? 13 : 3, i, cVar.pn);
            X.HK(cVar.page);
            X.HC(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cAJ().a(X);
            cVar.CN = true;
            cIo.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.bsP() != null && dVar.bsP().advertAppContext != null && !dVar.bsP().advertAppContext.CN && !sa(dVar.bsP().advertAppContext.extensionInfo)) {
            dVar.bsP().page = dVar.bsP().advertAppContext.page;
            com.baidu.tbadk.distribute.a.aLq().a(dVar.bsP(), "", 0L, dVar.bsP().page, "show", dVar.bsP().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.bsP(), 3, dVar.bsP().advertAppContext.pn);
            d.HC(dVar.bsP().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.cAJ().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.bsP()));
            dVar.bsP().advertAppContext.CN = true;
            cIo.add(dVar.bsP().advertAppContext.extensionInfo);
        }
    }

    private static boolean sa(String str) {
        return cIo.contains(str);
    }
}
