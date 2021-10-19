package c.a.p0.a.t1.g;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a2.e;
import c.a.p0.a.a2.n.d;
import c.a.p0.a.g1.f;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.k;
import c.a.p0.a.v2.w;
import c.a.p0.n.h.h;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f8720a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1119359876, "Lc/a/p0/a/t1/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1119359876, "Lc/a/p0/a/t1/g/b;");
                return;
            }
        }
        f8720a = k.f7085a;
    }

    public static void a(Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, map, str) == null) || map == null) {
            return;
        }
        String b2 = b(map, "dynamicLibPath", 3);
        String b3 = b(map, "dynamicLibConfig", 3);
        String b4 = b(map, "pluginPath", 4);
        if (TextUtils.isEmpty(str) || !f8720a) {
            return;
        }
        c.a.p0.a.t1.d.a.a(str + ", dynamicLibPath = " + b2 + "; dynamicLibConfig = " + b3 + "; pluginPath = " + b4);
    }

    public static String b(Map<String, String> map, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, map, str, i2)) == null) {
            if (map == null || TextUtils.isEmpty(str)) {
                return null;
            }
            e i3 = e.i();
            String e2 = i3 != null ? i3.J().e(str, null) : null;
            if (!TextUtils.isEmpty(e2)) {
                map.put(str, e2);
                return e2;
            }
            SwanAppConfigData F = i3 != null ? i3.F() : null;
            if (i2 == 3) {
                c.a.p0.a.t1.b.a.f(F, false);
                e2 = i(str, null);
            } else if (i2 == 4) {
                e2 = l(F);
            }
            map.put(str, e2);
            return e2;
        }
        return (String) invokeLLI.objValue;
    }

    public static void c(String str, String str2) {
        e i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || TextUtils.isEmpty(str) || (i2 = e.i()) == null) {
            return;
        }
        i2.J().j(str, str2);
    }

    public static String d(List<c.a.p0.a.t1.f.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            int size = list.size();
            StringBuilder sb = new StringBuilder();
            sb.append("select * from (SELECT * from ");
            sb.append("swan_plugin");
            sb.append(" ORDER BY update_time) group by bundle_id having bundle_id in ");
            sb.append("(");
            for (int i2 = 0; i2 < size; i2++) {
                sb.append("'");
                sb.append(list.get(i2).f8716h);
                sb.append("'");
                if (i2 == size - 1) {
                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    sb.append(",");
                }
            }
            sb.append(";");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            SwanAppConfigData b2 = d.b(str);
            if (b2 == null) {
                c.a.p0.a.t1.d.a.a("getDownloadKey, app.json is null");
                return null;
            }
            SwanAppConfigData.k kVar = b2.f46570d;
            if (kVar == null) {
                c.a.p0.a.t1.d.a.a("getDownloadKey, sub pkg obj is null");
                return null;
            }
            Map<String, String> map = kVar.f46609a;
            if (map == null) {
                c.a.p0.a.t1.d.a.a("getDownloadKey, sub pkg map is null");
                return null;
            }
            return map.get(str2);
        }
        return (String) invokeLL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            h g2 = g(str);
            if ((g2 == null || TextUtils.isEmpty(g2.r)) ? false : true) {
                return g2.r;
            }
            c.a.p0.a.t1.d.a.a("get plugin appKey form db, but empty, plugin appId = " + str);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static h g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return c.a.p0.a.t1.b.a.i(str, "0.0.0", 0L);
        }
        return (h) invokeL.objValue;
    }

    public static h h(String str) {
        InterceptResult invokeL;
        SwanAppConfigData F;
        List<h> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!c.a.p0.a.e0.f.e.e.d() && !c.a.p0.a.u1.a.a.G() && !c.a.p0.a.u1.a.a.C()) {
                return g(str);
            }
            e i2 = e.i();
            if (i2 != null && (F = i2.F()) != null && (list = F.k) != null) {
                for (h hVar : list) {
                    if (TextUtils.equals(str, hVar.f11893g)) {
                        return hVar;
                    }
                }
            }
            return null;
        }
        return (h) invokeL.objValue;
    }

    public static String i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            e i2 = e.i();
            if (i2 == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return i2.J().e(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public static void j() {
        g W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, null) == null) && (W = f.V().W()) != null && (W.m() instanceof c.a.p0.a.h0.g.h)) {
            f.V().getActivity().onBackPressed();
        }
    }

    public static List<h> k(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                if (length == 0) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("plugin_id");
                        if (!TextUtils.isEmpty(optString)) {
                            h hVar = new h();
                            hVar.f11893g = optString;
                            hVar.f11895i = optJSONObject.optLong("version_code", 0L);
                            hVar.f11896j = optJSONObject.optString("version_name", "0.0.0");
                            hVar.p = optJSONObject.optString("token");
                            hVar.q = optJSONObject.optString("domains");
                            hVar.f11894h = 4;
                            hVar.r = optJSONObject.optString("app_key");
                            hVar.s = optJSONObject.optString("app_name");
                            hVar.l = "";
                            hVar.m = "";
                            hVar.n = "";
                            arrayList.add(hVar);
                            if (z) {
                                c.a.p0.n.g.a.h().l(hVar);
                            }
                        }
                    }
                }
                return arrayList;
            } catch (JSONException e2) {
                c.a.p0.a.t1.d.a.a(Log.getStackTraceString(e2));
                return null;
            }
        }
        return (List) invokeLZ.objValue;
    }

    public static String l(SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, swanAppConfigData)) == null) {
            if (swanAppConfigData == null) {
                c.a.p0.a.t1.d.a.a("parse app.json is null");
                return null;
            }
            List<c.a.p0.a.t1.f.a> h2 = swanAppConfigData.h(4);
            if (h2 != null && !h2.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (c.a.p0.a.t1.f.a aVar : h2) {
                    if (aVar != null && aVar.d()) {
                        w.f(jSONObject, aVar.f8716h, aVar.f8718j);
                    }
                }
                String jSONObject2 = jSONObject.toString();
                c("pluginPath", jSONObject2);
                return jSONObject2;
            }
            c("pluginPath", null);
            c.a.p0.a.t1.d.a.a("this swan app not apply on someone plugin");
            return null;
        }
        return (String) invokeL.objValue;
    }
}
