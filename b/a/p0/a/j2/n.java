package b.a.p0.a.j2;

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
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6372a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f6373b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<a> f6374c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final b.a.p0.a.j2.p.c f6375a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f6376b;

        /* renamed from: c  reason: collision with root package name */
        public final long f6377c;

        /* renamed from: d  reason: collision with root package name */
        public final String f6378d;

        public a(@NonNull b.a.p0.a.j2.p.c cVar, @NonNull String str) {
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
            this.f6375a = cVar;
            this.f6378d = str;
            this.f6377c = cVar.l();
            synchronized (n.f6374c) {
                if (n.f6373b) {
                    n.f6374c.add(this);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1326472638, "Lb/a/p0/a/j2/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1326472638, "Lb/a/p0/a/j2/n;");
                return;
            }
        }
        f6372a = b.a.p0.a.k.f6397a;
        f6373b = false;
        f6374c = new ArrayList();
    }

    public static void c(@NonNull HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, hybridUbcFlow) == null) && "670".equals(hybridUbcFlow.j())) {
            hybridUbcFlow.A("networkStatus", String.valueOf(b.a.p0.a.n1.l.a()));
            if (b.a.p0.a.r1.l.b.o || (f2 = hybridUbcFlow.f("na_first_meaningful_paint")) == null) {
                return;
            }
            long g2 = f2.g();
            synchronized (f6374c) {
                if (f6372a) {
                    String str = "size=" + f6374c.size();
                }
                f6373b = false;
                JSONArray jSONArray = new JSONArray();
                for (a aVar : f6374c) {
                    if (aVar.f6377c <= g2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", aVar.f6378d);
                            if (aVar.f6375a != null) {
                                aVar.f6375a.o(jSONObject);
                            }
                            if (aVar.f6376b != null) {
                                Iterator<String> keys = aVar.f6376b.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    jSONObject.put(next, aVar.f6376b.get(next));
                                }
                            }
                            jSONArray.put(jSONObject);
                        } catch (JSONException unused) {
                            boolean z = f6372a;
                        }
                    }
                }
                if (jSONArray.length() > 0) {
                    hybridUbcFlow.A("requests", jSONArray.toString());
                }
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (f6374c) {
                f6373b = true;
                f6374c.clear();
            }
        }
    }
}
