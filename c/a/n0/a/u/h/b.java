package c.a.n0.a.u.h;

import android.annotation.SuppressLint;
import android.util.Log;
import c.a.n0.a.p2.q0;
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
    public static final boolean f6517h;
    public static String i;
    public static String j;
    public static String k;
    public static String l;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @SuppressLint({"BDOfflineUrl"})

    /* renamed from: b  reason: collision with root package name */
    public String f6518b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6519c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6520d;

    /* renamed from: e  reason: collision with root package name */
    public int f6521e;

    /* renamed from: f  reason: collision with root package name */
    public int f6522f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6523g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-708745041, "Lc/a/n0/a/u/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-708745041, "Lc/a/n0/a/u/h/b;");
                return;
            }
        }
        f6517h = c.a.n0.a.a.a;
        i = "V8Master";
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
        this.a = String.valueOf(System.currentTimeMillis());
        this.f6518b = "http://chrome-devtools-frontend.appspot.com/serve_rev/@74dd8d5ea19a92d0e6092e59a0c8bd3a40877b71/inspector.html?ws=localhost:4000";
        this.f6519c = false;
        this.f6520d = true;
        this.f6521e = 0;
        this.f6522f = 0;
        this.f6523g = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.putOpt("title", i);
                jSONObject.putOpt("type", j);
                jSONObject.putOpt("url", k);
                jSONObject.putOpt("webSocketDebuggerUrl", l);
                jSONObject.putOpt("id", this.a);
                jSONObject.putOpt("devtoolsFrontendUrl", this.f6518b);
                jSONObject.putOpt("swanJsVersion", c.a.n0.a.g2.b.h(0));
                jSONObject.putOpt("appVersion", q0.D());
                jSONObject2.putOpt("attached", Boolean.valueOf(this.f6519c));
                jSONObject2.putOpt(SchemeCollecter.CLASSIFY_EMPTY, Boolean.valueOf(this.f6520d));
                jSONObject2.putOpt("screenX", Integer.valueOf(this.f6521e));
                jSONObject2.putOpt("screenY", Integer.valueOf(this.f6522f));
                jSONObject2.putOpt(TKBase.VISIBILITY_VISIBLE, Boolean.valueOf(this.f6523g));
                jSONObject.putOpt("description", jSONObject2.toString());
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
                if (f6517h) {
                    Log.e("V8Module", "Build V8 module fail", e2);
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }
}
