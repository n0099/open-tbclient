package c.a.n0.j.d0.a;

import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.k1.h;
import c.a.n0.a.t1.n.c;
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
/* loaded from: classes2.dex */
public final class a extends c.a.n0.a.t1.n.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f8691h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f8692b;

    /* renamed from: c  reason: collision with root package name */
    public b f8693c;

    /* renamed from: d  reason: collision with root package name */
    public c f8694d;

    /* renamed from: e  reason: collision with root package name */
    public String f8695e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.j.s.a f8696f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.j.z.e.a f8697g;

    /* renamed from: c.a.n0.j.d0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0700a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f8698b;

        /* renamed from: c  reason: collision with root package name */
        public String f8699c;

        /* renamed from: d  reason: collision with root package name */
        public String f8700d;

        public C0700a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static C0700a b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                C0700a c0700a = new C0700a();
                c0700a.f8698b = jSONObject.optString("root");
                c0700a.a = jSONObject.optString("name");
                if (!TextUtils.isEmpty(c0700a.f8698b) && !TextUtils.isEmpty(c0700a.a)) {
                    if (c0700a.f8698b.endsWith(".js")) {
                        String[] split = c0700a.f8698b.split(File.separator);
                        if (split.length < 1) {
                            return c();
                        }
                        c0700a.f8700d = split[split.length - 1];
                        c0700a.f8699c = "";
                        for (int i = 0; i < split.length - 1; i++) {
                            c0700a.f8699c += split[i] + File.separator;
                        }
                    } else {
                        String str = c0700a.f8698b;
                        c0700a.f8699c = str;
                        if (!str.endsWith(File.separator)) {
                            c0700a.f8699c += File.separator;
                        }
                        c0700a.f8700d = "index.js";
                    }
                    return c0700a;
                }
                return c();
            }
            return (C0700a) invokeL.objValue;
        }

        public static C0700a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C0700a() : (C0700a) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<C0700a> a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f8701b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    bVar.f8701b = new HashMap<>();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            bVar.a.add(C0700a.b(optJSONObject));
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
                bVar.f8701b = new HashMap<>();
                return bVar;
            }
            return (b) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap<String, String> a;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static c b(JSONObject jSONObject, b bVar) {
            InterceptResult invokeLL;
            List<C0700a> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
                if (jSONObject != null && bVar != null && (list = bVar.a) != null && list.size() > 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                    if (optJSONObject == null) {
                        return c();
                    }
                    c cVar = new c();
                    cVar.a = new HashMap<>();
                    for (C0700a c0700a : bVar.a) {
                        if (c0700a != null && !TextUtils.isEmpty(c0700a.f8698b)) {
                            HashMap<String, String> hashMap = cVar.a;
                            String str = c0700a.f8698b;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1808711233, "Lc/a/n0/j/d0/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1808711233, "Lc/a/n0/j/d0/a/a;");
                return;
            }
        }
        f8691h = c.a.n0.a.a.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                aVar.f8692b = 0;
                if (TextUtils.equals(optString, "landscape")) {
                    aVar.f8692b = 1;
                }
                jSONObject.optBoolean("showStatusBar", false);
                jSONObject.optString("workers");
                b b2 = b.b(jSONObject);
                aVar.f8693c = b2;
                aVar.f8694d = c.b(jSONObject, b2);
                aVar.f8695e = jSONObject.optString("openDataContext");
                aVar.f8696f = new c.a.n0.j.s.a(jSONObject);
                JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    z = true;
                }
                h.p(NodeJS.STARTUP_SCRIPT_NAME).D("preload_resources", z ? "1" : "0");
                aVar.f8697g = new c.a.n0.j.z.e.a(optJSONArray);
                JSONObject optJSONObject = jSONObject.optJSONObject("setting");
                if (optJSONObject != null) {
                    optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
                }
                return aVar;
            } catch (JSONException e2) {
                if (f8691h) {
                    Log.e("SwanGameConfigData", "buildConfigData json error: " + Log.getStackTraceString(e2));
                }
                return null;
            }
        }
        return (a) invokeL.objValue;
    }
}
