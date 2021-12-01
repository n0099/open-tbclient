package com.baidu.searchbox.anr.impl;

import c.a.i0.a.b.b;
import c.a.i0.a.b.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.anr.ioc.IANRRegister_ANRRuntime_ListProvider;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class ANRRuntime {
    public static /* synthetic */ Interceptable $ic;
    public static ANRRuntime sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject
    public d<IANRRegister> mIANRMonitorList;

    public ANRRuntime() {
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
        initmIANRMonitorList();
    }

    public static ANRRuntime getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (ANRRuntime.class) {
                    if (sInstance == null) {
                        sInstance = new ANRRuntime();
                    }
                }
            }
            return sInstance;
        }
        return (ANRRuntime) invokeV.objValue;
    }

    public boolean enableANR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d<IANRRegister> dVar = this.mIANRMonitorList;
            if (dVar == null || dVar.getList() == null) {
                return false;
            }
            for (IANRRegister iANRRegister : this.mIANRMonitorList.getList()) {
                if (iANRRegister != null && iANRRegister.checkEnable()) {
                    AppConfig.isDebug();
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public d<IANRRegister> getIANRUploadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mIANRMonitorList : (d) invokeV.objValue;
    }

    public void initmIANRMonitorList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b b2 = b.b();
            this.mIANRMonitorList = b2;
            b2.a(new IANRRegister_ANRRuntime_ListProvider());
        }
    }
}
