package c.a.n0.a.k.g;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.k1.h;
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
import com.kwad.v8.NodeJS;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f5285b;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, c.a.n0.a.k1.k.a> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-995066342, "Lc/a/n0/a/k/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-995066342, "Lc/a/n0/a/k/g/b;");
                return;
            }
        }
        f5285b = c.a.n0.a.a.a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap();
    }

    @Override // c.a.n0.a.k.g.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a.containsKey(str)) {
            return;
        }
        if (f5285b) {
            Log.d("Api-FirstRecorder", "markStart: " + str);
        }
        c.a.n0.a.k1.k.a aVar = new c.a.n0.a.k1.k.a();
        this.a.put(str, aVar);
        aVar.i(System.currentTimeMillis());
        aVar.f(str);
    }

    @Override // c.a.n0.a.k.g.a
    @SuppressLint({"BDThrowableCheck"})
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            c.a.n0.a.k1.k.a aVar = this.a.get(str);
            if (aVar == null) {
                if (f5285b) {
                    throw new RuntimeException(str + " markEnd before markStart");
                }
            } else if (aVar.d() > 0) {
            } else {
                aVar.h(System.currentTimeMillis());
                if (f5285b) {
                    Log.d("Api-FirstRecorder", str + " first called cost " + aVar.c());
                }
                if (TextUtils.equals(str, "request")) {
                    if (f5285b) {
                        Log.d("Api-FirstRecorder", "record first request api called " + aVar.toString());
                    }
                    HybridUbcFlow p = h.p(NodeJS.STARTUP_SCRIPT_NAME);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("first_request_api_call_start");
                    ubcFlowEvent.h(aVar.e());
                    p.F(ubcFlowEvent);
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("first_request_api_call_end");
                    ubcFlowEvent2.h(aVar.d());
                    p.F(ubcFlowEvent2);
                }
            }
        }
    }
}
