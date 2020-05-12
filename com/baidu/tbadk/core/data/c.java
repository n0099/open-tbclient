package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    protected static final Set<String> dma = new HashSet();
    public boolean WL;
    public String dlW;
    public String dlX;
    public String dlY;
    public String dlZ;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.WL && !tK(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ab = com.baidu.tieba.recapp.report.g.ab(z ? 13 : 3, i, cVar.pn);
            ab.JQ(cVar.page);
            ab.eE("isCache", String.valueOf(cVar.dlW));
            ab.JN(cVar.dlX);
            ab.JO(cVar.dlY);
            ab.JP(cVar.fid);
            ab.eE("vc", cVar.dlZ);
            ab.JI(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cOj().a(ab);
            cVar.WL = true;
            dma.add(cVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.WL && !tK(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 3, cVar.pn);
            c.JQ(cVar.page);
            c.eE("isCache", cVar.dlW);
            c.JN(cVar.dlX);
            c.JO(cVar.dlY);
            c.JP(cVar.fid);
            c.eE("vc", cVar.dlZ);
            c.JI(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cOj().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.WL = true;
            dma.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pp() != null && !dVar.WL && !TextUtils.isEmpty(dVar.pp().ext) && !tK(dVar.pp().ext)) {
            com.baidu.tieba.recapp.report.d.cOj().a(com.baidu.tieba.recapp.report.g.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.WL = true;
            dma.add(dVar.pp().ext);
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.WL && !tK(cVar.extensionInfo)) {
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
            cVar2.JQ(cVar.page);
            cVar2.JN(cVar.dlX);
            cVar2.JO(cVar.dlY);
            cVar2.JP(cVar.fid);
            cVar2.eE("vc", cVar.dlZ);
            cVar2.JI(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cOj().a(cVar2);
            cVar.WL = true;
            dma.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.cWd() != null && (cVar = mVar.cWd().advertAppContext) != null && !cVar.WL && !tK(cVar.extensionInfo)) {
            mVar.dmE = cVar.dlX;
            mVar.dmF = cVar.dlY;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.cWe() != null && mVar.cWe().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(mVar, i);
            c.JI(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cOj().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.po()));
            cVar.WL = true;
            dma.add(cVar.extensionInfo);
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.WL && !tK(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ab = com.baidu.tieba.recapp.report.g.ab(z ? 13 : 3, i, cVar.pn);
            ab.JQ(cVar.page);
            ab.JI(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cOj().a(ab);
            cVar.WL = true;
            dma.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.bFn() != null && dVar.bFn().advertAppContext != null && !dVar.bFn().advertAppContext.WL && !tK(dVar.bFn().advertAppContext.extensionInfo)) {
            dVar.bFn().page = dVar.bFn().advertAppContext.page;
            com.baidu.tbadk.distribute.a.aWB().a(dVar.bFn(), "", 0L, dVar.bFn().page, "show", dVar.bFn().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c d = com.baidu.tieba.recapp.report.g.d(dVar.bFn(), 3, dVar.bFn().advertAppContext.pn);
            d.JI(dVar.bFn().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.d.cOj().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.bFn()));
            dVar.bFn().advertAppContext.WL = true;
            dma.add(dVar.bFn().advertAppContext.extensionInfo);
        }
    }

    private static boolean tK(String str) {
        return dma.contains(str);
    }
}
