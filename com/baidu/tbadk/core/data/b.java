package com.baidu.tbadk.core.data;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class b {
    public boolean IR;
    public String Vt;
    public String Vu;
    public String Vv;
    public String Vw;
    public String Vx;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.IR) {
            com.baidu.tieba.recapp.report.a W = com.baidu.tieba.recapp.report.e.W(z ? 13 : 3, i, bVar.pn);
            W.sk(bVar.Vt);
            W.bR("isCache", String.valueOf(bVar.Vu));
            W.sh(bVar.Vv);
            W.si(bVar.Vw);
            W.sj(bVar.fid);
            W.bR("vc", bVar.Vx);
            W.sd(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bke().a(W);
            bVar.IR = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.IR) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.sk(bVar.Vt);
            c.bR("isCache", bVar.Vu);
            c.sh(bVar.Vv);
            c.si(bVar.Vw);
            c.sj(bVar.fid);
            c.bR("vc", bVar.Vx);
            c.sd(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bke().a(c);
            bVar.IR = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.lw() != null && !dVar.IR && !TextUtils.isEmpty(dVar.lw().ext)) {
            com.baidu.tieba.recapp.report.b.bke().a(com.baidu.tieba.recapp.report.e.a(dVar, 3, dVar.getPageNum()));
            dVar.IR = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.IR) {
            com.baidu.tieba.recapp.report.a W = com.baidu.tieba.recapp.report.e.W(z ? 13 : 3, i, bVar.pn);
            W.sk(bVar.Vt);
            W.sh(bVar.Vv);
            W.si(bVar.Vw);
            W.sj(bVar.fid);
            W.bR("vc", bVar.Vx);
            W.sd(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bke().a(W);
            bVar.IR = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.brP() != null && (bVar = lVar.brP().advertAppContext) != null && !bVar.IR) {
            lVar.Wd = bVar.Vv;
            lVar.We = bVar.Vw;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.brQ() != null && lVar.brQ().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, i);
            c.sd(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bke().a(c);
            bVar.IR = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.IR) {
            com.baidu.tieba.recapp.report.a W = com.baidu.tieba.recapp.report.e.W(z ? 13 : 3, i, bVar.pn);
            W.sk(bVar.Vt);
            W.sd(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bke().a(W);
            bVar.IR = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.afP() != null && dVar.afP().advertAppContext != null && !dVar.afP().advertAppContext.IR) {
            dVar.afP().Vt = dVar.afP().advertAppContext.Vt;
            com.baidu.tbadk.distribute.a.Dq().a(dVar.afP(), "", 0L, dVar.afP().Vt, "show", dVar.afP().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.afP(), 3, dVar.afP().advertAppContext.pn);
            d.sd(dVar.afP().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bke().a(d);
            dVar.afP().advertAppContext.IR = true;
        }
    }
}
