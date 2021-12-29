package c.o.a.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Map<String, Object> a(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fVar)) == null) {
            c.o.a.d b2 = fVar.b();
            if (b2 != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("sql", b2.e());
                hashMap.put("arguments", b2.d());
                return hashMap;
            }
            return null;
        }
        return (Map) invokeL.objValue;
    }
}
