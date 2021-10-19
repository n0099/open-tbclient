package c.a.r0.h1.f.a;

import android.view.View;
import c.a.q0.s.q.d2;
import c.a.r0.h1.f.a.e.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view, Object obj, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65536, null, view, obj, i2, str) == null) {
            if (obj instanceof c.a.r0.h1.f.a.e.c) {
                c.a.r0.h1.f.a.e.c cVar = (c.a.r0.h1.f.a.e.c) obj;
                if (cVar.f18279e) {
                    StatisticItem statisticItem = new StatisticItem("c13736");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.eventStat();
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13735");
                statisticItem2.param("obj_locate", str);
                statisticItem2.param("topic_id", cVar.f18275a);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.eventStat();
            } else if (obj instanceof e) {
                d2 d2Var = ((e) obj).f18287j;
                StatisticItem statisticItem3 = new StatisticItem("c13738");
                statisticItem3.param("obj_type", str);
                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (d2Var != null) {
                    statisticItem3.param("tid", d2Var.s1());
                    statisticItem3.param("fid", d2Var.T());
                }
                statisticItem3.eventStat();
            } else if ((obj instanceof c.a.q0.s.q.a) && c(view)) {
                d2 threadData = ((c.a.q0.s.q.a) obj).getThreadData();
                StatisticItem statisticItem4 = new StatisticItem("c13738");
                statisticItem4.param("obj_type", str);
                statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (threadData != null) {
                    statisticItem4.param("tid", threadData.s1());
                    statisticItem4.param("fid", threadData.T());
                }
                statisticItem4.eventStat();
            }
        }
    }

    public static void b(View view, Object obj, String str) {
        d2 threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, view, obj, str) == null) {
            StatisticItem statisticItem = new StatisticItem("c13825");
            statisticItem.param("obj_type", str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (obj instanceof e) {
                threadData = ((e) obj).f18287j;
            } else {
                threadData = obj instanceof c.a.q0.s.q.a ? ((c.a.q0.s.q.a) obj).getThreadData() : null;
            }
            if (threadData != null) {
                statisticItem.param("tid", threadData.s1());
                statisticItem.param("fid", threadData.T());
            }
            statisticItem.eventStat();
        }
    }

    public static boolean c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            int id = view.getId();
            return id == R.id.thread_card_root || id == R.id.thread_info_commont_container;
        }
        return invokeL.booleanValue;
    }
}
