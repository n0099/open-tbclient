package c.a.r0.a.u.e.f;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.r0.a.h2.c.j.b;
import c.a.r0.a.k;
import c.a.r0.a.z2.q0;
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
public class j extends c.a.r0.a.u.e.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f9063i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public SwanAppWebPopWindow f9064f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.a.h0.g.m.a f9065g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.a.h0.g.d f9066h;

    /* loaded from: classes.dex */
    public class a implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9067e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f9068f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9069g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ j f9070h;

        public a(j jVar, String str, c.a.r0.a.d2.e eVar, String str2) {
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
            this.f9070h = jVar;
            this.f9067e = str;
            this.f9068f = eVar;
            this.f9069g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.r0.a.h2.c.d.h(iVar)) {
                    this.f9070h.I(this.f9068f, this.f9069g, this.f9067e);
                } else {
                    this.f9070h.d(this.f9067e, new c.a.r0.a.u.h.b(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9071e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f9072f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9073g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9074h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ j f9075i;

        /* loaded from: classes.dex */
        public class a extends c.a.r0.a.h0.g.m.a {
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

            @Override // c.a.r0.a.h0.g.m.a, c.a.r0.a.h0.g.m.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    super.b();
                    c.a.r0.a.e0.d.i("WebPopWindowApi", "swanId=" + this.a.f9072f.f5537f + ", nowId=" + c.a.r0.a.d2.e.f0());
                    if (TextUtils.equals(this.a.f9072f.f5537f, c.a.r0.a.d2.e.f0())) {
                        return;
                    }
                    this.a.f9075i.H();
                }
            }

            @Override // c.a.r0.a.h0.g.m.a, c.a.r0.a.h0.g.m.b
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c.a.r0.a.e0.d.i("WebPopWindowApi", "call onFragmentDestroyed");
                    this.a.f9075i.H();
                    if (this.a.f9075i.f9066h == null || this.a.f9075i.f9065g == null) {
                        return;
                    }
                    this.a.f9075i.f9066h.L2(this.a.f9075i.f9065g);
                }
            }
        }

        public b(j jVar, String str, c.a.r0.a.d2.e eVar, String str2, String str3) {
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
            this.f9075i = jVar;
            this.f9071e = str;
            this.f9072f = eVar;
            this.f9073g = str2;
            this.f9074h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = c.a.r0.a.g1.f.U().getActivity()) == null) {
                return;
            }
            if (this.f9075i.f9064f != null && this.f9075i.f9064f.x()) {
                this.f9075i.d(this.f9071e, new c.a.r0.a.u.h.b(303, "execute failed, halfScreenWebview is showing"));
                return;
            }
            c.a.r0.a.h0.g.g V = c.a.r0.a.g1.f.U().V();
            if (V == null) {
                return;
            }
            this.f9075i.f9066h = V.m();
            if (this.f9075i.f9066h == null) {
                return;
            }
            if (this.f9075i.f9065g != null) {
                this.f9075i.f9066h.L2(this.f9075i.f9065g);
            }
            this.f9075i.f9065g = new a(this);
            this.f9075i.f9066h.h2(this.f9075i.f9065g);
            j jVar = this.f9075i;
            SwanAppWebPopWindow swanAppWebPopWindow = new SwanAppWebPopWindow(activity, this.f9073g);
            swanAppWebPopWindow.q0(c.a.r0.a.h.swan_app_baidu_guarantee_title);
            jVar.f9064f = swanAppWebPopWindow;
            if (TextUtils.equals(this.f9074h, "protect")) {
                SwanAppWebPopWindow swanAppWebPopWindow2 = this.f9075i.f9064f;
                swanAppWebPopWindow2.m0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
                swanAppWebPopWindow2.n0();
            }
            SwanAppWebPopWindow swanAppWebPopWindow3 = this.f9075i.f9064f;
            swanAppWebPopWindow3.l0();
            swanAppWebPopWindow3.s0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", 0);
            } catch (JSONException e2) {
                if (j.f9063i) {
                    e2.printStackTrace();
                }
            }
            this.f9075i.d(this.f9071e, new c.a.r0.a.u.h.b(0, "show halfScreenWebview success", jSONObject));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(536427159, "Lc/a/r0/a/u/e/f/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(536427159, "Lc/a/r0/a/u/e/f/j;");
                return;
            }
        }
        f9063i = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NonNull c.a.r0.a.u.c.b bVar) {
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
                super((c.a.r0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void G(c.a.r0.a.d2.e eVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, eVar, str, str2) == null) {
            if (TextUtils.equals(str, "protect")) {
                eVar.d0().g(getContext(), "scope_web_window_pay_protected", new a(this, str2, eVar, str));
            } else {
                d(str2, new c.a.r0.a.u.h.b(202, "type is invalid"));
            }
        }
    }

    public final void H() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f9066h.U() && (swanAppWebPopWindow = this.f9064f) != null) {
            swanAppWebPopWindow.r();
        }
    }

    public final void I(c.a.r0.a.d2.e eVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, str, str2) == null) {
            String J = J(eVar, str);
            if (J == null) {
                d(str2, new c.a.r0.a.u.h.b(202, "type is invalid"));
            } else {
                q0.e0(new b(this, str2, eVar, J, str));
            }
        }
    }

    public final String J(c.a.r0.a.d2.e eVar, String str) {
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

    public c.a.r0.a.u.h.b K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#showHalfScreenWebview", false);
            if (f9063i) {
                String str2 = "#showHalfScreenWebview params=" + str;
            }
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (a0 == null) {
                return new c.a.r0.a.u.h.b(202, "swan app is null");
            }
            Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((c.a.r0.a.u.h.b) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.r0.a.u.h.b(202, "type is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new c.a.r0.a.u.h.b(202, "cb is invalid");
                }
                G(a0, optString, optString2);
                return c.a.r0.a.u.h.b.f();
            }
            return new c.a.r0.a.u.h.b(202);
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.r0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "WebPopWindowApi" : (String) invokeV.objValue;
    }
}
