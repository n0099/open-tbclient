package com.baidu.searchbox.looper.impl;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class LooperMonitor_Factory {
    public static /* synthetic */ Interceptable $ic;
    public static volatile LooperMonitor instance;
    public transient /* synthetic */ FieldHolder $fh;

    public LooperMonitor_Factory() {
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

    public static synchronized LooperMonitor get() {
        InterceptResult invokeV;
        LooperMonitor looperMonitor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (LooperMonitor_Factory.class) {
                if (instance == null) {
                    instance = new LooperMonitor();
                }
                looperMonitor = instance;
            }
            return looperMonitor;
        }
        return (LooperMonitor) invokeV.objValue;
    }
}
