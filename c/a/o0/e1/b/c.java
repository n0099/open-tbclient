package c.a.o0.e1.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            StatisticItem statisticItem = new StatisticItem("c14166");
            if (TbadkCoreApplication.isLogin()) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i2) == null) {
            StatisticItem statisticItem = new StatisticItem("c14165");
            if (TbadkCoreApplication.isLogin()) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            }
            statisticItem.param("obj_locate", i2 == 1 ? 2 : 1);
            TiebaStatic.log(statisticItem);
            a();
        }
    }
}
