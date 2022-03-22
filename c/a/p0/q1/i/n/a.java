package c.a.p0.q1.i.n;

import c.a.d.o.e.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, n nVar) {
        InterceptResult invokeLL;
        c.a.p0.h0.e0.b bVar;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, nVar)) == null) {
            if (!(nVar instanceof c.a.p0.h0.e0.b) || (threadData = (bVar = (c.a.p0.h0.e0.b) nVar).a) == null || threadData.getVoiceRoomData() == null || StringUtils.isNull(bVar.a.getVoiceRoomData().room_name) || bVar.a.getVoiceRoomData().room_id.longValue() <= 0) {
                return false;
            }
            ((c.a.o0.i0.c.a) ServiceManager.getService(c.a.o0.i0.c.a.a.a())).a(tbPageContext, bVar.a.getVoiceRoomData().room_id.longValue());
            return true;
        }
        return invokeLL.booleanValue;
    }
}
