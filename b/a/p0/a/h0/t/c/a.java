package b.a.p0.a.h0.t.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.e;
import b.a.p0.a.e0.d;
import b.a.p0.a.h0.g.f;
import b.a.p0.a.h0.t.c.b;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
import b.a.p0.a.v2.o0;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5794a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f5795b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2121937454, "Lb/a/p0/a/h0/t/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2121937454, "Lb/a/p0/a/h0/t/c/a;");
                return;
            }
        }
        f5794a = k.f6397a;
        b.a.p0.a.c1.a.Z().getSwitch("swan_next_page_res_load", 0);
        f5795b = false;
        d.h("SwanAppSlaveTopPages", "swan_top_page_res_load - " + f5795b);
        j();
    }

    public static b.a a(@NonNull b.a.p0.a.p.e.b<?> bVar, @NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bVar, pMSAppInfo)) == null) {
            Set<String> k = k(pMSAppInfo);
            if (k != null && k.size() > 0) {
                String str = pMSAppInfo.appId;
                String valueOf = String.valueOf(pMSAppInfo.versionCode);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                    String str2 = e.C0109e.i(str, valueOf).getPath() + File.separator;
                    b bVar2 = new b();
                    for (String str3 : k) {
                        if (g(str2, str3)) {
                            bVar2.a(e(bVar, b.a.p0.a.l1.b.e(o0.g(str3), str2)));
                        }
                    }
                    return bVar2.b();
                }
            }
            return null;
        }
        return (b.a) invokeLL.objValue;
    }

    public static b.a.p0.a.l1.b b() {
        InterceptResult invokeV;
        SwanAppActivity x;
        f H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P == null || (x = P.x()) == null || x.isFinishing() || x.isDestroyed() || (H = b.a.p0.a.g1.f.T().H()) == null) {
                return null;
            }
            return H.T2();
        }
        return (b.a.p0.a.l1.b) invokeV.objValue;
    }

    public static void c(@NonNull PMSAppInfo pMSAppInfo, @Nullable b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, pMSAppInfo, aVar) == null) {
        }
    }

    public static b.a d(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pMSAppInfo)) == null) {
            return null;
        }
        return (b.a) invokeL.objValue;
    }

    public static b.a.p0.a.o0.d.b e(b.a.p0.a.p.e.b<?> bVar, b.a.p0.a.l1.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, bVar, bVar2)) == null) ? b.a.p0.a.h0.u.d.a(b.a.p0.a.c2.f.p0.a.a(bVar, bVar2, "")) : (b.a.p0.a.o0.d.b) invokeLL.objValue;
    }

    public static JSONObject f(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, pMSAppInfo)) == null) ? b.a.p0.a.l1.d.d.f().i(pMSAppInfo) : (JSONObject) invokeL.objValue;
    }

    public static boolean g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) ? e.C(str, str2) : invokeLL.booleanValue;
    }

    public static void h(b.a.p0.a.p.e.b<?> bVar) {
        PMSAppInfo e0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, bVar) == null) && f5795b && bVar != null) {
            long currentTimeMillis = f5794a ? System.currentTimeMillis() : 0L;
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P == null || (e0 = P.K().e0()) == null) {
                return;
            }
            b.a d2 = d(e0);
            if (d2 == null) {
                d2 = a(bVar, e0);
                c(e0, d2);
            }
            if (d2 != null) {
                g.M().H0(bVar.b(), d2);
            }
            if (f5794a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "sendTopPageMsg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
        }
    }

    public static Set<String> i(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONObject)) == null) {
            if (jSONObject.length() <= 0) {
                return null;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    linkedHashSet.add(next);
                }
            }
            if (f5794a) {
                String str = "get top pages - " + linkedHashSet;
            }
            return linkedHashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
        }
    }

    public static Set<String> k(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, pMSAppInfo)) == null) {
            if (f5794a) {
                String str = "current page - " + b();
            }
            JSONObject f2 = f(pMSAppInfo);
            if (f2 == null || f2.length() <= 0) {
                return null;
            }
            if (f5794a) {
                String str2 = "pages info - " + f2;
            }
            return i(f2);
        }
        return (Set) invokeL.objValue;
    }
}
