package c.a.p0.q1.g.a;

import android.view.View;
import c.a.p0.q1.g.a.e.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view, Object obj, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65536, null, view, obj, i, str) == null) {
            if (obj instanceof c.a.p0.q1.g.a.e.c) {
                c.a.p0.q1.g.a.e.c cVar = (c.a.p0.q1.g.a.e.c) obj;
                if (cVar.f17324e) {
                    StatisticItem statisticItem = new StatisticItem("c13736");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.eventStat();
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13735");
                statisticItem2.param("obj_locate", str);
                statisticItem2.param("topic_id", cVar.a);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.eventStat();
            } else if (obj instanceof e) {
                ThreadData threadData = ((e) obj).f17330f;
                StatisticItem statisticItem3 = new StatisticItem("c13738");
                statisticItem3.param("obj_type", str);
                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (threadData != null) {
                    statisticItem3.param("tid", threadData.getTid());
                    statisticItem3.param("fid", threadData.getFid());
                }
                statisticItem3.eventStat();
            } else if ((obj instanceof c.a.o0.r.r.a) && c(view)) {
                ThreadData threadData2 = ((c.a.o0.r.r.a) obj).getThreadData();
                StatisticItem statisticItem4 = new StatisticItem("c13738");
                statisticItem4.param("obj_type", str);
                statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (threadData2 != null) {
                    statisticItem4.param("tid", threadData2.getTid());
                    statisticItem4.param("fid", threadData2.getFid());
                }
                statisticItem4.eventStat();
            }
        }
    }

    public static void b(View view, Object obj, String str) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, view, obj, str) == null) {
            StatisticItem statisticItem = new StatisticItem("c13825");
            statisticItem.param("obj_type", str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (obj instanceof e) {
                threadData = ((e) obj).f17330f;
            } else {
                threadData = obj instanceof c.a.o0.r.r.a ? ((c.a.o0.r.r.a) obj).getThreadData() : null;
            }
            if (threadData != null) {
                statisticItem.param("tid", threadData.getTid());
                statisticItem.param("fid", threadData.getFid());
            }
            statisticItem.eventStat();
        }
    }

    public static boolean c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            int id = view.getId();
            return id == R.id.obfuscated_res_0x7f091f9a || id == R.id.obfuscated_res_0x7f091fac;
        }
        return invokeL.booleanValue;
    }
}
