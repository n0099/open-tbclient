package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int ww = 0;
    private static int wx = 0;
    private static int wy = 0;
    private static int wz = 0;
    private static int wA = 0;
    private static int wB = 0;
    private static Object wC = new Object();

    public static com.baidu.adp.lib.stats.a fK() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (wC) {
                if (aVar != null) {
                    wy = (int) (wy + aVar.fU());
                }
                if (aVar2 != null) {
                    wx = (int) (wx + aVar2.fU());
                }
                int i = ww + 1;
                ww = i;
                if (i + wz > 100) {
                    fL();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (wC) {
                if (aVar != null) {
                    wB = (int) (wB + aVar.fU());
                }
                if (aVar2 != null) {
                    wA = (int) (wA + aVar2.fU());
                }
                int i = wz + 1;
                wz = i;
                if (i + ww > 100) {
                    fL();
                }
            }
        }
    }

    public static void fL() {
        if (ww + wz > 10) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "allStat");
            fK.p("diskTaskCostTime", String.valueOf(wy));
            fK.p("diskCostTime", String.valueOf(wx));
            fK.p("diskNum", String.valueOf(ww));
            fK.p("netTaskCostTime", String.valueOf(wB));
            fK.p("netCostTime", String.valueOf(wA));
            fK.p("netNum", String.valueOf(wz));
            fK.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fK);
            wx = 0;
            ww = 0;
            wA = 0;
            wz = 0;
            wy = 0;
            wB = 0;
        }
    }
}
