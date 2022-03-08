package c.a.f0.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.f0.i.h;
import c.a.f0.i.i;
import c.a.f0.i.j;
import c.a.f0.i.l;
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
import com.google.android.exoplayer2.text.ttml.TtmlNode;
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
    public static String f3344b;

    /* renamed from: c  reason: collision with root package name */
    public static String f3345c;

    /* renamed from: d  reason: collision with root package name */
    public static String f3346d;

    /* renamed from: e  reason: collision with root package name */
    public static String f3347e;

    /* renamed from: f  reason: collision with root package name */
    public static String f3348f;

    /* renamed from: g  reason: collision with root package name */
    public static String f3349g;

    /* renamed from: h  reason: collision with root package name */
    public static String f3350h;

    /* renamed from: i  reason: collision with root package name */
    public static List<c.a.f0.g.c> f3351i;

    /* renamed from: j  reason: collision with root package name */
    public static Object f3352j;
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
    public static class b extends c.a.f0.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.f0.c.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.f0.c.b f3353b;

        public b(c.a.f0.c.c cVar, c.a.f0.c.b bVar) {
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
            this.f3353b = bVar;
        }

        @Override // c.a.f0.c.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                f.l(this.a.b(), this.f3353b.b());
                e.g().h();
            }
        }

        @Override // c.a.f0.c.a
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends c.a.f0.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONArray f3354b;

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
            this.f3354b = jSONArray;
        }

        @Override // c.a.f0.c.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f3354b.put(this.a);
                h.g("localObject" + this.a);
            }
        }

        @Override // c.a.f0.c.a
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1599693692, "Lc/a/f0/g/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1599693692, "Lc/a/f0/g/f;");
                return;
            }
        }
        f3352j = new Object();
    }

    public static void c() {
        List<c.a.f0.g.c> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || (list = f3351i) == null) {
            return;
        }
        list.clear();
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (f.class) {
                List<c.a.f0.g.c> list = f3351i;
                if (list != null && !list.isEmpty()) {
                    c.a.f0.c.b g2 = g();
                    synchronized (f3352j) {
                        JSONArray jSONArray = new JSONArray();
                        for (c.a.f0.g.c cVar : f3351i) {
                            JSONObject d2 = cVar.d();
                            if (d2 != null) {
                                jSONArray.put(d2);
                            }
                        }
                        g2.d("data", jSONArray.toString());
                        g2.d("s", HttpSigner.a(g2, "key", c.a.f0.c.h.a.a()));
                        c();
                    }
                    c.a.f0.c.c h2 = h();
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

    public static void e(c.a.f0.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, cVar) == null) {
            if (f3351i == null) {
                f3351i = new ArrayList();
            }
            if (cVar != null) {
                synchronized (f3352j) {
                    f3351i.add(cVar);
                }
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            c.a.f0.h.a.a(new a());
        }
    }

    public static c.a.f0.c.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            c.a.f0.c.b bVar = new c.a.f0.c.b();
            bVar.d(x.B, "cashier");
            bVar.d(UrlOcrConfig.IdCardKey.OS, "android");
            bVar.d("v", "2.8.7.9");
            if (!TextUtils.isEmpty(f3349g)) {
                bVar.d("n", f3349g);
            }
            String b2 = c.a.f0.c.h.c.b();
            if (!TextUtils.isEmpty(b2)) {
                bVar.d("nv", b2);
            }
            if (!TextUtils.isEmpty(f3350h)) {
                bVar.d("ss", f3350h);
            }
            if (!TextUtils.isEmpty(f3344b)) {
                bVar.d("d", f3344b);
            }
            if (!TextUtils.isEmpty(f3347e)) {
                bVar.d("dt", f3347e);
            }
            if (!TextUtils.isEmpty(f3348f)) {
                bVar.d(x.w, f3348f);
            }
            if (!TextUtils.isEmpty(f3345c)) {
                bVar.d(ContentUtil.RESULT_KEY_AK, f3345c);
            }
            if (!TextUtils.isEmpty(f3346d)) {
                bVar.d("dd", f3346d);
            }
            return bVar;
        }
        return (c.a.f0.c.b) invokeV.objValue;
    }

    public static c.a.f0.c.c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            c.a.f0.c.c cVar = new c.a.f0.c.c();
            if (!TextUtils.isEmpty(a)) {
                cVar.d("Cookie", "BDUSS=" + a);
            }
            return cVar;
        }
        return (c.a.f0.c.c) invokeV.objValue;
    }

    public static JSONArray i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            File file = new File(l.a().getFilesDir(), "poly_cashier_statistics.json");
            if (file.exists()) {
                try {
                    JSONArray jSONArray = new JSONArray(c.a.f0.i.f.b(file));
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
        c.a.f0.g.c cVar;
        c.a.f0.g.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65546, null, i2, str, str2) == null) {
            if (i2 != 0) {
                if (i2 == 2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("selects", c.a.f0.g.a.a);
                        c.a.f0.g.a.a = 0;
                        jSONObject.put("hbit", c.a.f0.g.a.f3331b);
                        c.a.f0.g.a.f3331b = "0";
                    } catch (JSONException unused) {
                    }
                    cVar2 = new c.a.f0.g.c("4");
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
                    cVar2 = new c.a.f0.g.c("3");
                    cVar2.c(jSONObject2);
                }
                cVar = cVar2;
            } else {
                cVar = new c.a.f0.g.c("2");
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
            f3344b = null;
            f3347e = null;
            f3348f = null;
            f3349g = null;
            f3350h = null;
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
                jSONObject.put(TtmlNode.TAG_BODY, b3);
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
        c.a.f0.i.f.d(jSONArray.toString(), new File(l.a().getFilesDir(), "poly_cashier_statistics.json"));
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
                    c.a.f0.c.c cVar = new c.a.f0.c.c();
                    cVar.e(i.d(jSONObject.optJSONObject("header")));
                    c.a.f0.c.b bVar = new c.a.f0.c.b();
                    bVar.e(i.d(jSONObject.optJSONObject(TtmlNode.TAG_BODY)));
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
