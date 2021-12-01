package c.a.b0.g.d;

import android.os.Build;
import c.a.b0.d0.r;
import c.a.b0.r.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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

    public final JSONObject a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            map.put("_client_version", c.a.b0.e.a.a().o());
            map.put("uid", c.a.b0.e.a.a().l());
            map.put("cuid", c.a.b0.e.a.a().b());
            if (Build.VERSION.SDK_INT >= 17) {
                map.put("ua", c.a.b0.e.a.d());
            }
            map.put("model", Build.MODEL);
            map.put(HttpRequest.CLIENT_TYPE, "2");
            map.put(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
            map.put("nt", String.valueOf(new n().c()));
            map.put("imei", c.a.b0.e.a.a().n());
            map.put("android_id", c.a.b0.e.a.a().a());
            map.put("ssl", "1");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                c.a.b0.u.b.d(jSONObject, entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void b(Map<String, String> map, c.a.b0.r.p.b<g> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, bVar) == null) {
            c.a.b0.r.s.c d2 = c.a.b0.r.s.c.d(r.a(a(map).toString().getBytes()));
            c.a.b0.r.s.d dVar = new c.a.b0.r.s.d();
            dVar.a("Content-Encoding", "gzip");
            dVar.a("Content-Type", "application/json");
            dVar.k("https://afdconf.baidu.com/afd/download");
            dVar.g(3000);
            dVar.i(3000);
            dVar.j(3000);
            dVar.f(d2);
            c.a.b0.r.g.b().a().a(dVar, bVar);
        }
    }
}
