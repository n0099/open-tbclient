package c.a.s0.a.h2.d;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.h2.c.j.a;
import c.a.s0.a.h2.c.j.b;
import c.a.s0.a.k;
import c.a.s0.a.n2.n;
import c.a.s0.a.p.d.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public static final Map<String, a> q;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7427b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7428c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7429d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<c.a.s0.a.z2.g1.c<a>> f7430e;

    /* renamed from: f  reason: collision with root package name */
    public TaskState f7431f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f7432g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7433h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.s0.a.d2.e f7434i;

    /* renamed from: j  reason: collision with root package name */
    public final c.a.s0.a.u2.a f7435j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public final c.a.s0.a.z2.f1.a o;

    /* renamed from: c.a.s0.a.h2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0447a extends c.a.s0.a.z2.f1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7436f;

        public C0447a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7436f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7436f.H();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.s0.a.z2.g1.c<c.a.s0.a.h2.c.i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7437e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7437e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.s0.a.h2.c.i<JSONObject> iVar) {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar != null && iVar.c() && (jSONObject = iVar.a) != null) {
                    c.a.s0.a.e0.d.b("OpenData", "opendata=", jSONObject);
                    this.f7437e.f7435j.b(iVar.a.optInt("errno", 10001));
                    this.f7437e.f7435j.f(iVar.a.optString("errmsg", "internal error"));
                    if (0 != this.f7437e.f7435j.h()) {
                        c.a.s0.a.h2.c.d.k("by errno", Boolean.TRUE);
                        this.f7437e.f7435j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f7437e.A();
                        this.f7437e.y(10001);
                        return;
                    }
                    JSONObject optJSONObject = iVar.a.optJSONObject("data");
                    if (optJSONObject == null) {
                        c.a.s0.a.h2.c.d.k("by data parse", Boolean.TRUE);
                        this.f7437e.f7435j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f7437e.A();
                        this.f7437e.y(10001);
                        return;
                    }
                    c.a.s0.a.h2.c.f g2 = c.a.s0.a.h2.c.f.g(optJSONObject.optJSONObject("scope"));
                    if (g2 == null) {
                        c.a.s0.a.h2.c.d.k("illegal scope", Boolean.TRUE);
                        this.f7437e.f7435j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f7437e.A();
                        this.f7437e.y(10001);
                        return;
                    }
                    this.f7437e.f7432g = optJSONObject.optJSONObject("opendata");
                    if (!this.f7437e.f7429d && (i2 = g2.f7373j) < 0) {
                        if (i2 == -2) {
                            this.f7437e.f7435j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                        } else {
                            this.f7437e.f7435j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                            this.f7437e.z(10005, g2);
                        }
                        this.f7437e.A();
                        return;
                    } else if (g2.f7373j > 0) {
                        if (!this.f7437e.f7433h || !TextUtils.equals(g2.f7365b, "mobile") || (jSONObject2 = this.f7437e.f7432g) == null || jSONObject2.optInt("errno") != 1129) {
                            this.f7437e.A();
                            return;
                        } else {
                            this.f7437e.w(g2, false);
                            return;
                        }
                    } else if (!this.f7437e.f7434i.m0()) {
                        if (!this.f7437e.f7433h && g2.e()) {
                            if (!TextUtils.equals(g2.f7365b, "mobile") || SwanAppAllianceLoginHelper.f38889d.f()) {
                                this.f7437e.F();
                            } else {
                                this.f7437e.G();
                            }
                            n.T(this.f7437e.n, "phoneNumberLogin");
                            return;
                        } else if (TextUtils.equals(g2.f7365b, "mobile")) {
                            this.f7437e.v(g2);
                            return;
                        } else {
                            this.f7437e.K(g2);
                            return;
                        }
                    } else {
                        this.f7437e.f7435j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                        this.f7437e.A();
                        this.f7437e.z(10005, g2);
                        return;
                    }
                }
                c.a.s0.a.h2.c.d.k("bad MaOpenData response", Boolean.TRUE);
                this.f7437e.f7435j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                this.f7437e.A();
                this.f7437e.y(10001);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h2.c.f f7438b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f7439c;

        /* renamed from: c.a.s0.a.h2.d.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0448a implements n.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public C0448a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // c.a.s0.a.p.d.n.c
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    c.a.s0.a.e0.d.i("OpenData", "bindPhoneNumber check onSuccess isBind =" + z + ". needAuth = " + this.a.a);
                    if (z) {
                        this.a.f7439c.m = true;
                        this.a.f7439c.J();
                        return;
                    }
                    this.a.f7439c.f7435j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                    this.a.f7439c.A();
                }
            }

            @Override // c.a.s0.a.p.d.n.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c.a.s0.a.e0.d.i("OpenData", "bindPhoneNumber check onFail. needAuth = " + this.a.a);
                    c cVar = this.a;
                    if (cVar.a) {
                        cVar.f7439c.K(cVar.f7438b);
                    } else {
                        cVar.f7439c.A();
                    }
                }
            }
        }

        public c(a aVar, boolean z, c.a.s0.a.h2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z), fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7439c = aVar;
            this.a = z;
            this.f7438b = fVar;
        }

        @Override // c.a.s0.a.p.d.n.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.a.e0.d.i("OpenData", "bindPhoneNumber onFinish. needAuth = " + this.a);
                c.a.s0.a.c1.a.h0().g(new C0448a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.s0.a.h2.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.s0.a.h2.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.a.f7435j.b(LightappBusinessClient.SVC_ID_H5_TRANSERECORD);
                }
                this.a.I(z);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.s0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7440e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7440e = aVar;
        }

        @Override // c.a.s0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                c.a.s0.a.h2.c.d.k("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    c.a.s0.a.h2.c.d.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.f7440e.f7435j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f7440e.A();
                } else if (i2 != 0) {
                    c.a.s0.a.h2.c.d.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.f7440e.f7435j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f7440e.A();
                } else {
                    c.a.s0.a.h2.c.d.k("Login Preparation ok, is already login", Boolean.FALSE);
                    this.f7440e.f7433h = true;
                    this.f7440e.l = true;
                    this.f7440e.J();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.s0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7441e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7441e = aVar;
        }

        @Override // c.a.s0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                c.a.s0.a.h2.c.d.k("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    c.a.s0.a.h2.c.d.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.f7441e.f7435j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f7441e.A();
                } else if (i2 != 0) {
                    c.a.s0.a.h2.c.d.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.f7441e.f7435j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f7441e.A();
                } else {
                    c.a.s0.a.h2.c.d.k("Login Preparation ok, is already login", Boolean.FALSE);
                    this.f7441e.f7433h = true;
                    this.f7441e.J();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.s0.a.z2.g1.c<c.a.s0.a.h2.c.i<a.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f7442e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7443f;

        public g(a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7443f = aVar;
            this.f7442e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.s0.a.h2.c.i<a.b> iVar) {
            a.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!this.f7442e && !this.f7443f.k) {
                    this.f7443f.A();
                } else if (iVar != null && iVar.c() && (bVar = iVar.a) != null && bVar.f7408c != null) {
                    a aVar = this.f7443f;
                    aVar.f7432g = bVar.f7408c;
                    aVar.A();
                } else {
                    c.a.s0.a.u2.a aVar2 = this.f7443f.f7435j;
                    aVar2.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                    aVar2.f("bad Accredit response");
                    this.f7443f.A();
                    this.f7443f.y(10002);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.s0.a.z2.g1.c<c.a.s0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7444e;

        public h(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7444e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.s0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null || !iVar.c()) {
                    c.a.s0.a.u2.a aVar = this.f7444e.f7435j;
                    aVar.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                    aVar.f("bad authorize response");
                    this.f7444e.y(10002);
                }
                this.f7444e.A();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7445e;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7445e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f7445e.f7430e) {
                    for (c.a.s0.a.z2.g1.c cVar : this.f7445e.f7430e) {
                        cVar.onCallback(this.f7445e);
                    }
                    this.f7445e.f7430e.clear();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1531285744, "Lc/a/s0/a/h2/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1531285744, "Lc/a/s0/a/h2/d/a;");
                return;
            }
        }
        p = k.a;
        q = new HashMap();
    }

    public a(Activity activity, String str, String str2, boolean z, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, Boolean.valueOf(z), str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7430e = new HashSet();
        this.f7431f = TaskState.INIT;
        this.f7433h = false;
        c.a.s0.a.u2.a aVar = new c.a.s0.a.u2.a();
        aVar.k(8L);
        aVar.f("OpenData");
        this.f7435j = aVar;
        this.k = false;
        this.l = false;
        this.m = false;
        this.o = new C0447a(this);
        this.a = activity;
        this.f7427b = str;
        this.f7428c = str2;
        this.f7429d = z;
        this.n = str3;
    }

    public static void B(Activity activity, String str, String str2, boolean z, String str3, c.a.s0.a.z2.g1.c<a> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{activity, str, str2, Boolean.valueOf(z), str3, cVar}) == null) {
            synchronized (q) {
                String C = C(str, z);
                a aVar = q.get(C);
                if (aVar == null) {
                    a aVar2 = new a(activity, str, str2, z, str3);
                    q.put(C, aVar2);
                    aVar2.L(cVar);
                } else {
                    c.a.s0.a.e0.d.i("OpenData", "reuse session : " + aVar.toString());
                    aVar.u(cVar);
                }
            }
        }
    }

    public static String C(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/");
            sb.append(z ? "1" : "0");
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, null) == null) {
            synchronized (q) {
                q.clear();
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.o.a();
            synchronized (q) {
                q.remove(C(this.f7427b, this.f7429d));
            }
            this.f7431f = TaskState.FINISHED;
            if (this.f7432g == null && 0 == this.f7435j.a()) {
                if (this.f7433h) {
                    this.f7435j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                } else {
                    this.f7435j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                }
            }
            c.a.s0.a.e0.d.i("OpenData", "onFinish" + toString());
            c.a.s0.a.h2.c.d.l(new i(this));
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TaskState.FINISHED == this.f7431f && 0 == this.f7435j.a() && this.f7432g != null : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TaskState.FINISHED == this.f7431f && this.f7432g != null : invokeV.booleanValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f7434i.M().f(this.a, null, new f(this));
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.s0.a.c1.a.h0().j(new e(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f7433h = this.f7434i.M().e(this.a);
            J();
        }
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (TextUtils.isEmpty(this.f7428c)) {
                c.a.s0.a.h2.c.j.a a = c.a.s0.a.d2.d.J().y().a().b().a(this.a, z, this.f7427b, this.f7428c);
                a.q(this.n);
                a.o(new g(this, z));
                a.call();
                return;
            }
            c.a.s0.a.h2.c.j.b d2 = c.a.s0.a.d2.d.J().y().a().b().d(this.a, true, z, new String[]{this.f7427b}, this.f7428c, true);
            d2.q(this.n);
            d2.o(new h(this));
            d2.call();
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.s0.a.n2.n.T(this.n, "requestOpenData");
            c.a.s0.a.h2.c.j.g c2 = c.a.s0.a.d2.d.J().y().a().b().c(this.a, this.f7427b, this.f7428c, this.f7429d, this.f7433h);
            c2.q(this.n);
            c2.o(new b(this));
            c2.call();
        }
    }

    public final void K(@NonNull c.a.s0.a.h2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            c.a.s0.a.h2.c.d.u(this.a, this.f7434i, fVar, this.f7432g, new d(this));
        }
    }

    public final void L(c.a.s0.a.z2.g1.c<a> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            c.a.s0.a.e0.d.i("OpenData", "start session : " + this.f7427b);
            this.f7431f = TaskState.CALLING;
            this.k = TextUtils.equals(this.f7427b, "snsapi_userinfo");
            u(cVar);
            c.a.s0.a.d2.e L = c.a.s0.a.d2.e.L();
            this.f7434i = L;
            if (L == null) {
                c.a.s0.a.h2.c.d.k("SwanApp is null", Boolean.TRUE);
                this.f7435j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                A();
                y(10001);
                return;
            }
            L.d0().f7236f.d(this.o);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.f7427b, Boolean.valueOf(D()), super.toString()));
            sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.f7435j));
            if (this.f7432g != null) {
                sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.f7432g));
            }
            sb.append(String.format(Locale.getDefault(), "state=%s\n", this.f7431f));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final a u(c.a.s0.a.z2.g1.c<a> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, cVar)) == null) {
            if (cVar == null) {
                return this;
            }
            synchronized (this.f7430e) {
                this.f7430e.add(cVar);
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final void v(c.a.s0.a.h2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
            if (this.l) {
                I(true);
            } else if (this.m) {
                K(fVar);
            } else {
                JSONObject jSONObject = this.f7432g;
                if (jSONObject != null && jSONObject.optInt("errno") == 1129) {
                    w(fVar, true);
                } else {
                    K(fVar);
                }
            }
        }
    }

    public final void w(c.a.s0.a.h2.c.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, fVar, z) == null) {
            c.a.s0.a.c1.a.h0().a(new c(this, z, fVar));
        }
    }

    public final void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            z(i2, c.a.s0.a.h2.c.f.f(this.f7427b, new JSONObject()));
        }
    }

    public final void z(int i2, c.a.s0.a.h2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, fVar) == null) {
            c.a.s0.a.d2.e a0 = c.a.s0.a.d2.e.a0();
            if (a0 == null) {
                boolean z = p;
                return;
            }
            c.a.s0.a.n2.s.d dVar = new c.a.s0.a.n2.s.d();
            dVar.o(i2);
            dVar.r(a0.X());
            dVar.q(c.a.s0.a.n2.n.n(a0.l()));
            dVar.m(a0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", a0.getAppId());
                jSONObject.put("msg", c.a.s0.a.h2.c.d.f(i2));
                if (fVar != null) {
                    jSONObject.put("scope", fVar.f7365b);
                    jSONObject.put("scopeData", fVar.a);
                }
            } catch (JSONException e2) {
                if (p) {
                    e2.printStackTrace();
                }
            }
            dVar.e(jSONObject);
            c.a.s0.a.n2.n.R(dVar);
        }
    }
}
