package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class d {
    private static int By = 0;
    private static int Bz = 0;
    private static int BA = 0;
    private static int BB = 0;
    private static int BC = 0;
    private static int BD = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a iF() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    BA = (int) (BA + aVar.iP());
                }
                if (aVar2 != null) {
                    Bz = (int) (Bz + aVar2.iP());
                }
                int i = By + 1;
                By = i;
                if (i + BB > 100) {
                    iG();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    BD = (int) (BD + aVar.iP());
                }
                if (aVar2 != null) {
                    BC = (int) (BC + aVar2.iP());
                }
                int i = BB + 1;
                BB = i;
                if (i + By > 100) {
                    iG();
                }
            }
        }
    }

    public static void iG() {
        if (By + BB > 10) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append(SocialConstants.PARAM_ACT, "allStat");
            iF.append("diskTaskCostTime", String.valueOf(BA));
            iF.append("diskCostTime", String.valueOf(Bz));
            iF.append("diskNum", String.valueOf(By));
            iF.append("netTaskCostTime", String.valueOf(BD));
            iF.append("netCostTime", String.valueOf(BC));
            iF.append("netNum", String.valueOf(BB));
            iF.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
            Bz = 0;
            By = 0;
            BC = 0;
            BB = 0;
            BA = 0;
            BD = 0;
        }
    }
}
