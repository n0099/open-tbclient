package com.baidu.searchbox.perfframe.impl;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.perfframe.ioc.IPerfFrameRegister;
import com.baidu.searchbox.perfframe.ioc.IPerfFrameRegister_PerfFrameRuntime_ListProvider;
import com.baidu.tieba.pf1;
import com.baidu.tieba.rf1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class PerfFrameRuntime {
    public static /* synthetic */ Interceptable $ic;
    public static PerfFrameRuntime sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject
    public rf1<IPerfFrameRegister> mIPerfFrameMonitorList;

    public void initmIPerfFrameMonitorList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            pf1 b = pf1.b();
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

    public rf1<IPerfFrameRegister> getPerfFrameRegister() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mIPerfFrameMonitorList;
        }
        return (rf1) invokeV.objValue;
    }
}
