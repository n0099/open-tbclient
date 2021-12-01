package com.baidu.common.config;

import android.text.TextUtils;
import c.a.m.b.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AppIdentityManager {
    public static /* synthetic */ Interceptable $ic;
    public static AppIdentityManager sAppIdentity;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAppName;

    public AppIdentityManager() {
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

    public static AppIdentityManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sAppIdentity == null) {
                synchronized (AppIdentityManager.class) {
                    if (sAppIdentity == null) {
                        sAppIdentity = new AppIdentityManager();
                    }
                }
            }
            return sAppIdentity;
        }
        return (AppIdentityManager) invokeV.objValue;
    }

    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.isEmpty(this.mAppName)) {
                return this.mAppName;
            }
            return a.a().getAppName();
        }
        return (String) invokeV.objValue;
    }

    public String getUserAgentIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String a = a.b().a();
            return TextUtils.isEmpty(a) ? getAppName() : a;
        }
        return (String) invokeV.objValue;
    }

    public void setAppName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.mAppName = str;
        }
    }
}
