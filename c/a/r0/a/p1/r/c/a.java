package c.a.r0.a.p1.r.c;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.d2.e;
import c.a.r0.a.h2.c.f;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.r0.a.p1.r.c.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static LruCache<String, ArrayMap<String, f>> f8316b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.p1.r.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0511a implements c.a.r0.a.p1.r.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.z2.g1.c a;

        /* renamed from: c.a.r0.a.p1.r.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0512a implements c.a.r0.a.p1.r.b.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ C0511a a;

            public C0512a(C0511a c0511a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0511a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = c0511a;
            }

            @Override // c.a.r0.a.p1.r.b.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    boolean unused = a.a;
                    this.a.a.onCallback(a.g(true));
                }
            }
        }

        public C0511a(c.a.r0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
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
        }

        @Override // c.a.r0.a.p1.r.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, f> g2 = a.g(true);
                if (g2.size() > 0) {
                    this.a.onCallback(g2);
                    boolean unused = a.a;
                    return;
                }
                c.a.r0.a.e0.d.k("SwanAppUpdateManager", "has not scope set，required request from server");
                c.a.r0.a.p1.r.a.g().update(new C0512a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements c.a.r0.a.p1.r.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z2.g1.c f8317b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f8318c;

        public b(String str, c.a.r0.a.z2.g1.c cVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, cVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f8317b = cVar;
            this.f8318c = str2;
        }

        @Override // c.a.r0.a.p1.r.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.p1.r.d.b.f().d(this.a);
                this.f8317b.onCallback(a.g(true).get(this.f8318c));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(275658456, "Lc/a/r0/a/p1/r/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(275658456, "Lc/a/r0/a/p1/r/c/a;");
                return;
            }
        }
        a = k.a;
        f8316b = new LruCache<>(6);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            c.a.r0.a.e0.d.k("SwanAppUpdateManager", "cleanAccreditListData");
            e L = e.L();
            if (L == null) {
                c.a.r0.a.e0.d.k("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            c.a.r0.a.e0.d.k("SwanAppUpdateManager", "prefName: " + L.d0().p() + ", cleanAccredit");
            c.a.r0.a.p1.r.a.g().w(new a());
            L.d0().B("node_data_accredit_list", "");
            o();
            c.a.r0.a.p1.r.a.g().update();
        }
    }

    @NonNull
    public static Map<String, f> g(boolean z) {
        InterceptResult invokeZ;
        ArrayMap<String, f> l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z)) == null) {
            if (!z || (l = l()) == null) {
                long nanoTime = a ? System.nanoTime() : 0L;
                ArrayMap arrayMap = new ArrayMap();
                e L = e.L();
                if (L == null) {
                    c.a.r0.a.e0.d.k("SwanAppUpdateManager", "#getAccreditListData swanApp=null");
                    return arrayMap;
                }
                String appId = L.getAppId();
                String q = L.d0().q("node_data_accredit_list", "");
                String q2 = L.d0().q("cur_request_id", "");
                c.a.r0.a.e0.d.k("SwanAppUpdateManager", "#getAccreditListData prefName=" + L.d0().p() + " requestId=" + q2 + " accreditList=" + q);
                if (TextUtils.isEmpty(q)) {
                    return arrayMap;
                }
                try {
                    ArrayMap<String, f> m = m(new JSONObject(q), appId);
                    if (a) {
                        long nanoTime2 = System.nanoTime();
                        StringBuilder sb = new StringBuilder();
                        sb.append("#getAccreditListData cost=");
                        sb.append((nanoTime2 - nanoTime) / 1000000.0d);
                        sb.append(" size=");
                        LruCache<String, ArrayMap<String, f>> lruCache = f8316b;
                        sb.append(lruCache == null ? 0 : lruCache.size());
                        sb.toString();
                    }
                    c.a.r0.a.e0.d.k("SwanAppUpdateManager", "getAccreditListData - from json");
                    return m;
                } catch (JSONException e2) {
                    c.a.r0.a.e0.d.l("SwanAppUpdateManager", "#getAccreditListData - parse accreditList fail", e2);
                    return arrayMap;
                }
            }
            return l;
        }
        return (Map) invokeZ.objValue;
    }

    public static void h(@NonNull c.a.r0.a.z2.g1.c<Map<String, f>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, cVar) == null) {
            boolean z = a;
            c.a.r0.a.p1.r.a.g().z(new C0511a(cVar));
        }
    }

    public static void i(String str, @NonNull c.a.r0.a.z2.g1.c<f> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, cVar) == null) {
            j(str, cVar, c.a.r0.a.p1.r.d.b.f().b(str));
        }
    }

    public static void j(String str, @NonNull c.a.r0.a.z2.g1.c<f> cVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, cVar, str2) == null) {
            f fVar = g(true).get(str);
            if (fVar != null) {
                c.a.r0.a.p1.r.d.b.f().d(str2);
                cVar.onCallback(fVar);
                boolean z = a;
                return;
            }
            c.a.r0.a.e0.d.k("SwanAppUpdateManager", "has not scope node，required request from server");
            c.a.r0.a.p1.r.a.g().update(new b(str2, cVar, str));
        }
    }

    @Nullable
    public static f k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? g(true).get(str) : (f) invokeL.objValue;
    }

    public static ArrayMap<String, f> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            e a0 = e.a0();
            if (a0 == null || TextUtils.isEmpty(a0.f5537f)) {
                return null;
            }
            return f8316b.get(a0.f5537f);
        }
        return (ArrayMap) invokeV.objValue;
    }

    public static ArrayMap<String, f> m(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, jSONObject, str)) == null) {
            ArrayMap<String, f> arrayMap = new ArrayMap<>();
            if (jSONObject == null) {
                return arrayMap;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("list");
            if (optJSONObject2 == null) {
                c.a.r0.a.e0.d.k("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
                return arrayMap;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap.put(next, f.f(next, optJSONObject));
                }
            }
            n(arrayMap, str);
            return arrayMap;
        }
        return (ArrayMap) invokeLL.objValue;
    }

    public static void n(ArrayMap<String, f> arrayMap, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, arrayMap, str) == null) || arrayMap == null || arrayMap.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.r0.a.e0.d.k("SwanAppUpdateManager", "putScopeInfo to cache: appId=" + str + ",getAppId=" + c.a.r0.a.d2.d.J().getAppId());
        f8316b.put(str, arrayMap);
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            c.a.r0.a.e0.d.k("SwanAppUpdateManager", "resetCache");
            f8316b.evictAll();
        }
    }

    @Override // c.a.r0.a.p1.r.c.b
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "accredit" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.p1.r.c.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.r0.a.e0.d.k("SwanAppUpdateManager", "onFail");
        }
    }

    @Override // c.a.r0.a.p1.r.c.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.r0.a.e0.d.k("SwanAppUpdateManager", "onFiltered");
        }
    }

    @Override // c.a.r0.a.p1.r.c.b
    public void d(String str, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, jSONObject, str2) == null) {
            c.a.r0.a.e0.d.k("SwanAppUpdateManager", "onUpdate ");
            if (jSONObject == null) {
                c.a.r0.a.e0.d.k("SwanAppUpdateManager", ADConfigError.REASON_NULL_DATA);
                return;
            }
            e L = e.L();
            if (L == null) {
                c.a.r0.a.e0.d.k("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            String jSONObject2 = jSONObject.toString();
            c.a.r0.a.e0.d.k("SwanAppUpdateManager", "request appId: " + str + ",prefName: " + L.d0().p() + ", putAccredit = " + jSONObject2);
            L.d0().B("node_data_accredit_list", jSONObject2);
            c.a.r0.a.h2.a d0 = L.d0();
            d0.B("cur_request_id", "update:" + str2 + "_" + str + "_" + System.currentTimeMillis());
            o();
        }
    }
}
