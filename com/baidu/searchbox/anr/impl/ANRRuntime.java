package com.baidu.searchbox.anr.impl;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.anr.ioc.IANRRegister_ANRRuntime_ListProvider;
import com.baidu.searchbox.block.impl.BlockMonitor;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.lf1;
import com.baidu.tieba.nf1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ANRRuntime {
    public static /* synthetic */ Interceptable $ic;
    public static ANRRuntime sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject
    public nf1<IANRRegister> mIANRMonitorList;

    public void initmIANRMonitorList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            lf1 b = lf1.b();
            this.mIANRMonitorList = b;
            b.a(new IANRRegister_ANRRuntime_ListProvider());
        }
    }

    public ANRRuntime() {
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

    public nf1<IANRRegister> getIANRUploadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mIANRMonitorList;
        }
        return (nf1) invokeV.objValue;
    }

    public boolean enableANR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            nf1<IANRRegister> nf1Var = this.mIANRMonitorList;
            if (nf1Var != null && nf1Var.getList() != null) {
                for (IANRRegister iANRRegister : this.mIANRMonitorList.getList()) {
                    if (iANRRegister != null && iANRRegister.checkEnable()) {
                        if (AppConfig.isDebug()) {
                            Log.d(BlockMonitor.TAG, "enableANR = true");
                            return true;
                        }
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
