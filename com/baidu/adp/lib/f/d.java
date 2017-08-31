package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int vQ = 0;
    private static int vR = 0;
    private static int vS = 0;
    private static int vT = 0;
    private static int vU = 0;
    private static int vV = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a fL() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    vS = (int) (vS + aVar.fV());
                }
                if (aVar2 != null) {
                    vR = (int) (vR + aVar2.fV());
                }
                int i = vQ + 1;
                vQ = i;
                if (i + vT > 100) {
                    fM();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    vV = (int) (vV + aVar.fV());
                }
                if (aVar2 != null) {
                    vU = (int) (vU + aVar2.fV());
                }
                int i = vT + 1;
                vT = i;
                if (i + vQ > 100) {
                    fM();
                }
            }
        }
    }

    public static void fM() {
        if (vQ + vT > 10) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("act", "allStat");
            fL.p("diskTaskCostTime", String.valueOf(vS));
            fL.p("diskCostTime", String.valueOf(vR));
            fL.p("diskNum", String.valueOf(vQ));
            fL.p("netTaskCostTime", String.valueOf(vV));
            fL.p("netCostTime", String.valueOf(vU));
            fL.p("netNum", String.valueOf(vT));
            fL.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fL);
            vR = 0;
            vQ = 0;
            vU = 0;
            vT = 0;
            vS = 0;
            vV = 0;
        }
    }
}
