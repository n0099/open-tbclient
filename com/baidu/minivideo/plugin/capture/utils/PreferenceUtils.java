package com.baidu.minivideo.plugin.capture.utils;

import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.plugin.capture.Application;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
/* loaded from: classes3.dex */
public class PreferenceUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PreferenceUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean hasGingerbread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void clearString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            try {
                commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().remove(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void commitEditor(SharedPreferences.Editor editor) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, editor) != null) || editor == null) {
            return;
        }
        if (hasGingerbread()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public static boolean contains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return PreferenceManager.getDefaultSharedPreferences(Application.get()).contains(str);
        }
        return invokeL.booleanValue;
    }

    public static boolean getBoolean(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return getBoolean(str, false);
        }
        return invokeL.booleanValue;
    }

    public static float getFloat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            return getFloat(str, 0.0f);
        }
        return invokeL.floatValue;
    }

    public static int getInt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            return getInt(str, 0);
        }
        return invokeL.intValue;
    }

    public static long getLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            return getLong(str, 0L);
        }
        return invokeL.longValue;
    }

    public static String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            return getString(str, null);
        }
        return (String) invokeL.objValue;
    }

    public static boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, str, z)) == null) {
            try {
                return PreferenceManager.getDefaultSharedPreferences(Application.get()).getBoolean(str, z);
            } catch (Exception e) {
                e.printStackTrace();
                return z;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static float getFloat(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65543, null, str, f)) == null) {
            try {
                return PreferenceManager.getDefaultSharedPreferences(Application.get()).getFloat(str, f);
            } catch (Exception e) {
                e.printStackTrace();
                return f;
            }
        }
        return invokeLF.floatValue;
    }

    public static int getInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, str, i)) == null) {
            try {
                return PreferenceManager.getDefaultSharedPreferences(Application.get()).getInt(str, i);
            } catch (Exception e) {
                e.printStackTrace();
                return i;
            }
        }
        return invokeLI.intValue;
    }

    public static long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65547, null, str, j)) == null) {
            try {
                return PreferenceManager.getDefaultSharedPreferences(Application.get()).getLong(str, j);
            } catch (Exception e) {
                e.printStackTrace();
                return j;
            }
        }
        return invokeLJ.longValue;
    }

    public static String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, str2)) == null) {
            try {
                return PreferenceManager.getDefaultSharedPreferences(Application.get()).getString(str, str2);
            } catch (Exception e) {
                e.printStackTrace();
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static Set<String> getStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, set)) == null) {
            try {
                return PreferenceManager.getDefaultSharedPreferences(Application.get()).getStringSet(str, set);
            } catch (Exception e) {
                e.printStackTrace();
                return set;
            }
        }
        return (Set) invokeLL.objValue;
    }

    public static void putBoolean(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65552, null, str, z) == null) {
            try {
                commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putBoolean(str, z));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void putFloat(String str, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65553, null, str, f) == null) {
            try {
                commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putFloat(str, f));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void putInt(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65554, null, str, i) == null) {
            try {
                commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putInt(str, i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void putLong(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65555, null, str, j) == null) {
            try {
                commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putLong(str, j));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void putString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, str2) == null) {
            try {
                commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putString(str, str2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void putStringSet(String str, Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, str, set) == null) {
            try {
                commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putStringSet(str, set));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
