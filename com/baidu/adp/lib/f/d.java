package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int ake = 0;
    private static int akf = 0;
    private static int akg = 0;
    private static int akh = 0;
    private static int aki = 0;
    private static int akj = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a nm() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    akg = (int) (akg + aVar.nw());
                }
                if (aVar2 != null) {
                    akf = (int) (akf + aVar2.nw());
                }
                int i = ake + 1;
                ake = i;
                if (i + akh > 100) {
                    nn();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    akj = (int) (akj + aVar.nw());
                }
                if (aVar2 != null) {
                    aki = (int) (aki + aVar2.nw());
                }
                int i = akh + 1;
                akh = i;
                if (i + ake > 100) {
                    nn();
                }
            }
        }
    }

    public static void nn() {
        if (ake + akh > 10) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("act", "allStat");
            nm.append("diskTaskCostTime", String.valueOf(akg));
            nm.append("diskCostTime", String.valueOf(akf));
            nm.append("diskNum", String.valueOf(ake));
            nm.append("netTaskCostTime", String.valueOf(akj));
            nm.append("netCostTime", String.valueOf(aki));
            nm.append("netNum", String.valueOf(akh));
            nm.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", nm);
            akf = 0;
            ake = 0;
            aki = 0;
            akh = 0;
            akg = 0;
            akj = 0;
        }
    }
}
