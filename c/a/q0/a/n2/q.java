package c.a.q0.a.n2;

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
    public static volatile boolean f7409b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<a> f7410c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.a.q0.a.n2.s.c a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f7411b;

        /* renamed from: c  reason: collision with root package name */
        public final long f7412c;

        /* renamed from: d  reason: collision with root package name */
        public final String f7413d;

        public a(@NonNull c.a.q0.a.n2.s.c cVar, @NonNull String str) {
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
            this.f7413d = str;
            this.f7412c = cVar.l();
            synchronized (q.f7410c) {
                if (q.f7409b) {
                    q.f7410c.add(this);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(628094685, "Lc/a/q0/a/n2/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(628094685, "Lc/a/q0/a/n2/q;");
                return;
            }
        }
        a = c.a.q0.a.k.a;
        f7409b = false;
        f7410c = new ArrayList();
    }

    public static void c(@NonNull HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent g2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, hybridUbcFlow) == null) && "670".equals(hybridUbcFlow.l())) {
            hybridUbcFlow.D("networkStatus", String.valueOf(c.a.q0.a.p1.l.a()));
            if (c.a.q0.a.u1.l.b.f8879f || (g2 = hybridUbcFlow.g("na_first_meaningful_paint")) == null) {
                return;
            }
            long g3 = g2.g();
            synchronized (f7410c) {
                if (a) {
                    String str = "size=" + f7410c.size();
                }
                f7409b = false;
                JSONArray jSONArray = new JSONArray();
                for (a aVar : f7410c) {
                    if (aVar.f7412c <= g3) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", aVar.f7413d);
                            if (aVar.a != null) {
                                aVar.a.p(jSONObject);
                            }
                            if (aVar.f7411b != null) {
                                Iterator<String> keys = aVar.f7411b.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    jSONObject.put(next, aVar.f7411b.get(next));
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
            synchronized (f7410c) {
                f7409b = true;
                f7410c.clear();
            }
        }
    }
}
