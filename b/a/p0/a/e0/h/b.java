package b.a.p0.a.e0.h;

import android.annotation.SuppressLint;
import b.a.p0.a.k;
import b.a.p0.a.v2.q0;
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
    public static final boolean f4722h;

    /* renamed from: i  reason: collision with root package name */
    public static String f4723i;
    public static String j;
    public static String k;
    public static String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f4724a;
    @SuppressLint({"BDOfflineUrl"})

    /* renamed from: b  reason: collision with root package name */
    public String f4725b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4726c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4727d;

    /* renamed from: e  reason: collision with root package name */
    public int f4728e;

    /* renamed from: f  reason: collision with root package name */
    public int f4729f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4730g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1065078386, "Lb/a/p0/a/e0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1065078386, "Lb/a/p0/a/e0/h/b;");
                return;
            }
        }
        f4722h = k.f6397a;
        f4723i = "V8Master";
        j = "page";
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
        this.f4724a = String.valueOf(System.currentTimeMillis());
        this.f4725b = "http://chrome-devtools-frontend.appspot.com/serve_rev/@74dd8d5ea19a92d0e6092e59a0c8bd3a40877b71/inspector.html?ws=localhost:4000";
        this.f4726c = false;
        this.f4727d = true;
        this.f4728e = 0;
        this.f4729f = 0;
        this.f4730g = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.putOpt("title", f4723i);
                jSONObject.putOpt("type", j);
                jSONObject.putOpt("url", k);
                jSONObject.putOpt("webSocketDebuggerUrl", l);
                jSONObject.putOpt("id", this.f4724a);
                jSONObject.putOpt("devtoolsFrontendUrl", this.f4725b);
                jSONObject.putOpt("swanJsVersion", b.a.p0.a.m2.b.h(0));
                jSONObject.putOpt("appVersion", q0.D());
                jSONObject2.putOpt("attached", Boolean.valueOf(this.f4726c));
                jSONObject2.putOpt("empty", Boolean.valueOf(this.f4727d));
                jSONObject2.putOpt("screenX", Integer.valueOf(this.f4728e));
                jSONObject2.putOpt("screenY", Integer.valueOf(this.f4729f));
                jSONObject2.putOpt("visible", Boolean.valueOf(this.f4730g));
                jSONObject.putOpt("description", jSONObject2.toString());
                jSONArray.put(jSONObject);
            } catch (JSONException unused) {
                boolean z = f4722h;
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }
}
