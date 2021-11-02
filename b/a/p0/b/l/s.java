package b.a.p0.b.l;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import b.a.p0.a.u.e.a.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
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
public class s extends b.a.p0.a.e2.c.j.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public transient /* synthetic */ FieldHolder $fh;
    public String s;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b extends b.a.p0.a.e2.c.e implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s f9354g;

        public b(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9354g = sVar;
        }

        @Override // b.a.p0.a.e2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean e2 = b.a.p0.a.c1.a.a0().e(this.f9354g.m);
                if (s.t) {
                    String str = "LoginPreparation isLogin : " + e2 + " call stack:" + Log.getStackTraceString(new Exception());
                }
                if (!e2) {
                    this.f9354g.M().j().f(this.f9354g.m, this.f9354g.p, this);
                    return false;
                }
                s sVar = this.f9354g;
                sVar.h(new c(sVar, null));
                return true;
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
                    s sVar = this.f9354g;
                    sVar.h(new c(sVar, null));
                    d();
                }
            }
        }

        public /* synthetic */ b(s sVar, a aVar) {
            this(sVar);
        }
    }

    /* loaded from: classes.dex */
    public class c extends b.a.p0.a.e2.c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s f9355g;

        /* loaded from: classes.dex */
        public class a implements b.a.p0.a.v2.e1.b<Bundle> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f9356e;

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
                this.f9356e = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                    if (bundle == null) {
                        b.a.p0.a.e2.c.d.j("null stoken", Boolean.TRUE);
                        this.f9356e.e(new OAuthException(10001));
                        return;
                    }
                    String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE, "");
                    if (!TextUtils.isEmpty(string)) {
                        this.f9356e.f9355g.s = string;
                        this.f9356e.d();
                        return;
                    }
                    b.a.p0.a.e2.c.d.j("empty stoken", Boolean.TRUE);
                    this.f9356e.e(new OAuthException(10001));
                }
            }
        }

        public /* synthetic */ c(s sVar, a aVar) {
            this(sVar);
        }

        @Override // b.a.p0.a.e2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.p0.b.l.a.t(this.f9355g.m, new a(this), BdZeusUtil.URL_KEY_MACHINE);
                return false;
            }
            return invokeV.booleanValue;
        }

        public c(s sVar) {
            c.C0379c c0379c;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9355g = sVar;
            if (sVar.o == null || (c0379c = sVar.n) == null || !c0379c.f8022a) {
                return;
            }
            long j = c0379c.f8023b;
            if (s.t) {
                String str = "send timeout " + j + "ms msg";
            }
            sVar.o.sendEmptyMessageDelayed(1, j < 0 ? 0L : j);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1036901312, "Lb/a/p0/b/l/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1036901312, "Lb/a/p0/b/l/s;");
                return;
            }
        }
        t = b.a.p0.a.k.f6397a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(Activity activity, c.C0379c c0379c, Bundle bundle) {
        super(activity, c0379c, bundle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, c0379c, bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Activity) objArr2[0], (c.C0379c) objArr2[1], (Bundle) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        x();
        y();
    }

    @Override // b.a.p0.a.e2.c.j.f
    @NonNull
    public b.a.p0.a.e2.c.e Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this, null) : (b.a.p0.a.e2.c.e) invokeV.objValue;
    }

    @Override // b.a.p0.a.e2.c.j.f, b.a.p0.a.e2.c.c
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                boolean isEmpty = TextUtils.isEmpty(this.q);
                jSONObject.put("ma_id", isEmpty ? M().k() : this.q);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("app_key", isEmpty ? M().k() : this.q);
                jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject2.put("host_key_hash", b.a.p0.a.e2.c.d.g());
                jSONObject2.put("stoken", this.s);
                String l = b.a.p0.a.c1.a.n().l();
                if (!TextUtils.isEmpty(l)) {
                    jSONObject2.put("host_api_key", l);
                }
                jSONObject.put("open", jSONObject2);
            } catch (JSONException e2) {
                if (t) {
                    e2.printStackTrace();
                }
            }
            v("data", jSONObject.toString());
            return true;
        }
        return invokeV.booleanValue;
    }
}
