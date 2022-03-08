package c.a.p0.g.c;

import c.a.p0.q.i.g;
import c.a.p0.q.i.h;
import c.a.p0.q.i.i.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes.dex */
public class a implements c.a.p0.q.i.j.b {
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

    @Override // c.a.p0.q.i.g
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
            if (PMSConstants.a(c.a.p0.q.c.b())) {
                c.a.p0.q.i.a.b(str, map, map2, jSONObject, new c.a.p0.c.a.h.a(aVar));
            } else {
                c.a.p0.q.i.a.b(str, map, map2, jSONObject, new h(aVar));
            }
        }
    }

    @Override // c.a.p0.q.i.j.b
    public e b(String str, int i2) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) ? c.a.p0.q.i.i.f.c.a(str, i2) : (e) invokeLI.objValue;
    }

    @Override // c.a.p0.q.i.g
    public void j(String str, Map<String, String> map, Map<String, String> map2, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, map, map2, aVar) == null) {
            if (PMSConstants.a(c.a.p0.q.c.b())) {
                c.a.p0.q.i.a.a(str, map, map2, new c.a.p0.c.a.h.a(aVar));
            } else {
                c.a.p0.q.i.a.a(str, map, map2, new h(aVar));
            }
        }
    }
}
