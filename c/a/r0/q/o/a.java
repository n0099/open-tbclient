package c.a.r0.q.o;

import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.q.p.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            SharedPreferences a = h.a();
            return a.getLong("latest_update_time" + i2, 0L);
        }
        return invokeI.longValue;
    }

    public static long b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            SharedPreferences a = h.a();
            return a.getLong("max_age" + i2, 0L);
        }
        return invokeI.longValue;
    }

    public static boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            return (System.currentTimeMillis() - a(i2)) / 1000 > b(i2);
        }
        return invokeI.booleanValue;
    }

    public static void d(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            SharedPreferences.Editor edit = h.a().edit();
            edit.putLong("latest_update_time" + i2, j2).apply();
        }
    }

    public static void e(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (j2 <= 0 || j2 >= 259200) {
                j2 = 0;
            }
            h.a().edit().putLong("max_age" + i2, j2).apply();
        }
    }
}
