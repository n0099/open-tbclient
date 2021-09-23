package c.a.p0.a.u.e.g;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.e2.c.j.b;
import c.a.p0.a.k;
import c.a.p0.a.v2.q0;
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
public class i extends c.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f8930g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public SwanAppWebPopWindow f8931d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.h0.g.l.a f8932e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.h0.g.d f8933f;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8934e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f8935f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8936g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i f8937h;

        public a(i iVar, String str, c.a.p0.a.a2.e eVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, eVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8937h = iVar;
            this.f8934e = str;
            this.f8935f = eVar;
            this.f8936g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.e2.c.d.h(iVar)) {
                    this.f8937h.C(this.f8935f, this.f8936g, this.f8934e);
                } else {
                    this.f8937h.d(this.f8934e, new c.a.p0.a.u.h.b(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8938e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f8939f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8940g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8941h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f8942i;

        /* loaded from: classes.dex */
        public class a extends c.a.p0.a.h0.g.l.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f8943a;

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
                this.f8943a = bVar;
            }

            @Override // c.a.p0.a.h0.g.l.a, c.a.p0.a.h0.g.l.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    super.a();
                    c.a.p0.a.e0.d.g("Api-WebPopWindow", "swanId=" + this.f8943a.f8939f.f4566f + ", nowId=" + c.a.p0.a.a2.e.V());
                    if (TextUtils.equals(this.f8943a.f8939f.f4566f, c.a.p0.a.a2.e.V())) {
                        return;
                    }
                    this.f8943a.f8942i.B();
                }
            }

            @Override // c.a.p0.a.h0.g.l.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c.a.p0.a.e0.d.g("Api-WebPopWindow", "call onFragmentDestroyed");
                    this.f8943a.f8942i.B();
                    if (this.f8943a.f8942i.f8933f == null || this.f8943a.f8942i.f8932e == null) {
                        return;
                    }
                    this.f8943a.f8942i.f8933f.D2(this.f8943a.f8942i.f8932e);
                }
            }
        }

        public b(i iVar, String str, c.a.p0.a.a2.e eVar, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, eVar, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8942i = iVar;
            this.f8938e = str;
            this.f8939f = eVar;
            this.f8940g = str2;
            this.f8941h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = c.a.p0.a.g1.f.V().getActivity()) == null) {
                return;
            }
            if (this.f8942i.f8931d != null && this.f8942i.f8931d.x()) {
                this.f8942i.d(this.f8938e, new c.a.p0.a.u.h.b(303, "execute failed, halfScreenWebview is showing"));
                return;
            }
            c.a.p0.a.h0.g.g W = c.a.p0.a.g1.f.V().W();
            if (W == null) {
                return;
            }
            this.f8942i.f8933f = W.m();
            if (this.f8942i.f8933f == null) {
                return;
            }
            if (this.f8942i.f8932e != null) {
                this.f8942i.f8933f.D2(this.f8942i.f8932e);
            }
            this.f8942i.f8932e = new a(this);
            this.f8942i.f8933f.f2(this.f8942i.f8932e);
            i iVar = this.f8942i;
            SwanAppWebPopWindow swanAppWebPopWindow = new SwanAppWebPopWindow(activity, this.f8940g);
            swanAppWebPopWindow.z0(c.a.p0.a.h.swan_app_baidu_guarantee_title);
            iVar.f8931d = swanAppWebPopWindow;
            if (TextUtils.equals(this.f8941h, "protect")) {
                SwanAppWebPopWindow swanAppWebPopWindow2 = this.f8942i.f8931d;
                swanAppWebPopWindow2.v0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
                swanAppWebPopWindow2.w0();
            }
            SwanAppWebPopWindow swanAppWebPopWindow3 = this.f8942i.f8931d;
            swanAppWebPopWindow3.u0();
            swanAppWebPopWindow3.B0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", 0);
            } catch (JSONException e2) {
                if (i.f8930g) {
                    e2.printStackTrace();
                }
            }
            this.f8942i.d(this.f8938e, new c.a.p0.a.u.h.b(0, "show halfScreenWebview success", jSONObject));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1123262933, "Lc/a/p0/a/u/e/g/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1123262933, "Lc/a/p0/a/u/e/g/i;");
                return;
            }
        }
        f8930g = k.f7085a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NonNull c.a.p0.a.u.c.b bVar) {
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

    public final void A(c.a.p0.a.a2.e eVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, eVar, str, str2) == null) {
            if (TextUtils.equals(str, "protect")) {
                eVar.T().g(i(), "scope_web_window_pay_protected", new a(this, str2, eVar, str));
            } else {
                d(str2, new c.a.p0.a.u.h.b(202, "type is invalid"));
            }
        }
    }

    public final void B() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f8933f.e0() && (swanAppWebPopWindow = this.f8931d) != null) {
            swanAppWebPopWindow.r();
        }
    }

    public final void C(c.a.p0.a.a2.e eVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, str, str2) == null) {
            String D = D(eVar, str);
            if (D == null) {
                d(str2, new c.a.p0.a.u.h.b(202, "type is invalid"));
            } else {
                q0.b0(new b(this, str2, eVar, D, str));
            }
        }
    }

    public final String D(c.a.p0.a.a2.e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eVar, str)) == null) {
            if (!TextUtils.equals(str, "protect") || eVar == null) {
                return null;
            }
            return "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + eVar.D();
        }
        return (String) invokeLL.objValue;
    }

    public c.a.p0.a.u.h.b E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (f8930g) {
                String str2 = "start show web pop window action, params =" + str;
            }
            c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
            if (Q == null) {
                return new c.a.p0.a.u.h.b(202, "swanApp is null");
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> a2 = c.a.p0.a.u.i.b.a(str);
            JSONObject jSONObject = (JSONObject) a2.second;
            if (((c.a.p0.a.u.h.b) a2.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.p0.a.u.h.b(202, "type is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new c.a.p0.a.u.h.b(202, "cb is invalid");
                }
                A(Q, optString, optString2);
                return new c.a.p0.a.u.h.b(0);
            }
            return new c.a.p0.a.u.h.b(202);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }
}
