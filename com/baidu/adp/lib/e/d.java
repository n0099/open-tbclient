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

    public static com.baidu.adp.lib.stats.a gt() {
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
                    gu();
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
                    gu();
                }
            }
        }
    }

    public static void gu() {
        if (sj + so > 10) {
            com.baidu.adp.lib.stats.a gt = gt();
            gt.append("act", "allStat");
            gt.append("diskTaskCostTime", String.valueOf(sm));
            gt.append("diskCostTime", String.valueOf(sl));
            gt.append("diskNum", String.valueOf(sj));
            gt.append("netTaskCostTime", String.valueOf(sr));
            gt.append("netCostTime", String.valueOf(sq));
            gt.append("netNum", String.valueOf(so));
            gt.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", gt);
            sl = 0;
            sj = 0;
            sq = 0;
            so = 0;
            sm = 0;
            sr = 0;
        }
    }
}
