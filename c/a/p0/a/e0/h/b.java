package c.a.p0.a.e0.h;

import android.annotation.SuppressLint;
import c.a.p0.a.k;
import c.a.p0.a.z2.q0;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.TKBase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f4815h;

    /* renamed from: i  reason: collision with root package name */
    public static String f4816i;

    /* renamed from: j  reason: collision with root package name */
    public static String f4817j;

    /* renamed from: k  reason: collision with root package name */
    public static String f4818k;
    public static String l;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @SuppressLint({"BDOfflineUrl"})

    /* renamed from: b  reason: collision with root package name */
    public String f4819b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4820c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4821d;

    /* renamed from: e  reason: collision with root package name */
    public int f4822e;

    /* renamed from: f  reason: collision with root package name */
    public int f4823f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4824g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1575612563, "Lc/a/p0/a/e0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1575612563, "Lc/a/p0/a/e0/h/b;");
                return;
            }
        }
        f4815h = k.a;
        f4816i = "V8Master";
        f4817j = "page";
        f4818k = "runtime/index.js";
        l = "ws://localhost:4000";
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
        this.a = String.valueOf(System.currentTimeMillis());
        this.f4819b = "http://chrome-devtools-frontend.appspot.com/serve_rev/@74dd8d5ea19a92d0e6092e59a0c8bd3a40877b71/inspector.html?ws=localhost:4000";
        this.f4820c = false;
        this.f4821d = true;
        this.f4822e = 0;
        this.f4823f = 0;
        this.f4824g = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.putOpt("title", f4816i);
                jSONObject.putOpt("type", f4817j);
                jSONObject.putOpt("url", f4818k);
                jSONObject.putOpt("webSocketDebuggerUrl", l);
                jSONObject.putOpt("id", this.a);
                jSONObject.putOpt("devtoolsFrontendUrl", this.f4819b);
                jSONObject.putOpt("swanJsVersion", c.a.p0.a.q2.b.h(0));
                jSONObject.putOpt("appVersion", q0.D());
                jSONObject2.putOpt("attached", Boolean.valueOf(this.f4820c));
                jSONObject2.putOpt(SchemeCollecter.CLASSIFY_EMPTY, Boolean.valueOf(this.f4821d));
                jSONObject2.putOpt("screenX", Integer.valueOf(this.f4822e));
                jSONObject2.putOpt("screenY", Integer.valueOf(this.f4823f));
                jSONObject2.putOpt(TKBase.VISIBILITY_VISIBLE, Boolean.valueOf(this.f4824g));
                jSONObject.putOpt("description", jSONObject2.toString());
                jSONArray.put(jSONObject);
            } catch (JSONException unused) {
                boolean z = f4815h;
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }
}
