package c.a.r0.z3;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ENTER_VIDEO_PAGE);
            if (TextUtils.isEmpty(str)) {
                statisticItem.param("obj_type", "1");
            } else {
                statisticItem.param("obj_type", "2");
                statisticItem.param("obj_id", str);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(String str, boolean z, long j2, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, Boolean.valueOf(z), Long.valueOf(j2), str2, str3, str4}) == null) {
            String str5 = TextUtils.isEmpty(str) ? "0" : "1";
            long currentTimeMillis = System.currentTimeMillis() - j2;
            if ("from_nani_video".equals(str2)) {
                String str6 = "a002";
                if (!"index".equals(str3)) {
                    if ("concern_tab".equals(str3)) {
                        str6 = "a038";
                    } else if ("frs".equals(str3)) {
                        str6 = "a006";
                    } else {
                        "homepage".equals(str3);
                    }
                }
                if (z) {
                    TiebaStatic.log(new StatisticItem("stime").param("obj_type", "a023").param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis).param("obj_source", str6).param(TiebaStatic.Params.IS_VERTICAL, "1").param("is_dynamic", str5).param("obj_location", str4));
                    return;
                } else {
                    TiebaStatic.log(new StatisticItem("stime").param("obj_type", "a023").param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis).param("obj_source", str6).param("is_dynamic", str5).param(TiebaStatic.Params.IS_VERTICAL, "1"));
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem("stime").param("obj_type", "a023").param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis).param("is_dynamic", str5).param("obj_source", "a020"));
        }
    }

    public static void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_EXPOSURE);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
