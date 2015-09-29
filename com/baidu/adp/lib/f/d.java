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

    public static com.baidu.adp.lib.stats.d hb() {
        return com.baidu.adp.lib.stats.a.hi().ap("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (vM) {
                if (dVar != null) {
                    vI = (int) (vI + dVar.hz());
                }
                if (dVar2 != null) {
                    vH = (int) (vH + dVar2.hz());
                }
                int i = vG + 1;
                vG = i;
                if (i + vJ > 100) {
                    hc();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (vM) {
                if (dVar != null) {
                    vL = (int) (vL + dVar.hz());
                }
                if (dVar2 != null) {
                    vK = (int) (vK + dVar2.hz());
                }
                int i = vJ + 1;
                vJ = i;
                if (i + vG > 100) {
                    hc();
                }
            }
        }
    }

    public static void hc() {
        if (vG + vJ > 10) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("act", "allStat");
            hb.q("diskTaskCostTime", String.valueOf(vI));
            hb.q("diskCostTime", String.valueOf(vH));
            hb.q("diskNum", String.valueOf(vG));
            hb.q("netTaskCostTime", String.valueOf(vL));
            hb.q("netCostTime", String.valueOf(vK));
            hb.q("netNum", String.valueOf(vJ));
            hb.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.hi().b("img", hb);
            vH = 0;
            vG = 0;
            vK = 0;
            vJ = 0;
            vI = 0;
            vL = 0;
        }
    }
}
