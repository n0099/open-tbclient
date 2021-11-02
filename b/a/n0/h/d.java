package b.a.n0.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.n0.e.i;
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
    public static class a extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3667f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3668g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f3669h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f3670i;

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
            this.f3667f = i2;
            this.f3668g = i3;
            this.f3669h = str;
            this.f3670i = context;
        }

        @Override // b.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f3667f);
                    jSONObject.put("1", System.currentTimeMillis());
                    jSONObject.put("2", this.f3668g);
                    jSONObject.put("3", this.f3669h);
                    jSONObject.put("4", "1");
                    jSONArray.put(jSONObject);
                    b.a.n0.h.b.c(this.f3670i).f(jSONArray.toString(), "1077112", 2);
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3671f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f3672g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f3673h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f3674i;
        public final /* synthetic */ String j;

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
            this.f3671f = i2;
            this.f3672g = context;
            this.f3673h = i3;
            this.f3674i = i4;
            this.j = str;
        }

        @Override // b.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f3671f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int Z = b.a.n0.b.a.h(this.f3672g).Z();
                    if (Z != -1) {
                        jSONObject.put("4", Z);
                    }
                    jSONObject.put("5", b.a.n0.b.a.h(this.f3672g).a0());
                    jSONObject.put("7", this.f3673h);
                    if (this.f3674i != -1) {
                        jSONObject.put("8", this.f3674i);
                    }
                    jSONObject.put("9", this.j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.q);
                    jSONObject.put("12", "1");
                    new b.a.n0.f.d(this.f3672g, null).h(jSONObject);
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3675f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f3676g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f3677h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f3678i;
        public final /* synthetic */ String j;

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
            this.f3675f = i2;
            this.f3676g = context;
            this.f3677h = i3;
            this.f3678i = i4;
            this.j = str;
        }

        @Override // b.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f3675f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int d0 = b.a.n0.b.a.h(this.f3676g).d0();
                    if (d0 != -1) {
                        jSONObject.put("4", d0);
                    }
                    jSONObject.put("5", b.a.n0.b.a.h(this.f3676g).e0());
                    jSONObject.put("7", this.f3677h);
                    if (this.f3678i != -1) {
                        jSONObject.put("8", this.f3678i);
                    }
                    jSONObject.put("9", this.j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.r);
                    jSONObject.put("12", "1");
                    jSONArray.put(jSONObject);
                    b.a.n0.h.b.c(this.f3676g).f(jSONArray.toString(), "1077122", 2);
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                }
            }
        }
    }

    /* renamed from: b.a.n0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0103d extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3679f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3680g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f3681h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f3682i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public C0103d(int i2, int i3, String str, int i4, int i5, Context context) {
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
            this.f3679f = i2;
            this.f3680g = i3;
            this.f3681h = str;
            this.f3682i = i4;
            this.j = i5;
            this.k = context;
        }

        @Override // b.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f3682i);
                    jSONObject.put("2", this.f3679f);
                    if (this.f3680g != -1) {
                        jSONObject.put("3", this.f3680g);
                    }
                    if (!TextUtils.isEmpty(this.f3681h)) {
                        jSONObject.put("4", this.f3681h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.q);
                    jSONObject.put("7", this.j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    b.a.n0.h.b.c(this.k).f(jSONArray.toString(), "1077105", 2);
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3683f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3684g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f3685h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f3686i;
        public final /* synthetic */ int j;
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
            this.f3683f = i2;
            this.f3684g = i3;
            this.f3685h = str;
            this.f3686i = i4;
            this.j = i5;
            this.k = context;
        }

        @Override // b.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f3686i);
                    jSONObject.put("2", this.f3683f);
                    if (this.f3684g != -1) {
                        jSONObject.put("3", this.f3684g);
                    }
                    if (!TextUtils.isEmpty(this.f3685h)) {
                        jSONObject.put("4", this.f3685h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.r);
                    jSONObject.put("7", this.j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    b.a.n0.h.b.c(this.k).f(jSONArray.toString(), "1077123", 2);
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                }
            }
        }
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            b.a.n0.k.e.c().b(new C0103d(i4, i5, str, i2, i3, context));
        }
    }

    public static void b(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            b.a.n0.k.e.c().b(new c(i2, context, i4, i3, str));
        }
    }

    public static void c(Context context, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            b.a.n0.k.e.c().b(new a(i2, i3, str, context));
        }
    }

    public static void d(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            b.a.n0.k.e.c().b(new e(i4, i5, str, i2, i3, context));
        }
    }

    public static void e(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            b.a.n0.k.e.c().b(new b(i2, context, i4, i3, str));
        }
    }
}
