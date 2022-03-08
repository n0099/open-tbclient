package c.a.p0.a.k.e.f;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.p2.q0;
import c.a.p0.a.x1.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import com.baidu.tieba.R;
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
public class j extends c.a.p0.a.k.e.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f6033i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public SwanAppWebPopWindow f6034f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.a.x.g.m.a f6035g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.a.x.g.d f6036h;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.p2.g1.c<c.a.p0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6037e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f6038f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6039g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ j f6040h;

        public a(j jVar, String str, c.a.p0.a.t1.e eVar, String str2) {
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
            this.f6040h = jVar;
            this.f6037e = str;
            this.f6038f = eVar;
            this.f6039g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.x1.c.d.h(iVar)) {
                    this.f6040h.I(this.f6038f, this.f6039g, this.f6037e);
                } else {
                    this.f6040h.d(this.f6037e, new c.a.p0.a.k.h.b(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6041e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f6042f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6043g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6044h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ j f6045i;

        /* loaded from: classes.dex */
        public class a extends c.a.p0.a.x.g.m.a {
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

            @Override // c.a.p0.a.x.g.m.a, c.a.p0.a.x.g.m.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    super.b();
                    c.a.p0.a.u.d.i("WebPopWindowApi", "swanId=" + this.a.f6042f.f7512f + ", nowId=" + c.a.p0.a.t1.e.f0());
                    if (TextUtils.equals(this.a.f6042f.f7512f, c.a.p0.a.t1.e.f0())) {
                        return;
                    }
                    this.a.f6045i.H();
                }
            }

            @Override // c.a.p0.a.x.g.m.a, c.a.p0.a.x.g.m.b
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c.a.p0.a.u.d.i("WebPopWindowApi", "call onFragmentDestroyed");
                    this.a.f6045i.H();
                    if (this.a.f6045i.f6036h == null || this.a.f6045i.f6035g == null) {
                        return;
                    }
                    this.a.f6045i.f6036h.L2(this.a.f6045i.f6035g);
                }
            }
        }

        public b(j jVar, String str, c.a.p0.a.t1.e eVar, String str2, String str3) {
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
            this.f6045i = jVar;
            this.f6041e = str;
            this.f6042f = eVar;
            this.f6043g = str2;
            this.f6044h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = c.a.p0.a.w0.f.U().getActivity()) == null) {
                return;
            }
            if (this.f6045i.f6034f != null && this.f6045i.f6034f.x()) {
                this.f6045i.d(this.f6041e, new c.a.p0.a.k.h.b(303, "execute failed, halfScreenWebview is showing"));
                return;
            }
            c.a.p0.a.x.g.g V = c.a.p0.a.w0.f.U().V();
            if (V == null) {
                return;
            }
            this.f6045i.f6036h = V.m();
            if (this.f6045i.f6036h == null) {
                return;
            }
            if (this.f6045i.f6035g != null) {
                this.f6045i.f6036h.L2(this.f6045i.f6035g);
            }
            this.f6045i.f6035g = new a(this);
            this.f6045i.f6036h.h2(this.f6045i.f6035g);
            j jVar = this.f6045i;
            SwanAppWebPopWindow swanAppWebPopWindow = new SwanAppWebPopWindow(activity, this.f6043g);
            swanAppWebPopWindow.q0(R.string.swan_app_baidu_guarantee_title);
            jVar.f6034f = swanAppWebPopWindow;
            if (TextUtils.equals(this.f6044h, "protect")) {
                SwanAppWebPopWindow swanAppWebPopWindow2 = this.f6045i.f6034f;
                swanAppWebPopWindow2.m0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
                swanAppWebPopWindow2.n0();
            }
            SwanAppWebPopWindow swanAppWebPopWindow3 = this.f6045i.f6034f;
            swanAppWebPopWindow3.l0();
            swanAppWebPopWindow3.s0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", 0);
            } catch (JSONException e2) {
                if (j.f6033i) {
                    e2.printStackTrace();
                }
            }
            this.f6045i.d(this.f6041e, new c.a.p0.a.k.h.b(0, "show halfScreenWebview success", jSONObject));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(874999007, "Lc/a/p0/a/k/e/f/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(874999007, "Lc/a/p0/a/k/e/f/j;");
                return;
            }
        }
        f6033i = c.a.p0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NonNull c.a.p0.a.k.c.b bVar) {
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
                super((c.a.p0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void G(c.a.p0.a.t1.e eVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, eVar, str, str2) == null) {
            if (TextUtils.equals(str, "protect")) {
                eVar.d0().g(getContext(), "scope_web_window_pay_protected", new a(this, str2, eVar, str));
            } else {
                d(str2, new c.a.p0.a.k.h.b(202, "type is invalid"));
            }
        }
    }

    public final void H() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f6036h.U() && (swanAppWebPopWindow = this.f6034f) != null) {
            swanAppWebPopWindow.r();
        }
    }

    public final void I(c.a.p0.a.t1.e eVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, str, str2) == null) {
            String J = J(eVar, str);
            if (J == null) {
                d(str2, new c.a.p0.a.k.h.b(202, "type is invalid"));
            } else {
                q0.e0(new b(this, str2, eVar, J, str));
            }
        }
    }

    public final String J(c.a.p0.a.t1.e eVar, String str) {
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

    public c.a.p0.a.k.h.b K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#showHalfScreenWebview", false);
            if (f6033i) {
                String str2 = "#showHalfScreenWebview params=" + str;
            }
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            if (a0 == null) {
                return new c.a.p0.a.k.h.b(202, "swan app is null");
            }
            Pair<c.a.p0.a.k.h.b, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((c.a.p0.a.k.h.b) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.p0.a.k.h.b(202, "type is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new c.a.p0.a.k.h.b(202, "cb is invalid");
                }
                G(a0, optString, optString2);
                return c.a.p0.a.k.h.b.f();
            }
            return new c.a.p0.a.k.h.b(202);
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "WebPopWindowApi" : (String) invokeV.objValue;
    }
}
