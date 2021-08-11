package c.a.d0.k.h;

import android.text.TextUtils;
import c.a.d0.n.e;
import c.a.d0.n.f;
import c.a.d0.n.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.poly.util.HttpSigner;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f1826a;

    /* renamed from: b  reason: collision with root package name */
    public static String f1827b;

    /* renamed from: c  reason: collision with root package name */
    public static String f1828c;

    /* renamed from: d  reason: collision with root package name */
    public static String f1829d;

    /* renamed from: e  reason: collision with root package name */
    public static String f1830e;

    /* renamed from: f  reason: collision with root package name */
    public static List<c.a.d0.k.h.b> f1831f;

    /* renamed from: g  reason: collision with root package name */
    public static Object f1832g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.i();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a.d0.k.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.d0.k.a.c f1833a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.d0.k.a.b f1834b;

        public b(c.a.d0.k.a.c cVar, c.a.d0.k.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1833a = cVar;
            this.f1834b = bVar;
        }

        @Override // c.a.d0.k.a.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            }
        }

        @Override // c.a.d0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                d.f(this.f1833a.c(), this.f1834b.c());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends c.a.d0.k.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONArray f1835a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f1836b;

        public c(JSONArray jSONArray, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONArray, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1835a = jSONArray;
            this.f1836b = jSONObject;
        }

        @Override // c.a.d0.k.a.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            }
        }

        @Override // c.a.d0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                this.f1835a.put(this.f1836b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-858144513, "Lc/a/d0/k/h/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-858144513, "Lc/a/d0/k/h/d;");
                return;
            }
        }
        f1832g = new Object();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            f1826a = null;
            f1827b = null;
            f1828c = null;
            f1829d = null;
            f1830e = null;
        }
    }

    public static void b(c.a.d0.k.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bVar) == null) {
            if (f1831f == null) {
                f1831f = new ArrayList();
            }
            if (bVar != null) {
                synchronized (f1832g) {
                    f1831f.add(bVar);
                }
            }
        }
    }

    public static void e(int i2, String str) {
        c.a.d0.k.h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, null, i2, str) == null) {
            if (i2 == 0) {
                bVar = new c.a.d0.k.h.b("2");
            } else if (i2 != 2) {
                bVar = i2 != 3 ? null : new c.a.d0.k.h.b("3");
            } else {
                bVar = new c.a.d0.k.h.b("4");
            }
            if (bVar != null) {
                bVar.c(str);
                b(bVar);
            }
        }
    }

    public static void f(Map map, Map map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, map, map2) == null) {
            try {
                JSONArray l = l();
                if (l != null) {
                    if (l.length() >= 20) {
                        l.remove(0);
                    }
                } else {
                    l = new JSONArray();
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject c2 = e.c(map);
                JSONObject c3 = e.c(map2);
                jSONObject.put("header", c2);
                jSONObject.put("body", c3);
                l.put(jSONObject);
                g(l);
            } catch (Exception unused) {
            }
        }
    }

    public static void g(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, jSONArray) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        c.a.d0.n.c.b(jSONArray.toString(), new File(g.a().getFilesDir(), "poly_cashier_statistics.json"));
    }

    public static void h() {
        List<c.a.d0.k.h.b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || (list = f1831f) == null) {
            return;
        }
        list.clear();
    }

    public static synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            synchronized (d.class) {
                List<c.a.d0.k.h.b> list = f1831f;
                if (list != null && !list.isEmpty()) {
                    c.a.d0.k.a.b m = m();
                    synchronized (f1832g) {
                        JSONArray jSONArray = new JSONArray();
                        for (c.a.d0.k.h.b bVar : f1831f) {
                            JSONObject a2 = bVar.a();
                            if (a2 != null) {
                                jSONArray.put(a2);
                            }
                        }
                        m.e("data", jSONArray.toString());
                        m.e("s", HttpSigner.a(m, "key", c.a.d0.k.b.a.d()));
                        h();
                    }
                    c.a.d0.k.a.c k = k();
                    if (f.a()) {
                        n();
                        new c.a.d0.k.h.c().a(k, m, new b(k, m));
                    } else {
                        f(k.c(), m.c());
                    }
                }
            }
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            c.a.d0.m.a.a(new a());
        }
    }

    public static c.a.d0.k.a.c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            c.a.d0.k.a.c cVar = new c.a.d0.k.a.c();
            if (!TextUtils.isEmpty(f1826a)) {
                cVar.e("Cookie", "BDUSS=" + f1826a);
            }
            return cVar;
        }
        return (c.a.d0.k.a.c) invokeV.objValue;
    }

    public static JSONArray l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            File file = new File(g.a().getFilesDir(), "poly_cashier_statistics.json");
            if (file.exists()) {
                try {
                    JSONArray jSONArray = new JSONArray(c.a.d0.n.c.d(file));
                    try {
                        file.delete();
                    } catch (Exception unused) {
                    }
                    return jSONArray;
                } catch (Exception unused2) {
                    return null;
                }
            }
            return null;
        }
        return (JSONArray) invokeV.objValue;
    }

    public static c.a.d0.k.a.b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            c.a.d0.k.a.b bVar = new c.a.d0.k.a.b();
            bVar.e("dm", "cashier");
            bVar.e("os", "android");
            bVar.e("v", "2.7.7");
            if (!TextUtils.isEmpty(f1830e)) {
                bVar.e("n", f1830e);
            }
            if (!TextUtils.isEmpty(f1827b)) {
                bVar.e("d", f1827b);
            }
            if (!TextUtils.isEmpty(f1828c)) {
                bVar.e("dt", f1828c);
            }
            if (!TextUtils.isEmpty(f1829d)) {
                bVar.e("dp", f1829d);
            }
            return bVar;
        }
        return (c.a.d0.k.a.b) invokeV.objValue;
    }

    public static void n() {
        JSONArray l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65550, null) == null) && (l = l()) != null && l.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < l.length(); i2++) {
                    JSONObject jSONObject = l.getJSONObject(i2);
                    c.a.d0.k.a.c cVar = new c.a.d0.k.a.c();
                    cVar.a(e.d(jSONObject.optJSONObject("header")));
                    c.a.d0.k.a.b bVar = new c.a.d0.k.a.b();
                    bVar.a(e.d(jSONObject.optJSONObject("body")));
                    new c.a.d0.k.h.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                g(jSONArray);
            } catch (Exception unused) {
            }
        }
    }
}
