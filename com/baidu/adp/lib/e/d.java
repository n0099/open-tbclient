package com.baidu.adp.lib.e;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int Lg = 0;
    private static int Lh = 0;
    private static int Li = 0;
    private static int Lj = 0;
    private static int Lk = 0;
    private static int Ll = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a kW() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    Li = (int) (Li + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    Lh = (int) (Lh + aVar2.getTimeCost());
                }
                int i = Lg + 1;
                Lg = i;
                if (i + Lj > 100) {
                    kX();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    Ll = (int) (Ll + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    Lk = (int) (Lk + aVar2.getTimeCost());
                }
                int i = Lj + 1;
                Lj = i;
                if (i + Lg > 100) {
                    kX();
                }
            }
        }
    }

    public static void kX() {
        if (Lg + Lj > 10) {
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("act", "allStat");
            kW.append("diskTaskCostTime", String.valueOf(Li));
            kW.append("diskCostTime", String.valueOf(Lh));
            kW.append("diskNum", String.valueOf(Lg));
            kW.append("netTaskCostTime", String.valueOf(Ll));
            kW.append("netCostTime", String.valueOf(Lk));
            kW.append("netNum", String.valueOf(Lj));
            kW.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", kW);
            Lh = 0;
            Lg = 0;
            Lk = 0;
            Lj = 0;
            Li = 0;
            Ll = 0;
        }
    }
}
