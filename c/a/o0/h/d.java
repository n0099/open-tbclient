package c.a.o0.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.e.i;
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
    public static class a extends c.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4331f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4332g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4333h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f4334i;

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
            this.f4331f = i2;
            this.f4332g = i3;
            this.f4333h = str;
            this.f4334i = context;
        }

        @Override // c.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4331f);
                    jSONObject.put("1", System.currentTimeMillis());
                    jSONObject.put("2", this.f4332g);
                    jSONObject.put("3", this.f4333h);
                    jSONObject.put("4", "1");
                    jSONArray.put(jSONObject);
                    c.a.o0.h.b.c(this.f4334i).f(jSONArray.toString(), "1077112", 2);
                } catch (Throwable th) {
                    c.a.o0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4335f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4336g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4337h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4338i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4339j;

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
            this.f4335f = i2;
            this.f4336g = context;
            this.f4337h = i3;
            this.f4338i = i4;
            this.f4339j = str;
        }

        @Override // c.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4335f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int Z = c.a.o0.b.a.h(this.f4336g).Z();
                    if (Z != -1) {
                        jSONObject.put("4", Z);
                    }
                    jSONObject.put("5", c.a.o0.b.a.h(this.f4336g).a0());
                    jSONObject.put("7", this.f4337h);
                    if (this.f4338i != -1) {
                        jSONObject.put("8", this.f4338i);
                    }
                    jSONObject.put("9", this.f4339j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.q);
                    jSONObject.put("12", "1");
                    new c.a.o0.f.d(this.f4336g, null).h(jSONObject);
                } catch (Throwable th) {
                    c.a.o0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends c.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4340f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4341g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4342h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4343i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4344j;

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
            this.f4340f = i2;
            this.f4341g = context;
            this.f4342h = i3;
            this.f4343i = i4;
            this.f4344j = str;
        }

        @Override // c.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4340f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int d0 = c.a.o0.b.a.h(this.f4341g).d0();
                    if (d0 != -1) {
                        jSONObject.put("4", d0);
                    }
                    jSONObject.put("5", c.a.o0.b.a.h(this.f4341g).e0());
                    jSONObject.put("7", this.f4342h);
                    if (this.f4343i != -1) {
                        jSONObject.put("8", this.f4343i);
                    }
                    jSONObject.put("9", this.f4344j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.r);
                    jSONObject.put("12", "1");
                    jSONArray.put(jSONObject);
                    c.a.o0.h.b.c(this.f4341g).f(jSONArray.toString(), "1077122", 2);
                } catch (Throwable th) {
                    c.a.o0.l.c.d(th);
                }
            }
        }
    }

    /* renamed from: c.a.o0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0195d extends c.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4345f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4346g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4347h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4348i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f4349j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ Context f4350k;

        public C0195d(int i2, int i3, String str, int i4, int i5, Context context) {
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
            this.f4345f = i2;
            this.f4346g = i3;
            this.f4347h = str;
            this.f4348i = i4;
            this.f4349j = i5;
            this.f4350k = context;
        }

        @Override // c.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f4348i);
                    jSONObject.put("2", this.f4345f);
                    if (this.f4346g != -1) {
                        jSONObject.put("3", this.f4346g);
                    }
                    if (!TextUtils.isEmpty(this.f4347h)) {
                        jSONObject.put("4", this.f4347h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.q);
                    jSONObject.put("7", this.f4349j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.o0.h.b.c(this.f4350k).f(jSONArray.toString(), "1077105", 2);
                } catch (Throwable th) {
                    c.a.o0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends c.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4351f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4352g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4353h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4354i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f4355j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ Context f4356k;

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
            this.f4351f = i2;
            this.f4352g = i3;
            this.f4353h = str;
            this.f4354i = i4;
            this.f4355j = i5;
            this.f4356k = context;
        }

        @Override // c.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f4354i);
                    jSONObject.put("2", this.f4351f);
                    if (this.f4352g != -1) {
                        jSONObject.put("3", this.f4352g);
                    }
                    if (!TextUtils.isEmpty(this.f4353h)) {
                        jSONObject.put("4", this.f4353h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.r);
                    jSONObject.put("7", this.f4355j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.o0.h.b.c(this.f4356k).f(jSONArray.toString(), "1077123", 2);
                } catch (Throwable th) {
                    c.a.o0.l.c.d(th);
                }
            }
        }
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            c.a.o0.k.e.c().b(new C0195d(i4, i5, str, i2, i3, context));
        }
    }

    public static void b(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            c.a.o0.k.e.c().b(new c(i2, context, i4, i3, str));
        }
    }

    public static void c(Context context, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            c.a.o0.k.e.c().b(new a(i2, i3, str, context));
        }
    }

    public static void d(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            c.a.o0.k.e.c().b(new e(i4, i5, str, i2, i3, context));
        }
    }

    public static void e(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            c.a.o0.k.e.c().b(new b(i2, context, i4, i3, str));
        }
    }
}
