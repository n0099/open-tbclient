package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int wu = 0;
    private static int wv = 0;
    private static int ww = 0;
    private static int wx = 0;
    private static int wy = 0;
    private static int wz = 0;
    private static Object wA = new Object();

    public static com.baidu.adp.lib.stats.c fN() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, com.baidu.adp.lib.stats.c cVar2) {
        if (cVar != null || cVar2 != null) {
            synchronized (wA) {
                if (cVar != null) {
                    ww = (int) (ww + cVar.fX());
                }
                if (cVar2 != null) {
                    wv = (int) (wv + cVar2.fX());
                }
                int i = wu + 1;
                wu = i;
                if (i + wx > 100) {
                    fO();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.c cVar, com.baidu.adp.lib.stats.c cVar2) {
        if (cVar != null || cVar2 != null) {
            synchronized (wA) {
                if (cVar != null) {
                    wz = (int) (wz + cVar.fX());
                }
                if (cVar2 != null) {
                    wy = (int) (wy + cVar2.fX());
                }
                int i = wx + 1;
                wx = i;
                if (i + wu > 100) {
                    fO();
                }
            }
        }
    }

    public static void fO() {
        if (wu + wx > 10) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("act", "allStat");
            fN.p("diskTaskCostTime", String.valueOf(ww));
            fN.p("diskCostTime", String.valueOf(wv));
            fN.p("diskNum", String.valueOf(wu));
            fN.p("netTaskCostTime", String.valueOf(wz));
            fN.p("netCostTime", String.valueOf(wy));
            fN.p("netNum", String.valueOf(wx));
            fN.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fN);
            wv = 0;
            wu = 0;
            wy = 0;
            wx = 0;
            ww = 0;
            wz = 0;
        }
    }
}
