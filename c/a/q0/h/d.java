package c.a.q0.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.e.i;
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
    public static class a extends c.a.q0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4904f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4905g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4906h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f4907i;

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
            this.f4904f = i2;
            this.f4905g = i3;
            this.f4906h = str;
            this.f4907i = context;
        }

        @Override // c.a.q0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4904f);
                    jSONObject.put("1", System.currentTimeMillis());
                    jSONObject.put("2", this.f4905g);
                    jSONObject.put("3", this.f4906h);
                    jSONObject.put("4", "1");
                    jSONArray.put(jSONObject);
                    c.a.q0.h.b.c(this.f4907i).f(jSONArray.toString(), "1077112", 2);
                } catch (Throwable th) {
                    c.a.q0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a.q0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4908f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4909g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4910h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4911i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4912j;

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
            this.f4908f = i2;
            this.f4909g = context;
            this.f4910h = i3;
            this.f4911i = i4;
            this.f4912j = str;
        }

        @Override // c.a.q0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4908f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int Z = c.a.q0.b.a.h(this.f4909g).Z();
                    if (Z != -1) {
                        jSONObject.put("4", Z);
                    }
                    jSONObject.put("5", c.a.q0.b.a.h(this.f4909g).a0());
                    jSONObject.put("7", this.f4910h);
                    if (this.f4911i != -1) {
                        jSONObject.put("8", this.f4911i);
                    }
                    jSONObject.put("9", this.f4912j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.q);
                    jSONObject.put("12", "1");
                    new c.a.q0.f.d(this.f4909g, null).h(jSONObject);
                } catch (Throwable th) {
                    c.a.q0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends c.a.q0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4913f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4914g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4915h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4916i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4917j;

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
            this.f4913f = i2;
            this.f4914g = context;
            this.f4915h = i3;
            this.f4916i = i4;
            this.f4917j = str;
        }

        @Override // c.a.q0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f4913f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int d0 = c.a.q0.b.a.h(this.f4914g).d0();
                    if (d0 != -1) {
                        jSONObject.put("4", d0);
                    }
                    jSONObject.put("5", c.a.q0.b.a.h(this.f4914g).e0());
                    jSONObject.put("7", this.f4915h);
                    if (this.f4916i != -1) {
                        jSONObject.put("8", this.f4916i);
                    }
                    jSONObject.put("9", this.f4917j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.r);
                    jSONObject.put("12", "1");
                    jSONArray.put(jSONObject);
                    c.a.q0.h.b.c(this.f4914g).f(jSONArray.toString(), "1077122", 2);
                } catch (Throwable th) {
                    c.a.q0.l.c.d(th);
                }
            }
        }
    }

    /* renamed from: c.a.q0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0243d extends c.a.q0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4918f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4919g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4920h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4921i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f4922j;
        public final /* synthetic */ Context k;

        public C0243d(int i2, int i3, String str, int i4, int i5, Context context) {
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
            this.f4918f = i2;
            this.f4919g = i3;
            this.f4920h = str;
            this.f4921i = i4;
            this.f4922j = i5;
            this.k = context;
        }

        @Override // c.a.q0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f4921i);
                    jSONObject.put("2", this.f4918f);
                    if (this.f4919g != -1) {
                        jSONObject.put("3", this.f4919g);
                    }
                    if (!TextUtils.isEmpty(this.f4920h)) {
                        jSONObject.put("4", this.f4920h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.q);
                    jSONObject.put("7", this.f4922j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.q0.h.b.c(this.k).f(jSONArray.toString(), "1077105", 2);
                } catch (Throwable th) {
                    c.a.q0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends c.a.q0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4923f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4924g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4925h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4926i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f4927j;
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
            this.f4923f = i2;
            this.f4924g = i3;
            this.f4925h = str;
            this.f4926i = i4;
            this.f4927j = i5;
            this.k = context;
        }

        @Override // c.a.q0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f4926i);
                    jSONObject.put("2", this.f4923f);
                    if (this.f4924g != -1) {
                        jSONObject.put("3", this.f4924g);
                    }
                    if (!TextUtils.isEmpty(this.f4925h)) {
                        jSONObject.put("4", this.f4925h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.r);
                    jSONObject.put("7", this.f4927j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    c.a.q0.h.b.c(this.k).f(jSONArray.toString(), "1077123", 2);
                } catch (Throwable th) {
                    c.a.q0.l.c.d(th);
                }
            }
        }
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            c.a.q0.k.e.c().b(new C0243d(i4, i5, str, i2, i3, context));
        }
    }

    public static void b(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            c.a.q0.k.e.c().b(new c(i2, context, i4, i3, str));
        }
    }

    public static void c(Context context, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            c.a.q0.k.e.c().b(new a(i2, i3, str, context));
        }
    }

    public static void d(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            c.a.q0.k.e.c().b(new e(i4, i5, str, i2, i3, context));
        }
    }

    public static void e(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            c.a.q0.k.e.c().b(new b(i2, context, i4, i3, str));
        }
    }
}
