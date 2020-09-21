package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    protected static final Set<String> dYb = new HashSet();
    public boolean Yw;
    public String dXX;
    public String dXY;
    public String dXZ;
    public String dYa;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Yw && !zt(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c Z = com.baidu.tieba.recapp.report.g.Z(z ? 13 : 3, i, bVar.pn);
            Z.Qj(bVar.page);
            Z.fS("isCache", String.valueOf(bVar.dXX));
            Z.Qg(bVar.dXY);
            Z.Qh(bVar.dXZ);
            Z.Qi(bVar.fid);
            Z.fS("vc", bVar.dYa);
            Z.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.drV().a(Z);
            bVar.Yw = true;
            dYb.add(bVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.Yw && !zt(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 3, bVar.pn);
            c.Qj(bVar.page);
            c.fS("isCache", bVar.dXX);
            c.Qg(bVar.dXY);
            c.Qh(bVar.dXZ);
            c.Qi(bVar.fid);
            c.fS("vc", bVar.dYa);
            c.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.drV().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(advertAppInfo));
            bVar.Yw = true;
            dYb.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.rr() != null && !dVar.Yw && !TextUtils.isEmpty(dVar.rr().ext) && !zt(dVar.rr().ext)) {
            com.baidu.tieba.recapp.report.d.drV().a(com.baidu.tieba.recapp.report.g.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Yw = true;
            dYb.add(dVar.rr().ext);
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Yw && !zt(bVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.c cVar = new com.baidu.tieba.recapp.report.c();
            cVar.GM(i2);
            if ("PB_BANNER".equals(bVar.page)) {
                cVar.GN(-1);
                cVar.setPageNumber(-1);
            } else {
                cVar.GN(i2);
                cVar.setPageNumber(bVar.pn);
            }
            cVar.Qj(bVar.page);
            cVar.Qg(bVar.dXY);
            cVar.Qh(bVar.dXZ);
            cVar.Qi(bVar.fid);
            cVar.fS("vc", bVar.dYa);
            cVar.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.drV().a(cVar);
            bVar.Yw = true;
            dYb.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.n nVar) {
        b bVar;
        if (nVar != null && nVar.dAr() != null && (bVar = nVar.dAr().advertAppContext) != null && !bVar.Yw && !zt(bVar.extensionInfo)) {
            nVar.dYF = bVar.dXY;
            nVar.dYG = bVar.dXZ;
            nVar.forumId = bVar.fid;
            int i = 3;
            if (nVar != null && nVar.dAs() != null && nVar.dAs().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, i);
            c.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.drV().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(nVar.rq()));
            bVar.Yw = true;
            dYb.add(bVar.extensionInfo);
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Yw && !zt(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c Z = com.baidu.tieba.recapp.report.g.Z(z ? 13 : 3, i, bVar.pn);
            Z.Qj(bVar.page);
            Z.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.drV().a(Z);
            bVar.Yw = true;
            dYb.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.e eVar) {
        if (eVar != null && eVar.cfH() != null && eVar.cfH().advertAppContext != null && !eVar.cfH().advertAppContext.Yw && !zt(eVar.cfH().advertAppContext.extensionInfo)) {
            eVar.cfH().page = eVar.cfH().advertAppContext.page;
            com.baidu.tbadk.distribute.a.bsi().a(eVar.cfH(), "", 0L, eVar.cfH().page, "show", eVar.cfH().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c d = com.baidu.tieba.recapp.report.g.d(eVar.cfH(), 3, eVar.cfH().advertAppContext.pn);
            d.setExtInfo(eVar.cfH().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.d.drV().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(eVar.cfH()));
            eVar.cfH().advertAppContext.Yw = true;
            dYb.add(eVar.cfH().advertAppContext.extensionInfo);
        }
    }

    private static boolean zt(String str) {
        return dYb.contains(str);
    }
}
