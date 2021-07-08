package com.baidu.mobads.container.download.activate;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class XSharedPreferences {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mAppliContext;
    public String mName;

    public XSharedPreferences(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAppliContext = context.getApplicationContext();
        this.mName = str;
    }

    private SharedPreferences getSP() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.mAppliContext.getSharedPreferences(this.mName, 0) : (SharedPreferences) invokeV.objValue;
    }

    private SharedPreferences.Editor getSPEditor() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? getSP().edit() : (SharedPreferences.Editor) invokeV.objValue;
    }

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                SharedPreferences.Editor sPEditor = getSPEditor();
                sPEditor.remove(str);
                if (Build.VERSION.SDK_INT >= 9) {
                    sPEditor.apply();
                } else {
                    sPEditor.commit();
                }
            } catch (Exception unused) {
            }
        }
    }

    public Long getLongValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                return Long.valueOf(getSP().getLong(str, 0L));
            } catch (Exception unused) {
                return 0L;
            }
        }
        return (Long) invokeL.objValue;
    }

    public String getValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return getSP().getString(str, "");
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(9)
    public void putLong(String str, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, l) == null) {
            try {
                SharedPreferences.Editor sPEditor = getSPEditor();
                sPEditor.putLong(str, l.longValue());
                if (Build.VERSION.SDK_INT >= 9) {
                    sPEditor.apply();
                } else {
                    sPEditor.commit();
                }
            } catch (Exception unused) {
            }
        }
    }

    @TargetApi(9)
    public void putString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            try {
                SharedPreferences.Editor sPEditor = getSPEditor();
                sPEditor.putString(str, str2);
                if (Build.VERSION.SDK_INT >= 9) {
                    sPEditor.apply();
                } else {
                    sPEditor.commit();
                }
            } catch (Exception unused) {
            }
        }
    }
}
