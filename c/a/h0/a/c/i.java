package c.a.h0.a.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public static SharedPreferences a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(215531917, "Lc/a/h0/a/c/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(215531917, "Lc/a/h0/a/c/i;");
        }
    }

    public static Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a.c0.e.a.b() : (Context) invokeV.objValue;
    }

    public static float b(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65538, null, str, f2)) == null) ? e().getFloat(str, f2) : invokeLF.floatValue;
    }

    public static int c(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i2)) == null) ? e().getInt(str, i2) : invokeLI.intValue;
    }

    public static long d(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, j2)) == null) ? e().getLong(str, j2) : invokeLJ.longValue;
    }

    public static SharedPreferences e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (a == null) {
                a = PreferenceManager.getDefaultSharedPreferences(a());
            }
            return a;
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public static String f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) ? e().getString(str, str2) : (String) invokeLL.objValue;
    }

    public static void g(String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65543, null, str, f2) == null) {
            SharedPreferences.Editor edit = e().edit();
            edit.putFloat(str, f2);
            edit.apply();
        }
    }

    public static void h(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, str, i2) == null) {
            SharedPreferences.Editor edit = e().edit();
            edit.putInt(str, i2);
            edit.apply();
        }
    }

    public static void i(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65545, null, str, j2) == null) {
            SharedPreferences.Editor edit = e().edit();
            edit.putLong(str, j2);
            edit.apply();
        }
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            SharedPreferences.Editor edit = e().edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }
}
