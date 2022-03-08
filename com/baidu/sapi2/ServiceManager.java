package com.baidu.sapi2;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ServiceManager implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public static ServiceManager instance;
    public transient /* synthetic */ FieldHolder $fh;
    public ISAccountManager isAccountManager;

    public ServiceManager() {
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

    public static synchronized ServiceManager getInstance() {
        InterceptResult invokeV;
        ServiceManager serviceManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (ServiceManager.class) {
                if (instance == null) {
                    instance = new ServiceManager();
                }
                serviceManager = instance;
            }
            return serviceManager;
        }
        return (ServiceManager) invokeV.objValue;
    }

    public ISAccountManager getIsAccountManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isAccountManager : (ISAccountManager) invokeV.objValue;
    }

    public void setIsAccountManager(ISAccountManager iSAccountManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iSAccountManager) == null) {
            this.isAccountManager = iSAccountManager;
        }
    }
}
