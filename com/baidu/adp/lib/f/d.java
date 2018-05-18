package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class d {
    private static int uD = 0;
    private static int uE = 0;
    private static int uF = 0;
    private static int uG = 0;
    private static int uH = 0;
    private static int uI = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a fq() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    uF = (int) (uF + aVar.fB());
                }
                if (aVar2 != null) {
                    uE = (int) (uE + aVar2.fB());
                }
                int i = uD + 1;
                uD = i;
                if (i + uG > 100) {
                    fs();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    uI = (int) (uI + aVar.fB());
                }
                if (aVar2 != null) {
                    uH = (int) (uH + aVar2.fB());
                }
                int i = uG + 1;
                uG = i;
                if (i + uD > 100) {
                    fs();
                }
            }
        }
    }

    public static void fs() {
        if (uD + uG > 10) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(SocialConstants.PARAM_ACT, "allStat");
            fq.append("diskTaskCostTime", String.valueOf(uF));
            fq.append("diskCostTime", String.valueOf(uE));
            fq.append("diskNum", String.valueOf(uD));
            fq.append("netTaskCostTime", String.valueOf(uI));
            fq.append("netCostTime", String.valueOf(uH));
            fq.append("netNum", String.valueOf(uG));
            fq.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fq);
            uE = 0;
            uD = 0;
            uH = 0;
            uG = 0;
            uF = 0;
            uI = 0;
        }
    }
}
