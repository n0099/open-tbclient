package com.baidu.searchbox.preload;

import com.baidu.searchbox.launch.ScheduleStrategy;
import com.baidu.searchbox.util.ChannelInitHelper;
import com.baidu.searchbox.util.VersionInitHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.LaunchUpApplicationSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class AppRuntimePreloader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AppRuntimePreloader() {
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

    public static void preload(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65537, null, z) == null) && z && LaunchUpApplicationSwitch.getIsOn()) {
            Thread thread = new Thread(new Runnable() { // from class: com.baidu.searchbox.preload.AppRuntimePreloader.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        VersionInitHelper.init();
                        TbadkCoreApplication.setClientId(TbadkCoreApplication.getInst().readClientId(TbadkCoreApplication.getInst().getContext()));
                        TbadkCoreApplication.getInst().initImei();
                        ChannelInitHelper.init();
                        ScheduleStrategy.getDeviceScore();
                    }
                }
            });
            thread.setPriority(10);
            thread.start();
        }
    }
}
