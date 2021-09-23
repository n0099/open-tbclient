package c.a.p0.v.j.a.c;

import android.util.Log;
import c.a.p0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f12447g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12448a;

    /* renamed from: b  reason: collision with root package name */
    public int f12449b;

    /* renamed from: c  reason: collision with root package name */
    public int f12450c;

    /* renamed from: d  reason: collision with root package name */
    public int f12451d;

    /* renamed from: e  reason: collision with root package name */
    public int f12452e;

    /* renamed from: f  reason: collision with root package name */
    public int f12453f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-814233893, "Lc/a/p0/v/j/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-814233893, "Lc/a/p0/v/j/a/c/a;");
                return;
            }
        }
        f12447g = k.f7085a;
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
                jSONObject.put("videoBitrate", this.f12448a);
                jSONObject.put("audioBitrate", this.f12449b);
                jSONObject.put("videoFPS", this.f12450c);
                jSONObject.put("netSpeed", this.f12451d);
                jSONObject.put("videoWidth", this.f12452e);
                jSONObject.put("videoHeight", this.f12453f);
                jSONObject2.putOpt("info", jSONObject);
                return jSONObject2.toString();
            } catch (JSONException e2) {
                if (f12447g) {
                    String str = "toJSONObject failed: " + Log.getStackTraceString(e2);
                    return null;
                }
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
