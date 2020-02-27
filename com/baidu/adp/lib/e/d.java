package com.baidu.adp.lib.e;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int sl = 0;
    private static int sm = 0;
    private static int so = 0;
    private static int sq = 0;
    private static int sr = 0;
    private static int ss = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a gs() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    so = (int) (so + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    sm = (int) (sm + aVar2.getTimeCost());
                }
                int i = sl + 1;
                sl = i;
                if (i + sq > 100) {
                    gt();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    ss = (int) (ss + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    sr = (int) (sr + aVar2.getTimeCost());
                }
                int i = sq + 1;
                sq = i;
                if (i + sl > 100) {
                    gt();
                }
            }
        }
    }

    public static void gt() {
        if (sl + sq > 10) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("act", "allStat");
            gs.append("diskTaskCostTime", String.valueOf(so));
            gs.append("diskCostTime", String.valueOf(sm));
            gs.append("diskNum", String.valueOf(sl));
            gs.append("netTaskCostTime", String.valueOf(ss));
            gs.append("netCostTime", String.valueOf(sr));
            gs.append("netNum", String.valueOf(sq));
            gs.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", gs);
            sm = 0;
            sl = 0;
            sr = 0;
            sq = 0;
            so = 0;
            ss = 0;
        }
    }
}
