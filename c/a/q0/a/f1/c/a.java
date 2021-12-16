package c.a.q0.a.f1.c;

import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.d2.n.d;
import c.a.q0.a.z2.k0;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class a implements c.a.q0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static SwanAppConfigData a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
            if (file == null || !file.exists()) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            SwanAppConfigData b2 = d.b(file.getAbsolutePath());
            if (c.a.q0.a.f1.f.a.a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append("buildAppJsonConfig cost = ");
                sb.append(currentTimeMillis2 - currentTimeMillis);
                sb.append("ms ; current thread is main = ");
                sb.append(Looper.getMainLooper() == Looper.myLooper());
                sb.append(" ; path = ");
                sb.append(file);
                sb.toString();
            }
            return b2;
        }
        return (SwanAppConfigData) invokeL.objValue;
    }

    public static SwanAppConfigData b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            if (file == null || !file.exists()) {
                return null;
            }
            SwanAppConfigData swanAppConfigData = (SwanAppConfigData) b.c().b(file.getAbsolutePath());
            if (swanAppConfigData == null) {
                swanAppConfigData = c.a.q0.a.u1.l.g.a.e().j(file);
                if (swanAppConfigData == null) {
                    swanAppConfigData = a(file);
                }
                b.c().d(file.getAbsolutePath(), swanAppConfigData);
            } else {
                boolean z = c.a.q0.a.f1.f.a.a;
            }
            return swanAppConfigData;
        }
        return (SwanAppConfigData) invokeL.objValue;
    }

    public static Boolean c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            Boolean bool = (Boolean) b.c().b("getNightModeStateCache");
            if (bool == null) {
                return Boolean.valueOf(c.a.q0.a.c1.a.M().a());
            }
            if (z) {
                b.c().e("getNightModeStateCache");
            }
            return bool;
        }
        return (Boolean) invokeZ.objValue;
    }

    public static List<k0.a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            List<k0.a> list = (List) b.c().b("getStorageListCache");
            if (list == null) {
                List<k0.a> d2 = k0.d();
                b.c().d("getStorageListCache", d2);
                return d2;
            }
            return list;
        }
        return (List) invokeV.objValue;
    }

    public static void e(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bool) == null) {
            b.c().d("getNightModeStateCache", bool);
        }
    }
}
