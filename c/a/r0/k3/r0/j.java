package c.a.r0.k3.r0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            TiebaStatic.log(new StatisticItem("c14041").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", c.a.q0.s.m.b.b() ? 1 : 0));
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            TiebaStatic.log(new StatisticItem("c14040").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", c.a.q0.s.m.b.b() ? 1 : 0));
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            TiebaStatic.log(new StatisticItem("c14029").param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }
}
