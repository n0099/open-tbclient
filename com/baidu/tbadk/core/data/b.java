package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String aIO;
    public String aIP;
    public String aIQ;
    public String aIR;
    public String aIS;
    public boolean aIT;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aIT) {
            com.baidu.tieba.recapp.report.a ai = com.baidu.tieba.recapp.report.e.ai(z ? 13 : 3, i, bVar.pn);
            ai.sv(bVar.aIO);
            ai.bX("isCache", String.valueOf(bVar.aIP));
            ai.ss(bVar.aIQ);
            ai.st(bVar.aIR);
            ai.su(bVar.fid);
            ai.bX("vc", bVar.aIS);
            ai.sn(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bui().a(ai);
            bVar.aIT = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.aIT) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.sv(bVar.aIO);
            c.bX("isCache", bVar.aIP);
            c.ss(bVar.aIQ);
            c.st(bVar.aIR);
            c.su(bVar.fid);
            c.bX("vc", bVar.aIS);
            c.sn(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bui().a(c);
            bVar.aIT = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aIT) {
            com.baidu.tieba.recapp.report.a ai = com.baidu.tieba.recapp.report.e.ai(z ? 13 : 3, i, bVar.pn);
            ai.sv(bVar.aIO);
            ai.ss(bVar.aIQ);
            ai.st(bVar.aIR);
            ai.su(bVar.fid);
            ai.bX("vc", bVar.aIS);
            ai.sn(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bui().a(ai);
            bVar.aIT = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bBZ() != null && (bVar = lVar.bBZ().advertAppContext) != null && !bVar.aIT) {
            lVar.aJz = bVar.aIQ;
            lVar.aJA = bVar.aIR;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.bCa() != null && lVar.bCa().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, i);
            c.sn(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bui().a(c);
            bVar.aIT = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aIT) {
            com.baidu.tieba.recapp.report.a ai = com.baidu.tieba.recapp.report.e.ai(z ? 13 : 3, i, bVar.pn);
            ai.sv(bVar.aIO);
            ai.sn(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bui().a(ai);
            bVar.aIT = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.ajQ() != null && dVar.ajQ().advertAppContext != null && !dVar.ajQ().advertAppContext.aIT) {
            dVar.ajQ().aIO = dVar.ajQ().advertAppContext.aIO;
            com.baidu.tbadk.distribute.a.Kp().a(dVar.ajQ(), "", 0L, dVar.ajQ().aIO, "show", dVar.ajQ().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.ajQ(), 3, dVar.ajQ().advertAppContext.pn);
            d.sn(dVar.ajQ().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bui().a(d);
            dVar.ajQ().advertAppContext.aIT = true;
        }
    }
}
