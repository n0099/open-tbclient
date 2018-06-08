package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class d {
    private static int AG = 0;
    private static int AH = 0;
    private static int AI = 0;
    private static int AJ = 0;
    private static int AK = 0;
    private static int AM = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a ih() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    AI = (int) (AI + aVar.ir());
                }
                if (aVar2 != null) {
                    AH = (int) (AH + aVar2.ir());
                }
                int i = AG + 1;
                AG = i;
                if (i + AJ > 100) {
                    ii();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    AM = (int) (AM + aVar.ir());
                }
                if (aVar2 != null) {
                    AK = (int) (AK + aVar2.ir());
                }
                int i = AJ + 1;
                AJ = i;
                if (i + AG > 100) {
                    ii();
                }
            }
        }
    }

    public static void ii() {
        if (AG + AJ > 10) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(SocialConstants.PARAM_ACT, "allStat");
            ih.append("diskTaskCostTime", String.valueOf(AI));
            ih.append("diskCostTime", String.valueOf(AH));
            ih.append("diskNum", String.valueOf(AG));
            ih.append("netTaskCostTime", String.valueOf(AM));
            ih.append("netCostTime", String.valueOf(AK));
            ih.append("netNum", String.valueOf(AJ));
            ih.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", ih);
            AH = 0;
            AG = 0;
            AK = 0;
            AJ = 0;
            AI = 0;
            AM = 0;
        }
    }
}
