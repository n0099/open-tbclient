package c.a.r0.p3.f;

import c.a.q0.s.e0.b;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.WINDOW_CLICK);
            statisticItem.param("obj_source", str);
            statisticItem.param("obj_type", str2);
            statisticItem.param("obj_locate", b.j().k("app_restart_times", 0) >= 1 ? 2 : 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.WINDOW_EXPOSURE);
            statisticItem.param("obj_type", str);
            statisticItem.param("obj_locate", b.j().k("app_restart_times", 0) >= 1 ? 2 : 1);
            TiebaStatic.log(statisticItem);
        }
    }
}
