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

    public static com.baidu.adp.lib.stats.c fM() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, com.baidu.adp.lib.stats.c cVar2) {
        if (cVar != null || cVar2 != null) {
            synchronized (wB) {
                if (cVar != null) {
                    wx = (int) (wx + cVar.fW());
                }
                if (cVar2 != null) {
                    ww = (int) (ww + cVar2.fW());
                }
                int i = wv + 1;
                wv = i;
                if (i + wy > 100) {
                    fN();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.c cVar, com.baidu.adp.lib.stats.c cVar2) {
        if (cVar != null || cVar2 != null) {
            synchronized (wB) {
                if (cVar != null) {
                    wA = (int) (wA + cVar.fW());
                }
                if (cVar2 != null) {
                    wz = (int) (wz + cVar2.fW());
                }
                int i = wy + 1;
                wy = i;
                if (i + wv > 100) {
                    fN();
                }
            }
        }
    }

    public static void fN() {
        if (wv + wy > 10) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("act", "allStat");
            fM.p("diskTaskCostTime", String.valueOf(wx));
            fM.p("diskCostTime", String.valueOf(ww));
            fM.p("diskNum", String.valueOf(wv));
            fM.p("netTaskCostTime", String.valueOf(wA));
            fM.p("netCostTime", String.valueOf(wz));
            fM.p("netNum", String.valueOf(wy));
            fM.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fM);
            ww = 0;
            wv = 0;
            wz = 0;
            wy = 0;
            wx = 0;
            wA = 0;
        }
    }
}
