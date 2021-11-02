package com.baidu.mobads.container.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BDSharedPreferences {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_PREFIX_LOCAL_PATH = "localPath_";
    public static final String KEY_PREFIX_TIME = "time_";
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences mSharedPreferences;

    public BDSharedPreferences(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSharedPreferences = context.getApplicationContext().getSharedPreferences(str, i2);
    }

    public boolean contains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.mSharedPreferences.contains(str) : invokeL.booleanValue;
    }

    public String getLocalPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            SharedPreferences sharedPreferences = this.mSharedPreferences;
            return sharedPreferences.getString(KEY_PREFIX_LOCAL_PATH + str, null);
        }
        return (String) invokeL.objValue;
    }

    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) ? this.mSharedPreferences.getLong(str, j) : invokeLJ.longValue;
    }

    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) ? this.mSharedPreferences.getString(str, str2) : (String) invokeLL.objValue;
    }

    public void putLong(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, str, j) == null) {
            SharedPreferences.Editor edit = this.mSharedPreferences.edit();
            edit.putLong(str, j);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }

    public void putString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            SharedPreferences.Editor edit = this.mSharedPreferences.edit();
            edit.putString(str, str2);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }

    public void saveFileInfo(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            SharedPreferences.Editor edit = this.mSharedPreferences.edit();
            edit.putString(KEY_PREFIX_LOCAL_PATH + str, str2);
            edit.putLong(KEY_PREFIX_TIME + str, j);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }
}
