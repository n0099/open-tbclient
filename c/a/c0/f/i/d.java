package c.a.c0.f.i;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.h.k;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.c0.f.h.d f1872e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f1873f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f1874g;

        public a(c.a.c0.f.h.d dVar, Map map, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, map, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1872e = dVar;
            this.f1873f = map;
            this.f1874g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.s(this.f1872e, this.f1873f, this.f1874g);
            }
        }
    }

    public static Map<String, String> b(c.a.c0.f.h.d dVar, @Nullable c.a.c0.f.g.a aVar, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{dVar, aVar, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? c(dVar, aVar, null, i2, z) : (Map) invokeCommon.objValue;
    }

    public static Map<String, String> c(c.a.c0.f.h.d dVar, @Nullable c.a.c0.f.g.a aVar, @Nullable String str, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{dVar, aVar, str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            Map<String, String> u = u(str, i2);
            if (aVar != null) {
                String str2 = (String) c.a.c0.x.c.b(aVar.d(), WebChromeClient.KEY_ARG_CALLBACK);
                if (!TextUtils.isEmpty(str2)) {
                    c.a.c0.x.c.e(u, WebChromeClient.KEY_ARG_CALLBACK, str2);
                }
            }
            r(dVar, u, i2, z);
            return u;
        }
        return (Map) invokeCommon.objValue;
    }

    public static Map<String, String> d(c.a.c0.f.h.d dVar, String str, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{dVar, str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? e(dVar, str, null, i2, z) : (Map) invokeCommon.objValue;
    }

    public static Map<String, String> e(c.a.c0.f.h.d dVar, String str, @Nullable String str2, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{dVar, str, str2, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            return c(dVar, !TextUtils.isEmpty(str) ? new c.a.c0.f.g.a(str) : null, str2, i2, z);
        }
        return (Map) invokeCommon.objValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? !TextUtils.isEmpty(str) : invokeL.booleanValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? TextUtils.equals("vendor/ad", str) : invokeL.booleanValue;
    }

    @Nullable
    public static String h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("javascript:")) {
                str = "javascript:" + str;
            }
            return str + "('" + str2 + "');";
        }
        return (String) invokeLL.objValue;
    }

    public static String i(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (c.a.c0.x.a.g(pathSegments)) {
                return null;
            }
            return (String) c.a.c0.x.a.d(pathSegments, c.a.c0.x.a.k(pathSegments) - 1);
        }
        return (String) invokeL.objValue;
    }

    public static String j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 101) {
                    if (i2 != 201) {
                        if (i2 != 202) {
                            if (i2 != 301) {
                                if (i2 != 302) {
                                    switch (i2) {
                                        case 401:
                                            return c.a.c0.h.a.b().getString(c.a.c0.f.b.nad_scheme_err_message_action_sec_check_fail);
                                        case 402:
                                            return c.a.c0.h.a.b().getString(c.a.c0.f.b.nad_scheme_err_message_action_acl_check_fail);
                                        case 403:
                                            return c.a.c0.h.a.b().getString(c.a.c0.f.b.nad_scheme_err_message_action_allow_close);
                                        default:
                                            return c.a.c0.h.a.b().getString(c.a.c0.f.b.nad_scheme_err_message_parse_fail);
                                    }
                                }
                                return c.a.c0.h.a.b().getString(c.a.c0.f.b.nad_scheme_err_message_action_notfound);
                            }
                            return c.a.c0.h.a.b().getString(c.a.c0.f.b.nad_scheme_err_message_module_notfound);
                        }
                        return c.a.c0.h.a.b().getString(c.a.c0.f.b.nad_scheme_err_message_params_parse_fail);
                    }
                    return c.a.c0.h.a.b().getString(c.a.c0.f.b.nad_scheme_err_message_parse_fail);
                }
                return c.a.c0.h.a.b().getString(c.a.c0.f.b.nad_scheme_err_message_not_support);
            }
            return c.a.c0.h.a.b().getString(c.a.c0.f.b.nad_scheme_err_message_ok);
        }
        return (String) invokeI.objValue;
    }

    public static String k(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            String host = uri.getHost();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(host)) {
                sb.append(host);
            }
            List<String> pathSegments = uri.getPathSegments();
            if (!c.a.c0.x.a.g(pathSegments)) {
                for (int i2 = 0; i2 < c.a.c0.x.a.k(pathSegments) - 1; i2++) {
                    sb.append("/");
                    sb.append((String) c.a.c0.x.a.d(pathSegments, i2));
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static HashMap<String, String> l(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, uri)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (uri != null) {
                try {
                    Set<String> queryParameterNames = uri.getQueryParameterNames();
                    if (queryParameterNames != null) {
                        for (String str : queryParameterNames) {
                            hashMap.put(str, uri.getQueryParameter(str));
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String m(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            return uri.getScheme();
        }
        return (String) invokeL.objValue;
    }

    public static boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Uri.parse(str) == null) {
                q(str);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static String o(@Nullable Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, map)) == null) {
            if (map == null || c.a.c0.x.c.b(map, WebChromeClient.KEY_ARG_CALLBACK) == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            c.a.c0.x.b.e(jSONObject, "status", c.a.c0.x.c.b(map, "status"));
            c.a.c0.x.b.e(jSONObject, "message", c.a.c0.x.c.b(map, "message"));
            c.a.c0.x.b.e(jSONObject, "data", c.a.c0.x.c.b(map, "data"));
            return h((String) c.a.c0.x.c.b(map, WebChromeClient.KEY_ARG_CALLBACK), c.a.c0.x.b.a(jSONObject.toString()));
        }
        return (String) invokeL.objValue;
    }

    public static void p(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, str2) == null) {
            ClogBuilder j2 = new ClogBuilder().r(ClogBuilder.LogType.EXCEPTION).h("1").i(DpStatConstants.FILECACHE_CLOSE_TYPE_OPT_IS_LIVE).j(str);
            if (!TextUtils.isEmpty(str2)) {
                j2.m(str2);
            }
            c.a.c0.a0.a.b(j2);
        }
    }

    public static void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            c.a.c0.a0.a.b(new ClogBuilder().r(ClogBuilder.LogType.EXCEPTION).h("1").i("1002").j(str));
        }
    }

    public static void r(c.a.c0.f.h.d dVar, Map<String, String> map, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{dVar, map, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (k.a()) {
                s(dVar, map, z);
            } else {
                k.b(new a(dVar, map, z));
            }
        }
    }

    public static void s(c.a.c0.f.h.d dVar, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65554, null, dVar, map, z) == null) || dVar == null) {
            return;
        }
        dVar.a(z, map);
    }

    public static Map<String, String> t(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65555, null, i2, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("status", String.valueOf(i2));
            hashMap.put("message", str);
            return hashMap;
        }
        return (Map) invokeIL.objValue;
    }

    public static Map<String, String> u(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65556, null, str, i2)) == null) ? v(str, i2, j(i2)) : (Map) invokeLI.objValue;
    }

    public static Map<String, String> v(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65557, null, str, i2, str2)) == null) {
            Map<String, String> t = t(i2, str2);
            if (str != null) {
                t.put("data", str);
            }
            return t;
        }
        return (Map) invokeLIL.objValue;
    }
}
