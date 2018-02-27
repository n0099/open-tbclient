package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class d {
    private static int aka = 0;
    private static int akb = 0;
    private static int akc = 0;
    private static int akd = 0;
    private static int ake = 0;
    private static int akf = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a nn() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    akc = (int) (akc + aVar.nx());
                }
                if (aVar2 != null) {
                    akb = (int) (akb + aVar2.nx());
                }
                int i = aka + 1;
                aka = i;
                if (i + akd > 100) {
                    no();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    akf = (int) (akf + aVar.nx());
                }
                if (aVar2 != null) {
                    ake = (int) (ake + aVar2.nx());
                }
                int i = akd + 1;
                akd = i;
                if (i + aka > 100) {
                    no();
                }
            }
        }
    }

    public static void no() {
        if (aka + akd > 10) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(SocialConstants.PARAM_ACT, "allStat");
            nn.append("diskTaskCostTime", String.valueOf(akc));
            nn.append("diskCostTime", String.valueOf(akb));
            nn.append("diskNum", String.valueOf(aka));
            nn.append("netTaskCostTime", String.valueOf(akf));
            nn.append("netCostTime", String.valueOf(ake));
            nn.append("netNum", String.valueOf(akd));
            nn.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", nn);
            akb = 0;
            aka = 0;
            ake = 0;
            akd = 0;
            akc = 0;
            akf = 0;
        }
    }
}
