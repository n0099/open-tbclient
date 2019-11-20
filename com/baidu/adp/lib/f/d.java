package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int pB = 0;
    private static int pC = 0;
    private static int pD = 0;
    private static int pE = 0;
    private static int pF = 0;
    private static int pG = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a fU() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    pD = (int) (pD + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    pC = (int) (pC + aVar2.getTimeCost());
                }
                int i = pB + 1;
                pB = i;
                if (i + pE > 100) {
                    fV();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    pG = (int) (pG + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    pF = (int) (pF + aVar2.getTimeCost());
                }
                int i = pE + 1;
                pE = i;
                if (i + pB > 100) {
                    fV();
                }
            }
        }
    }

    public static void fV() {
        if (pB + pE > 10) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("act", "allStat");
            fU.append("diskTaskCostTime", String.valueOf(pD));
            fU.append("diskCostTime", String.valueOf(pC));
            fU.append("diskNum", String.valueOf(pB));
            fU.append("netTaskCostTime", String.valueOf(pG));
            fU.append("netCostTime", String.valueOf(pF));
            fU.append("netNum", String.valueOf(pE));
            fU.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fU);
            pC = 0;
            pB = 0;
            pF = 0;
            pE = 0;
            pD = 0;
            pG = 0;
        }
    }
}
