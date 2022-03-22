package c.a.a0.j.d;

import android.os.Build;
import c.a.a0.h0.u;
import c.a.a0.u.n;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final JSONObject a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            map.put("_client_version", c.a.a0.h.a.a().q());
            map.put("uid", c.a.a0.h.a.a().m());
            map.put("cuid", c.a.a0.h.a.a().b());
            if (Build.VERSION.SDK_INT >= 17) {
                map.put("ua", c.a.a0.h.a.e());
            }
            map.put("model", Build.MODEL);
            map.put(HttpRequest.CLIENT_TYPE, "2");
            map.put(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
            map.put("nt", String.valueOf(new n().c()));
            map.put("imei", c.a.a0.h.a.a().p());
            map.put(HttpRequest.ANDROID_ID, c.a.a0.h.a.a().a());
            map.put("ssl", "1");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                c.a.a0.x.b.e(jSONObject, entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void b(Map<String, String> map, c.a.a0.u.p.b<g> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, bVar) == null) {
            c.a.a0.u.s.c f2 = c.a.a0.u.s.c.f(u.a(a(map).toString().getBytes()));
            c.a.a0.u.s.d dVar = new c.a.a0.u.s.d();
            dVar.a("Content-Encoding", "gzip");
            dVar.a("Content-Type", "application/json");
            dVar.k("https://afdconf.baidu.com/afd/download");
            dVar.g(3000);
            dVar.i(3000);
            dVar.j(3000);
            dVar.f(f2);
            c.a.a0.u.g.b().a().a(dVar, bVar);
        }
    }
}
