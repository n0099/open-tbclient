package c.a.r0.a.w0;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.f1.e.b;
import c.a.r0.a.k;
import c.a.r0.a.n0.l.b;
import c.a.r0.a.o2.g.h;
import c.a.r0.a.z2.o0;
import c.a.r0.a.z2.q;
import c.a.r0.a.z2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements c.a.r0.a.m.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f9644e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements c.a.r0.a.w0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.f1.e.b a;

        public a(c.a.r0.a.f1.e.b bVar) {
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
            this.a = bVar;
        }

        @Override // c.a.r0.a.w0.b
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                c.a.r0.a.j0.c.b.u(AppRuntime.getAppContext().getContentResolver(), this.a.H(), 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.w0.b a;

        public b(c.a.r0.a.w0.b bVar) {
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
            this.a = bVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            c.a.r0.a.w0.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, exc) == null) || (bVar = this.a) == null) {
                return;
            }
            bVar.onResult(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i2) {
            c.a.r0.a.w0.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i2) == null) || (bVar = this.a) == null) {
                return;
            }
            if (jSONObject != null) {
                if (d.f9644e) {
                    String str = "上报数据 onSuccess: response=" + jSONObject;
                }
                if (jSONObject.optInt("errno", -1) == 0) {
                    this.a.onResult(true);
                    return;
                } else {
                    this.a.onResult(false);
                    return;
                }
            }
            bVar.onResult(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i2)) == null) {
                if (response == null || response.body() == null) {
                    return null;
                }
                return w.d(response.body().string());
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.h(true);
            }
        }
    }

    /* renamed from: c.a.r0.a.w0.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0615d implements c.a.r0.a.w0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0615d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.a.w0.a
        public void a(List<c.a.r0.a.w0.c> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
                return;
            }
            c.a.r0.a.j0.c.b.f();
            c.a.r0.a.j0.c.b.l(list);
        }
    }

    /* loaded from: classes.dex */
    public static class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.w0.a a;

        public e(c.a.r0.a.w0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            c.a.r0.a.w0.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, exc) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.a(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i2) {
            c.a.r0.a.w0.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i2) == null) || (aVar = this.a) == null) {
                return;
            }
            if (jSONObject != null) {
                if (d.f9644e) {
                    String str = "下拉数据 onSuccess: response=" + jSONObject;
                }
                if (jSONObject.optInt("errno", -1) != 0) {
                    this.a.a(null);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    this.a.a(null);
                    return;
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                if (optJSONArray == null) {
                    this.a.a(null);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    c.a.r0.a.w0.c b2 = c.a.r0.a.w0.c.b(optJSONArray.optJSONObject(i3));
                    if (b2 != null) {
                        arrayList.add(b2);
                    }
                }
                h.a().putString("fetch_history_data_last_id", optJSONObject.optString(ImageViewerConfig.LAST_ID));
                this.a.a(arrayList);
                return;
            }
            aVar.a(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i2)) == null) {
                if (response == null || response.body() == null) {
                    return null;
                }
                return w.d(response.body().string());
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public static final d a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1772587634, "Lc/a/r0/a/w0/d$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1772587634, "Lc/a/r0/a/w0/d$f;");
                    return;
                }
            }
            a = new d(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(439832884, "Lc/a/r0/a/w0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(439832884, "Lc/a/r0/a/w0/d;");
                return;
            }
        }
        f9644e = k.a;
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    @WorkerThread
    public static void c(c.a.r0.a.d2.e eVar, b.C0480b c0480b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, eVar, c0480b) == null) || eVar == null) {
            return;
        }
        b.a V = eVar.V();
        if (TextUtils.equals("1", V.c0())) {
            c.a.r0.a.e0.d.b("SwanHistoryManager", "add history with 'notinhis=1': " + V.H() + "/" + V.K());
            return;
        }
        c.a.r0.a.e0.d.b("SwanHistoryManager", "add history: " + V.H() + "/" + V.K());
        c.a.r0.a.w0.c a2 = c.a.r0.a.w0.c.a(V);
        boolean c2 = c.a.r0.a.j0.c.b.c(AppRuntime.getAppContext().getContentResolver(), a2, c0480b);
        a aVar = new a(V);
        if (c2) {
            j("ADD", a2.a, a2.f9638e, a2.f9635b, a2.f9640g, a2.f9643j, aVar);
        }
        boolean z = f9644e;
    }

    public static String d(String str, List<c.a.r0.a.w0.c> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                for (c.a.r0.a.w0.c cVar : list) {
                    if (cVar != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("cmd", str);
                        jSONObject2.put("bundle_id", cVar.a);
                        jSONObject2.put("time", cVar.f9638e);
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("items", jSONArray);
            } catch (JSONException e2) {
                if (f9644e) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String e(String str, String str2, long j2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, str2, Long.valueOf(j2), str3, str4, str5})) == null) {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("cmd", str);
                if (TextUtils.isEmpty(str3)) {
                    jSONObject2.put("bundle_id", str2);
                } else {
                    jSONObject2.put("appkey", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("pkg_type", Integer.parseInt(str4));
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("version_code", Integer.parseInt(str5));
                }
                jSONObject2.put("time", j2);
                jSONArray.put(jSONObject2);
                jSONObject.put("items", jSONArray);
            } catch (JSONException e2) {
                if (f9644e) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            q.k(new c(), "fetchHistoryDataFromServer");
        }
    }

    public static void g(String str, List<c.a.r0.a.w0.c> list, c.a.r0.a.w0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, list, aVar) == null) {
            String p = c.a.r0.a.c1.a.o().p();
            HashMap hashMap = new HashMap();
            hashMap.put(ImageViewerConfig.LAST_ID, h.a().getString("fetch_history_data_last_id", ""));
            String b2 = o0.b(p, hashMap);
            String d2 = d(str, list);
            if (f9644e) {
                String str2 = "fetchHistoryDataFromServer: url=" + b2 + "  params=" + d2;
            }
            e eVar = new e(aVar);
            c.a.r0.p.d.a aVar2 = new c.a.r0.p.d.a();
            aVar2.f11591b = "POST";
            aVar2.a = b2;
            aVar2.f11595f = true;
            aVar2.f11596g = true;
            if (!TextUtils.isEmpty(d2)) {
                aVar2.f11593d = RequestBody.create(c.a.r0.a.p1.f.a, d2);
            }
            aVar2.f11594e = eVar;
            c.a.r0.p.e.a.g().e(aVar2);
        }
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            List<c.a.r0.a.w0.c> r = c.a.r0.a.j0.c.b.r();
            if (z || (r != null && r.size() > 0)) {
                g("ADD", r, new C0615d());
            }
        }
    }

    public static d i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f.a : (d) invokeV.objValue;
    }

    public static void j(String str, String str2, long j2, String str3, String str4, String str5, c.a.r0.a.w0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{str, str2, Long.valueOf(j2), str3, str4, str5, bVar}) == null) {
            String c2 = c.a.r0.a.c1.a.o().c();
            String e2 = e(str, str2, j2, str3, str4, str5);
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            if (f9644e) {
                String str6 = "reportHistoryDataToServer: 上行参数" + e2;
            }
            b bVar2 = new b(bVar);
            c.a.r0.p.d.a aVar = new c.a.r0.p.d.a();
            aVar.f11591b = "POST";
            aVar.a = c2;
            aVar.f11595f = true;
            aVar.f11596g = true;
            aVar.f11593d = RequestBody.create(c.a.r0.a.p1.f.a, e2);
            aVar.f11594e = bVar2;
            c.a.r0.p.e.a.g().e(aVar);
        }
    }

    @Override // c.a.r0.a.m.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            f();
        }
    }

    public d() {
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
        c.a.r0.a.c1.a.h0().c(this);
    }
}
