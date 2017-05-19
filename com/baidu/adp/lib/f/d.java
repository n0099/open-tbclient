package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int wv = 0;
    private static int ww = 0;
    private static int wx = 0;
    private static int wy = 0;
    private static int wz = 0;
    private static int wA = 0;
    private static Object wB = new Object();

    public static com.baidu.adp.lib.stats.c fN() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, com.baidu.adp.lib.stats.c cVar2) {
        if (cVar != null || cVar2 != null) {
            synchronized (wB) {
                if (cVar != null) {
                    wx = (int) (wx + cVar.fX());
                }
                if (cVar2 != null) {
                    ww = (int) (ww + cVar2.fX());
                }
                int i = wv + 1;
                wv = i;
                if (i + wy > 100) {
                    fO();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.c cVar, com.baidu.adp.lib.stats.c cVar2) {
        if (cVar != null || cVar2 != null) {
            synchronized (wB) {
                if (cVar != null) {
                    wA = (int) (wA + cVar.fX());
                }
                if (cVar2 != null) {
                    wz = (int) (wz + cVar2.fX());
                }
                int i = wy + 1;
                wy = i;
                if (i + wv > 100) {
                    fO();
                }
            }
        }
    }

    public static void fO() {
        if (wv + wy > 10) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("act", "allStat");
            fN.p("diskTaskCostTime", String.valueOf(wx));
            fN.p("diskCostTime", String.valueOf(ww));
            fN.p("diskNum", String.valueOf(wv));
            fN.p("netTaskCostTime", String.valueOf(wA));
            fN.p("netCostTime", String.valueOf(wz));
            fN.p("netNum", String.valueOf(wy));
            fN.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fN);
            ww = 0;
            wv = 0;
            wz = 0;
            wy = 0;
            wx = 0;
            wA = 0;
        }
    }
}
