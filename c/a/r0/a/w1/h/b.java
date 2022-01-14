package c.a.r0.a.w1.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.d2.e;
import c.a.r0.a.d2.n.d;
import c.a.r0.a.g1.f;
import c.a.r0.a.h0.g.g;
import c.a.r0.a.h0.g.h;
import c.a.r0.a.k;
import c.a.r0.a.w1.g.c;
import c.a.r0.a.z2.w;
import c.a.r0.q.i.i;
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
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1801346396, "Lc/a/r0/a/w1/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1801346396, "Lc/a/r0/a/w1/h/b;");
                return;
            }
        }
        a = k.a;
    }

    public static void a(Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, map, str) == null) || map == null) {
            return;
        }
        String b2 = b(map, "dynamicLibPath", 3);
        String b3 = b(map, "dynamicLibConfig", 3);
        String b4 = b(map, "pluginPath", 4);
        String b5 = b(map, "dependenciesPath", 6);
        String b6 = b(map, "dependenciesConfig", 6);
        if (TextUtils.isEmpty(str) || !a) {
            return;
        }
        c.a.r0.a.w1.e.a.b(str + ", dynamicLibPath = " + b2 + "; dynamicLibConfig = " + b3 + "; pluginPath = " + b4 + "; dependenciesPath = " + b5 + "; dependenciesConfig = " + b6);
    }

    public static String b(Map<String, String> map, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, map, str, i2)) == null) {
            if (map == null || TextUtils.isEmpty(str)) {
                return null;
            }
            e L = e.L();
            String e2 = L != null ? L.T().e(str, null) : null;
            if (!TextUtils.isEmpty(e2)) {
                map.put(str, e2);
                return e2;
            }
            SwanAppConfigData P = L != null ? L.P() : null;
            if (i2 == 3) {
                c.a.r0.a.w1.c.a.m(P, false);
                e2 = i(str, null);
            } else if (i2 == 4) {
                e2 = l(P);
            } else if (i2 == 6) {
                c.a.r0.a.w1.a.a(P);
                e2 = i(str, null);
            }
            map.put(str, e2);
            return e2;
        }
        return (String) invokeLLI.objValue;
    }

    public static void c(String str, String str2) {
        e L;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || TextUtils.isEmpty(str) || (L = e.L()) == null) {
            return;
        }
        L.T().j(str, str2);
    }

    public static String d(List<c> list) {
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
                sb.append(list.get(i2).f9545e);
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            SwanAppConfigData b2 = d.b(str);
            if (b2 == null) {
                c.a.r0.a.w1.e.a.b("getDownloadKey, app.json is null");
                return null;
            }
            SwanAppConfigData.m mVar = b2.f39342d;
            if (mVar == null) {
                c.a.r0.a.w1.e.a.b("getDownloadKey, sub pkg obj is null");
                return null;
            }
            Map<String, String> map = mVar.a;
            if (map == null) {
                c.a.r0.a.w1.e.a.b("getDownloadKey, sub pkg map is null");
                return null;
            }
            return map.get(str2);
        }
        return (String) invokeLL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            i g2 = g(str);
            if ((g2 == null || TextUtils.isEmpty(g2.r)) ? false : true) {
                return g2.r;
            }
            c.a.r0.a.w1.e.a.b("get plugin appKey form db, but empty, plugin appId = " + str);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static i g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return c.a.r0.a.w1.c.a.p(str, com.kuaishou.weapon.un.d.S, 0L);
        }
        return (i) invokeL.objValue;
    }

    public static i h(String str) {
        InterceptResult invokeL;
        SwanAppConfigData P;
        List<i> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!c.a.r0.a.e0.f.e.e.d() && !c.a.r0.a.x1.a.a.H() && !c.a.r0.a.x1.a.a.D()) {
                return g(str);
            }
            e L = e.L();
            if (L != null && (P = L.P()) != null && (list = P.l) != null) {
                for (i iVar : list) {
                    if (TextUtils.equals(str, iVar.f11494g)) {
                        return iVar;
                    }
                }
            }
            return null;
        }
        return (i) invokeL.objValue;
    }

    public static String i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            e L = e.L();
            if (L == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return L.T().e(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public static void j() {
        g V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, null) == null) && (V = f.U().V()) != null && (V.m() instanceof h)) {
            f.U().getActivity().onBackPressed();
        }
    }

    public static List<i> k(String str, boolean z) {
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
                            i iVar = new i();
                            iVar.f11494g = optString;
                            iVar.f11496i = optJSONObject.optLong("version_code", 0L);
                            iVar.f11497j = optJSONObject.optString("version_name", com.kuaishou.weapon.un.d.S);
                            iVar.p = optJSONObject.optString("token");
                            iVar.q = optJSONObject.optString("domains");
                            iVar.f11495h = 4;
                            iVar.r = optJSONObject.optString("app_key");
                            iVar.s = optJSONObject.optString("app_name");
                            iVar.l = "";
                            iVar.m = "";
                            iVar.n = "";
                            arrayList.add(iVar);
                            if (z) {
                                c.a.r0.q.g.a.i().m(iVar);
                            }
                        }
                    }
                }
                return arrayList;
            } catch (JSONException e2) {
                c.a.r0.a.w1.e.a.b(Log.getStackTraceString(e2));
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
                c.a.r0.a.w1.e.a.b("parse app.json is null");
                return null;
            }
            List<c> i2 = swanAppConfigData.i(4);
            if (i2 != null && !i2.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (c cVar : i2) {
                    if (cVar != null && cVar.a()) {
                        w.f(jSONObject, cVar.f9545e, cVar.f9549i);
                    }
                }
                String jSONObject2 = jSONObject.toString();
                c("pluginPath", jSONObject2);
                return jSONObject2;
            }
            c("pluginPath", null);
            c.a.r0.a.w1.e.a.b("this swan app not apply on someone plugin");
            return null;
        }
        return (String) invokeL.objValue;
    }
}
