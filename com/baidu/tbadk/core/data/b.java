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
            ab.LD(bVar.page);
            ab.ff("isCache", String.valueOf(bVar.dzY));
            ab.LA(bVar.dzZ);
            ab.LB(bVar.dAa);
            ab.LC(bVar.fid);
            ab.ff("vc", bVar.dAb);
            ab.Lv(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cVA().a(ab);
            bVar.WZ = true;
            dAc.add(bVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.WZ && !vq(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 3, bVar.pn);
            c.LD(bVar.page);
            c.ff("isCache", bVar.dzY);
            c.LA(bVar.dzZ);
            c.LB(bVar.dAa);
            c.LC(bVar.fid);
            c.ff("vc", bVar.dAb);
            c.Lv(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cVA().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            bVar.WZ = true;
            dAc.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pv() != null && !dVar.WZ && !TextUtils.isEmpty(dVar.pv().ext) && !vq(dVar.pv().ext)) {
            com.baidu.tieba.recapp.report.d.cVA().a(com.baidu.tieba.recapp.report.g.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.WZ = true;
            dAc.add(dVar.pv().ext);
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.WZ && !vq(bVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.c cVar = new com.baidu.tieba.recapp.report.c();
            cVar.Cs(i2);
            if ("PB_BANNER".equals(bVar.page)) {
                cVar.Ct(-1);
                cVar.setPageNumber(-1);
            } else {
                cVar.Ct(i2);
                cVar.setPageNumber(bVar.pn);
            }
            cVar.LD(bVar.page);
            cVar.LA(bVar.dzZ);
            cVar.LB(bVar.dAa);
            cVar.LC(bVar.fid);
            cVar.ff("vc", bVar.dAb);
            cVar.Lv(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cVA().a(cVar);
            bVar.WZ = true;
            dAc.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.n nVar) {
        b bVar;
        if (nVar != null && nVar.ddx() != null && (bVar = nVar.ddx().advertAppContext) != null && !bVar.WZ && !vq(bVar.extensionInfo)) {
            nVar.dAG = bVar.dzZ;
            nVar.dAH = bVar.dAa;
            nVar.forumId = bVar.fid;
            int i = 3;
            if (nVar != null && nVar.ddy() != null && nVar.ddy().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, i);
            c.Lv(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cVA().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(nVar.pu()));
            bVar.WZ = true;
            dAc.add(bVar.extensionInfo);
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.WZ && !vq(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ab = com.baidu.tieba.recapp.report.g.ab(z ? 13 : 3, i, bVar.pn);
            ab.LD(bVar.page);
            ab.Lv(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.cVA().a(ab);
            bVar.WZ = true;
            dAc.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.bLJ() != null && dVar.bLJ().advertAppContext != null && !dVar.bLJ().advertAppContext.WZ && !vq(dVar.bLJ().advertAppContext.extensionInfo)) {
            dVar.bLJ().page = dVar.bLJ().advertAppContext.page;
            com.baidu.tbadk.distribute.a.bcL().a(dVar.bLJ(), "", 0L, dVar.bLJ().page, "show", dVar.bLJ().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c d = com.baidu.tieba.recapp.report.g.d(dVar.bLJ(), 3, dVar.bLJ().advertAppContext.pn);
            d.Lv(dVar.bLJ().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.d.cVA().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.bLJ()));
            dVar.bLJ().advertAppContext.WZ = true;
            dAc.add(dVar.bLJ().advertAppContext.extensionInfo);
        }
    }

    private static boolean vq(String str) {
        return dAc.contains(str);
    }
}
