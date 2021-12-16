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
/* loaded from: classes9.dex */
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

    @SuppressLint({"CommitPrefEdits"})
    public SharedPreferencesUtil(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, i2);
        this.mSharedPreferences = sharedPreferences;
        this.mEditor = sharedPreferences.edit();
    }

    public static SharedPreferencesUtil getInstance(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? getInstance(context, str, 0) : (SharedPreferencesUtil) invokeLL.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mSharedPreferences.getAll() : (Map) invokeV.objValue;
    }

    public boolean getBooleanPreference(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) ? this.mSharedPreferences.getBoolean(str, z) : invokeLZ.booleanValue;
    }

    public float getFloatPreference(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048579, this, str, f2)) == null) ? this.mSharedPreferences.getFloat(str, f2) : invokeLF.floatValue;
    }

    public int getIntPreference(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i2)) == null) ? this.mSharedPreferences.getInt(str, i2) : invokeLI.intValue;
    }

    public long getLongPreference(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, str, j2)) == null) ? this.mSharedPreferences.getLong(str, j2) : invokeLJ.longValue;
    }

    public String getStringPreference(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) ? this.mSharedPreferences.getString(str, str2) : (String) invokeLL.objValue;
    }

    public void removeStringPreference(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mEditor.remove(str);
            this.mEditor.commit();
        }
    }

    public void setBooleanPreference(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z) == null) {
            this.mEditor.putBoolean(str, z);
            this.mEditor.commit();
        }
    }

    public void setFloatPreference(String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048585, this, str, f2) == null) {
            this.mEditor.putFloat(str, f2);
            this.mEditor.commit();
        }
    }

    public void setIntPreference(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, str, i2) == null) {
            this.mEditor.putInt(str, i2);
            this.mEditor.commit();
        }
    }

    public void setLongPreference(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, str, j2) == null) {
            this.mEditor.putLong(str, j2);
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

    public static SharedPreferencesUtil getInstance(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, context, str, i2)) == null) {
            SharedPreferencesUtil sharedPreferencesUtil = mPrefrencesUtil.get(str);
            if (sharedPreferencesUtil == null) {
                synchronized (SharedPreferencesUtil.class) {
                    sharedPreferencesUtil = mPrefrencesUtil.get(str);
                    if (sharedPreferencesUtil == null) {
                        sharedPreferencesUtil = new SharedPreferencesUtil(context, str, i2);
                        mPrefrencesUtil.put(str, sharedPreferencesUtil);
                    }
                }
            }
            return sharedPreferencesUtil;
        }
        return (SharedPreferencesUtil) invokeLLI.objValue;
    }
}
