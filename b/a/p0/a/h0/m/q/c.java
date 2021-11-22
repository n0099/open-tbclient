package b.a.p0.a.h0.m.q;

import androidx.annotation.NonNull;
import b.a.p0.q.j.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends a implements g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f5877f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1973042921, "Lb/a/p0/a/h0/m/q/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1973042921, "Lb/a/p0/a/h0/m/q/c;");
                return;
            }
        }
        b.a.p0.a.c1.a.g0().getSwitch("swan_pms_http_request_retry_use_default_net_lib", false);
        f5877f = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b.a.p0.a.d2.d dVar) {
        super(dVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.d2.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @NonNull
    public static b.a.p0.q.j.j.b J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f5877f ? b.a.p0.a.c1.a.r0() : new b.a.p0.q.j.j.d() : (b.a.p0.q.j.j.b) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.m.q.a, b.a.p0.q.j.g
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
            J().a(str, map, map2, jSONObject, aVar);
        }
    }

    @Override // b.a.p0.a.h0.m.q.a, b.a.p0.q.j.g
    public void j(String str, Map<String, String> map, Map<String, String> map2, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, map2, aVar) == null) {
            String b2 = b.a.p0.a.u1.l.d.b();
            if (b2 != null) {
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("launchid", b2);
            }
            J().j(str, map, map2, aVar);
        }
    }
}
