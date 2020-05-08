package com.baidu.adp.lib.e;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int Lj = 0;
    private static int Lk = 0;
    private static int Ll = 0;
    private static int Lm = 0;
    private static int Ln = 0;
    private static int Lo = 0;
    private static Object Lp = new Object();

    public static com.baidu.adp.lib.stats.a kW() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (Lp) {
                if (aVar != null) {
                    Ll = (int) (Ll + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    Lk = (int) (Lk + aVar2.getTimeCost());
                }
                int i = Lj + 1;
                Lj = i;
                if (i + Lm > 100) {
                    kX();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (Lp) {
                if (aVar != null) {
                    Lo = (int) (Lo + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    Ln = (int) (Ln + aVar2.getTimeCost());
                }
                int i = Lm + 1;
                Lm = i;
                if (i + Lj > 100) {
                    kX();
                }
            }
        }
    }

    public static void kX() {
        if (Lj + Lm > 10) {
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("act", "allStat");
            kW.append("diskTaskCostTime", String.valueOf(Ll));
            kW.append("diskCostTime", String.valueOf(Lk));
            kW.append("diskNum", String.valueOf(Lj));
            kW.append("netTaskCostTime", String.valueOf(Lo));
            kW.append("netCostTime", String.valueOf(Ln));
            kW.append("netNum", String.valueOf(Lm));
            kW.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", kW);
            Lk = 0;
            Lj = 0;
            Ln = 0;
            Lm = 0;
            Ll = 0;
            Lo = 0;
        }
    }
}
