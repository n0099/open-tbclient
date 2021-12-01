package com.baidu.searchbox.perfframe.impl;

import c.a.i0.a.b.b;
import c.a.i0.a.b.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.perfframe.ioc.IPerfFrameRegister;
import com.baidu.searchbox.perfframe.ioc.IPerfFrameRegister_PerfFrameRuntime_ListProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PerfFrameRuntime {
    public static /* synthetic */ Interceptable $ic;
    public static PerfFrameRuntime sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject
    public d<IPerfFrameRegister> mIPerfFrameMonitorList;

    public PerfFrameRuntime() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public d<IPerfFrameRegister> getPerfFrameRegister() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIPerfFrameMonitorList : (d) invokeV.objValue;
    }

    public void initmIPerfFrameMonitorList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b b2 = b.b();
            this.mIPerfFrameMonitorList = b2;
            b2.a(new IPerfFrameRegister_PerfFrameRuntime_ListProvider());
        }
    }
}
