package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class d {
    private static int CY = 0;
    private static int CZ = 0;
    private static int Da = 0;
    private static int Db = 0;
    private static int Dc = 0;
    private static int Dd = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a jo() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    Da = (int) (Da + aVar.jy());
                }
                if (aVar2 != null) {
                    CZ = (int) (CZ + aVar2.jy());
                }
                int i = CY + 1;
                CY = i;
                if (i + Db > 100) {
                    jp();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    Dd = (int) (Dd + aVar.jy());
                }
                if (aVar2 != null) {
                    Dc = (int) (Dc + aVar2.jy());
                }
                int i = Db + 1;
                Db = i;
                if (i + CY > 100) {
                    jp();
                }
            }
        }
    }

    public static void jp() {
        if (CY + Db > 10) {
            com.baidu.adp.lib.stats.a jo = jo();
            jo.append(SocialConstants.PARAM_ACT, "allStat");
            jo.append("diskTaskCostTime", String.valueOf(Da));
            jo.append("diskCostTime", String.valueOf(CZ));
            jo.append("diskNum", String.valueOf(CY));
            jo.append("netTaskCostTime", String.valueOf(Dd));
            jo.append("netCostTime", String.valueOf(Dc));
            jo.append("netNum", String.valueOf(Db));
            jo.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jo);
            CZ = 0;
            CY = 0;
            Dc = 0;
            Db = 0;
            Da = 0;
            Dd = 0;
        }
    }
}
