package com.baidu.adp.lib.e;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int Nf = 0;
    private static int Ng = 0;
    private static int Nh = 0;
    private static int Ni = 0;
    private static int Nj = 0;
    private static int Nk = 0;
    private static Object Nl = new Object();

    public static com.baidu.adp.lib.stats.a mT() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (Nl) {
                if (aVar != null) {
                    Nh = (int) (Nh + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    Ng = (int) (Ng + aVar2.getTimeCost());
                }
                int i = Nf + 1;
                Nf = i;
                if (i + Ni > 100) {
                    mU();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (Nl) {
                if (aVar != null) {
                    Nk = (int) (Nk + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    Nj = (int) (Nj + aVar2.getTimeCost());
                }
                int i = Ni + 1;
                Ni = i;
                if (i + Nf > 100) {
                    mU();
                }
            }
        }
    }

    public static void mU() {
        if (Nf + Ni > 10) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("act", "allStat");
            mT.append("diskTaskCostTime", String.valueOf(Nh));
            mT.append("diskCostTime", String.valueOf(Ng));
            mT.append("diskNum", String.valueOf(Nf));
            mT.append("netTaskCostTime", String.valueOf(Nk));
            mT.append("netCostTime", String.valueOf(Nj));
            mT.append("netNum", String.valueOf(Ni));
            mT.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", mT);
            Ng = 0;
            Nf = 0;
            Nj = 0;
            Ni = 0;
            Nh = 0;
            Nk = 0;
        }
    }
}
