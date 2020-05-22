package com.baidu.adp.lib.e;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int Lu = 0;
    private static int Lv = 0;
    private static int Lw = 0;
    private static int Lx = 0;
    private static int Ly = 0;
    private static int Lz = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a kY() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    Lw = (int) (Lw + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    Lv = (int) (Lv + aVar2.getTimeCost());
                }
                int i = Lu + 1;
                Lu = i;
                if (i + Lx > 100) {
                    kZ();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    Lz = (int) (Lz + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    Ly = (int) (Ly + aVar2.getTimeCost());
                }
                int i = Lx + 1;
                Lx = i;
                if (i + Lu > 100) {
                    kZ();
                }
            }
        }
    }

    public static void kZ() {
        if (Lu + Lx > 10) {
            com.baidu.adp.lib.stats.a kY = kY();
            kY.append("act", "allStat");
            kY.append("diskTaskCostTime", String.valueOf(Lw));
            kY.append("diskCostTime", String.valueOf(Lv));
            kY.append("diskNum", String.valueOf(Lu));
            kY.append("netTaskCostTime", String.valueOf(Lz));
            kY.append("netCostTime", String.valueOf(Ly));
            kY.append("netNum", String.valueOf(Lx));
            kY.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", kY);
            Lv = 0;
            Lu = 0;
            Ly = 0;
            Lx = 0;
            Lw = 0;
            Lz = 0;
        }
    }
}
