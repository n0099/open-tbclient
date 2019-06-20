package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class d {
    private static int Bs = 0;
    private static int Bt = 0;
    private static int Bu = 0;
    private static int Bv = 0;
    private static int Bw = 0;
    private static int Bx = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a iw() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    Bu = (int) (Bu + aVar.iG());
                }
                if (aVar2 != null) {
                    Bt = (int) (Bt + aVar2.iG());
                }
                int i = Bs + 1;
                Bs = i;
                if (i + Bv > 100) {
                    ix();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    Bx = (int) (Bx + aVar.iG());
                }
                if (aVar2 != null) {
                    Bw = (int) (Bw + aVar2.iG());
                }
                int i = Bv + 1;
                Bv = i;
                if (i + Bs > 100) {
                    ix();
                }
            }
        }
    }

    public static void ix() {
        if (Bs + Bv > 10) {
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append(SocialConstants.PARAM_ACT, "allStat");
            iw.append("diskTaskCostTime", String.valueOf(Bu));
            iw.append("diskCostTime", String.valueOf(Bt));
            iw.append("diskNum", String.valueOf(Bs));
            iw.append("netTaskCostTime", String.valueOf(Bx));
            iw.append("netCostTime", String.valueOf(Bw));
            iw.append("netNum", String.valueOf(Bv));
            iw.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
            Bt = 0;
            Bs = 0;
            Bw = 0;
            Bv = 0;
            Bu = 0;
            Bx = 0;
        }
    }
}
