package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int vS = 0;
    private static int vT = 0;
    private static int vU = 0;
    private static int vV = 0;
    private static int vW = 0;
    private static int vX = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a fK() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    vU = (int) (vU + aVar.fU());
                }
                if (aVar2 != null) {
                    vT = (int) (vT + aVar2.fU());
                }
                int i = vS + 1;
                vS = i;
                if (i + vV > 100) {
                    fL();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    vX = (int) (vX + aVar.fU());
                }
                if (aVar2 != null) {
                    vW = (int) (vW + aVar2.fU());
                }
                int i = vV + 1;
                vV = i;
                if (i + vS > 100) {
                    fL();
                }
            }
        }
    }

    public static void fL() {
        if (vS + vV > 10) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "allStat");
            fK.p("diskTaskCostTime", String.valueOf(vU));
            fK.p("diskCostTime", String.valueOf(vT));
            fK.p("diskNum", String.valueOf(vS));
            fK.p("netTaskCostTime", String.valueOf(vX));
            fK.p("netCostTime", String.valueOf(vW));
            fK.p("netNum", String.valueOf(vV));
            fK.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fK);
            vT = 0;
            vS = 0;
            vW = 0;
            vV = 0;
            vU = 0;
            vX = 0;
        }
    }
}
