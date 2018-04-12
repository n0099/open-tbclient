package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class d {
    private static int uE = 0;
    private static int uF = 0;
    private static int uG = 0;
    private static int uH = 0;
    private static int uI = 0;
    private static int uJ = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a fq() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    uG = (int) (uG + aVar.fB());
                }
                if (aVar2 != null) {
                    uF = (int) (uF + aVar2.fB());
                }
                int i = uE + 1;
                uE = i;
                if (i + uH > 100) {
                    fs();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    uJ = (int) (uJ + aVar.fB());
                }
                if (aVar2 != null) {
                    uI = (int) (uI + aVar2.fB());
                }
                int i = uH + 1;
                uH = i;
                if (i + uE > 100) {
                    fs();
                }
            }
        }
    }

    public static void fs() {
        if (uE + uH > 10) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(SocialConstants.PARAM_ACT, "allStat");
            fq.append("diskTaskCostTime", String.valueOf(uG));
            fq.append("diskCostTime", String.valueOf(uF));
            fq.append("diskNum", String.valueOf(uE));
            fq.append("netTaskCostTime", String.valueOf(uJ));
            fq.append("netCostTime", String.valueOf(uI));
            fq.append("netNum", String.valueOf(uH));
            fq.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fq);
            uF = 0;
            uE = 0;
            uI = 0;
            uH = 0;
            uG = 0;
            uJ = 0;
        }
    }
}
