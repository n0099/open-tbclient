package com.baidu.android.bdutil.cuid.sdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AppCuidManager {
    public static /* synthetic */ Interceptable $ic;
    public static AppCuidManager sAppCuidManager;
    public transient /* synthetic */ FieldHolder $fh;

    public AppCuidManager() {
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

    public static AppCuidManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sAppCuidManager == null) {
                synchronized (AppCuidManager.class) {
                    if (sAppCuidManager == null) {
                        sAppCuidManager = new AppCuidManager();
                    }
                }
            }
            return sAppCuidManager;
        }
        return (AppCuidManager) invokeV.objValue;
    }

    public String getCuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? AppCuidRuntime.getAppCuidManager().getCuid() : (String) invokeV.objValue;
    }

    public String getEnCuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? AppCuidRuntime.getAppCuidManager().getEnCuid() : (String) invokeV.objValue;
    }
}
