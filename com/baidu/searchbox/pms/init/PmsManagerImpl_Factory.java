package com.baidu.searchbox.pms.init;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PmsManagerImpl_Factory {
    public static /* synthetic */ Interceptable $ic;
    public static volatile PmsManagerImpl instance;
    public transient /* synthetic */ FieldHolder $fh;

    public PmsManagerImpl_Factory() {
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

    public static synchronized PmsManagerImpl get() {
        InterceptResult invokeV;
        PmsManagerImpl pmsManagerImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (PmsManagerImpl_Factory.class) {
                if (instance == null) {
                    instance = new PmsManagerImpl();
                }
                pmsManagerImpl = instance;
            }
            return pmsManagerImpl;
        }
        return (PmsManagerImpl) invokeV.objValue;
    }
}
