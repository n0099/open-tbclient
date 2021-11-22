package b.a.r0.h1.h.n;

import b.a.e.m.e.n;
import b.a.q0.s.q.d2;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, n nVar) {
        InterceptResult invokeLL;
        b.a.r0.b0.f0.b bVar;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, nVar)) == null) {
            if (!(nVar instanceof b.a.r0.b0.f0.b) || (d2Var = (bVar = (b.a.r0.b0.f0.b) nVar).f16235e) == null || d2Var.F1() == null || StringUtils.isNull(bVar.f16235e.F1().room_name) || bVar.f16235e.F1().room_id.longValue() <= 0) {
                return false;
            }
            ((b.a.q0.i0.c.a) ServiceManager.getService(b.a.q0.i0.c.a.f13386a.a())).a(tbPageContext, bVar.f16235e.F1().room_id.longValue());
            return true;
        }
        return invokeLL.booleanValue;
    }
}
