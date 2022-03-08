package c.a.p0.a.k.e.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.p0.a.p2.d0;
import c.a.p0.a.p2.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
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
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final String f6062f;

    /* renamed from: g  reason: collision with root package name */
    public static final MediaType f6063g;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f6064b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f6065c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6066d;

    /* renamed from: e  reason: collision with root package name */
    public String f6067e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(875088163, "Lc/a/p0/a/k/e/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(875088163, "Lc/a/p0/a/k/e/i/c;");
                return;
            }
        }
        boolean z = c.a.p0.a.a.a;
        f6062f = String.format("%s/ma/call", c.a.p0.a.t.a.b());
        f6063g = c.a.p0.a.f1.f.a;
    }

    public c() {
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
        this.a = f6062f + "?";
        this.f6064b = new HashMap();
        this.f6065c = new HashMap();
        this.f6066d = false;
        this.f6067e = "";
        d();
        e();
    }

    public final void a() {
        c.a.p0.a.t1.e a0;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (a0 = c.a.p0.a.t1.e.a0()) == null || (f0 = a0.V().f0()) == null) {
            return;
        }
        this.f6065c.put("app_ver", String.valueOf(f0.versionCode));
    }

    public final void b() {
        c.a.p0.a.t1.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (a0 = c.a.p0.a.t1.e.a0()) == null) {
            return;
        }
        int l = a0.l();
        String i2 = c.a.p0.a.g2.b.i(c.a.p0.a.w0.f.U().M(), l);
        if (l == 0) {
            this.f6065c.put("swan_ver", i2);
        } else if (l == 1) {
            this.f6065c.put("game_ver", i2);
        }
    }

    public void c(@NonNull ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, responseCallback) == null) {
            if (!this.f6066d) {
                responseCallback.onFail(new InvalidParameterException("no service has been set"));
                return;
            }
            String b2 = o0.b(this.a, this.f6065c);
            this.a = b2;
            this.a = c.a.p0.a.t.c.b(b2);
            c.a.p0.p.d.a aVar = new c.a.p0.p.d.a(this.a, RequestBody.create(f6063g, this.f6067e), responseCallback);
            aVar.f10917c = this.f6064b;
            aVar.f10921g = true;
            c.a.p0.a.u.d.i("CallServiceRequest", "Start request cloud ability: " + this.f6065c.get("service"));
            c.a.p0.p.e.a.g().e(aVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.a.p0.d.c.getContext() == null) {
                c.a.p0.a.u.d.c("CallServiceRequest", Log.getStackTraceString(new AssertionError("Assertion failed: SwanConfigRuntime.getContext() == null")));
                return;
            }
            this.f6065c.put("host_os", c.a.p0.w.a.f());
            this.f6065c.put("host_os_ver", c.a.p0.w.a.g());
            this.f6065c.put("host_app", c.a.p0.d.c.getContext().c());
            this.f6065c.put("host_app_ver", c.a.p0.d.c.getContext().h());
            this.f6065c.put("sdk_ver", c.a.p0.d.c.getContext().b());
            this.f6065c.put("ua", c.a.p0.w.i.b(c.a.p0.d.c.getContext().h()));
            this.f6065c.put("ut", c.a.p0.a.t.c.f());
            this.f6065c.put("network", c.a.p0.w.a.e());
            this.f6065c.put("bundle_Id", c.a.p0.a.t1.d.J().getAppId());
            this.f6065c.put("cuid", c.a.p0.d.c.getContext().g());
            this.f6065c.put("uuid", c.a.p0.d.c.getContext().e());
            Map<String, String> map = this.f6065c;
            map.put("sid", c.a.p0.a.s0.a.g0().k() + "");
            this.f6065c.put("source", "swan_sdk");
            this.f6065c.put("timestamp", String.valueOf(System.currentTimeMillis()));
            b();
            a();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f6064b.put("mnpunion", String.valueOf(SwanAppAllianceLoginHelper.f37293d.f() ? 2 : 0));
            this.f6064b.put("Referer", d0.b());
        }
    }

    public void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            if (jSONObject == null) {
                this.f6067e = "";
            } else {
                this.f6067e = jSONObject.toString();
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f6065c.put("service", str);
        this.f6066d = true;
    }
}
