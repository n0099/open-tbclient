package c.a.p0.q.i.j;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import c.a.p0.p.c.h;
import c.a.p0.q.i.e;
import c.a.p0.q.i.f;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidubce.AbstractBceClient;
import java.util.Map;
import okhttp3.MediaType;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends c.a.p0.q.i.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Map<String, String> map, Map<String, String> map2, e<String> eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, str, map, map2, eVar) == null) || d(str, eVar)) {
            return;
        }
        c(c.a.p0.p.e.a.g().getRequest(), str, map, map2, eVar);
    }

    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, e<String> eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65537, null, str, map, map2, jSONObject, eVar) == null) || d(str, eVar)) {
            return;
        }
        h postStringRequest = c.a.p0.p.e.a.g().postStringRequest();
        c.a.p0.q.d.a(postStringRequest, map);
        postStringRequest.content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6);
        c(postStringRequest, str, map, map2, eVar);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public static void c(HttpRequestBuilder<?> httpRequestBuilder, String str, Map<String, String> map, Map<String, String> map2, e<String> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, httpRequestBuilder, str, map, map2, eVar) == null) {
            httpRequestBuilder.url(f.j(str, map)).requestSubFrom(10).addHeaders(map2).userAgent(c.a.p0.q.i.a.f10965b).cookieManager(c.a.p0.q.i.a.a).enableStat(true).build().executeStat(eVar);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean d(String str, e<String> eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, eVar)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (eVar != null) {
                eVar.onStart();
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
