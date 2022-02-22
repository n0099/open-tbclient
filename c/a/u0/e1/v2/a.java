package c.a.u0.e1.v2;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.b.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, statisticItem) == null) {
            statisticItem.param("obj_param1", c());
        }
    }

    public static void b(@NonNull StatisticItem statisticItem, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, statisticItem, str, str2) == null) {
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? d.u() ? "100465_2" : d.v() ? "100465_1" : "100465_3" : (String) invokeV.objValue;
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            StatisticItem param = new StatisticItem("c14564").param("fid", str).param("fname", str2).param("uid", TbadkCoreApplication.getCurrentAccountId());
            a(param);
            TiebaStatic.log(param);
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            StatisticItem param = new StatisticItem(d.u() ? "c14556" : TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("fid", str).param("fname", str2).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 11);
            a(param);
            TiebaStatic.log(param);
        }
    }
}
