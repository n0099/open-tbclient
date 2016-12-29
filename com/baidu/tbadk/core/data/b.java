package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String OO;
    public String OP;
    public String OQ;
    public String OR;
    public String OS;
    public boolean OT;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i) {
        if (bVar != null && !bVar.OT) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pH(bVar.OO);
            O.bS("isCache", String.valueOf(bVar.OP));
            O.pE(bVar.OQ);
            O.pF(bVar.OR);
            O.pG(bVar.fid);
            O.bS("vc", bVar.OS);
            O.pB(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.aYs().a(O);
            bVar.OT = true;
        }
    }

    public static void a(c cVar) {
        b bVar;
        if (cVar != null && (bVar = cVar.Pz) != null && !bVar.OT) {
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(cVar, 3, bVar.pn);
            a.pH(bVar.OO);
            a.bS("isCache", bVar.OP);
            a.pE(bVar.OQ);
            a.pF(bVar.OR);
            a.pG(bVar.fid);
            a.bS("vc", bVar.OS);
            a.pB(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.aYs().a(a);
            bVar.OT = true;
        }
    }

    public static void b(b bVar, int i) {
        if (bVar != null && !bVar.OT) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pH(bVar.OO);
            O.pE(bVar.OQ);
            O.pF(bVar.OR);
            O.pG(bVar.fid);
            O.bS("vc", bVar.OS);
            O.pB(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.aYs().a(O);
            bVar.OT = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.p pVar) {
        b bVar;
        if (pVar != null && pVar.bfO() != null && (bVar = pVar.bfO().Pz) != null && !bVar.OT) {
            pVar.PA = bVar.OQ;
            pVar.PC = bVar.OR;
            pVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(pVar, 3);
            a.pB(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.aYs().a(a);
            bVar.OT = true;
        }
    }

    public static void c(b bVar, int i) {
        if (bVar != null && !bVar.OT) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pH(bVar.OO);
            O.pB(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.aYs().a(O);
            bVar.OT = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.OW() != null && dVar.OW().Pz != null && !dVar.OW().Pz.OT) {
            dVar.OW().OO = dVar.OW().Pz.OO;
            com.baidu.tbadk.distribute.a.Ck().a(dVar.OW(), "", 0L, dVar.OW().OO, "show", dVar.OW().Pz.pn);
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(dVar.OW(), 3, dVar.OW().Pz.pn);
            a.pB(dVar.OW().Pz.extensionInfo);
            com.baidu.tieba.recapp.report.b.aYs().a(a);
            dVar.OW().Pz.OT = true;
        }
    }
}
