package com.baidu.searchbox.block.impl;

import c.a.l0.a.b.b;
import c.a.l0.a.b.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.block.ioc.IBlockRegister;
import com.baidu.searchbox.block.ioc.IBlockRegister_BlockRuntime_ListProvider;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class BlockRuntime {
    public static /* synthetic */ Interceptable $ic;
    public static volatile BlockRuntime sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject
    public d<IBlockRegister> mIBlockMonitorList;

    public BlockRuntime() {
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
        initmIBlockMonitorList();
    }

    public static BlockRuntime getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (BlockRuntime.class) {
                    if (sInstance == null) {
                        sInstance = new BlockRuntime();
                    }
                }
            }
            return sInstance;
        }
        return (BlockRuntime) invokeV.objValue;
    }

    public boolean enableBlock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d<IBlockRegister> dVar = this.mIBlockMonitorList;
            if (dVar == null || dVar.getList() == null) {
                return false;
            }
            for (IBlockRegister iBlockRegister : this.mIBlockMonitorList.getList()) {
                if (iBlockRegister != null && iBlockRegister.checkEnable()) {
                    AppConfig.isDebug();
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public d<IBlockRegister> getIBlockUploadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mIBlockMonitorList : (d) invokeV.objValue;
    }

    public void initmIBlockMonitorList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b b2 = b.b();
            this.mIBlockMonitorList = b2;
            b2.a(new IBlockRegister_BlockRuntime_ListProvider());
        }
    }
}
