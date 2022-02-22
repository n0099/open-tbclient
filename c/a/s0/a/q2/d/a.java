package c.a.s0.a.q2.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.k;
import c.a.s0.a.o2.g.h;
import c.a.s0.a.z2.l0;
import c.a.s0.w.d;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(928884281, "Lc/a/s0/a/q2/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(928884281, "Lc/a/s0/a/q2/d/a;");
                return;
            }
        }
        a = k.a;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            File c2 = c();
            if (c2.exists()) {
                d.j(c2);
            }
        }
    }

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? h.a().getLong("aiapps_cur_debug_ver_key", 0L) : invokeV.longValue;
    }

    public static File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new File(c.a.s0.a.f1.c.a.d().get(0).a, "/aiapps_debug_swan_core/") : (File) invokeV.objValue;
    }

    public static File d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            File c2 = c();
            if (!c2.exists()) {
                c2.mkdirs();
            }
            return new File(c2, "debugSwanCore.zip");
        }
        return (File) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            File file = new File(c().getPath(), "pkginfo.json");
            if (file.exists()) {
                JSONObject jSONObject = null;
                try {
                    jSONObject = new JSONObject(d.E(file));
                } catch (JSONException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
                if (jSONObject == null) {
                    return false;
                }
                String optString = jSONObject.optString("version_name");
                if (TextUtils.isEmpty(optString)) {
                    return true;
                }
                h.a().putLong("aiapps_cur_debug_ver_key", l0.b(optString));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
