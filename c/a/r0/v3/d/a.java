package c.a.r0.v3.d;

import c.a.r0.v3.c.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, cVar) == null) || cVar == null || cVar.f24309b == 0 || cVar.f24310c == 0) {
            return;
        }
        StatisticItem addParam = StatisticItem.make("c14571").addParam("obj_source", cVar.f24309b).addParam("obj_type", cVar.f24310c).addParam("uid", TbadkCoreApplication.getCurrentAccount());
        int i2 = cVar.a;
        if (i2 != 0) {
            addParam.addParam("obj_locate", i2);
        }
        addParam.eventStat();
    }
}
