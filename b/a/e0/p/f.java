package b.a.e0.p;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e0.r.h;
import b.a.e0.r.i;
import b.a.e0.r.j;
import b.a.e0.r.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.poly.util.HttpSigner;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f2674a;

    /* renamed from: b  reason: collision with root package name */
    public static String f2675b;

    /* renamed from: c  reason: collision with root package name */
    public static String f2676c;

    /* renamed from: d  reason: collision with root package name */
    public static String f2677d;

    /* renamed from: e  reason: collision with root package name */
    public static String f2678e;

    /* renamed from: f  reason: collision with root package name */
    public static String f2679f;

    /* renamed from: g  reason: collision with root package name */
    public static String f2680g;

    /* renamed from: h  reason: collision with root package name */
    public static String f2681h;

    /* renamed from: i  reason: collision with root package name */
    public static List<b.a.e0.p.c> f2682i;
    public static Object j;
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
    public static class b extends b.a.e0.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.e0.l.c f2683a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.e0.l.b f2684b;

        public b(b.a.e0.l.c cVar, b.a.e0.l.b bVar) {
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
            this.f2683a = cVar;
            this.f2684b = bVar;
        }

        @Override // b.a.e0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                f.l(this.f2683a.b(), this.f2684b.b());
                e.g().h();
            }
        }

        @Override // b.a.e0.l.a
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends b.a.e0.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f2685a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONArray f2686b;

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
            this.f2685a = jSONObject;
            this.f2686b = jSONArray;
        }

        @Override // b.a.e0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f2686b.put(this.f2685a);
                h.g("localObject" + this.f2685a);
            }
        }

        @Override // b.a.e0.l.a
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                h.g("localObject success" + this.f2685a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1785557807, "Lb/a/e0/p/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1785557807, "Lb/a/e0/p/f;");
                return;
            }
        }
        j = new Object();
    }

    public static void c() {
        List<b.a.e0.p.c> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || (list = f2682i) == null) {
            return;
        }
        list.clear();
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (f.class) {
                List<b.a.e0.p.c> list = f2682i;
                if (list != null && !list.isEmpty()) {
                    b.a.e0.l.b g2 = g();
                    synchronized (j) {
                        JSONArray jSONArray = new JSONArray();
                        for (b.a.e0.p.c cVar : f2682i) {
                            JSONObject d2 = cVar.d();
                            if (d2 != null) {
                                jSONArray.put(d2);
                            }
                        }
                        g2.d("data", jSONArray.toString());
                        g2.d("s", HttpSigner.a(g2, "key", b.a.e0.l.h.a.a()));
                        c();
                    }
                    b.a.e0.l.c h2 = h();
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

    public static void e(b.a.e0.p.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, cVar) == null) {
            if (f2682i == null) {
                f2682i = new ArrayList();
            }
            if (cVar != null) {
                synchronized (j) {
                    f2682i.add(cVar);
                }
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            b.a.e0.q.a.a(new a());
        }
    }

    public static b.a.e0.l.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            b.a.e0.l.b bVar = new b.a.e0.l.b();
            bVar.d("dm", "cashier");
            bVar.d("os", "android");
            bVar.d("v", "2.8.7.9");
            if (!TextUtils.isEmpty(f2680g)) {
                bVar.d("n", f2680g);
            }
            String b2 = b.a.e0.l.h.c.b();
            if (!TextUtils.isEmpty(b2)) {
                bVar.d("nv", b2);
            }
            if (!TextUtils.isEmpty(f2681h)) {
                bVar.d("ss", f2681h);
            }
            if (!TextUtils.isEmpty(f2675b)) {
                bVar.d("d", f2675b);
            }
            if (!TextUtils.isEmpty(f2678e)) {
                bVar.d("dt", f2678e);
            }
            if (!TextUtils.isEmpty(f2679f)) {
                bVar.d("dp", f2679f);
            }
            if (!TextUtils.isEmpty(f2676c)) {
                bVar.d(ContentUtil.RESULT_KEY_AK, f2676c);
            }
            if (!TextUtils.isEmpty(f2677d)) {
                bVar.d("dd", f2677d);
            }
            return bVar;
        }
        return (b.a.e0.l.b) invokeV.objValue;
    }

    public static b.a.e0.l.c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            b.a.e0.l.c cVar = new b.a.e0.l.c();
            if (!TextUtils.isEmpty(f2674a)) {
                cVar.d("Cookie", "BDUSS=" + f2674a);
            }
            return cVar;
        }
        return (b.a.e0.l.c) invokeV.objValue;
    }

    public static JSONArray i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            File file = new File(l.a().getFilesDir(), "poly_cashier_statistics.json");
            if (file.exists()) {
                try {
                    JSONArray jSONArray = new JSONArray(b.a.e0.r.f.b(file));
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
        b.a.e0.p.c cVar;
        b.a.e0.p.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65546, null, i2, str, str2) == null) {
            if (i2 != 0) {
                if (i2 == 2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("selects", b.a.e0.p.a.f2656a);
                        b.a.e0.p.a.f2656a = 0;
                        jSONObject.put("hbit", b.a.e0.p.a.f2657b);
                        b.a.e0.p.a.f2657b = "0";
                    } catch (JSONException unused) {
                    }
                    cVar2 = new b.a.e0.p.c("4");
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
                    cVar2 = new b.a.e0.p.c("3");
                    cVar2.c(jSONObject2);
                }
                cVar = cVar2;
            } else {
                cVar = new b.a.e0.p.c("2");
            }
            if (cVar != null) {
                e(cVar);
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            f2674a = null;
            f2675b = null;
            f2678e = null;
            f2679f = null;
            f2680g = null;
            f2681h = null;
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
        b.a.e0.r.f.d(jSONArray.toString(), new File(l.a().getFilesDir(), "poly_cashier_statistics.json"));
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
                    b.a.e0.l.c cVar = new b.a.e0.l.c();
                    cVar.e(i.d(jSONObject.optJSONObject("header")));
                    b.a.e0.l.b bVar = new b.a.e0.l.b();
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
