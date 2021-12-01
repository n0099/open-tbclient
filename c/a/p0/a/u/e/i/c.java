package c.a.p0.a.u.e.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.p0.a.z2.d0;
import c.a.p0.a.z2.o0;
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
    public static final String f8250f;

    /* renamed from: g  reason: collision with root package name */
    public static final MediaType f8251g;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f8252b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f8253c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8254d;

    /* renamed from: e  reason: collision with root package name */
    public String f8255e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1123322329, "Lc/a/p0/a/u/e/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1123322329, "Lc/a/p0/a/u/e/i/c;");
                return;
            }
        }
        boolean z = c.a.p0.a.k.a;
        f8250f = String.format("%s/ma/call", c.a.p0.a.d0.a.b());
        f8251g = c.a.p0.a.p1.f.a;
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
        this.a = f8250f + "?";
        this.f8252b = new HashMap();
        this.f8253c = new HashMap();
        this.f8254d = false;
        this.f8255e = "";
        d();
        e();
    }

    public final void a() {
        c.a.p0.a.d2.e a0;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (a0 = c.a.p0.a.d2.e.a0()) == null || (f0 = a0.V().f0()) == null) {
            return;
        }
        this.f8253c.put("app_ver", String.valueOf(f0.versionCode));
    }

    public final void b() {
        c.a.p0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (a0 = c.a.p0.a.d2.e.a0()) == null) {
            return;
        }
        int l = a0.l();
        String i2 = c.a.p0.a.q2.b.i(c.a.p0.a.g1.f.U().M(), l);
        if (l == 0) {
            this.f8253c.put("swan_ver", i2);
        } else if (l == 1) {
            this.f8253c.put("game_ver", i2);
        }
    }

    public void c(@NonNull ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, responseCallback) == null) {
            if (!this.f8254d) {
                responseCallback.onFail(new InvalidParameterException("no service has been set"));
                return;
            }
            String b2 = o0.b(this.a, this.f8253c);
            this.a = b2;
            this.a = c.a.p0.a.d0.c.b(b2);
            c.a.p0.p.d.a aVar = new c.a.p0.p.d.a(this.a, RequestBody.create(f8251g, this.f8255e), responseCallback);
            aVar.f10671c = this.f8252b;
            aVar.f10675g = true;
            c.a.p0.a.e0.d.i("CallServiceRequest", "Start request cloud ability: " + this.f8253c.get("service"));
            c.a.p0.p.e.a.g().e(aVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.a.p0.d.c.getContext() == null) {
                c.a.p0.a.e0.d.c("CallServiceRequest", Log.getStackTraceString(new AssertionError("Assertion failed: SwanConfigRuntime.getContext() == null")));
                return;
            }
            this.f8253c.put("host_os", c.a.p0.w.a.f());
            this.f8253c.put("host_os_ver", c.a.p0.w.a.g());
            this.f8253c.put("host_app", c.a.p0.d.c.getContext().c());
            this.f8253c.put("host_app_ver", c.a.p0.d.c.getContext().h());
            this.f8253c.put("sdk_ver", c.a.p0.d.c.getContext().b());
            this.f8253c.put("ua", c.a.p0.w.i.b(c.a.p0.d.c.getContext().h()));
            this.f8253c.put("ut", c.a.p0.a.d0.c.f());
            this.f8253c.put("network", c.a.p0.w.a.e());
            this.f8253c.put("bundle_Id", c.a.p0.a.d2.d.J().getAppId());
            this.f8253c.put("cuid", c.a.p0.d.c.getContext().g());
            this.f8253c.put("uuid", c.a.p0.d.c.getContext().e());
            Map<String, String> map = this.f8253c;
            map.put("sid", c.a.p0.a.c1.a.g0().k() + "");
            this.f8253c.put("source", "swan_sdk");
            this.f8253c.put("timestamp", String.valueOf(System.currentTimeMillis()));
            b();
            a();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f8252b.put("mnpunion", String.valueOf(SwanAppAllianceLoginHelper.f39311d.f() ? 2 : 0));
            this.f8252b.put("Referer", d0.b());
        }
    }

    public void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            if (jSONObject == null) {
                this.f8255e = "";
            } else {
                this.f8255e = jSONObject.toString();
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f8253c.put("service", str);
        this.f8254d = true;
    }
}
