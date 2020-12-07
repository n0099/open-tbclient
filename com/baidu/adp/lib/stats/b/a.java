package com.baidu.adp.lib.stats.b;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    public static void a(String str, int i, String str2, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, int i2) {
        if (BdBaseApplication.getInst().isSmallFlow()) {
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem(BdStatsConstant.StatsType.PERFORMANCE);
            statsItem.append("action", "network_monitor_a");
            statsItem.append("cmd", String.valueOf(i));
            statsItem.append("url", str2);
            statsItem.append("issuccess", z ? "1" : "0");
            statsItem.append("ishttp", z2 ? "1" : "0");
            statsItem.append("nettype", j.getNetType());
            statsItem.append("connt", String.valueOf(j));
            statsItem.append("rwt", String.valueOf(j2));
            statsItem.append("parset", String.valueOf(j3));
            statsItem.append("fbt", String.valueOf(j4));
            statsItem.append("abt", String.valueOf(j5));
            statsItem.append("salno", String.valueOf(i2));
            BdStatisticsManager.getInstance().performance(str, statsItem);
        }
    }
}
