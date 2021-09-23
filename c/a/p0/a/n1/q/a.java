package c.a.p0.a.n1.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a2.e;
import c.a.p0.a.e0.d;
import c.a.p0.a.j2.k;
import c.a.p0.a.n1.q.c.c;
import c.a.p0.a.v2.w;
import c.a.p0.n.j.i.o;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.mobads.container.util.AdIconUtil;
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
    public static final boolean f7631d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f7632e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<c.a.p0.a.n1.q.c.b> f7633a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f7634b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<c.a.p0.a.n1.q.b.a> f7635c;

    /* renamed from: c.a.p0.a.n1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0317a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7636a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f7637b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ArrayMap f7638c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f7639d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7640e;

        public C0317a(a aVar, String str, List list, ArrayMap arrayMap, String str2) {
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
            this.f7640e = aVar;
            this.f7636a = str;
            this.f7637b = list;
            this.f7638c = arrayMap;
            this.f7639d = str2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.f7640e.d(this.f7637b);
                d.i("SwanAppUpdateManager", "update request failure: ", exc);
                k.w(this.f7639d, -1, exc.toString());
                c.a.p0.a.j2.q.a.b(SwanInterfaceType.UPDATE, 2101, this.f7639d, null, exc.getMessage());
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
                String appId = c.a.p0.a.a2.d.g().getAppId();
                if (TextUtils.equals(this.f7636a, appId)) {
                    this.f7640e.s(this.f7636a, response, this.f7637b, this.f7638c);
                    d.h("SwanAppUpdateManager", "response code = " + response.code());
                    if (!response.isSuccessful()) {
                        k.w(this.f7639d, response.code(), response.message());
                    }
                    return response;
                }
                d.h("SwanAppUpdateManager", "invalid response requestAppId:" + this.f7636a + ";currentAppId:" + appId);
                this.f7640e.d(this.f7637b);
                a.x(this.f7636a);
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
        public final /* synthetic */ c.a.p0.a.n1.q.b.a f7641e;

        public b(a aVar, c.a.p0.a.n1.q.b.a aVar2) {
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
            this.f7641e = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7641e.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2145850509, "Lc/a/p0/a/n1/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2145850509, "Lc/a/p0/a/n1/q/a;");
                return;
            }
        }
        f7631d = c.a.p0.a.k.f7085a;
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
            if (f7632e == null) {
                synchronized (a.class) {
                    if (f7632e == null) {
                        f7632e = new a();
                    }
                }
            }
            return f7632e;
        }
        return (a) invokeV.objValue;
    }

    public static void x(String str) {
        e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) || (Q = e.Q()) == null) {
            return;
        }
        c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
        aVar.j(5L);
        aVar.h(53L);
        c.a.p0.a.j2.p.d dVar = new c.a.p0.a.j2.p.d();
        dVar.p(aVar);
        dVar.r(Q.L());
        dVar.q(k.m(Q.l()));
        dVar.m(Q.getAppId());
        dVar.a("requestAppId", str);
        k.L(dVar);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            B(null);
        }
    }

    public void B(@Nullable c.a.p0.a.n1.q.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (aVar != null) {
                this.f7635c.add(aVar);
            }
            f(this.f7633a);
        }
    }

    public final void C(@NonNull List<c.a.p0.a.n1.q.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        e i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, arrayMap) == null) || list.size() == 0 || (i2 = e.i()) == null) {
            return;
        }
        String q = i2.T().q("update_nodes_version", "");
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(q)) {
            try {
                jSONObject = new JSONObject(q);
            } catch (JSONException e2) {
                if (f7631d) {
                    e2.printStackTrace();
                }
            }
        }
        for (c.a.p0.a.n1.q.c.b bVar : list) {
            String str = arrayMap.get(bVar.a());
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            try {
                if (f7631d) {
                    String str2 = "updateNodeVersions: update node => " + bVar.a() + " , version => " + str;
                }
                jSONObject.put(bVar.a(), str);
            } catch (JSONException e3) {
                if (f7631d) {
                    e3.printStackTrace();
                }
            }
        }
        i2.T().B("update_nodes_version", jSONObject.toString());
    }

    @Nullable
    public final JSONObject c(@NonNull List<c.a.p0.a.n1.q.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, list, arrayMap)) == null) {
            if (list.size() == 0) {
                return null;
            }
            String D = c.a.p0.a.a2.d.g().r().D();
            if (TextUtils.isEmpty(D)) {
                return null;
            }
            String T = e.i().N().T();
            if (TextUtils.isEmpty(T)) {
                T = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", D);
                jSONObject.put("source", T);
            } catch (JSONException e2) {
                if (f7631d) {
                    e2.printStackTrace();
                }
            }
            for (c.a.p0.a.n1.q.c.b bVar : list) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    String str = arrayMap.containsKey(bVar.a()) ? arrayMap.get(bVar.a()) : "";
                    if (f7631d) {
                        String str2 = "buildRequestParams: node => " + bVar.a() + " , version => " + str;
                    }
                    jSONObject2.put("version", str);
                    jSONObject.put(bVar.a(), jSONObject2);
                } catch (JSONException e3) {
                    if (f7631d) {
                        e3.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final void d(@NonNull List<c.a.p0.a.n1.q.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            boolean z = f7631d;
            n(list);
            o(false);
        }
    }

    public final void e(String str, @NonNull JSONObject jSONObject, @NonNull List<c.a.p0.a.n1.q.c.b> list, @NonNull ArrayMap<String, String> arrayMap, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, str, jSONObject, list, arrayMap, str2) == null) {
            boolean z = f7631d;
            t();
            boolean z2 = false;
            for (c.a.p0.a.n1.q.c.b bVar : list) {
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
                        if (f7631d) {
                            String str3 = "doRequestSuccess: node => " + bVar.a() + " update";
                        }
                        bVar.d(str, optJSONObject2, str2);
                        String optString = optJSONObject.optString("version", "");
                        if (!TextUtils.isEmpty(optString)) {
                            if (f7631d) {
                                String str4 = "doRequestSuccess: " + bVar.a() + " update , version " + optString;
                            }
                            arrayMap.put(bVar.a(), optString);
                            z2 = true;
                        }
                    }
                }
            }
            if (z2) {
                C(list, arrayMap);
            }
            o(true);
        }
    }

    public final void f(@NonNull List<c.a.p0.a.n1.q.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (list.size() == 0) {
                d.h("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
                p();
                return;
            }
            if (f7631d) {
                r0 = "doUpdate: start => nodes size " + list.size();
            }
            if (this.f7634b.incrementAndGet() > 1) {
                d.h("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
                return;
            }
            ArrayMap<String, String> i2 = i(this.f7633a);
            JSONObject c2 = c(list, i2);
            if (c2 == null) {
                d.h("SwanAppUpdateManager", "doUpdate: finish => build params is null");
                p();
                return;
            }
            boolean z = f7631d;
            FormBody build = new FormBody.Builder().add("data", c2.toString()).build();
            String b2 = c.a.p0.a.c1.a.n().b();
            d.h("SwanAppUpdateManager", "appId =" + c.a.p0.a.a2.d.g().getAppId() + ", update url = " + b2 + ",body=" + c2);
            j(c.a.p0.a.a2.d.g().getAppId(), b2, build, list, i2);
        }
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (c.a.p0.a.a2.d.g().C()) {
                return c.a.p0.a.a2.d.g().r().T().n(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
            }
            return System.currentTimeMillis();
        }
        return invokeV.longValue;
    }

    @NonNull
    public final ArrayMap<String, String> i(@NonNull List<c.a.p0.a.n1.q.c.b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list)) == null) {
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            if (list.size() == 0) {
                return arrayMap;
            }
            for (c.a.p0.a.n1.q.c.b bVar : list) {
                arrayMap.put(bVar.a(), "");
            }
            e i2 = e.i();
            if (i2 == null) {
                return arrayMap;
            }
            String q = i2.T().q("update_nodes_version", "");
            if (TextUtils.isEmpty(q)) {
                return arrayMap;
            }
            try {
                JSONObject jSONObject = new JSONObject(q);
                for (c.a.p0.a.n1.q.c.b bVar2 : list) {
                    arrayMap.put(bVar2.a(), jSONObject.optString(bVar2.a(), ""));
                }
            } catch (JSONException e2) {
                if (f7631d) {
                    e2.printStackTrace();
                }
            }
            return arrayMap;
        }
        return (ArrayMap) invokeL.objValue;
    }

    public final void j(String str, String str2, RequestBody requestBody, List<c.a.p0.a.n1.q.c.b> list, ArrayMap<String, String> arrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048585, this, str, str2, requestBody, list, arrayMap) == null) {
            c.a.p0.m.d.a aVar = new c.a.p0.m.d.a(str2, requestBody, new C0317a(this, str, list, arrayMap, str2));
            aVar.f11853f = true;
            aVar.f11854g = true;
            aVar.f11855h = false;
            aVar.k = 20;
            c.a.p0.m.e.a.g().e(aVar);
            c.a.p0.a.j2.q.a.a(SwanInterfaceType.UPDATE);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            l();
            this.f7634b = new AtomicInteger(0);
            this.f7635c = new CopyOnWriteArrayList<>();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f7633a = arrayList;
            arrayList.add(new c.a.p0.a.n1.q.c.a());
            this.f7633a.add(new c());
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            long h2 = h();
            if (h2 <= 0) {
                return true;
            }
            return System.currentTimeMillis() - h2 > o.b(c.a.p0.a.a2.d.g().getAppId());
        }
        return invokeV.booleanValue;
    }

    public final void n(@NonNull List<c.a.p0.a.n1.q.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            for (c.a.p0.a.n1.q.c.b bVar : list) {
                bVar.b();
            }
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            boolean z2 = f7631d;
            if (this.f7634b.decrementAndGet() > 0) {
                boolean z3 = f7631d;
                this.f7634b.set(0);
                if (!z) {
                    A();
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
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            boolean z = f7631d;
            this.f7634b.set(0);
            Iterator<c.a.p0.a.n1.q.b.a> it = this.f7635c.iterator();
            while (it.hasNext()) {
                c.a.p0.a.e2.c.d.k(new b(this, it.next()));
            }
            this.f7635c.clear();
        }
    }

    public void q(@NonNull c.a.p0.a.k2.g.b bVar, @NonNull JSONObject jSONObject) {
        int length;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, bVar, jSONObject) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = f7631d;
            String string = bVar.getString("node_data_accredit_list", "");
            d.h("SwanAppUpdateManager", "prefName: " + bVar.i() + ",cacheData is Empty = " + TextUtils.isEmpty(string) + ":accreditNodeObj=" + jSONObject);
            if (TextUtils.isEmpty(string)) {
                JSONObject jSONObject3 = new JSONObject();
                w.f(jSONObject3, "list", jSONObject);
                String jSONObject4 = jSONObject3.toString();
                bVar.putString("node_data_accredit_list", jSONObject4);
                bVar.putString("cur_request_id", "pkgInfo:" + System.currentTimeMillis());
                if (f7631d) {
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
                        d.h("SwanAppUpdateManager", "local has cache data, but list node is empty");
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
                    d.h("SwanAppUpdateManager", "prefName: " + bVar.i() + ",mergeAccredit = " + d2);
                } else {
                    d.h("SwanAppUpdateManager", "local has cache data, but pending data is empty");
                    return;
                }
            }
            if (f7631d) {
                String str = "parse increment accredit node end, cost = " + (System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final HashMap<String, JSONObject> r(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, jSONObject)) == null) {
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

    public final void s(String str, Response response, @NonNull List<c.a.p0.a.n1.q.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048594, this, str, response, list, arrayMap) == null) {
            boolean z = f7631d;
            String str2 = null;
            if (!response.isSuccessful()) {
                d(list);
                c.a.p0.a.j2.q.a.c(SwanInterfaceType.UPDATE, 2104, null, response);
                return;
            }
            ResponseBody body = response.body();
            if (body == null) {
                d(list);
                c.a.p0.a.j2.q.a.c(SwanInterfaceType.UPDATE, 2103, null, response);
                return;
            }
            try {
                str2 = body.string();
            } catch (IOException e2) {
                if (f7631d) {
                    e2.printStackTrace();
                }
            }
            d.h("SwanAppUpdateManager", "response body = " + str2);
            if (TextUtils.isEmpty(str2)) {
                d(list);
                c.a.p0.a.j2.q.a.c(SwanInterfaceType.UPDATE, 2103, str2, response);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                    d(list);
                    c.a.p0.a.j2.q.a.c(SwanInterfaceType.UPDATE, jSONObject.optInt("errno", 2103), str2, response);
                    return;
                }
                String optString = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                d.h("SwanAppUpdateManager", "request_id = " + optString);
                if (optJSONObject == null) {
                    d(list);
                } else {
                    e(str, optJSONObject, list, arrayMap, optString);
                }
            } catch (JSONException e3) {
                if (f7631d) {
                    e3.printStackTrace();
                }
                d(list);
                c.a.p0.a.j2.q.a.c(SwanInterfaceType.UPDATE, 2103, str2, response);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && c.a.p0.a.a2.d.g().C()) {
            c.a.p0.a.a2.d.g().r().T().A(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, System.currentTimeMillis());
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            boolean z = f7631d;
            if (f7632e == null) {
                return;
            }
            this.f7635c.clear();
            f7632e = null;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (c.a.p0.a.a2.d.g().C()) {
                c.a.p0.a.a2.d.g().r().T().D(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
            }
            y();
        }
    }

    public void w(c.a.p0.a.n1.q.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            if (bVar == null) {
                boolean z = f7631d;
                return;
            }
            if (f7631d) {
                String str = "resetNodeVersion: " + bVar.a();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bVar);
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            arrayMap.put(bVar.a(), "");
            C(arrayList, arrayMap);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            boolean m = c.a.p0.a.a2.d.g().r().T().m("swan_service_update_degraded", false);
            d.g("SwanAppUpdateManager", "tryUpdate, isServiceDegraded = " + m);
            if (m) {
                return;
            }
            z(null);
        }
    }

    public void z(@Nullable c.a.p0.a.n1.q.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            if (m()) {
                boolean z = f7631d;
                B(aVar);
                return;
            }
            boolean z2 = f7631d;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
