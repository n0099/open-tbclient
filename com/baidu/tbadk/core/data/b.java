package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String aIP;
    public String aIQ;
    public String aIR;
    public String aIS;
    public String aIT;
    public boolean aIU;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aIU) {
            com.baidu.tieba.recapp.report.a ah = com.baidu.tieba.recapp.report.e.ah(z ? 13 : 3, i, bVar.pn);
            ah.rW(bVar.aIP);
            ah.bS("isCache", String.valueOf(bVar.aIQ));
            ah.rT(bVar.aIR);
            ah.rU(bVar.aIS);
            ah.rV(bVar.fid);
            ah.bS("vc", bVar.aIT);
            ah.rP(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bnC().a(ah);
            bVar.aIU = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.aIU) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.rW(bVar.aIP);
            c.bS("isCache", bVar.aIQ);
            c.rT(bVar.aIR);
            c.rU(bVar.aIS);
            c.rV(bVar.fid);
            c.bS("vc", bVar.aIT);
            c.rP(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bnC().a(c);
            bVar.aIU = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aIU) {
            com.baidu.tieba.recapp.report.a ah = com.baidu.tieba.recapp.report.e.ah(z ? 13 : 3, i, bVar.pn);
            ah.rW(bVar.aIP);
            ah.rT(bVar.aIR);
            ah.rU(bVar.aIS);
            ah.rV(bVar.fid);
            ah.bS("vc", bVar.aIT);
            ah.rP(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bnC().a(ah);
            bVar.aIU = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bvx() != null && (bVar = lVar.bvx().advertAppContext) != null && !bVar.aIU) {
            lVar.aJA = bVar.aIR;
            lVar.aJB = bVar.aIS;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.bvy() != null && lVar.bvy().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, i);
            c.rP(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bnC().a(c);
            bVar.aIU = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aIU) {
            com.baidu.tieba.recapp.report.a ah = com.baidu.tieba.recapp.report.e.ah(z ? 13 : 3, i, bVar.pn);
            ah.rW(bVar.aIP);
            ah.rP(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bnC().a(ah);
            bVar.aIU = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.akY() != null && dVar.akY().advertAppContext != null && !dVar.akY().advertAppContext.aIU) {
            dVar.akY().aIP = dVar.akY().advertAppContext.aIP;
            com.baidu.tbadk.distribute.a.Kg().a(dVar.akY(), "", 0L, dVar.akY().aIP, "show", dVar.akY().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.akY(), 3, dVar.akY().advertAppContext.pn);
            d.rP(dVar.akY().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bnC().a(d);
            dVar.akY().advertAppContext.aIU = true;
        }
    }
}
