package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int wq = 0;
    private static int wr = 0;
    private static int ws = 0;
    private static int wt = 0;
    private static int wu = 0;
    private static int wv = 0;
    private static Object ww = new Object();

    public static com.baidu.adp.lib.stats.c fM() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, com.baidu.adp.lib.stats.c cVar2) {
        if (cVar != null || cVar2 != null) {
            synchronized (ww) {
                if (cVar != null) {
                    ws = (int) (ws + cVar.fW());
                }
                if (cVar2 != null) {
                    wr = (int) (wr + cVar2.fW());
                }
                int i = wq + 1;
                wq = i;
                if (i + wt > 100) {
                    fN();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.c cVar, com.baidu.adp.lib.stats.c cVar2) {
        if (cVar != null || cVar2 != null) {
            synchronized (ww) {
                if (cVar != null) {
                    wv = (int) (wv + cVar.fW());
                }
                if (cVar2 != null) {
                    wu = (int) (wu + cVar2.fW());
                }
                int i = wt + 1;
                wt = i;
                if (i + wq > 100) {
                    fN();
                }
            }
        }
    }

    public static void fN() {
        if (wq + wt > 10) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("act", "allStat");
            fM.p("diskTaskCostTime", String.valueOf(ws));
            fM.p("diskCostTime", String.valueOf(wr));
            fM.p("diskNum", String.valueOf(wq));
            fM.p("netTaskCostTime", String.valueOf(wv));
            fM.p("netCostTime", String.valueOf(wu));
            fM.p("netNum", String.valueOf(wt));
            fM.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fM);
            wr = 0;
            wq = 0;
            wu = 0;
            wt = 0;
            ws = 0;
            wv = 0;
        }
    }
}
