package com.baidu.searchbox.pms.init;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Autowired
/* loaded from: classes2.dex */
public class PmsManager {
    public static /* synthetic */ Interceptable $ic;
    public static IPmsManager sPmsManager;
    public transient /* synthetic */ FieldHolder $fh;

    public PmsManager() {
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

    @Inject(force = false)
    public static IPmsManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sPmsManager == null) {
                sPmsManager = IPmsManager.EMPTY;
            }
            return PmsManagerImpl_Factory.get();
        }
        return (IPmsManager) invokeV.objValue;
    }

    public static void setPmsManager(IPmsManager iPmsManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, iPmsManager) == null) {
            sPmsManager = iPmsManager;
        }
    }
}
