package c.a.p0.a.x1.d;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d2.n;
import c.a.p0.a.f.d.n;
import c.a.p0.a.x1.c.j.a;
import c.a.p0.a.x1.c.j.b;
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
    public final String f9160b;

    /* renamed from: c  reason: collision with root package name */
    public final String f9161c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9162d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<c.a.p0.a.p2.g1.c<a>> f9163e;

    /* renamed from: f  reason: collision with root package name */
    public TaskState f9164f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f9165g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f9166h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.a.t1.e f9167i;

    /* renamed from: j  reason: collision with root package name */
    public final c.a.p0.a.k2.a f9168j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public final c.a.p0.a.p2.f1.a o;

    /* renamed from: c.a.p0.a.x1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0601a extends c.a.p0.a.p2.f1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f9169f;

        public C0601a(a aVar) {
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
            this.f9169f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9169f.H();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.p2.g1.c<c.a.p0.a.x1.c.i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f9170e;

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
            this.f9170e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.x1.c.i<JSONObject> iVar) {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar != null && iVar.c() && (jSONObject = iVar.a) != null) {
                    c.a.p0.a.u.d.b("OpenData", "opendata=", jSONObject);
                    this.f9170e.f9168j.b(iVar.a.optInt("errno", 10001));
                    this.f9170e.f9168j.f(iVar.a.optString("errmsg", "internal error"));
                    if (0 != this.f9170e.f9168j.h()) {
                        c.a.p0.a.x1.c.d.k("by errno", Boolean.TRUE);
                        this.f9170e.f9168j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f9170e.A();
                        this.f9170e.y(10001);
                        return;
                    }
                    JSONObject optJSONObject = iVar.a.optJSONObject("data");
                    if (optJSONObject == null) {
                        c.a.p0.a.x1.c.d.k("by data parse", Boolean.TRUE);
                        this.f9170e.f9168j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f9170e.A();
                        this.f9170e.y(10001);
                        return;
                    }
                    c.a.p0.a.x1.c.f g2 = c.a.p0.a.x1.c.f.g(optJSONObject.optJSONObject("scope"));
                    if (g2 == null) {
                        c.a.p0.a.x1.c.d.k("illegal scope", Boolean.TRUE);
                        this.f9170e.f9168j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f9170e.A();
                        this.f9170e.y(10001);
                        return;
                    }
                    this.f9170e.f9165g = optJSONObject.optJSONObject("opendata");
                    if (!this.f9170e.f9162d && (i2 = g2.f9106j) < 0) {
                        if (i2 == -2) {
                            this.f9170e.f9168j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                        } else {
                            this.f9170e.f9168j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                            this.f9170e.z(10005, g2);
                        }
                        this.f9170e.A();
                        return;
                    } else if (g2.f9106j > 0) {
                        if (!this.f9170e.f9166h || !TextUtils.equals(g2.f9098b, "mobile") || (jSONObject2 = this.f9170e.f9165g) == null || jSONObject2.optInt("errno") != 1129) {
                            this.f9170e.A();
                            return;
                        } else {
                            this.f9170e.w(g2, false);
                            return;
                        }
                    } else if (!this.f9170e.f9167i.m0()) {
                        if (!this.f9170e.f9166h && g2.e()) {
                            if (!TextUtils.equals(g2.f9098b, "mobile") || SwanAppAllianceLoginHelper.f37293d.f()) {
                                this.f9170e.F();
                            } else {
                                this.f9170e.G();
                            }
                            n.T(this.f9170e.n, "phoneNumberLogin");
                            return;
                        } else if (TextUtils.equals(g2.f9098b, "mobile")) {
                            this.f9170e.v(g2);
                            return;
                        } else {
                            this.f9170e.K(g2);
                            return;
                        }
                    } else {
                        this.f9170e.f9168j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                        this.f9170e.A();
                        this.f9170e.z(10005, g2);
                        return;
                    }
                }
                c.a.p0.a.x1.c.d.k("bad MaOpenData response", Boolean.TRUE);
                this.f9170e.f9168j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                this.f9170e.A();
                this.f9170e.y(10001);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x1.c.f f9171b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f9172c;

        /* renamed from: c.a.p0.a.x1.d.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0602a implements n.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public C0602a(c cVar) {
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

            @Override // c.a.p0.a.f.d.n.c
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    c.a.p0.a.u.d.i("OpenData", "bindPhoneNumber check onSuccess isBind =" + z + ". needAuth = " + this.a.a);
                    if (z) {
                        this.a.f9172c.m = true;
                        this.a.f9172c.J();
                        return;
                    }
                    this.a.f9172c.f9168j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                    this.a.f9172c.A();
                }
            }

            @Override // c.a.p0.a.f.d.n.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c.a.p0.a.u.d.i("OpenData", "bindPhoneNumber check onFail. needAuth = " + this.a.a);
                    c cVar = this.a;
                    if (cVar.a) {
                        cVar.f9172c.K(cVar.f9171b);
                    } else {
                        cVar.f9172c.A();
                    }
                }
            }
        }

        public c(a aVar, boolean z, c.a.p0.a.x1.c.f fVar) {
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
            this.f9172c = aVar;
            this.a = z;
            this.f9171b = fVar;
        }

        @Override // c.a.p0.a.f.d.n.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.u.d.i("OpenData", "bindPhoneNumber onFinish. needAuth = " + this.a);
                c.a.p0.a.s0.a.h0().g(new C0602a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.p0.a.x1.c.a {
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

        @Override // c.a.p0.a.x1.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.a.f9168j.b(LightappBusinessClient.SVC_ID_H5_TRANSERECORD);
                }
                this.a.I(z);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.p0.a.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f9173e;

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
            this.f9173e = aVar;
        }

        @Override // c.a.p0.a.c.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                c.a.p0.a.x1.c.d.k("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    c.a.p0.a.x1.c.d.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.f9173e.f9168j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f9173e.A();
                } else if (i2 != 0) {
                    c.a.p0.a.x1.c.d.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.f9173e.f9168j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f9173e.A();
                } else {
                    c.a.p0.a.x1.c.d.k("Login Preparation ok, is already login", Boolean.FALSE);
                    this.f9173e.f9166h = true;
                    this.f9173e.l = true;
                    this.f9173e.J();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.p0.a.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f9174e;

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
            this.f9174e = aVar;
        }

        @Override // c.a.p0.a.c.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                c.a.p0.a.x1.c.d.k("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    c.a.p0.a.x1.c.d.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.f9174e.f9168j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f9174e.A();
                } else if (i2 != 0) {
                    c.a.p0.a.x1.c.d.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.f9174e.f9168j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f9174e.A();
                } else {
                    c.a.p0.a.x1.c.d.k("Login Preparation ok, is already login", Boolean.FALSE);
                    this.f9174e.f9166h = true;
                    this.f9174e.J();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.p0.a.p2.g1.c<c.a.p0.a.x1.c.i<a.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f9175e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f9176f;

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
            this.f9176f = aVar;
            this.f9175e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.x1.c.i<a.b> iVar) {
            a.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!this.f9175e && !this.f9176f.k) {
                    this.f9176f.A();
                } else if (iVar != null && iVar.c() && (bVar = iVar.a) != null && bVar.f9141c != null) {
                    a aVar = this.f9176f;
                    aVar.f9165g = bVar.f9141c;
                    aVar.A();
                } else {
                    c.a.p0.a.k2.a aVar2 = this.f9176f.f9168j;
                    aVar2.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                    aVar2.f("bad Accredit response");
                    this.f9176f.A();
                    this.f9176f.y(10002);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.p0.a.p2.g1.c<c.a.p0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f9177e;

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
            this.f9177e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null || !iVar.c()) {
                    c.a.p0.a.k2.a aVar = this.f9177e.f9168j;
                    aVar.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                    aVar.f("bad authorize response");
                    this.f9177e.y(10002);
                }
                this.f9177e.A();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f9178e;

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
            this.f9178e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f9178e.f9163e) {
                    for (c.a.p0.a.p2.g1.c cVar : this.f9178e.f9163e) {
                        cVar.onCallback(this.f9178e);
                    }
                    this.f9178e.f9163e.clear();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1864401852, "Lc/a/p0/a/x1/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1864401852, "Lc/a/p0/a/x1/d/a;");
                return;
            }
        }
        p = c.a.p0.a.a.a;
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
        this.f9163e = new HashSet();
        this.f9164f = TaskState.INIT;
        this.f9166h = false;
        c.a.p0.a.k2.a aVar = new c.a.p0.a.k2.a();
        aVar.k(8L);
        aVar.f("OpenData");
        this.f9168j = aVar;
        this.k = false;
        this.l = false;
        this.m = false;
        this.o = new C0601a(this);
        this.a = activity;
        this.f9160b = str;
        this.f9161c = str2;
        this.f9162d = z;
        this.n = str3;
    }

    public static void B(Activity activity, String str, String str2, boolean z, String str3, c.a.p0.a.p2.g1.c<a> cVar) {
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
                    c.a.p0.a.u.d.i("OpenData", "reuse session : " + aVar.toString());
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
                q.remove(C(this.f9160b, this.f9162d));
            }
            this.f9164f = TaskState.FINISHED;
            if (this.f9165g == null && 0 == this.f9168j.a()) {
                if (this.f9166h) {
                    this.f9168j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                } else {
                    this.f9168j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                }
            }
            c.a.p0.a.u.d.i("OpenData", "onFinish" + toString());
            c.a.p0.a.x1.c.d.l(new i(this));
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TaskState.FINISHED == this.f9164f && 0 == this.f9168j.a() && this.f9165g != null : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TaskState.FINISHED == this.f9164f && this.f9165g != null : invokeV.booleanValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f9167i.M().f(this.a, null, new f(this));
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.p0.a.s0.a.h0().j(new e(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f9166h = this.f9167i.M().e(this.a);
            J();
        }
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (TextUtils.isEmpty(this.f9161c)) {
                c.a.p0.a.x1.c.j.a a = c.a.p0.a.t1.d.J().y().a().b().a(this.a, z, this.f9160b, this.f9161c);
                a.q(this.n);
                a.o(new g(this, z));
                a.call();
                return;
            }
            c.a.p0.a.x1.c.j.b d2 = c.a.p0.a.t1.d.J().y().a().b().d(this.a, true, z, new String[]{this.f9160b}, this.f9161c, true);
            d2.q(this.n);
            d2.o(new h(this));
            d2.call();
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.a.d2.n.T(this.n, "requestOpenData");
            c.a.p0.a.x1.c.j.g c2 = c.a.p0.a.t1.d.J().y().a().b().c(this.a, this.f9160b, this.f9161c, this.f9162d, this.f9166h);
            c2.q(this.n);
            c2.o(new b(this));
            c2.call();
        }
    }

    public final void K(@NonNull c.a.p0.a.x1.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            c.a.p0.a.x1.c.d.u(this.a, this.f9167i, fVar, this.f9165g, new d(this));
        }
    }

    public final void L(c.a.p0.a.p2.g1.c<a> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            c.a.p0.a.u.d.i("OpenData", "start session : " + this.f9160b);
            this.f9164f = TaskState.CALLING;
            this.k = TextUtils.equals(this.f9160b, "snsapi_userinfo");
            u(cVar);
            c.a.p0.a.t1.e L = c.a.p0.a.t1.e.L();
            this.f9167i = L;
            if (L == null) {
                c.a.p0.a.x1.c.d.k("SwanApp is null", Boolean.TRUE);
                this.f9168j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                A();
                y(10001);
                return;
            }
            L.d0().f8969f.d(this.o);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.f9160b, Boolean.valueOf(D()), super.toString()));
            sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.f9168j));
            if (this.f9165g != null) {
                sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.f9165g));
            }
            sb.append(String.format(Locale.getDefault(), "state=%s\n", this.f9164f));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final a u(c.a.p0.a.p2.g1.c<a> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, cVar)) == null) {
            if (cVar == null) {
                return this;
            }
            synchronized (this.f9163e) {
                this.f9163e.add(cVar);
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final void v(c.a.p0.a.x1.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
            if (this.l) {
                I(true);
            } else if (this.m) {
                K(fVar);
            } else {
                JSONObject jSONObject = this.f9165g;
                if (jSONObject != null && jSONObject.optInt("errno") == 1129) {
                    w(fVar, true);
                } else {
                    K(fVar);
                }
            }
        }
    }

    public final void w(c.a.p0.a.x1.c.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, fVar, z) == null) {
            c.a.p0.a.s0.a.h0().a(new c(this, z, fVar));
        }
    }

    public final void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            z(i2, c.a.p0.a.x1.c.f.f(this.f9160b, new JSONObject()));
        }
    }

    public final void z(int i2, c.a.p0.a.x1.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, fVar) == null) {
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            if (a0 == null) {
                boolean z = p;
                return;
            }
            c.a.p0.a.d2.s.d dVar = new c.a.p0.a.d2.s.d();
            dVar.o(i2);
            dVar.r(a0.X());
            dVar.q(c.a.p0.a.d2.n.n(a0.l()));
            dVar.m(a0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", a0.getAppId());
                jSONObject.put("msg", c.a.p0.a.x1.c.d.f(i2));
                if (fVar != null) {
                    jSONObject.put("scope", fVar.f9098b);
                    jSONObject.put("scopeData", fVar.a);
                }
            } catch (JSONException e2) {
                if (p) {
                    e2.printStackTrace();
                }
            }
            dVar.e(jSONObject);
            c.a.p0.a.d2.n.R(dVar);
        }
    }
}
