package c.a.p0;

import c.a.o0.s.c.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void b(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, hVar) == null) || hVar == null) {
            return;
        }
        if (hVar.f11207b != 0) {
            c.a.o0.r.j0.b.k().y("app_entrance_nologin", hVar.f11207b + "");
        }
        if (hVar.a == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        c.a.o0.r.j0.b.k().y("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), hVar.a + "");
    }

    public int a() {
        InterceptResult invokeV;
        String q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                q = c.a.o0.r.j0.b.k().q("app_entrance_nologin", "");
            } else {
                c.a.o0.r.j0.b k = c.a.o0.r.j0.b.k();
                q = k.q("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            int e2 = c.a.d.f.m.b.e(q, 0);
            return (e2 != 1 && e2 == 2) ? 1 : 2;
        }
        return invokeV.intValue;
    }
}
