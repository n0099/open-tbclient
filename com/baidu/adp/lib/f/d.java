package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    private static int qa = 0;
    private static int qb = 0;
    private static int qc = 0;
    private static int qd = 0;
    private static int qe = 0;
    private static int qf = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a fU() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    qc = (int) (qc + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    qb = (int) (qb + aVar2.getTimeCost());
                }
                int i = qa + 1;
                qa = i;
                if (i + qd > 100) {
                    fV();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.a aVar, com.baidu.adp.lib.stats.a aVar2) {
        if (aVar != null || aVar2 != null) {
            synchronized (syncLock) {
                if (aVar != null) {
                    qf = (int) (qf + aVar.getTimeCost());
                }
                if (aVar2 != null) {
                    qe = (int) (qe + aVar2.getTimeCost());
                }
                int i = qd + 1;
                qd = i;
                if (i + qa > 100) {
                    fV();
                }
            }
        }
    }

    public static void fV() {
        if (qa + qd > 10) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("act", "allStat");
            fU.append("diskTaskCostTime", String.valueOf(qc));
            fU.append("diskCostTime", String.valueOf(qb));
            fU.append("diskNum", String.valueOf(qa));
            fU.append("netTaskCostTime", String.valueOf(qf));
            fU.append("netCostTime", String.valueOf(qe));
            fU.append("netNum", String.valueOf(qd));
            fU.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fU);
            qb = 0;
            qa = 0;
            qe = 0;
            qd = 0;
            qc = 0;
            qf = 0;
        }
    }
}
