package c.a.u0.w3.d;

import c.a.u0.w3.c.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, cVar) == null) || cVar == null || cVar.f25031b == 0 || cVar.f25032c == 0) {
            return;
        }
        StatisticItem addParam = StatisticItem.make("c14571").addParam("obj_source", cVar.f25031b).addParam("obj_type", cVar.f25032c).addParam("uid", TbadkCoreApplication.getCurrentAccount());
        int i2 = cVar.a;
        if (i2 != 0) {
            addParam.addParam("obj_locate", i2);
        }
        addParam.eventStat();
    }
}
