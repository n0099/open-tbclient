package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.views.SmsLoginView;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    protected static final Set<String> bEC = new HashSet();
    public boolean Rn;
    public String bEA;
    public String bEB;
    public String bEy;
    public String bEz;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Rn && !mn(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b af = com.baidu.tieba.recapp.report.f.af(z ? 13 : 3, i, cVar.pn);
            af.Ec(cVar.page);
            af.ea("isCache", String.valueOf(cVar.bEy));
            af.DZ(cVar.bEz);
            af.Ea(cVar.bEA);
            af.Eb(cVar.fid);
            af.ea("vc", cVar.bEB);
            af.DU(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.ciQ().a(af);
            cVar.Rn = true;
            bEC.add(cVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.Rn && !mn(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, cVar.pn);
            c.Ec(cVar.page);
            c.ea("isCache", cVar.bEy);
            c.DZ(cVar.bEz);
            c.Ea(cVar.bEA);
            c.Eb(cVar.fid);
            c.ea("vc", cVar.bEB);
            c.DU(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.ciQ().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.Rn = true;
            bEC.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pi() != null && !dVar.Rn && !TextUtils.isEmpty(dVar.pi().ext) && !mn(dVar.pi().ext)) {
            com.baidu.tieba.recapp.report.c.ciQ().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Rn = true;
            bEC.add(dVar.pi().ext);
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Rn && !mn(cVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar = new com.baidu.tieba.recapp.report.b();
            bVar.zG(i2);
            if ("PB_BANNER".equals(cVar.page)) {
                bVar.zH(-1);
                bVar.setPageNumber(-1);
            } else {
                bVar.zH(i2);
                bVar.setPageNumber(cVar.pn);
            }
            bVar.Ec(cVar.page);
            bVar.DZ(cVar.bEz);
            bVar.Ea(cVar.bEA);
            bVar.Eb(cVar.fid);
            bVar.ea("vc", cVar.bEB);
            bVar.DU(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.ciQ().a(bVar);
            cVar.Rn = true;
            bEC.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.cpz() != null && (cVar = mVar.cpz().advertAppContext) != null && !cVar.Rn && !mn(cVar.extensionInfo)) {
            mVar.bFh = cVar.bEz;
            mVar.bFi = cVar.bEA;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.cpA() != null && mVar.cpA().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, i);
            c.DU(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.ciQ().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.ph()));
            cVar.Rn = true;
            bEC.add(cVar.extensionInfo);
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Rn && !mn(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b af = com.baidu.tieba.recapp.report.f.af(z ? 13 : 3, i, cVar.pn);
            af.Ec(cVar.page);
            af.DU(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.ciQ().a(af);
            cVar.Rn = true;
            bEC.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.bah() != null && dVar.bah().advertAppContext != null && !dVar.bah().advertAppContext.Rn && !mn(dVar.bah().advertAppContext.extensionInfo)) {
            dVar.bah().page = dVar.bah().advertAppContext.page;
            com.baidu.tbadk.distribute.a.arN().a(dVar.bah(), "", 0L, dVar.bah().page, SmsLoginView.StatEvent.LOGIN_SHOW, dVar.bah().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.bah(), 3, dVar.bah().advertAppContext.pn);
            d.DU(dVar.bah().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.ciQ().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.bah()));
            dVar.bah().advertAppContext.Rn = true;
            bEC.add(dVar.bah().advertAppContext.extensionInfo);
        }
    }

    private static boolean mn(String str) {
        return bEC.contains(str);
    }
}
