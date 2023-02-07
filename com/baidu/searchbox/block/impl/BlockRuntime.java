package com.baidu.searchbox.block.impl;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.block.ioc.IBlockRegister;
import com.baidu.searchbox.block.ioc.IBlockRegister_BlockRuntime_ListProvider;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.ak1;
import com.baidu.tieba.ck1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BlockRuntime {
    public static /* synthetic */ Interceptable $ic;
    public static volatile BlockRuntime sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject
    public ck1<IBlockRegister> mIBlockMonitorList;

    public void initmIBlockMonitorList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ak1 b = ak1.b();
            this.mIBlockMonitorList = b;
            b.a(new IBlockRegister_BlockRuntime_ListProvider());
        }
    }

    public BlockRuntime() {
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

    public ck1<IBlockRegister> getIBlockUploadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mIBlockMonitorList;
        }
        return (ck1) invokeV.objValue;
    }

    public boolean enableBlock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ck1<IBlockRegister> ck1Var = this.mIBlockMonitorList;
            if (ck1Var != null && ck1Var.getList() != null) {
                for (IBlockRegister iBlockRegister : this.mIBlockMonitorList.getList()) {
                    if (iBlockRegister != null && iBlockRegister.checkEnable()) {
                        if (AppConfig.isDebug()) {
                            Log.d(BlockMonitor.TAG, "enableBlock = true");
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
