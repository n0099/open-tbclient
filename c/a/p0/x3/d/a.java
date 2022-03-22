package c.a.p0.x3.d;

import c.a.p0.x3.c.c;
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
        if (!(interceptable == null || interceptable.invokeL(65536, null, cVar) == null) || cVar == null || cVar.f20714b == 0 || cVar.f20715c == 0) {
            return;
        }
        StatisticItem addParam = StatisticItem.make("c14571").addParam("obj_source", cVar.f20714b).addParam("obj_type", cVar.f20715c).addParam("uid", TbadkCoreApplication.getCurrentAccount());
        int i = cVar.a;
        if (i != 0) {
            addParam.addParam("obj_locate", i);
        }
        addParam.eventStat();
    }
}
