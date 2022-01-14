package c.a.r0.a.e0.h;

import android.annotation.SuppressLint;
import c.a.r0.a.k;
import c.a.r0.a.z2.q0;
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
    public static final boolean f5731h;

    /* renamed from: i  reason: collision with root package name */
    public static String f5732i;

    /* renamed from: j  reason: collision with root package name */
    public static String f5733j;
    public static String k;
    public static String l;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @SuppressLint({"BDOfflineUrl"})

    /* renamed from: b  reason: collision with root package name */
    public String f5734b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5735c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5736d;

    /* renamed from: e  reason: collision with root package name */
    public int f5737e;

    /* renamed from: f  reason: collision with root package name */
    public int f5738f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5739g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1317447125, "Lc/a/r0/a/e0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1317447125, "Lc/a/r0/a/e0/h/b;");
                return;
            }
        }
        f5731h = k.a;
        f5732i = "V8Master";
        f5733j = "page";
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
        this.f5734b = "http://chrome-devtools-frontend.appspot.com/serve_rev/@74dd8d5ea19a92d0e6092e59a0c8bd3a40877b71/inspector.html?ws=localhost:4000";
        this.f5735c = false;
        this.f5736d = true;
        this.f5737e = 0;
        this.f5738f = 0;
        this.f5739g = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.putOpt("title", f5732i);
                jSONObject.putOpt("type", f5733j);
                jSONObject.putOpt("url", k);
                jSONObject.putOpt("webSocketDebuggerUrl", l);
                jSONObject.putOpt("id", this.a);
                jSONObject.putOpt("devtoolsFrontendUrl", this.f5734b);
                jSONObject.putOpt("swanJsVersion", c.a.r0.a.q2.b.h(0));
                jSONObject.putOpt("appVersion", q0.D());
                jSONObject2.putOpt("attached", Boolean.valueOf(this.f5735c));
                jSONObject2.putOpt(SchemeCollecter.CLASSIFY_EMPTY, Boolean.valueOf(this.f5736d));
                jSONObject2.putOpt("screenX", Integer.valueOf(this.f5737e));
                jSONObject2.putOpt("screenY", Integer.valueOf(this.f5738f));
                jSONObject2.putOpt(TKBase.VISIBILITY_VISIBLE, Boolean.valueOf(this.f5739g));
                jSONObject.putOpt("description", jSONObject2.toString());
                jSONArray.put(jSONObject);
            } catch (JSONException unused) {
                boolean z = f5731h;
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }
}
