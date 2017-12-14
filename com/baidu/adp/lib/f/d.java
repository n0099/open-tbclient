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

    public static com.baidu.adp.lib.stats.a fK() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    vS = (int) (vS + aVar.fU());
                }
                if (aVar2 != null) {
                    vR = (int) (vR + aVar2.fU());
                }
                int i = vQ + 1;
                vQ = i;
                if (i + vT > 100) {
                    fL();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    vV = (int) (vV + aVar.fU());
                }
                if (aVar2 != null) {
                    vU = (int) (vU + aVar2.fU());
                }
                int i = vT + 1;
                vT = i;
                if (i + vQ > 100) {
                    fL();
                }
            }
        }
    }

    public static void fL() {
        if (vQ + vT > 10) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "allStat");
            fK.p("diskTaskCostTime", String.valueOf(vS));
            fK.p("diskCostTime", String.valueOf(vR));
            fK.p("diskNum", String.valueOf(vQ));
            fK.p("netTaskCostTime", String.valueOf(vV));
            fK.p("netCostTime", String.valueOf(vU));
            fK.p("netNum", String.valueOf(vT));
            fK.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fK);
            vR = 0;
            vQ = 0;
            vU = 0;
            vT = 0;
            vS = 0;
            vV = 0;
        }
    }
}
