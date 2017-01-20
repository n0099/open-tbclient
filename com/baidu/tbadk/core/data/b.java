package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String Oa;
    public String Ob;
    public String Oc;
    public String Od;
    public String Oe;
    public boolean Of;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i) {
        if (bVar != null && !bVar.Of) {
            com.baidu.tieba.recapp.report.a P = com.baidu.tieba.recapp.report.e.P(3, i, bVar.pn);
            P.qb(bVar.Oa);
            P.cb("isCache", String.valueOf(bVar.Ob));
            P.pY(bVar.Oc);
            P.pZ(bVar.Od);
            P.qa(bVar.fid);
            P.cb("vc", bVar.Oe);
            P.pV(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bai().a(P);
            bVar.Of = true;
        }
    }

    public static void a(c cVar) {
        b bVar;
        if (cVar != null && (bVar = cVar.advertAppContext) != null && !bVar.Of) {
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(cVar, 3, bVar.pn);
            a.qb(bVar.Oa);
            a.cb("isCache", bVar.Ob);
            a.pY(bVar.Oc);
            a.pZ(bVar.Od);
            a.qa(bVar.fid);
            a.cb("vc", bVar.Oe);
            a.pV(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bai().a(a);
            bVar.Of = true;
        }
    }

    public static void b(b bVar, int i) {
        if (bVar != null && !bVar.Of) {
            com.baidu.tieba.recapp.report.a P = com.baidu.tieba.recapp.report.e.P(3, i, bVar.pn);
            P.qb(bVar.Oa);
            P.pY(bVar.Oc);
            P.pZ(bVar.Od);
            P.qa(bVar.fid);
            P.cb("vc", bVar.Oe);
            P.pV(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bai().a(P);
            bVar.Of = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.o oVar) {
        b bVar;
        if (oVar != null && oVar.bhE() != null && (bVar = oVar.bhE().advertAppContext) != null && !bVar.Of) {
            oVar.OH = bVar.Oc;
            oVar.OI = bVar.Od;
            oVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(oVar, 3);
            a.pV(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bai().a(a);
            bVar.Of = true;
        }
    }

    public static void c(b bVar, int i) {
        if (bVar != null && !bVar.Of) {
            com.baidu.tieba.recapp.report.a P = com.baidu.tieba.recapp.report.e.P(3, i, bVar.pn);
            P.qb(bVar.Oa);
            P.pV(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.bai().a(P);
            bVar.Of = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.RM() != null && dVar.RM().advertAppContext != null && !dVar.RM().advertAppContext.Of) {
            dVar.RM().Oa = dVar.RM().advertAppContext.Oa;
            com.baidu.tbadk.distribute.a.Cg().a(dVar.RM(), "", 0L, dVar.RM().Oa, "show", dVar.RM().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(dVar.RM(), 3, dVar.RM().advertAppContext.pn);
            a.pV(dVar.RM().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.bai().a(a);
            dVar.RM().advertAppContext.Of = true;
        }
    }
}
