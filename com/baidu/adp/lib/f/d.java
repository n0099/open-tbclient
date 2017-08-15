package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int xZ = 0;
    private static int ya = 0;
    private static int yb = 0;
    private static int yc = 0;
    private static int yd = 0;
    private static int ye = 0;
    private static Object yf = new Object();

    public static com.baidu.adp.lib.stats.a fV() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (yf) {
                if (aVar != null) {
                    yb = (int) (yb + aVar.gf());
                }
                if (aVar2 != null) {
                    ya = (int) (ya + aVar2.gf());
                }
                int i = xZ + 1;
                xZ = i;
                if (i + yc > 100) {
                    fW();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (yf) {
                if (aVar != null) {
                    ye = (int) (ye + aVar.gf());
                }
                if (aVar2 != null) {
                    yd = (int) (yd + aVar2.gf());
                }
                int i = yc + 1;
                yc = i;
                if (i + xZ > 100) {
                    fW();
                }
            }
        }
    }

    public static void fW() {
        if (xZ + yc > 10) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("act", "allStat");
            fV.p("diskTaskCostTime", String.valueOf(yb));
            fV.p("diskCostTime", String.valueOf(ya));
            fV.p("diskNum", String.valueOf(xZ));
            fV.p("netTaskCostTime", String.valueOf(ye));
            fV.p("netCostTime", String.valueOf(yd));
            fV.p("netNum", String.valueOf(yc));
            fV.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fV);
            ya = 0;
            xZ = 0;
            yd = 0;
            yc = 0;
            yb = 0;
            ye = 0;
        }
    }
}
