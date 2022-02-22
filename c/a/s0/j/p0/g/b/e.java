package c.a.s0.j.p0.g.b;

import androidx.annotation.NonNull;
import c.a.s0.w.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            }
        }
    }

    public static Map<String, String> a(@NonNull c.a.s0.a.d2.e eVar, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, eVar, i2, str)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put("app_key", eVar.N());
            treeMap.put("to_app_key", str);
            treeMap.put("source", String.valueOf(i2));
            treeMap.put("timestamp", c());
            StringBuilder sb = new StringBuilder();
            for (String str2 : treeMap.keySet()) {
                sb.append(str2);
                sb.append("=");
                sb.append((String) treeMap.get(str2));
                sb.append("&");
            }
            sb.append("dsb9Ao44");
            treeMap.put("sign", f.d(sb.toString().getBytes(), false));
            return treeMap;
        }
        return (Map) invokeLIL.objValue;
    }

    public static void b(int i2, @NonNull ResponseCallback responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65537, null, i2, responseCallback) == null) {
            c.a.s0.a.d2.e L = c.a.s0.a.d2.e.L();
            if (L == null) {
                responseCallback.onFail(new Exception("framework error: swan app is null."));
                return;
            }
            L.h0().getRequest().cookieManager(c.a.s0.a.c1.a.q().a()).url(c.a.s0.j.u.a.b().p()).addUrlParam("app_key", L.N()).addUrlParam(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(5)).addUrlParam("source", String.valueOf(i2)).requestFrom(16).requestFrom(1607).build().executeAsync(responseCallback);
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? String.valueOf(System.currentTimeMillis() / 1000) : (String) invokeV.objValue;
    }

    public static void d(int i2, String str) {
        c.a.s0.a.d2.e L;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65539, null, i2, str) == null) || (L = c.a.s0.a.d2.e.L()) == null) {
            return;
        }
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) L.h0().postFormRequest().cookieManager(c.a.s0.a.c1.a.q().a())).url(c.a.s0.j.u.a.b().g())).addParams(a(L, i2, str)).requestFrom(16)).requestFrom(1607)).build().executeAsync(new a());
    }
}
