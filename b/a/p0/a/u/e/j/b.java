package b.a.p0.a.u.e.j;

import android.text.TextUtils;
import android.util.Log;
import b.a.p0.a.k;
import b.a.p0.a.v2.d0;
import b.a.p0.a.v2.o0;
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
    public static final String f8222f;

    /* renamed from: g  reason: collision with root package name */
    public static final MediaType f8223g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f8224a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f8225b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f8226c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8227d;

    /* renamed from: e  reason: collision with root package name */
    public String f8228e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-229957608, "Lb/a/p0/a/u/e/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-229957608, "Lb/a/p0/a/u/e/j/b;");
                return;
            }
        }
        boolean z = k.f6397a;
        f8222f = String.format("%s/ma/call", b.a.p0.a.d0.a.d());
        f8223g = b.a.p0.a.n1.f.f6891a;
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
        this.f8224a = f8222f + "?";
        this.f8225b = new HashMap();
        this.f8226c = new HashMap();
        this.f8227d = false;
        this.f8228e = "";
        d();
        e();
    }

    public final void a() {
        b.a.p0.a.a2.e P;
        PMSAppInfo e0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (P = b.a.p0.a.a2.e.P()) == null || (e0 = P.K().e0()) == null) {
            return;
        }
        this.f8226c.put(IAdRequestParam.APV, String.valueOf(e0.versionCode));
    }

    public final void b() {
        b.a.p0.a.a2.e P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (P = b.a.p0.a.a2.e.P()) == null) {
            return;
        }
        int l = P.l();
        String i2 = b.a.p0.a.m2.b.i(b.a.p0.a.g1.f.T().L(), l);
        if (l == 0) {
            this.f8226c.put("swan_ver", i2);
        } else if (l == 1) {
            this.f8226c.put("game_ver", i2);
        }
    }

    public void c(ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, responseCallback) == null) {
            if (!this.f8227d) {
                responseCallback.onFail(new InvalidParameterException("no service has been set"));
                return;
            }
            String b2 = o0.b(this.f8224a, this.f8226c);
            this.f8224a = b2;
            this.f8224a = b.a.p0.a.d0.c.b(b2);
            b.a.p0.m.d.a aVar = new b.a.p0.m.d.a(this.f8224a, RequestBody.create(f8223g, this.f8228e), responseCallback);
            aVar.f11035c = this.f8225b;
            aVar.f11039g = true;
            b.a.p0.a.e0.d.g("CallServiceRequest", "Start request cloud ability: " + this.f8226c.get("service"));
            b.a.p0.m.e.a.g().e(aVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (b.a.p0.d.c.getContext() == null) {
                b.a.p0.a.e0.d.b("CallServiceRequest", Log.getStackTraceString(new AssertionError("Assertion failed: SwanConfigRuntime.getContext() == null")));
                return;
            }
            this.f8226c.put("host_os", b.a.p0.t.a.f());
            this.f8226c.put("host_os_ver", b.a.p0.t.a.g());
            this.f8226c.put("host_app", b.a.p0.d.c.getContext().c());
            this.f8226c.put("host_app_ver", b.a.p0.d.c.getContext().i());
            this.f8226c.put("sdk_ver", b.a.p0.d.c.getContext().b());
            this.f8226c.put("ua", b.a.p0.t.i.b(b.a.p0.d.c.getContext().i()));
            this.f8226c.put("ut", b.a.p0.a.d0.c.f());
            this.f8226c.put("network", b.a.p0.t.a.e());
            this.f8226c.put("bundle_Id", b.a.p0.a.a2.d.g().getAppId());
            this.f8226c.put("cuid", b.a.p0.d.c.getContext().h());
            this.f8226c.put("uuid", b.a.p0.d.c.getContext().e());
            Map<String, String> map = this.f8226c;
            map.put("sid", b.a.p0.a.c1.a.Z().k() + "");
            this.f8226c.put("source", "swan_sdk");
            this.f8226c.put("timestamp", String.valueOf(System.currentTimeMillis()));
            b();
            a();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f8225b.put("mnpunion", String.valueOf(b.a.p0.a.s.a.f.f7771d.f() ? 2 : 0));
            this.f8225b.put("Referer", d0.b());
        }
    }

    public void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            if (jSONObject == null) {
                this.f8228e = "";
            } else {
                this.f8228e = jSONObject.toString();
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f8226c.put("service", str);
        this.f8227d = true;
    }
}
