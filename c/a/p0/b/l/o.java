package c.a.p0.b.l;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import c.a.p0.a.e2.c.j.b;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o extends c.a.p0.a.e2.c.j.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String v;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b extends c.a.p0.a.e2.c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ o f10124g;

        /* loaded from: classes.dex */
        public class a implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.f> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f10125e;

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
                this.f10125e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(c.a.p0.a.e2.c.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    if (c.a.p0.a.e2.c.c.f5526f) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("ListPreparation result: ");
                        sb.append(fVar == null ? StringUtil.NULL_STRING : fVar);
                        sb.toString();
                    }
                    this.f10125e.f10124g.r = fVar;
                    if (fVar == null) {
                        this.f10125e.e(new Exception("no such scope"));
                        return;
                    }
                    if (fVar.c() && !this.f10125e.f10124g.q) {
                        o oVar = this.f10125e.f10124g;
                        oVar.i(new c(oVar, null));
                    } else {
                        o oVar2 = this.f10125e.f10124g;
                        oVar2.i(new b.C0175b(oVar2));
                    }
                    this.f10125e.d();
                }
            }
        }

        public b(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10124g = oVar;
        }

        @Override // c.a.p0.a.e2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (TextUtils.isEmpty(this.f10124g.s)) {
                    if (this.f10124g.m.length <= 1) {
                        c.a.p0.a.n1.q.c.a.i(this.f10124g.m[0], new a(this));
                        return false;
                    }
                    d();
                    return false;
                }
                d();
                return false;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ b(o oVar, a aVar) {
            this(oVar);
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.p0.a.e2.c.e implements c.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ o f10126g;

        public c(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10126g = oVar;
        }

        @Override // c.a.p0.a.e2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f10126g.q = true;
                if (this.f10126g.N().j().e(this.f10126g.n)) {
                    c.a.p0.a.e2.c.d.j("LoginPreparation: isLogin true", Boolean.FALSE);
                    o oVar = this.f10126g;
                    oVar.i(new d(oVar, null));
                    return true;
                }
                c.a.p0.a.a2.e N = this.f10126g.N();
                if (!N.d0()) {
                    if (this.f10126g.n instanceof Activity) {
                        N.j().f((Activity) this.f10126g.n, null, this);
                        return false;
                    }
                    c.a.p0.a.e2.c.d.j("login error context is not activity.", Boolean.TRUE);
                    e(new OAuthException(10004));
                    return true;
                }
                c.a.p0.a.e2.c.d.j("this operation does not supported when app is invisible.", Boolean.TRUE);
                e(new OAuthException(10004));
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.p0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    c.a.p0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    e(new OAuthException(10004));
                } else if (i2 != 0) {
                    c.a.p0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                    e(new OAuthException(10004));
                } else {
                    c.a.p0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                    o oVar = this.f10126g;
                    oVar.i(new d(oVar, null));
                    d();
                }
            }
        }

        public /* synthetic */ c(o oVar, a aVar) {
            this(oVar);
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.p0.a.e2.c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ o f10127g;

        /* loaded from: classes.dex */
        public class a implements c.a.p0.a.v2.e1.b<Bundle> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f10128e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10128e = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                    if (bundle == null) {
                        this.f10128e.e(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE, "");
                    if (!TextUtils.isEmpty(string)) {
                        this.f10128e.f10127g.v = string;
                        o oVar = this.f10128e.f10127g;
                        oVar.i(new b(oVar, null));
                        this.f10128e.d();
                        return;
                    }
                    this.f10128e.e(new OAuthException("empty stoken", 10001));
                }
            }
        }

        public d(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10127g = oVar;
        }

        @Override // c.a.p0.a.e2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.b.l.a.t(this.f10127g.n, new a(this), BdZeusUtil.URL_KEY_MACHINE);
                return false;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ d(o oVar, a aVar) {
            this(oVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        super(context, z, z2, strArr, str, z3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2), strArr, str, Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue(), (String[]) objArr2[3], (String) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (z2) {
            z();
        }
    }

    @Override // c.a.p0.a.e2.c.j.b, c.a.p0.a.e2.c.j.h
    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.J();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.e2.c.j.b, c.a.p0.a.e2.c.c
    /* renamed from: a0 */
    public b.e n(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            Context context = this.n;
            if (context instanceof Activity) {
                c.a.p0.b.l.a.E((Activity) context, jSONObject);
            } else if (c.a.p0.a.e2.c.c.f5526f) {
                Log.getStackTraceString(new Exception("context is not activity."));
            }
            return super.n(jSONObject);
        }
        return (b.e) invokeL.objValue;
    }

    @Override // c.a.p0.a.e2.c.j.b, c.a.p0.a.e2.c.c
    public boolean k() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", N().D());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("app_key", N().D());
                jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject2.put("host_key_hash", c.a.p0.a.e2.c.d.g());
                jSONObject2.put("stoken", this.v);
                String l = c.a.p0.a.c1.a.n().l();
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
                e2.printStackTrace();
            }
            w("data", jSONObject.toString());
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.e2.c.j.b, c.a.p0.a.e2.c.c
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (N().j().e(this.n)) {
                i(new d(this, null));
                return true;
            }
            i(new b(this, null));
            return true;
        }
        return invokeV.booleanValue;
    }
}
