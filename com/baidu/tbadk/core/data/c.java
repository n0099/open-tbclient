package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.views.SmsLoginView;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    protected static final Set<String> bEB = new HashSet();
    public boolean Rn;
    public String bEA;
    public String bEx;
    public String bEy;
    public String bEz;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Rn && !mn(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b af = com.baidu.tieba.recapp.report.f.af(z ? 13 : 3, i, cVar.pn);
            af.Eb(cVar.page);
            af.ea("isCache", String.valueOf(cVar.bEx));
            af.DY(cVar.bEy);
            af.DZ(cVar.bEz);
            af.Ea(cVar.fid);
            af.ea("vc", cVar.bEA);
            af.DT(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.ciy().a(af);
            cVar.Rn = true;
            bEB.add(cVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.Rn && !mn(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, cVar.pn);
            c.Eb(cVar.page);
            c.ea("isCache", cVar.bEx);
            c.DY(cVar.bEy);
            c.DZ(cVar.bEz);
            c.Ea(cVar.fid);
            c.ea("vc", cVar.bEA);
            c.DT(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.ciy().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.Rn = true;
            bEB.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pi() != null && !dVar.Rn && !TextUtils.isEmpty(dVar.pi().ext) && !mn(dVar.pi().ext)) {
            com.baidu.tieba.recapp.report.c.ciy().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Rn = true;
            bEB.add(dVar.pi().ext);
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Rn && !mn(cVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar = new com.baidu.tieba.recapp.report.b();
            bVar.zE(i2);
            if ("PB_BANNER".equals(cVar.page)) {
                bVar.zF(-1);
                bVar.setPageNumber(-1);
            } else {
                bVar.zF(i2);
                bVar.setPageNumber(cVar.pn);
            }
            bVar.Eb(cVar.page);
            bVar.DY(cVar.bEy);
            bVar.DZ(cVar.bEz);
            bVar.Ea(cVar.fid);
            bVar.ea("vc", cVar.bEA);
            bVar.DT(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.ciy().a(bVar);
            cVar.Rn = true;
            bEB.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.cpd() != null && (cVar = mVar.cpd().advertAppContext) != null && !cVar.Rn && !mn(cVar.extensionInfo)) {
            mVar.bFg = cVar.bEy;
            mVar.bFh = cVar.bEz;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.cpe() != null && mVar.cpe().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, i);
            c.DT(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.ciy().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.ph()));
            cVar.Rn = true;
            bEB.add(cVar.extensionInfo);
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Rn && !mn(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b af = com.baidu.tieba.recapp.report.f.af(z ? 13 : 3, i, cVar.pn);
            af.Eb(cVar.page);
            af.DT(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.ciy().a(af);
            cVar.Rn = true;
            bEB.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.baf() != null && dVar.baf().advertAppContext != null && !dVar.baf().advertAppContext.Rn && !mn(dVar.baf().advertAppContext.extensionInfo)) {
            dVar.baf().page = dVar.baf().advertAppContext.page;
            com.baidu.tbadk.distribute.a.arL().a(dVar.baf(), "", 0L, dVar.baf().page, SmsLoginView.StatEvent.LOGIN_SHOW, dVar.baf().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.baf(), 3, dVar.baf().advertAppContext.pn);
            d.DT(dVar.baf().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.ciy().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.baf()));
            dVar.baf().advertAppContext.Rn = true;
            bEB.add(dVar.baf().advertAppContext.extensionInfo);
        }
    }

    private static boolean mn(String str) {
        return bEB.contains(str);
    }
}
