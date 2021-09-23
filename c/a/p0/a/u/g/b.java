package c.a.p0.a.u.g;

import android.text.TextUtils;
import c.a.p0.a.k;
import c.a.p0.a.r1.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f9171b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, c.a.p0.a.r1.k.a> f9172a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-7710254, "Lc/a/p0/a/u/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-7710254, "Lc/a/p0/a/u/g/b;");
                return;
            }
        }
        f9171b = k.f7085a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9172a = new ConcurrentHashMap();
    }

    @Override // c.a.p0.a.u.g.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f9172a.containsKey(str)) {
            return;
        }
        if (f9171b) {
            String str2 = "markStart: " + str;
        }
        c.a.p0.a.r1.k.a aVar = new c.a.p0.a.r1.k.a();
        this.f9172a.put(str, aVar);
        aVar.i(System.currentTimeMillis());
        aVar.f(str);
    }

    @Override // c.a.p0.a.u.g.a
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            c.a.p0.a.r1.k.a aVar = this.f9172a.get(str);
            if (aVar == null) {
                if (f9171b) {
                    throw new RuntimeException(str + " markEnd before markStart");
                }
            } else if (aVar.d() > 0) {
            } else {
                aVar.h(System.currentTimeMillis());
                if (f9171b) {
                    String str2 = str + " first called cost " + aVar.c();
                }
                if (TextUtils.equals(str, "request")) {
                    if (f9171b) {
                        String str3 = "record first request api called " + aVar.toString();
                    }
                    HybridUbcFlow p = h.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("first_request_api_call_start");
                    ubcFlowEvent.h(aVar.e());
                    p.C(ubcFlowEvent);
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("first_request_api_call_end");
                    ubcFlowEvent2.h(aVar.d());
                    p.C(ubcFlowEvent2);
                }
            }
        }
    }
}
