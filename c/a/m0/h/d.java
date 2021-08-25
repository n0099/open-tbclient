package c.a.m0.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.m0.e.i;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends c.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4235f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4236g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4237h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f4238i;

        public a(int i2, int i3, String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4235f = i2;
            this.f4236g = i3;
            this.f4237h = str;
            this.f4238i = context;
        }

        @Override // c.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4235f);
                    jSONObject.put("1", System.currentTimeMillis());
                    jSONObject.put("2", this.f4236g);
                    jSONObject.put("3", this.f4237h);
                    jSONObject.put("4", "1");
                    jSONArray.put(jSONObject);
                    c.a.m0.h.b.c(this.f4238i).f(jSONArray.toString(), "1077112", 2);
                } catch (Throwable th) {
                    c.a.m0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4239f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4240g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4241h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4242i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4243j;

        public b(int i2, Context context, int i3, int i4, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), context, Integer.valueOf(i3), Integer.valueOf(i4), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4239f = i2;
            this.f4240g = context;
            this.f4241h = i3;
            this.f4242i = i4;
            this.f4243j = str;
        }

        @Override // c.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4239f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int Z = c.a.m0.b.a.h(this.f4240g).Z();
                    if (Z != -1) {
                        jSONObject.put("4", Z);
                    }
                    jSONObject.put("5", c.a.m0.b.a.h(this.f4240g).a0());
                    jSONObject.put("7", this.f4241h);
                    if (this.f4242i != -1) {
                        jSONObject.put("8", this.f4242i);
                    }
                    jSONObject.put("9", this.f4243j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.q);
                    jSONObject.put("12", "1");
                    new c.a.m0.f.d(this.f4240g, null).h(jSONObject);
                } catch (Throwable th) {
                    c.a.m0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends c.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4244f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4245g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4246h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4247i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4248j;

        public c(int i2, Context context, int i3, int i4, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), context, Integer.valueOf(i3), Integer.valueOf(i4), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4244f = i2;
            this.f4245g = context;
            this.f4246h = i3;
            this.f4247i = i4;
            this.f4248j = str;
        }

        @Override // c.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4244f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int d0 = c.a.m0.b.a.h(this.f4245g).d0();
                    if (d0 != -1) {
                        jSONObject.put("4", d0);
                    }
                    jSONObject.put("5", c.a.m0.b.a.h(this.f4245g).e0());
                    jSONObject.put("7", this.f4246h);
                    if (this.f4247i != -1) {
                        jSONObject.put("8", this.f4247i);
                    }
                    jSONObject.put("9", this.f4248j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.r);
                    jSONObject.put("12", "1");
                    jSONArray.put(jSONObject);
                    c.a.m0.h.b.c(this.f4245g).f(jSONArray.toString(), "1077122", 2);
                } catch (Throwable th) {
                    c.a.m0.l.c.d(th);
                }
            }
        }
    }

    /* renamed from: c.a.m0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0107d extends c.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4249f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4250g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4251h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4252i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f4253j;
        public final /* synthetic */ Context k;

        public C0107d(int i2, int i3, String str, int i4, int i5, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4249f = i2;
            this.f4250g = i3;
            this.f4251h = str;
            this.f4252i = i4;
            this.f4253j = i5;
            this.k = context;
        }

        @Override // c.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f4252i);
                    jSONObject.put("2", this.f4249f);
                    if (this.f4250g != -1) {
                        jSONObject.put("3", this.f4250g);
                    }
                    if (!TextUtils.isEmpty(this.f4251h)) {
                        jSONObject.put("4", this.f4251h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.q);
                    jSONObject.put("7", this.f4253j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.m0.h.b.c(this.k).f(jSONArray.toString(), "1077105", 2);
                } catch (Throwable th) {
                    c.a.m0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends c.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4254f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4255g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4256h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4257i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f4258j;
        public final /* synthetic */ Context k;

        public e(int i2, int i3, String str, int i4, int i5, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4254f = i2;
            this.f4255g = i3;
            this.f4256h = str;
            this.f4257i = i4;
            this.f4258j = i5;
            this.k = context;
        }

        @Override // c.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f4257i);
                    jSONObject.put("2", this.f4254f);
                    if (this.f4255g != -1) {
                        jSONObject.put("3", this.f4255g);
                    }
                    if (!TextUtils.isEmpty(this.f4256h)) {
                        jSONObject.put("4", this.f4256h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.r);
                    jSONObject.put("7", this.f4258j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.m0.h.b.c(this.k).f(jSONArray.toString(), "1077123", 2);
                } catch (Throwable th) {
                    c.a.m0.l.c.d(th);
                }
            }
        }
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            c.a.m0.k.e.c().b(new C0107d(i4, i5, str, i2, i3, context));
        }
    }

    public static void b(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            c.a.m0.k.e.c().b(new c(i2, context, i4, i3, str));
        }
    }

    public static void c(Context context, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            c.a.m0.k.e.c().b(new a(i2, i3, str, context));
        }
    }

    public static void d(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            c.a.m0.k.e.c().b(new e(i4, i5, str, i2, i3, context));
        }
    }

    public static void e(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            c.a.m0.k.e.c().b(new b(i2, context, i4, i3, str));
        }
    }
}
