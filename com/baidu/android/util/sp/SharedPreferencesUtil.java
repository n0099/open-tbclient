package com.baidu.android.util.sp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
@Deprecated
/* loaded from: classes.dex */
public final class SharedPreferencesUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CARD_REMIND_GUIDANCE_SHARED_PREFERENCE = "card_remind_guidance_preference";
    public static final String DISCOVERY_HOME_SHARED_PREFERENCE = "discovery_home_share_preference";
    public static final String STRONG_CARD_SHARED_PREFRENCE = "strong_shared_prefrence";
    public static final String WEAK_CARD_SHARED_PREFRENCE = "weak_shared_prefrence";
    public static HashMap<String, SharedPreferencesUtil> mPrefrencesUtil;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences.Editor mEditor;
    public SharedPreferences mSharedPreferences;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-55548071, "Lcom/baidu/android/util/sp/SharedPreferencesUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-55548071, "Lcom/baidu/android/util/sp/SharedPreferencesUtil;");
                return;
            }
        }
        mPrefrencesUtil = new HashMap<>();
    }

    public void commitPreference() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mEditor.commit();
        }
    }

    public Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mSharedPreferences.getAll();
        }
        return (Map) invokeV.objValue;
    }

    @SuppressLint({"CommitPrefEdits"})
    public SharedPreferencesUtil(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, i);
        this.mSharedPreferences = sharedPreferences;
        this.mEditor = sharedPreferences.edit();
    }

    public static SharedPreferencesUtil getInstance(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, context, str, i)) == null) {
            SharedPreferencesUtil sharedPreferencesUtil = mPrefrencesUtil.get(str);
            if (sharedPreferencesUtil == null) {
                synchronized (SharedPreferencesUtil.class) {
                    sharedPreferencesUtil = mPrefrencesUtil.get(str);
                    if (sharedPreferencesUtil == null) {
                        sharedPreferencesUtil = new SharedPreferencesUtil(context, str, i);
                        mPrefrencesUtil.put(str, sharedPreferencesUtil);
                    }
                }
            }
            return sharedPreferencesUtil;
        }
        return (SharedPreferencesUtil) invokeLLI.objValue;
    }

    public static SharedPreferencesUtil getInstance(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            return getInstance(context, str, 0);
        }
        return (SharedPreferencesUtil) invokeLL.objValue;
    }

    public boolean getBooleanPreference(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            return this.mSharedPreferences.getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public float getFloatPreference(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048579, this, str, f)) == null) {
            return this.mSharedPreferences.getFloat(str, f);
        }
        return invokeLF.floatValue;
    }

    public int getIntPreference(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i)) == null) {
            return this.mSharedPreferences.getInt(str, i);
        }
        return invokeLI.intValue;
    }

    public long getLongPreference(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, str, j)) == null) {
            return this.mSharedPreferences.getLong(str, j);
        }
        return invokeLJ.longValue;
    }

    public String getStringPreference(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            return this.mSharedPreferences.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public void setBooleanPreference(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z) == null) {
            this.mEditor.putBoolean(str, z);
            this.mEditor.commit();
        }
    }

    public void setFloatPreference(String str, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048585, this, str, f) == null) {
            this.mEditor.putFloat(str, f);
            this.mEditor.commit();
        }
    }

    public void setIntPreference(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, str, i) == null) {
            this.mEditor.putInt(str, i);
            this.mEditor.commit();
        }
    }

    public void setLongPreference(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, str, j) == null) {
            this.mEditor.putLong(str, j);
            this.mEditor.commit();
        }
    }

    public void setStringPreference(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            this.mEditor.putString(str, str2);
            this.mEditor.commit();
        }
    }

    public void setStringWithoutCommit(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
            this.mEditor.putString(str, str2);
        }
    }

    public void removeStringPreference(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mEditor.remove(str);
            this.mEditor.commit();
        }
    }
}
