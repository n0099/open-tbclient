package c.a.o0.h.c0.a;

import android.text.TextUtils;
import android.util.Log;
import c.a.o0.a.a2.n.c;
import c.a.o0.a.k;
import c.a.o0.a.r1.h;
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
public final class a extends c.a.o0.a.a2.n.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f11089h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f11090b;

    /* renamed from: c  reason: collision with root package name */
    public b f11091c;

    /* renamed from: d  reason: collision with root package name */
    public c f11092d;

    /* renamed from: e  reason: collision with root package name */
    public String f11093e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.h.r.a f11094f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.h.y.e.a f11095g;

    /* renamed from: c.a.o0.h.c0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0562a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f11096a;

        /* renamed from: b  reason: collision with root package name */
        public String f11097b;

        /* renamed from: c  reason: collision with root package name */
        public String f11098c;

        /* renamed from: d  reason: collision with root package name */
        public String f11099d;

        public C0562a() {
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

        public static C0562a b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                C0562a c0562a = new C0562a();
                c0562a.f11097b = jSONObject.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH);
                c0562a.f11096a = jSONObject.optString("name");
                if (!TextUtils.isEmpty(c0562a.f11097b) && !TextUtils.isEmpty(c0562a.f11096a)) {
                    if (c0562a.f11097b.endsWith(".js")) {
                        String[] split = c0562a.f11097b.split(File.separator);
                        if (split.length < 1) {
                            return c();
                        }
                        c0562a.f11099d = split[split.length - 1];
                        c0562a.f11098c = "";
                        for (int i2 = 0; i2 < split.length - 1; i2++) {
                            c0562a.f11098c += split[i2] + File.separator;
                        }
                    } else {
                        String str = c0562a.f11097b;
                        c0562a.f11098c = str;
                        if (!str.endsWith(File.separator)) {
                            c0562a.f11098c += File.separator;
                        }
                        c0562a.f11099d = "index.js";
                    }
                    return c0562a;
                }
                return c();
            }
            return (C0562a) invokeL.objValue;
        }

        public static C0562a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C0562a() : (C0562a) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<C0562a> f11100a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f11101b;

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
                    bVar.f11100a = new ArrayList();
                    bVar.f11101b = new HashMap<>();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            bVar.f11100a.add(C0562a.b(optJSONObject));
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
                bVar.f11100a = new ArrayList();
                bVar.f11101b = new HashMap<>();
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
        public HashMap<String, String> f11102a;

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
            List<C0562a> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
                if (jSONObject != null && bVar != null && (list = bVar.f11100a) != null && list.size() > 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                    if (optJSONObject == null) {
                        return c();
                    }
                    c cVar = new c();
                    cVar.f11102a = new HashMap<>();
                    for (C0562a c0562a : bVar.f11100a) {
                        if (c0562a != null && !TextUtils.isEmpty(c0562a.f11097b)) {
                            HashMap<String, String> hashMap = cVar.f11102a;
                            String str = c0562a.f11097b;
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
                cVar.f11102a = new HashMap<>();
                return cVar;
            }
            return (c) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1047776731, "Lc/a/o0/h/c0/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1047776731, "Lc/a/o0/h/c0/a/a;");
                return;
            }
        }
        f11089h = k.f7049a;
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
                aVar.f4562a = c.a.a(jSONObject);
                String optString = jSONObject.optString("deviceOrientation", "portrait");
                boolean z = false;
                aVar.f11090b = 0;
                if (TextUtils.equals(optString, "landscape")) {
                    aVar.f11090b = 1;
                }
                jSONObject.optBoolean("showStatusBar", false);
                jSONObject.optString("workers");
                b b2 = b.b(jSONObject);
                aVar.f11091c = b2;
                aVar.f11092d = c.b(jSONObject, b2);
                aVar.f11093e = jSONObject.optString("openDataContext");
                aVar.f11094f = new c.a.o0.h.r.a(jSONObject);
                JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    z = true;
                }
                h.p("startup").A("preload_resources", z ? "1" : "0");
                aVar.f11095g = new c.a.o0.h.y.e.a(optJSONArray);
                JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.f35930j);
                if (optJSONObject != null) {
                    optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
                }
                return aVar;
            } catch (JSONException e2) {
                if (f11089h) {
                    String str2 = "buildConfigData json error: " + Log.getStackTraceString(e2);
                }
                return null;
            }
        }
        return (a) invokeL.objValue;
    }
}
