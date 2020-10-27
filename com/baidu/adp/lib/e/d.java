package com.baidu.adp.lib.e;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int Ng = 0;
    private static int Nh = 0;
    private static int Ni = 0;
    private static int Nj = 0;
    private static int Nk = 0;
    private static int Nl = 0;
    private static Object Nm = new Object();

    public static com.baidu.adp.lib.stats.a mT() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (Nm) {
                if (aVar != null) {
                    Ni = (int) (Ni + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    Nh = (int) (Nh + aVar2.getTimeCost());
                }
                int i = Ng + 1;
                Ng = i;
                if (i + Nj > 100) {
                    mU();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (Nm) {
                if (aVar != null) {
                    Nl = (int) (Nl + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    Nk = (int) (Nk + aVar2.getTimeCost());
                }
                int i = Nj + 1;
                Nj = i;
                if (i + Ng > 100) {
                    mU();
                }
            }
        }
    }

    public static void mU() {
        if (Ng + Nj > 10) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("act", "allStat");
            mT.append("diskTaskCostTime", String.valueOf(Ni));
            mT.append("diskCostTime", String.valueOf(Nh));
            mT.append("diskNum", String.valueOf(Ng));
            mT.append("netTaskCostTime", String.valueOf(Nl));
            mT.append("netCostTime", String.valueOf(Nk));
            mT.append("netNum", String.valueOf(Nj));
            mT.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", mT);
            Nh = 0;
            Ng = 0;
            Nk = 0;
            Nj = 0;
            Ni = 0;
            Nl = 0;
        }
    }
}
