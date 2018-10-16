package com.baidu.tbadk.core.data;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class b {
    public boolean RQ;
    public String akG;
    public String akH;
    public String akI;
    public String akJ;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.RQ) {
            com.baidu.tieba.recapp.report.b aa = com.baidu.tieba.recapp.report.f.aa(z ? 13 : 3, i, bVar.pn);
            aa.uo(bVar.page);
            aa.cv("isCache", String.valueOf(bVar.akG));
            aa.ul(bVar.akH);
            aa.um(bVar.akI);
            aa.un(bVar.fid);
            aa.cv("vc", bVar.akJ);
            aa.uh(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.buf().a(aa);
            bVar.RQ = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.RQ) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, bVar.pn);
            c.uo(bVar.page);
            c.cv("isCache", bVar.akG);
            c.ul(bVar.akH);
            c.um(bVar.akI);
            c.un(bVar.fid);
            c.cv("vc", bVar.akJ);
            c.uh(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.buf().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            bVar.RQ = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.py() != null && !dVar.RQ && !TextUtils.isEmpty(dVar.py().ext)) {
            com.baidu.tieba.recapp.report.c.buf().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.RQ = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.RQ) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar2 = new com.baidu.tieba.recapp.report.b();
            bVar2.tg(i2);
            if ("PB_BANNER".equals(bVar.page)) {
                bVar2.th(-1);
                bVar2.setPageNumber(-1);
            } else {
                bVar2.th(i2);
                bVar2.setPageNumber(bVar.pn);
            }
            bVar2.uo(bVar.page);
            bVar2.ul(bVar.akH);
            bVar2.um(bVar.akI);
            bVar2.un(bVar.fid);
            bVar2.cv("vc", bVar.akJ);
            bVar2.uh(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.buf().a(bVar2);
            bVar.RQ = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bBP() != null && (bVar = lVar.bBP().advertAppContext) != null && !bVar.RQ) {
            lVar.alq = bVar.akH;
            lVar.alr = bVar.akI;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.bBQ() != null && lVar.bBQ().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(lVar, i);
            c.uh(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.buf().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(lVar.px()));
            bVar.RQ = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.RQ) {
            com.baidu.tieba.recapp.report.b aa = com.baidu.tieba.recapp.report.f.aa(z ? 13 : 3, i, bVar.pn);
            aa.uo(bVar.page);
            aa.uh(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.buf().a(aa);
            bVar.RQ = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.aoG() != null && dVar.aoG().advertAppContext != null && !dVar.aoG().advertAppContext.RQ) {
            dVar.aoG().page = dVar.aoG().advertAppContext.page;
            com.baidu.tbadk.distribute.a.Ku().a(dVar.aoG(), "", 0L, dVar.aoG().page, "show", dVar.aoG().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.aoG(), 3, dVar.aoG().advertAppContext.pn);
            d.uh(dVar.aoG().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.buf().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.aoG()));
            dVar.aoG().advertAppContext.RQ = true;
        }
    }
}
