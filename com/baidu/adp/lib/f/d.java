package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class d {
    private static int DK = 0;
    private static int DL = 0;
    private static int DM = 0;
    private static int DN = 0;
    private static int DO = 0;
    private static int DQ = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a jB() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    DM = (int) (DM + aVar.jK());
                }
                if (aVar2 != null) {
                    DL = (int) (DL + aVar2.jK());
                }
                int i = DK + 1;
                DK = i;
                if (i + DN > 100) {
                    jC();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    DQ = (int) (DQ + aVar.jK());
                }
                if (aVar2 != null) {
                    DO = (int) (DO + aVar2.jK());
                }
                int i = DN + 1;
                DN = i;
                if (i + DK > 100) {
                    jC();
                }
            }
        }
    }

    public static void jC() {
        if (DK + DN > 10) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append(SocialConstants.PARAM_ACT, "allStat");
            jB.append("diskTaskCostTime", String.valueOf(DM));
            jB.append("diskCostTime", String.valueOf(DL));
            jB.append("diskNum", String.valueOf(DK));
            jB.append("netTaskCostTime", String.valueOf(DQ));
            jB.append("netCostTime", String.valueOf(DO));
            jB.append("netNum", String.valueOf(DN));
            jB.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
            DL = 0;
            DK = 0;
            DO = 0;
            DN = 0;
            DM = 0;
            DQ = 0;
        }
    }
}
