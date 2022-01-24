package c.a.t0.p1.h.n;

import c.a.d.n.e.n;
import c.a.s0.s.q.e2;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, n nVar) {
        InterceptResult invokeLL;
        c.a.t0.g0.f0.b bVar;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, nVar)) == null) {
            if (!(nVar instanceof c.a.t0.g0.f0.b) || (e2Var = (bVar = (c.a.t0.g0.f0.b) nVar).f17600e) == null || e2Var.H1() == null || StringUtils.isNull(bVar.f17600e.H1().room_name) || bVar.f17600e.H1().room_id.longValue() <= 0) {
                return false;
            }
            ((c.a.s0.j0.c.a) ServiceManager.getService(c.a.s0.j0.c.a.a.a())).a(tbPageContext, bVar.f17600e.H1().room_id.longValue());
            return true;
        }
        return invokeLL.booleanValue;
    }
}
