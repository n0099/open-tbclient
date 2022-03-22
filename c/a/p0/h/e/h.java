package c.a.p0.h.e;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static b a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cVar)) == null) {
            if (cVar != null && (cVar.a() instanceof TbPageContext) && (((TbPageContext) cVar.a()).getPageActivity() instanceof b)) {
                return (b) ((TbPageContext) cVar.a()).getPageActivity();
            }
            return null;
        }
        return (b) invokeL.objValue;
    }
}
