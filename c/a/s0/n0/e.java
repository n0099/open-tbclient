package c.a.s0.n0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65536, null, i2, str) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_CLICK);
            statisticItem.param("obj_locate", i2);
            statisticItem.param("obj_source", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            TiebaStatic.log(new StatisticItem(str));
        }
    }

    public static void c(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, str, i2) == null) {
            TiebaStatic.log(new StatisticItem(str).addParam("obj_locate", i2));
        }
    }

    public static void d(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i2, str) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW);
            statisticItem.param("obj_locate", i2);
            statisticItem.param("obj_source", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            TiebaStatic.log(new StatisticItem(str));
        }
    }
}
