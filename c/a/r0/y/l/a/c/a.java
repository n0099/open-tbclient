package c.a.r0.y.l.a.c;

import android.util.Log;
import c.a.r0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f12246g;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f12247b;

    /* renamed from: c  reason: collision with root package name */
    public int f12248c;

    /* renamed from: d  reason: collision with root package name */
    public int f12249d;

    /* renamed from: e  reason: collision with root package name */
    public int f12250e;

    /* renamed from: f  reason: collision with root package name */
    public int f12251f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1495040248, "Lc/a/r0/y/l/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1495040248, "Lc/a/r0/y/l/a/c/a;");
                return;
            }
        }
        f12246g = k.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("videoBitrate", this.a);
                jSONObject.put("audioBitrate", this.f12247b);
                jSONObject.put("videoFPS", this.f12248c);
                jSONObject.put("netSpeed", this.f12249d);
                jSONObject.put("videoWidth", this.f12250e);
                jSONObject.put("videoHeight", this.f12251f);
                jSONObject2.putOpt("info", jSONObject);
                return jSONObject2.toString();
            } catch (JSONException e2) {
                if (f12246g) {
                    String str = "toJSONObject failed: " + Log.getStackTraceString(e2);
                    return null;
                }
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
