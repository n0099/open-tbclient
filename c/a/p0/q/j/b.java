package c.a.p0.q.j;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.q.i.i;
import c.a.p0.q.j.m.a;
import c.a.p0.q.j.m.c;
import c.a.p0.q.j.m.f;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.ETAG;
import io.flutter.embedding.android.FlutterActivityAndFragmentDelegate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j2, boolean z) {
        InterceptResult invokeCommon;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            List<c.a.p0.q.i.a> l = c.a.p0.q.c.b().l(str, j2);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (c.a.p0.q.i.a aVar : l) {
                        if (aVar.f10703b) {
                            j3 = aVar.f10704c;
                        } else {
                            i b2 = c.a.p0.q.p.e.b(aVar.a, aVar.f10705d, aVar.f10706e, arrayList);
                            j3 = b2 == null ? 0L : b2.f10719i;
                        }
                        if (j3 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", aVar.a);
                            jSONObject.put("pkg_ver", j3);
                            if (z) {
                                jSONObject.put("category", 6);
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                } catch (JSONException unused) {
                }
                if (!arrayList.isEmpty()) {
                    c.a.p0.q.g.a.i().g(arrayList);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeCommon.objValue;
    }

    @NonNull
    public static JSONObject b() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("swan_ext_ver", g(0));
            jSONObject.put("game_ext_ver", g(1));
            jSONObject.put("swan_ext_vercode", c.a.p0.q.c.b().j(0));
            jSONObject.put("game_ext_vercode", c.a.p0.q.c.b().j(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @NonNull
    public static JSONObject c() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("swan_core_ver", h(0));
            jSONObject.put("swan_game_ver", h(1));
            jSONObject.put("swan_vercode", c.a.p0.q.c.b().w(0));
            jSONObject.put("game_vercode", c.a.p0.q.c.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(c.a.p0.q.j.m.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) {
            if (aVar != null && aVar.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(FlutterActivityAndFragmentDelegate.FRAMEWORK_RESTORATION_BUNDLE_KEY, c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (a.C0703a c0703a : aVar.f()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("bundle_id", c0703a.a());
                        jSONObject2.put("category", c0703a.b());
                        jSONObject2.put("pkg_ver", c0703a.e());
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("min_version", c0703a.d());
                        jSONObject3.put("max_version", c0703a.c());
                        jSONObject2.put("version_range", jSONObject3);
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("list", jSONArray);
                    return jSONObject;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject e(c.a.p0.q.j.m.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar)) == null) {
            if (cVar != null && cVar.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(FlutterActivityAndFragmentDelegate.FRAMEWORK_RESTORATION_BUNDLE_KEY, c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (c.a aVar : cVar.f()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("bundle_id", aVar.b());
                        if (aVar.c() != -1) {
                            jSONObject2.put("category", aVar.c());
                        }
                        jSONObject2.put("pkg_ver", aVar.d());
                        jSONObject2.put("app_sign", aVar.a());
                        if (aVar.c() == 0 && aVar.d() != -1 && aVar.d() != 0) {
                            jSONObject2.put("dep", a(aVar.b(), aVar.d(), true));
                        }
                        if (aVar instanceof f.b) {
                            f.b bVar = (f.b) aVar;
                            String[] i2 = bVar.i();
                            if (i2 != null && i2.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i2)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<f.a> j2 = bVar.j();
                            if (j2 != null && !j2.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (f.a aVar2 : j2) {
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("id", aVar2.a());
                                    jSONObject4.put("type", aVar2.getType());
                                    jSONArray2.put(jSONObject4);
                                }
                                jSONObject3.put("list", jSONArray2);
                                jSONObject3.put("ver", j2.get(0).b());
                            }
                            jSONObject2.put("sub_info", jSONObject3);
                        }
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("list", jSONArray);
                    return jSONObject;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static HashMap<String, String> f(c.a.p0.q.j.m.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, hVar)) == null) {
            if (hVar == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(hVar.b(), "-1")) {
                hashMap.put("from", hVar.b());
            }
            if (!TextUtils.equals(hVar.c(), "-1")) {
                hashMap.put("scene", hVar.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i2)) == null) {
            String v = c.a.p0.q.c.b().v(i2);
            return TextUtils.isEmpty(v) ? "0" : v;
        }
        return (String) invokeI.objValue;
    }

    public static String h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) {
            String J = c.a.p0.q.c.b().J(i2);
            return TextUtils.isEmpty(J) ? "0" : J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(c.a.p0.q.j.m.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, dVar)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (dVar == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", dVar.g());
            hashMap.put("category", String.valueOf(dVar.a()));
            if (dVar.m() == -1) {
                pMSAppInfo = c.a.p0.q.g.a.i().u(dVar.g());
                if (pMSAppInfo != null && c.a.p0.q.g.a.i().o(c.a.p0.q.i.g.class, dVar.g()) != null) {
                    dVar.u(pMSAppInfo.versionCode);
                } else {
                    dVar.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(dVar.m()));
            if (dVar.a() == 0 && dVar.m() != -1 && dVar.m() != 0) {
                hashMap.put("dep", a(dVar.g(), dVar.m(), false).toString());
            }
            if (dVar.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = c.a.p0.q.g.a.i().u(dVar.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    dVar.o(pMSAppInfo.appSign);
                } else {
                    dVar.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(dVar.f()));
            if (dVar.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(dVar.i()));
            }
            String k2 = dVar.k();
            if (TextUtils.isEmpty(k2)) {
                k2 = h(dVar.a());
                dVar.s(k2);
            }
            if (TextUtils.isEmpty(k2)) {
                k2 = "0";
            }
            hashMap.put("framework_ver", k2);
            long w = c.a.p0.q.c.b().w(dVar.a());
            long j2 = c.a.p0.q.c.b().j(dVar.a());
            if (dVar.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j2 + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j2 + "");
            }
            String j3 = dVar.j();
            if (TextUtils.isEmpty(j3)) {
                j3 = g(dVar.a());
                dVar.r(j3);
            }
            hashMap.put("extension_ver", TextUtils.isEmpty(j3) ? "0" : j3);
            if (!TextUtils.isEmpty(dVar.l())) {
                hashMap.put("path", dVar.l());
            }
            if (!TextUtils.equals(dVar.b(), "-1")) {
                hashMap.put("from", dVar.b());
            }
            if (!TextUtils.equals(dVar.c(), "-1")) {
                hashMap.put("scene", dVar.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(dVar.n()));
            hashMap.put("host_env", String.valueOf(c.a.p0.q.c.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(c.a.p0.q.j.m.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, eVar)) == null) {
            if (eVar == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", eVar.f());
            hashMap.put("category", String.valueOf(eVar.a()));
            if (TextUtils.isEmpty(eVar.h())) {
                eVar.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", eVar.h());
            if (eVar.g() >= 0) {
                hashMap.put("plugin_vercode", eVar.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> k(c.a.p0.q.j.m.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, gVar)) == null) {
            if (gVar == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", gVar.f());
            hashMap.put("category", String.valueOf(gVar.a()));
            hashMap.put("pkg_ver", String.valueOf(gVar.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(gVar.j()));
            hashMap.put("sub_id", gVar.k());
            if (!TextUtils.equals(gVar.b(), "-1")) {
                hashMap.put("from", gVar.b());
            }
            if (TextUtils.isEmpty(gVar.i())) {
                gVar.m(h(gVar.a()));
            }
            if (!TextUtils.isEmpty(gVar.i())) {
                hashMap.put("framework_ver", gVar.i());
            }
            if (TextUtils.isEmpty(gVar.h())) {
                gVar.l(g(gVar.a()));
            }
            if (!TextUtils.isEmpty(gVar.h())) {
                hashMap.put("extension_ver", gVar.h());
            }
            long w = c.a.p0.q.c.b().w(gVar.a());
            long j2 = c.a.p0.q.c.b().j(gVar.a());
            if (gVar.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j2 + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j2 + "");
            }
            if (gVar.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(gVar.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
