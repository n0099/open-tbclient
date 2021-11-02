package b.a.p0.a.e2.c.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.j2.k;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends h<e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final String[] m;
    public final Context n;
    public boolean o;
    public boolean p;
    public boolean q;
    public b.a.p0.a.e2.c.f r;
    public final String s;
    public final boolean t;
    public boolean u;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: b.a.p0.a.e2.c.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0170b extends b.a.p0.a.e2.c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f4952g;

        /* renamed from: b.a.p0.a.e2.c.j.b$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f4953e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.e2.c.f f4954f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C0170b f4955g;

            /* renamed from: b.a.p0.a.e2.c.j.b$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0171a implements b.a.p0.a.e2.c.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f4956a;

                public C0171a(a aVar) {
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
                    this.f4956a = aVar;
                }

                @Override // b.a.p0.a.e2.c.a
                public void onResult(boolean z) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                        b bVar = this.f4956a.f4955g.f4952g;
                        bVar.p = z;
                        bVar.u = !z;
                        this.f4956a.f4955g.d();
                    }
                }
            }

            public a(C0170b c0170b, Activity activity, b.a.p0.a.e2.c.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0170b, activity, fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4955g = c0170b;
                this.f4953e = activity;
                this.f4954f = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f4953e.isFinishing()) {
                    return;
                }
                b.a.p0.a.e2.c.d.t(this.f4953e, this.f4955g.f4952g.M(), this.f4954f, null, new C0171a(this));
            }
        }

        public C0170b(b bVar) {
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
            this.f4952g = bVar;
        }

        @Override // b.a.p0.a.e2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b bVar = this.f4952g;
                b.a.p0.a.e2.c.f fVar = bVar.r;
                if (fVar == null) {
                    b.a.p0.a.e2.c.d.j("Illegal ScopeInfo", Boolean.TRUE);
                    this.f4952g.d(new OAuthException(10001));
                    k.p(10001, null);
                    return true;
                } else if (fVar.f4907d) {
                    bVar.d(new OAuthException(10005));
                    k.p(10005, fVar);
                    return true;
                } else if (bVar.t || !bVar.p) {
                    return true;
                } else {
                    if (!bVar.o && fVar.j < 0) {
                        bVar.r(new e(false, null));
                        this.f4952g.d(new OAuthException(10005));
                        return true;
                    } else if (fVar.j > 0) {
                        this.f4952g.r(new e(true, null));
                        this.f4952g.c();
                        return true;
                    } else if (this.f4952g.M().c0()) {
                        b.a.p0.a.e2.c.d.j("this operation does not supported when app is invisible.", Boolean.TRUE);
                        this.f4952g.d(new OAuthException(10005));
                        return true;
                    } else {
                        Activity Y = this.f4952g.Y();
                        if (Y == null) {
                            b.a.p0.a.e2.c.d.j("login error context is not activity.", Boolean.TRUE);
                            this.f4952g.d(new OAuthException(10005));
                            return true;
                        }
                        b.a.p0.a.e2.c.d.k(new a(this, Y, fVar));
                        return false;
                    }
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class c extends b.a.p0.a.e2.c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f4957g;

        /* loaded from: classes.dex */
        public class a implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.f> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f4958e;

            public a(c cVar) {
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
                this.f4958e = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(b.a.p0.a.e2.c.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    if (b.a.p0.a.e2.c.c.f4884f) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("ListPreparation result: ");
                        sb.append(fVar == null ? StringUtil.NULL_STRING : fVar);
                        sb.toString();
                    }
                    c cVar = this.f4958e;
                    cVar.f4957g.r = fVar;
                    if (fVar == null) {
                        cVar.e(new Exception("no such scope"));
                        return;
                    }
                    if (fVar.c()) {
                        b bVar = this.f4958e.f4957g;
                        if (!bVar.q) {
                            bVar.h(new d(bVar, null));
                            this.f4958e.d();
                        }
                    }
                    b bVar2 = this.f4958e.f4957g;
                    bVar2.h(new C0170b(bVar2));
                    this.f4958e.d();
                }
            }
        }

        public c(b bVar) {
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
            this.f4957g = bVar;
        }

        @Override // b.a.p0.a.e2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String[] strArr = this.f4957g.m;
                if (strArr != null && strArr.length <= 1) {
                    b.a.p0.a.n1.q.c.a.i(strArr[0], new a(this));
                    return false;
                }
                d();
                return true;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes.dex */
    public class d extends b.a.p0.a.e2.c.e implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f4959g;

        public d(b bVar) {
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
            this.f4959g = bVar;
        }

        @Override // b.a.p0.a.e2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b bVar = this.f4959g;
                bVar.q = true;
                if (bVar.M().j().e(this.f4959g.n)) {
                    b.a.p0.a.e2.c.d.j("LoginPreparation: isLogin true", Boolean.FALSE);
                    b bVar2 = this.f4959g;
                    bVar2.h(new c(bVar2, null));
                    return true;
                }
                b.a.p0.a.a2.e M = this.f4959g.M();
                if (M.c0()) {
                    b.a.p0.a.e2.c.d.j("this operation does not supported when app is invisible.", Boolean.TRUE);
                    e(new OAuthException(10004));
                    return true;
                }
                Activity Y = this.f4959g.Y();
                if (Y == null) {
                    b.a.p0.a.e2.c.d.j("login error context is not activity.", Boolean.TRUE);
                    e(new OAuthException(10004));
                    return true;
                }
                if (!b.a.p0.a.a2.d.g().r().j().e(Y)) {
                    k.N(this.f4959g.l, "passLogin");
                }
                M.j().f(Y, null, this);
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                b.a.p0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    b.a.p0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    e(new OAuthException(10004));
                } else if (i2 != 0) {
                    b.a.p0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                    e(new OAuthException(10004));
                } else {
                    b.a.p0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                    b bVar = this.f4959g;
                    bVar.h(new c(bVar, null));
                    d();
                }
            }
        }

        public /* synthetic */ d(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f4960a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f4961b;

        public e(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4960a = str == null ? "" : str;
            this.f4961b = z;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("Result(%b):%s", Boolean.valueOf(this.f4961b), this.f4960a) : (String) invokeV.objValue;
        }
    }

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2), strArr, str, Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = false;
        this.u = false;
        this.n = context;
        this.o = z;
        this.m = strArr == null ? new String[0] : strArr;
        this.s = str;
        this.p = z2;
        this.t = z3;
    }

    @Override // b.a.p0.a.e2.c.j.h
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.I();
            if (this.u) {
                d(new OAuthException(10003));
                this.u = false;
            }
            if (TextUtils.isEmpty(this.s)) {
                b.a.p0.a.n1.q.c.a.f();
            }
        }
    }

    public Activity Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Context context = this.n;
            if (context instanceof Activity) {
                return (Activity) context;
            }
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P == null) {
                return null;
            }
            return P.x();
        }
        return (Activity) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.e2.c.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: Z */
    public e m(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            JSONObject c2 = b.a.p0.a.e2.c.d.c(jSONObject);
            int optInt = c2.optInt("errno", 10001);
            if (optInt != 0) {
                if (11001 == optInt) {
                    b.a.p0.a.e2.c.d.l(c2);
                    b.a.p0.a.e2.c.d.s("Authorize", c2.toString());
                }
                if (b.a.p0.a.e2.c.c.f4884f) {
                    throw new JSONException("Illegal errno=" + optInt + " errms=" + c2.optString("errms"));
                }
            }
            JSONObject jSONObject2 = c2.getJSONObject("data");
            return new e(this.p, jSONObject2 != null ? jSONObject2.optString("code", "") : "");
        }
        return (e) invokeL.objValue;
    }

    @Override // b.a.p0.a.e2.c.c
    public boolean j() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", M().k());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("app_key", M().k());
                jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject2.put("host_key_hash", b.a.p0.a.e2.c.d.g());
                String l = b.a.p0.a.c1.a.n().l();
                if (!TextUtils.isEmpty(l)) {
                    jSONObject2.put("host_api_key", l);
                }
                jSONObject.put("open", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                for (String str : this.m) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("permit", Boolean.toString(this.p));
                    jSONObject3.put(str, jSONObject4);
                }
                jSONObject.put("accredits", jSONObject3);
                if (!TextUtils.isEmpty(this.s)) {
                    jSONObject.put("provider_appkey", this.s);
                }
            } catch (JSONException e2) {
                if (b.a.p0.a.e2.c.c.f4884f) {
                    e2.printStackTrace();
                }
            }
            v("data", jSONObject.toString());
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.e2.c.c
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            h(new c(this, null));
            return super.k();
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.e2.c.j.h
    public HttpRequest w(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hVar)) == null) ? b.a.p0.a.c1.a.n().C(this.n, hVar.B()) : (HttpRequest) invokeL.objValue;
    }

    @Override // b.a.p0.a.e2.c.j.h
    public SwanInterfaceType z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? SwanInterfaceType.AUTHORIZE : (SwanInterfaceType) invokeV.objValue;
    }
}
