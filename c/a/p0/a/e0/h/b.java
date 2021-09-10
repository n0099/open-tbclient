package c.a.p0.a.e0.h;

import android.annotation.SuppressLint;
import c.a.p0.a.k;
import c.a.p0.a.v2.q0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f5348h;

    /* renamed from: i  reason: collision with root package name */
    public static String f5349i;

    /* renamed from: j  reason: collision with root package name */
    public static String f5350j;
    public static String k;
    public static String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f5351a;
    @SuppressLint({"BDOfflineUrl"})

    /* renamed from: b  reason: collision with root package name */
    public String f5352b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5353c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5354d;

    /* renamed from: e  reason: collision with root package name */
    public int f5355e;

    /* renamed from: f  reason: collision with root package name */
    public int f5356f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5357g;

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
        f5348h = k.f7077a;
        f5349i = "V8Master";
        f5350j = "page";
        k = "runtime/index.js";
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
        this.f5351a = String.valueOf(System.currentTimeMillis());
        this.f5352b = "http://chrome-devtools-frontend.appspot.com/serve_rev/@74dd8d5ea19a92d0e6092e59a0c8bd3a40877b71/inspector.html?ws=localhost:4000";
        this.f5353c = false;
        this.f5354d = true;
        this.f5355e = 0;
        this.f5356f = 0;
        this.f5357g = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.putOpt("title", f5349i);
                jSONObject.putOpt("type", f5350j);
                jSONObject.putOpt("url", k);
                jSONObject.putOpt("webSocketDebuggerUrl", l);
                jSONObject.putOpt("id", this.f5351a);
                jSONObject.putOpt("devtoolsFrontendUrl", this.f5352b);
                jSONObject.putOpt("swanJsVersion", c.a.p0.a.m2.b.h(0));
                jSONObject.putOpt("appVersion", q0.D());
                jSONObject2.putOpt("attached", Boolean.valueOf(this.f5353c));
                jSONObject2.putOpt("empty", Boolean.valueOf(this.f5354d));
                jSONObject2.putOpt("screenX", Integer.valueOf(this.f5355e));
                jSONObject2.putOpt("screenY", Integer.valueOf(this.f5356f));
                jSONObject2.putOpt("visible", Boolean.valueOf(this.f5357g));
                jSONObject.putOpt("description", jSONObject2.toString());
                jSONArray.put(jSONObject);
            } catch (JSONException unused) {
                boolean z = f5348h;
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }
}
