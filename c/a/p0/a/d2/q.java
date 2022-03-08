package c.a.p0.a.d2;

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
    public static volatile boolean f4935b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<a> f4936c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.a.p0.a.d2.s.c a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f4937b;

        /* renamed from: c  reason: collision with root package name */
        public final long f4938c;

        /* renamed from: d  reason: collision with root package name */
        public final String f4939d;

        public a(@NonNull c.a.p0.a.d2.s.c cVar, @NonNull String str) {
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
            this.f4939d = str;
            this.f4938c = cVar.l();
            synchronized (q.f4936c) {
                if (q.f4935b) {
                    q.f4936c.add(this);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(815372980, "Lc/a/p0/a/d2/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(815372980, "Lc/a/p0/a/d2/q;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
        f4935b = false;
        f4936c = new ArrayList();
    }

    public static void c(@NonNull HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent g2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, hybridUbcFlow) == null) && "670".equals(hybridUbcFlow.l())) {
            hybridUbcFlow.D("networkStatus", String.valueOf(c.a.p0.a.f1.l.a()));
            if (c.a.p0.a.k1.l.b.f6375f || (g2 = hybridUbcFlow.g("na_first_meaningful_paint")) == null) {
                return;
            }
            long g3 = g2.g();
            synchronized (f4936c) {
                if (a) {
                    String str = "size=" + f4936c.size();
                }
                f4935b = false;
                JSONArray jSONArray = new JSONArray();
                for (a aVar : f4936c) {
                    if (aVar.f4938c <= g3) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", aVar.f4939d);
                            if (aVar.a != null) {
                                aVar.a.p(jSONObject);
                            }
                            if (aVar.f4937b != null) {
                                Iterator<String> keys = aVar.f4937b.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    jSONObject.put(next, aVar.f4937b.get(next));
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
            synchronized (f4936c) {
                f4935b = true;
                f4936c.clear();
            }
        }
    }
}
