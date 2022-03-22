package c.a.l0.i;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
    public static class a extends c.a.l0.l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3649b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3650c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f3651d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f3652e;

        public a(int i, int i2, String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3649b = i;
            this.f3650c = i2;
            this.f3651d = str;
            this.f3652e = context;
        }

        @Override // c.a.l0.l.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f3649b);
                    jSONObject.put("1", System.currentTimeMillis());
                    jSONObject.put("2", this.f3650c);
                    jSONObject.put("3", this.f3651d);
                    jSONObject.put("4", "1");
                    jSONArray.put(jSONObject);
                    c.a.l0.i.b.c(this.f3652e).f(jSONArray.toString(), "1077112", 2);
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a.l0.l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3653b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f3654c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f3655d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f3656e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f3657f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f3658g;

        public b(int i, long j, int i2, int i3, String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3653b = i;
            this.f3654c = j;
            this.f3655d = i2;
            this.f3656e = i3;
            this.f3657f = str;
            this.f3658g = context;
        }

        @Override // c.a.l0.l.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = "";
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f3653b);
                    jSONObject.put("1", "");
                    jSONObject.put("2", Build.VERSION.SDK_INT);
                    jSONObject.put("3", this.f3654c);
                    jSONObject.put("4", this.f3655d);
                    jSONObject.put("5", this.f3656e);
                    if (!TextUtils.isEmpty(this.f3657f)) {
                        str = this.f3657f;
                    }
                    jSONObject.put("6", str);
                    jSONArray.put(jSONObject);
                    c.a.l0.i.b.c(this.f3658g).f(jSONArray.toString(), "1077128", 2);
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends c.a.l0.l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3659b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f3660c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f3661d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f3662e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f3663f;

        public c(int i, Context context, int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), context, Integer.valueOf(i2), Integer.valueOf(i3), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3659b = i;
            this.f3660c = context;
            this.f3661d = i2;
            this.f3662e = i3;
            this.f3663f = str;
        }

        @Override // c.a.l0.l.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f3659b);
                    jSONObject.put("3", System.currentTimeMillis());
                    int Z = c.a.l0.b.a.f(this.f3660c).Z();
                    if (Z != -1) {
                        jSONObject.put("4", Z);
                    }
                    jSONObject.put("5", c.a.l0.b.a.f(this.f3660c).a0());
                    jSONObject.put("7", this.f3661d);
                    if (this.f3662e != -1) {
                        jSONObject.put("8", this.f3662e);
                    }
                    jSONObject.put("9", this.f3663f);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", c.a.l0.d.d.q);
                    jSONObject.put("12", "1");
                    new c.a.l0.g.c(this.f3660c, null).h(jSONObject);
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                }
            }
        }
    }

    /* renamed from: c.a.l0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0203d extends c.a.l0.l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3664b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f3665c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f3666d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f3667e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f3668f;

        public C0203d(int i, Context context, int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), context, Integer.valueOf(i2), Integer.valueOf(i3), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3664b = i;
            this.f3665c = context;
            this.f3666d = i2;
            this.f3667e = i3;
            this.f3668f = str;
        }

        @Override // c.a.l0.l.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f3664b);
                    jSONObject.put("3", System.currentTimeMillis());
                    int d0 = c.a.l0.b.a.f(this.f3665c).d0();
                    if (d0 != -1) {
                        jSONObject.put("4", d0);
                    }
                    jSONObject.put("5", c.a.l0.b.a.f(this.f3665c).e0());
                    jSONObject.put("7", this.f3666d);
                    if (this.f3667e != -1) {
                        jSONObject.put("8", this.f3667e);
                    }
                    jSONObject.put("9", this.f3668f);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", c.a.l0.d.d.r);
                    jSONObject.put("12", "1");
                    jSONArray.put(jSONObject);
                    c.a.l0.i.b.c(this.f3665c).f(jSONArray.toString(), "1077122", 2);
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends c.a.l0.l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3669b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3670c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f3671d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f3672e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3673f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f3674g;

        public e(int i, int i2, String str, int i3, int i4, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3669b = i;
            this.f3670c = i2;
            this.f3671d = str;
            this.f3672e = i3;
            this.f3673f = i4;
            this.f3674g = context;
        }

        @Override // c.a.l0.l.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f3672e);
                    jSONObject.put("2", this.f3669b);
                    if (this.f3670c != -1) {
                        jSONObject.put("3", this.f3670c);
                    }
                    if (!TextUtils.isEmpty(this.f3671d)) {
                        jSONObject.put("4", this.f3671d);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", c.a.l0.d.d.q);
                    jSONObject.put("7", this.f3673f);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.l0.i.b.c(this.f3674g).f(jSONArray.toString(), "1077105", 2);
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f extends c.a.l0.l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3675b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3676c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f3677d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f3678e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3679f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f3680g;

        public f(int i, int i2, String str, int i3, int i4, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3675b = i;
            this.f3676c = i2;
            this.f3677d = str;
            this.f3678e = i3;
            this.f3679f = i4;
            this.f3680g = context;
        }

        @Override // c.a.l0.l.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f3678e);
                    jSONObject.put("2", this.f3675b);
                    if (this.f3676c != -1) {
                        jSONObject.put("3", this.f3676c);
                    }
                    if (!TextUtils.isEmpty(this.f3677d)) {
                        jSONObject.put("4", this.f3677d);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", c.a.l0.d.d.r);
                    jSONObject.put("7", this.f3679f);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.l0.i.b.c(this.f3680g).f(jSONArray.toString(), "1077123", 2);
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                }
            }
        }
    }

    public static void a(Context context, int i, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            c.a.l0.l.e.c().b(new e(i3, i4, str, i, i2, context));
        }
    }

    public static void b(Context context, int i, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            c.a.l0.l.e.c().b(new c(i, context, i3, i2, str));
        }
    }

    public static void c(Context context, int i, int i2, long j, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), str}) == null) {
            c.a.l0.l.e.c().b(new b(i, j, i3, i2, str, context));
        }
    }

    public static void d(Context context, int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
            c.a.l0.l.e.c().b(new a(i, i2, str, context));
        }
    }

    public static void e(Context context, int i, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            c.a.l0.l.e.c().b(new f(i3, i4, str, i, i2, context));
        }
    }

    public static void f(Context context, int i, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            c.a.l0.l.e.c().b(new C0203d(i, context, i3, i2, str));
        }
    }
}
