package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int akh = 0;
    private static int aki = 0;
    private static int akj = 0;
    private static int akk = 0;
    private static int akl = 0;
    private static int akm = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a nn() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    akj = (int) (akj + aVar.nx());
                }
                if (aVar2 != null) {
                    aki = (int) (aki + aVar2.nx());
                }
                int i = akh + 1;
                akh = i;
                if (i + akk > 100) {
                    no();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    akm = (int) (akm + aVar.nx());
                }
                if (aVar2 != null) {
                    akl = (int) (akl + aVar2.nx());
                }
                int i = akk + 1;
                akk = i;
                if (i + akh > 100) {
                    no();
                }
            }
        }
    }

    public static void no() {
        if (akh + akk > 10) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("act", "allStat");
            nn.append("diskTaskCostTime", String.valueOf(akj));
            nn.append("diskCostTime", String.valueOf(aki));
            nn.append("diskNum", String.valueOf(akh));
            nn.append("netTaskCostTime", String.valueOf(akm));
            nn.append("netCostTime", String.valueOf(akl));
            nn.append("netNum", String.valueOf(akk));
            nn.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", nn);
            aki = 0;
            akh = 0;
            akl = 0;
            akk = 0;
            akj = 0;
            akm = 0;
        }
    }
}
