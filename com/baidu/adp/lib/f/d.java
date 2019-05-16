package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class d {
    private static int Bt = 0;
    private static int Bu = 0;
    private static int Bv = 0;
    private static int Bw = 0;
    private static int Bx = 0;
    private static int By = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a iw() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    Bv = (int) (Bv + aVar.iG());
                }
                if (aVar2 != null) {
                    Bu = (int) (Bu + aVar2.iG());
                }
                int i = Bt + 1;
                Bt = i;
                if (i + Bw > 100) {
                    ix();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    By = (int) (By + aVar.iG());
                }
                if (aVar2 != null) {
                    Bx = (int) (Bx + aVar2.iG());
                }
                int i = Bw + 1;
                Bw = i;
                if (i + Bt > 100) {
                    ix();
                }
            }
        }
    }

    public static void ix() {
        if (Bt + Bw > 10) {
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append(SocialConstants.PARAM_ACT, "allStat");
            iw.append("diskTaskCostTime", String.valueOf(Bv));
            iw.append("diskCostTime", String.valueOf(Bu));
            iw.append("diskNum", String.valueOf(Bt));
            iw.append("netTaskCostTime", String.valueOf(By));
            iw.append("netCostTime", String.valueOf(Bx));
            iw.append("netNum", String.valueOf(Bw));
            iw.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
            Bu = 0;
            Bt = 0;
            Bx = 0;
            Bw = 0;
            Bv = 0;
            By = 0;
        }
    }
}
