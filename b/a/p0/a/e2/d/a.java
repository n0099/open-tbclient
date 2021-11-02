package b.a.p0.a.e2.d;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e2.c.j.a;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.j2.k;
import b.a.p0.a.p.d.n;
import com.baidu.android.imsdk.internal.Constants;
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
    public final Activity f4975a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4976b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4977c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4978d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<b.a.p0.a.v2.e1.b<a>> f4979e;

    /* renamed from: f  reason: collision with root package name */
    public TaskState f4980f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f4981g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4982h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.p0.a.a2.e f4983i;
    public final b.a.p0.a.q2.a j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public final b.a.p0.a.v2.d1.a o;

    /* renamed from: b.a.p0.a.e2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0172a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4984e;

        public RunnableC0172a(a aVar) {
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
            this.f4984e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f4984e.f4979e) {
                    for (b.a.p0.a.v2.e1.b bVar : this.f4984e.f4979e) {
                        bVar.onCallback(this.f4984e);
                    }
                    this.f4984e.f4979e.clear();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends b.a.p0.a.v2.d1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4985f;

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
            this.f4985f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4985f.I();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4986e;

        public c(a aVar) {
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
            this.f4986e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.i<JSONObject> iVar) {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar != null && iVar.c() && (jSONObject = iVar.f4946a) != null) {
                    b.a.p0.a.e0.d.a("OpenData", "opendata=", jSONObject);
                    this.f4986e.j.b(iVar.f4946a.optInt("errno", 10001));
                    this.f4986e.j.e(iVar.f4946a.optString("errmsg", "internal error"));
                    if (0 != this.f4986e.j.g()) {
                        b.a.p0.a.e2.c.d.j("by errno", Boolean.TRUE);
                        this.f4986e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f4986e.B();
                        this.f4986e.z(10001);
                        return;
                    }
                    JSONObject optJSONObject = iVar.f4946a.optJSONObject("data");
                    if (optJSONObject == null) {
                        b.a.p0.a.e2.c.d.j("by data parse", Boolean.TRUE);
                        this.f4986e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f4986e.B();
                        this.f4986e.z(10001);
                        return;
                    }
                    b.a.p0.a.e2.c.f e2 = b.a.p0.a.e2.c.f.e(optJSONObject.optJSONObject("scope"));
                    if (e2 == null) {
                        b.a.p0.a.e2.c.d.j("illegal scope", Boolean.TRUE);
                        this.f4986e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f4986e.B();
                        this.f4986e.z(10001);
                        return;
                    }
                    this.f4986e.f4981g = optJSONObject.optJSONObject("opendata");
                    if (!this.f4986e.f4978d && (i2 = e2.j) < 0) {
                        if (i2 == -2) {
                            this.f4986e.j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                        } else {
                            this.f4986e.j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                            this.f4986e.A(10005, e2);
                        }
                        this.f4986e.B();
                        return;
                    } else if (e2.j > 0) {
                        if (!this.f4986e.f4982h || !TextUtils.equals(e2.f4905b, "mobile") || (jSONObject2 = this.f4986e.f4981g) == null || jSONObject2.optInt("errno") != 1129) {
                            this.f4986e.B();
                            return;
                        } else {
                            this.f4986e.w(e2, false);
                            return;
                        }
                    } else if (!this.f4986e.f4983i.c0()) {
                        if (!this.f4986e.f4982h && e2.c()) {
                            if (!TextUtils.equals(e2.f4905b, "mobile") || b.a.p0.a.s.a.f.f7771d.f()) {
                                this.f4986e.G();
                            } else {
                                this.f4986e.H();
                            }
                            k.N(this.f4986e.n, "phoneNumberLogin");
                            return;
                        } else if (TextUtils.equals(e2.f4905b, "mobile")) {
                            this.f4986e.v(e2);
                            return;
                        } else {
                            this.f4986e.L(e2);
                            return;
                        }
                    } else {
                        this.f4986e.j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                        this.f4986e.B();
                        this.f4986e.A(10005, e2);
                        return;
                    }
                }
                b.a.p0.a.e2.c.d.j("bad MaOpenData response", Boolean.TRUE);
                this.f4986e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                this.f4986e.B();
                this.f4986e.z(10001);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements n.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.e2.c.f f4987a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f4988b;

        public d(a aVar, b.a.p0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4988b = aVar;
            this.f4987a = fVar;
        }

        @Override // b.a.p0.a.p.d.n.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                b.a.p0.a.e0.d.g("OpenData", "checkPhoneNumberStatus onSuccess isBind = " + z + ". needAuth = true");
                if (z) {
                    this.f4988b.L(this.f4987a);
                } else {
                    this.f4988b.w(this.f4987a, true);
                }
            }
        }

        @Override // b.a.p0.a.p.d.n.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.p0.a.e0.d.g("OpenData", "checkPhoneNumberStatus onFail. needAuth = true");
                this.f4988b.L(this.f4987a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f4989a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.e2.c.f f4990b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f4991c;

        /* renamed from: b.a.p0.a.e2.d.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0173a implements n.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f4992a;

            public C0173a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4992a = eVar;
            }

            @Override // b.a.p0.a.p.d.n.c
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    b.a.p0.a.e0.d.g("OpenData", "bindPhoneNumber check onSuccess isBind =" + z + ". needAuth = " + this.f4992a.f4989a);
                    if (z) {
                        this.f4992a.f4991c.m = true;
                        this.f4992a.f4991c.K();
                        return;
                    }
                    this.f4992a.f4991c.j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                    this.f4992a.f4991c.B();
                }
            }

            @Override // b.a.p0.a.p.d.n.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    b.a.p0.a.e0.d.g("OpenData", "bindPhoneNumber check onFail. needAuth = " + this.f4992a.f4989a);
                    e eVar = this.f4992a;
                    if (eVar.f4989a) {
                        eVar.f4991c.L(eVar.f4990b);
                    } else {
                        eVar.f4991c.B();
                    }
                }
            }
        }

        public e(a aVar, boolean z, b.a.p0.a.e2.c.f fVar) {
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
            this.f4991c = aVar;
            this.f4989a = z;
            this.f4990b = fVar;
        }

        @Override // b.a.p0.a.p.d.n.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.e0.d.g("OpenData", "bindPhoneNumber onFinish. needAuth = " + this.f4989a);
                b.a.p0.a.c1.a.a0().g(new C0173a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.a.p0.a.e2.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f4993a;

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
            this.f4993a = aVar;
        }

        @Override // b.a.p0.a.e2.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.f4993a.j.b(LightappBusinessClient.SVC_ID_H5_TRANSERECORD);
                }
                this.f4993a.J(z);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4994e;

        public g(a aVar) {
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
            this.f4994e = aVar;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                b.a.p0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    b.a.p0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.f4994e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f4994e.B();
                } else if (i2 != 0) {
                    b.a.p0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.f4994e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f4994e.B();
                } else {
                    b.a.p0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                    this.f4994e.f4982h = true;
                    this.f4994e.l = true;
                    this.f4994e.K();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4995e;

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
            this.f4995e = aVar;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                b.a.p0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    b.a.p0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.f4995e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f4995e.B();
                } else if (i2 != 0) {
                    b.a.p0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.f4995e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f4995e.B();
                } else {
                    b.a.p0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                    this.f4995e.f4982h = true;
                    this.f4995e.K();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<a.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f4996e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4997f;

        public i(a aVar, boolean z) {
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
            this.f4997f = aVar;
            this.f4996e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.i<a.b> iVar) {
            a.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!this.f4996e && !this.f4997f.k) {
                    this.f4997f.B();
                } else if (iVar != null && iVar.c() && (bVar = iVar.f4946a) != null && bVar.f4951c != null) {
                    a aVar = this.f4997f;
                    aVar.f4981g = bVar.f4951c;
                    aVar.B();
                } else {
                    b.a.p0.a.q2.a aVar2 = this.f4997f.j;
                    aVar2.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                    aVar2.e("bad Accredit response");
                    this.f4997f.B();
                    this.f4997f.z(10002);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4998e;

        public j(a aVar) {
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
            this.f4998e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null || !iVar.c()) {
                    b.a.p0.a.q2.a aVar = this.f4998e.j;
                    aVar.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                    aVar.e("bad authorize response");
                    this.f4998e.z(10002);
                }
                this.f4998e.B();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1007939279, "Lb/a/p0/a/e2/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1007939279, "Lb/a/p0/a/e2/d/a;");
                return;
            }
        }
        p = b.a.p0.a.k.f6397a;
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
        this.f4979e = new HashSet();
        this.f4980f = TaskState.INIT;
        this.f4982h = false;
        b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
        aVar.j(8L);
        aVar.e("OpenData");
        this.j = aVar;
        this.k = false;
        this.l = false;
        this.m = false;
        this.o = new b(this);
        this.f4975a = activity;
        this.f4976b = str;
        this.f4977c = str2;
        this.f4978d = z;
        this.n = str3;
    }

    public static void C(Activity activity, String str, String str2, boolean z, String str3, b.a.p0.a.v2.e1.b<a> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{activity, str, str2, Boolean.valueOf(z), str3, bVar}) == null) {
            synchronized (q) {
                String D = D(str, z);
                a aVar = q.get(D);
                if (aVar == null) {
                    a aVar2 = new a(activity, str, str2, z, str3);
                    q.put(D, aVar2);
                    aVar2.M(bVar);
                } else {
                    b.a.p0.a.e0.d.g("OpenData", "reuse session : " + aVar.toString());
                    aVar.u(bVar);
                }
            }
        }
    }

    public static String D(String str, boolean z) {
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

    public final void A(int i2, b.a.p0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, fVar) == null) {
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P == null) {
                boolean z = p;
                return;
            }
            b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
            dVar.o(i2);
            dVar.r(P.M());
            dVar.q(k.m(P.l()));
            dVar.m(P.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", P.getAppId());
                jSONObject.put("msg", b.a.p0.a.e2.c.d.f(i2));
                if (fVar != null) {
                    jSONObject.put("scope", fVar.f4905b);
                    jSONObject.put("scopeData", fVar.f4904a);
                }
            } catch (JSONException e2) {
                if (p) {
                    e2.printStackTrace();
                }
            }
            dVar.e(jSONObject);
            k.L(dVar);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.o.a();
            synchronized (q) {
                q.remove(D(this.f4976b, this.f4978d));
            }
            this.f4980f = TaskState.FINISHED;
            if (this.f4981g == null && 0 == this.j.a()) {
                if (this.f4982h) {
                    this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                } else {
                    this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                }
            }
            b.a.p0.a.e0.d.g("OpenData", "onFinish" + toString());
            b.a.p0.a.e2.c.d.k(new RunnableC0172a(this));
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TaskState.FINISHED == this.f4980f && 0 == this.j.a() && this.f4981g != null : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TaskState.FINISHED == this.f4980f && this.f4981g != null : invokeV.booleanValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f4983i.j().f(this.f4975a, null, new h(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.p0.a.c1.a.a0().j(new g(this));
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f4982h = this.f4983i.j().e(this.f4975a);
            K();
        }
    }

    public final void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (TextUtils.isEmpty(this.f4977c)) {
                b.a.p0.a.e2.c.j.a a2 = b.a.p0.a.a2.d.g().y().a().b().a(this.f4975a, z, this.f4976b, this.f4977c);
                a2.q(this.n);
                a2.o(new i(this, z));
                a2.call();
                return;
            }
            b.a.p0.a.e2.c.j.b d2 = b.a.p0.a.a2.d.g().y().a().b().d(this.f4975a, true, z, new String[]{this.f4976b}, this.f4977c, true);
            d2.q(this.n);
            d2.o(new j(this));
            d2.call();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            k.N(this.n, "requestOpenData");
            b.a.p0.a.e2.c.j.g c2 = b.a.p0.a.a2.d.g().y().a().b().c(this.f4975a, this.f4976b, this.f4977c, this.f4978d, this.f4982h);
            c2.q(this.n);
            c2.o(new c(this));
            c2.call();
        }
    }

    public final void L(@NonNull b.a.p0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            b.a.p0.a.e2.c.d.t(this.f4975a, this.f4983i, fVar, this.f4981g, new f(this));
        }
    }

    public final void M(b.a.p0.a.v2.e1.b<a> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            b.a.p0.a.e0.d.g("OpenData", "start session : " + this.f4976b);
            this.f4980f = TaskState.CALLING;
            this.k = TextUtils.equals(this.f4976b, "snsapi_userinfo");
            u(bVar);
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
            this.f4983i = i2;
            if (i2 == null) {
                b.a.p0.a.e2.c.d.j("SwanApp is null", Boolean.TRUE);
                this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                B();
                z(10001);
                return;
            }
            i2.S().f4778f.d(this.o);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.f4976b, Boolean.valueOf(E()), super.toString()));
            sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.j));
            if (this.f4981g != null) {
                sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.f4981g));
            }
            sb.append(String.format(Locale.getDefault(), "state=%s\n", this.f4980f));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final a u(b.a.p0.a.v2.e1.b<a> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bVar)) == null) {
            if (bVar == null) {
                return this;
            }
            synchronized (this.f4979e) {
                this.f4979e.add(bVar);
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final void v(b.a.p0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
            if (this.l) {
                J(true);
            } else if (this.m) {
                L(fVar);
            } else {
                y(fVar);
            }
        }
    }

    public final void w(b.a.p0.a.e2.c.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, fVar, z) == null) {
            b.a.p0.a.c1.a.a0().a(new e(this, z, fVar));
        }
    }

    public final void y(b.a.p0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) {
            b.a.p0.a.c1.a.a0().g(new d(this, fVar));
        }
    }

    public final void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            A(i2, b.a.p0.a.e2.c.f.d(this.f4976b, new JSONObject()));
        }
    }
}
