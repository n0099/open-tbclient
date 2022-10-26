package com.baidu.searchbox.perfframe.impl;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.perfframe.ioc.IPerfFrameRegister_PerfFrameRuntime_ListProvider;
import com.baidu.tieba.se1;
import com.baidu.tieba.ue1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PerfFrameRuntime {
    public static /* synthetic */ Interceptable $ic;
    public static PerfFrameRuntime sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public ue1 mIPerfFrameMonitorList;

    public void initmIPerfFrameMonitorList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            se1 b = se1.b();
            this.mIPerfFrameMonitorList = b;
            b.a(new IPerfFrameRegister_PerfFrameRuntime_ListProvider());
        }
    }

    public PerfFrameRuntime() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        initmIPerfFrameMonitorList();
    }

    public static PerfFrameRuntime getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (PerfFrameRuntime.class) {
                    if (sInstance == null) {
                        sInstance = new PerfFrameRuntime();
                    }
                }
            }
            return sInstance;
        }
        return (PerfFrameRuntime) invokeV.objValue;
    }

    public ue1 getPerfFrameRegister() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mIPerfFrameMonitorList;
        }
        return (ue1) invokeV.objValue;
    }
}
