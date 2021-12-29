package c.a.t0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
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

    public static void b(c.a.s0.t.c.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, iVar) == null) || iVar == null) {
            return;
        }
        if (iVar.f14171b != 0) {
            c.a.s0.s.g0.b.j().x("app_entrance_nologin", iVar.f14171b + "");
        }
        if (iVar.a == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        c.a.s0.s.g0.b.j().x("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), iVar.a + "");
    }

    public int a() {
        InterceptResult invokeV;
        String p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                p = c.a.s0.s.g0.b.j().p("app_entrance_nologin", "");
            } else {
                c.a.s0.s.g0.b j2 = c.a.s0.s.g0.b.j();
                p = j2.p("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            int e2 = c.a.d.f.m.b.e(p, 0);
            return (e2 != 1 && e2 == 2) ? 1 : 2;
        }
        return invokeV.intValue;
    }
}
