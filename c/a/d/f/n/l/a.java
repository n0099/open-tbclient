package c.a.d.f.n.l;

import c.a.d.f.p.k;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, int i2, String str2, boolean z, boolean z2, long j2, long j3, long j4, long j5, long j6, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Integer.valueOf(i2), str2, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i3)}) == null) && BdBaseApplication.getInst().isSmallFlow()) {
            c.a.d.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", "network_monitor_a");
            statsItem.b("cmd", String.valueOf(i2));
            statsItem.b("url", str2);
            statsItem.b("issuccess", z ? "1" : "0");
            statsItem.b("ishttp", z2 ? "1" : "0");
            statsItem.b("nettype", k.m());
            statsItem.b("connt", String.valueOf(j2));
            statsItem.b("rwt", String.valueOf(j3));
            statsItem.b("parset", String.valueOf(j4));
            statsItem.b("fbt", String.valueOf(j5));
            statsItem.b("abt", String.valueOf(j6));
            statsItem.b("salno", String.valueOf(i3));
            BdStatisticsManager.getInstance().performance(str, statsItem);
        }
    }
}
