package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int xX = 0;
    private static int xY = 0;
    private static int xZ = 0;
    private static int ya = 0;
    private static int yb = 0;
    private static int yc = 0;
    private static Object yd = new Object();

    public static com.baidu.adp.lib.stats.a fV() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (yd) {
                if (aVar != null) {
                    xZ = (int) (xZ + aVar.gf());
                }
                if (aVar2 != null) {
                    xY = (int) (xY + aVar2.gf());
                }
                int i = xX + 1;
                xX = i;
                if (i + ya > 100) {
                    fW();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (yd) {
                if (aVar != null) {
                    yc = (int) (yc + aVar.gf());
                }
                if (aVar2 != null) {
                    yb = (int) (yb + aVar2.gf());
                }
                int i = ya + 1;
                ya = i;
                if (i + xX > 100) {
                    fW();
                }
            }
        }
    }

    public static void fW() {
        if (xX + ya > 10) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("act", "allStat");
            fV.p("diskTaskCostTime", String.valueOf(xZ));
            fV.p("diskCostTime", String.valueOf(xY));
            fV.p("diskNum", String.valueOf(xX));
            fV.p("netTaskCostTime", String.valueOf(yc));
            fV.p("netCostTime", String.valueOf(yb));
            fV.p("netNum", String.valueOf(ya));
            fV.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fV);
            xY = 0;
            xX = 0;
            yb = 0;
            ya = 0;
            xZ = 0;
            yc = 0;
        }
    }
}
