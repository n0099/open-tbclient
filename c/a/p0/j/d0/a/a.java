package c.a.p0.j.d0.a;

import android.text.TextUtils;
import android.util.Log;
import c.a.p0.a.d2.n.c;
import c.a.p0.a.k;
import c.a.p0.a.u1.h;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.CfgFileUtils;
import com.kwad.v8.NodeJS;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a extends c.a.p0.a.d2.n.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f10140h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f10141b;

    /* renamed from: c  reason: collision with root package name */
    public b f10142c;

    /* renamed from: d  reason: collision with root package name */
    public c f10143d;

    /* renamed from: e  reason: collision with root package name */
    public String f10144e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.j.s.a f10145f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.j.z.e.a f10146g;

    /* renamed from: c.a.p0.j.d0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0648a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f10147b;

        /* renamed from: c  reason: collision with root package name */
        public String f10148c;

        /* renamed from: d  reason: collision with root package name */
        public String f10149d;

        public C0648a() {
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

        public static C0648a b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                C0648a c0648a = new C0648a();
                c0648a.f10147b = jSONObject.optString("root");
                c0648a.a = jSONObject.optString("name");
                if (!TextUtils.isEmpty(c0648a.f10147b) && !TextUtils.isEmpty(c0648a.a)) {
                    if (c0648a.f10147b.endsWith(".js")) {
                        String[] split = c0648a.f10147b.split(File.separator);
                        if (split.length < 1) {
                            return c();
                        }
                        c0648a.f10149d = split[split.length - 1];
                        c0648a.f10148c = "";
                        for (int i2 = 0; i2 < split.length - 1; i2++) {
                            c0648a.f10148c += split[i2] + File.separator;
                        }
                    } else {
                        String str = c0648a.f10147b;
                        c0648a.f10148c = str;
                        if (!str.endsWith(File.separator)) {
                            c0648a.f10148c += File.separator;
                        }
                        c0648a.f10149d = "index.js";
                    }
                    return c0648a;
                }
                return c();
            }
            return (C0648a) invokeL.objValue;
        }

        public static C0648a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C0648a() : (C0648a) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<C0648a> a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f10150b;

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
                    bVar.a = new ArrayList();
                    bVar.f10150b = new HashMap<>();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            bVar.a.add(C0648a.b(optJSONObject));
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
                bVar.a = new ArrayList();
                bVar.f10150b = new HashMap<>();
                return bVar;
            }
            return (b) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap<String, String> a;

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
            List<C0648a> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
                if (jSONObject != null && bVar != null && (list = bVar.a) != null && list.size() > 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                    if (optJSONObject == null) {
                        return c();
                    }
                    c cVar = new c();
                    cVar.a = new HashMap<>();
                    for (C0648a c0648a : bVar.a) {
                        if (c0648a != null && !TextUtils.isEmpty(c0648a.f10147b)) {
                            HashMap<String, String> hashMap = cVar.a;
                            String str = c0648a.f10147b;
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
                cVar.a = new HashMap<>();
                return cVar;
            }
            return (c) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1550545795, "Lc/a/p0/j/d0/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1550545795, "Lc/a/p0/j/d0/a/a;");
                return;
            }
        }
        f10140h = k.a;
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
                aVar.a = c.a.a(jSONObject);
                String optString = jSONObject.optString("deviceOrientation", "portrait");
                boolean z = false;
                aVar.f10141b = 0;
                if (TextUtils.equals(optString, "landscape")) {
                    aVar.f10141b = 1;
                }
                jSONObject.optBoolean("showStatusBar", false);
                jSONObject.optString("workers");
                b b2 = b.b(jSONObject);
                aVar.f10142c = b2;
                aVar.f10143d = c.b(jSONObject, b2);
                aVar.f10144e = jSONObject.optString("openDataContext");
                aVar.f10145f = new c.a.p0.j.s.a(jSONObject);
                JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    z = true;
                }
                h.p(NodeJS.STARTUP_SCRIPT_NAME).D("preload_resources", z ? "1" : "0");
                aVar.f10146g = new c.a.p0.j.z.e.a(optJSONArray);
                JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.s);
                if (optJSONObject != null) {
                    optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
                }
                return aVar;
            } catch (JSONException e2) {
                if (f10140h) {
                    String str2 = "buildConfigData json error: " + Log.getStackTraceString(e2);
                }
                return null;
            }
        }
        return (a) invokeL.objValue;
    }
}
