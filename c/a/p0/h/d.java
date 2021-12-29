package c.a.p0.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.e.i;
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
    public static class a extends c.a.p0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4790f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4791g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4792h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f4793i;

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
            this.f4790f = i2;
            this.f4791g = i3;
            this.f4792h = str;
            this.f4793i = context;
        }

        @Override // c.a.p0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4790f);
                    jSONObject.put("1", System.currentTimeMillis());
                    jSONObject.put("2", this.f4791g);
                    jSONObject.put("3", this.f4792h);
                    jSONObject.put("4", "1");
                    jSONArray.put(jSONObject);
                    c.a.p0.h.b.c(this.f4793i).f(jSONArray.toString(), "1077112", 2);
                } catch (Throwable th) {
                    c.a.p0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a.p0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4794f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4795g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4796h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4797i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4798j;

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
            this.f4794f = i2;
            this.f4795g = context;
            this.f4796h = i3;
            this.f4797i = i4;
            this.f4798j = str;
        }

        @Override // c.a.p0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4794f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int Z = c.a.p0.b.a.h(this.f4795g).Z();
                    if (Z != -1) {
                        jSONObject.put("4", Z);
                    }
                    jSONObject.put("5", c.a.p0.b.a.h(this.f4795g).a0());
                    jSONObject.put("7", this.f4796h);
                    if (this.f4797i != -1) {
                        jSONObject.put("8", this.f4797i);
                    }
                    jSONObject.put("9", this.f4798j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.q);
                    jSONObject.put("12", "1");
                    new c.a.p0.f.d(this.f4795g, null).h(jSONObject);
                } catch (Throwable th) {
                    c.a.p0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends c.a.p0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4799f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4800g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4801h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4802i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4803j;

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
            this.f4799f = i2;
            this.f4800g = context;
            this.f4801h = i3;
            this.f4802i = i4;
            this.f4803j = str;
        }

        @Override // c.a.p0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4799f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int d0 = c.a.p0.b.a.h(this.f4800g).d0();
                    if (d0 != -1) {
                        jSONObject.put("4", d0);
                    }
                    jSONObject.put("5", c.a.p0.b.a.h(this.f4800g).e0());
                    jSONObject.put("7", this.f4801h);
                    if (this.f4802i != -1) {
                        jSONObject.put("8", this.f4802i);
                    }
                    jSONObject.put("9", this.f4803j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.r);
                    jSONObject.put("12", "1");
                    jSONArray.put(jSONObject);
                    c.a.p0.h.b.c(this.f4800g).f(jSONArray.toString(), "1077122", 2);
                } catch (Throwable th) {
                    c.a.p0.l.c.d(th);
                }
            }
        }
    }

    /* renamed from: c.a.p0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0219d extends c.a.p0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4804f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4805g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4806h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4807i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f4808j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ Context f4809k;

        public C0219d(int i2, int i3, String str, int i4, int i5, Context context) {
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
            this.f4804f = i2;
            this.f4805g = i3;
            this.f4806h = str;
            this.f4807i = i4;
            this.f4808j = i5;
            this.f4809k = context;
        }

        @Override // c.a.p0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f4807i);
                    jSONObject.put("2", this.f4804f);
                    if (this.f4805g != -1) {
                        jSONObject.put("3", this.f4805g);
                    }
                    if (!TextUtils.isEmpty(this.f4806h)) {
                        jSONObject.put("4", this.f4806h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.q);
                    jSONObject.put("7", this.f4808j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.p0.h.b.c(this.f4809k).f(jSONArray.toString(), "1077105", 2);
                } catch (Throwable th) {
                    c.a.p0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends c.a.p0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4810f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4811g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4812h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4813i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f4814j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ Context f4815k;

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
            this.f4810f = i2;
            this.f4811g = i3;
            this.f4812h = str;
            this.f4813i = i4;
            this.f4814j = i5;
            this.f4815k = context;
        }

        @Override // c.a.p0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f4813i);
                    jSONObject.put("2", this.f4810f);
                    if (this.f4811g != -1) {
                        jSONObject.put("3", this.f4811g);
                    }
                    if (!TextUtils.isEmpty(this.f4812h)) {
                        jSONObject.put("4", this.f4812h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.r);
                    jSONObject.put("7", this.f4814j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.p0.h.b.c(this.f4815k).f(jSONArray.toString(), "1077123", 2);
                } catch (Throwable th) {
                    c.a.p0.l.c.d(th);
                }
            }
        }
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            c.a.p0.k.e.c().b(new C0219d(i4, i5, str, i2, i3, context));
        }
    }

    public static void b(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            c.a.p0.k.e.c().b(new c(i2, context, i4, i3, str));
        }
    }

    public static void c(Context context, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            c.a.p0.k.e.c().b(new a(i2, i3, str, context));
        }
    }

    public static void d(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            c.a.p0.k.e.c().b(new e(i4, i5, str, i2, i3, context));
        }
    }

    public static void e(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            c.a.p0.k.e.c().b(new b(i2, context, i4, i3, str));
        }
    }
}
