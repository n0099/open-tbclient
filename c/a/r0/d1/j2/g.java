package c.a.r0.d1.j2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65536, null, i2, i3) == null) {
            StatisticItem statisticItem = new StatisticItem("c13513");
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_type", i2);
            if (i3 != -1) {
                statisticItem.addParam("obj_locate", i3);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, str, i2) == null) {
            StatisticItem statisticItem = new StatisticItem("c13512");
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("fid", str);
            statisticItem.addParam("obj_source", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
