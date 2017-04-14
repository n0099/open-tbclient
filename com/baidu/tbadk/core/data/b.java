package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class b {
    public String TA;
    public boolean TB;
    public String Tw;
    public String Tx;
    public String Ty;
    public String Tz;
    public String extensionInfo;
    public String fid;
    public int pn;

    public static void a(b bVar, int i) {
        if (bVar != null && !bVar.TB) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pA(bVar.Tw);
            O.bU("isCache", String.valueOf(bVar.Tx));
            O.px(bVar.Ty);
            O.py(bVar.Tz);
            O.pz(bVar.fid);
            O.bU("vc", bVar.TA);
            O.pt(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.baz().a(O);
            bVar.TB = true;
        }
    }

    public static void a(AdvertAppInfo advertAppInfo) {
        b bVar;
        if (advertAppInfo != null && (bVar = advertAppInfo.advertAppContext) != null && !bVar.TB) {
            com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(advertAppInfo, 3, bVar.pn);
            b.pA(bVar.Tw);
            b.bU("isCache", bVar.Tx);
            b.px(bVar.Ty);
            b.py(bVar.Tz);
            b.pz(bVar.fid);
            b.bU("vc", bVar.TA);
            b.pt(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.baz().a(b);
            bVar.TB = true;
        }
    }

    public static void b(b bVar, int i) {
        if (bVar != null && !bVar.TB) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pA(bVar.Tw);
            O.px(bVar.Ty);
            O.py(bVar.Tz);
            O.pz(bVar.fid);
            O.bU("vc", bVar.TA);
            O.pt(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.baz().a(O);
            bVar.TB = true;
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.o oVar) {
        b bVar;
        if (oVar != null && oVar.bic() != null && (bVar = oVar.bic().advertAppContext) != null && !bVar.TB) {
            oVar.Ue = bVar.Ty;
            oVar.Uf = bVar.Tz;
            oVar.forumId = bVar.fid;
            com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(oVar, 3);
            b.pt(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.baz().a(b);
            bVar.TB = true;
        }
    }

    public static void c(b bVar, int i) {
        if (bVar != null && !bVar.TB) {
            com.baidu.tieba.recapp.report.a O = com.baidu.tieba.recapp.report.e.O(3, i, bVar.pn);
            O.pA(bVar.Tw);
            O.pt(bVar.extensionInfo);
            com.baidu.tieba.recapp.report.b.baz().a(O);
            bVar.TB = true;
        }
    }

    public static void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar != null && dVar.Ti() != null && dVar.Ti().advertAppContext != null && !dVar.Ti().advertAppContext.TB) {
            dVar.Ti().Tw = dVar.Ti().advertAppContext.Tw;
            com.baidu.tbadk.distribute.a.CX().a(dVar.Ti(), "", 0L, dVar.Ti().Tw, "show", dVar.Ti().advertAppContext.pn);
            com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(dVar.Ti(), 3, dVar.Ti().advertAppContext.pn);
            b.pt(dVar.Ti().advertAppContext.extensionInfo);
            com.baidu.tieba.recapp.report.b.baz().a(b);
            dVar.Ti().advertAppContext.TB = true;
        }
    }
}
