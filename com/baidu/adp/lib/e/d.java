package com.baidu.adp.lib.e;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int Ob = 0;
    private static int Oc = 0;
    private static int Od = 0;
    private static int Oe = 0;
    private static int Of = 0;
    private static int Og = 0;
    private static Object Oh = new Object();

    public static com.baidu.adp.lib.stats.a mT() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void mU() {
        if (Ob + Oe > 10) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("act", "allStat");
            mT.append("diskTaskCostTime", String.valueOf(Od));
            mT.append("diskCostTime", String.valueOf(Oc));
            mT.append("diskNum", String.valueOf(Ob));
            mT.append("netTaskCostTime", String.valueOf(Og));
            mT.append("netCostTime", String.valueOf(Of));
            mT.append("netNum", String.valueOf(Oe));
            mT.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", mT);
            Oc = 0;
            Ob = 0;
            Of = 0;
            Oe = 0;
            Od = 0;
            Og = 0;
        }
    }
}
