package com.baidu.tbadk.core.data;

import com.baidu.sapi2.SapiSafeFacade;
/* loaded from: classes.dex */
public class b {
    public String Ut;
    public String Uu;
    public String Uv;
    public String Uw;
    public String Ux;
    public boolean Uy;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Uy) {
            com.baidu.tieba.recapp.report.a Z = com.baidu.tieba.recapp.report.e.Z(z ? 13 : 3, i, bVar.pn);
            Z.se(bVar.Ut);
            Z.bV("isCache", String.valueOf(bVar.Uu));
            Z.sb(bVar.Uv);
            Z.sc(bVar.Uw);
            Z.sd(bVar.fid);
            Z.bV("vc", bVar.Ux);
            Z.rX(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.blV().a(Z);
            bVar.Uy = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.Uy) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.se(bVar.Ut);
            c.bV("isCache", bVar.Uu);
            c.sb(bVar.Uv);
            c.sc(bVar.Uw);
            c.sd(bVar.fid);
            c.bV("vc", bVar.Ux);
            c.rX(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.blV().a(c);
            bVar.Uy = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Uy) {
            com.baidu.tieba.recapp.report.a Z = com.baidu.tieba.recapp.report.e.Z(z ? 13 : 3, i, bVar.pn);
            Z.se(bVar.Ut);
            Z.sb(bVar.Uv);
            Z.sc(bVar.Uw);
            Z.sd(bVar.fid);
            Z.bV("vc", bVar.Ux);
            Z.rX(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.blV().a(Z);
            bVar.Uy = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bwd() != null && (bVar = lVar.bwd().advertAppContext) != null && !bVar.Uy) {
            lVar.Vf = bVar.Uv;
            lVar.Vg = bVar.Uw;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.bwe() != null && lVar.bwe().forFree()) {
                i = SapiSafeFacade.SAPIWEBVIEW_FINISH;
            }
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, i);
            c.rX(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.blV().a(c);
            bVar.Uy = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Uy) {
            com.baidu.tieba.recapp.report.a Z = com.baidu.tieba.recapp.report.e.Z(z ? 13 : 3, i, bVar.pn);
            Z.se(bVar.Ut);
            Z.rX(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.blV().a(Z);
            bVar.Uy = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.acb() != null && dVar.acb().advertAppContext != null && !dVar.acb().advertAppContext.Uy) {
            dVar.acb().Ut = dVar.acb().advertAppContext.Ut;
            com.baidu.tbadk.distribute.a.CN().a(dVar.acb(), "", 0L, dVar.acb().Ut, "show", dVar.acb().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.acb(), 3, dVar.acb().advertAppContext.pn);
            d.rX(dVar.acb().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.blV().a(d);
            dVar.acb().advertAppContext.Uy = true;
        }
    }
}
