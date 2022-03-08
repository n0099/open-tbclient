package c.a.q0.a.d0;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
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

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            StatisticItem addParam = new StatisticItem("c14570").addParam("obj_type", 2).addParam("obj_source", 2).addParam("uid", TbadkCoreApplication.getCurrentAccount());
            if (!StringUtils.isNull(str)) {
                addParam.addParam("obj_locate", str);
            }
            addParam.eventStat();
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            StatisticItem addParam = new StatisticItem("c14570").addParam("obj_type", 1).addParam("obj_source", 1).addParam("uid", TbadkCoreApplication.getCurrentAccount());
            if (!StringUtils.isNull(str)) {
                addParam.addParam("obj_locate", str);
            }
            a = str;
            addParam.eventStat();
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            StatisticItem addParam = new StatisticItem("c14570").addParam("obj_type", 1).addParam("obj_source", 2).addParam("uid", TbadkCoreApplication.getCurrentAccount());
            if (!StringUtils.isNull(a)) {
                addParam.addParam("obj_locate", a);
            }
            a = null;
            addParam.eventStat();
        }
    }
}
