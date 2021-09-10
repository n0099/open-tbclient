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
        public final /* synthetic */ int f4255f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4256g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4257h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f4258i;

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
            this.f4255f = i2;
            this.f4256g = i3;
            this.f4257h = str;
            this.f4258i = context;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4255f);
                    jSONObject.put("1", System.currentTimeMillis());
                    jSONObject.put("2", this.f4256g);
                    jSONObject.put("3", this.f4257h);
                    jSONObject.put("4", "1");
                    jSONArray.put(jSONObject);
                    c.a.n0.h.b.c(this.f4258i).f(jSONArray.toString(), "1077112", 2);
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
        public final /* synthetic */ int f4259f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4260g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4261h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4262i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4263j;

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
            this.f4259f = i2;
            this.f4260g = context;
            this.f4261h = i3;
            this.f4262i = i4;
            this.f4263j = str;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4259f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int Z = c.a.n0.b.a.h(this.f4260g).Z();
                    if (Z != -1) {
                        jSONObject.put("4", Z);
                    }
                    jSONObject.put("5", c.a.n0.b.a.h(this.f4260g).a0());
                    jSONObject.put("7", this.f4261h);
                    if (this.f4262i != -1) {
                        jSONObject.put("8", this.f4262i);
                    }
                    jSONObject.put("9", this.f4263j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.q);
                    jSONObject.put("12", "1");
                    new c.a.n0.f.d(this.f4260g, null).h(jSONObject);
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
        public final /* synthetic */ int f4264f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4265g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4266h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4267i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4268j;

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
            this.f4264f = i2;
            this.f4265g = context;
            this.f4266h = i3;
            this.f4267i = i4;
            this.f4268j = str;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4264f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int d0 = c.a.n0.b.a.h(this.f4265g).d0();
                    if (d0 != -1) {
                        jSONObject.put("4", d0);
                    }
                    jSONObject.put("5", c.a.n0.b.a.h(this.f4265g).e0());
                    jSONObject.put("7", this.f4266h);
                    if (this.f4267i != -1) {
                        jSONObject.put("8", this.f4267i);
                    }
                    jSONObject.put("9", this.f4268j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.r);
                    jSONObject.put("12", "1");
                    jSONArray.put(jSONObject);
                    c.a.n0.h.b.c(this.f4265g).f(jSONArray.toString(), "1077122", 2);
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
        public final /* synthetic */ int f4269f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4270g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4271h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4272i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f4273j;
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
            this.f4269f = i2;
            this.f4270g = i3;
            this.f4271h = str;
            this.f4272i = i4;
            this.f4273j = i5;
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
                    jSONObject.put("1", this.f4272i);
                    jSONObject.put("2", this.f4269f);
                    if (this.f4270g != -1) {
                        jSONObject.put("3", this.f4270g);
                    }
                    if (!TextUtils.isEmpty(this.f4271h)) {
                        jSONObject.put("4", this.f4271h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.q);
                    jSONObject.put("7", this.f4273j);
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
        public final /* synthetic */ int f4274f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4275g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4276h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4277i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f4278j;
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
            this.f4274f = i2;
            this.f4275g = i3;
            this.f4276h = str;
            this.f4277i = i4;
            this.f4278j = i5;
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
                    jSONObject.put("1", this.f4277i);
                    jSONObject.put("2", this.f4274f);
                    if (this.f4275g != -1) {
                        jSONObject.put("3", this.f4275g);
                    }
                    if (!TextUtils.isEmpty(this.f4276h)) {
                        jSONObject.put("4", this.f4276h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.r);
                    jSONObject.put("7", this.f4278j);
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
