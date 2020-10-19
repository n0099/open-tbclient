package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    protected static final Set<String> ekd = new HashSet();
    public boolean YM;
    public String ejZ;
    public String eka;
    public String ekb;
    public String ekc;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.YM && !Af(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c Z = com.baidu.tieba.recapp.report.g.Z(z ? 13 : 3, i, bVar.pn);
            Z.QX(bVar.page);
            Z.fZ("isCache", String.valueOf(bVar.ejZ));
            Z.QU(bVar.eka);
            Z.QV(bVar.ekb);
            Z.QW(bVar.fid);
            Z.fZ("vc", bVar.ekc);
            Z.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dvG().a(Z);
            bVar.YM = true;
            ekd.add(bVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.YM && !Af(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 3, bVar.pn);
            c.QX(bVar.page);
            c.fZ("isCache", bVar.ejZ);
            c.QU(bVar.eka);
            c.QV(bVar.ekb);
            c.QW(bVar.fid);
            c.fZ("vc", bVar.ekc);
            c.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dvG().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(advertAppInfo));
            bVar.YM = true;
            ekd.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.rr() != null && !dVar.YM && !TextUtils.isEmpty(dVar.rr().ext) && !Af(dVar.rr().ext)) {
            com.baidu.tieba.recapp.report.d.dvG().a(com.baidu.tieba.recapp.report.g.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.YM = true;
            ekd.add(dVar.rr().ext);
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.YM && !Af(bVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.c cVar = new com.baidu.tieba.recapp.report.c();
            cVar.Hs(i2);
            if ("PB_BANNER".equals(bVar.page)) {
                cVar.Ht(-1);
                cVar.setPageNumber(-1);
            } else {
                cVar.Ht(i2);
                cVar.setPageNumber(bVar.pn);
            }
            cVar.QX(bVar.page);
            cVar.QU(bVar.eka);
            cVar.QV(bVar.ekb);
            cVar.QW(bVar.fid);
            cVar.fZ("vc", bVar.ekc);
            cVar.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dvG().a(cVar);
            bVar.YM = true;
            ekd.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.n nVar) {
        b bVar;
        if (nVar != null && nVar.dEd() != null && (bVar = nVar.dEd().advertAppContext) != null && !bVar.YM && !Af(bVar.extensionInfo)) {
            nVar.ekH = bVar.eka;
            nVar.ekI = bVar.ekb;
            nVar.forumId = bVar.fid;
            int i = 3;
            if (nVar != null && nVar.dEe() != null && nVar.dEe().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, i);
            c.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dvG().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(nVar.rq()));
            bVar.YM = true;
            ekd.add(bVar.extensionInfo);
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.YM && !Af(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c Z = com.baidu.tieba.recapp.report.g.Z(z ? 13 : 3, i, bVar.pn);
            Z.QX(bVar.page);
            Z.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dvG().a(Z);
            bVar.YM = true;
            ekd.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.e eVar) {
        if (eVar != null && eVar.cjd() != null && eVar.cjd().advertAppContext != null && !eVar.cjd().advertAppContext.YM && !Af(eVar.cjd().advertAppContext.extensionInfo)) {
            eVar.cjd().page = eVar.cjd().advertAppContext.page;
            com.baidu.tbadk.distribute.a.buS().a(eVar.cjd(), "", 0L, eVar.cjd().page, "show", eVar.cjd().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c d = com.baidu.tieba.recapp.report.g.d(eVar.cjd(), 3, eVar.cjd().advertAppContext.pn);
            d.setExtInfo(eVar.cjd().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.d.dvG().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(eVar.cjd()));
            eVar.cjd().advertAppContext.YM = true;
            ekd.add(eVar.cjd().advertAppContext.extensionInfo);
        }
    }

    private static boolean Af(String str) {
        return ekd.contains(str);
    }
}
