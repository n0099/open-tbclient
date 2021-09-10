package c.a.r0.d2;

import c.a.q0.s.q.d2;
import c.a.q0.s.q.q1;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65536, null, str, obj, i2) == null) {
            if (obj instanceof q1) {
                StatisticItem statisticItem = new StatisticItem(str);
                statisticItem.param("fid", ((q1) obj).o());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.eventStat();
            } else if (obj instanceof c.a.r0.d2.e.b) {
                StatisticItem statisticItem2 = new StatisticItem(str);
                d2 d2Var = ((c.a.r0.d2.e.b) obj).k;
                if (d2Var != null) {
                    statisticItem2.param("tid", d2Var.s1());
                }
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.eventStat();
            }
        }
    }

    public static void b(c.a.r0.d2.d.c.a aVar, c.a.q0.s.q.a aVar2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, aVar, aVar2) == null) || aVar2 == null || aVar2.getThreadData() == null) {
            return;
        }
        d2 threadData = aVar2.getThreadData();
        StatisticItem statisticItem = new StatisticItem(aVar.h0() ? "c13823" : "c13822");
        statisticItem.param("tid", threadData.s1());
        statisticItem.param("fid", threadData.T());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.eventStat();
    }

    public static void c(c.a.r0.d2.d.c.a aVar, c.a.q0.s.q.a aVar2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, aVar, aVar2) == null) || aVar2 == null || aVar2.getThreadData() == null) {
            return;
        }
        d2 threadData = aVar2.getThreadData();
        StatisticItem statisticItem = new StatisticItem(aVar.h0() ? "c13824" : "c13821");
        statisticItem.param("tid", threadData.s1());
        statisticItem.param("fid", threadData.T());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.eventStat();
    }
}
