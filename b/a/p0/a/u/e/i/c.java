package b.a.p0.a.u.e.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import b.a.p0.a.z2.d0;
import b.a.p0.a.z2.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
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
    public static final String f8694f;

    /* renamed from: g  reason: collision with root package name */
    public static final MediaType f8695g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f8696a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f8697b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f8698c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8699d;

    /* renamed from: e  reason: collision with root package name */
    public String f8700e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-229987368, "Lb/a/p0/a/u/e/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-229987368, "Lb/a/p0/a/u/e/i/c;");
                return;
            }
        }
        boolean z = b.a.p0.a.k.f6863a;
        f8694f = String.format("%s/ma/call", b.a.p0.a.d0.a.b());
        f8695g = b.a.p0.a.p1.f.f7732a;
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
        this.f8696a = f8694f + "?";
        this.f8697b = new HashMap();
        this.f8698c = new HashMap();
        this.f8699d = false;
        this.f8700e = "";
        d();
        e();
    }

    public final void a() {
        b.a.p0.a.d2.e a0;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (a0 = b.a.p0.a.d2.e.a0()) == null || (f0 = a0.V().f0()) == null) {
            return;
        }
        this.f8698c.put(IAdRequestParam.APV, String.valueOf(f0.versionCode));
    }

    public final void b() {
        b.a.p0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (a0 = b.a.p0.a.d2.e.a0()) == null) {
            return;
        }
        int l = a0.l();
        String i2 = b.a.p0.a.q2.b.i(b.a.p0.a.g1.f.U().M(), l);
        if (l == 0) {
            this.f8698c.put("swan_ver", i2);
        } else if (l == 1) {
            this.f8698c.put("game_ver", i2);
        }
    }

    public void c(@NonNull ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, responseCallback) == null) {
            if (!this.f8699d) {
                responseCallback.onFail(new InvalidParameterException("no service has been set"));
                return;
            }
            String b2 = o0.b(this.f8696a, this.f8698c);
            this.f8696a = b2;
            this.f8696a = b.a.p0.a.d0.c.b(b2);
            b.a.p0.p.d.a aVar = new b.a.p0.p.d.a(this.f8696a, RequestBody.create(f8695g, this.f8700e), responseCallback);
            aVar.f11722c = this.f8697b;
            aVar.f11726g = true;
            b.a.p0.a.e0.d.i("CallServiceRequest", "Start request cloud ability: " + this.f8698c.get("service"));
            b.a.p0.p.e.a.g().e(aVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (b.a.p0.d.c.getContext() == null) {
                b.a.p0.a.e0.d.c("CallServiceRequest", Log.getStackTraceString(new AssertionError("Assertion failed: SwanConfigRuntime.getContext() == null")));
                return;
            }
            this.f8698c.put("host_os", b.a.p0.w.a.f());
            this.f8698c.put("host_os_ver", b.a.p0.w.a.g());
            this.f8698c.put("host_app", b.a.p0.d.c.getContext().c());
            this.f8698c.put("host_app_ver", b.a.p0.d.c.getContext().h());
            this.f8698c.put("sdk_ver", b.a.p0.d.c.getContext().b());
            this.f8698c.put("ua", b.a.p0.w.i.b(b.a.p0.d.c.getContext().h()));
            this.f8698c.put("ut", b.a.p0.a.d0.c.f());
            this.f8698c.put("network", b.a.p0.w.a.e());
            this.f8698c.put("bundle_Id", b.a.p0.a.d2.d.J().getAppId());
            this.f8698c.put("cuid", b.a.p0.d.c.getContext().g());
            this.f8698c.put("uuid", b.a.p0.d.c.getContext().e());
            Map<String, String> map = this.f8698c;
            map.put("sid", b.a.p0.a.c1.a.g0().k() + "");
            this.f8698c.put("source", "swan_sdk");
            this.f8698c.put("timestamp", String.valueOf(System.currentTimeMillis()));
            b();
            a();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f8697b.put("mnpunion", String.valueOf(SwanAppAllianceLoginHelper.f44256d.f() ? 2 : 0));
            this.f8697b.put("Referer", d0.b());
        }
    }

    public void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            if (jSONObject == null) {
                this.f8700e = "";
            } else {
                this.f8700e = jSONObject.toString();
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f8698c.put("service", str);
        this.f8699d = true;
    }
}
