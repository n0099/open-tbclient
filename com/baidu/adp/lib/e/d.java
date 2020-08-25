package com.baidu.adp.lib.e;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int MC = 0;
    private static int MD = 0;
    private static int ME = 0;
    private static int MF = 0;
    private static int MG = 0;
    private static int MH = 0;
    private static Object MI = new Object();

    public static com.baidu.adp.lib.stats.a mN() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (MI) {
                if (aVar != null) {
                    ME = (int) (ME + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    MD = (int) (MD + aVar2.getTimeCost());
                }
                int i = MC + 1;
                MC = i;
                if (i + MF > 100) {
                    mO();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (MI) {
                if (aVar != null) {
                    MH = (int) (MH + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    MG = (int) (MG + aVar2.getTimeCost());
                }
                int i = MF + 1;
                MF = i;
                if (i + MC > 100) {
                    mO();
                }
            }
        }
    }

    public static void mO() {
        if (MC + MF > 10) {
            com.baidu.adp.lib.stats.a mN = mN();
            mN.append("act", "allStat");
            mN.append("diskTaskCostTime", String.valueOf(ME));
            mN.append("diskCostTime", String.valueOf(MD));
            mN.append("diskNum", String.valueOf(MC));
            mN.append("netTaskCostTime", String.valueOf(MH));
            mN.append("netCostTime", String.valueOf(MG));
            mN.append("netNum", String.valueOf(MF));
            mN.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", mN);
            MD = 0;
            MC = 0;
            MG = 0;
            MF = 0;
            ME = 0;
            MH = 0;
        }
    }
}
