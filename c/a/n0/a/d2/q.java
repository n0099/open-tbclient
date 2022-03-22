package c.a.n0.a.d2;

import android.util.Log;
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
    public static volatile boolean f4180b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<a> f4181c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.a.n0.a.d2.s.c a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f4182b;

        /* renamed from: c  reason: collision with root package name */
        public final long f4183c;

        /* renamed from: d  reason: collision with root package name */
        public final String f4184d;

        public a(@NonNull c.a.n0.a.d2.s.c cVar, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
            this.f4184d = str;
            this.f4183c = cVar.l();
            synchronized (q.f4181c) {
                if (q.f4180b) {
                    q.f4181c.add(this);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1208399990, "Lc/a/n0/a/d2/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1208399990, "Lc/a/n0/a/d2/q;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        f4180b = false;
        f4181c = new ArrayList();
    }

    public static void c(@NonNull HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent g2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, hybridUbcFlow) == null) && "670".equals(hybridUbcFlow.l())) {
            hybridUbcFlow.D("networkStatus", String.valueOf(c.a.n0.a.f1.l.a()));
            if (c.a.n0.a.k1.l.b.f5358f || (g2 = hybridUbcFlow.g("na_first_meaningful_paint")) == null) {
                return;
            }
            long g3 = g2.g();
            synchronized (f4181c) {
                if (a) {
                    Log.d("SwanReqStatisticManager", "size=" + f4181c.size());
                }
                f4180b = false;
                JSONArray jSONArray = new JSONArray();
                for (a aVar : f4181c) {
                    if (aVar.f4183c <= g3) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", aVar.f4184d);
                            if (aVar.a != null) {
                                aVar.a.p(jSONObject);
                            }
                            if (aVar.f4182b != null) {
                                Iterator<String> keys = aVar.f4182b.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    jSONObject.put(next, aVar.f4182b.get(next));
                                }
                            }
                            jSONArray.put(jSONObject);
                        } catch (JSONException e2) {
                            if (a) {
                                Log.e("SwanReqStatisticManager", "appendRequestRecord", e2);
                            }
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
            synchronized (f4181c) {
                f4180b = true;
                f4181c.clear();
            }
        }
    }
}
