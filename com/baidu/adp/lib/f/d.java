package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int wN = 0;
    private static int wO = 0;
    private static int wP = 0;
    private static int wQ = 0;
    private static int wR = 0;
    private static int wS = 0;
    private static Object wT = new Object();

    public static com.baidu.adp.lib.stats.c fH() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, com.baidu.adp.lib.stats.c cVar2) {
        if (cVar != null || cVar2 != null) {
            synchronized (wT) {
                if (cVar != null) {
                    wP = (int) (wP + cVar.fR());
                }
                if (cVar2 != null) {
                    wO = (int) (wO + cVar2.fR());
                }
                int i = wN + 1;
                wN = i;
                if (i + wQ > 100) {
                    fI();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.c cVar, com.baidu.adp.lib.stats.c cVar2) {
        if (cVar != null || cVar2 != null) {
            synchronized (wT) {
                if (cVar != null) {
                    wS = (int) (wS + cVar.fR());
                }
                if (cVar2 != null) {
                    wR = (int) (wR + cVar2.fR());
                }
                int i = wQ + 1;
                wQ = i;
                if (i + wN > 100) {
                    fI();
                }
            }
        }
    }

    public static void fI() {
        if (wN + wQ > 10) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("act", "allStat");
            fH.p("diskTaskCostTime", String.valueOf(wP));
            fH.p("diskCostTime", String.valueOf(wO));
            fH.p("diskNum", String.valueOf(wN));
            fH.p("netTaskCostTime", String.valueOf(wS));
            fH.p("netCostTime", String.valueOf(wR));
            fH.p("netNum", String.valueOf(wQ));
            fH.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fH);
            wO = 0;
            wN = 0;
            wR = 0;
            wQ = 0;
            wP = 0;
            wS = 0;
        }
    }
}
