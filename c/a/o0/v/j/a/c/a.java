package c.a.o0.v.j.a.c;

import android.util.Log;
import c.a.o0.a.k;
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
    public static final boolean f12411g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12412a;

    /* renamed from: b  reason: collision with root package name */
    public int f12413b;

    /* renamed from: c  reason: collision with root package name */
    public int f12414c;

    /* renamed from: d  reason: collision with root package name */
    public int f12415d;

    /* renamed from: e  reason: collision with root package name */
    public int f12416e;

    /* renamed from: f  reason: collision with root package name */
    public int f12417f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-520830886, "Lc/a/o0/v/j/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-520830886, "Lc/a/o0/v/j/a/c/a;");
                return;
            }
        }
        f12411g = k.f7049a;
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
                jSONObject.put("videoBitrate", this.f12412a);
                jSONObject.put("audioBitrate", this.f12413b);
                jSONObject.put("videoFPS", this.f12414c);
                jSONObject.put("netSpeed", this.f12415d);
                jSONObject.put("videoWidth", this.f12416e);
                jSONObject.put("videoHeight", this.f12417f);
                jSONObject2.putOpt("info", jSONObject);
                return jSONObject2.toString();
            } catch (JSONException e2) {
                if (f12411g) {
                    String str = "toJSONObject failed: " + Log.getStackTraceString(e2);
                    return null;
                }
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
