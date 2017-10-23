package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int vT = 0;
    private static int vU = 0;
    private static int vV = 0;
    private static int vW = 0;
    private static int vX = 0;
    private static int vY = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a fK() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
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
                if (i + vW > 100) {
                    fL();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    vY = (int) (vY + aVar.fU());
                }
                if (aVar2 != null) {
                    vX = (int) (vX + aVar2.fU());
                }
                int i = vW + 1;
                vW = i;
                if (i + vT > 100) {
                    fL();
                }
            }
        }
    }

    public static void fL() {
        if (vT + vW > 10) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "allStat");
            fK.p("diskTaskCostTime", String.valueOf(vV));
            fK.p("diskCostTime", String.valueOf(vU));
            fK.p("diskNum", String.valueOf(vT));
            fK.p("netTaskCostTime", String.valueOf(vY));
            fK.p("netCostTime", String.valueOf(vX));
            fK.p("netNum", String.valueOf(vW));
            fK.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fK);
            vU = 0;
            vT = 0;
            vX = 0;
            vW = 0;
            vV = 0;
            vY = 0;
        }
    }
}
