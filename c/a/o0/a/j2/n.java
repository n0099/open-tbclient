package c.a.o0.a.j2;

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
    public static final boolean f7023a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f7024b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<a> f7025c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final c.a.o0.a.j2.p.c f7026a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f7027b;

        /* renamed from: c  reason: collision with root package name */
        public final long f7028c;

        /* renamed from: d  reason: collision with root package name */
        public final String f7029d;

        public a(@NonNull c.a.o0.a.j2.p.c cVar, @NonNull String str) {
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
            this.f7026a = cVar;
            this.f7029d = str;
            this.f7028c = cVar.l();
            synchronized (n.f7025c) {
                if (n.f7024b) {
                    n.f7025c.add(this);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1017427518, "Lc/a/o0/a/j2/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1017427518, "Lc/a/o0/a/j2/n;");
                return;
            }
        }
        f7023a = c.a.o0.a.k.f7049a;
        f7024b = false;
        f7025c = new ArrayList();
    }

    public static void c(@NonNull HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, hybridUbcFlow) == null) && "670".equals(hybridUbcFlow.j())) {
            hybridUbcFlow.A("networkStatus", String.valueOf(c.a.o0.a.n1.l.a()));
            if (c.a.o0.a.r1.l.b.o || (f2 = hybridUbcFlow.f("na_first_meaningful_paint")) == null) {
                return;
            }
            long g2 = f2.g();
            synchronized (f7025c) {
                if (f7023a) {
                    String str = "size=" + f7025c.size();
                }
                f7024b = false;
                JSONArray jSONArray = new JSONArray();
                for (a aVar : f7025c) {
                    if (aVar.f7028c <= g2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", aVar.f7029d);
                            if (aVar.f7026a != null) {
                                aVar.f7026a.o(jSONObject);
                            }
                            if (aVar.f7027b != null) {
                                Iterator<String> keys = aVar.f7027b.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    jSONObject.put(next, aVar.f7027b.get(next));
                                }
                            }
                            jSONArray.put(jSONObject);
                        } catch (JSONException unused) {
                            boolean z = f7023a;
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
            synchronized (f7025c) {
                f7024b = true;
                f7025c.clear();
            }
        }
    }
}
