package c.a.n0.h.c0.a;

import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.a2.n.c;
import c.a.n0.a.k;
import c.a.n0.a.r1.h;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.CfgFileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a extends c.a.n0.a.a2.n.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f10843h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f10844b;

    /* renamed from: c  reason: collision with root package name */
    public b f10845c;

    /* renamed from: d  reason: collision with root package name */
    public c f10846d;

    /* renamed from: e  reason: collision with root package name */
    public String f10847e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.h.r.a f10848f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.h.y.e.a f10849g;

    /* renamed from: c.a.n0.h.c0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0554a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f10850a;

        /* renamed from: b  reason: collision with root package name */
        public String f10851b;

        /* renamed from: c  reason: collision with root package name */
        public String f10852c;

        /* renamed from: d  reason: collision with root package name */
        public String f10853d;

        public C0554a() {
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

        public static C0554a b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                C0554a c0554a = new C0554a();
                c0554a.f10851b = jSONObject.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH);
                c0554a.f10850a = jSONObject.optString("name");
                if (!TextUtils.isEmpty(c0554a.f10851b) && !TextUtils.isEmpty(c0554a.f10850a)) {
                    if (c0554a.f10851b.endsWith(".js")) {
                        String[] split = c0554a.f10851b.split(File.separator);
                        if (split.length < 1) {
                            return c();
                        }
                        c0554a.f10853d = split[split.length - 1];
                        c0554a.f10852c = "";
                        for (int i2 = 0; i2 < split.length - 1; i2++) {
                            c0554a.f10852c += split[i2] + File.separator;
                        }
                    } else {
                        String str = c0554a.f10851b;
                        c0554a.f10852c = str;
                        if (!str.endsWith(File.separator)) {
                            c0554a.f10852c += File.separator;
                        }
                        c0554a.f10853d = "index.js";
                    }
                    return c0554a;
                }
                return c();
            }
            return (C0554a) invokeL.objValue;
        }

        public static C0554a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C0554a() : (C0554a) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<C0554a> f10854a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f10855b;

        public b() {
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

        public static b b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    b bVar = new b();
                    bVar.f10854a = new ArrayList();
                    bVar.f10855b = new HashMap<>();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            bVar.f10854a.add(C0554a.b(optJSONObject));
                        }
                    }
                    return bVar;
                }
                return c();
            }
            return (b) invokeL.objValue;
        }

        public static b c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                b bVar = new b();
                bVar.f10854a = new ArrayList();
                bVar.f10855b = new HashMap<>();
                return bVar;
            }
            return (b) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, String> f10856a;

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

        public static c b(JSONObject jSONObject, b bVar) {
            InterceptResult invokeLL;
            List<C0554a> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
                if (jSONObject != null && bVar != null && (list = bVar.f10854a) != null && list.size() > 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                    if (optJSONObject == null) {
                        return c();
                    }
                    c cVar = new c();
                    cVar.f10856a = new HashMap<>();
                    for (C0554a c0554a : bVar.f10854a) {
                        if (c0554a != null && !TextUtils.isEmpty(c0554a.f10851b)) {
                            HashMap<String, String> hashMap = cVar.f10856a;
                            String str = c0554a.f10851b;
                            hashMap.put(str, optJSONObject.optString(str));
                        }
                    }
                    return cVar;
                }
                return c();
            }
            return (c) invokeLL.objValue;
        }

        public static c c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                c cVar = new c();
                cVar.f10856a = new HashMap<>();
                return cVar;
            }
            return (c) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(918694012, "Lc/a/n0/h/c0/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(918694012, "Lc/a/n0/h/c0/a/a;");
                return;
            }
        }
        f10843h = k.f6803a;
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
            }
        }
    }

    public static a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                aVar.f4316a = c.a.a(jSONObject);
                String optString = jSONObject.optString("deviceOrientation", "portrait");
                boolean z = false;
                aVar.f10844b = 0;
                if (TextUtils.equals(optString, "landscape")) {
                    aVar.f10844b = 1;
                }
                jSONObject.optBoolean("showStatusBar", false);
                jSONObject.optString("workers");
                b b2 = b.b(jSONObject);
                aVar.f10845c = b2;
                aVar.f10846d = c.b(jSONObject, b2);
                aVar.f10847e = jSONObject.optString("openDataContext");
                aVar.f10848f = new c.a.n0.h.r.a(jSONObject);
                JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    z = true;
                }
                h.p("startup").A("preload_resources", z ? "1" : "0");
                aVar.f10849g = new c.a.n0.h.y.e.a(optJSONArray);
                JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.f35824j);
                if (optJSONObject != null) {
                    optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
                }
                return aVar;
            } catch (JSONException e2) {
                if (f10843h) {
                    String str2 = "buildConfigData json error: " + Log.getStackTraceString(e2);
                }
                return null;
            }
        }
        return (a) invokeL.objValue;
    }
}
