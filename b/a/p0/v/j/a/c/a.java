package b.a.p0.v.j.a.c;

import android.util.Log;
import b.a.p0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f11622g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f11623a;

    /* renamed from: b  reason: collision with root package name */
    public int f11624b;

    /* renamed from: c  reason: collision with root package name */
    public int f11625c;

    /* renamed from: d  reason: collision with root package name */
    public int f11626d;

    /* renamed from: e  reason: collision with root package name */
    public int f11627e;

    /* renamed from: f  reason: collision with root package name */
    public int f11628f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2127423706, "Lb/a/p0/v/j/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2127423706, "Lb/a/p0/v/j/a/c/a;");
                return;
            }
        }
        f11622g = k.f6397a;
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
                jSONObject.put("videoBitrate", this.f11623a);
                jSONObject.put("audioBitrate", this.f11624b);
                jSONObject.put("videoFPS", this.f11625c);
                jSONObject.put("netSpeed", this.f11626d);
                jSONObject.put("videoWidth", this.f11627e);
                jSONObject.put("videoHeight", this.f11628f);
                jSONObject2.putOpt("info", jSONObject);
                return jSONObject2.toString();
            } catch (JSONException e2) {
                if (f11622g) {
                    String str = "toJSONObject failed: " + Log.getStackTraceString(e2);
                    return null;
                }
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
