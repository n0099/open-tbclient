package c.a.p0.a.u.e.f;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.h2.c.j.b;
import c.a.p0.a.k;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends c.a.p0.a.u.e.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f8221i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public SwanAppWebPopWindow f8222f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.a.h0.g.m.a f8223g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.a.h0.g.d f8224h;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8225e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.d2.e f8226f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8227g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ j f8228h;

        public a(j jVar, String str, c.a.p0.a.d2.e eVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, str, eVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8228h = jVar;
            this.f8225e = str;
            this.f8226f = eVar;
            this.f8227g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.h2.c.d.h(iVar)) {
                    this.f8228h.I(this.f8226f, this.f8227g, this.f8225e);
                } else {
                    this.f8228h.d(this.f8225e, new c.a.p0.a.u.h.b(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8229e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.d2.e f8230f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8231g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8232h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ j f8233i;

        /* loaded from: classes.dex */
        public class a extends c.a.p0.a.h0.g.m.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // c.a.p0.a.h0.g.m.a, c.a.p0.a.h0.g.m.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    super.b();
                    c.a.p0.a.e0.d.i("WebPopWindowApi", "swanId=" + this.a.f8230f.f4616f + ", nowId=" + c.a.p0.a.d2.e.f0());
                    if (TextUtils.equals(this.a.f8230f.f4616f, c.a.p0.a.d2.e.f0())) {
                        return;
                    }
                    this.a.f8233i.H();
                }
            }

            @Override // c.a.p0.a.h0.g.m.a, c.a.p0.a.h0.g.m.b
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c.a.p0.a.e0.d.i("WebPopWindowApi", "call onFragmentDestroyed");
                    this.a.f8233i.H();
                    if (this.a.f8233i.f8224h == null || this.a.f8233i.f8223g == null) {
                        return;
                    }
                    this.a.f8233i.f8224h.S2(this.a.f8233i.f8223g);
                }
            }
        }

        public b(j jVar, String str, c.a.p0.a.d2.e eVar, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, str, eVar, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8233i = jVar;
            this.f8229e = str;
            this.f8230f = eVar;
            this.f8231g = str2;
            this.f8232h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = c.a.p0.a.g1.f.U().getActivity()) == null) {
                return;
            }
            if (this.f8233i.f8222f != null && this.f8233i.f8222f.x()) {
                this.f8233i.d(this.f8229e, new c.a.p0.a.u.h.b(303, "execute failed, halfScreenWebview is showing"));
                return;
            }
            c.a.p0.a.h0.g.g V = c.a.p0.a.g1.f.U().V();
            if (V == null) {
                return;
            }
            this.f8233i.f8224h = V.m();
            if (this.f8233i.f8224h == null) {
                return;
            }
            if (this.f8233i.f8223g != null) {
                this.f8233i.f8224h.S2(this.f8233i.f8223g);
            }
            this.f8233i.f8223g = new a(this);
            this.f8233i.f8224h.o2(this.f8233i.f8223g);
            j jVar = this.f8233i;
            SwanAppWebPopWindow swanAppWebPopWindow = new SwanAppWebPopWindow(activity, this.f8231g);
            swanAppWebPopWindow.x0(c.a.p0.a.h.swan_app_baidu_guarantee_title);
            jVar.f8222f = swanAppWebPopWindow;
            if (TextUtils.equals(this.f8232h, "protect")) {
                SwanAppWebPopWindow swanAppWebPopWindow2 = this.f8233i.f8222f;
                swanAppWebPopWindow2.t0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
                swanAppWebPopWindow2.u0();
            }
            SwanAppWebPopWindow swanAppWebPopWindow3 = this.f8233i.f8222f;
            swanAppWebPopWindow3.s0();
            swanAppWebPopWindow3.z0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", 0);
            } catch (JSONException e2) {
                if (j.f8221i) {
                    e2.printStackTrace();
                }
            }
            this.f8233i.d(this.f8229e, new c.a.p0.a.u.h.b(0, "show halfScreenWebview success", jSONObject));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1123233173, "Lc/a/p0/a/u/e/f/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1123233173, "Lc/a/p0/a/u/e/f/j;");
                return;
            }
        }
        f8221i = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NonNull c.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void G(c.a.p0.a.d2.e eVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, eVar, str, str2) == null) {
            if (TextUtils.equals(str, "protect")) {
                eVar.d0().g(getContext(), "scope_web_window_pay_protected", new a(this, str2, eVar, str));
            } else {
                d(str2, new c.a.p0.a.u.h.b(202, "type is invalid"));
            }
        }
    }

    public final void H() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f8224h.i0() && (swanAppWebPopWindow = this.f8222f) != null) {
            swanAppWebPopWindow.r();
        }
    }

    public final void I(c.a.p0.a.d2.e eVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, str, str2) == null) {
            String J = J(eVar, str);
            if (J == null) {
                d(str2, new c.a.p0.a.u.h.b(202, "type is invalid"));
            } else {
                q0.e0(new b(this, str2, eVar, J, str));
            }
        }
    }

    public final String J(c.a.p0.a.d2.e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eVar, str)) == null) {
            if (!TextUtils.equals(str, "protect") || eVar == null) {
                return null;
            }
            return "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + eVar.N();
        }
        return (String) invokeLL.objValue;
    }

    public c.a.p0.a.u.h.b K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#showHalfScreenWebview", false);
            if (f8221i) {
                String str2 = "#showHalfScreenWebview params=" + str;
            }
            c.a.p0.a.d2.e a0 = c.a.p0.a.d2.e.a0();
            if (a0 == null) {
                return new c.a.p0.a.u.h.b(202, "swan app is null");
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((c.a.p0.a.u.h.b) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.p0.a.u.h.b(202, "type is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new c.a.p0.a.u.h.b(202, "cb is invalid");
                }
                G(a0, optString, optString2);
                return c.a.p0.a.u.h.b.f();
            }
            return new c.a.p0.a.u.h.b(202);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "WebPopWindowApi" : (String) invokeV.objValue;
    }
}
