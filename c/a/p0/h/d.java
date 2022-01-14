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
        public final /* synthetic */ int f4687f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4688g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4689h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f4690i;

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
            this.f4687f = i2;
            this.f4688g = i3;
            this.f4689h = str;
            this.f4690i = context;
        }

        @Override // c.a.p0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4687f);
                    jSONObject.put("1", System.currentTimeMillis());
                    jSONObject.put("2", this.f4688g);
                    jSONObject.put("3", this.f4689h);
                    jSONObject.put("4", "1");
                    jSONArray.put(jSONObject);
                    c.a.p0.h.b.c(this.f4690i).f(jSONArray.toString(), "1077112", 2);
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
        public final /* synthetic */ int f4691f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4692g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4693h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4694i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4695j;

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
            this.f4691f = i2;
            this.f4692g = context;
            this.f4693h = i3;
            this.f4694i = i4;
            this.f4695j = str;
        }

        @Override // c.a.p0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4691f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int Z = c.a.p0.b.a.h(this.f4692g).Z();
                    if (Z != -1) {
                        jSONObject.put("4", Z);
                    }
                    jSONObject.put("5", c.a.p0.b.a.h(this.f4692g).a0());
                    jSONObject.put("7", this.f4693h);
                    if (this.f4694i != -1) {
                        jSONObject.put("8", this.f4694i);
                    }
                    jSONObject.put("9", this.f4695j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.q);
                    jSONObject.put("12", "1");
                    new c.a.p0.f.d(this.f4692g, null).h(jSONObject);
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
        public final /* synthetic */ int f4696f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4697g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4698h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4699i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4700j;

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
            this.f4696f = i2;
            this.f4697g = context;
            this.f4698h = i3;
            this.f4699i = i4;
            this.f4700j = str;
        }

        @Override // c.a.p0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4696f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int d0 = c.a.p0.b.a.h(this.f4697g).d0();
                    if (d0 != -1) {
                        jSONObject.put("4", d0);
                    }
                    jSONObject.put("5", c.a.p0.b.a.h(this.f4697g).e0());
                    jSONObject.put("7", this.f4698h);
                    if (this.f4699i != -1) {
                        jSONObject.put("8", this.f4699i);
                    }
                    jSONObject.put("9", this.f4700j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.r);
                    jSONObject.put("12", "1");
                    jSONArray.put(jSONObject);
                    c.a.p0.h.b.c(this.f4697g).f(jSONArray.toString(), "1077122", 2);
                } catch (Throwable th) {
                    c.a.p0.l.c.d(th);
                }
            }
        }
    }

    /* renamed from: c.a.p0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0228d extends c.a.p0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4701f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4702g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4703h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4704i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f4705j;
        public final /* synthetic */ Context k;

        public C0228d(int i2, int i3, String str, int i4, int i5, Context context) {
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
            this.f4701f = i2;
            this.f4702g = i3;
            this.f4703h = str;
            this.f4704i = i4;
            this.f4705j = i5;
            this.k = context;
        }

        @Override // c.a.p0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f4704i);
                    jSONObject.put("2", this.f4701f);
                    if (this.f4702g != -1) {
                        jSONObject.put("3", this.f4702g);
                    }
                    if (!TextUtils.isEmpty(this.f4703h)) {
                        jSONObject.put("4", this.f4703h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.q);
                    jSONObject.put("7", this.f4705j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.p0.h.b.c(this.k).f(jSONArray.toString(), "1077105", 2);
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
        public final /* synthetic */ int f4706f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4707g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4708h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4709i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f4710j;
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
            this.f4706f = i2;
            this.f4707g = i3;
            this.f4708h = str;
            this.f4709i = i4;
            this.f4710j = i5;
            this.k = context;
        }

        @Override // c.a.p0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f4709i);
                    jSONObject.put("2", this.f4706f);
                    if (this.f4707g != -1) {
                        jSONObject.put("3", this.f4707g);
                    }
                    if (!TextUtils.isEmpty(this.f4708h)) {
                        jSONObject.put("4", this.f4708h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.r);
                    jSONObject.put("7", this.f4710j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.p0.h.b.c(this.k).f(jSONArray.toString(), "1077123", 2);
                } catch (Throwable th) {
                    c.a.p0.l.c.d(th);
                }
            }
        }
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            c.a.p0.k.e.c().b(new C0228d(i4, i5, str, i2, i3, context));
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
