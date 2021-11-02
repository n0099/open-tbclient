package b.a.p0.n.j.i;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11206a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile g f11207b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-648425112, "Lb/a/p0/n/j/i/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-648425112, "Lb/a/p0/n/j/i/g;");
                return;
            }
        }
        f11206a = b.a.p0.n.c.f11048a;
    }

    public g() {
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

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f11207b == null) {
                synchronized (g.class) {
                    if (f11207b == null) {
                        f11207b = new g();
                    }
                }
            }
            return f11207b;
        }
        return (g) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.a.p0.n.c.b() == null ? "0" : b.a.p0.n.c.b().j().getString("local_debug_version", "0") : (String) invokeV.objValue;
    }

    public void c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (f11206a) {
            String str = WebGLImageLoader.DATA_URL + jSONObject;
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null || b.a.p0.n.c.b() == null) {
            return;
        }
        b.a.p0.n.c.b().j().putString("local_debug_version", optString);
        b.a.p0.n.c.b().j().putString("enable_local_debug_switch", optJSONObject.optString("enable_local_debug_switch"));
        b.a.p0.n.c.b().j().putString("error_url", optJSONObject.optString("error_url"));
        b.a.p0.n.c.b().j().putString("auth_white_list", optJSONObject.optString("auth_white_list"));
    }
}
