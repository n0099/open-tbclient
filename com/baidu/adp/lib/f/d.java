package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class d {
    private static int DG = 0;
    private static int DH = 0;
    private static int DI = 0;
    private static int DJ = 0;
    private static int DK = 0;
    private static int DL = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a jD() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    DI = (int) (DI + aVar.jM());
                }
                if (aVar2 != null) {
                    DH = (int) (DH + aVar2.jM());
                }
                int i = DG + 1;
                DG = i;
                if (i + DJ > 100) {
                    jE();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
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
                if (i + DG > 100) {
                    jE();
                }
            }
        }
    }

    public static void jE() {
        if (DG + DJ > 10) {
            com.baidu.adp.lib.stats.a jD = jD();
            jD.append(SocialConstants.PARAM_ACT, "allStat");
            jD.append("diskTaskCostTime", String.valueOf(DI));
            jD.append("diskCostTime", String.valueOf(DH));
            jD.append("diskNum", String.valueOf(DG));
            jD.append("netTaskCostTime", String.valueOf(DL));
            jD.append("netCostTime", String.valueOf(DK));
            jD.append("netNum", String.valueOf(DJ));
            jD.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jD);
            DH = 0;
            DG = 0;
            DK = 0;
            DJ = 0;
            DI = 0;
            DL = 0;
        }
    }
}
