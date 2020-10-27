package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    protected static final Set<String> esC = new HashSet();
    public boolean YN;
    public String esA;
    public String esB;
    public String esy;
    public String esz;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.YN && !Ay(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c aa = com.baidu.tieba.recapp.report.g.aa(z ? 13 : 3, i, bVar.pn);
            aa.Rv(bVar.page);
            aa.ge("isCache", String.valueOf(bVar.esy));
            aa.Rs(bVar.esz);
            aa.Rt(bVar.esA);
            aa.Ru(bVar.fid);
            aa.ge("vc", bVar.esB);
            aa.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dyN().a(aa);
            bVar.YN = true;
            esC.add(bVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.YN && !Ay(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 3, bVar.pn);
            c.Rv(bVar.page);
            c.ge("isCache", bVar.esy);
            c.Rs(bVar.esz);
            c.Rt(bVar.esA);
            c.Ru(bVar.fid);
            c.ge("vc", bVar.esB);
            c.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dyN().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(advertAppInfo));
            bVar.YN = true;
            esC.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.rr() != null && !dVar.YN && !TextUtils.isEmpty(dVar.rr().ext) && !Ay(dVar.rr().ext)) {
            com.baidu.tieba.recapp.report.d.dyN().a(com.baidu.tieba.recapp.report.g.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.YN = true;
            esC.add(dVar.rr().ext);
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.YN && !Ay(bVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.c cVar = new com.baidu.tieba.recapp.report.c();
            cVar.HL(i2);
            if ("PB_BANNER".equals(bVar.page)) {
                cVar.HM(-1);
                cVar.setPageNumber(-1);
            } else {
                cVar.HM(i2);
                cVar.setPageNumber(bVar.pn);
            }
            cVar.Rv(bVar.page);
            cVar.Rs(bVar.esz);
            cVar.Rt(bVar.esA);
            cVar.Ru(bVar.fid);
            cVar.ge("vc", bVar.esB);
            cVar.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dyN().a(cVar);
            bVar.YN = true;
            esC.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.n nVar) {
        b bVar;
        if (nVar != null && nVar.dHl() != null && (bVar = nVar.dHl().advertAppContext) != null && !bVar.YN && !Ay(bVar.extensionInfo)) {
            nVar.eth = bVar.esz;
            nVar.eti = bVar.esA;
            nVar.forumId = bVar.fid;
            int i = 3;
            if (nVar != null && nVar.dHm() != null && nVar.dHm().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, i);
            c.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dyN().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(nVar.rq()));
            bVar.YN = true;
            esC.add(bVar.extensionInfo);
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.YN && !Ay(bVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c aa = com.baidu.tieba.recapp.report.g.aa(z ? 13 : 3, i, bVar.pn);
            aa.Rv(bVar.page);
            aa.setExtInfo(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dyN().a(aa);
            bVar.YN = true;
            esC.add(bVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.e eVar) {
        if (eVar != null && eVar.cmk() != null && eVar.cmk().advertAppContext != null && !eVar.cmk().advertAppContext.YN && !Ay(eVar.cmk().advertAppContext.extensionInfo)) {
            eVar.cmk().page = eVar.cmk().advertAppContext.page;
            com.baidu.tbadk.distribute.a.bwL().a(eVar.cmk(), "", 0L, eVar.cmk().page, "show", eVar.cmk().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c d = com.baidu.tieba.recapp.report.g.d(eVar.cmk(), 3, eVar.cmk().advertAppContext.pn);
            d.setExtInfo(eVar.cmk().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.d.dyN().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(eVar.cmk()));
            eVar.cmk().advertAppContext.YN = true;
            esC.add(eVar.cmk().advertAppContext.extensionInfo);
        }
    }

    private static boolean Ay(String str) {
        return esC.contains(str);
    }
}
