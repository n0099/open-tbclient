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
        public final /* synthetic */ int f4022f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4023g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4024h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f4025i;

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
            this.f4022f = i2;
            this.f4023g = i3;
            this.f4024h = str;
            this.f4025i = context;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4022f);
                    jSONObject.put("1", System.currentTimeMillis());
                    jSONObject.put("2", this.f4023g);
                    jSONObject.put("3", this.f4024h);
                    jSONObject.put("4", "1");
                    jSONArray.put(jSONObject);
                    c.a.n0.h.b.c(this.f4025i).f(jSONArray.toString(), "1077112", 2);
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
        public final /* synthetic */ int f4026f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4027g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4028h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4029i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4030j;

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
            this.f4026f = i2;
            this.f4027g = context;
            this.f4028h = i3;
            this.f4029i = i4;
            this.f4030j = str;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4026f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int Z = c.a.n0.b.a.h(this.f4027g).Z();
                    if (Z != -1) {
                        jSONObject.put("4", Z);
                    }
                    jSONObject.put("5", c.a.n0.b.a.h(this.f4027g).a0());
                    jSONObject.put("7", this.f4028h);
                    if (this.f4029i != -1) {
                        jSONObject.put("8", this.f4029i);
                    }
                    jSONObject.put("9", this.f4030j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.q);
                    jSONObject.put("12", "1");
                    new c.a.n0.f.d(this.f4027g, null).h(jSONObject);
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
        public final /* synthetic */ int f4031f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4032g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4033h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4034i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4035j;

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
            this.f4031f = i2;
            this.f4032g = context;
            this.f4033h = i3;
            this.f4034i = i4;
            this.f4035j = str;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4031f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int d0 = c.a.n0.b.a.h(this.f4032g).d0();
                    if (d0 != -1) {
                        jSONObject.put("4", d0);
                    }
                    jSONObject.put("5", c.a.n0.b.a.h(this.f4032g).e0());
                    jSONObject.put("7", this.f4033h);
                    if (this.f4034i != -1) {
                        jSONObject.put("8", this.f4034i);
                    }
                    jSONObject.put("9", this.f4035j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.r);
                    jSONObject.put("12", "1");
                    jSONArray.put(jSONObject);
                    c.a.n0.h.b.c(this.f4032g).f(jSONArray.toString(), "1077122", 2);
                } catch (Throwable th) {
                    c.a.n0.l.c.d(th);
                }
            }
        }
    }

    /* renamed from: c.a.n0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0161d extends c.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4036f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4037g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4038h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4039i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f4040j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ Context f4041k;

        public C0161d(int i2, int i3, String str, int i4, int i5, Context context) {
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
            this.f4036f = i2;
            this.f4037g = i3;
            this.f4038h = str;
            this.f4039i = i4;
            this.f4040j = i5;
            this.f4041k = context;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f4039i);
                    jSONObject.put("2", this.f4036f);
                    if (this.f4037g != -1) {
                        jSONObject.put("3", this.f4037g);
                    }
                    if (!TextUtils.isEmpty(this.f4038h)) {
                        jSONObject.put("4", this.f4038h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.q);
                    jSONObject.put("7", this.f4040j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.n0.h.b.c(this.f4041k).f(jSONArray.toString(), "1077105", 2);
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
        public final /* synthetic */ int f4042f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4043g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4044h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4045i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f4046j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ Context f4047k;

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
            this.f4042f = i2;
            this.f4043g = i3;
            this.f4044h = str;
            this.f4045i = i4;
            this.f4046j = i5;
            this.f4047k = context;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f4045i);
                    jSONObject.put("2", this.f4042f);
                    if (this.f4043g != -1) {
                        jSONObject.put("3", this.f4043g);
                    }
                    if (!TextUtils.isEmpty(this.f4044h)) {
                        jSONObject.put("4", this.f4044h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.r);
                    jSONObject.put("7", this.f4046j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.n0.h.b.c(this.f4047k).f(jSONArray.toString(), "1077123", 2);
                } catch (Throwable th) {
                    c.a.n0.l.c.d(th);
                }
            }
        }
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            c.a.n0.k.e.c().b(new C0161d(i4, i5, str, i2, i3, context));
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
