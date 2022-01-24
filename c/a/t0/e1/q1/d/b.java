package c.a.t0.e1.q1.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65536, null, j2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ACCELERATOR_PAGE_ENTER_GAME_BTN_CLICK);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_id", j2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65537, null, j2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ACCELERATOR_PAGE_ENTER_GAME_BTN_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_id", j2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, null, j2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ACCELERATOR_PAGE_RETRY_BTN_CLICK);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_id", j2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void d(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65539, null, j2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ACCELERATOR_PAGE_RETRY_BTN_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_id", j2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void e(String str, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ACCELERATOR_PAGE_SHOW);
            statisticItem.addParam("fid", str);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_id", j2);
            statisticItem.addParam("obj_source", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void f(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65541, null, j2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ACCELERATOR_PAGE_STOP_BTN_CLICK);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_id", j2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void g(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65542, null, j2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ACCELERATOR_PAGE_STOP_BTN_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_id", j2);
            TiebaStatic.log(statisticItem);
        }
    }
}
