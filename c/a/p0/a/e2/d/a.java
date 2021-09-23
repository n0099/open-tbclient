package c.a.p0.a.e2.d;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.e2.c.j.a;
import c.a.p0.a.e2.c.j.b;
import c.a.p0.a.j2.k;
import c.a.p0.a.p.d.n;
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
    public final Activity f5620a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5621b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5622c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5623d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<c.a.p0.a.v2.e1.b<a>> f5624e;

    /* renamed from: f  reason: collision with root package name */
    public TaskState f5625f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f5626g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5627h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.a.a2.e f5628i;

    /* renamed from: j  reason: collision with root package name */
    public final c.a.p0.a.q2.a f5629j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public final c.a.p0.a.v2.d1.a o;

    /* renamed from: c.a.p0.a.e2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0177a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5630e;

        public RunnableC0177a(a aVar) {
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
            this.f5630e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f5630e.f5624e) {
                    for (c.a.p0.a.v2.e1.b bVar : this.f5630e.f5624e) {
                        bVar.onCallback(this.f5630e);
                    }
                    this.f5630e.f5624e.clear();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.p0.a.v2.d1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5631f;

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
            this.f5631f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5631f.I();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5632e;

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
            this.f5632e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.i<JSONObject> iVar) {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar != null && iVar.c() && (jSONObject = iVar.f5590a) != null) {
                    c.a.p0.a.e0.d.a("OpenData", "opendata=", jSONObject);
                    this.f5632e.f5629j.b(iVar.f5590a.optInt("errno", 10001));
                    this.f5632e.f5629j.e(iVar.f5590a.optString("errmsg", "internal error"));
                    if (0 != this.f5632e.f5629j.g()) {
                        c.a.p0.a.e2.c.d.j("by errno", Boolean.TRUE);
                        this.f5632e.f5629j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f5632e.B();
                        this.f5632e.z(10001);
                        return;
                    }
                    JSONObject optJSONObject = iVar.f5590a.optJSONObject("data");
                    if (optJSONObject == null) {
                        c.a.p0.a.e2.c.d.j("by data parse", Boolean.TRUE);
                        this.f5632e.f5629j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f5632e.B();
                        this.f5632e.z(10001);
                        return;
                    }
                    c.a.p0.a.e2.c.f e2 = c.a.p0.a.e2.c.f.e(optJSONObject.optJSONObject("scope"));
                    if (e2 == null) {
                        c.a.p0.a.e2.c.d.j("illegal scope", Boolean.TRUE);
                        this.f5632e.f5629j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f5632e.B();
                        this.f5632e.z(10001);
                        return;
                    }
                    this.f5632e.f5626g = optJSONObject.optJSONObject("opendata");
                    if (!this.f5632e.f5623d && (i2 = e2.f5555j) < 0) {
                        if (i2 == -2) {
                            this.f5632e.f5629j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                        } else {
                            this.f5632e.f5629j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                            this.f5632e.A(10005, e2);
                        }
                        this.f5632e.B();
                        return;
                    } else if (e2.f5555j > 0) {
                        if (!this.f5632e.f5627h || !TextUtils.equals(e2.f5547b, "mobile") || (jSONObject2 = this.f5632e.f5626g) == null || jSONObject2.optInt("errno") != 1129) {
                            this.f5632e.B();
                            return;
                        } else {
                            this.f5632e.w(e2, false);
                            return;
                        }
                    } else if (!this.f5632e.f5628i.d0()) {
                        if (!this.f5632e.f5627h && e2.c()) {
                            if (!TextUtils.equals(e2.f5547b, "mobile") || c.a.p0.a.s.a.f.f8500d.f()) {
                                this.f5632e.G();
                            } else {
                                this.f5632e.H();
                            }
                            k.N(this.f5632e.n, "phoneNumberLogin");
                            return;
                        } else if (TextUtils.equals(e2.f5547b, "mobile")) {
                            this.f5632e.v(e2);
                            return;
                        } else {
                            this.f5632e.L(e2);
                            return;
                        }
                    } else {
                        this.f5632e.f5629j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                        this.f5632e.B();
                        this.f5632e.A(10005, e2);
                        return;
                    }
                }
                c.a.p0.a.e2.c.d.j("bad MaOpenData response", Boolean.TRUE);
                this.f5632e.f5629j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                this.f5632e.B();
                this.f5632e.z(10001);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements n.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.e2.c.f f5633a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f5634b;

        public d(a aVar, c.a.p0.a.e2.c.f fVar) {
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
            this.f5634b = aVar;
            this.f5633a = fVar;
        }

        @Override // c.a.p0.a.p.d.n.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c.a.p0.a.e0.d.g("OpenData", "checkPhoneNumberStatus onSuccess isBind = " + z + ". needAuth = true");
                if (z) {
                    this.f5634b.L(this.f5633a);
                } else {
                    this.f5634b.w(this.f5633a, true);
                }
            }
        }

        @Override // c.a.p0.a.p.d.n.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.p0.a.e0.d.g("OpenData", "checkPhoneNumberStatus onFail. needAuth = true");
                this.f5634b.L(this.f5633a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f5635a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.e2.c.f f5636b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f5637c;

        /* renamed from: c.a.p0.a.e2.d.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0178a implements n.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f5638a;

            public C0178a(e eVar) {
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
                this.f5638a = eVar;
            }

            @Override // c.a.p0.a.p.d.n.c
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    c.a.p0.a.e0.d.g("OpenData", "bindPhoneNumber check onSuccess isBind =" + z + ". needAuth = " + this.f5638a.f5635a);
                    if (z) {
                        this.f5638a.f5637c.m = true;
                        this.f5638a.f5637c.K();
                        return;
                    }
                    this.f5638a.f5637c.f5629j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                    this.f5638a.f5637c.B();
                }
            }

            @Override // c.a.p0.a.p.d.n.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c.a.p0.a.e0.d.g("OpenData", "bindPhoneNumber check onFail. needAuth = " + this.f5638a.f5635a);
                    e eVar = this.f5638a;
                    if (eVar.f5635a) {
                        eVar.f5637c.L(eVar.f5636b);
                    } else {
                        eVar.f5637c.B();
                    }
                }
            }
        }

        public e(a aVar, boolean z, c.a.p0.a.e2.c.f fVar) {
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
            this.f5637c = aVar;
            this.f5635a = z;
            this.f5636b = fVar;
        }

        @Override // c.a.p0.a.p.d.n.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.e0.d.g("OpenData", "bindPhoneNumber onFinish. needAuth = " + this.f5635a);
                c.a.p0.a.c1.a.a0().g(new C0178a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.p0.a.e2.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5639a;

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
            this.f5639a = aVar;
        }

        @Override // c.a.p0.a.e2.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.f5639a.f5629j.b(LightappBusinessClient.SVC_ID_H5_TRANSERECORD);
                }
                this.f5639a.J(z);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5640e;

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
            this.f5640e = aVar;
        }

        @Override // c.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                c.a.p0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    c.a.p0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.f5640e.f5629j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f5640e.B();
                } else if (i2 != 0) {
                    c.a.p0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.f5640e.f5629j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f5640e.B();
                } else {
                    c.a.p0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                    this.f5640e.f5627h = true;
                    this.f5640e.l = true;
                    this.f5640e.K();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5641e;

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
            this.f5641e = aVar;
        }

        @Override // c.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                c.a.p0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    c.a.p0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.f5641e.f5629j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f5641e.B();
                } else if (i2 != 0) {
                    c.a.p0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.f5641e.f5629j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f5641e.B();
                } else {
                    c.a.p0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                    this.f5641e.f5627h = true;
                    this.f5641e.K();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<a.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f5642e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5643f;

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
            this.f5643f = aVar;
            this.f5642e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.i<a.b> iVar) {
            a.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!this.f5642e && !this.f5643f.k) {
                    this.f5643f.B();
                } else if (iVar != null && iVar.c() && (bVar = iVar.f5590a) != null && bVar.f5595c != null) {
                    a aVar = this.f5643f;
                    aVar.f5626g = bVar.f5595c;
                    aVar.B();
                } else {
                    c.a.p0.a.q2.a aVar2 = this.f5643f.f5629j;
                    aVar2.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                    aVar2.e("bad Accredit response");
                    this.f5643f.B();
                    this.f5643f.z(10002);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5644e;

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
            this.f5644e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null || !iVar.c()) {
                    c.a.p0.a.q2.a aVar = this.f5644e.f5629j;
                    aVar.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                    aVar.e("bad authorize response");
                    this.f5644e.z(10002);
                }
                this.f5644e.B();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1518473456, "Lc/a/p0/a/e2/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1518473456, "Lc/a/p0/a/e2/d/a;");
                return;
            }
        }
        p = c.a.p0.a.k.f7085a;
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
        this.f5624e = new HashSet();
        this.f5625f = TaskState.INIT;
        this.f5627h = false;
        c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
        aVar.j(8L);
        aVar.e("OpenData");
        this.f5629j = aVar;
        this.k = false;
        this.l = false;
        this.m = false;
        this.o = new b(this);
        this.f5620a = activity;
        this.f5621b = str;
        this.f5622c = str2;
        this.f5623d = z;
        this.n = str3;
    }

    public static void C(Activity activity, String str, String str2, boolean z, String str3, c.a.p0.a.v2.e1.b<a> bVar) {
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
                    c.a.p0.a.e0.d.g("OpenData", "reuse session : " + aVar.toString());
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

    public final void A(int i2, c.a.p0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, fVar) == null) {
            c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
            if (Q == null) {
                boolean z = p;
                return;
            }
            c.a.p0.a.j2.p.d dVar = new c.a.p0.a.j2.p.d();
            dVar.o(i2);
            dVar.r(Q.N());
            dVar.q(k.m(Q.l()));
            dVar.m(Q.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", Q.getAppId());
                jSONObject.put("msg", c.a.p0.a.e2.c.d.f(i2));
                if (fVar != null) {
                    jSONObject.put("scope", fVar.f5547b);
                    jSONObject.put("scopeData", fVar.f5546a);
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
                q.remove(D(this.f5621b, this.f5623d));
            }
            this.f5625f = TaskState.FINISHED;
            if (this.f5626g == null && 0 == this.f5629j.a()) {
                if (this.f5627h) {
                    this.f5629j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                } else {
                    this.f5629j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                }
            }
            c.a.p0.a.e0.d.g("OpenData", "onFinish" + toString());
            c.a.p0.a.e2.c.d.k(new RunnableC0177a(this));
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TaskState.FINISHED == this.f5625f && 0 == this.f5629j.a() && this.f5626g != null : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TaskState.FINISHED == this.f5625f && this.f5626g != null : invokeV.booleanValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f5628i.j().f(this.f5620a, null, new h(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.a.c1.a.a0().j(new g(this));
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f5627h = this.f5628i.j().e(this.f5620a);
            K();
        }
    }

    public final void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (TextUtils.isEmpty(this.f5622c)) {
                c.a.p0.a.e2.c.j.a a2 = c.a.p0.a.a2.d.g().y().a().b().a(this.f5620a, z, this.f5621b, this.f5622c);
                a2.r(this.n);
                a2.p(new i(this, z));
                a2.a();
                return;
            }
            c.a.p0.a.e2.c.j.b d2 = c.a.p0.a.a2.d.g().y().a().b().d(this.f5620a, true, z, new String[]{this.f5621b}, this.f5622c, true);
            d2.r(this.n);
            d2.p(new j(this));
            d2.a();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            k.N(this.n, "requestOpenData");
            c.a.p0.a.e2.c.j.g c2 = c.a.p0.a.a2.d.g().y().a().b().c(this.f5620a, this.f5621b, this.f5622c, this.f5623d, this.f5627h);
            c2.r(this.n);
            c2.p(new c(this));
            c2.a();
        }
    }

    public final void L(@NonNull c.a.p0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            c.a.p0.a.e2.c.d.t(this.f5620a, this.f5628i, fVar, this.f5626g, new f(this));
        }
    }

    public final void M(c.a.p0.a.v2.e1.b<a> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            c.a.p0.a.e0.d.g("OpenData", "start session : " + this.f5621b);
            this.f5625f = TaskState.CALLING;
            this.k = TextUtils.equals(this.f5621b, "snsapi_userinfo");
            u(bVar);
            c.a.p0.a.a2.e i2 = c.a.p0.a.a2.e.i();
            this.f5628i = i2;
            if (i2 == null) {
                c.a.p0.a.e2.c.d.j("SwanApp is null", Boolean.TRUE);
                this.f5629j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                B();
                z(10001);
                return;
            }
            i2.T().f5414f.d(this.o);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.f5621b, Boolean.valueOf(E()), super.toString()));
            sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.f5629j));
            if (this.f5626g != null) {
                sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.f5626g));
            }
            sb.append(String.format(Locale.getDefault(), "state=%s\n", this.f5625f));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final a u(c.a.p0.a.v2.e1.b<a> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bVar)) == null) {
            if (bVar == null) {
                return this;
            }
            synchronized (this.f5624e) {
                this.f5624e.add(bVar);
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final void v(c.a.p0.a.e2.c.f fVar) {
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

    public final void w(c.a.p0.a.e2.c.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, fVar, z) == null) {
            c.a.p0.a.c1.a.a0().a(new e(this, z, fVar));
        }
    }

    public final void y(c.a.p0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) {
            c.a.p0.a.c1.a.a0().g(new d(this, fVar));
        }
    }

    public final void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            A(i2, c.a.p0.a.e2.c.f.d(this.f5621b, new JSONObject()));
        }
    }
}
