package com.baidu.android.util.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class PreferenceUtils {
    public static /* synthetic */ Interceptable $ic;
    public static SharedPreferences mPreference;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1585870104, "Lcom/baidu/android/util/sp/PreferenceUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1585870104, "Lcom/baidu/android/util/sp/PreferenceUtils;");
        }
    }

    public PreferenceUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return AppRuntime.getAppContext();
        }
        return (Context) invokeV.objValue;
    }

    public static SharedPreferences getPreference() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (mPreference == null) {
                mPreference = PreferenceManager.getDefaultSharedPreferences(getAppContext());
            }
            return mPreference;
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public static boolean containsKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return getPreference().contains(str);
        }
        return invokeL.booleanValue;
    }

    public static void registerOnChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, onSharedPreferenceChangeListener) == null) {
            getPreference().registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    public static void removeKey(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, str) == null) && getPreference().contains(str)) {
            SharedPreferences.Editor edit = getPreference().edit();
            edit.remove(str);
            edit.apply();
        }
    }

    public static void unregisterOnChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, onSharedPreferenceChangeListener) == null) {
            getPreference().unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    public static boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, z)) == null) {
            return getPreference().getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public static float getFloat(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65541, null, str, f)) == null) {
            return getPreference().getFloat(str, f);
        }
        return invokeLF.floatValue;
    }

    public static int getInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            return getPreference().getInt(str, i);
        }
        return invokeLI.intValue;
    }

    public static long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, str, j)) == null) {
            return getPreference().getLong(str, j);
        }
        return invokeLJ.longValue;
    }

    public static String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            return getPreference().getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public static void setBoolean(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65548, null, str, z) == null) {
            SharedPreferences.Editor edit = getPreference().edit();
            edit.putBoolean(str, z);
            edit.apply();
        }
    }

    public static void setFloat(String str, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65549, null, str, f) == null) {
            SharedPreferences.Editor edit = getPreference().edit();
            edit.putFloat(str, f);
            edit.apply();
        }
    }

    public static void setInt(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, str, i) == null) {
            SharedPreferences.Editor edit = getPreference().edit();
            edit.putInt(str, i);
            edit.apply();
        }
    }

    public static void setLong(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65551, null, str, j) == null) {
            SharedPreferences.Editor edit = getPreference().edit();
            edit.putLong(str, j);
            edit.apply();
        }
    }

    public static void setString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, str, str2) == null) {
            SharedPreferences.Editor edit = getPreference().edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    public static void setStringCommit(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, str, str2) == null) {
            SharedPreferences.Editor edit = getPreference().edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }
}
