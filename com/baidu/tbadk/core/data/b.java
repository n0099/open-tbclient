package com.baidu.tbadk.core.data;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class b {
    public boolean Sc;
    public String apA;
    public String apx;
    public String apy;
    public String apz;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Sc) {
            com.baidu.tieba.recapp.report.b aa = com.baidu.tieba.recapp.report.f.aa(z ? 13 : 3, i, bVar.pn);
            aa.vm(bVar.page);
            aa.cB("isCache", String.valueOf(bVar.apx));
            aa.vj(bVar.apy);
            aa.vk(bVar.apz);
            aa.vl(bVar.fid);
            aa.cB("vc", bVar.apA);
            aa.vf(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bwO().a(aa);
            bVar.Sc = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.Sc) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, bVar.pn);
            c.vm(bVar.page);
            c.cB("isCache", bVar.apx);
            c.vj(bVar.apy);
            c.vk(bVar.apz);
            c.vl(bVar.fid);
            c.cB("vc", bVar.apA);
            c.vf(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bwO().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            bVar.Sc = true;
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pz() != null && !dVar.Sc && !TextUtils.isEmpty(dVar.pz().ext)) {
            com.baidu.tieba.recapp.report.c.bwO().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Sc = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Sc) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar2 = new com.baidu.tieba.recapp.report.b();
            bVar2.uj(i2);
            if ("PB_BANNER".equals(bVar.page)) {
                bVar2.uk(-1);
                bVar2.setPageNumber(-1);
            } else {
                bVar2.uk(i2);
                bVar2.setPageNumber(bVar.pn);
            }
            bVar2.vm(bVar.page);
            bVar2.vj(bVar.apy);
            bVar2.vk(bVar.apz);
            bVar2.vl(bVar.fid);
            bVar2.cB("vc", bVar.apA);
            bVar2.vf(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bwO().a(bVar2);
            bVar.Sc = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bEG() != null && (bVar = lVar.bEG().advertAppContext) != null && !bVar.Sc) {
            lVar.aqg = bVar.apy;
            lVar.aqh = bVar.apz;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.bEH() != null && lVar.bEH().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(lVar, i);
            c.vf(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bwO().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(lVar.py()));
            bVar.Sc = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.Sc) {
            com.baidu.tieba.recapp.report.b aa = com.baidu.tieba.recapp.report.f.aa(z ? 13 : 3, i, bVar.pn);
            aa.vm(bVar.page);
            aa.vf(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.bwO().a(aa);
            bVar.Sc = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.arh() != null && dVar.arh().advertAppContext != null && !dVar.arh().advertAppContext.Sc) {
            dVar.arh().page = dVar.arh().advertAppContext.page;
            com.baidu.tbadk.distribute.a.Mc().a(dVar.arh(), "", 0L, dVar.arh().page, "show", dVar.arh().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.arh(), 3, dVar.arh().advertAppContext.pn);
            d.vf(dVar.arh().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.bwO().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.arh()));
            dVar.arh().advertAppContext.Sc = true;
        }
    }
}
