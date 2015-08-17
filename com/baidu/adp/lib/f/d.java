package com.baidu.adp.lib.f;
/* loaded from: classes.dex */
public class d {
    private static int vH = 0;
    private static int vI = 0;
    private static int vJ = 0;
    private static int vK = 0;
    private static int vL = 0;
    private static int vM = 0;
    private static Object vN = new Object();

    public static com.baidu.adp.lib.stats.d hd() {
        return com.baidu.adp.lib.stats.a.hk().ap("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (vN) {
                if (dVar != null) {
                    vJ = (int) (vJ + dVar.hB());
                }
                if (dVar2 != null) {
                    vI = (int) (vI + dVar2.hB());
                }
                int i = vH + 1;
                vH = i;
                if (i + vK > 100) {
                    he();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (vN) {
                if (dVar != null) {
                    vM = (int) (vM + dVar.hB());
                }
                if (dVar2 != null) {
                    vL = (int) (vL + dVar2.hB());
                }
                int i = vK + 1;
                vK = i;
                if (i + vH > 100) {
                    he();
                }
            }
        }
    }

    public static void he() {
        if (vH + vK > 10) {
            com.baidu.adp.lib.stats.d hd = hd();
            hd.q("act", "allStat");
            hd.q("diskTaskCostTime", String.valueOf(vJ));
            hd.q("diskCostTime", String.valueOf(vI));
            hd.q("diskNum", String.valueOf(vH));
            hd.q("netTaskCostTime", String.valueOf(vM));
            hd.q("netCostTime", String.valueOf(vL));
            hd.q("netNum", String.valueOf(vK));
            hd.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.hk().b("img", hd);
            vI = 0;
            vH = 0;
            vL = 0;
            vK = 0;
            vJ = 0;
            vM = 0;
        }
    }
}
