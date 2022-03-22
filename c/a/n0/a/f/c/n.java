package c.a.n0.a.f.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class n extends c.a.n0.a.s0.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.n0.a.f.d.a0
    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.n0.a.t.c.v(String.format("%s/api/subscribe/v1/relation/get", c.a.n0.a.t.a.c())) : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? String.format("%s/ma/tips", Q()) : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public long E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public HttpRequest F(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, map)) == null) ? P("ma/accredit_v1", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? c.a.n0.a.t.c.w(String.format("%s/ma/grs/brand/applist", Q()), true) : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public HttpRequest M(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, context, map)) == null) ? P("ma/user/openid", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? String.format("%s/ma/ai", Q()) : (String) invokeV.objValue;
    }

    public final HttpRequest P(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, map)) == null) {
            HttpUrl parse = HttpUrl.parse(Q());
            if (parse == null) {
                return null;
            }
            HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
            for (Map.Entry<String, String> entry : c.a.n0.a.t.b.b().f6325d.entrySet()) {
                addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
            }
            HttpUrl build = addPathSegments.build();
            c.a.n0.p.d.a aVar = new c.a.n0.p.d.a();
            aVar.f9106b = "POST";
            aVar.a = c.a.n0.a.t.c.w(build.toString(), true);
            aVar.f9108d = c.a.n0.a.x1.c.d.b(map);
            aVar.f9110f = true;
            aVar.f9111g = true;
            aVar.f9112h = false;
            HttpRequestBuilder a = c.a.n0.p.e.b.a(aVar);
            c.a.n0.p.e.a.g().u(a, aVar);
            return a.build();
        }
        return (HttpRequest) invokeLL.objValue;
    }

    public final String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? c.a.n0.a.t.c.a : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public HttpRequest a(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, context, map)) == null) ? P("ma/user/checksessionkey", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? c.a.n0.a.t.c.w(String.format("%s/ma/update", Q()), true) : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? c.a.n0.a.t.c.v(String.format("%s/ma/history/sync", Q())) : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? String.format("%s/ma/component/comment/bos_auth", "https://ossapi.baidu.com") : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public HttpRequest g(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, context, map)) == null) ? P("ma/user/swanid", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? c.a.n0.a.s0.a.n().a() : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public HttpRequest o(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, map)) == null) ? P("ma/accredit_data", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? c.a.n0.a.t.c.v(String.format("%s/ma/history/list", Q())) : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public HttpRequest s(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, context, map)) == null) ? P("ma/login", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public HttpRequest u(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, context, map)) == null) ? P("ma/open/data", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // c.a.n0.a.f.d.a0
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? c.a.n0.a.t.c.v(String.format("%s/ma/reset", Q())) : (String) invokeV.objValue;
    }
}
