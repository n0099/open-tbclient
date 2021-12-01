package c.a.r0.n1.h.n;

import c.a.d.m.e.n;
import c.a.q0.s.q.d2;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, n nVar) {
        InterceptResult invokeLL;
        c.a.r0.g0.f0.b bVar;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, nVar)) == null) {
            if (!(nVar instanceof c.a.r0.g0.f0.b) || (d2Var = (bVar = (c.a.r0.g0.f0.b) nVar).f17245e) == null || d2Var.G1() == null || StringUtils.isNull(bVar.f17245e.G1().room_name) || bVar.f17245e.G1().room_id.longValue() <= 0) {
                return false;
            }
            ((c.a.q0.j0.c.a) ServiceManager.getService(c.a.q0.j0.c.a.a.a())).a(tbPageContext, bVar.f17245e.G1().room_id.longValue());
            return true;
        }
        return invokeLL.booleanValue;
    }
}
