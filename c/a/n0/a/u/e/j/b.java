package c.a.n0.a.u.e.j;

import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.k;
import c.a.n0.a.v2.d0;
import c.a.n0.a.v2.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final String f8682f;

    /* renamed from: g  reason: collision with root package name */
    public static final MediaType f8683g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f8684a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f8685b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f8686c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8687d;

    /* renamed from: e  reason: collision with root package name */
    public String f8688e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1710158103, "Lc/a/n0/a/u/e/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1710158103, "Lc/a/n0/a/u/e/j/b;");
                return;
            }
        }
        boolean z = k.f6803a;
        f8682f = String.format("%s/ma/call", c.a.n0.a.d0.a.d());
        f8683g = c.a.n0.a.n1.f.f7306a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8684a = f8682f + "?";
        this.f8685b = new HashMap();
        this.f8686c = new HashMap();
        this.f8687d = false;
        this.f8688e = "";
        d();
        e();
    }

    public final void a() {
        c.a.n0.a.a2.e Q;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (Q = c.a.n0.a.a2.e.Q()) == null || (f0 = Q.L().f0()) == null) {
            return;
        }
        this.f8686c.put(IAdRequestParam.APV, String.valueOf(f0.versionCode));
    }

    public final void b() {
        c.a.n0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (Q = c.a.n0.a.a2.e.Q()) == null) {
            return;
        }
        int l = Q.l();
        String i2 = c.a.n0.a.m2.b.i(c.a.n0.a.g1.f.V().N(), l);
        if (l == 0) {
            this.f8686c.put("swan_ver", i2);
        } else if (l == 1) {
            this.f8686c.put("game_ver", i2);
        }
    }

    public void c(ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, responseCallback) == null) {
            if (!this.f8687d) {
                responseCallback.onFail(new InvalidParameterException("no service has been set"));
                return;
            }
            String b2 = o0.b(this.f8684a, this.f8686c);
            this.f8684a = b2;
            this.f8684a = c.a.n0.a.d0.c.b(b2);
            c.a.n0.m.d.a aVar = new c.a.n0.m.d.a(this.f8684a, RequestBody.create(f8683g, this.f8688e), responseCallback);
            aVar.f11568c = this.f8685b;
            aVar.f11572g = true;
            c.a.n0.a.e0.d.g("CallServiceRequest", "Start request cloud ability: " + this.f8686c.get("service"));
            c.a.n0.m.e.a.g().e(aVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.a.n0.d.c.a() == null) {
                c.a.n0.a.e0.d.b("CallServiceRequest", Log.getStackTraceString(new AssertionError("Assertion failed: SwanConfigRuntime.getContext() == null")));
                return;
            }
            this.f8686c.put("host_os", c.a.n0.t.a.f());
            this.f8686c.put("host_os_ver", c.a.n0.t.a.g());
            this.f8686c.put("host_app", c.a.n0.d.c.a().c());
            this.f8686c.put("host_app_ver", c.a.n0.d.c.a().i());
            this.f8686c.put("sdk_ver", c.a.n0.d.c.a().b());
            this.f8686c.put("ua", c.a.n0.t.i.b(c.a.n0.d.c.a().i()));
            this.f8686c.put("ut", c.a.n0.a.d0.c.f());
            this.f8686c.put("network", c.a.n0.t.a.e());
            this.f8686c.put("bundle_Id", c.a.n0.a.a2.d.g().getAppId());
            this.f8686c.put("cuid", c.a.n0.d.c.a().h());
            this.f8686c.put("uuid", c.a.n0.d.c.a().e());
            Map<String, String> map = this.f8686c;
            map.put("sid", c.a.n0.a.c1.a.Z().k() + "");
            this.f8686c.put("source", "swan_sdk");
            this.f8686c.put("timestamp", String.valueOf(System.currentTimeMillis()));
            b();
            a();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f8685b.put("mnpunion", String.valueOf(c.a.n0.a.s.a.f.f8218d.f() ? 2 : 0));
            this.f8685b.put("Referer", d0.b());
        }
    }

    public void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            if (jSONObject == null) {
                this.f8688e = "";
            } else {
                this.f8688e = jSONObject.toString();
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f8686c.put("service", str);
        this.f8687d = true;
    }
}
