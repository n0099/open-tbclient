package com.baidu.adp.lib.f;
/* loaded from: classes.dex */
public class d {
    private static int vG = 0;
    private static int vH = 0;
    private static int vI = 0;
    private static int vJ = 0;
    private static int vK = 0;
    private static int vL = 0;
    private static Object vM = new Object();

    public static com.baidu.adp.lib.stats.d hc() {
        return com.baidu.adp.lib.stats.a.hj().an("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (vM) {
                if (dVar != null) {
                    vI = (int) (vI + dVar.hA());
                }
                if (dVar2 != null) {
                    vH = (int) (vH + dVar2.hA());
                }
                int i = vG + 1;
                vG = i;
                if (i + vJ > 100) {
                    hd();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (vM) {
                if (dVar != null) {
                    vL = (int) (vL + dVar.hA());
                }
                if (dVar2 != null) {
                    vK = (int) (vK + dVar2.hA());
                }
                int i = vJ + 1;
                vJ = i;
                if (i + vG > 100) {
                    hd();
                }
            }
        }
    }

    public static void hd() {
        if (vG + vJ > 10) {
            com.baidu.adp.lib.stats.d hc = hc();
            hc.q("act", "allStat");
            hc.q("diskTaskCostTime", String.valueOf(vI));
            hc.q("diskCostTime", String.valueOf(vH));
            hc.q("diskNum", String.valueOf(vG));
            hc.q("netTaskCostTime", String.valueOf(vL));
            hc.q("netCostTime", String.valueOf(vK));
            hc.q("netNum", String.valueOf(vJ));
            hc.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.hj().b("img", hc);
            vH = 0;
            vG = 0;
            vK = 0;
            vJ = 0;
            vI = 0;
            vL = 0;
        }
    }
}
