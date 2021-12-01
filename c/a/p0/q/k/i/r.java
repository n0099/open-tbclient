package c.a.p0.q.k.i;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class r {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1821219898, "Lc/a/p0/q/k/i/r;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1821219898, "Lc/a/p0/q/k/i/r;");
        }
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            int i2 = 5;
            if (c() <= 0) {
                return 5;
            }
            String string = c.a.p0.q.c.b().i().getString("expire_time", "");
            if (TextUtils.isEmpty(string)) {
                return 5;
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                i2 = jSONObject.optInt("time", 5);
                JSONObject optJSONObject = jSONObject.optJSONObject("appkeys");
                if (optJSONObject == null) {
                    return i2;
                }
                int optInt = optJSONObject.optInt(str, -1);
                return optInt < 0 ? i2 : optInt;
            } catch (JSONException unused) {
                return i2;
            }
        }
        return invokeL.intValue;
    }

    public static long b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? TimeUnit.HOURS.toMillis(a(str)) : invokeL.longValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a < 0) {
                c.a.p0.q.c.b().F("swan_update_expired_time", 0);
                a = 0;
            }
            return a;
        }
        return invokeV.intValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a.p0.q.c.b().i().getString("expire_time_version", "0") : (String) invokeV.objValue;
    }

    public static void e(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        c.a.p0.q.c.b().i().putString("expire_time_version", optString);
        c.a.p0.q.c.b().i().putString("expire_time", optJSONObject.toString());
    }
}
