package b.a.p0.a.f2.f.o0;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.z2.d0;
import b.a.p0.a.z2.o0;
import b.a.p0.a.z2.q0;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5075a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.f2.f.o0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0184a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5076e;

        public RunnableC0184a(String str) {
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
            this.f5076e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.p0.a.h0.g.g V;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (V = b.a.p0.a.g1.f.U().V()) == null) {
                return;
            }
            g.b i2 = V.i(this.f5076e);
            i2.f();
            i2.b();
            b.a.p0.a.e0.d.k("ActionUtils", "popAllFragment: finish");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(188449330, "Lb/a/p0/a/f2/f/o0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(188449330, "Lb/a/p0/a/f2/f/o0/a;");
                return;
            }
        }
        f5075a = b.a.p0.a.k.f6863a;
    }

    public static b.a.p0.a.h0.u.d a(b.a.p0.a.p.e.b<?> bVar, b.a.p0.a.m1.b bVar2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, bVar, bVar2, str)) == null) {
            b.a.p0.a.d2.n.g e2 = b.a.p0.a.g1.f.U().e(bVar2.f7017h);
            b.a.p0.a.h0.u.d dVar = new b.a.p0.a.h0.u.d();
            dVar.f6154i = bVar.L();
            dVar.f6146a = bVar2.f7016g;
            if (b.a.p0.a.d2.e.L() != null) {
                dVar.f6148c = b.a.p0.a.d2.e.L().c0(bVar2.f7017h);
            }
            dVar.k = b.a.p0.a.h0.u.a.c(b.a.p0.a.d2.e.L(), bVar2.f7014e);
            dVar.f6147b = b.a.p0.a.m1.b.b(bVar2);
            dVar.f6149d = e2.f4523g;
            dVar.f6150e = String.valueOf(b.a.p0.a.e0.a.a());
            if (b.a.p0.a.d2.e.L() != null) {
                String W = b.a.p0.a.d2.e.L().W(bVar2.f7017h);
                if (!TextUtils.isEmpty(W)) {
                    if (f5075a) {
                        String str2 = "add initData: " + W;
                    }
                    dVar.f6151f = W;
                }
            }
            dVar.f6152g = f5075a || b.a.p0.a.g1.f.U().N();
            dVar.f6153h = str;
            if (b.a.p0.a.x1.a.a.H()) {
                dVar.j = b.a.p0.a.e0.f.b.d();
            }
            if (f5075a) {
                String str3 = "buildPageEvent: " + Arrays.toString(new Exception().getStackTrace());
            }
            b.a.p0.a.r2.f.a.b(dVar.f6146a, dVar.f6147b);
            return dVar;
        }
        return (b.a.p0.a.h0.u.d) invokeLLL.objValue;
    }

    public static JSONObject b(@NonNull b.a.p0.a.d2.e eVar, String str, String str2, List<String> list) {
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
                if (f5075a) {
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
                if (f5075a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [b.a.p0.a.p.e.c] */
    public static void e(b.a.p0.a.p.e.b<?> bVar, b.a.p0.a.m1.b bVar2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, bVar, bVar2, str) == null) {
            b.a.p0.a.u1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createAndLoadPage start.");
            String a2 = q0.a(bVar2.f7016g, bVar2.f7014e, bVar2.f7015f);
            b.a.p0.a.h0.u.d a3 = a(bVar, bVar2, str);
            b.a.p0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("slave_dispatch_start"));
            d0.d();
            bVar.t().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, bVar2.f());
            bVar.T(a3.f6147b);
            b.a.p0.a.g1.f.U().l(bVar.c(), b.a.p0.a.h0.u.d.a(a3));
            if (b.a.p0.a.h0.u.e.b()) {
                b.a.p0.a.h0.u.e eVar = new b.a.p0.a.h0.u.e();
                eVar.f6157a = bVar.c();
                b.a.p0.a.g1.f.U().u(b.a.p0.a.h0.u.e.a(eVar));
            }
            b.a.p0.a.n2.e.F(bVar.c(), a3.f6147b);
            b.a.p0.a.h0.t.a.o(a2, bVar);
            b.a.p0.a.u1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createAndLoadPage end.");
        }
    }

    public static void f(String str, String str2, @NonNull String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, str3) == null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("from", str2);
            }
            hashMap.put("url", str3);
            b.a.p0.a.o0.d.c cVar = new b.a.p0.a.o0.d.c(str, hashMap);
            PrefetchEvent.c createFromReLaunch = PrefetchEvent.createFromReLaunch(str2);
            if (createFromReLaunch == null) {
                b.a.p0.a.g1.f.U().u(cVar);
                return;
            }
            b.a.p0.a.h0.u.c cVar2 = new b.a.p0.a.h0.u.c();
            cVar2.t(createFromReLaunch);
            cVar2.t(cVar);
            b.a.p0.a.g1.f.U().u(cVar2);
        }
    }

    public static List<String> g(b.a.p0.a.h0.g.g gVar) {
        InterceptResult invokeL;
        b.a.p0.a.h0.g.d j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, gVar)) == null) {
            if (gVar != null && gVar.k() >= b.a.p0.a.u.e.j.c.f8745g && (j = gVar.j(0)) != null && (j instanceof b.a.p0.a.h0.g.f)) {
                return ((b.a.p0.a.h0.g.f) j).r3();
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        b.a.p0.a.p.e.b l3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            b.a.p0.a.h0.g.f H = b.a.p0.a.g1.f.U().H();
            if (H == null || (l3 = H.l3()) == null) {
                return null;
            }
            return l3.n();
        }
        return (String) invokeV.objValue;
    }

    public static boolean i(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            String h2 = h();
            if (f5075a) {
                String str2 = "lastPageUrl: " + h2 + "\ncurPageUrl: " + str;
            }
            if (h2 != null && str != null) {
                String x1 = b.a.p0.a.f1.e.b.x1(h2);
                String x12 = b.a.p0.a.f1.e.b.x1(str);
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

    public static void k(b.a.p0.a.u.c.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, aVar, str) == null) || aVar == null) {
            return;
        }
        aVar.d(str, new b.a.p0.a.u.h.b(1001, "No Package"));
    }

    public static void l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{unitedSchemeEntity, callbackHandler, eVar, str, str2, list, str3}) == null) || eVar == null || TextUtils.isEmpty(str3)) {
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b(eVar, str2, str, list), 0).toString(), str3);
    }

    public static void m(b.a.p0.a.u.c.a aVar, b.a.p0.a.d2.e eVar, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{aVar, eVar, str, str2, list, str3}) == null) || aVar == null || eVar == null || TextUtils.isEmpty(str3)) {
            return;
        }
        aVar.d(str3, new b.a.p0.a.u.h.b(0, b(eVar, str2, str, list)));
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
                if (f5075a) {
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
            b.a.p0.a.e0.d.k("ActionUtils", "popAllFragment: routeType=" + str);
            q0.e0(new RunnableC0184a(str));
        }
    }
}
