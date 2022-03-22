package com.baidu.searchbox.anr.impl;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ANRMonitor_Factory {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ANRMonitor instance;
    public transient /* synthetic */ FieldHolder $fh;

    public ANRMonitor_Factory() {
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

    public static synchronized ANRMonitor get() {
        InterceptResult invokeV;
        ANRMonitor aNRMonitor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (ANRMonitor_Factory.class) {
                if (instance == null) {
                    instance = new ANRMonitor();
                }
                aNRMonitor = instance;
            }
            return aNRMonitor;
        }
        return (ANRMonitor) invokeV.objValue;
    }
}
