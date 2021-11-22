package b.a.p0.a.h2.d;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h2.c.j.a;
import b.a.p0.a.h2.c.j.b;
import b.a.p0.a.k;
import b.a.p0.a.n2.n;
import b.a.p0.a.p.d.n;
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

    /* renamed from: a  reason: collision with root package name */
    public final Activity f6453a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6454b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6455c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6456d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<b.a.p0.a.z2.g1.c<a>> f6457e;

    /* renamed from: f  reason: collision with root package name */
    public TaskState f6458f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f6459g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6460h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.p0.a.d2.e f6461i;
    public final b.a.p0.a.u2.a j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public final b.a.p0.a.z2.f1.a o;

    /* renamed from: b.a.p0.a.h2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0278a extends b.a.p0.a.z2.f1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6462f;

        public C0278a(a aVar) {
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
            this.f6462f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6462f.H();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.z2.g1.c<b.a.p0.a.h2.c.i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6463e;

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
            this.f6463e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h2.c.i<JSONObject> iVar) {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar != null && iVar.c() && (jSONObject = iVar.f6424a) != null) {
                    b.a.p0.a.e0.d.b("OpenData", "opendata=", jSONObject);
                    this.f6463e.j.b(iVar.f6424a.optInt("errno", 10001));
                    this.f6463e.j.f(iVar.f6424a.optString("errmsg", "internal error"));
                    if (0 != this.f6463e.j.h()) {
                        b.a.p0.a.h2.c.d.k("by errno", Boolean.TRUE);
                        this.f6463e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f6463e.A();
                        this.f6463e.y(10001);
                        return;
                    }
                    JSONObject optJSONObject = iVar.f6424a.optJSONObject("data");
                    if (optJSONObject == null) {
                        b.a.p0.a.h2.c.d.k("by data parse", Boolean.TRUE);
                        this.f6463e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f6463e.A();
                        this.f6463e.y(10001);
                        return;
                    }
                    b.a.p0.a.h2.c.f g2 = b.a.p0.a.h2.c.f.g(optJSONObject.optJSONObject("scope"));
                    if (g2 == null) {
                        b.a.p0.a.h2.c.d.k("illegal scope", Boolean.TRUE);
                        this.f6463e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f6463e.A();
                        this.f6463e.y(10001);
                        return;
                    }
                    this.f6463e.f6459g = optJSONObject.optJSONObject("opendata");
                    if (!this.f6463e.f6456d && (i2 = g2.j) < 0) {
                        if (i2 == -2) {
                            this.f6463e.j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                        } else {
                            this.f6463e.j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                            this.f6463e.z(10005, g2);
                        }
                        this.f6463e.A();
                        return;
                    } else if (g2.j > 0) {
                        if (!this.f6463e.f6460h || !TextUtils.equals(g2.f6383b, "mobile") || (jSONObject2 = this.f6463e.f6459g) == null || jSONObject2.optInt("errno") != 1129) {
                            this.f6463e.A();
                            return;
                        } else {
                            this.f6463e.w(g2, false);
                            return;
                        }
                    } else if (!this.f6463e.f6461i.m0()) {
                        if (!this.f6463e.f6460h && g2.e()) {
                            if (!TextUtils.equals(g2.f6383b, "mobile") || SwanAppAllianceLoginHelper.f44256d.f()) {
                                this.f6463e.F();
                            } else {
                                this.f6463e.G();
                            }
                            n.T(this.f6463e.n, "phoneNumberLogin");
                            return;
                        } else if (TextUtils.equals(g2.f6383b, "mobile")) {
                            this.f6463e.v(g2);
                            return;
                        } else {
                            this.f6463e.K(g2);
                            return;
                        }
                    } else {
                        this.f6463e.j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                        this.f6463e.A();
                        this.f6463e.z(10005, g2);
                        return;
                    }
                }
                b.a.p0.a.h2.c.d.k("bad MaOpenData response", Boolean.TRUE);
                this.f6463e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                this.f6463e.A();
                this.f6463e.y(10001);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f6464a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h2.c.f f6465b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f6466c;

        /* renamed from: b.a.p0.a.h2.d.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0279a implements n.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f6467a;

            public C0279a(c cVar) {
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
                this.f6467a = cVar;
            }

            @Override // b.a.p0.a.p.d.n.c
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    b.a.p0.a.e0.d.i("OpenData", "bindPhoneNumber check onSuccess isBind =" + z + ". needAuth = " + this.f6467a.f6464a);
                    if (z) {
                        this.f6467a.f6466c.m = true;
                        this.f6467a.f6466c.J();
                        return;
                    }
                    this.f6467a.f6466c.j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                    this.f6467a.f6466c.A();
                }
            }

            @Override // b.a.p0.a.p.d.n.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    b.a.p0.a.e0.d.i("OpenData", "bindPhoneNumber check onFail. needAuth = " + this.f6467a.f6464a);
                    c cVar = this.f6467a;
                    if (cVar.f6464a) {
                        cVar.f6466c.K(cVar.f6465b);
                    } else {
                        cVar.f6466c.A();
                    }
                }
            }
        }

        public c(a aVar, boolean z, b.a.p0.a.h2.c.f fVar) {
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
            this.f6466c = aVar;
            this.f6464a = z;
            this.f6465b = fVar;
        }

        @Override // b.a.p0.a.p.d.n.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.e0.d.i("OpenData", "bindPhoneNumber onFinish. needAuth = " + this.f6464a);
                b.a.p0.a.c1.a.h0().g(new C0279a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements b.a.p0.a.h2.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6468a;

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
            this.f6468a = aVar;
        }

        @Override // b.a.p0.a.h2.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.f6468a.j.b(LightappBusinessClient.SVC_ID_H5_TRANSERECORD);
                }
                this.f6468a.I(z);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6469e;

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
            this.f6469e = aVar;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                b.a.p0.a.h2.c.d.k("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    b.a.p0.a.h2.c.d.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.f6469e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f6469e.A();
                } else if (i2 != 0) {
                    b.a.p0.a.h2.c.d.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.f6469e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f6469e.A();
                } else {
                    b.a.p0.a.h2.c.d.k("Login Preparation ok, is already login", Boolean.FALSE);
                    this.f6469e.f6460h = true;
                    this.f6469e.l = true;
                    this.f6469e.J();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6470e;

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
            this.f6470e = aVar;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                b.a.p0.a.h2.c.d.k("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    b.a.p0.a.h2.c.d.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.f6470e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f6470e.A();
                } else if (i2 != 0) {
                    b.a.p0.a.h2.c.d.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.f6470e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f6470e.A();
                } else {
                    b.a.p0.a.h2.c.d.k("Login Preparation ok, is already login", Boolean.FALSE);
                    this.f6470e.f6460h = true;
                    this.f6470e.J();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements b.a.p0.a.z2.g1.c<b.a.p0.a.h2.c.i<a.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f6471e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6472f;

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
            this.f6472f = aVar;
            this.f6471e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h2.c.i<a.b> iVar) {
            a.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!this.f6471e && !this.f6472f.k) {
                    this.f6472f.A();
                } else if (iVar != null && iVar.c() && (bVar = iVar.f6424a) != null && bVar.f6429c != null) {
                    a aVar = this.f6472f;
                    aVar.f6459g = bVar.f6429c;
                    aVar.A();
                } else {
                    b.a.p0.a.u2.a aVar2 = this.f6472f.j;
                    aVar2.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                    aVar2.f("bad Accredit response");
                    this.f6472f.A();
                    this.f6472f.y(10002);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements b.a.p0.a.z2.g1.c<b.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6473e;

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
            this.f6473e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null || !iVar.c()) {
                    b.a.p0.a.u2.a aVar = this.f6473e.j;
                    aVar.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                    aVar.f("bad authorize response");
                    this.f6473e.y(10002);
                }
                this.f6473e.A();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6474e;

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
            this.f6474e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f6474e.f6457e) {
                    for (b.a.p0.a.z2.g1.c cVar : this.f6474e.f6457e) {
                        cVar.onCallback(this.f6474e);
                    }
                    this.f6474e.f6457e.clear();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1654571764, "Lb/a/p0/a/h2/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1654571764, "Lb/a/p0/a/h2/d/a;");
                return;
            }
        }
        p = k.f6863a;
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
        this.f6457e = new HashSet();
        this.f6458f = TaskState.INIT;
        this.f6460h = false;
        b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
        aVar.k(8L);
        aVar.f("OpenData");
        this.j = aVar;
        this.k = false;
        this.l = false;
        this.m = false;
        this.o = new C0278a(this);
        this.f6453a = activity;
        this.f6454b = str;
        this.f6455c = str2;
        this.f6456d = z;
        this.n = str3;
    }

    public static void B(Activity activity, String str, String str2, boolean z, String str3, b.a.p0.a.z2.g1.c<a> cVar) {
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
                    b.a.p0.a.e0.d.i("OpenData", "reuse session : " + aVar.toString());
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
                q.remove(C(this.f6454b, this.f6456d));
            }
            this.f6458f = TaskState.FINISHED;
            if (this.f6459g == null && 0 == this.j.a()) {
                if (this.f6460h) {
                    this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                } else {
                    this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                }
            }
            b.a.p0.a.e0.d.i("OpenData", "onFinish" + toString());
            b.a.p0.a.h2.c.d.l(new i(this));
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TaskState.FINISHED == this.f6458f && 0 == this.j.a() && this.f6459g != null : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TaskState.FINISHED == this.f6458f && this.f6459g != null : invokeV.booleanValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f6461i.M().f(this.f6453a, null, new f(this));
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b.a.p0.a.c1.a.h0().j(new e(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f6460h = this.f6461i.M().e(this.f6453a);
            J();
        }
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (TextUtils.isEmpty(this.f6455c)) {
                b.a.p0.a.h2.c.j.a a2 = b.a.p0.a.d2.d.J().y().a().b().a(this.f6453a, z, this.f6454b, this.f6455c);
                a2.q(this.n);
                a2.o(new g(this, z));
                a2.call();
                return;
            }
            b.a.p0.a.h2.c.j.b d2 = b.a.p0.a.d2.d.J().y().a().b().d(this.f6453a, true, z, new String[]{this.f6454b}, this.f6455c, true);
            d2.q(this.n);
            d2.o(new h(this));
            d2.call();
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.p0.a.n2.n.T(this.n, "requestOpenData");
            b.a.p0.a.h2.c.j.g c2 = b.a.p0.a.d2.d.J().y().a().b().c(this.f6453a, this.f6454b, this.f6455c, this.f6456d, this.f6460h);
            c2.q(this.n);
            c2.o(new b(this));
            c2.call();
        }
    }

    public final void K(@NonNull b.a.p0.a.h2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            b.a.p0.a.h2.c.d.u(this.f6453a, this.f6461i, fVar, this.f6459g, new d(this));
        }
    }

    public final void L(b.a.p0.a.z2.g1.c<a> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            b.a.p0.a.e0.d.i("OpenData", "start session : " + this.f6454b);
            this.f6458f = TaskState.CALLING;
            this.k = TextUtils.equals(this.f6454b, "snsapi_userinfo");
            u(cVar);
            b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
            this.f6461i = L;
            if (L == null) {
                b.a.p0.a.h2.c.d.k("SwanApp is null", Boolean.TRUE);
                this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                A();
                y(10001);
                return;
            }
            L.d0().f6249f.d(this.o);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.f6454b, Boolean.valueOf(D()), super.toString()));
            sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.j));
            if (this.f6459g != null) {
                sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.f6459g));
            }
            sb.append(String.format(Locale.getDefault(), "state=%s\n", this.f6458f));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final a u(b.a.p0.a.z2.g1.c<a> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, cVar)) == null) {
            if (cVar == null) {
                return this;
            }
            synchronized (this.f6457e) {
                this.f6457e.add(cVar);
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final void v(b.a.p0.a.h2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
            if (this.l) {
                I(true);
            } else if (this.m) {
                K(fVar);
            } else {
                JSONObject jSONObject = this.f6459g;
                if (jSONObject != null && jSONObject.optInt("errno") == 1129) {
                    w(fVar, true);
                } else {
                    K(fVar);
                }
            }
        }
    }

    public final void w(b.a.p0.a.h2.c.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, fVar, z) == null) {
            b.a.p0.a.c1.a.h0().a(new c(this, z, fVar));
        }
    }

    public final void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            z(i2, b.a.p0.a.h2.c.f.f(this.f6454b, new JSONObject()));
        }
    }

    public final void z(int i2, b.a.p0.a.h2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, fVar) == null) {
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null) {
                boolean z = p;
                return;
            }
            b.a.p0.a.n2.s.d dVar = new b.a.p0.a.n2.s.d();
            dVar.o(i2);
            dVar.r(a0.X());
            dVar.q(b.a.p0.a.n2.n.n(a0.l()));
            dVar.m(a0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", a0.getAppId());
                jSONObject.put("msg", b.a.p0.a.h2.c.d.f(i2));
                if (fVar != null) {
                    jSONObject.put("scope", fVar.f6383b);
                    jSONObject.put("scopeData", fVar.f6382a);
                }
            } catch (JSONException e2) {
                if (p) {
                    e2.printStackTrace();
                }
            }
            dVar.e(jSONObject);
            b.a.p0.a.n2.n.R(dVar);
        }
    }
}
