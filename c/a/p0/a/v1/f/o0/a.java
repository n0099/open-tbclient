package c.a.p0.a.v1.f.o0;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.p2.d0;
import c.a.p0.a.p2.o0;
import c.a.p0.a.p2.q0;
import c.a.p0.a.x.g.g;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.v1.f.o0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0507a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8036e;

        public RunnableC0507a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8036e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.p0.a.x.g.g V;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (V = c.a.p0.a.w0.f.U().V()) == null) {
                return;
            }
            g.b i2 = V.i(this.f8036e);
            i2.f();
            i2.b();
            c.a.p0.a.u.d.k("ActionUtils", "popAllFragment: finish");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1992784158, "Lc/a/p0/a/v1/f/o0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1992784158, "Lc/a/p0/a/v1/f/o0/a;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
    }

    public static c.a.p0.a.x.u.d a(c.a.p0.a.f.e.b<?> bVar, c.a.p0.a.c1.b bVar2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, bVar, bVar2, str)) == null) {
            c.a.p0.a.t1.n.g f2 = c.a.p0.a.w0.f.U().f(bVar2.f4645h);
            c.a.p0.a.x.u.d dVar = new c.a.p0.a.x.u.d();
            dVar.f8896i = bVar.L();
            dVar.a = bVar2.f4644g;
            if (c.a.p0.a.t1.e.L() != null) {
                dVar.f8890c = c.a.p0.a.t1.e.L().c0(bVar2.f4645h);
            }
            dVar.k = c.a.p0.a.x.u.a.c(c.a.p0.a.t1.e.L(), bVar2.f4642e);
            dVar.f8889b = c.a.p0.a.c1.b.b(bVar2);
            dVar.f8891d = f2.f7554g;
            dVar.f8892e = String.valueOf(c.a.p0.a.u.a.a());
            if (c.a.p0.a.t1.e.L() != null) {
                String W = c.a.p0.a.t1.e.L().W(bVar2.f4645h);
                if (!TextUtils.isEmpty(W)) {
                    if (a) {
                        String str2 = "add initData: " + W;
                    }
                    dVar.f8893f = W;
                }
            }
            dVar.f8894g = a || c.a.p0.a.w0.f.U().N();
            dVar.f8895h = str;
            if (c.a.p0.a.n1.a.a.H()) {
                dVar.f8897j = c.a.p0.a.u.f.b.d();
            }
            if (a) {
                String str3 = "buildPageEvent: " + Arrays.toString(new Exception().getStackTrace());
            }
            c.a.p0.a.h2.f.a.b(dVar.a, dVar.f8889b);
            return dVar;
        }
        return (c.a.p0.a.x.u.d) invokeLLL.objValue;
    }

    public static JSONObject b(@NonNull c.a.p0.a.t1.e eVar, String str, String str2, List<String> list) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, eVar, str, str2, list)) == null) {
            String f2 = o0.f(str);
            String o = o0.o(str);
            String b2 = j.b(f2);
            String b0 = eVar.b0(f2);
            String c0 = eVar.c0(f2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str2);
                jSONObject.put("root", b0);
                jSONObject.put("pageType", c0);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("pageUrl", str);
                }
                if (!TextUtils.equals(f2, b2)) {
                    if (!TextUtils.isEmpty(o)) {
                        b2 = b2 + "?" + o;
                    }
                    jSONObject.put("pageRoutePath", b2);
                }
                if (list != null && !list.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str3 : list) {
                        jSONArray.put(str3);
                    }
                    jSONObject.put("removedSlaveIDs", jSONArray);
                }
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLLL.objValue;
    }

    public static JSONObject c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? d(str, "") : (JSONObject) invokeL.objValue;
    }

    public static JSONObject d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("pageUrl", str2);
                }
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [c.a.p0.a.f.e.c] */
    public static void e(c.a.p0.a.f.e.b<?> bVar, c.a.p0.a.c1.b bVar2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, bVar, bVar2, str) == null) {
            c.a.p0.a.k1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createAndLoadPage start.");
            String a2 = q0.a(bVar2.f4644g, bVar2.f4642e, bVar2.f4643f);
            c.a.p0.a.x.u.d a3 = a(bVar, bVar2, str);
            c.a.p0.a.k1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("slave_dispatch_start"));
            d0.d();
            bVar.t().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, bVar2.f());
            bVar.T(a3.f8889b);
            c.a.p0.a.w0.f.U().m(bVar.c(), c.a.p0.a.x.u.d.a(a3));
            if (c.a.p0.a.x.u.e.b()) {
                c.a.p0.a.x.u.e eVar = new c.a.p0.a.x.u.e();
                eVar.a = bVar.c();
                c.a.p0.a.w0.f.U().u(c.a.p0.a.x.u.e.a(eVar));
            }
            c.a.p0.a.d2.e.F(bVar.c(), a3.f8889b);
            c.a.p0.a.x.t.a.o(a2, bVar);
            c.a.p0.a.k1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createAndLoadPage end.");
        }
    }

    public static void f(String str, String str2, @NonNull String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, str2, str3) == null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("from", str2);
            }
            hashMap.put("url", str3);
            c.a.p0.a.e0.d.c cVar = new c.a.p0.a.e0.d.c(str, hashMap);
            PrefetchEvent.c createFromReLaunch = PrefetchEvent.createFromReLaunch(str2);
            if (createFromReLaunch == null) {
                c.a.p0.a.w0.f.U().u(cVar);
                return;
            }
            c.a.p0.a.x.u.c cVar2 = new c.a.p0.a.x.u.c();
            cVar2.t(createFromReLaunch);
            cVar2.t(cVar);
            c.a.p0.a.w0.f.U().u(cVar2);
        }
    }

    public static List<String> g(c.a.p0.a.x.g.g gVar) {
        InterceptResult invokeL;
        c.a.p0.a.x.g.d j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, gVar)) == null) {
            if (gVar != null && gVar.k() >= c.a.p0.a.k.e.j.c.f6108g && (j2 = gVar.j(0)) != null && (j2 instanceof c.a.p0.a.x.g.f)) {
                return ((c.a.p0.a.x.g.f) j2).o3();
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        c.a.p0.a.f.e.b i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            c.a.p0.a.x.g.f H = c.a.p0.a.w0.f.U().H();
            if (H == null || (i3 = H.i3()) == null) {
                return null;
            }
            return i3.n();
        }
        return (String) invokeV.objValue;
    }

    public static boolean i(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            String h2 = h();
            if (a) {
                String str2 = "lastPageUrl: " + h2 + "\ncurPageUrl: " + str;
            }
            if (h2 != null && str != null) {
                String x1 = c.a.p0.a.v0.e.b.x1(h2);
                String x12 = c.a.p0.a.v0.e.b.x1(str);
                return (TextUtils.equals(x1, x12) || TextUtils.equals(Uri.decode(x1), x12) || TextUtils.equals(x1, Uri.decode(x12))) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void j(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, unitedSchemeEntity, callbackHandler, str) == null) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "No Package").toString(), str);
        }
    }

    public static void k(c.a.p0.a.k.c.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, aVar, str) == null) || aVar == null) {
            return;
        }
        aVar.d(str, new c.a.p0.a.k.h.b(1001, "No Package"));
    }

    public static void l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{unitedSchemeEntity, callbackHandler, eVar, str, str2, list, str3}) == null) || eVar == null || TextUtils.isEmpty(str3)) {
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b(eVar, str2, str, list), 0).toString(), str3);
    }

    public static void m(c.a.p0.a.k.c.a aVar, c.a.p0.a.t1.e eVar, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{aVar, eVar, str, str2, list, str3}) == null) || aVar == null || eVar == null || TextUtils.isEmpty(str3)) {
            return;
        }
        aVar.d(str3, new c.a.p0.a.k.h.b(0, b(eVar, str2, str, list)));
    }

    public static String n(UnitedSchemeEntity unitedSchemeEntity, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, unitedSchemeEntity, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            String str3 = unitedSchemeEntity.getParams().get(str);
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                return new JSONObject(str3).optString(str2);
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String o(UnitedSchemeEntity unitedSchemeEntity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, unitedSchemeEntity, str)) == null) ? n(unitedSchemeEntity, str, "url") : (String) invokeLL.objValue;
    }

    @Nullable
    public static String p(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return jSONObject.optString("url");
        }
        return (String) invokeL.objValue;
    }

    public static void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            c.a.p0.a.u.d.k("ActionUtils", "popAllFragment: routeType=" + str);
            q0.e0(new RunnableC0507a(str));
        }
    }
}
