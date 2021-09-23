package c.a.r0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void b(c.a.q0.t.c.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, hVar) == null) || hVar == null) {
            return;
        }
        if (hVar.f14677b != 0) {
            c.a.q0.s.d0.b.j().x("app_entrance_nologin", hVar.f14677b + "");
        }
        if (hVar.f14676a == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        c.a.q0.s.d0.b.j().x("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), hVar.f14676a + "");
    }

    public int a() {
        InterceptResult invokeV;
        String p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                p = c.a.q0.s.d0.b.j().p("app_entrance_nologin", "");
            } else {
                c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
                p = j2.p("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            int e2 = c.a.e.e.m.b.e(p, 0);
            return (e2 != 1 && e2 == 2) ? 1 : 2;
        }
        return invokeV.intValue;
    }
}
