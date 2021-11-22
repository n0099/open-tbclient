package b.a.p0.a.e0.h;

import android.annotation.SuppressLint;
import b.a.p0.a.k;
import b.a.p0.a.z2.q0;
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
    public static final boolean f4703h;

    /* renamed from: i  reason: collision with root package name */
    public static String f4704i;
    public static String j;
    public static String k;
    public static String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f4705a;
    @SuppressLint({"BDOfflineUrl"})

    /* renamed from: b  reason: collision with root package name */
    public String f4706b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4707c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4708d;

    /* renamed from: e  reason: collision with root package name */
    public int f4709e;

    /* renamed from: f  reason: collision with root package name */
    public int f4710f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4711g;

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
        f4703h = k.f6863a;
        f4704i = "V8Master";
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
        this.f4705a = String.valueOf(System.currentTimeMillis());
        this.f4706b = "http://chrome-devtools-frontend.appspot.com/serve_rev/@74dd8d5ea19a92d0e6092e59a0c8bd3a40877b71/inspector.html?ws=localhost:4000";
        this.f4707c = false;
        this.f4708d = true;
        this.f4709e = 0;
        this.f4710f = 0;
        this.f4711g = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.putOpt("title", f4704i);
                jSONObject.putOpt("type", j);
                jSONObject.putOpt("url", k);
                jSONObject.putOpt("webSocketDebuggerUrl", l);
                jSONObject.putOpt("id", this.f4705a);
                jSONObject.putOpt("devtoolsFrontendUrl", this.f4706b);
                jSONObject.putOpt("swanJsVersion", b.a.p0.a.q2.b.h(0));
                jSONObject.putOpt("appVersion", q0.D());
                jSONObject2.putOpt("attached", Boolean.valueOf(this.f4707c));
                jSONObject2.putOpt("empty", Boolean.valueOf(this.f4708d));
                jSONObject2.putOpt("screenX", Integer.valueOf(this.f4709e));
                jSONObject2.putOpt("screenY", Integer.valueOf(this.f4710f));
                jSONObject2.putOpt("visible", Boolean.valueOf(this.f4711g));
                jSONObject.putOpt("description", jSONObject2.toString());
                jSONArray.put(jSONObject);
            } catch (JSONException unused) {
                boolean z = f4703h;
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }
}
