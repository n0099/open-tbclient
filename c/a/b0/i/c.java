package c.a.b0.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.b0.d0.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1745e;

    /* renamed from: f  reason: collision with root package name */
    public int f1746f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1747g;

    /* renamed from: h  reason: collision with root package name */
    public int f1748h;

    /* renamed from: i  reason: collision with root package name */
    public ADConfigError f1749i;

    /* renamed from: j  reason: collision with root package name */
    public j f1750j;

    /* loaded from: classes.dex */
    public class a extends c.a.b0.r.p.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        @Override // c.a.b0.r.p.a
        public void a(Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) {
                try {
                    e(exc);
                } finally {
                    this.a.j();
                }
            }
        }

        public final void e(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
                this.a.f1749i = ADConfigError.error("1", exc.toString());
                if (this.a.f1750j != null) {
                    this.a.f1750j.a(this.a.f1749i);
                }
            }
        }

        public final void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        this.a.f1745e = true;
                        b.d().c();
                        b.d().e(str);
                        return;
                    } catch (ADConfigError e2) {
                        this.a.f1749i = e2;
                        this.a.k();
                        return;
                    }
                }
                this.a.f1749i = ADConfigError.error("1", ADConfigError.REASON_NULL_RESPONSE);
                this.a.k();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.b0.r.p.b
        /* renamed from: g */
        public void b(Headers headers, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048581, this, headers, str, i2) == null) {
                try {
                    f(str);
                } finally {
                    this.a.j();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.b0.r.p.b
        /* renamed from: h */
        public String d(Headers headers, String str, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, headers, str, i2)) == null) {
                if (i2 != 200) {
                    String str2 = i2 + "";
                    if (str != null) {
                        str2 = c.a.b0.u.b.b(str).optString("error_message");
                    }
                    this.a.f1749i = ADConfigError.error("8", str2);
                    this.a.k();
                    this.a.j();
                    return null;
                }
                return str;
            }
            return (String) invokeLLI.objValue;
        }
    }

    public c(int i2, boolean z, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1746f = i2;
        this.f1747g = z;
        this.f1748h = i3;
    }

    @NonNull
    public final JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            c.a.b0.e.f a2 = c.a.b0.e.a.a();
            c.a.b0.u.b.d(jSONObject, "cuid", a2.b());
            c.a.b0.u.b.d(jSONObject, "baiduid", a2.f());
            c.a.b0.u.b.d(jSONObject, "product", a2.q());
            c.a.b0.u.b.d(jSONObject, "bundle_id", a2.packageName());
            c.a.b0.u.b.d(jSONObject, AdExtParam.KEY_NAD_CORE_VERSION, "4.2.1.3");
            c.a.b0.u.b.d(jSONObject, "ot", "2");
            c.a.b0.u.b.d(jSONObject, SearchJsBridge.COOKIE_OV, a2.c());
            c.a.b0.u.b.d(jSONObject, "ua", c.a.b0.e.a.d());
            c.a.b0.u.b.d(jSONObject, "ver", a2.o());
            c.a.b0.u.b.d(jSONObject, "sid", a2.d());
            c.a.b0.u.b.d(jSONObject, HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, String.valueOf(System.currentTimeMillis()));
            c.a.b0.u.b.d(jSONObject, "ext", "");
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Nullable
    public final c.a.b0.r.s.d h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.b0.r.s.c d2 = c.a.b0.r.s.c.d(r.a(g().toString().getBytes()));
            c.a.b0.r.s.d dVar = new c.a.b0.r.s.d();
            dVar.a("Content-Encoding", "gzip");
            dVar.a("Content-Type", "application/json");
            dVar.k("https://afdconf.baidu.com/afd/platform?" + c.a.b0.e.a.a().e());
            dVar.g(this.f1746f * 1000);
            dVar.i(this.f1746f * 1000);
            dVar.j(this.f1746f * 1000);
            dVar.f(d2);
            return dVar;
        }
        return (c.a.b0.r.s.d) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1745e : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e.c().d();
        }
    }

    public final void k() {
        ADConfigError aDConfigError;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aDConfigError = this.f1749i) == null || TextUtils.equals(aDConfigError.reason, ADConfigError.REASON_REQUEST_SUCCESS)) {
            return;
        }
        d.c(this.f1749i, this.f1748h, this.f1747g);
    }

    public void l(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.f1750j = jVar;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.b0.r.s.d h2 = h();
            if (h2 == null) {
                this.f1749i = ADConfigError.error("10", ADConfigError.REASON_BUILD_REQUEST_FAILED);
                k();
                j();
                return;
            }
            c.a.b0.r.g.b().a().a(h2, new a(this));
        }
    }
}
