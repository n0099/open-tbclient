package c.a.q0.i2.k.g;

import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, str2, str3) == null) {
            StatisticItem statisticItem = new StatisticItem("c14349");
            statisticItem.param("tid", str);
            statisticItem.param("uid", str2);
            statisticItem.param("post_id", str3);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, str, str2, str3) == null) {
            StatisticItem statisticItem = new StatisticItem("c14348");
            statisticItem.param("tid", str);
            statisticItem.param("uid", str2);
            statisticItem.param("post_id", str3);
            TiebaStatic.log(statisticItem);
        }
    }
}
