package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    protected static final Set<String> eyw = new HashSet();
    public boolean YN;
    public String extensionInfo;
    public String eys;
    public String eyt;
    public String eyu;
    public String eyv;
    public String fid;
    public String page;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.YN && !AM(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c aa = com.baidu.tieba.recapp.report.g.aa(z ? 13 : 3, i, bVar.pn);
            aa.RM(bVar.page);
            aa.ge("isCache", String.valueOf(bVar.eys));
            aa.RJ(bVar.eyt);
            aa.RK(bVar.eyu);
            aa.RL(bVar.fid);
            aa.ge("vc", bVar.eyv);
            aa.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dBp().a(aa);
            bVar.YN = true;
            eyw.add(bVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.YN && !AM(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 3, bVar.pn);
            c.RM(bVar.page);
            c.ge("isCache", bVar.eys);
            c.RJ(bVar.eyt);
            c.RK(bVar.eyu);
            c.RL(bVar.fid);
            c.ge("vc", bVar.eyv);
            c.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dBp().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(advertAppInfo));
            bVar.YN = true;
            eyw.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.rr() != null && !dVar.YN && !TextUtils.isEmpty(dVar.rr().ext) && !AM(dVar.rr().ext)) {
            com.baidu.tieba.recapp.report.d.dBp().a(com.baidu.tieba.recapp.report.g.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.YN = true;
            eyw.add(dVar.rr().ext);
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.YN && !AM(bVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.c cVar = new com.baidu.tieba.recapp.report.c();
            cVar.HY(i2);
            if ("PB_BANNER".equals(bVar.page)) {
                cVar.HZ(-1);
                cVar.setPageNumber(-1);
            } else {
                cVar.HZ(i2);
                cVar.setPageNumber(bVar.pn);
            }
            cVar.RM(bVar.page);
            cVar.RJ(bVar.eyt);
            cVar.RK(bVar.eyu);
            cVar.RL(bVar.fid);
            cVar.ge("vc", bVar.eyv);
            cVar.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dBp().a(cVar);
            bVar.YN = true;
            eyw.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.n nVar) {
        b bVar;
        if (nVar != null && nVar.dJN() != null && (bVar = nVar.dJN().advertAppContext) != null && !bVar.YN && !AM(bVar.extensionInfo)) {
            nVar.eza = bVar.eyt;
            nVar.ezb = bVar.eyu;
            nVar.forumId = bVar.fid;
            int i = 3;
            if (nVar != null && nVar.dJO() != null && nVar.dJO().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, i);
            c.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dBp().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(nVar.rq()));
            bVar.YN = true;
            eyw.add(bVar.extensionInfo);
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.YN && !AM(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c aa = com.baidu.tieba.recapp.report.g.aa(z ? 13 : 3, i, bVar.pn);
            aa.RM(bVar.page);
            aa.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dBp().a(aa);
            bVar.YN = true;
            eyw.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.e eVar) {
        if (eVar != null && eVar.coL() != null && eVar.coL().advertAppContext != null && !eVar.coL().advertAppContext.YN && !AM(eVar.coL().advertAppContext.extensionInfo)) {
            eVar.coL().page = eVar.coL().advertAppContext.page;
            com.baidu.tbadk.distribute.a.bzk().a(eVar.coL(), "", 0L, eVar.coL().page, "show", eVar.coL().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c d = com.baidu.tieba.recapp.report.g.d(eVar.coL(), 3, eVar.coL().advertAppContext.pn);
            d.setExtInfo(eVar.coL().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.d.dBp().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(eVar.coL()));
            eVar.coL().advertAppContext.YN = true;
            eyw.add(eVar.coL().advertAppContext.extensionInfo);
        }
    }

    private static boolean AM(String str) {
        return eyw.contains(str);
    }
}
