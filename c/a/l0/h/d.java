package c.a.l0.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.l0.e.i;
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
    public static class a extends c.a.l0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3833f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3834g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f3835h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f3836i;

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
            this.f3833f = i2;
            this.f3834g = i3;
            this.f3835h = str;
            this.f3836i = context;
        }

        @Override // c.a.l0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f3833f);
                    jSONObject.put("1", System.currentTimeMillis());
                    jSONObject.put("2", this.f3834g);
                    jSONObject.put("3", this.f3835h);
                    jSONObject.put("4", "1");
                    jSONArray.put(jSONObject);
                    c.a.l0.h.b.c(this.f3836i).f(jSONArray.toString(), "1077112", 2);
                } catch (Throwable th) {
                    c.a.l0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a.l0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3837f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f3838g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f3839h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f3840i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f3841j;

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
            this.f3837f = i2;
            this.f3838g = context;
            this.f3839h = i3;
            this.f3840i = i4;
            this.f3841j = str;
        }

        @Override // c.a.l0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f3837f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int Z = c.a.l0.b.a.h(this.f3838g).Z();
                    if (Z != -1) {
                        jSONObject.put("4", Z);
                    }
                    jSONObject.put("5", c.a.l0.b.a.h(this.f3838g).a0());
                    jSONObject.put("7", this.f3839h);
                    if (this.f3840i != -1) {
                        jSONObject.put("8", this.f3840i);
                    }
                    jSONObject.put("9", this.f3841j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.q);
                    jSONObject.put("12", "1");
                    new c.a.l0.f.d(this.f3838g, null).h(jSONObject);
                } catch (Throwable th) {
                    c.a.l0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends c.a.l0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3842f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f3843g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f3844h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f3845i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f3846j;

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
            this.f3842f = i2;
            this.f3843g = context;
            this.f3844h = i3;
            this.f3845i = i4;
            this.f3846j = str;
        }

        @Override // c.a.l0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f3842f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int d0 = c.a.l0.b.a.h(this.f3843g).d0();
                    if (d0 != -1) {
                        jSONObject.put("4", d0);
                    }
                    jSONObject.put("5", c.a.l0.b.a.h(this.f3843g).e0());
                    jSONObject.put("7", this.f3844h);
                    if (this.f3845i != -1) {
                        jSONObject.put("8", this.f3845i);
                    }
                    jSONObject.put("9", this.f3846j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.r);
                    jSONObject.put("12", "1");
                    jSONArray.put(jSONObject);
                    c.a.l0.h.b.c(this.f3843g).f(jSONArray.toString(), "1077122", 2);
                } catch (Throwable th) {
                    c.a.l0.l.c.d(th);
                }
            }
        }
    }

    /* renamed from: c.a.l0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0095d extends c.a.l0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3847f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3848g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f3849h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f3850i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f3851j;
        public final /* synthetic */ Context k;

        public C0095d(int i2, int i3, String str, int i4, int i5, Context context) {
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
            this.f3847f = i2;
            this.f3848g = i3;
            this.f3849h = str;
            this.f3850i = i4;
            this.f3851j = i5;
            this.k = context;
        }

        @Override // c.a.l0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f3850i);
                    jSONObject.put("2", this.f3847f);
                    if (this.f3848g != -1) {
                        jSONObject.put("3", this.f3848g);
                    }
                    if (!TextUtils.isEmpty(this.f3849h)) {
                        jSONObject.put("4", this.f3849h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.q);
                    jSONObject.put("7", this.f3851j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.l0.h.b.c(this.k).f(jSONArray.toString(), "1077105", 2);
                } catch (Throwable th) {
                    c.a.l0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends c.a.l0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3852f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3853g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f3854h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f3855i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f3856j;
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
            this.f3852f = i2;
            this.f3853g = i3;
            this.f3854h = str;
            this.f3855i = i4;
            this.f3856j = i5;
            this.k = context;
        }

        @Override // c.a.l0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f3855i);
                    jSONObject.put("2", this.f3852f);
                    if (this.f3853g != -1) {
                        jSONObject.put("3", this.f3853g);
                    }
                    if (!TextUtils.isEmpty(this.f3854h)) {
                        jSONObject.put("4", this.f3854h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.r);
                    jSONObject.put("7", this.f3856j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.l0.h.b.c(this.k).f(jSONArray.toString(), "1077123", 2);
                } catch (Throwable th) {
                    c.a.l0.l.c.d(th);
                }
            }
        }
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            c.a.l0.k.e.c().b(new C0095d(i4, i5, str, i2, i3, context));
        }
    }

    public static void b(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            c.a.l0.k.e.c().b(new c(i2, context, i4, i3, str));
        }
    }

    public static void c(Context context, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            c.a.l0.k.e.c().b(new a(i2, i3, str, context));
        }
    }

    public static void d(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            c.a.l0.k.e.c().b(new e(i4, i5, str, i2, i3, context));
        }
    }

    public static void e(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            c.a.l0.k.e.c().b(new b(i2, context, i4, i3, str));
        }
    }
}
