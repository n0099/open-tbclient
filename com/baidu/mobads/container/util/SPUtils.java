package com.baidu.mobads.container.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
/* loaded from: classes3.dex */
public class SPUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_SP_NAME = "bd_sp_file";
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences.Editor editor;
    public SharedPreferences mSharedPreferences;

    public SPUtils(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(DEFAULT_SP_NAME, 0);
        this.mSharedPreferences = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    private void submit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                this.editor.apply();
            } else {
                this.editor.commit();
            }
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.editor.clear();
            if (Build.VERSION.SDK_INT >= 9) {
                this.editor.apply();
            } else {
                this.editor.commit();
            }
        }
    }

    public boolean contains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.mSharedPreferences.contains(str) : invokeL.booleanValue;
    }

    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) ? this.mSharedPreferences.getBoolean(str, z) : invokeLZ.booleanValue;
    }

    public float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048579, this, str, f2)) == null) ? this.mSharedPreferences.getFloat(str, f2) : invokeLF.floatValue;
    }

    public int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i2)) == null) ? this.mSharedPreferences.getInt(str, i2) : invokeLI.intValue;
    }

    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, str, j)) == null) ? this.mSharedPreferences.getLong(str, j) : invokeLJ.longValue;
    }

    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) ? this.mSharedPreferences.getString(str, str2) : (String) invokeLL.objValue;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, set)) == null) ? this.mSharedPreferences.getStringSet(str, set) : (Set) invokeLL.objValue;
    }

    public void putBoolean(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z) == null) {
            this.editor.putBoolean(str, z);
            submit();
        }
    }

    public void putFloat(String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048585, this, str, f2) == null) {
            this.editor.putFloat(str, Float.valueOf(f2).floatValue());
            submit();
        }
    }

    public void putInt(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, str, i2) == null) {
            this.editor.putInt(str, i2);
            submit();
        }
    }

    public void putLong(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, str, j) == null) {
            this.editor.putLong(str, Long.valueOf(j).longValue());
            submit();
        }
    }

    public void putString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            this.editor.putString(str, str2);
            submit();
        }
    }

    public void putStringSet(String str, Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, set) == null) {
            this.editor.putStringSet(str, set);
            submit();
        }
    }

    public void remove(String str) {
        SharedPreferences.Editor editor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (editor = this.editor) == null) {
            return;
        }
        editor.remove(str);
    }

    public SPUtils(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(str, 0);
        this.mSharedPreferences = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }
}
