package c.a.n0.a.k.e.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.n0.a.p2.d0;
import c.a.n0.a.p2.o0;
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
    public static final String f5099f;

    /* renamed from: g  reason: collision with root package name */
    public static final MediaType f5100g;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f5101b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f5102c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5103d;

    /* renamed from: e  reason: collision with root package name */
    public String f5104e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1461894177, "Lc/a/n0/a/k/e/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1461894177, "Lc/a/n0/a/k/e/i/c;");
                return;
            }
        }
        boolean z = c.a.n0.a.a.a;
        f5099f = String.format("%s/ma/call", c.a.n0.a.t.a.b());
        f5100g = c.a.n0.a.f1.f.a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = f5099f + "?";
        this.f5101b = new HashMap();
        this.f5102c = new HashMap();
        this.f5103d = false;
        this.f5104e = "";
        d();
        e();
    }

    public final void a() {
        c.a.n0.a.t1.e a0;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (a0 = c.a.n0.a.t1.e.a0()) == null || (f0 = a0.V().f0()) == null) {
            return;
        }
        this.f5102c.put("app_ver", String.valueOf(f0.versionCode));
    }

    public final void b() {
        c.a.n0.a.t1.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (a0 = c.a.n0.a.t1.e.a0()) == null) {
            return;
        }
        int l = a0.l();
        String i = c.a.n0.a.g2.b.i(c.a.n0.a.w0.f.U().M(), l);
        if (l == 0) {
            this.f5102c.put("swan_ver", i);
        } else if (l == 1) {
            this.f5102c.put("game_ver", i);
        }
    }

    public void c(@NonNull ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, responseCallback) == null) {
            if (!this.f5103d) {
                responseCallback.onFail(new InvalidParameterException("no service has been set"));
                return;
            }
            String b2 = o0.b(this.a, this.f5102c);
            this.a = b2;
            this.a = c.a.n0.a.t.c.b(b2);
            c.a.n0.p.d.a aVar = new c.a.n0.p.d.a(this.a, RequestBody.create(f5100g, this.f5104e), responseCallback);
            aVar.f9107c = this.f5101b;
            aVar.f9111g = true;
            c.a.n0.a.u.d.i("CallServiceRequest", "Start request cloud ability: " + this.f5102c.get("service"));
            c.a.n0.p.e.a.g().e(aVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.a.n0.d.c.getContext() == null) {
                c.a.n0.a.u.d.c("CallServiceRequest", Log.getStackTraceString(new AssertionError("Assertion failed: SwanConfigRuntime.getContext() == null")));
                return;
            }
            this.f5102c.put("host_os", c.a.n0.w.a.f());
            this.f5102c.put("host_os_ver", c.a.n0.w.a.g());
            this.f5102c.put("host_app", c.a.n0.d.c.getContext().c());
            this.f5102c.put("host_app_ver", c.a.n0.d.c.getContext().h());
            this.f5102c.put("sdk_ver", c.a.n0.d.c.getContext().b());
            this.f5102c.put("ua", c.a.n0.w.i.b(c.a.n0.d.c.getContext().h()));
            this.f5102c.put("ut", c.a.n0.a.t.c.f());
            this.f5102c.put("network", c.a.n0.w.a.e());
            this.f5102c.put("bundle_Id", c.a.n0.a.t1.d.J().getAppId());
            this.f5102c.put("cuid", c.a.n0.d.c.getContext().g());
            this.f5102c.put("uuid", c.a.n0.d.c.getContext().e());
            Map<String, String> map = this.f5102c;
            map.put("sid", c.a.n0.a.s0.a.g0().k() + "");
            this.f5102c.put("source", "swan_sdk");
            this.f5102c.put("timestamp", String.valueOf(System.currentTimeMillis()));
            b();
            a();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f5101b.put("mnpunion", String.valueOf(SwanAppAllianceLoginHelper.f28743d.f() ? 2 : 0));
            this.f5101b.put("Referer", d0.b());
        }
    }

    public void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            if (jSONObject == null) {
                this.f5104e = "";
            } else {
                this.f5104e = jSONObject.toString();
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f5102c.put("service", str);
        this.f5103d = true;
    }
}
