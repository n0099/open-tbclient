package com.baidu.adp.lib.e;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int MP = 0;
    private static int MQ = 0;
    private static int MR = 0;
    private static int MS = 0;
    private static int MT = 0;
    private static int MU = 0;
    private static Object MV = new Object();

    public static com.baidu.adp.lib.stats.a mS() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (MV) {
                if (aVar != null) {
                    MR = (int) (MR + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    MQ = (int) (MQ + aVar2.getTimeCost());
                }
                int i = MP + 1;
                MP = i;
                if (i + MS > 100) {
                    mT();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (MV) {
                if (aVar != null) {
                    MU = (int) (MU + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    MT = (int) (MT + aVar2.getTimeCost());
                }
                int i = MS + 1;
                MS = i;
                if (i + MP > 100) {
                    mT();
                }
            }
        }
    }

    public static void mT() {
        if (MP + MS > 10) {
            com.baidu.adp.lib.stats.a mS = mS();
            mS.append("act", "allStat");
            mS.append("diskTaskCostTime", String.valueOf(MR));
            mS.append("diskCostTime", String.valueOf(MQ));
            mS.append("diskNum", String.valueOf(MP));
            mS.append("netTaskCostTime", String.valueOf(MU));
            mS.append("netCostTime", String.valueOf(MT));
            mS.append("netNum", String.valueOf(MS));
            mS.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", mS);
            MQ = 0;
            MP = 0;
            MT = 0;
            MS = 0;
            MR = 0;
            MU = 0;
        }
    }
}
