package c.a.n0.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.e.i;
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
    public static class a extends c.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4262f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4263g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4264h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f4265i;

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
            this.f4262f = i2;
            this.f4263g = i3;
            this.f4264h = str;
            this.f4265i = context;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4262f);
                    jSONObject.put("1", System.currentTimeMillis());
                    jSONObject.put("2", this.f4263g);
                    jSONObject.put("3", this.f4264h);
                    jSONObject.put("4", "1");
                    jSONArray.put(jSONObject);
                    c.a.n0.h.b.c(this.f4265i).f(jSONArray.toString(), "1077112", 2);
                } catch (Throwable th) {
                    c.a.n0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4266f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4267g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4268h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4269i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4270j;

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
            this.f4266f = i2;
            this.f4267g = context;
            this.f4268h = i3;
            this.f4269i = i4;
            this.f4270j = str;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4266f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int Z = c.a.n0.b.a.h(this.f4267g).Z();
                    if (Z != -1) {
                        jSONObject.put("4", Z);
                    }
                    jSONObject.put("5", c.a.n0.b.a.h(this.f4267g).a0());
                    jSONObject.put("7", this.f4268h);
                    if (this.f4269i != -1) {
                        jSONObject.put("8", this.f4269i);
                    }
                    jSONObject.put("9", this.f4270j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.q);
                    jSONObject.put("12", "1");
                    new c.a.n0.f.d(this.f4267g, null).h(jSONObject);
                } catch (Throwable th) {
                    c.a.n0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends c.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4271f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4272g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4273h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4274i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4275j;

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
            this.f4271f = i2;
            this.f4272g = context;
            this.f4273h = i3;
            this.f4274i = i4;
            this.f4275j = str;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4271f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int d0 = c.a.n0.b.a.h(this.f4272g).d0();
                    if (d0 != -1) {
                        jSONObject.put("4", d0);
                    }
                    jSONObject.put("5", c.a.n0.b.a.h(this.f4272g).e0());
                    jSONObject.put("7", this.f4273h);
                    if (this.f4274i != -1) {
                        jSONObject.put("8", this.f4274i);
                    }
                    jSONObject.put("9", this.f4275j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.r);
                    jSONObject.put("12", "1");
                    jSONArray.put(jSONObject);
                    c.a.n0.h.b.c(this.f4272g).f(jSONArray.toString(), "1077122", 2);
                } catch (Throwable th) {
                    c.a.n0.l.c.d(th);
                }
            }
        }
    }

    /* renamed from: c.a.n0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0108d extends c.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4276f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4277g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4278h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4279i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f4280j;
        public final /* synthetic */ Context k;

        public C0108d(int i2, int i3, String str, int i4, int i5, Context context) {
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
            this.f4276f = i2;
            this.f4277g = i3;
            this.f4278h = str;
            this.f4279i = i4;
            this.f4280j = i5;
            this.k = context;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f4279i);
                    jSONObject.put("2", this.f4276f);
                    if (this.f4277g != -1) {
                        jSONObject.put("3", this.f4277g);
                    }
                    if (!TextUtils.isEmpty(this.f4278h)) {
                        jSONObject.put("4", this.f4278h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.q);
                    jSONObject.put("7", this.f4280j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.n0.h.b.c(this.k).f(jSONArray.toString(), "1077105", 2);
                } catch (Throwable th) {
                    c.a.n0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends c.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4281f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4282g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4283h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4284i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f4285j;
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
            this.f4281f = i2;
            this.f4282g = i3;
            this.f4283h = str;
            this.f4284i = i4;
            this.f4285j = i5;
            this.k = context;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f4284i);
                    jSONObject.put("2", this.f4281f);
                    if (this.f4282g != -1) {
                        jSONObject.put("3", this.f4282g);
                    }
                    if (!TextUtils.isEmpty(this.f4283h)) {
                        jSONObject.put("4", this.f4283h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.r);
                    jSONObject.put("7", this.f4285j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.n0.h.b.c(this.k).f(jSONArray.toString(), "1077123", 2);
                } catch (Throwable th) {
                    c.a.n0.l.c.d(th);
                }
            }
        }
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            c.a.n0.k.e.c().b(new C0108d(i4, i5, str, i2, i3, context));
        }
    }

    public static void b(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            c.a.n0.k.e.c().b(new c(i2, context, i4, i3, str));
        }
    }

    public static void c(Context context, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            c.a.n0.k.e.c().b(new a(i2, i3, str, context));
        }
    }

    public static void d(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            c.a.n0.k.e.c().b(new e(i4, i5, str, i2, i3, context));
        }
    }

    public static void e(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            c.a.n0.k.e.c().b(new b(i2, context, i4, i3, str));
        }
    }
}
