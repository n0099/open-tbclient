package c.a.r0.a.u.e.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.r0.a.z2.d0;
import c.a.r0.a.z2.o0;
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
    public static final String f9234f;

    /* renamed from: g  reason: collision with root package name */
    public static final MediaType f9235g;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f9236b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f9237c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9238d;

    /* renamed from: e  reason: collision with root package name */
    public String f9239e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(536516315, "Lc/a/r0/a/u/e/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(536516315, "Lc/a/r0/a/u/e/i/c;");
                return;
            }
        }
        boolean z = c.a.r0.a.k.a;
        f9234f = String.format("%s/ma/call", c.a.r0.a.d0.a.b());
        f9235g = c.a.r0.a.p1.f.a;
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
        this.a = f9234f + "?";
        this.f9236b = new HashMap();
        this.f9237c = new HashMap();
        this.f9238d = false;
        this.f9239e = "";
        d();
        e();
    }

    public final void a() {
        c.a.r0.a.d2.e a0;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (a0 = c.a.r0.a.d2.e.a0()) == null || (f0 = a0.V().f0()) == null) {
            return;
        }
        this.f9237c.put("app_ver", String.valueOf(f0.versionCode));
    }

    public final void b() {
        c.a.r0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (a0 = c.a.r0.a.d2.e.a0()) == null) {
            return;
        }
        int l = a0.l();
        String i2 = c.a.r0.a.q2.b.i(c.a.r0.a.g1.f.U().M(), l);
        if (l == 0) {
            this.f9237c.put("swan_ver", i2);
        } else if (l == 1) {
            this.f9237c.put("game_ver", i2);
        }
    }

    public void c(@NonNull ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, responseCallback) == null) {
            if (!this.f9238d) {
                responseCallback.onFail(new InvalidParameterException("no service has been set"));
                return;
            }
            String b2 = o0.b(this.a, this.f9237c);
            this.a = b2;
            this.a = c.a.r0.a.d0.c.b(b2);
            c.a.r0.p.d.a aVar = new c.a.r0.p.d.a(this.a, RequestBody.create(f9235g, this.f9239e), responseCallback);
            aVar.f11592c = this.f9236b;
            aVar.f11596g = true;
            c.a.r0.a.e0.d.i("CallServiceRequest", "Start request cloud ability: " + this.f9237c.get("service"));
            c.a.r0.p.e.a.g().e(aVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.a.r0.d.c.getContext() == null) {
                c.a.r0.a.e0.d.c("CallServiceRequest", Log.getStackTraceString(new AssertionError("Assertion failed: SwanConfigRuntime.getContext() == null")));
                return;
            }
            this.f9237c.put("host_os", c.a.r0.w.a.f());
            this.f9237c.put("host_os_ver", c.a.r0.w.a.g());
            this.f9237c.put("host_app", c.a.r0.d.c.getContext().c());
            this.f9237c.put("host_app_ver", c.a.r0.d.c.getContext().h());
            this.f9237c.put("sdk_ver", c.a.r0.d.c.getContext().b());
            this.f9237c.put("ua", c.a.r0.w.i.b(c.a.r0.d.c.getContext().h()));
            this.f9237c.put("ut", c.a.r0.a.d0.c.f());
            this.f9237c.put("network", c.a.r0.w.a.e());
            this.f9237c.put("bundle_Id", c.a.r0.a.d2.d.J().getAppId());
            this.f9237c.put("cuid", c.a.r0.d.c.getContext().g());
            this.f9237c.put("uuid", c.a.r0.d.c.getContext().e());
            Map<String, String> map = this.f9237c;
            map.put("sid", c.a.r0.a.c1.a.g0().k() + "");
            this.f9237c.put("source", "swan_sdk");
            this.f9237c.put("timestamp", String.valueOf(System.currentTimeMillis()));
            b();
            a();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f9236b.put("mnpunion", String.valueOf(SwanAppAllianceLoginHelper.f38661d.f() ? 2 : 0));
            this.f9236b.put("Referer", d0.b());
        }
    }

    public void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            if (jSONObject == null) {
                this.f9239e = "";
            } else {
                this.f9239e = jSONObject.toString();
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f9237c.put("service", str);
        this.f9238d = true;
    }
}
