package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.views.SmsLoginView;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    protected static final Set<String> bFa = new HashSet();
    public boolean Rm;
    public String bEW;
    public String bEX;
    public String bEY;
    public String bEZ;
    public String extensionInfo;
    public String fid;
    public String page;
    public int pn;

    public static void a(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Rm && !mp(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b ag = com.baidu.tieba.recapp.report.f.ag(z ? 13 : 3, i, cVar.pn);
            ag.EC(cVar.page);
            ag.eb("isCache", String.valueOf(cVar.bEW));
            ag.Ez(cVar.bEX);
            ag.EA(cVar.bEY);
            ag.EB(cVar.fid);
            ag.eb("vc", cVar.bEZ);
            ag.Eu(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cjE().a(ag);
            cVar.Rm = true;
            bFa.add(cVar.extensionInfo);
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        c cVar;
        if (advertAppInfo != null && (cVar = advertAppInfo.advertAppContext) != null && !cVar.Rm && !mp(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 3, cVar.pn);
            c.EC(cVar.page);
            c.eb("isCache", cVar.bEW);
            c.Ez(cVar.bEX);
            c.EA(cVar.bEY);
            c.EB(cVar.fid);
            c.eb("vc", cVar.bEZ);
            c.Eu(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cjE().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
            cVar.Rm = true;
            bFa.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.afd.d dVar) {
        if (dVar != null && dVar.pj() != null && !dVar.Rm && !TextUtils.isEmpty(dVar.pj().ext) && !mp(dVar.pj().ext)) {
            com.baidu.tieba.recapp.report.c.cjE().a(com.baidu.tieba.recapp.report.f.a(dVar, 3, dVar.getPageNum()));
            com.baidu.tieba.lego.card.b.c.b(dVar);
            dVar.Rm = true;
            bFa.add(dVar.pj().ext);
        }
    }

    public static void b(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Rm && !mp(cVar.extensionInfo)) {
            int i2 = z ? 13 : 3;
            com.baidu.tieba.recapp.report.b bVar = new com.baidu.tieba.recapp.report.b();
            bVar.zJ(i2);
            if ("PB_BANNER".equals(cVar.page)) {
                bVar.zK(-1);
                bVar.setPageNumber(-1);
            } else {
                bVar.zK(i2);
                bVar.setPageNumber(cVar.pn);
            }
            bVar.EC(cVar.page);
            bVar.Ez(cVar.bEX);
            bVar.EA(cVar.bEY);
            bVar.EB(cVar.fid);
            bVar.eb("vc", cVar.bEZ);
            bVar.Eu(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cjE().a(bVar);
            cVar.Rm = true;
            bFa.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.m mVar) {
        c cVar;
        if (mVar != null && mVar.cqn() != null && (cVar = mVar.cqn().advertAppContext) != null && !cVar.Rm && !mp(cVar.extensionInfo)) {
            mVar.bFF = cVar.bEX;
            mVar.bFG = cVar.bEY;
            mVar.forumId = cVar.fid;
            int i = 3;
            if (mVar != null && mVar.cqo() != null && mVar.cqo().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, i);
            c.Eu(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cjE().a(c);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(mVar.pi()));
            cVar.Rm = true;
            bFa.add(cVar.extensionInfo);
        }
    }

    public static void c(c cVar, int i, boolean z) {
        if (cVar != null && !cVar.Rm && !mp(cVar.extensionInfo)) {
            com.baidu.tieba.recapp.report.b ag = com.baidu.tieba.recapp.report.f.ag(z ? 13 : 3, i, cVar.pn);
            ag.EC(cVar.page);
            ag.Eu(cVar.extensionInfo);
            com.baidu.tieba.recapp.report.c.cjE().a(ag);
            cVar.Rm = true;
            bFa.add(cVar.extensionInfo);
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.baL() != null && dVar.baL().advertAppContext != null && !dVar.baL().advertAppContext.Rm && !mp(dVar.baL().advertAppContext.extensionInfo)) {
            dVar.baL().page = dVar.baL().advertAppContext.page;
            com.baidu.tbadk.distribute.a.arZ().a(dVar.baL(), "", 0L, dVar.baL().page, SmsLoginView.StatEvent.LOGIN_SHOW, dVar.baL().advertAppContext.pn);
            com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(dVar.baL(), 3, dVar.baL().advertAppContext.pn);
            d.Eu(dVar.baL().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.c.cjE().a(d);
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(dVar.baL()));
            dVar.baL().advertAppContext.Rm = true;
            bFa.add(dVar.baL().advertAppContext.extensionInfo);
        }
    }

    private static boolean mp(String str) {
        return bFa.contains(str);
    }
}
