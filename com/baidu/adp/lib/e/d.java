package com.baidu.adp.lib.e;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int LY = 0;
    private static int LZ = 0;
    private static int Ma = 0;
    private static int Mb = 0;
    private static int Mc = 0;
    private static int Md = 0;
    private static Object Me = new Object();

    public static com.baidu.adp.lib.stats.a lo() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (Me) {
                if (aVar != null) {
                    Ma = (int) (Ma + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    LZ = (int) (LZ + aVar2.getTimeCost());
                }
                int i = LY + 1;
                LY = i;
                if (i + Mb > 100) {
                    lp();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (Me) {
                if (aVar != null) {
                    Md = (int) (Md + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    Mc = (int) (Mc + aVar2.getTimeCost());
                }
                int i = Mb + 1;
                Mb = i;
                if (i + LY > 100) {
                    lp();
                }
            }
        }
    }

    public static void lp() {
        if (LY + Mb > 10) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("act", "allStat");
            lo.append("diskTaskCostTime", String.valueOf(Ma));
            lo.append("diskCostTime", String.valueOf(LZ));
            lo.append("diskNum", String.valueOf(LY));
            lo.append("netTaskCostTime", String.valueOf(Md));
            lo.append("netCostTime", String.valueOf(Mc));
            lo.append("netNum", String.valueOf(Mb));
            lo.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", lo);
            LZ = 0;
            LY = 0;
            Mc = 0;
            Mb = 0;
            Ma = 0;
            Md = 0;
        }
    }
}
