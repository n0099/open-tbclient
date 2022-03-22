package com.baidu.android.util;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class UniKV implements SharedPreferences {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String DEFAULT_SP_NAME = "default";
    public static final int MAX_STRING_LENGTH = 256;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences mInstance;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-413242721, "Lcom/baidu/android/util/UniKV;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-413242721, "Lcom/baidu/android/util/UniKV;");
        }
    }

    public UniKV() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mInstance = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
    }

    private void verifyAllLength(String str, Set<String> set) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, this, str, set) == null) || set == null) {
            return;
        }
        for (String str2 : set) {
            verifyLength(str, str2);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    private void verifyLength(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, this, str, str2) == null) && str2 != null && str2.length() > 256 && DEBUG) {
            throw new IllegalArgumentException(String.format("the value of %s is %d, over the limit of %d!", str, Integer.valueOf(str2.length()), 256));
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SharedPreferences sharedPreferences = this.mInstance;
            if (sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.contains(str);
        }
        return invokeL.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SharedPreferences sharedPreferences = this.mInstance;
            if (sharedPreferences == null) {
                return null;
            }
            return sharedPreferences.edit();
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SharedPreferences sharedPreferences = this.mInstance;
            if (sharedPreferences == null) {
                return null;
            }
            return sharedPreferences.getAll();
        }
        return (Map) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            SharedPreferences sharedPreferences = this.mInstance;
            return sharedPreferences == null ? z : sharedPreferences.getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048580, this, str, f2)) == null) {
            SharedPreferences sharedPreferences = this.mInstance;
            return sharedPreferences == null ? f2 : sharedPreferences.getFloat(str, f2);
        }
        return invokeLF.floatValue;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            SharedPreferences sharedPreferences = this.mInstance;
            return sharedPreferences == null ? i : sharedPreferences.getInt(str, i);
        }
        return invokeLI.intValue;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j)) == null) {
            SharedPreferences sharedPreferences = this.mInstance;
            return sharedPreferences == null ? j : sharedPreferences.getLong(str, j);
        }
        return invokeLJ.longValue;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            SharedPreferences sharedPreferences = this.mInstance;
            return sharedPreferences == null ? str2 : sharedPreferences.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, set)) == null) {
            SharedPreferences sharedPreferences = this.mInstance;
            return sharedPreferences == null ? set : sharedPreferences.getStringSet(str, set);
        }
        return (Set) invokeLL.objValue;
    }

    public void putBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, str, z) == null) || (sharedPreferences = this.mInstance) == null) {
            return;
        }
        sharedPreferences.edit().putBoolean(str, z).apply();
    }

    public void putFloat(String str, float f2) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048586, this, str, f2) == null) || (sharedPreferences = this.mInstance) == null) {
            return;
        }
        sharedPreferences.edit().putFloat(str, f2).apply();
    }

    public void putInt(String str, int i) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048587, this, str, i) == null) || (sharedPreferences = this.mInstance) == null) {
            return;
        }
        sharedPreferences.edit().putInt(str, i).apply();
    }

    public void putLong(String str, long j) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048588, this, str, j) == null) || (sharedPreferences = this.mInstance) == null) {
            return;
        }
        sharedPreferences.edit().putLong(str, j).apply();
    }

    public void putString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) || this.mInstance == null) {
            return;
        }
        verifyLength(str, str2);
        this.mInstance.edit().putString(str, str2).apply();
    }

    public void putStringSet(String str, Set<String> set) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, str, set) == null) || this.mInstance == null) {
            return;
        }
        verifyAllLength(str, set);
        this.mInstance.edit().putStringSet(str, set).apply();
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, onSharedPreferenceChangeListener) == null) || (sharedPreferences = this.mInstance) == null) {
            return;
        }
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void remove(String str) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || (sharedPreferences = this.mInstance) == null) {
            return;
        }
        sharedPreferences.edit().remove(str).apply();
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, onSharedPreferenceChangeListener) == null) || (sharedPreferences = this.mInstance) == null) {
            return;
        }
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UniKV(String str) {
        this(str, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public UniKV(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        if (!TextUtils.isEmpty(str) && !"default".equals(str)) {
            this.mInstance = KVStorageFactory.getSharedPreferences(str, i);
        } else {
            this.mInstance = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        }
    }

    public UniKV(SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sharedPreferences};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mInstance = sharedPreferences;
    }
}
