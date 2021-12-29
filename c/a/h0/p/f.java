package c.a.h0.p;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.h0.r.h;
import c.a.h0.r.i;
import c.a.h0.r.j;
import c.a.h0.r.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.util.HttpSigner;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.kuaishou.weapon.un.x;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static String f3663b;

    /* renamed from: c  reason: collision with root package name */
    public static String f3664c;

    /* renamed from: d  reason: collision with root package name */
    public static String f3665d;

    /* renamed from: e  reason: collision with root package name */
    public static String f3666e;

    /* renamed from: f  reason: collision with root package name */
    public static String f3667f;

    /* renamed from: g  reason: collision with root package name */
    public static String f3668g;

    /* renamed from: h  reason: collision with root package name */
    public static String f3669h;

    /* renamed from: i  reason: collision with root package name */
    public static List<c.a.h0.p.c> f3670i;

    /* renamed from: j  reason: collision with root package name */
    public static Object f3671j;
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
                f.d();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a.h0.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.h0.l.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.h0.l.b f3672b;

        public b(c.a.h0.l.c cVar, c.a.h0.l.b bVar) {
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
            this.a = cVar;
            this.f3672b = bVar;
        }

        @Override // c.a.h0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                f.l(this.a.b(), this.f3672b.b());
                e.g().h();
            }
        }

        @Override // c.a.h0.l.a
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends c.a.h0.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONArray f3673b;

        public c(JSONObject jSONObject, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject;
            this.f3673b = jSONArray;
        }

        @Override // c.a.h0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f3673b.put(this.a);
                h.g("localObject" + this.a);
            }
        }

        @Override // c.a.h0.l.a
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                h.g("localObject success" + this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-919998123, "Lc/a/h0/p/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-919998123, "Lc/a/h0/p/f;");
                return;
            }
        }
        f3671j = new Object();
    }

    public static void c() {
        List<c.a.h0.p.c> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || (list = f3670i) == null) {
            return;
        }
        list.clear();
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (f.class) {
                List<c.a.h0.p.c> list = f3670i;
                if (list != null && !list.isEmpty()) {
                    c.a.h0.l.b g2 = g();
                    synchronized (f3671j) {
                        JSONArray jSONArray = new JSONArray();
                        for (c.a.h0.p.c cVar : f3670i) {
                            JSONObject d2 = cVar.d();
                            if (d2 != null) {
                                jSONArray.put(d2);
                            }
                        }
                        g2.d("data", jSONArray.toString());
                        g2.d("s", HttpSigner.a(g2, "key", c.a.h0.l.h.a.a()));
                        c();
                    }
                    c.a.h0.l.c h2 = h();
                    if (j.d()) {
                        n();
                        new d().a(h2, g2, new b(h2, g2));
                    } else {
                        l(h2.b(), g2.b());
                        e.g().h();
                    }
                }
            }
        }
    }

    public static void e(c.a.h0.p.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, cVar) == null) {
            if (f3670i == null) {
                f3670i = new ArrayList();
            }
            if (cVar != null) {
                synchronized (f3671j) {
                    f3670i.add(cVar);
                }
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            c.a.h0.q.a.a(new a());
        }
    }

    public static c.a.h0.l.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            c.a.h0.l.b bVar = new c.a.h0.l.b();
            bVar.d(x.B, "cashier");
            bVar.d(UrlOcrConfig.IdCardKey.OS, "android");
            bVar.d("v", "2.8.7.9");
            if (!TextUtils.isEmpty(f3668g)) {
                bVar.d("n", f3668g);
            }
            String b2 = c.a.h0.l.h.c.b();
            if (!TextUtils.isEmpty(b2)) {
                bVar.d("nv", b2);
            }
            if (!TextUtils.isEmpty(f3669h)) {
                bVar.d("ss", f3669h);
            }
            if (!TextUtils.isEmpty(f3663b)) {
                bVar.d("d", f3663b);
            }
            if (!TextUtils.isEmpty(f3666e)) {
                bVar.d("dt", f3666e);
            }
            if (!TextUtils.isEmpty(f3667f)) {
                bVar.d(x.w, f3667f);
            }
            if (!TextUtils.isEmpty(f3664c)) {
                bVar.d(ContentUtil.RESULT_KEY_AK, f3664c);
            }
            if (!TextUtils.isEmpty(f3665d)) {
                bVar.d("dd", f3665d);
            }
            return bVar;
        }
        return (c.a.h0.l.b) invokeV.objValue;
    }

    public static c.a.h0.l.c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            c.a.h0.l.c cVar = new c.a.h0.l.c();
            if (!TextUtils.isEmpty(a)) {
                cVar.d("Cookie", "BDUSS=" + a);
            }
            return cVar;
        }
        return (c.a.h0.l.c) invokeV.objValue;
    }

    public static JSONArray i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            File file = new File(l.a().getFilesDir(), "poly_cashier_statistics.json");
            if (file.exists()) {
                try {
                    JSONArray jSONArray = new JSONArray(c.a.h0.r.f.b(file));
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

    public static void j(int i2, String str, String str2) {
        c.a.h0.p.c cVar;
        c.a.h0.p.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65546, null, i2, str, str2) == null) {
            if (i2 != 0) {
                if (i2 == 2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("selects", c.a.h0.p.a.a);
                        c.a.h0.p.a.a = 0;
                        jSONObject.put("hbit", c.a.h0.p.a.f3650b);
                        c.a.h0.p.a.f3650b = "0";
                    } catch (JSONException unused) {
                    }
                    cVar2 = new c.a.h0.p.c("4");
                    cVar2.c(jSONObject);
                } else if (i2 != 3) {
                    cVar = null;
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("exceptionType", str2);
                        jSONObject2.put("msg", str);
                    } catch (JSONException unused2) {
                    }
                    cVar2 = new c.a.h0.p.c("3");
                    cVar2.c(jSONObject2);
                }
                cVar = cVar2;
            } else {
                cVar = new c.a.h0.p.c("2");
            }
            if (cVar != null) {
                e(cVar);
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            a = null;
            f3663b = null;
            f3666e = null;
            f3667f = null;
            f3668g = null;
            f3669h = null;
        }
    }

    public static void l(Map map, Map map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, map, map2) == null) {
            try {
                JSONArray i2 = i();
                if (i2 != null) {
                    if (i2.length() >= 20) {
                        i2.remove(0);
                    }
                } else {
                    i2 = new JSONArray();
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject b2 = i.b(map);
                JSONObject b3 = i.b(map2);
                jSONObject.put("header", b2);
                jSONObject.put("body", b3);
                i2.put(jSONObject);
                m(i2);
            } catch (Exception unused) {
            }
        }
    }

    public static void m(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, jSONArray) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        h.g("localArray" + jSONArray.length() + jSONArray.toString());
        c.a.h0.r.f.d(jSONArray.toString(), new File(l.a().getFilesDir(), "poly_cashier_statistics.json"));
    }

    public static boolean n() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            JSONArray i2 = i();
            if (i2 == null || i2.length() == 0) {
                return true;
            }
            try {
                jSONArray = new JSONArray();
                for (int i3 = 0; i3 < i2.length(); i3++) {
                    JSONObject jSONObject = i2.getJSONObject(i3);
                    c.a.h0.l.c cVar = new c.a.h0.l.c();
                    cVar.e(i.d(jSONObject.optJSONObject("header")));
                    c.a.h0.l.b bVar = new c.a.h0.l.b();
                    bVar.e(i.d(jSONObject.optJSONObject("body")));
                    new d().a(cVar, bVar, new c(jSONObject, jSONArray));
                }
            } catch (Exception unused) {
            }
            if (jSONArray.length() == 0) {
                return true;
            }
            m(jSONArray);
            return false;
        }
        return invokeV.booleanValue;
    }
}
