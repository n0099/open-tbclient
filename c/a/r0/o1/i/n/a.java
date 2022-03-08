package c.a.r0.o1.i.n;

import c.a.d.o.e.n;
import c.a.q0.r.r.e2;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, n nVar) {
        InterceptResult invokeLL;
        c.a.r0.f0.d0.b bVar;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, nVar)) == null) {
            if (!(nVar instanceof c.a.r0.f0.d0.b) || (e2Var = (bVar = (c.a.r0.f0.d0.b) nVar).f17272e) == null || e2Var.H1() == null || StringUtils.isNull(bVar.f17272e.H1().room_name) || bVar.f17272e.H1().room_id.longValue() <= 0) {
                return false;
            }
            ((c.a.q0.i0.c.a) ServiceManager.getService(c.a.q0.i0.c.a.a.a())).a(tbPageContext, bVar.f17272e.H1().room_id.longValue());
            return true;
        }
        return invokeLL.booleanValue;
    }
}
