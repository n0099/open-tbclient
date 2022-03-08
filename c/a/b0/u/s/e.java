package c.a.b0.u.s;

import androidx.annotation.NonNull;
import com.baidu.nadcore.net.exception.RequestError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.Request;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Request.Builder a(@NonNull d dVar) throws RequestError {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dVar)) == null) {
            Request.Builder builder = new Request.Builder();
            try {
                builder.url(dVar.a);
                Object obj = dVar.f2035e;
                if (obj != null) {
                    builder.tag(obj);
                }
                Headers.a aVar = dVar.f2033c;
                if (aVar != null) {
                    Headers c2 = aVar.c();
                    for (int i2 = 0; i2 < c2.g(); i2++) {
                        builder.addHeader(c2.f(i2), c2.h(i2));
                    }
                }
                String str = dVar.f2032b;
                builder.method(str, a.g(str, dVar.f2034d));
                return builder;
            } catch (Throwable th) {
                throw new RequestError("Invalid request url: " + dVar.a, th);
            }
        }
        return (Request.Builder) invokeL.objValue;
    }
}
