package c.a.o0.a.e0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static String f9661b;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            StatisticItem addParam = new StatisticItem("c14570").addParam("obj_type", 2).addParam("obj_source", 1).addParam("uid", TbadkCoreApplication.getCurrentAccount());
            if (!StringUtils.isNull(str)) {
                addParam.addParam("obj_locate", str);
            }
            addParam.eventStat();
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            StatisticItem addParam = new StatisticItem("c14570").addParam("obj_type", 2).addParam("obj_source", 2).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam(TiebaStatic.Params.OBJ_PARAM3, str2);
            if (!StringUtils.isNull(str)) {
                addParam.addParam("obj_locate", str);
            }
            addParam.eventStat();
        }
    }

    public static void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, null, i, i2) == null) {
            StatisticItem addParam = new StatisticItem("c14570").addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_type", 1).addParam("obj_source", 3).addParam("obj_param1", i).addParam(TiebaStatic.Params.OBJ_PARAM2, i2);
            if (!StringUtils.isNull(f9661b)) {
                addParam.addParam(TiebaStatic.Params.OBJ_PARAM3, f9661b);
            }
            if (!StringUtils.isNull(a)) {
                addParam.addParam("obj_locate", a);
            }
            addParam.eventStat();
            f9661b = null;
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            StatisticItem addParam = new StatisticItem("c14570").addParam("obj_type", 1).addParam("obj_source", 1).addParam("uid", TbadkCoreApplication.getCurrentAccount());
            if (!StringUtils.isNull(str)) {
                addParam.addParam("obj_locate", str);
            }
            a = str;
            addParam.eventStat();
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            StatisticItem addParam = new StatisticItem("c14570").addParam("obj_type", 1).addParam("obj_source", 2).addParam("uid", TbadkCoreApplication.getCurrentAccount());
            if (!StringUtils.isNull(a)) {
                addParam.addParam("obj_locate", a);
            }
            a = null;
            addParam.eventStat();
        }
    }
}
