package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class d {
    private static int akg = 0;
    private static int akh = 0;
    private static int aki = 0;
    private static int akj = 0;
    private static int akk = 0;
    private static int akl = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a nn() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    aki = (int) (aki + aVar.nx());
                }
                if (aVar2 != null) {
                    akh = (int) (akh + aVar2.nx());
                }
                int i = akg + 1;
                akg = i;
                if (i + akj > 100) {
                    no();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    akl = (int) (akl + aVar.nx());
                }
                if (aVar2 != null) {
                    akk = (int) (akk + aVar2.nx());
                }
                int i = akj + 1;
                akj = i;
                if (i + akg > 100) {
                    no();
                }
            }
        }
    }

    public static void no() {
        if (akg + akj > 10) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(SocialConstants.PARAM_ACT, "allStat");
            nn.append("diskTaskCostTime", String.valueOf(aki));
            nn.append("diskCostTime", String.valueOf(akh));
            nn.append("diskNum", String.valueOf(akg));
            nn.append("netTaskCostTime", String.valueOf(akl));
            nn.append("netCostTime", String.valueOf(akk));
            nn.append("netNum", String.valueOf(akj));
            nn.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", nn);
            akh = 0;
            akg = 0;
            akk = 0;
            akj = 0;
            aki = 0;
            akl = 0;
        }
    }
}
