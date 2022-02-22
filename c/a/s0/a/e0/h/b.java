package c.a.s0.a.e0.h;

import android.annotation.SuppressLint;
import c.a.s0.a.k;
import c.a.s0.a.z2.q0;
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
    public static final boolean f5973h;

    /* renamed from: i  reason: collision with root package name */
    public static String f5974i;

    /* renamed from: j  reason: collision with root package name */
    public static String f5975j;
    public static String k;
    public static String l;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @SuppressLint({"BDOfflineUrl"})

    /* renamed from: b  reason: collision with root package name */
    public String f5976b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5977c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5978d;

    /* renamed from: e  reason: collision with root package name */
    public int f5979e;

    /* renamed from: f  reason: collision with root package name */
    public int f5980f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5981g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1188364406, "Lc/a/s0/a/e0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1188364406, "Lc/a/s0/a/e0/h/b;");
                return;
            }
        }
        f5973h = k.a;
        f5974i = "V8Master";
        f5975j = "page";
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
        this.a = String.valueOf(System.currentTimeMillis());
        this.f5976b = "http://chrome-devtools-frontend.appspot.com/serve_rev/@74dd8d5ea19a92d0e6092e59a0c8bd3a40877b71/inspector.html?ws=localhost:4000";
        this.f5977c = false;
        this.f5978d = true;
        this.f5979e = 0;
        this.f5980f = 0;
        this.f5981g = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.putOpt("title", f5974i);
                jSONObject.putOpt("type", f5975j);
                jSONObject.putOpt("url", k);
                jSONObject.putOpt("webSocketDebuggerUrl", l);
                jSONObject.putOpt("id", this.a);
                jSONObject.putOpt("devtoolsFrontendUrl", this.f5976b);
                jSONObject.putOpt("swanJsVersion", c.a.s0.a.q2.b.h(0));
                jSONObject.putOpt("appVersion", q0.D());
                jSONObject2.putOpt("attached", Boolean.valueOf(this.f5977c));
                jSONObject2.putOpt(SchemeCollecter.CLASSIFY_EMPTY, Boolean.valueOf(this.f5978d));
                jSONObject2.putOpt("screenX", Integer.valueOf(this.f5979e));
                jSONObject2.putOpt("screenY", Integer.valueOf(this.f5980f));
                jSONObject2.putOpt(TKBase.VISIBILITY_VISIBLE, Boolean.valueOf(this.f5981g));
                jSONObject.putOpt("description", jSONObject2.toString());
                jSONArray.put(jSONObject);
            } catch (JSONException unused) {
                boolean z = f5973h;
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }
}
