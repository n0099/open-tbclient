package com.baidu.minivideo.plugin.capture.utils;

import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.plugin.capture.Application;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
/* loaded from: classes2.dex */
public class PreferenceUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PreferenceUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void clearString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            try {
                commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().remove(str));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void commitEditor(SharedPreferences.Editor editor) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, editor) == null) || editor == null) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? PreferenceManager.getDefaultSharedPreferences(Application.get()).contains(str) : invokeL.booleanValue;
    }

    public static boolean getBoolean(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? getBoolean(str, false) : invokeL.booleanValue;
    }

    public static float getFloat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? getFloat(str, 0.0f) : invokeL.floatValue;
    }

    public static int getInt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? getInt(str, 0) : invokeL.intValue;
    }

    public static long getLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? getLong(str, 0L) : invokeL.longValue;
    }

    public static String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? getString(str, null) : (String) invokeL.objValue;
    }

    public static Set<String> getStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, set)) == null) {
            try {
                return PreferenceManager.getDefaultSharedPreferences(Application.get()).getStringSet(str, set);
            } catch (Exception e2) {
                e2.printStackTrace();
                return set;
            }
        }
        return (Set) invokeLL.objValue;
    }

    public static boolean hasGingerbread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? Build.VERSION.SDK_INT >= 9 : invokeV.booleanValue;
    }

    public static void putBoolean(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65552, null, str, z) == null) {
            try {
                commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putBoolean(str, z));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void putFloat(String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65553, null, str, f2) == null) {
            try {
                commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putFloat(str, f2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void putInt(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65554, null, str, i2) == null) {
            try {
                commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putInt(str, i2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void putLong(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65555, null, str, j) == null) {
            try {
                commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putLong(str, j));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void putString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, str2) == null) {
            try {
                commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putString(str, str2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void putStringSet(String str, Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, str, set) == null) {
            try {
                commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putStringSet(str, set));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, str, z)) == null) {
            try {
                return PreferenceManager.getDefaultSharedPreferences(Application.get()).getBoolean(str, z);
            } catch (Exception e2) {
                e2.printStackTrace();
                return z;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65543, null, str, f2)) == null) {
            try {
                return PreferenceManager.getDefaultSharedPreferences(Application.get()).getFloat(str, f2);
            } catch (Exception e2) {
                e2.printStackTrace();
                return f2;
            }
        }
        return invokeLF.floatValue;
    }

    public static int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, str, i2)) == null) {
            try {
                return PreferenceManager.getDefaultSharedPreferences(Application.get()).getInt(str, i2);
            } catch (Exception e2) {
                e2.printStackTrace();
                return i2;
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
            } catch (Exception e2) {
                e2.printStackTrace();
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
            } catch (Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }
}
