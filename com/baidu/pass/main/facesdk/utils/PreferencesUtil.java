package com.baidu.pass.main.facesdk.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@SuppressLint({"NewApi"})
/* loaded from: classes9.dex */
public class PreferencesUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LEFT_MOUNT = "[";
    public static final String LENGTH_SUFFIX = "#LENGTH";
    public static final String RIGHT_MOUNT = "]";
    public static SharedPreferences mPrefs;
    public transient /* synthetic */ FieldHolder $fh;

    public PreferencesUtil() {
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

    public static boolean contains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? getPreferences().contains(str) : invokeL.booleanValue;
    }

    public static Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? getPreferences().getAll() : (Map) invokeV.objValue;
    }

    public static boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, str, z)) == null) ? getPreferences().getBoolean(str, z) : invokeLZ.booleanValue;
    }

    public static float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(InputDeviceCompat.SOURCE_TRACKBALL, null, str, f2)) == null) ? getPreferences().getFloat(str, f2) : invokeLF.floatValue;
    }

    public static int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, str, i2)) == null) ? getPreferences().getInt(str, i2) : invokeLI.intValue;
    }

    public static long getLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, str, j2)) == null) ? getPreferences().getLong(str, j2) : invokeLJ.longValue;
    }

    public static SharedPreferences getPreferences() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            SharedPreferences sharedPreferences = mPrefs;
            if (sharedPreferences != null) {
                return sharedPreferences;
            }
            throw new RuntimeException("please call iniPrefs(context) in the Application class onCreate.");
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public static String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) ? getPreferences().getString(str, str2) : (String) invokeLL.objValue;
    }

    @TargetApi(11)
    public static Set<String> getStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, set)) == null) {
            SharedPreferences preferences = getPreferences();
            if (Build.VERSION.SDK_INT >= 11) {
                return preferences.getStringSet(str, set);
            }
            if (preferences.contains(str + LENGTH_SUFFIX)) {
                set = new HashSet<>();
                int i2 = preferences.getInt(str + LENGTH_SUFFIX, -1);
                if (i2 >= 0) {
                    for (int i3 = 0; i3 < i2; i3++) {
                        preferences.getString(str + LEFT_MOUNT + i3 + RIGHT_MOUNT, null);
                    }
                }
            }
            return set;
        }
        return (Set) invokeLL.objValue;
    }

    public static void initPrefs(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, context) == null) && mPrefs == null) {
            String packageName = context.getPackageName();
            if (packageName != null) {
                mPrefs = context.getSharedPreferences(packageName, 4);
                return;
            }
            throw new NullPointerException("Prefs key may not be null");
        }
    }

    public static void putBoolean(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, str, z) == null) {
            SharedPreferences.Editor edit = getPreferences().edit();
            edit.putBoolean(str, z);
            if (Build.VERSION.SDK_INT < 9) {
                edit.commit();
            } else {
                edit.apply();
            }
        }
    }

    public static void putFloat(String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65548, null, str, f2) == null) {
            SharedPreferences.Editor edit = getPreferences().edit();
            edit.putFloat(str, f2);
            if (Build.VERSION.SDK_INT < 9) {
                edit.commit();
            } else {
                edit.apply();
            }
        }
    }

    public static void putInt(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, null, str, i2) == null) {
            SharedPreferences.Editor edit = getPreferences().edit();
            edit.putInt(str, i2);
            if (Build.VERSION.SDK_INT < 9) {
                edit.commit();
            } else {
                edit.apply();
            }
        }
    }

    public static void putLong(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65550, null, str, j2) == null) {
            SharedPreferences.Editor edit = getPreferences().edit();
            edit.putLong(str, j2);
            if (Build.VERSION.SDK_INT < 9) {
                edit.commit();
            } else {
                edit.apply();
            }
        }
    }

    public static void putString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, str2) == null) {
            SharedPreferences.Editor edit = getPreferences().edit();
            edit.putString(str, str2);
            if (Build.VERSION.SDK_INT < 9) {
                edit.commit();
            } else {
                edit.apply();
            }
        }
    }

    @TargetApi(11)
    public static void putStringSet(String str, Set<String> set) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, str, set) == null) {
            SharedPreferences.Editor edit = getPreferences().edit();
            if (Build.VERSION.SDK_INT >= 11) {
                edit.putStringSet(str, set);
            } else {
                SharedPreferences sharedPreferences = mPrefs;
                boolean contains = sharedPreferences.contains(str + LENGTH_SUFFIX);
                int i3 = 0;
                if (contains) {
                    SharedPreferences sharedPreferences2 = mPrefs;
                    i2 = sharedPreferences2.getInt(str + LENGTH_SUFFIX, -1);
                } else {
                    i2 = 0;
                }
                edit.putInt(str + LENGTH_SUFFIX, set.size());
                for (String str2 : set) {
                    edit.putString(str + LEFT_MOUNT + i3 + RIGHT_MOUNT, str2);
                    i3++;
                }
                while (i3 < i2) {
                    edit.remove(str + LEFT_MOUNT + i3 + RIGHT_MOUNT);
                    i3++;
                }
            }
            if (Build.VERSION.SDK_INT < 9) {
                edit.commit();
            } else {
                edit.apply();
            }
        }
    }

    @Deprecated
    public static void reInit(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, null, context) == null) || context == null) {
            return;
        }
        String packageName = context.getPackageName();
        if (packageName != null) {
            mPrefs = context.getSharedPreferences(packageName, 4);
            return;
        }
        throw new NullPointerException("Prefs key may not be null");
    }

    public static void remove(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, str) == null) {
            SharedPreferences preferences = getPreferences();
            SharedPreferences.Editor edit = preferences.edit();
            if (preferences.contains(str + LENGTH_SUFFIX)) {
                int i2 = preferences.getInt(str + LENGTH_SUFFIX, -1);
                if (i2 >= 0) {
                    edit.remove(str + LENGTH_SUFFIX);
                    for (int i3 = 0; i3 < i2; i3++) {
                        edit.remove(str + LEFT_MOUNT + i3 + RIGHT_MOUNT);
                    }
                }
            }
            edit.remove(str);
            if (Build.VERSION.SDK_INT < 9) {
                edit.commit();
            } else {
                edit.apply();
            }
        }
    }
}
