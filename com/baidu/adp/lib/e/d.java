package com.baidu.adp.lib.e;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int LZ = 0;
    private static int Ma = 0;
    private static int Mb = 0;
    private static int Mc = 0;
    private static int Md = 0;
    private static int Me = 0;
    private static Object Mf = new Object();

    public static com.baidu.adp.lib.stats.a lo() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (Mf) {
                if (aVar != null) {
                    Mb = (int) (Mb + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    Ma = (int) (Ma + aVar2.getTimeCost());
                }
                int i = LZ + 1;
                LZ = i;
                if (i + Mc > 100) {
                    lp();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (Mf) {
                if (aVar != null) {
                    Me = (int) (Me + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    Md = (int) (Md + aVar2.getTimeCost());
                }
                int i = Mc + 1;
                Mc = i;
                if (i + LZ > 100) {
                    lp();
                }
            }
        }
    }

    public static void lp() {
        if (LZ + Mc > 10) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("act", "allStat");
            lo.append("diskTaskCostTime", String.valueOf(Mb));
            lo.append("diskCostTime", String.valueOf(Ma));
            lo.append("diskNum", String.valueOf(LZ));
            lo.append("netTaskCostTime", String.valueOf(Me));
            lo.append("netCostTime", String.valueOf(Md));
            lo.append("netNum", String.valueOf(Mc));
            lo.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", lo);
            Ma = 0;
            LZ = 0;
            Md = 0;
            Mc = 0;
            Mb = 0;
            Me = 0;
        }
    }
}
