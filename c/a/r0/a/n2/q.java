package c.a.r0.a.n2;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f8144b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<a> f8145c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.a.r0.a.n2.s.c a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f8146b;

        /* renamed from: c  reason: collision with root package name */
        public final long f8147c;

        /* renamed from: d  reason: collision with root package name */
        public final String f8148d;

        public a(@NonNull c.a.r0.a.n2.s.c cVar, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
            this.f8148d = str;
            this.f8147c = cVar.l();
            synchronized (q.f8145c) {
                if (q.f8144b) {
                    q.f8145c.add(this);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(431581180, "Lc/a/r0/a/n2/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(431581180, "Lc/a/r0/a/n2/q;");
                return;
            }
        }
        a = c.a.r0.a.k.a;
        f8144b = false;
        f8145c = new ArrayList();
    }

    public static void c(@NonNull HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent g2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, hybridUbcFlow) == null) && "670".equals(hybridUbcFlow.l())) {
            hybridUbcFlow.D("networkStatus", String.valueOf(c.a.r0.a.p1.l.a()));
            if (c.a.r0.a.u1.l.b.f9614f || (g2 = hybridUbcFlow.g("na_first_meaningful_paint")) == null) {
                return;
            }
            long g3 = g2.g();
            synchronized (f8145c) {
                if (a) {
                    String str = "size=" + f8145c.size();
                }
                f8144b = false;
                JSONArray jSONArray = new JSONArray();
                for (a aVar : f8145c) {
                    if (aVar.f8147c <= g3) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", aVar.f8148d);
                            if (aVar.a != null) {
                                aVar.a.p(jSONObject);
                            }
                            if (aVar.f8146b != null) {
                                Iterator<String> keys = aVar.f8146b.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    jSONObject.put(next, aVar.f8146b.get(next));
                                }
                            }
                            jSONArray.put(jSONObject);
                        } catch (JSONException unused) {
                            boolean z = a;
                        }
                    }
                }
                if (jSONArray.length() > 0) {
                    hybridUbcFlow.D("requests", jSONArray.toString());
                }
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (f8145c) {
                f8144b = true;
                f8145c.clear();
            }
        }
    }
}
