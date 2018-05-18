package com.baidu.tbadk.core.data;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class b {
    public boolean IM;
    public String Vp;
    public String Vq;
    public String Vr;
    public String Vs;
    public String Vt;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.IM) {
            com.baidu.tieba.recapp.report.a W = com.baidu.tieba.recapp.report.e.W(z ? 13 : 3, i, bVar.pn);
            W.sn(bVar.Vp);
            W.bR("isCache", String.valueOf(bVar.Vq));
            W.sk(bVar.Vr);
            W.sl(bVar.Vs);
            W.sm(bVar.fid);
            W.bR("vc", bVar.Vt);
            W.sg(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bkd().a(W);
            bVar.IM = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.IM) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.sn(bVar.Vp);
            c.bR("isCache", bVar.Vq);
            c.sk(bVar.Vr);
            c.sl(bVar.Vs);
            c.sm(bVar.fid);
            c.bR("vc", bVar.Vt);
            c.sg(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bkd().a(c);
            bVar.IM = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.lv() != null && !dVar.IM && !TextUtils.isEmpty(dVar.lv().ext)) {
            com.baidu.tieba.recapp.report.b.bkd().a(com.baidu.tieba.recapp.report.e.a(dVar, 3, dVar.getPageNum()));
            dVar.IM = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.IM) {
            com.baidu.tieba.recapp.report.a W = com.baidu.tieba.recapp.report.e.W(z ? 13 : 3, i, bVar.pn);
            W.sn(bVar.Vp);
            W.sk(bVar.Vr);
            W.sl(bVar.Vs);
            W.sm(bVar.fid);
            W.bR("vc", bVar.Vt);
            W.sg(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bkd().a(W);
            bVar.IM = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.brN() != null && (bVar = lVar.brN().advertAppContext) != null && !bVar.IM) {
            lVar.VZ = bVar.Vr;
            lVar.Wa = bVar.Vs;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.brO() != null && lVar.brO().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, i);
            c.sg(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bkd().a(c);
            bVar.IM = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.IM) {
            com.baidu.tieba.recapp.report.a W = com.baidu.tieba.recapp.report.e.W(z ? 13 : 3, i, bVar.pn);
            W.sn(bVar.Vp);
            W.sg(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bkd().a(W);
            bVar.IM = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.afP() != null && dVar.afP().advertAppContext != null && !dVar.afP().advertAppContext.IM) {
            dVar.afP().Vp = dVar.afP().advertAppContext.Vp;
            com.baidu.tbadk.distribute.a.Do().a(dVar.afP(), "", 0L, dVar.afP().Vp, "show", dVar.afP().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.afP(), 3, dVar.afP().advertAppContext.pn);
            d.sg(dVar.afP().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bkd().a(d);
            dVar.afP().advertAppContext.IM = true;
        }
    }
}
