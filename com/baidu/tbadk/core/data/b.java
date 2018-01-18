package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String aIM;
    public String aIN;
    public String aIO;
    public String aIP;
    public String aIQ;
    public boolean aIR;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aIR) {
            com.baidu.tieba.recapp.report.a ah = com.baidu.tieba.recapp.report.e.ah(z ? 13 : 3, i, bVar.pn);
            ah.rO(bVar.aIM);
            ah.bT("isCache", String.valueOf(bVar.aIN));
            ah.rL(bVar.aIO);
            ah.rM(bVar.aIP);
            ah.rN(bVar.fid);
            ah.bT("vc", bVar.aIQ);
            ah.rH(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bnB().a(ah);
            bVar.aIR = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.aIR) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 3, bVar.pn);
            c.rO(bVar.aIM);
            c.bT("isCache", bVar.aIN);
            c.rL(bVar.aIO);
            c.rM(bVar.aIP);
            c.rN(bVar.fid);
            c.bT("vc", bVar.aIQ);
            c.rH(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bnB().a(c);
            bVar.aIR = true;
        }
    }

    public static void b(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aIR) {
            com.baidu.tieba.recapp.report.a ah = com.baidu.tieba.recapp.report.e.ah(z ? 13 : 3, i, bVar.pn);
            ah.rO(bVar.aIM);
            ah.rL(bVar.aIO);
            ah.rM(bVar.aIP);
            ah.rN(bVar.fid);
            ah.bT("vc", bVar.aIQ);
            ah.rH(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bnB().a(ah);
            bVar.aIR = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        b bVar;
        if (lVar != null && lVar.bvv() != null && (bVar = lVar.bvv().advertAppContext) != null && !bVar.aIR) {
            lVar.aJx = bVar.aIO;
            lVar.aJy = bVar.aIP;
            lVar.forumId = bVar.fid;
            int i = 3;
            if (lVar != null && lVar.bvw() != null && lVar.bvw().forFree()) {
                i = 103;
            }
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, i);
            c.rH(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bnB().a(c);
            bVar.aIR = true;
        }
    }

    public static void c(b bVar, int i, boolean z) {
        if (bVar != null && !bVar.aIR) {
            com.baidu.tieba.recapp.report.a ah = com.baidu.tieba.recapp.report.e.ah(z ? 13 : 3, i, bVar.pn);
            ah.rO(bVar.aIM);
            ah.rH(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bnB().a(ah);
            bVar.aIR = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.akT() != null && dVar.akT().advertAppContext != null && !dVar.akT().advertAppContext.aIR) {
            dVar.akT().aIM = dVar.akT().advertAppContext.aIM;
            com.baidu.tbadk.distribute.a.Ke().a(dVar.akT(), "", 0L, dVar.akT().aIM, "show", dVar.akT().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a d = com.baidu.tieba.recapp.report.e.d(dVar.akT(), 3, dVar.akT().advertAppContext.pn);
            d.rH(dVar.akT().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bnB().a(d);
            dVar.akT().advertAppContext.aIR = true;
        }
    }
}
