package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    protected static final Set<String> dAc = new HashSet();
    public boolean WZ;
    public String dAa;
    public String dAb;
    public String dzY;
    public String dzZ;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.WZ && !vq(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ab = com.baidu.tieba.recapp.report.g.ab(z ? 13 : 3, i, bVar.pn);
            ab.LC(bVar.page);
            ab.ff("isCache", String.valueOf(bVar.dzY));
            ab.Lz(bVar.dzZ);
            ab.LA(bVar.dAa);
            ab.LB(bVar.fid);
            ab.ff("vc", bVar.dAb);
            ab.Lu(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cVk().a(ab);
            bVar.WZ = true;
            dAc.add(bVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.WZ && !vq(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 3, bVar.pn);
            c.LC(bVar.page);
            c.ff("isCache", bVar.dzY);
            c.Lz(bVar.dzZ);
            c.LA(bVar.dAa);
            c.LB(bVar.fid);
            c.ff("vc", bVar.dAb);
            c.Lu(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cVk().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            bVar.WZ = true;
            dAc.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pv() != null && !dVar.WZ && !TextUtils.isEmpty(dVar.pv().ext) && !vq(dVar.pv().ext)) {
            com.baidu.tieba.recapp.report.d.cVk().a(com.baidu.tieba.recapp.report.g.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.WZ = true;
            dAc.add(dVar.pv().ext);
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.WZ && !vq(bVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.c cVar = new com.baidu.tieba.recapp.report.c();
            cVar.Cq(i2);
            if ("PB_BANNER".equals(bVar.page)) {
                cVar.Cr(-1);
                cVar.setPageNumber(-1);
            } else {
                cVar.Cr(i2);
                cVar.setPageNumber(bVar.pn);
            }
            cVar.LC(bVar.page);
            cVar.Lz(bVar.dzZ);
            cVar.LA(bVar.dAa);
            cVar.LB(bVar.fid);
            cVar.ff("vc", bVar.dAb);
            cVar.Lu(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cVk().a(cVar);
            bVar.WZ = true;
            dAc.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.n nVar) {
        b bVar;
        if (nVar != null && nVar.ddi() != null && (bVar = nVar.ddi().advertAppContext) != null && !bVar.WZ && !vq(bVar.extensionInfo)) {
            nVar.dAG = bVar.dzZ;
            nVar.dAH = bVar.dAa;
            nVar.forumId = bVar.fid;
            int i = 3;
            if (nVar != null && nVar.ddj() != null && nVar.ddj().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, i);
            c.Lu(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cVk().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(nVar.pu()));
            bVar.WZ = true;
            dAc.add(bVar.extensionInfo);
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.WZ && !vq(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ab = com.baidu.tieba.recapp.report.g.ab(z ? 13 : 3, i, bVar.pn);
            ab.LC(bVar.page);
            ab.Lu(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cVk().a(ab);
            bVar.WZ = true;
            dAc.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.bLH() != null && dVar.bLH().advertAppContext != null && !dVar.bLH().advertAppContext.WZ && !vq(dVar.bLH().advertAppContext.extensionInfo)) {
            dVar.bLH().page = dVar.bLH().advertAppContext.page;
            com.baidu.tbadk.distribute.a.bcK().a(dVar.bLH(), "", 0L, dVar.bLH().page, "show", dVar.bLH().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c d = com.baidu.tieba.recapp.report.g.d(dVar.bLH(), 3, dVar.bLH().advertAppContext.pn);
            d.Lu(dVar.bLH().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.d.cVk().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.bLH()));
            dVar.bLH().advertAppContext.WZ = true;
            dAc.add(dVar.bLH().advertAppContext.extensionInfo);
        }
    }

    private static boolean vq(String str) {
        return dAc.contains(str);
    }
}
