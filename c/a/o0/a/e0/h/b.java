package c.a.o0.a.e0.h;

import android.annotation.SuppressLint;
import c.a.o0.a.k;
import c.a.o0.a.v2.q0;
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
    public static final boolean f5320h;

    /* renamed from: i  reason: collision with root package name */
    public static String f5321i;

    /* renamed from: j  reason: collision with root package name */
    public static String f5322j;
    public static String k;
    public static String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f5323a;
    @SuppressLint({"BDOfflineUrl"})

    /* renamed from: b  reason: collision with root package name */
    public String f5324b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5325c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5326d;

    /* renamed from: e  reason: collision with root package name */
    public int f5327e;

    /* renamed from: f  reason: collision with root package name */
    public int f5328f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5329g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1704695282, "Lc/a/o0/a/e0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1704695282, "Lc/a/o0/a/e0/h/b;");
                return;
            }
        }
        f5320h = k.f7049a;
        f5321i = "V8Master";
        f5322j = "page";
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
        this.f5323a = String.valueOf(System.currentTimeMillis());
        this.f5324b = "http://chrome-devtools-frontend.appspot.com/serve_rev/@74dd8d5ea19a92d0e6092e59a0c8bd3a40877b71/inspector.html?ws=localhost:4000";
        this.f5325c = false;
        this.f5326d = true;
        this.f5327e = 0;
        this.f5328f = 0;
        this.f5329g = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.putOpt("title", f5321i);
                jSONObject.putOpt("type", f5322j);
                jSONObject.putOpt("url", k);
                jSONObject.putOpt("webSocketDebuggerUrl", l);
                jSONObject.putOpt("id", this.f5323a);
                jSONObject.putOpt("devtoolsFrontendUrl", this.f5324b);
                jSONObject.putOpt("swanJsVersion", c.a.o0.a.m2.b.h(0));
                jSONObject.putOpt("appVersion", q0.D());
                jSONObject2.putOpt("attached", Boolean.valueOf(this.f5325c));
                jSONObject2.putOpt("empty", Boolean.valueOf(this.f5326d));
                jSONObject2.putOpt("screenX", Integer.valueOf(this.f5327e));
                jSONObject2.putOpt("screenY", Integer.valueOf(this.f5328f));
                jSONObject2.putOpt("visible", Boolean.valueOf(this.f5329g));
                jSONObject.putOpt("description", jSONObject2.toString());
                jSONArray.put(jSONObject);
            } catch (JSONException unused) {
                boolean z = f5320h;
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }
}
