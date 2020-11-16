package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    protected static final Set<String> ewK = new HashSet();
    public boolean YS;
    public String ewG;
    public String ewH;
    public String ewI;
    public String ewJ;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.YS && !Ah(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ac = com.baidu.tieba.recapp.report.g.ac(z ? 13 : 3, i, cVar.pn);
            ac.Rk(cVar.page);
            ac.ge("isCache", String.valueOf(cVar.ewG));
            ac.Rh(cVar.ewH);
            ac.Ri(cVar.ewI);
            ac.Rj(cVar.fid);
            ac.ge("vc", cVar.ewJ);
            ac.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dAT().a(ac);
            cVar.YS = true;
            ewK.add(cVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.YS && !Ah(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 3, cVar.pn);
            c.Rk(cVar.page);
            c.ge("isCache", cVar.ewG);
            c.Rh(cVar.ewH);
            c.Ri(cVar.ewI);
            c.Rj(cVar.fid);
            c.ge("vc", cVar.ewJ);
            c.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dAT().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.c(advertAppInfo));
            cVar.YS = true;
            ewK.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.rr() != null && !dVar.YS && !TextUtils.isEmpty(dVar.rr().ext) && !Ah(dVar.rr().ext)) {
            com.baidu.tieba.recapp.report.d.dAT().a(com.baidu.tieba.recapp.report.g.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.YS = true;
            ewK.add(dVar.rr().ext);
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.YS && !Ah(cVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.c cVar2 = new com.baidu.tieba.recapp.report.c();
            cVar2.Iz(i2);
            if ("PB_BANNER".equals(cVar.page)) {
                cVar2.IA(-1);
                cVar2.setPageNumber(-1);
            } else {
                cVar2.IA(i2);
                cVar2.setPageNumber(cVar.pn);
            }
            cVar2.Rk(cVar.page);
            cVar2.Rh(cVar.ewH);
            cVar2.Ri(cVar.ewI);
            cVar2.Rj(cVar.fid);
            cVar2.ge("vc", cVar.ewJ);
            cVar2.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dAT().a(cVar2);
            cVar.YS = true;
            ewK.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.n nVar) {
        c cVar;
        if (nVar != null && nVar.dJE() != null && (cVar = nVar.dJE().advertAppContext) != null && !cVar.YS && !Ah(cVar.extensionInfo)) {
            nVar.exo = cVar.ewH;
            nVar.exp = cVar.ewI;
            nVar.forumId = cVar.fid;
            int i = 3;
            if (nVar != null && nVar.dJF() != null && nVar.dJF().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, i);
            c.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dAT().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.c(nVar.rq()));
            cVar.YS = true;
            ewK.add(cVar.extensionInfo);
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.YS && !Ah(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.c ac = com.baidu.tieba.recapp.report.g.ac(z ? 13 : 3, i, cVar.pn);
            ac.Rk(cVar.page);
            ac.setExtInfo(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.d.dAT().a(ac);
            cVar.YS = true;
            ewK.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.coq() != null && dVar.coq().advertAppContext != null && !dVar.coq().advertAppContext.YS && !Ah(dVar.coq().advertAppContext.extensionInfo)) {
            dVar.coq().page = dVar.coq().advertAppContext.page;
            com.baidu.tbadk.distribute.a.byA().a(dVar.coq(), "", 0L, dVar.coq().page, "show", dVar.coq().advertAppContext.pn);
            com.baidu.tieba.recapp.report.c d = com.baidu.tieba.recapp.report.g.d(dVar.coq(), 3, dVar.coq().advertAppContext.pn);
            d.setExtInfo(dVar.coq().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.d.dAT().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.c(dVar.coq()));
            dVar.coq().advertAppContext.YS = true;
            ewK.add(dVar.coq().advertAppContext.extensionInfo);
        }
    }

    private static boolean Ah(String str) {
        return ewK.contains(str);
    }
}
