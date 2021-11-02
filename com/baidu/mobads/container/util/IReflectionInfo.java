package com.baidu.mobads.container.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class IReflectionInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APP_ACTIVITY = "com.baidu.mobads.sdk.api.AppActivity";
    public static final String APP_LP_ACTIVITY = "com.baidu.mobads.container.landingpage.App2Activity";
    public static final String APP_PRI_ACTIVITY = "com.baidu.mobads.container.landingpage.AppPriActivity";
    public static final String BD_SHELL_ACTIVITY = "com.baidu.mobads.sdk.api.BdShellActivity";
    public static final String DOWNLOAD_FILEPROVIDER = "com.baidu.mobads.sdk.api.BdFileProvider";
    public static final String DOWNLOAD_TASK_ACTIVITY = "com.baidu.mobads.container.landingpage.DownTaskActivity";
    public static final String REWARD_ACTIVITY = "com.baidu.mobads.sdk.api.MobRewardVideoActivity";
    public transient /* synthetic */ FieldHolder $fh;

    public IReflectionInfo() {
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
}
