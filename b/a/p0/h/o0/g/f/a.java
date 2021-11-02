package b.a.p0.h.o0.g.f;

import b.a.p0.a.a2.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, callback) == null) {
            b(callback, "6");
        }
    }

    public static void b(Callback callback, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, callback, str) == null) || e.i() == null) {
            return;
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/exchange/list").newBuilder();
        newBuilder.addQueryParameter(Constants.EXTRA_CONFIG_LIMIT, str);
        newBuilder.addQueryParameter("app_key", e.i().k());
        newBuilder.addQueryParameter("source", "4");
        ((b.a.p0.h.y.b) e.i().W()).call(new Request.Builder().url(newBuilder.build()).build(), callback);
    }
}
