package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class d {
    private static int AC = 0;
    private static int AD = 0;
    private static int AE = 0;
    private static int AF = 0;
    private static int AG = 0;
    private static int AH = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a ii() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    AE = (int) (AE + aVar.is());
                }
                if (aVar2 != null) {
                    AD = (int) (AD + aVar2.is());
                }
                int i = AC + 1;
                AC = i;
                if (i + AF > 100) {
                    ij();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    AH = (int) (AH + aVar.is());
                }
                if (aVar2 != null) {
                    AG = (int) (AG + aVar2.is());
                }
                int i = AF + 1;
                AF = i;
                if (i + AC > 100) {
                    ij();
                }
            }
        }
    }

    public static void ij() {
        if (AC + AF > 10) {
            com.baidu.adp.lib.stats.a ii = ii();
            ii.append(SocialConstants.PARAM_ACT, "allStat");
            ii.append("diskTaskCostTime", String.valueOf(AE));
            ii.append("diskCostTime", String.valueOf(AD));
            ii.append("diskNum", String.valueOf(AC));
            ii.append("netTaskCostTime", String.valueOf(AH));
            ii.append("netCostTime", String.valueOf(AG));
            ii.append("netNum", String.valueOf(AF));
            ii.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ii);
            AD = 0;
            AC = 0;
            AG = 0;
            AF = 0;
            AE = 0;
            AH = 0;
        }
    }
}
