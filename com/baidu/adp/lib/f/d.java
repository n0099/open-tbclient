package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int vR = 0;
    private static int vS = 0;
    private static int vT = 0;
    private static int vU = 0;
    private static int vV = 0;
    private static int vW = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a fK() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    vT = (int) (vT + aVar.fU());
                }
                if (aVar2 != null) {
                    vS = (int) (vS + aVar2.fU());
                }
                int i = vR + 1;
                vR = i;
                if (i + vU > 100) {
                    fL();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    vW = (int) (vW + aVar.fU());
                }
                if (aVar2 != null) {
                    vV = (int) (vV + aVar2.fU());
                }
                int i = vU + 1;
                vU = i;
                if (i + vR > 100) {
                    fL();
                }
            }
        }
    }

    public static void fL() {
        if (vR + vU > 10) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "allStat");
            fK.p("diskTaskCostTime", String.valueOf(vT));
            fK.p("diskCostTime", String.valueOf(vS));
            fK.p("diskNum", String.valueOf(vR));
            fK.p("netTaskCostTime", String.valueOf(vW));
            fK.p("netCostTime", String.valueOf(vV));
            fK.p("netNum", String.valueOf(vU));
            fK.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fK);
            vS = 0;
            vR = 0;
            vV = 0;
            vU = 0;
            vT = 0;
            vW = 0;
        }
    }
}
