package c.a.r0.q.j.i.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.Response;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static e a(String str, int i2) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i2)) == null) {
            Response executeSync = c.a.r0.p.e.a.g().getRequest().requestFrom(6).requestSubFrom(i2).url(str).build().executeSync();
            if (executeSync == null) {
                return null;
            }
            return new a(executeSync);
        }
        return (e) invokeLI.objValue;
    }
}
