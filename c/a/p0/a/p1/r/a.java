package c.a.p0.a.p1.r;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d2.e;
import c.a.p0.a.e0.d;
import c.a.p0.a.k;
import c.a.p0.a.n2.n;
import c.a.p0.a.p1.r.c.c;
import c.a.p0.a.z2.w;
import c.a.p0.q.k.i.r;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f7447d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f7448e;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.p0.a.p1.r.c.b> a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f7449b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<c.a.p0.a.p1.r.b.a> f7450c;

    /* renamed from: c.a.p0.a.p1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0417a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f7451b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ArrayMap f7452c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f7453d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7454e;

        public C0417a(a aVar, String str, List list, ArrayMap arrayMap, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, list, arrayMap, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7454e = aVar;
            this.a = str;
            this.f7451b = list;
            this.f7452c = arrayMap;
            this.f7453d = str2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.f7454e.d(this.f7451b);
                d.l("SwanAppUpdateManager", "update request failure: ", exc);
                n.z(this.f7453d, -1, exc.toString());
                c.a.p0.a.n2.t.a.b(SwanInterfaceType.UPDATE, 2101, this.f7453d, null, exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                String appId = c.a.p0.a.d2.d.J().getAppId();
                if (TextUtils.equals(this.a, appId)) {
                    this.f7454e.s(this.a, response, this.f7451b, this.f7452c);
                    d.k("SwanAppUpdateManager", "response code = " + response.code());
                    if (!response.isSuccessful()) {
                        n.z(this.f7453d, response.code(), response.message());
                    }
                    return response;
                }
                d.k("SwanAppUpdateManager", "invalid response requestAppId:" + this.a + ";currentAppId:" + appId);
                this.f7454e.d(this.f7451b);
                a.x(this.a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p1.r.b.a f7455e;

        public b(a aVar, c.a.p0.a.p1.r.b.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7455e = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7455e.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-374079634, "Lc/a/p0/a/p1/r/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-374079634, "Lc/a/p0/a/p1/r/a;");
                return;
            }
        }
        f7447d = k.a;
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
                return;
            }
        }
        k();
    }

    public static a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f7448e == null) {
                synchronized (a.class) {
                    if (f7448e == null) {
                        f7448e = new a();
                    }
                }
            }
            return f7448e;
        }
        return (a) invokeV.objValue;
    }

    public static void x(String str) {
        e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, str) == null) || (a0 = e.a0()) == null) {
            return;
        }
        c.a.p0.a.u2.a aVar = new c.a.p0.a.u2.a();
        aVar.k(5L);
        aVar.i(53L);
        c.a.p0.a.n2.s.d dVar = new c.a.p0.a.n2.s.d();
        dVar.p(aVar);
        dVar.r(a0.V());
        dVar.q(n.n(a0.l()));
        dVar.m(a0.getAppId());
        dVar.a("requestAppId", str);
        n.R(dVar);
    }

    public final void A(@NonNull List<c.a.p0.a.p1.r.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        e L;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, list, arrayMap) == null) || list.size() == 0 || (L = e.L()) == null) {
            return;
        }
        String q = L.d0().q("update_nodes_version", "");
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(q)) {
            try {
                jSONObject = new JSONObject(q);
            } catch (JSONException e2) {
                if (f7447d) {
                    e2.printStackTrace();
                }
            }
        }
        for (c.a.p0.a.p1.r.c.b bVar : list) {
            String str = arrayMap.get(bVar.a());
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            try {
                if (f7447d) {
                    String str2 = "updateNodeVersions: update node => " + bVar.a() + " , version => " + str;
                }
                jSONObject.put(bVar.a(), str);
            } catch (JSONException e3) {
                if (f7447d) {
                    e3.printStackTrace();
                }
            }
        }
        L.d0().B("update_nodes_version", jSONObject.toString());
    }

    @Nullable
    public final JSONObject c(@NonNull List<c.a.p0.a.p1.r.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, arrayMap)) == null) {
            if (list.size() == 0) {
                return null;
            }
            String N = c.a.p0.a.d2.d.J().r().N();
            if (TextUtils.isEmpty(N)) {
                return null;
            }
            String T = e.L().X().T();
            if (TextUtils.isEmpty(T)) {
                T = "NA";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", N);
                jSONObject.put("source", T);
            } catch (JSONException e2) {
                if (f7447d) {
                    e2.printStackTrace();
                }
            }
            for (c.a.p0.a.p1.r.c.b bVar : list) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    String str = arrayMap.containsKey(bVar.a()) ? arrayMap.get(bVar.a()) : "";
                    if (f7447d) {
                        String str2 = "buildRequestParams: node => " + bVar.a() + " , version => " + str;
                    }
                    jSONObject2.put("version", str);
                    jSONObject.put(bVar.a(), jSONObject2);
                } catch (JSONException e3) {
                    if (f7447d) {
                        e3.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final void d(@NonNull List<c.a.p0.a.p1.r.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            boolean z = f7447d;
            n(list);
            o(false);
        }
    }

    public final void e(String str, @NonNull JSONObject jSONObject, @NonNull List<c.a.p0.a.p1.r.c.b> list, @NonNull ArrayMap<String, String> arrayMap, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, str, jSONObject, list, arrayMap, str2) == null) {
            boolean z = f7447d;
            t();
            boolean z2 = false;
            for (c.a.p0.a.p1.r.c.b bVar : list) {
                JSONObject optJSONObject = jSONObject.optJSONObject(bVar.a());
                if (optJSONObject == null) {
                    bVar.b();
                } else if (!TextUtils.equals(optJSONObject.optString("errno"), "0")) {
                    bVar.b();
                } else {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                    if (optJSONObject2 == null) {
                        bVar.c();
                    } else {
                        if (f7447d) {
                            String str3 = "doRequestSuccess: node => " + bVar.a() + " update";
                        }
                        bVar.d(str, optJSONObject2, str2);
                        String optString = optJSONObject.optString("version", "");
                        if (!TextUtils.isEmpty(optString)) {
                            if (f7447d) {
                                String str4 = "doRequestSuccess: " + bVar.a() + " update , version " + optString;
                            }
                            arrayMap.put(bVar.a(), optString);
                            z2 = true;
                        }
                    }
                }
            }
            if (z2) {
                A(list, arrayMap);
            }
            o(true);
        }
    }

    public final void f(@NonNull List<c.a.p0.a.p1.r.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list.size() == 0) {
                d.k("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
                p();
                return;
            }
            if (f7447d) {
                r0 = "doUpdate: start => nodes size " + list.size();
            }
            if (this.f7449b.incrementAndGet() > 1) {
                d.k("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
                return;
            }
            ArrayMap<String, String> i2 = i(this.a);
            JSONObject c2 = c(list, i2);
            if (c2 == null) {
                d.k("SwanAppUpdateManager", "doUpdate: finish => build params is null");
                p();
                return;
            }
            boolean z = f7447d;
            FormBody build = new FormBody.Builder().add("data", c2.toString()).build();
            String b2 = c.a.p0.a.c1.a.o().b();
            d.k("SwanAppUpdateManager", "appId =" + c.a.p0.a.d2.d.J().getAppId() + ", update url = " + b2 + ",body=" + c2);
            j(c.a.p0.a.d2.d.J().getAppId(), b2, build, list, i2);
        }
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (c.a.p0.a.d2.d.J().D()) {
                return c.a.p0.a.d2.d.J().r().d0().n(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
            }
            return System.currentTimeMillis();
        }
        return invokeV.longValue;
    }

    @NonNull
    public final ArrayMap<String, String> i(@NonNull List<c.a.p0.a.p1.r.c.b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            if (list.size() == 0) {
                return arrayMap;
            }
            for (c.a.p0.a.p1.r.c.b bVar : list) {
                arrayMap.put(bVar.a(), "");
            }
            e L = e.L();
            if (L == null) {
                return arrayMap;
            }
            String q = L.d0().q("update_nodes_version", "");
            if (TextUtils.isEmpty(q)) {
                return arrayMap;
            }
            try {
                JSONObject jSONObject = new JSONObject(q);
                for (c.a.p0.a.p1.r.c.b bVar2 : list) {
                    arrayMap.put(bVar2.a(), jSONObject.optString(bVar2.a(), ""));
                }
            } catch (JSONException e2) {
                if (f7447d) {
                    e2.printStackTrace();
                }
            }
            return arrayMap;
        }
        return (ArrayMap) invokeL.objValue;
    }

    public final void j(String str, String str2, RequestBody requestBody, List<c.a.p0.a.p1.r.c.b> list, ArrayMap<String, String> arrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, requestBody, list, arrayMap) == null) {
            c.a.p0.p.d.a aVar = new c.a.p0.p.d.a(str2, requestBody, new C0417a(this, str, list, arrayMap, str2));
            aVar.f10674f = true;
            aVar.f10675g = true;
            aVar.f10676h = false;
            aVar.f10679k = 20;
            c.a.p0.p.e.a.g().e(aVar);
            c.a.p0.a.n2.t.a.a(SwanInterfaceType.UPDATE);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            l();
            this.f7449b = new AtomicInteger(0);
            this.f7450c = new CopyOnWriteArrayList<>();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            arrayList.add(new c.a.p0.a.p1.r.c.a());
            this.a.add(new c());
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            long h2 = h();
            if (h2 <= 0) {
                return true;
            }
            return System.currentTimeMillis() - h2 > r.b(c.a.p0.a.d2.d.J().getAppId());
        }
        return invokeV.booleanValue;
    }

    public final void n(@NonNull List<c.a.p0.a.p1.r.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            for (c.a.p0.a.p1.r.c.b bVar : list) {
                bVar.b();
            }
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            boolean z2 = f7447d;
            if (this.f7449b.decrementAndGet() > 0) {
                boolean z3 = f7447d;
                this.f7449b.set(0);
                if (!z) {
                    update();
                    return;
                } else {
                    p();
                    return;
                }
            }
            p();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            boolean z = f7447d;
            this.f7449b.set(0);
            Iterator<c.a.p0.a.p1.r.b.a> it = this.f7450c.iterator();
            while (it.hasNext()) {
                c.a.p0.a.h2.c.d.l(new b(this, it.next()));
            }
            this.f7450c.clear();
        }
    }

    public void q(@NonNull c.a.p0.a.o2.g.b bVar, @NonNull JSONObject jSONObject) {
        int length;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, bVar, jSONObject) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = f7447d;
            String string = bVar.getString("node_data_accredit_list", "");
            d.k("SwanAppUpdateManager", "prefName: " + bVar.h() + ",cacheData is Empty = " + TextUtils.isEmpty(string) + ":accreditNodeObj=" + jSONObject);
            if (TextUtils.isEmpty(string)) {
                JSONObject jSONObject3 = new JSONObject();
                w.f(jSONObject3, "list", jSONObject);
                String jSONObject4 = jSONObject3.toString();
                bVar.putString("node_data_accredit_list", jSONObject4);
                bVar.putString("cur_request_id", "pkgInfo:" + System.currentTimeMillis());
                if (f7447d) {
                    r0 = "local has no cache data, write directly. pending data = " + jSONObject4;
                }
            } else {
                HashMap<String, JSONObject> r = r(jSONObject);
                if (r != null && r.size() != 0) {
                    JSONObject d2 = w.d(string);
                    JSONObject optJSONObject = d2.optJSONObject("list");
                    if (optJSONObject == null) {
                        w.f(d2, "list", jSONObject);
                        bVar.putString("node_data_accredit_list", d2.toString());
                        bVar.putString("cur_request_id", "pkgInfo:" + System.currentTimeMillis());
                        d.k("SwanAppUpdateManager", "local has cache data, but list node is empty");
                        return;
                    }
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next) && (jSONObject2 = r.get(next)) != null) {
                            w.f(optJSONObject, next, jSONObject2);
                        }
                    }
                    w.f(d2, "list", optJSONObject);
                    bVar.putString("node_data_accredit_list", d2.toString());
                    String string2 = bVar.getString("cur_request_id", "");
                    if (!TextUtils.isEmpty(string2) && (length = string2.length()) > 100) {
                        string2 = string2.substring(length - 100);
                    }
                    bVar.putString("cur_request_id", string2 + ";merge:" + System.currentTimeMillis());
                    d.k("SwanAppUpdateManager", "prefName: " + bVar.h() + ",mergeAccredit = " + d2);
                } else {
                    d.k("SwanAppUpdateManager", "local has cache data, but pending data is empty");
                    return;
                }
            }
            if (f7447d) {
                String str = "parse increment accredit node end, cost = " + (System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final HashMap<String, JSONObject> r(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, jSONObject)) == null) {
            HashMap<String, JSONObject> hashMap = new HashMap<>();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = jSONObject.optJSONObject(next)) != null) {
                    hashMap.put(next, optJSONObject);
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public final void s(String str, Response response, @NonNull List<c.a.p0.a.p1.r.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048592, this, str, response, list, arrayMap) == null) {
            boolean z = f7447d;
            String str2 = null;
            if (!response.isSuccessful()) {
                d(list);
                c.a.p0.a.n2.t.a.c(SwanInterfaceType.UPDATE, 2104, null, response);
                return;
            }
            ResponseBody body = response.body();
            if (body == null) {
                d(list);
                c.a.p0.a.n2.t.a.c(SwanInterfaceType.UPDATE, 2103, null, response);
                return;
            }
            try {
                str2 = body.string();
            } catch (IOException e2) {
                if (f7447d) {
                    e2.printStackTrace();
                }
            }
            d.k("SwanAppUpdateManager", "response body = " + str2);
            if (TextUtils.isEmpty(str2)) {
                d(list);
                c.a.p0.a.n2.t.a.c(SwanInterfaceType.UPDATE, 2103, str2, response);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                    d(list);
                    c.a.p0.a.n2.t.a.c(SwanInterfaceType.UPDATE, jSONObject.optInt("errno", 2103), str2, response);
                    return;
                }
                String optString = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                d.k("SwanAppUpdateManager", "request_id = " + optString);
                if (optJSONObject == null) {
                    d(list);
                } else {
                    e(str, optJSONObject, list, arrayMap, optString);
                }
            } catch (JSONException e3) {
                if (f7447d) {
                    e3.printStackTrace();
                }
                d(list);
                c.a.p0.a.n2.t.a.c(SwanInterfaceType.UPDATE, 2103, str2, response);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && c.a.p0.a.d2.d.J().D()) {
            c.a.p0.a.d2.d.J().r().d0().A(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, System.currentTimeMillis());
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            boolean z = f7447d;
            if (f7448e == null) {
                return;
            }
            this.f7450c.clear();
            f7448e = null;
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            update(null);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (c.a.p0.a.d2.d.J().D()) {
                c.a.p0.a.d2.d.J().r().d0().D(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
            }
            y();
        }
    }

    public void w(c.a.p0.a.p1.r.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            if (bVar == null) {
                boolean z = f7447d;
                return;
            }
            if (f7447d) {
                String str = "resetNodeVersion: " + bVar.a();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bVar);
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            arrayMap.put(bVar.a(), "");
            A(arrayList, arrayMap);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            boolean m = c.a.p0.a.d2.d.J().r().d0().m("swan_service_update_degraded", false);
            d.i("SwanAppUpdateManager", "tryUpdate, isServiceDegraded = " + m);
            if (m) {
                return;
            }
            z(null);
        }
    }

    public void z(@Nullable c.a.p0.a.p1.r.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            if (m()) {
                boolean z = f7447d;
                update(aVar);
                return;
            }
            boolean z2 = f7447d;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void update(@Nullable c.a.p0.a.p1.r.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            if (aVar != null) {
                this.f7450c.add(aVar);
            }
            f(this.a);
        }
    }
}
