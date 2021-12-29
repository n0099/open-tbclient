package c.a.c0.r.s;

import androidx.annotation.NonNull;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.Request;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Request.Builder a(@NonNull d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dVar)) == null) {
            Request.Builder builder = new Request.Builder();
            builder.url(dVar.a);
            Object obj = dVar.f2309e;
            if (obj != null) {
                builder.tag(obj);
            }
            Headers.a aVar = dVar.f2307c;
            if (aVar != null) {
                Headers c2 = aVar.c();
                for (int i2 = 0; i2 < c2.g(); i2++) {
                    builder.addHeader(c2.f(i2), c2.h(i2));
                }
            }
            String str = dVar.f2306b;
            builder.method(str, a.g(str, dVar.f2308d));
            return builder;
        }
        return (Request.Builder) invokeL.objValue;
    }
}
