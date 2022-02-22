package com.baidu.android.bdutil.cuid.api;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class IAppCuidManagerImpl_Factory {
    public static /* synthetic */ Interceptable $ic;
    public static volatile IAppCuidManagerImpl instance;
    public transient /* synthetic */ FieldHolder $fh;

    public IAppCuidManagerImpl_Factory() {
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

    public static synchronized IAppCuidManagerImpl get() {
        InterceptResult invokeV;
        IAppCuidManagerImpl iAppCuidManagerImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (IAppCuidManagerImpl_Factory.class) {
                if (instance == null) {
                    instance = new IAppCuidManagerImpl();
                }
                iAppCuidManagerImpl = instance;
            }
            return iAppCuidManagerImpl;
        }
        return (IAppCuidManagerImpl) invokeV.objValue;
    }
}
