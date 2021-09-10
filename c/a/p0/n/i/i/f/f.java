package c.a.p0.n.i.i.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.m.c.h;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.InvalidParameterException;
import java.util.Map;
import okhttp3.MediaType;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends c.a.p0.n.i.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f11921d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755813452, "Lc/a/p0/n/i/i/f/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755813452, "Lc/a/p0/n/i/i/f/f;");
                return;
            }
        }
        f11921d = c.a.p0.n.c.f11856a;
    }

    public static void a(String str, Map<String, String> map, Map<String, String> map2, c.a.p0.n.i.e<String> eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65537, null, str, map, map2, eVar) == null) || d(str, eVar)) {
            return;
        }
        c(c.a.p0.m.e.a.g().getRequest(), str, map, map2, eVar);
    }

    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, c.a.p0.n.i.e<String> eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65538, null, str, map, map2, jSONObject, eVar) == null) || d(str, eVar)) {
            return;
        }
        h postStringRequest = c.a.p0.m.e.a.g().postStringRequest();
        c.a.p0.n.d.a(postStringRequest, map);
        postStringRequest.content(jSONObject.toString()).mediaType(MediaType.parse("application/json; charset=utf-8")).requestFrom(6);
        c(postStringRequest, str, map, map2, eVar);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public static void c(HttpRequestBuilder<?> httpRequestBuilder, String str, Map<String, String> map, Map<String, String> map2, c.a.p0.n.i.e<String> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, httpRequestBuilder, str, map, map2, eVar) == null) {
            httpRequestBuilder.url(c.a.p0.n.i.f.i(str, map)).requestSubFrom(10).addHeader(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, "true").addHeaders(map2).userAgent(c.a.p0.n.i.a.f11891c).cookieManager(c.a.p0.n.i.a.f11890b).enableStat(true).build().executeStat(eVar);
        }
    }

    public static boolean d(String str, c.a.p0.n.i.e<String> eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, eVar)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (f11921d) {
                    throw new InvalidParameterException("PMS request URL is empty");
                }
                return true;
            } else if (eVar != null) {
                eVar.onStart();
                return false;
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
