package c.a.p0.a.n1.q.c;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a2.e;
import c.a.p0.a.e2.c.f;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
public class a extends c.a.p0.a.n1.q.c.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7634a;

    /* renamed from: b  reason: collision with root package name */
    public static LruCache<String, ArrayMap<String, f>> f7635b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.n1.q.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0318a implements c.a.p0.a.n1.q.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v2.e1.b f7636a;

        /* renamed from: c.a.p0.a.n1.q.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0319a implements c.a.p0.a.n1.q.b.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ C0318a f7637a;

            public C0319a(C0318a c0318a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0318a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7637a = c0318a;
            }

            @Override // c.a.p0.a.n1.q.b.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    boolean unused = a.f7634a;
                    this.f7637a.f7636a.onCallback(a.g(true));
                }
            }
        }

        public C0318a(c.a.p0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7636a = bVar;
        }

        @Override // c.a.p0.a.n1.q.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, f> g2 = a.g(true);
                if (g2.size() > 0) {
                    this.f7636a.onCallback(g2);
                    boolean unused = a.f7634a;
                    return;
                }
                c.a.p0.a.e0.d.h("SwanAppUpdateManager", "has not scope set，required request from server");
                c.a.p0.a.n1.q.a.g().B(new C0319a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements c.a.p0.a.n1.q.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7638a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v2.e1.b f7639b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f7640c;

        public b(String str, c.a.p0.a.v2.e1.b bVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, bVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7638a = str;
            this.f7639b = bVar;
            this.f7640c = str2;
        }

        @Override // c.a.p0.a.n1.q.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.n1.q.d.b.f().d(this.f7638a);
                this.f7639b.onCallback(a.g(true).get(this.f7640c));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(578088185, "Lc/a/p0/a/n1/q/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(578088185, "Lc/a/p0/a/n1/q/c/a;");
                return;
            }
        }
        f7634a = k.f7077a;
        f7635b = new LruCache<>(6);
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
            c.a.p0.a.e0.d.h("SwanAppUpdateManager", "cleanAccreditListData");
            e i2 = e.i();
            if (i2 == null) {
                c.a.p0.a.e0.d.h("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            c.a.p0.a.e0.d.h("SwanAppUpdateManager", "prefName: " + i2.T().p() + ", cleanAccredit");
            c.a.p0.a.n1.q.a.g().w(new a());
            i2.T().B("node_data_accredit_list", "");
            o();
            c.a.p0.a.n1.q.a.g().A();
        }
    }

    @NonNull
    public static Map<String, f> g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z)) == null) {
            ArrayMap<String, f> l = l();
            if (l != null && z) {
                c.a.p0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData from cache, size = " + l.size());
                return l;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayMap arrayMap = new ArrayMap();
            e i2 = e.i();
            if (i2 == null) {
                c.a.p0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - swanApp is null");
                return arrayMap;
            }
            String q = i2.T().q("node_data_accredit_list", "");
            String q2 = i2.T().q("cur_request_id", "");
            c.a.p0.a.e0.d.h("SwanAppUpdateManager", "prefName: " + i2.T().p() + ", requestId: " + q2 + ", getAccreditListData - from sp =" + q);
            if (TextUtils.isEmpty(q)) {
                c.a.p0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - sp is null");
                return arrayMap;
            }
            try {
                ArrayMap<String, f> m = m(new JSONObject(q));
                if (f7634a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    StringBuilder sb = new StringBuilder();
                    sb.append("getAccreditListData cost = ");
                    sb.append(currentTimeMillis2 - currentTimeMillis);
                    sb.append(" ; size = ");
                    LruCache<String, ArrayMap<String, f>> lruCache = f7635b;
                    sb.append(lruCache == null ? 0 : lruCache.size());
                    sb.toString();
                }
                c.a.p0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - from json");
                return m;
            } catch (JSONException e2) {
                c.a.p0.a.e0.d.i("SwanAppUpdateManager", "getAccreditListData - parse json fail", e2);
                return arrayMap;
            }
        }
        return (Map) invokeZ.objValue;
    }

    public static void h(@NonNull c.a.p0.a.v2.e1.b<Map<String, f>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bVar) == null) {
            boolean z = f7634a;
            c.a.p0.a.n1.q.a.g().z(new C0318a(bVar));
        }
    }

    public static void i(String str, @NonNull c.a.p0.a.v2.e1.b<f> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, bVar) == null) {
            j(str, bVar, c.a.p0.a.n1.q.d.b.f().b(str));
        }
    }

    public static void j(String str, @NonNull c.a.p0.a.v2.e1.b<f> bVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, bVar, str2) == null) {
            f fVar = g(true).get(str);
            if (fVar != null) {
                c.a.p0.a.n1.q.d.b.f().d(str2);
                bVar.onCallback(fVar);
                boolean z = f7634a;
                return;
            }
            c.a.p0.a.e0.d.h("SwanAppUpdateManager", "has not scope node，required request from server");
            c.a.p0.a.n1.q.a.g().B(new b(str2, bVar, str));
        }
    }

    @Nullable
    public static f k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            c.a.p0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListDataFromLocalCache, scope = " + str);
            return g(true).get(str);
        }
        return (f) invokeL.objValue;
    }

    public static ArrayMap<String, f> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            e Q = e.Q();
            if (Q == null || TextUtils.isEmpty(Q.f4558f)) {
                return null;
            }
            return f7635b.get(Q.f4558f);
        }
        return (ArrayMap) invokeV.objValue;
    }

    public static ArrayMap<String, f> m(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONObject)) == null) {
            ArrayMap<String, f> arrayMap = new ArrayMap<>();
            if (jSONObject == null) {
                return arrayMap;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("list");
            if (optJSONObject2 == null) {
                c.a.p0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
                return arrayMap;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap.put(next, f.d(next, optJSONObject));
                }
            }
            n(arrayMap);
            c.a.p0.a.e0.d.h("SwanAppUpdateManager", "parseScopeInfoMap to cache");
            return arrayMap;
        }
        return (ArrayMap) invokeL.objValue;
    }

    public static void n(ArrayMap<String, f> arrayMap) {
        e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, arrayMap) == null) || arrayMap == null || arrayMap.size() <= 0 || (Q = e.Q()) == null || TextUtils.isEmpty(Q.f4558f)) {
            return;
        }
        f7635b.put(Q.f4558f, arrayMap);
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            c.a.p0.a.e0.d.h("SwanAppUpdateManager", "resetCache");
            f7635b.evictAll();
        }
    }

    @Override // c.a.p0.a.n1.q.c.b
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "accredit" : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.n1.q.c.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.p0.a.e0.d.h("SwanAppUpdateManager", "onFail");
        }
    }

    @Override // c.a.p0.a.n1.q.c.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.a.e0.d.h("SwanAppUpdateManager", "onFiltered");
        }
    }

    @Override // c.a.p0.a.n1.q.c.b
    public void d(String str, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, jSONObject, str2) == null) {
            c.a.p0.a.e0.d.h("SwanAppUpdateManager", "onUpdate ");
            if (jSONObject == null) {
                c.a.p0.a.e0.d.h("SwanAppUpdateManager", "data is null");
                return;
            }
            e i2 = e.i();
            if (i2 == null) {
                c.a.p0.a.e0.d.h("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            String jSONObject2 = jSONObject.toString();
            c.a.p0.a.e0.d.h("SwanAppUpdateManager", "request appId: " + str + ",prefName: " + i2.T().p() + ", putAccredit = " + jSONObject2);
            i2.T().B("node_data_accredit_list", jSONObject2);
            c.a.p0.a.e2.a T = i2.T();
            T.B("cur_request_id", "update:" + str2 + "_" + str + "_" + System.currentTimeMillis());
            o();
        }
    }
}
