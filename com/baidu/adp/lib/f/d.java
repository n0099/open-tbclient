package com.baidu.adp.lib.f;
/* loaded from: classes.dex */
public class d {
    private static int vF = 0;
    private static int vG = 0;
    private static int vH = 0;
    private static int vI = 0;
    private static int vJ = 0;
    private static int vK = 0;
    private static Object vL = new Object();

    public static com.baidu.adp.lib.stats.d ha() {
        return com.baidu.adp.lib.stats.a.hh().ap("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (vL) {
                if (dVar != null) {
                    vH = (int) (vH + dVar.hy());
                }
                if (dVar2 != null) {
                    vG = (int) (vG + dVar2.hy());
                }
                int i = vF + 1;
                vF = i;
                if (i + vI > 100) {
                    hb();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (vL) {
                if (dVar != null) {
                    vK = (int) (vK + dVar.hy());
                }
                if (dVar2 != null) {
                    vJ = (int) (vJ + dVar2.hy());
                }
                int i = vI + 1;
                vI = i;
                if (i + vF > 100) {
                    hb();
                }
            }
        }
    }

    public static void hb() {
        if (vF + vI > 10) {
            com.baidu.adp.lib.stats.d ha = ha();
            ha.q("act", "allStat");
            ha.q("diskTaskCostTime", String.valueOf(vH));
            ha.q("diskCostTime", String.valueOf(vG));
            ha.q("diskNum", String.valueOf(vF));
            ha.q("netTaskCostTime", String.valueOf(vK));
            ha.q("netCostTime", String.valueOf(vJ));
            ha.q("netNum", String.valueOf(vI));
            ha.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.hh().b("img", ha);
            vG = 0;
            vF = 0;
            vJ = 0;
            vI = 0;
            vH = 0;
            vK = 0;
        }
    }
}
