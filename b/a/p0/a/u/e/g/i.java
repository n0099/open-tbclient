package b.a.p0.a.u.e.g;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.k;
import b.a.p0.a.v2.q0;
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
public class i extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f8188g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public SwanAppWebPopWindow f8189d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.a.h0.g.l.a f8190e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.a.h0.g.d f8191f;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8192e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f8193f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8194g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i f8195h;

        public a(i iVar, String str, b.a.p0.a.a2.e eVar, String str2) {
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
            this.f8195h = iVar;
            this.f8192e = str;
            this.f8193f = eVar;
            this.f8194g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    this.f8195h.B(this.f8193f, this.f8194g, this.f8192e);
                } else {
                    this.f8195h.d(this.f8192e, new b.a.p0.a.u.h.b(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8196e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f8197f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8198g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8199h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f8200i;

        /* loaded from: classes.dex */
        public class a extends b.a.p0.a.h0.g.l.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f8201a;

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
                this.f8201a = bVar;
            }

            @Override // b.a.p0.a.h0.g.l.a, b.a.p0.a.h0.g.l.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    super.a();
                    b.a.p0.a.e0.d.g("Api-WebPopWindow", "swanId=" + this.f8201a.f8197f.f3961f + ", nowId=" + b.a.p0.a.a2.e.U());
                    if (TextUtils.equals(this.f8201a.f8197f.f3961f, b.a.p0.a.a2.e.U())) {
                        return;
                    }
                    this.f8201a.f8200i.A();
                }
            }

            @Override // b.a.p0.a.h0.g.l.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    b.a.p0.a.e0.d.g("Api-WebPopWindow", "call onFragmentDestroyed");
                    this.f8201a.f8200i.A();
                    if (this.f8201a.f8200i.f8191f == null || this.f8201a.f8200i.f8190e == null) {
                        return;
                    }
                    this.f8201a.f8200i.f8191f.z2(this.f8201a.f8200i.f8190e);
                }
            }
        }

        public b(i iVar, String str, b.a.p0.a.a2.e eVar, String str2, String str3) {
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
            this.f8200i = iVar;
            this.f8196e = str;
            this.f8197f = eVar;
            this.f8198g = str2;
            this.f8199h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = b.a.p0.a.g1.f.T().getActivity()) == null) {
                return;
            }
            if (this.f8200i.f8189d != null && this.f8200i.f8189d.x()) {
                this.f8200i.d(this.f8196e, new b.a.p0.a.u.h.b(303, "execute failed, halfScreenWebview is showing"));
                return;
            }
            b.a.p0.a.h0.g.g U = b.a.p0.a.g1.f.T().U();
            if (U == null) {
                return;
            }
            this.f8200i.f8191f = U.m();
            if (this.f8200i.f8191f == null) {
                return;
            }
            if (this.f8200i.f8190e != null) {
                this.f8200i.f8191f.z2(this.f8200i.f8190e);
            }
            this.f8200i.f8190e = new a(this);
            this.f8200i.f8191f.b2(this.f8200i.f8190e);
            i iVar = this.f8200i;
            SwanAppWebPopWindow swanAppWebPopWindow = new SwanAppWebPopWindow(activity, this.f8198g);
            swanAppWebPopWindow.x0(b.a.p0.a.h.swan_app_baidu_guarantee_title);
            iVar.f8189d = swanAppWebPopWindow;
            if (TextUtils.equals(this.f8199h, "protect")) {
                SwanAppWebPopWindow swanAppWebPopWindow2 = this.f8200i.f8189d;
                swanAppWebPopWindow2.t0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
                swanAppWebPopWindow2.u0();
            }
            SwanAppWebPopWindow swanAppWebPopWindow3 = this.f8200i.f8189d;
            swanAppWebPopWindow3.s0();
            swanAppWebPopWindow3.z0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", 0);
            } catch (JSONException e2) {
                if (i.f8188g) {
                    e2.printStackTrace();
                }
            }
            this.f8200i.d(this.f8196e, new b.a.p0.a.u.h.b(0, "show halfScreenWebview success", jSONObject));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-230046764, "Lb/a/p0/a/u/e/g/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-230046764, "Lb/a/p0/a/u/e/g/i;");
                return;
            }
        }
        f8188g = k.f6397a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void A() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f8191f.a0() && (swanAppWebPopWindow = this.f8189d) != null) {
            swanAppWebPopWindow.r();
        }
    }

    public final void B(b.a.p0.a.a2.e eVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, str, str2) == null) {
            String C = C(eVar, str);
            if (C == null) {
                d(str2, new b.a.p0.a.u.h.b(202, "type is invalid"));
            } else {
                q0.b0(new b(this, str2, eVar, C, str));
            }
        }
    }

    public final String C(b.a.p0.a.a2.e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, eVar, str)) == null) {
            if (!TextUtils.equals(str, "protect") || eVar == null) {
                return null;
            }
            return "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + eVar.k();
        }
        return (String) invokeLL.objValue;
    }

    public b.a.p0.a.u.h.b D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (f8188g) {
                String str2 = "start show web pop window action, params =" + str;
            }
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P == null) {
                return new b.a.p0.a.u.h.b(202, "swanApp is null");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> a2 = b.a.p0.a.u.i.b.a(str);
            JSONObject jSONObject = (JSONObject) a2.second;
            if (((b.a.p0.a.u.h.b) a2.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new b.a.p0.a.u.h.b(202, "type is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new b.a.p0.a.u.h.b(202, "cb is invalid");
                }
                z(P, optString, optString2);
                return new b.a.p0.a.u.h.b(0);
            }
            return new b.a.p0.a.u.h.b(202);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void z(b.a.p0.a.a2.e eVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, eVar, str, str2) == null) {
            if (TextUtils.equals(str, "protect")) {
                eVar.S().g(getContext(), "scope_web_window_pay_protected", new a(this, str2, eVar, str));
            } else {
                d(str2, new b.a.p0.a.u.h.b(202, "type is invalid"));
            }
        }
    }
}
