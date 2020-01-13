package com.baidu.adp.lib.e;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int sj = 0;
    private static int sl = 0;
    private static int sm = 0;
    private static int so = 0;
    private static int sq = 0;
    private static int sr = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a gs() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    sm = (int) (sm + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    sl = (int) (sl + aVar2.getTimeCost());
                }
                int i = sj + 1;
                sj = i;
                if (i + so > 100) {
                    gt();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    sr = (int) (sr + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    sq = (int) (sq + aVar2.getTimeCost());
                }
                int i = so + 1;
                so = i;
                if (i + sj > 100) {
                    gt();
                }
            }
        }
    }

    public static void gt() {
        if (sj + so > 10) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("act", "allStat");
            gs.append("diskTaskCostTime", String.valueOf(sm));
            gs.append("diskCostTime", String.valueOf(sl));
            gs.append("diskNum", String.valueOf(sj));
            gs.append("netTaskCostTime", String.valueOf(sr));
            gs.append("netCostTime", String.valueOf(sq));
            gs.append("netNum", String.valueOf(so));
            gs.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", gs);
            sl = 0;
            sj = 0;
            sq = 0;
            so = 0;
            sm = 0;
            sr = 0;
        }
    }
}
