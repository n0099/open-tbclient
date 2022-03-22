package c.a.n0.a.x1.d;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.n;
import c.a.n0.a.f.d.n;
import c.a.n0.a.x1.c.j.a;
import c.a.n0.a.x1.c.j.b;
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
    public final String f7685b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7686c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7687d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<c.a.n0.a.p2.g1.c<a>> f7688e;

    /* renamed from: f  reason: collision with root package name */
    public TaskState f7689f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f7690g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7691h;
    public c.a.n0.a.t1.e i;
    public final c.a.n0.a.k2.a j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public final c.a.n0.a.p2.f1.a o;

    /* renamed from: c.a.n0.a.x1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0593a extends c.a.n0.a.p2.f1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f7692b;

        public C0593a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7692b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7692b.H();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.i<JSONObject> iVar) {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar != null && iVar.c() && (jSONObject = iVar.a) != null) {
                    c.a.n0.a.u.d.b("OpenData", "opendata=", jSONObject);
                    this.a.j.b(iVar.a.optInt("errno", 10001));
                    this.a.j.f(iVar.a.optString("errmsg", "internal error"));
                    if (0 != this.a.j.h()) {
                        c.a.n0.a.x1.c.d.k("by errno", Boolean.TRUE);
                        this.a.j.b(10001L);
                        this.a.A();
                        this.a.y(10001);
                        return;
                    }
                    JSONObject optJSONObject = iVar.a.optJSONObject("data");
                    if (optJSONObject == null) {
                        c.a.n0.a.x1.c.d.k("by data parse", Boolean.TRUE);
                        this.a.j.b(10001L);
                        this.a.A();
                        this.a.y(10001);
                        return;
                    }
                    c.a.n0.a.x1.c.f g2 = c.a.n0.a.x1.c.f.g(optJSONObject.optJSONObject("scope"));
                    if (g2 == null) {
                        c.a.n0.a.x1.c.d.k("illegal scope", Boolean.TRUE);
                        this.a.j.b(10001L);
                        this.a.A();
                        this.a.y(10001);
                        return;
                    }
                    this.a.f7690g = optJSONObject.optJSONObject("opendata");
                    if (!this.a.f7687d && (i = g2.j) < 0) {
                        if (i == -2) {
                            this.a.j.b(10006L);
                        } else {
                            this.a.j.b(10005L);
                            this.a.z(10005, g2);
                        }
                        this.a.A();
                        return;
                    } else if (g2.j > 0) {
                        if (!this.a.f7691h || !TextUtils.equals(g2.f7638b, "mobile") || (jSONObject2 = this.a.f7690g) == null || jSONObject2.optInt("errno") != 1129) {
                            this.a.A();
                            return;
                        } else {
                            this.a.w(g2, false);
                            return;
                        }
                    } else if (!this.a.i.m0()) {
                        if (!this.a.f7691h && g2.e()) {
                            if (!TextUtils.equals(g2.f7638b, "mobile") || SwanAppAllianceLoginHelper.f28743d.f()) {
                                this.a.F();
                            } else {
                                this.a.G();
                            }
                            n.T(this.a.n, "phoneNumberLogin");
                            return;
                        } else if (TextUtils.equals(g2.f7638b, "mobile")) {
                            this.a.v(g2);
                            return;
                        } else {
                            this.a.K(g2);
                            return;
                        }
                    } else {
                        this.a.j.b(10005L);
                        this.a.A();
                        this.a.z(10005, g2);
                        return;
                    }
                }
                c.a.n0.a.x1.c.d.k("bad MaOpenData response", Boolean.TRUE);
                this.a.j.b(10001L);
                this.a.A();
                this.a.y(10001);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x1.c.f f7693b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f7694c;

        /* renamed from: c.a.n0.a.x1.d.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0594a implements n.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public C0594a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // c.a.n0.a.f.d.n.c
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    c.a.n0.a.u.d.i("OpenData", "bindPhoneNumber check onSuccess isBind =" + z + ". needAuth = " + this.a.a);
                    if (z) {
                        this.a.f7694c.m = true;
                        this.a.f7694c.J();
                        return;
                    }
                    this.a.f7694c.j.b(10006L);
                    this.a.f7694c.A();
                }
            }

            @Override // c.a.n0.a.f.d.n.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c.a.n0.a.u.d.i("OpenData", "bindPhoneNumber check onFail. needAuth = " + this.a.a);
                    c cVar = this.a;
                    if (cVar.a) {
                        cVar.f7694c.K(cVar.f7693b);
                    } else {
                        cVar.f7694c.A();
                    }
                }
            }
        }

        public c(a aVar, boolean z, c.a.n0.a.x1.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z), fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7694c = aVar;
            this.a = z;
            this.f7693b = fVar;
        }

        @Override // c.a.n0.a.f.d.n.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.u.d.i("OpenData", "bindPhoneNumber onFinish. needAuth = " + this.a);
                c.a.n0.a.s0.a.h0().g(new C0594a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.n0.a.x1.c.a {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.x1.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.a.j.b(10003L);
                }
                this.a.I(z);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.n0.a.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.c.a
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                c.a.n0.a.x1.c.d.k("onResult :: " + i, Boolean.FALSE);
                if (i == -2) {
                    c.a.n0.a.x1.c.d.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.a.j.b(10004L);
                    this.a.A();
                } else if (i != 0) {
                    c.a.n0.a.x1.c.d.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.a.j.b(10004L);
                    this.a.A();
                } else {
                    c.a.n0.a.x1.c.d.k("Login Preparation ok, is already login", Boolean.FALSE);
                    this.a.f7691h = true;
                    this.a.l = true;
                    this.a.J();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.n0.a.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.c.a
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                c.a.n0.a.x1.c.d.k("onResult :: " + i, Boolean.FALSE);
                if (i == -2) {
                    c.a.n0.a.x1.c.d.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.a.j.b(10004L);
                    this.a.A();
                } else if (i != 0) {
                    c.a.n0.a.x1.c.d.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.a.j.b(10004L);
                    this.a.A();
                } else {
                    c.a.n0.a.x1.c.d.k("Login Preparation ok, is already login", Boolean.FALSE);
                    this.a.f7691h = true;
                    this.a.J();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.i<a.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f7695b;

        public g(a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7695b = aVar;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.i<a.b> iVar) {
            a.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!this.a && !this.f7695b.k) {
                    this.f7695b.A();
                } else if (iVar != null && iVar.c() && (bVar = iVar.a) != null && bVar.f7672c != null) {
                    a aVar = this.f7695b;
                    aVar.f7690g = bVar.f7672c;
                    aVar.A();
                } else {
                    c.a.n0.a.k2.a aVar2 = this.f7695b.j;
                    aVar2.b(10002L);
                    aVar2.f("bad Accredit response");
                    this.f7695b.A();
                    this.f7695b.y(10002);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public h(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null || !iVar.c()) {
                    c.a.n0.a.k2.a aVar = this.a.j;
                    aVar.b(10002L);
                    aVar.f("bad authorize response");
                    this.a.y(10002);
                }
                this.a.A();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a.f7688e) {
                    for (c.a.n0.a.p2.g1.c cVar : this.a.f7688e) {
                        cVar.onCallback(this.a);
                    }
                    this.a.f7688e.clear();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2122567290, "Lc/a/n0/a/x1/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2122567290, "Lc/a/n0/a/x1/d/a;");
                return;
            }
        }
        p = c.a.n0.a.a.a;
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
        this.f7688e = new HashSet();
        this.f7689f = TaskState.INIT;
        this.f7691h = false;
        c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
        aVar.k(8L);
        aVar.f("OpenData");
        this.j = aVar;
        this.k = false;
        this.l = false;
        this.m = false;
        this.o = new C0593a(this);
        this.a = activity;
        this.f7685b = str;
        this.f7686c = str2;
        this.f7687d = z;
        this.n = str3;
    }

    public static void B(Activity activity, String str, String str2, boolean z, String str3, c.a.n0.a.p2.g1.c<a> cVar) {
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
                    c.a.n0.a.u.d.i("OpenData", "reuse session : " + aVar.toString());
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
                q.remove(C(this.f7685b, this.f7687d));
            }
            this.f7689f = TaskState.FINISHED;
            if (this.f7690g == null && 0 == this.j.a()) {
                if (this.f7691h) {
                    this.j.b(10001L);
                } else {
                    this.j.b(10004L);
                }
            }
            c.a.n0.a.u.d.i("OpenData", "onFinish" + toString());
            c.a.n0.a.x1.c.d.l(new i(this));
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TaskState.FINISHED == this.f7689f && 0 == this.j.a() && this.f7690g != null : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TaskState.FINISHED == this.f7689f && this.f7690g != null : invokeV.booleanValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.i.M().f(this.a, null, new f(this));
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.n0.a.s0.a.h0().j(new e(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f7691h = this.i.M().e(this.a);
            J();
        }
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (TextUtils.isEmpty(this.f7686c)) {
                c.a.n0.a.x1.c.j.a a = c.a.n0.a.t1.d.J().y().a().b().a(this.a, z, this.f7685b, this.f7686c);
                a.q(this.n);
                a.o(new g(this, z));
                a.call();
                return;
            }
            c.a.n0.a.x1.c.j.b d2 = c.a.n0.a.t1.d.J().y().a().b().d(this.a, true, z, new String[]{this.f7685b}, this.f7686c, true);
            d2.q(this.n);
            d2.o(new h(this));
            d2.call();
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.n0.a.d2.n.T(this.n, "requestOpenData");
            c.a.n0.a.x1.c.j.g c2 = c.a.n0.a.t1.d.J().y().a().b().c(this.a, this.f7685b, this.f7686c, this.f7687d, this.f7691h);
            c2.q(this.n);
            c2.o(new b(this));
            c2.call();
        }
    }

    public final void K(@NonNull c.a.n0.a.x1.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            c.a.n0.a.x1.c.d.u(this.a, this.i, fVar, this.f7690g, new d(this));
        }
    }

    public final void L(c.a.n0.a.p2.g1.c<a> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            c.a.n0.a.u.d.i("OpenData", "start session : " + this.f7685b);
            this.f7689f = TaskState.CALLING;
            this.k = TextUtils.equals(this.f7685b, "snsapi_userinfo");
            u(cVar);
            c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
            this.i = L;
            if (L == null) {
                c.a.n0.a.x1.c.d.k("SwanApp is null", Boolean.TRUE);
                this.j.b(10001L);
                A();
                y(10001);
                return;
            }
            L.d0().f7539f.d(this.o);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.f7685b, Boolean.valueOf(D()), super.toString()));
            sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.j));
            if (this.f7690g != null) {
                sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.f7690g));
            }
            sb.append(String.format(Locale.getDefault(), "state=%s\n", this.f7689f));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final a u(c.a.n0.a.p2.g1.c<a> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, cVar)) == null) {
            if (cVar == null) {
                return this;
            }
            synchronized (this.f7688e) {
                this.f7688e.add(cVar);
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final void v(c.a.n0.a.x1.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
            if (this.l) {
                I(true);
            } else if (this.m) {
                K(fVar);
            } else {
                JSONObject jSONObject = this.f7690g;
                if (jSONObject != null && jSONObject.optInt("errno") == 1129) {
                    w(fVar, true);
                } else {
                    K(fVar);
                }
            }
        }
    }

    public final void w(c.a.n0.a.x1.c.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, fVar, z) == null) {
            c.a.n0.a.s0.a.h0().a(new c(this, z, fVar));
        }
    }

    public final void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            z(i2, c.a.n0.a.x1.c.f.f(this.f7685b, new JSONObject()));
        }
    }

    public final void z(int i2, c.a.n0.a.x1.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, fVar) == null) {
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                if (p) {
                    Log.e("OpenData", "failedStatistic-swanApp is null");
                    return;
                }
                return;
            }
            c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
            dVar.o(i2);
            dVar.r(a0.X());
            dVar.q(c.a.n0.a.d2.n.n(a0.l()));
            dVar.m(a0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", a0.getAppId());
                jSONObject.put("msg", c.a.n0.a.x1.c.d.f(i2));
                if (fVar != null) {
                    jSONObject.put("scope", fVar.f7638b);
                    jSONObject.put("scopeData", fVar.a);
                }
            } catch (JSONException e2) {
                if (p) {
                    e2.printStackTrace();
                }
            }
            dVar.e(jSONObject);
            c.a.n0.a.d2.n.R(dVar);
        }
    }
}
