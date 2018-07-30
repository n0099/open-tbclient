package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class d {
    private static int AB = 0;
    private static int AC = 0;
    private static int AD = 0;
    private static int AE = 0;
    private static int AF = 0;
    private static int AG = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a ii() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    AD = (int) (AD + aVar.is());
                }
                if (aVar2 != null) {
                    AC = (int) (AC + aVar2.is());
                }
                int i = AB + 1;
                AB = i;
                if (i + AE > 100) {
                    ij();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    AG = (int) (AG + aVar.is());
                }
                if (aVar2 != null) {
                    AF = (int) (AF + aVar2.is());
                }
                int i = AE + 1;
                AE = i;
                if (i + AB > 100) {
                    ij();
                }
            }
        }
    }

    public static void ij() {
        if (AB + AE > 10) {
            com.baidu.adp.lib.stats.a ii = ii();
            ii.append(SocialConstants.PARAM_ACT, "allStat");
            ii.append("diskTaskCostTime", String.valueOf(AD));
            ii.append("diskCostTime", String.valueOf(AC));
            ii.append("diskNum", String.valueOf(AB));
            ii.append("netTaskCostTime", String.valueOf(AG));
            ii.append("netCostTime", String.valueOf(AF));
            ii.append("netNum", String.valueOf(AE));
            ii.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ii);
            AC = 0;
            AB = 0;
            AF = 0;
            AE = 0;
            AD = 0;
            AG = 0;
        }
    }
}
