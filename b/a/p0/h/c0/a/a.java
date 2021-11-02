package b.a.p0.h.c0.a;

import android.text.TextUtils;
import android.util.Log;
import b.a.p0.a.a2.n.c;
import b.a.p0.a.k;
import b.a.p0.a.r1.h;
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
/* loaded from: classes4.dex */
public final class a extends b.a.p0.a.a2.n.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f10326h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f10327b;

    /* renamed from: c  reason: collision with root package name */
    public b f10328c;

    /* renamed from: d  reason: collision with root package name */
    public c f10329d;

    /* renamed from: e  reason: collision with root package name */
    public String f10330e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.h.r.a f10331f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.p0.h.y.e.a f10332g;

    /* renamed from: b.a.p0.h.c0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0559a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f10333a;

        /* renamed from: b  reason: collision with root package name */
        public String f10334b;

        /* renamed from: c  reason: collision with root package name */
        public String f10335c;

        /* renamed from: d  reason: collision with root package name */
        public String f10336d;

        public C0559a() {
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

        public static C0559a b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                C0559a c0559a = new C0559a();
                c0559a.f10334b = jSONObject.optString("root");
                c0559a.f10333a = jSONObject.optString("name");
                if (!TextUtils.isEmpty(c0559a.f10334b) && !TextUtils.isEmpty(c0559a.f10333a)) {
                    if (c0559a.f10334b.endsWith(".js")) {
                        String[] split = c0559a.f10334b.split(File.separator);
                        if (split.length < 1) {
                            return c();
                        }
                        c0559a.f10336d = split[split.length - 1];
                        c0559a.f10335c = "";
                        for (int i2 = 0; i2 < split.length - 1; i2++) {
                            c0559a.f10335c += split[i2] + File.separator;
                        }
                    } else {
                        String str = c0559a.f10334b;
                        c0559a.f10335c = str;
                        if (!str.endsWith(File.separator)) {
                            c0559a.f10335c += File.separator;
                        }
                        c0559a.f10336d = "index.js";
                    }
                    return c0559a;
                }
                return c();
            }
            return (C0559a) invokeL.objValue;
        }

        public static C0559a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C0559a() : (C0559a) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<C0559a> f10337a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f10338b;

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
                    bVar.f10337a = new ArrayList();
                    bVar.f10338b = new HashMap<>();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            bVar.f10337a.add(C0559a.b(optJSONObject));
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
                bVar.f10337a = new ArrayList();
                bVar.f10338b = new HashMap<>();
                return bVar;
            }
            return (b) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, String> f10339a;

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
            List<C0559a> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
                if (jSONObject != null && bVar != null && (list = bVar.f10337a) != null && list.size() > 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                    if (optJSONObject == null) {
                        return c();
                    }
                    c cVar = new c();
                    cVar.f10339a = new HashMap<>();
                    for (C0559a c0559a : bVar.f10337a) {
                        if (c0559a != null && !TextUtils.isEmpty(c0559a.f10334b)) {
                            HashMap<String, String> hashMap = cVar.f10339a;
                            String str = c0559a.f10334b;
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
                cVar.f10339a = new HashMap<>();
                return cVar;
            }
            return (c) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1687393627, "Lb/a/p0/h/c0/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1687393627, "Lb/a/p0/h/c0/a/a;");
                return;
            }
        }
        f10326h = k.f6397a;
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
                aVar.f3991a = c.a.a(jSONObject);
                String optString = jSONObject.optString("deviceOrientation", "portrait");
                boolean z = false;
                aVar.f10327b = 0;
                if (TextUtils.equals(optString, "landscape")) {
                    aVar.f10327b = 1;
                }
                jSONObject.optBoolean("showStatusBar", false);
                jSONObject.optString("workers");
                b b2 = b.b(jSONObject);
                aVar.f10328c = b2;
                aVar.f10329d = c.b(jSONObject, b2);
                aVar.f10330e = jSONObject.optString("openDataContext");
                aVar.f10331f = new b.a.p0.h.r.a(jSONObject);
                JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    z = true;
                }
                h.p("startup").A("preload_resources", z ? "1" : "0");
                aVar.f10332g = new b.a.p0.h.y.e.a(optJSONArray);
                JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.s);
                if (optJSONObject != null) {
                    optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
                }
                return aVar;
            } catch (JSONException e2) {
                if (f10326h) {
                    String str2 = "buildConfigData json error: " + Log.getStackTraceString(e2);
                }
                return null;
            }
        }
        return (a) invokeL.objValue;
    }
}
