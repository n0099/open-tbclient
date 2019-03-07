package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class d {
    private static int DJ = 0;
    private static int DK = 0;
    private static int DL = 0;
    private static int DM = 0;
    private static int DN = 0;
    private static int DO = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a jC() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    DL = (int) (DL + aVar.jM());
                }
                if (aVar2 != null) {
                    DK = (int) (DK + aVar2.jM());
                }
                int i = DJ + 1;
                DJ = i;
                if (i + DM > 100) {
                    jD();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    DO = (int) (DO + aVar.jM());
                }
                if (aVar2 != null) {
                    DN = (int) (DN + aVar2.jM());
                }
                int i = DM + 1;
                DM = i;
                if (i + DJ > 100) {
                    jD();
                }
            }
        }
    }

    public static void jD() {
        if (DJ + DM > 10) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append(SocialConstants.PARAM_ACT, "allStat");
            jC.append("diskTaskCostTime", String.valueOf(DL));
            jC.append("diskCostTime", String.valueOf(DK));
            jC.append("diskNum", String.valueOf(DJ));
            jC.append("netTaskCostTime", String.valueOf(DO));
            jC.append("netCostTime", String.valueOf(DN));
            jC.append("netNum", String.valueOf(DM));
            jC.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
            DK = 0;
            DJ = 0;
            DN = 0;
            DM = 0;
            DL = 0;
            DO = 0;
        }
    }
}
