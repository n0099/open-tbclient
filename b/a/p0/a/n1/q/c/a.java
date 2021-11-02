package b.a.p0.a.n1.q.c;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.e;
import b.a.p0.a.e2.c.f;
import b.a.p0.a.k;
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
public class a extends b.a.p0.a.n1.q.c.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6943a;

    /* renamed from: b  reason: collision with root package name */
    public static LruCache<String, ArrayMap<String, f>> f6944b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.n1.q.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0313a implements b.a.p0.a.n1.q.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.e1.b f6945a;

        /* renamed from: b.a.p0.a.n1.q.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0314a implements b.a.p0.a.n1.q.b.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ C0313a f6946a;

            public C0314a(C0313a c0313a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0313a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6946a = c0313a;
            }

            @Override // b.a.p0.a.n1.q.b.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    boolean unused = a.f6943a;
                    this.f6946a.f6945a.onCallback(a.g(true));
                }
            }
        }

        public C0313a(b.a.p0.a.v2.e1.b bVar) {
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
            this.f6945a = bVar;
        }

        @Override // b.a.p0.a.n1.q.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, f> g2 = a.g(true);
                if (g2.size() > 0) {
                    this.f6945a.onCallback(g2);
                    boolean unused = a.f6943a;
                    return;
                }
                b.a.p0.a.e0.d.h("SwanAppUpdateManager", "has not scope set，required request from server");
                b.a.p0.a.n1.q.a.g().update(new C0314a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements b.a.p0.a.n1.q.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6947a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.e1.b f6948b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6949c;

        public b(String str, b.a.p0.a.v2.e1.b bVar, String str2) {
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
            this.f6947a = str;
            this.f6948b = bVar;
            this.f6949c = str2;
        }

        @Override // b.a.p0.a.n1.q.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.n1.q.d.b.f().d(this.f6947a);
                this.f6948b.onCallback(a.g(true).get(this.f6949c));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1575160538, "Lb/a/p0/a/n1/q/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1575160538, "Lb/a/p0/a/n1/q/c/a;");
                return;
            }
        }
        f6943a = k.f6397a;
        f6944b = new LruCache<>(6);
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
            b.a.p0.a.e0.d.h("SwanAppUpdateManager", "cleanAccreditListData");
            e i2 = e.i();
            if (i2 == null) {
                b.a.p0.a.e0.d.h("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            b.a.p0.a.e0.d.h("SwanAppUpdateManager", "prefName: " + i2.S().p() + ", cleanAccredit");
            b.a.p0.a.n1.q.a.g().w(new a());
            i2.S().B("node_data_accredit_list", "");
            o();
            b.a.p0.a.n1.q.a.g().update();
        }
    }

    @NonNull
    public static Map<String, f> g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z)) == null) {
            ArrayMap<String, f> l = l();
            if (l != null && z) {
                b.a.p0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData from cache, size = " + l.size());
                return l;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayMap arrayMap = new ArrayMap();
            e i2 = e.i();
            if (i2 == null) {
                b.a.p0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - swanApp is null");
                return arrayMap;
            }
            String q = i2.S().q("node_data_accredit_list", "");
            String q2 = i2.S().q("cur_request_id", "");
            b.a.p0.a.e0.d.h("SwanAppUpdateManager", "prefName: " + i2.S().p() + ", requestId: " + q2 + ", getAccreditListData - from sp =" + q);
            if (TextUtils.isEmpty(q)) {
                b.a.p0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - sp is null");
                return arrayMap;
            }
            try {
                ArrayMap<String, f> m = m(new JSONObject(q));
                if (f6943a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    StringBuilder sb = new StringBuilder();
                    sb.append("getAccreditListData cost = ");
                    sb.append(currentTimeMillis2 - currentTimeMillis);
                    sb.append(" ; size = ");
                    LruCache<String, ArrayMap<String, f>> lruCache = f6944b;
                    sb.append(lruCache == null ? 0 : lruCache.size());
                    sb.toString();
                }
                b.a.p0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - from json");
                return m;
            } catch (JSONException e2) {
                b.a.p0.a.e0.d.i("SwanAppUpdateManager", "getAccreditListData - parse json fail", e2);
                return arrayMap;
            }
        }
        return (Map) invokeZ.objValue;
    }

    public static void h(@NonNull b.a.p0.a.v2.e1.b<Map<String, f>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bVar) == null) {
            boolean z = f6943a;
            b.a.p0.a.n1.q.a.g().z(new C0313a(bVar));
        }
    }

    public static void i(String str, @NonNull b.a.p0.a.v2.e1.b<f> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, bVar) == null) {
            j(str, bVar, b.a.p0.a.n1.q.d.b.f().b(str));
        }
    }

    public static void j(String str, @NonNull b.a.p0.a.v2.e1.b<f> bVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, bVar, str2) == null) {
            f fVar = g(true).get(str);
            if (fVar != null) {
                b.a.p0.a.n1.q.d.b.f().d(str2);
                bVar.onCallback(fVar);
                boolean z = f6943a;
                return;
            }
            b.a.p0.a.e0.d.h("SwanAppUpdateManager", "has not scope node，required request from server");
            b.a.p0.a.n1.q.a.g().update(new b(str2, bVar, str));
        }
    }

    @Nullable
    public static f k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            b.a.p0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListDataFromLocalCache, scope = " + str);
            return g(true).get(str);
        }
        return (f) invokeL.objValue;
    }

    public static ArrayMap<String, f> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            e P = e.P();
            if (P == null || TextUtils.isEmpty(P.f3961f)) {
                return null;
            }
            return f6944b.get(P.f3961f);
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
                b.a.p0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
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
            b.a.p0.a.e0.d.h("SwanAppUpdateManager", "parseScopeInfoMap to cache");
            return arrayMap;
        }
        return (ArrayMap) invokeL.objValue;
    }

    public static void n(ArrayMap<String, f> arrayMap) {
        e P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, arrayMap) == null) || arrayMap == null || arrayMap.size() <= 0 || (P = e.P()) == null || TextUtils.isEmpty(P.f3961f)) {
            return;
        }
        f6944b.put(P.f3961f, arrayMap);
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            b.a.p0.a.e0.d.h("SwanAppUpdateManager", "resetCache");
            f6944b.evictAll();
        }
    }

    @Override // b.a.p0.a.n1.q.c.b
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "accredit" : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.n1.q.c.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.p0.a.e0.d.h("SwanAppUpdateManager", "onFail");
        }
    }

    @Override // b.a.p0.a.n1.q.c.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.p0.a.e0.d.h("SwanAppUpdateManager", "onFiltered");
        }
    }

    @Override // b.a.p0.a.n1.q.c.b
    public void d(String str, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, jSONObject, str2) == null) {
            b.a.p0.a.e0.d.h("SwanAppUpdateManager", "onUpdate ");
            if (jSONObject == null) {
                b.a.p0.a.e0.d.h("SwanAppUpdateManager", "data is null");
                return;
            }
            e i2 = e.i();
            if (i2 == null) {
                b.a.p0.a.e0.d.h("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            String jSONObject2 = jSONObject.toString();
            b.a.p0.a.e0.d.h("SwanAppUpdateManager", "request appId: " + str + ",prefName: " + i2.S().p() + ", putAccredit = " + jSONObject2);
            i2.S().B("node_data_accredit_list", jSONObject2);
            b.a.p0.a.e2.a S = i2.S();
            S.B("cur_request_id", "update:" + str2 + "_" + str + "_" + System.currentTimeMillis());
            o();
        }
    }
}
